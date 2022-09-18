package com.example.test.pojo.CacheData;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author songnx  缓存处理类
 */
public class CacheOperation {
    private static final Log log = LogFactory.getLog(CacheOperation.class);
    private static CacheOperation singleton = CacheOperation.getInstance();

    private final Hashtable cacheMap;//存放缓存数据
    CacheData cacheData ;
    private final ArrayList threadKeys;//处于线程更新中的key值列表

    public static CacheOperation getInstance() {
        if (singleton == null) {
            singleton = new CacheOperation();
        }
        return singleton;
    }

    private CacheOperation() {
        cacheMap = new Hashtable();
        threadKeys = new ArrayList();
    }
    /*+================================================*/

    /**
     * 添加数据缓存
     * 与方法getCacheData(String key, long intervalTime, int maxVisitCount)配合使用
     *
     * @param key
     * @param data
     */
    public  void addCacheData(String key, Object data) {
        if(data == null){
            data = new CacheData();
        }
        addCacheData(key, data, true);
    }

    private void addCacheData(String key, Object data, boolean check) {
        log.warn("缓存大小"+singleton.cacheMap.size());
        if (Runtime.getRuntime().freeMemory() < 50L * 1024L * 1024L) {//虚拟机内存小于10兆，则清除缓存
            log.warn("WEB缓存：内存不足，开始清空缓存！");
            removeAllCacheData();
            return;
        } else if (check && singleton.cacheMap.containsKey(key)) {
            log.warn("WEB缓存：key值= " + key + " 在缓存中重复, 本次不缓存！");
            return;
        }

        singleton.cacheMap.put(key, data);
    }

    public Object getKeyCache(String key){
        return  singleton.cacheMap.get(key);
    }
    /**
     * 取得缓存中的数据
     * 与方法addCacheData(String key, Object data)配合使用
     *
     * @param key
     * @param intervalTime  缓存的时间周期，(限制的时间)小于等于0时不限制
     * @param maxVisitCount 访问次数，（访问的次数）小于等于0时不限制
     * @return 返回null 控制请求
     */
    public Object getCacheData(String key, CacheData cacheData,long intervalTime, int maxVisitCount) throws InterruptedException {
        //cacheData = (CacheData) getInstance().getKeyCache(key);
        long Localmillis = System.currentTimeMillis();
        if (cacheData == null) {
            return null;
        }
        log.warn("次数："+cacheData.getCount()+">>最大次数maxVisitCount  "+maxVisitCount);
        if(intervalTime<0  || maxVisitCount <0){
        } else {
            long time_dis = Localmillis - cacheData.getTime();
            log.warn("时间差"+time_dis+" 周期"+intervalTime+" 第一次时间"+cacheData.getTime()+" "+"本地时间"+Localmillis);
            //超过时间，更新缓存
            if(time_dis > intervalTime){
                removeCacheData(key);
                //从新计时
                cacheData = new CacheData();
                addCacheData(key,cacheData);
            }else {

                //范围之内不控制
                if(maxVisitCount - cacheData.getCount()>0){
                } else {
                    log.warn(cacheData.getCount());
                    //次数过多
                    removeCacheData(key);
                    return null;
                }
                cacheData.addCount();
            }
        }
        TimeUnit.SECONDS.sleep((long) (Math.random() * 10)<2? (long) (Math.random() * 10) :1);
        return cacheData.getCount();
    }



    /*===============================================*/





    /**
     * 当缓存中数据失效时，用不给定的方法线程更新数据
     *
     * @param o             取得数据的对像(该方法是静态方法是不用实例，则传Class实列)
     * @param methodName    该对像中的方法
     * @param parameters    该方法的参数列表(参数列表中对像都要实现toString方法,若列表中某一参数为空则传它所属类的Class)
     * @param intervalTime  缓存的时间周期，小于等于0时不限制
     * @param maxVisitCount 访问累积次数，小于等于0时不限制
     * @return
     */
    public Object getCacheData(Object o, String methodName, Object[] parameters,
                               long intervalTime, int maxVisitCount) {
        Class oc = o instanceof Class ? (Class) o : o.getClass();
        StringBuffer key = new StringBuffer(oc.getName());//生成缓存key值
        key.append("-").append(methodName);
        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                if (parameters[i] instanceof Object[]) {
                    key.append("-").append(Arrays.toString((Object[]) parameters[i]));
                } else {
                    key.append("-").append(parameters[i]);
                }
            }
        }

        CacheData cacheData = (CacheData) cacheMap.get(key.toString());
        if (cacheData == null) {//等待加载并返回
            Object returnValue = invoke(o, methodName, parameters, key.toString());
            return returnValue instanceof Class ? null : returnValue;
        }
        if (intervalTime > 0 && (System.currentTimeMillis() - cacheData.getTime()) > intervalTime) {
            daemonInvoke(o, methodName, parameters, key.toString());//缓存时间超时,启动线程更新数据
        } else if (maxVisitCount > 0 && (maxVisitCount - cacheData.getCount()) <= 0) {//访问次数超出,启动线程更新数据
            daemonInvoke(o, methodName, parameters, key.toString());
        } else {
            cacheData.addCount();
        }
        return cacheData.getData();
    }

    /**
     * 递归调用给定方法更新缓存中数据据
     *
     * @param o
     * @param methodName
     * @param parameters
     * @param key
     * @return 若反射调用方法返回值为空则返回该值的类型
     */
    private Object invoke(Object o, String methodName, Object[] parameters, String key) {
        Object returnValue = null;
        try {
            Class[] pcs = null;
            if (parameters != null) {
                pcs = new Class[parameters.length];
                for (int i = 0; i < parameters.length; i++) {
                    if (parameters[i] instanceof MethodInfo) {//参数类型是MethodInfo则调用该方法的返回值做这参数
                        MethodInfo pmi = (MethodInfo) parameters[i];
                        Object pre = invoke(pmi.getO(), pmi.getMethodName(), pmi.getParameters(), null);
                        parameters[i] = pre;
                    }
                    if (parameters[i] instanceof Class) {
                        pcs[i] = (Class) parameters[i];
                        parameters[i] = null;
                    } else {
                        pcs[i] = parameters[i].getClass();
                    }
                }
            }
            Class oc = o instanceof Class ? (Class) o : o.getClass();
            //    Method m = oc.getDeclaredMethod(methodName, pcs);
            Method m = matchMethod(oc, methodName, pcs);
            returnValue = m.invoke(o, parameters);
            if (key != null && returnValue != null) {
                addCacheData(key, returnValue, false);
            }
            if (returnValue == null) {
                returnValue = m.getReturnType();
            }
        } catch (Exception e) {
            log.error("调用方法失败,methodName=" + methodName);
            if (key != null) {
                removeCacheData(key);
                log.error("更新缓存失败，缓存key=" + key);
            }
            e.printStackTrace();
        }
        return returnValue;
    }

    /**
     * 找不到完全匹配的方法时,对参数进行向父类匹配
     * 因为方法aa(java.util.List) 与 aa(java.util.ArrayList)不能自动匹配到
     *
     * @param oc
     * @param methodName
     * @param pcs
     * @return
     * @throws NoSuchMethodException
     * @throws NoSuchMethodException
     */
    private Method matchMethod(Class oc, String methodName, Class[] pcs)
            throws NoSuchMethodException, SecurityException {
        try {
            Method method = oc.getDeclaredMethod(methodName, pcs);
            return method;
        } catch (NoSuchMethodException e) {
            Method[] ms = oc.getDeclaredMethods();
            aa:
            for (int i = 0; i < ms.length; i++) {
                if (ms[i].getName().equals(methodName)) {
                    Class[] pts = ms[i].getParameterTypes();
                    if (pts.length == pcs.length) {
                        for (int j = 0; j < pts.length; j++) {
                            if (!pts[j].isAssignableFrom(pcs[j])) {
                                break aa;
                            }
                        }
                        return ms[i];
                    }
                }
            }
            throw new NoSuchMethodException();
        }
    }

    /**
     * 新启线程后台调用给定方法更新缓存中数据据
     *
     * @param o
     * @param methodName
     * @param parameters
     * @param key
     */
    private void daemonInvoke(Object o, String methodName, Object[] parameters, String key) {
        System.out.println("methodName"+methodName);
        if (!threadKeys.contains(key)) {
            InvokeThread t = new InvokeThread(o, methodName, parameters, key);
            t.start();
        }
    }

    /**
     * 移除缓存中的数据
     *
     * @param key
     */
    public void removeCacheData(String key) {
        cacheMap.remove(key);
    }

    /**
     * 移除所有缓存中的数据
     */
    public void removeAllCacheData() {
        cacheMap.clear();
    }

    public class InvokeThread extends Thread {
        private Object o;
        private String methodName;
        private Object[] parameters;
        private String key;

        public InvokeThread(){

        }
        public InvokeThread(Object o, String methodName, Object[] parameters, String key) {
            this.o = o;
            this.methodName = methodName;
            this.parameters = parameters;
            this.key = key;
        }

        public  void run() {
            threadKeys.add(key);
            invoke(o, methodName, parameters, key);
            threadKeys.remove(key);
        }

        public String toString() {
            StringBuffer sb = new StringBuffer("************************ ");
            sb.append("正在更新的缓存数据： ");
            for (int i = 0; i < threadKeys.size(); i++) {
                sb.append(threadKeys.get(i)).append(" ");
            }
            sb.append("当前缓存大小：").append(cacheMap.size()).append(" ");
            sb.append("************************");
            return sb.toString();
        }
    }
}
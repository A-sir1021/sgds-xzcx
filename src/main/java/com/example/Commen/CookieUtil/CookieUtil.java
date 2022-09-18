package com.example.Commen.CookieUtil;


import com.example.Commen.Constant.Constant;
import com.example.Commen.Util.DateUtil;
import com.example.Commen.Util.FastJsonUtil;
import com.example.test.controller.Error.SellerAuthorizeException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {
    static Logger log = LoggerFactory.getLogger(CookieUtil.class);


    /**
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void set(HttpServletResponse response,
                           HttpServletRequest request,
                           String name,
                           String value,
                           int maxAge) throws Exception {
        String encode = "";
        Cookie cookie = null;
        try {
             encode = URLEncoder.encode(value, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //根据字段来赋值
        if(StringUtils.equalsAny("role",name)){
            cookie = new Cookie(name, value);
        } else {
            cookie = new Cookie(name, encode);

        }
        //时间
        if (Constant.TOKEN_ROLE_TIME.equals(name)) {
            String time = DateUtil.timeAddMess(maxAge);
            cookie = new Cookie(name, time);
        } else {
        }
        log.warn("setcookie:"+cookie.getName()+">>>"+cookie.getValue());
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);

        request.setAttribute("role", cookie);
        response.setCharacterEncoding("UTF-8");
        response.setLocale(new java.util.Locale("zh", "CN"));
        response.addCookie(cookie);
    }

    public static void setJsonValue(HttpServletResponse response,
                                    HttpServletRequest request,
                                    String name,
                                    Object obj,
                                    int maxAge) throws Exception {
        String value = "";
        value = obj ==null? "" : FastJsonUtil.beanToJson(obj);
        set(response,request,name,value,maxAge);
        return ;
    }

    /**
     * 获取cookie
     *
     * @param request
     * @param name
     * @return   获取key的cookie
     */
    public static Cookie getCookie(HttpServletRequest request,
                             String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);

        if (cookieMap.containsKey(name)) {
            return cookieMap.get(name);
        } else {
            return null;
        }
    }

    /**
     * 获取cookie
     *
     * @param request
     * @param name
     * @return  获取 key的value
     */
    private static String getJsonValue(HttpServletRequest request,
                                  String name) throws Exception {
        Cookie cookie = getCookie(request, name);
        String value = cookie.getValue();
        if (value != null) {
            String decode = FastJsonUtil.decodeStr(value);
            return decode;
        } else {
            return null;
        }
    }


    /**
     * @desc  通过name，取字段，转化为bean
     * @param request
     * @param name
     * @param tClass
     * @param <T>
     * @return   jsonToBean
     */
    public static <T> T JsonPara(HttpServletRequest request, String name, Class<T> tClass) throws Exception {
        String value = getJsonValue(request, name);
        return value == null ? (T) "" : JsonValue(value, tClass);
    }


    /**
     * @param jsonstr 对象字符串
     * @param tClass  对象的类
     * @param <T>
     * @return jsonToBean
     */
    public static <T> T JsonValue(String jsonstr, Class<T> tClass) {
        T t = null;
        try {
            String decodeStr = FastJsonUtil.decodeStr(jsonstr);
            t = FastJsonUtil.jsonToBean(decodeStr, tClass);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            t=(T) "";
        }
        return t;
    }

    /**
     * 将Cookie封装Map
     *
     * @param request
     * @return
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    /**
     * 判断过期
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static boolean ExpiCookie(HttpServletRequest request, String key) throws Exception {
        String jsonValue = CookieUtil.getJsonValue(request, key);
        log.info("本地 "+ Long.parseLong(DateUtil.getDateTime_ymdhms()) +"   "
        +Long.parseLong(jsonValue)  +"  "+(Long.parseLong(DateUtil.getDateTime_ymdhms()) -
                Long.parseLong(jsonValue)));
        if (Long.parseLong(DateUtil.getDateTime_ymdhms()) >
                Long.parseLong(jsonValue)) {
            return false;
        } else {
        }
        return true;
    }

    /**
     * cookie key
     *
     * @param request
     * @param args
     */
    public static void delCookie(HttpServletRequest request,HttpServletResponse response, String... args) {
        log.warn("删除cookie"+args);
        for (String arg : args) {
            request.removeAttribute(arg);
            Cookie cookie = new Cookie(arg, "");
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }

    /**
     * 参数默认
     * @param request
     * @param response
     */
    public static void delCookieArgs(HttpServletRequest request,HttpServletResponse response){
        delCookie(request,response,Constant.TOKEN_ROLE,Constant.TOKEN_ROLE_AUTH,
                Constant.TOKEN_ROLE_BEAN,Constant.TOKEN_ROLE_Phone,Constant.TOKEN_ROLE_TIME);
    }
}

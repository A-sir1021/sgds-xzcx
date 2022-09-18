package com.example.test.pojo.CacheData;

import java.util.Arrays;

/**
 * 些类存放方法的主调对像,名称及参数数组
 * @author zsy
 *
 */
public class MethodInfo {
    private Object o;
    private String methodName;
    private Object[] parameters;
    public MethodInfo(Object o, String methodName,Object[] parameters) {
        this.o = o;
        this.methodName = methodName;
        this.parameters = parameters;
    }
    public String getMethodName() {
        return methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    public Object getO() {
        return o;
    }
    public void setO(Object o) {
        this.o = o;
    }
    public Object[] getParameters() {
        return parameters;
    }
    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public String toString() {
        StringBuffer str = new StringBuffer(methodName);
        if (parameters != null) {
            str.append("(");
            for (int i = 0; i < parameters.length; i++) {
                if (parameters[i] instanceof Object[]) {
                    str.append(Arrays.toString((Object[])parameters[i])).append(",");
                } else {
                    str.append(parameters[i]).append(",");
                }
            }
            str.append(")");
        }
        return str.toString();
    }
}

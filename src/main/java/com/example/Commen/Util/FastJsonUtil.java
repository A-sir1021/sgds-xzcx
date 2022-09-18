package com.example.Commen.Util;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public class FastJsonUtil {

    public static String beanToJson(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static <T> T jsonToBean(String jsonStr, Class<T> objClass) {
        T t = null;
        try {
            t = JSON.parseObject(jsonStr, objClass);
        } catch (Exception e){
            return (T) "";
        }
        return t;

    }

    /**
     * 解析 数组类型
     * @param jsonStr
     * @param objClass
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToArray(String jsonStr, Class<T> objClass){
        List<T> ts = JSON.parseArray(jsonStr, objClass);

        return ts;
    }

    public static String decodeStr(String str) throws Exception {
        return URLDecoder.decode(str,"utf-8");
    }
}


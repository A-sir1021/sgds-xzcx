package com.example.Commen.Util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public final  class StrUtils {
    //生成指定长度的字母和数字的随机组合字符串
    static final String newString3 = RandomStringUtils.randomAlphanumeric(6);

    public static String getRandomString2(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(3);
            long result = 0;
            switch (number) {
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append((char) result);
                    break;
                case 1:
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append((char) result);
                    break;
                case 2:
                    sb.append(new Random().nextInt(10));
                    break;
            }

        }
        System.out.println(sb);
        return sb.toString();
    }

    /**
     * 字符串转数组
     * @param set
     * @return
     */
    public static List<Integer> StringSetToIntegerList(Set<String> set) {
        List<Integer> list = new ArrayList<>();
        for (String s : set) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }

    public static String converToString(){
        return "";
    }



}

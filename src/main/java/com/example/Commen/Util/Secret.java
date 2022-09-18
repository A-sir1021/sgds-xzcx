package com.example.Commen.Util;

import com.sun.jmx.snmp.Timestamp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public  class Secret {

    // MD5加码。32位
    public static String Pwd_MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];

        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString();
    }

    // 可逆的加密算法
    private static String KL(String inStr) {
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

    // 加密后解密
    private static String JM(String inStr) {
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String k = new String(a);
        return k;
    }

    public static String md5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    public static String createRandomCode() {
        return new Date().getTime() + UUID.randomUUID().toString().replace("-", "");
    }


    //密码解密
    public static String pwd_JM(String str){
        return JM(str);
    }

    public static String encodePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    // 测试主函数
    public static void main(String[] args) throws Exception {
        String s = "sa";
        System.out.println("原始：" + s);
        System.out.println("MD5后：" + Pwd_MD5(s));
        System.out.println("MD5后再加密：" + KL(Pwd_MD5(s)));
        System.out.println("解密为MD5后的：" + JM(KL(Pwd_MD5(s))));

        String time = DateUtil.getDateTime_ymd();
        System.out.println(time);

    }
}

package com.sgxrmyy.util;

/**
 * 安全工具类
 * @author 袁明 on 2017/2/13.
 */
public class SecurityUtils {

    public enum Type {
        ENCRYPT,//加密
        DECRYPT;//解密
    }

    /**
     * 天健用户登陆密码加密解密
     * @param password  需要加密或解密的字符串
     * @param type  加密或解密
     * @return  经过加密或解密后的字符串
     */
    public static String password(String password, Type type) {

        if (password == null) return "";
        if (type != Type.DECRYPT && type != Type.ENCRYPT) return "";

        String temp = "";
        String tmp;
        char k;

        password = password.toUpperCase();
        for (int i = 1; i <= password.length(); i++) {

            tmp = password.substring(i - 1);
            k = tmp.charAt(0);
            if (type == Type.ENCRYPT) {
                if (i % 2 == 0) {
                    k = (char) (k + i - 32);
                } else {
                    k = (char) (k - i + 8);
                }
            }
            if (type == Type.DECRYPT) {
                if (i % 2 == 0) {
                    k = (char) (k - i + 32);
                } else {
                    k = (char) (k + i - 8);
                }
            }
            temp = temp + k;
        }
//        System.out.println(temp);
        return temp;
    }
}

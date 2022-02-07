package com.xuzihan.seckill.util;


import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author ZihanXu
 * @version 1.0
 */
public class MD5Util {

    public static final String SALT = "password";

    public static String md5(String str){
        return DigestUtils.md5Hex(str);
    }

    public static String inputToFormPassWord(String inputPassword){
        String password = SALT.charAt(0)+SALT.charAt(2)+inputPassword+SALT.charAt(4)+SALT.charAt(6);
        return md5(password);
    }

    public static String formToDBPassword(String formPassword , String salt){
        String password = salt.charAt(0)+formPassword+salt.charAt(1);
        return md5(password);
    }

    public static String inputToDBPassword(String inputPassword , String salt){
        String formPassword = inputToFormPassWord(inputPassword);
        String DBPassword = formToDBPassword(formPassword , salt);
        return DBPassword;
    }

}

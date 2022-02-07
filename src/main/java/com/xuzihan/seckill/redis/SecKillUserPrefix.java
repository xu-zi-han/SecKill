package com.xuzihan.seckill.redis;

/**
 * @author ZihanXu
 * @version 1.0
 */
public class SecKillUserPrefix extends BasePrefix{

    private static final int EXPIRE_SECONDS = 24 * 3600 * 2;
    private static final String TOKEN = "token";

    public SecKillUserPrefix(String prefix){
        super(prefix);
    }
    public SecKillUserPrefix(String prefix , int expireSeconds){
        super(prefix , expireSeconds);
    }
    public static SecKillUserPrefix getByToken = new SecKillUserPrefix(TOKEN , EXPIRE_SECONDS);
}

package com.xuzihan.seckill.redis;


/**
 * @author ZihanXu
 * @version 1.0
 */
public abstract class BasePrefix implements KeyPrefix{
    private int expireSeconds;
    private String keyPrefix;

    public BasePrefix(String keyPrefix){
        this.expireSeconds = 0;
        this.keyPrefix = keyPrefix;
    }

    public BasePrefix(String prefix , int expireSeconds){
        this.keyPrefix = prefix;
        this.expireSeconds = expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className+":"+keyPrefix;
    }

    @Override
    public int getExpireSecond() {
        return expireSeconds;
    }
}

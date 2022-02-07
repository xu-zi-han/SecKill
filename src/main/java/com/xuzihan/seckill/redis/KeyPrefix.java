package com.xuzihan.seckill.redis;

/**
 * @author ZihanXu
 * @version 1.0
 */
public interface KeyPrefix {

    String getPrefix();

    int getExpireSecond();
}

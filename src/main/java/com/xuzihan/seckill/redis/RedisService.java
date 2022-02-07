package com.xuzihan.seckill.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author ZihanXu
 * @version 1.0
 */

@Service
public class RedisService {
    public <T> void redisSet(KeyPrefix prefix ,String key , T value){
        Jedis jedis = null;
        JedisPool jedisPool = new JedisPool("localhost" , 6379);
        jedis = jedisPool.getResource();
        String realKey = prefix.getPrefix() + key;
        String realValue = beanToString(value);
        jedis.set(realKey , realValue);
    }
    public <T> T redisGet(KeyPrefix prefix ,String key , Class<T> clazz){
        Jedis jedis = null;
        JedisPool jedisPool = new JedisPool("localhost" , 6379);
        jedis = jedisPool.getResource();
        String realKey = prefix.getPrefix() + key;
        String s = jedis.get(realKey);
        T realValue = stringToBean(s , clazz);
        System.out.println("Get key from redis :"+s);
        return realValue;
    }
    public <T> String beanToString(T value){
        Class<?> clazz = value.getClass();
        if(clazz == Integer.class){
            return ""+value;
        }else if(clazz == String.class){
            return (String)value;
        }else if(clazz == Long.class){
            return ""+value;
        }else{
            return JSON.toJSONString(value);
        }
    }
    public <T> T stringToBean(String value , Class<T> clazz){
        if(clazz == Integer.class){
            return (T)value;
        }else if(clazz == String.class){
            return (T)value;
        }else if(clazz == Long.class){
            return (T)value;
        }else{
            return JSON.toJavaObject(JSON.parseObject(value),clazz);
        }
    }
}

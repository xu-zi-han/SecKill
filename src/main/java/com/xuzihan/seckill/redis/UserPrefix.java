package com.xuzihan.seckill.redis;

/**
 * @author ZihanXu
 * @version 1.0
 */
public class UserPrefix extends BasePrefix{
    public static UserPrefix getById = new UserPrefix("id");
    public static UserPrefix getByName = new UserPrefix("name");
    public UserPrefix(String prefix){
        super(prefix);
    }
}

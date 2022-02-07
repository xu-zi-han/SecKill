package com.xuzihan.seckill.util;

import java.util.UUID;

/**
 * @author ZihanXu
 * @version 1.0
 */
public class UUIDUtil {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}

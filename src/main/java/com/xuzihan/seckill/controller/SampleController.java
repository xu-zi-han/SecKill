package com.xuzihan.seckill.controller;

import com.xuzihan.seckill.domain.User;
import com.xuzihan.seckill.redis.RedisService;
import com.xuzihan.seckill.redis.UserPrefix;
import com.xuzihan.seckill.result.Result;
import com.xuzihan.seckill.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZihanXu
 * @version 1.0
 */
@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    SampleService sampleService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/testUser")
    @ResponseBody
    public Result<User> testUser(){
        int id = 1;
        User user = sampleService.serachByIdService(id);
        return new Result<User>(500000,"success",user);
    }

    @RequestMapping("/testRedisSet")
    @ResponseBody
    public String testRedisSet(){
        redisService.redisSet(UserPrefix.getById,"sample" , "KeySample");
        return "success";
    }

    @RequestMapping("/testRedisGet")
    @ResponseBody
    public Result<String> testRedisGet(){
        String s = redisService.redisGet(UserPrefix.getById,"sample",String.class);
        return new Result<String>(500000,"suceess",s);
    }
}

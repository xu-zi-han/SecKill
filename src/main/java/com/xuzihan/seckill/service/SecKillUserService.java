package com.xuzihan.seckill.service;

import com.xuzihan.seckill.dao.SecKillUserDao;
import com.xuzihan.seckill.domain.SecKillUser;
import com.xuzihan.seckill.exception.GlobalException;
import com.xuzihan.seckill.redis.RedisService;
import com.xuzihan.seckill.redis.SecKillUserPrefix;
import com.xuzihan.seckill.result.CodeMsg;
import com.xuzihan.seckill.util.MD5Util;
import com.xuzihan.seckill.util.UUIDUtil;
import com.xuzihan.seckill.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ZihanXu
 * @version 1.0
 */

@Service
public class SecKillUserService {

    @Autowired
    SecKillUserDao secKillUserDao;

    @Autowired
    RedisService redisService;

    public SecKillUser getById(long id){
        return secKillUserDao.getById(id);
    }

    public SecKillUser getByToken(HttpServletResponse httpServletResponse , String token) {
        if(token == null){
            return null;
        }
        SecKillUser secKillUser = redisService.redisGet(SecKillUserPrefix.getByToken, token, SecKillUser.class);
        if(secKillUser != null){
            addCookie(httpServletResponse , secKillUser);
        }
        return secKillUser;
    }

    public void login(HttpServletResponse httpServletResponse,LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        System.out.println("userid:"+mobile);
        SecKillUser user = secKillUserDao.getById(Long.parseLong(mobile));
        System.out.println("start");
        if(user == null){
            System.out.println("user not find");
            throw new GlobalException(CodeMsg.USER_NOT_EXIST);
        }
        System.out.println("user find");
        //MD5Password need to be used
        String MD5Password = MD5Util.formToDBPassword(password , user.getSalt());
        if(! "123456".equals(user.getPassword())){
            System.out.println("login failed");
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        System.out.println("login success");
        addCookie(httpServletResponse , user);
    }
    public void addCookie(HttpServletResponse httpServletResponse , SecKillUser user){
        String token = UUIDUtil.uuid();
        redisService.redisSet(SecKillUserPrefix.getByToken,token,user);
        Cookie cookie = new Cookie("token",token);
        cookie.setMaxAge(SecKillUserPrefix.getByToken.getExpireSecond());
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
    }
}

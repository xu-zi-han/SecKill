package com.xuzihan.seckill.controller;

import com.xuzihan.seckill.result.Result;
import com.xuzihan.seckill.service.SecKillUserService;
import com.xuzihan.seckill.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ZihanXu
 * @version 1.0
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    SecKillUserService secKillUserService;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse httpServletResponse , LoginVo loginVo){
        secKillUserService.login(httpServletResponse , loginVo);
        return Result.success(true);
    }
}

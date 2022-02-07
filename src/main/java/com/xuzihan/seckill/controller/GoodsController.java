package com.xuzihan.seckill.controller;

import com.xuzihan.seckill.domain.SecKillUser;
import com.xuzihan.seckill.redis.RedisService;
import com.xuzihan.seckill.service.GoodsService;
import com.xuzihan.seckill.service.SecKillUserService;
import com.xuzihan.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author ZihanXu
 * @version 1.0
 */

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    SecKillUserService secKillUserService;

    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

//    @RequestMapping("/to_list")
//    public String to_list(HttpServletResponse httpServletResponse ,
//                          @CookieValue(value = "token" , required = false) String cookieToken ,
//                          @RequestParam(value = "token" , required = false) String paramToken){
//        if(cookieToken == null && paramToken == null){
//            return "login";
//        }
//        String token = cookieToken == null ? paramToken : cookieToken;
//        System.out.println("token:" + token);
//        SecKillUser secKillUser = secKillUserService.getByToken(httpServletResponse , token);
//        System.out.println(secKillUser.getId() + ":" + secKillUser.getNickname());
//        return "goods_list";
//    }

    @RequestMapping("/to_list")
    public String to_list(Model model , SecKillUser secKillUser){
        System.out.println(secKillUser.getId() + ":" + secKillUser.getNickname());
        List<GoodsVo> goodsList = goodsService.getGoodsVo();
        System.out.println(goodsList);
        model.addAttribute("goodsList",goodsList);
        return "goods_list";
    }

    @RequestMapping("/to_detail/{goodsId}")
    public String to_detail(Model model , SecKillUser secKillUser , @PathVariable("goodsId") long id){
        GoodsVo goods = goodsService.getGoodsVoById(id);
        model.addAttribute("user" , secKillUser);
        model.addAttribute("goods", goods);
        long startTime = goods.getStartDate().getTime();
        long endTime = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();
        int miaoshaStatus = 0;
        int remainSeconds = 0;
        if(now < startTime ) {//秒杀还没开始，倒计时
            remainSeconds = (int)((startTime - now )/1000);
        }else  if(now > endTime){//秒杀已经结束
            miaoshaStatus = 2;
            remainSeconds = -1;
        }else {//秒杀进行中
            miaoshaStatus = 1;
        }
        model.addAttribute("miaoshaStatus", miaoshaStatus);
        model.addAttribute("remainSeconds", remainSeconds);
        return "goods_detail";
    }
}

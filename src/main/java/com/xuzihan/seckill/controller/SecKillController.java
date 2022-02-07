package com.xuzihan.seckill.controller;

import com.xuzihan.seckill.domain.SecKillOrder;
import com.xuzihan.seckill.domain.SecKillUser;
import com.xuzihan.seckill.service.GoodsService;
import com.xuzihan.seckill.service.SecKillOrderService;
import com.xuzihan.seckill.service.SecKillService;
import com.xuzihan.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ZihanXu
 * @version 1.0
 */

@Controller
@RequestMapping("/seckill")
public class SecKillController {

    @Autowired
    SecKillService secKillService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    SecKillOrderService secKillOrderService;

    @RequestMapping("/do_miaosha")
    public String do_miaosha(Model model , SecKillUser secKillUser , @RequestParam("goodsId") long id){
        GoodsVo goodsVo = goodsService.getGoodsVoById(id);
        if(goodsVo.getStockCount() < 1){
            System.out.println("Stock is not enough");
            model.addAttribute("errmsg" , "Stock is not enough");
            return "miaosha_fail";
        }
        SecKillOrder secKillOrder = secKillOrderService.searchSecKillOrderByUserAndGoods(secKillUser.getId(), id);
        if(secKillOrder != null){
            System.out.println("Order repeat");
            model.addAttribute("errmsg" , "Order repeat");
            return "miaosha_fail";
        }
        SecKillOrder newSecKillOrder = new SecKillOrder();
        newSecKillOrder.setGoodsId(id);
        newSecKillOrder.setUserId(secKillUser.getId());
        newSecKillOrder.setOrderId(12345678L);
        secKillService.doSeckill(id , newSecKillOrder);
        return "order_detail";
    }
}

package com.xuzihan.seckill.service;

import com.xuzihan.seckill.domain.SecKillOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ZihanXu
 * @version 1.0
 */


@Service
public class SecKillService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    SecKillOrderService secKillOrderService;


    @Transactional
    public int doSeckill(long goodsId , SecKillOrder secKillOrder){
        goodsService.reduceGoodsStock(goodsId);
        return secKillOrderService.insertIntoSecKillOrder(secKillOrder);
    }


}

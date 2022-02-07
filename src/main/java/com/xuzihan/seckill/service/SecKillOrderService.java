package com.xuzihan.seckill.service;

import com.xuzihan.seckill.dao.OrderDao;
import com.xuzihan.seckill.domain.SecKillOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZihanXu
 * @version 1.0
 */

@Service
public class SecKillOrderService {
    @Autowired
    OrderDao orderDao;

    public SecKillOrder searchSecKillOrderByUserAndGoods(long user_id , long good_id){
        return orderDao.serachSecKillOrderByUserAndGoods(user_id, good_id);
    }

    public int insertIntoSecKillOrder(SecKillOrder secKillOrder){
        return orderDao.insertIntoSecKillOrder(secKillOrder);
    }
}

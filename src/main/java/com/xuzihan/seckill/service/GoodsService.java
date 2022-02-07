package com.xuzihan.seckill.service;

import com.xuzihan.seckill.dao.GoodsDao;
import com.xuzihan.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZihanXu
 * @version 1.0
 */

@Service
public class GoodsService {

    @Autowired
    GoodsDao goodsDao;

    public List<GoodsVo> getGoodsVo(){
        return goodsDao.getGoodsVo();
    }

    public GoodsVo getGoodsVoById(long id){
        return goodsDao.getGoodsVoById(id);
    }

    public int reduceGoodsStock(long id){
        return goodsDao.reduceStock(id);
    }
}

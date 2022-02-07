package com.xuzihan.seckill.dao;

import com.xuzihan.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author ZihanXu
 * @version 1.0
 */

@Mapper
public interface GoodsDao {

    @Select("select goods.* , miaosha_goods.miaosha_price , miaosha_goods.stock_count , miaosha_goods.start_date , miaosha_goods.end_date from miaosha_goods left join goods on miaosha_goods.goods_id = goods.id")
    List<GoodsVo> getGoodsVo();

    @Select("select goods.* , miaosha_goods.miaosha_price , miaosha_goods.stock_count , miaosha_goods.start_date , miaosha_goods.end_date from miaosha_goods left join goods on miaosha_goods.goods_id = goods.id where goods.id = #{id}")
    GoodsVo getGoodsVoById(long id);

    @Update("update miaosha_goods set stock_count = stock_count - 1 where id = #{id}")
    int reduceStock(long id);

}

package com.xuzihan.seckill.dao;

import com.xuzihan.seckill.domain.OrderInfo;
import com.xuzihan.seckill.domain.SecKillOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

/**
 * @author ZihanXu
 * @version 1.0
 */

@Mapper
public interface OrderDao {

    @Select("select * from miaosha_order where user_id = {user_id} , goods_id = {goods_id}")
    SecKillOrder serachSecKillOrderByUserAndGoods(long user_id , long goods_id);

    @Insert("insert into miaosha_order where (user_id, goods_id, order_id)values(#{userId}, #{goodsId}, #{orderId})")
    int insertIntoSecKillOrder(SecKillOrder secKillOrder);

    @Insert("insert into order_info(user_id, goods_id, goods_name, goods_count, goods_price, order_channel, status, create_date)values("
            + "#{userId}, #{goodsId}, #{goodsName}, #{goodsCount}, #{goodsPrice}, #{orderChannel},#{status},#{createDate} )")
    @SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    long insertIntoOrderInfo(OrderInfo orderInfo);
}

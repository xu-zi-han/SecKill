package com.xuzihan.seckill.dao;

import com.xuzihan.seckill.domain.SecKillUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author ZihanXu
 * @version 1.0
 */

@Mapper
public interface SecKillUserDao {

    @Select("select * from miaosha_user where id = #{id}")
    SecKillUser getById(long id);
}

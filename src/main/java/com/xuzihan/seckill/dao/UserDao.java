package com.xuzihan.seckill.dao;

import com.xuzihan.seckill.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author ZihanXu
 * @version 1.0
 */
@Mapper
public interface UserDao {

    @Select(" select * from user where id = #{id} ")
    User searchById(int id);
}

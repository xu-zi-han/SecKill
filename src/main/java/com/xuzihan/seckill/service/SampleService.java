package com.xuzihan.seckill.service;

import com.xuzihan.seckill.dao.UserDao;
import com.xuzihan.seckill.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZihanXu
 * @version 1.0
 */
@Service
public class SampleService {

    @Autowired
    UserDao userDao;

    public User serachByIdService(int id){
        User user = userDao.searchById(id);
        return user;
    }
}

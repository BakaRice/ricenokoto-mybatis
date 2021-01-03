package com.ricemarch.ricenokotomybatis.service.impl;

import com.ricemarch.ricenokotomybatis.dao.UserDao;
import com.ricemarch.ricenokotomybatis.entity.User;
import com.ricemarch.ricenokotomybatis.service.UserService;
import com.ricemarch.ricenokotomybatis.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author RiceMarch
 * @date 2021/1/3 15:32
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}

package com.ricemarch.ricenokotomybatis.service;

import com.ricemarch.ricenokotomybatis.dao.UserDao;
import com.ricemarch.ricenokotomybatis.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author RiceMarch
 * @date 2021/1/3 15:49
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void checkUser() {
        User user = userService.checkUser("rice", "ri3e");
        System.out.println(user);
    }
}
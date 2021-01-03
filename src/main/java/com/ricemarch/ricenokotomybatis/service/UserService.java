package com.ricemarch.ricenokotomybatis.service;

import com.ricemarch.ricenokotomybatis.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author RiceMarch
 * @date 2021/1/3 15:32
 */

public interface UserService {

    //核对用户名和密码
    User checkUser(String username, String password);
}

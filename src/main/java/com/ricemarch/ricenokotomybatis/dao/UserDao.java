package com.ricemarch.ricenokotomybatis.dao;

import com.ricemarch.ricenokotomybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户持久层接口
 *
 * @author RiceMarch
 * @date 2021/1/3 15:26
 */
@Mapper
@Repository
public interface UserDao {

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}

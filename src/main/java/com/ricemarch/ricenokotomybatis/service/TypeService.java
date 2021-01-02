package com.ricemarch.ricenokotomybatis.service;

import com.ricemarch.ricenokotomybatis.entity.Type;

import java.util.List;

/**
 * @author RiceMarch
 * @date 2021/1/2 18:58
 */
public interface TypeService {

    int saveType(Type type);

    Type getType(Long id);

    List<Type> getAllType();

    List<Type> getAllTypeAndBlog();

    Type getTypeByName(String name);

    int updateType(Type type);

    int deleteType(Long id);
}

package com.ricemarch.ricenokotomybatis.dao;

import com.ricemarch.ricenokotomybatis.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章分类持久层接口
 *
 * @author RiceMarch
 * @date 2021/1/2 16:08
 */

@Mapper
@Repository
public interface TypeDao {
    int saveType(Type type);

    Type getType(Long id);

    List<Type> getAllType();

    List<Type> getAllTypeAndBlog();

    Type getTypeByName(String name);

    int updateType(Type type);

    int deleteType(Long id);
}

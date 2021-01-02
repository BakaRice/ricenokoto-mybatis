package com.ricemarch.ricenokotomybatis.service;

import com.ricemarch.ricenokotomybatis.dao.TypeDao;
import com.ricemarch.ricenokotomybatis.entity.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author RiceMarch
 * @date 2021/1/3 0:49
 */
@SpringBootTest
class TypeServiceTest {

    @Autowired
    TypeDao typeDao;

    @Test
    void getAllType() {
        List<Type> allType = typeDao.getAllType();
        for (Type type : allType) {
            System.out.println(type.toString());
        }
    }

    @Test
    void saveType() {
        Type type = new Type();
        type.setName("类型2");
        typeDao.saveType(type);
    }
}
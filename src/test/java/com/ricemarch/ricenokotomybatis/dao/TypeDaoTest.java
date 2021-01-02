package com.ricemarch.ricenokotomybatis.dao;

import com.ricemarch.ricenokotomybatis.entity.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author RiceMarch
 * @date 2021/1/2 19:40
 */
@SpringBootTest
class TypeDaoTest {

    @Autowired
    TypeDao typeDao;

    @Test
    void deleteType() {
        int i = typeDao.deleteType(58L);
        assertEquals(1, i);
    }


    @Test
    void saveType() {
        Type type = new Type();
        type.setName("test");
        typeDao.saveType(type);
    }

    @Test
    void getType() {
    }

    @Test
    void getAllType() {
    }

    @Test
    void getTypeByName() {
    }
}
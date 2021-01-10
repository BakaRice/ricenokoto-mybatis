package com.ricemarch.ricenokotomybatis.dao;

import com.ricemarch.ricenokotomybatis.entity.Picture;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.FixedWidth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author RiceMarch
 * @date 2021/1/10 14:53
 */
@SpringBootTest
@Slf4j
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@Rollback(value = false)
class PictureDaoTest {

    @Autowired
    PictureDao pictureDao;

    static Long saveId;
    static Picture picture;

    @Test
    @Order(1)
    void savePicture() {
        Picture picture = new Picture();
        picture.setPictureaddress("address");
        picture.setPicturename("name");
        picture.setPicturetime("picturetime");
        picture.setPicturedescription("desc");
        pictureDao.savePicture(picture);
    }

    @Test
    @Order(2)
    void listPicture() {
        List<Picture> pictures = pictureDao.listPicture();
        pictures.forEach(picture -> {
            String toString = picture.toString();
            System.out.println(toString);
            saveId = picture.getId();
        });
        System.out.println(saveId);
    }


    @Test
    @Order(3)
    void getPicture() {
        System.out.println(this.saveId);
        Picture picture = pictureDao.getPicture(saveId);
        assertNotNull(picture);
        System.out.println(picture.toString());
        this.picture = picture;
    }

    @Test
    @Order(4)
    void updatePicture() {
        this.picture.setPicturename("update");
        int i = pictureDao.updatePicture(this.picture);
        assertEquals(1, i);
    }

    @Test
    @Order(5)
    void deletePicture() {
        int i = pictureDao.deletePicture(saveId);
        assertEquals(i, 1);
    }
}
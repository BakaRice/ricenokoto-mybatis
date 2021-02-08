package com.ricemarch.ricenokotomybatis.dao;

import com.ricemarch.ricenokotomybatis.entity.FriendLink;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author RiceMarch
 * @date 2021/1/14 21:42
 */
@SpringBootTest
@Slf4j
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FriendLinkDaoTest {

    static FriendLink friendLink;
    static Long id;

    @Autowired
    FriendLinkDao friendLinkDao;

    @Test
    @Order(2)
    void listFriendLink() {
        List<FriendLink> friendLinks = friendLinkDao.listFriendLink();
        for (FriendLink link : friendLinks) {
            log.info("{}", link);
            id = link.getId();
        }
        assertNotNull(friendLinks);
    }

    @Test
    @Order(1)
    void saveFriendLink() {
        friendLink = new FriendLink();
        friendLink.setBlogname("rr");
        friendLink.setBlogaddress("adrr");
        friendLink.setPictureaddress("picture addr");
        int i = friendLinkDao.saveFriendLink(friendLink);
        assertEquals(1, i);
    }

    @Test
    @Order(3)
    void getFriendLink() {
        FriendLink friendLink = friendLinkDao.getFriendLink(id);
        log.info("{}", friendLink);
        assertNotNull(friendLink);
    }

    @Test
    @Order(4)
    void getFriendLinkByBlogAddress() {
        friendLink = friendLinkDao.getFriendLinkByBlogAddress(friendLink.getPictureaddress());
        assertNotNull(friendLink);
    }

    @Test
    @Order(5)
    void updateFriendLink() {
        friendLink.setBlogname("hi!");
        int i = friendLinkDao.updateFriendLink(friendLink);
        assertEquals(1, i);
    }

    @Test
    @Order(6)
    void deleteFriendLink() {
        int i = friendLinkDao.deleteFriendLink(id);
        assertNotEquals(0, i);
    }
}
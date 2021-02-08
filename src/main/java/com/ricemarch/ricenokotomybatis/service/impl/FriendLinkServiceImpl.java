package com.ricemarch.ricenokotomybatis.service.impl;

import com.ricemarch.ricenokotomybatis.dao.FriendLinkDao;
import com.ricemarch.ricenokotomybatis.entity.FriendLink;
import com.ricemarch.ricenokotomybatis.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RiceMarch
 * @date 2021/2/7 16:48
 */
@Service
public class FriendLinkServiceImpl implements FriendLinkService {

    @Autowired
    private FriendLinkDao friendLinkDao;

    @Override
    public List<FriendLink> listFriendLink() {
        return friendLinkDao.listFriendLink();
    }

    @Override
    public int saveFriendLink(FriendLink friendLink) {
        return friendLinkDao.saveFriendLink(friendLink);
    }

    @Override
    public FriendLink getFriendLink(Long id) {
        return friendLinkDao.getFriendLink(id);
    }

    @Override
    public FriendLink getFriendLinkByaddress(String friendlink) {
        return friendLinkDao.getFriendLinkByBlogAddress(friendlink);
    }

    @Override
    public int updateFriendLink(FriendLink friendLink) {
        return friendLinkDao.updateFriendLink(friendLink);
    }

    @Override
    public int deleteFriendLink(Long id) {
        return friendLinkDao.deleteFriendLink(id);
    }
}

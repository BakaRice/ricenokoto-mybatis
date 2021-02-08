package com.ricemarch.ricenokotomybatis.dao;

import com.ricemarch.ricenokotomybatis.entity.FriendLink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author RiceMarch
 * @date 2021/1/14 21:27
 */
@Mapper
@Repository
public interface FriendLinkDao {

    List<FriendLink> listFriendLink();

    int saveFriendLink(FriendLink friendLink);

    FriendLink getFriendLink(Long id);

    /**
     * @param blogAddress pictureaddress
     * @return FriendLink
     */
    FriendLink getFriendLinkByBlogAddress(String blogAddress);

    int updateFriendLink(FriendLink friendLink);

    int deleteFriendLink(Long id);

}

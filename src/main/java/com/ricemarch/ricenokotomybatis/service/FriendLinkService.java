package com.ricemarch.ricenokotomybatis.service;

import com.ricemarch.ricenokotomybatis.entity.FriendLink;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Friends chain display
 *
 * @author RiceMarch
 * @date 2021/2/7 16:43
 */
@Service
public interface FriendLinkService {


    //query all friend link
    List<FriendLink> listFriendLink();

    //add new link
    int saveFriendLink(FriendLink friendLink);

    //query link by id
    FriendLink getFriendLink(Long id);

    //query link by website url
    FriendLink getFriendLinkByaddress(String friendlink);

    //update
    int updateFriendLink(FriendLink friendLink);

    //delete link
    int deleteFriendLink(Long id);

}

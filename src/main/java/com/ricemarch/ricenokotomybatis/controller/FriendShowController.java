package com.ricemarch.ricenokotomybatis.controller;

import com.ricemarch.ricenokotomybatis.entity.FriendLink;
import com.ricemarch.ricenokotomybatis.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author RiceMarch
 * @date 2021/2/7 16:42
 */
@Controller
public class FriendShowController {

    @Autowired
    private FriendLinkService friendLinkService;

    @GetMapping("/friends")
    public String friends(Model model) {
        List<FriendLink> friendLinks = friendLinkService.listFriendLink();
        model.addAttribute("friendlinks", friendLinks);
        return "friends";
    }

}

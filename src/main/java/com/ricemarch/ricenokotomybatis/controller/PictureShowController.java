package com.ricemarch.ricenokotomybatis.controller;

import com.ricemarch.ricenokotomybatis.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 照片墙页面显示控制器
 *
 * @author RiceMarch
 * @date 2021/1/10 17:07
 */
@Controller
public class PictureShowController {

    @Autowired
    PictureService pictureService;

    @GetMapping("/picture")
    public String friends(Model model) {
        model.addAttribute("pictures", pictureService.listPicture());
        return "picture";
    }

}

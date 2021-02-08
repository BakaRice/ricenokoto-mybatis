package com.ricemarch.ricenokotomybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 关于我页面显示控制器
 *
 * @author RiceMarch
 * @date 2021/1/14 21:09
 */
@Controller
public class AboutShowController {
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}

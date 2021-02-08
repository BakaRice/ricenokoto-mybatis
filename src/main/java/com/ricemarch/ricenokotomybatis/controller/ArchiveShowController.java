package com.ricemarch.ricenokotomybatis.controller;

import com.ricemarch.ricenokotomybatis.queryvo.BlogQuery;
import com.ricemarch.ricenokotomybatis.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 时间轴页面显示控制器
 *
 * @author RiceMarch
 * @date 2021/1/14 21:18
 */
@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archive(Model model) {
        List<BlogQuery> blogQueries = blogService.getAllBlog();
        model.addAttribute("blogs", blogQueries);
        return "archives";
    }

}

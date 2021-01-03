package com.ricemarch.ricenokotomybatis.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ricemarch.ricenokotomybatis.queryvo.DetailedBlog;
import com.ricemarch.ricenokotomybatis.queryvo.FirstPageBlog;
import com.ricemarch.ricenokotomybatis.queryvo.RecommendBlog;
import com.ricemarch.ricenokotomybatis.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author RiceMarch
 * @date 2021/1/3 18:19
 */
@Controller
public class IndexController {

    @Autowired
    BlogService blogService;


    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, RedirectAttributes attributes) {
        PageHelper.startPage(pageNum, 10);
        List<FirstPageBlog> allFirstPageBlog = blogService.getAllFirstPageBlog();
        List<RecommendBlog> recommendedBlog = blogService.getRecommendedBlog();

        PageInfo<FirstPageBlog> firstPageBlogPageInfo = new PageInfo<>(allFirstPageBlog);
        model.addAttribute("pageInfo", firstPageBlogPageInfo);
        model.addAttribute("recommendedBlogs", recommendedBlog);
        return "index";
    }

    @PostMapping("/search")
    public String search(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                         @RequestParam String query) {
        PageHelper.startPage(pageNum, 10);
        List<FirstPageBlog> searchBlog = blogService.getSearchBlog(query);
        PageInfo<FirstPageBlog> firstPageBlogPageInfo = new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo", firstPageBlogPageInfo);
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable long id, Model model) {
        DetailedBlog detailedBlog = blogService.getDetailedBlog(id);
//        弃用该评论改用gittalk
        //        model.addAttribute("comments", null);
        model.addAttribute("blog", detailedBlog);
        return "blog";
    }

    @GetMapping("/footer/blogmessage")
    public String blogMessage(Model model) {
        Integer blogTotal = blogService.getBlogTotal();
        Integer blogViewTotal = blogService.getBlogViewTotal();
        Integer blogCommentTotal = blogService.getBlogCommentTotal();
        Integer blogMessageTotal = blogService.getBlogMessageTotal();

        model.addAttribute("blogTotal", blogTotal);
        model.addAttribute("blogCommentTotal", blogCommentTotal);
        model.addAttribute("blogViewTotal", blogViewTotal);
        model.addAttribute("blogMessageTotal", blogMessageTotal);
        return "index :: blogMessage";
    }


}

package com.ricemarch.ricenokotomybatis.service.impl;

import com.ricemarch.ricenokotomybatis.dao.BlogDao;
import com.ricemarch.ricenokotomybatis.entity.Blog;
import com.ricemarch.ricenokotomybatis.exception.BlogNotFoundException;
import com.ricemarch.ricenokotomybatis.queryvo.*;
import com.ricemarch.ricenokotomybatis.service.BlogService;
import com.ricemarch.ricenokotomybatis.util.MarkdownUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author RiceMarch
 * @date 2021/1/2 19:44
 */
@Service
@Slf4j
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogDao blogDao;

    @Override
    public ShowBlog getBlogById(Long id) {
        return blogDao.getBlogById(id);
    }

    @Override
    public List<BlogQuery> getAllBlog() {
        return blogDao.getAllBlogQuery();
    }

    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        return blogDao.saveBlog(blog);
    }

    @Override
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        return blogDao.updateBlog(showBlog);
    }

    @Override
    public void deleteBlog(Long id) {
        blogDao.deleteBlog(id);
    }

    @Override
    public List<BlogQuery> getBlogBySearch(SearchBlog searchBlog) {
        return blogDao.searchByTitleOrTypeOrRecommend(searchBlog);
    }

    @Override
    public List<FirstPageBlog> getAllFirstPageBlog() {
        return blogDao.getFirstPageBlog();
    }

    @Override
    public List<RecommendBlog> getRecommendedBlog() {
        List<RecommendBlog> allRecommendBlog = blogDao.getAllRecommendBlog();
        return allRecommendBlog;
    }

    @Override
    public List<FirstPageBlog> getSearchBlog(String query) {
        return blogDao.getSearchBlog(query);
    }

    @Override
    public DetailedBlog getDetailedBlog(Long id) {
        log.debug(BlogServiceImpl.class.getName() + "getDetailedBlog" + "{}", id);
        DetailedBlog detailedBlog = blogDao.getDetailedBlog(id);
        if (detailedBlog == null) {
            throw new BlogNotFoundException("该博客不存在");
        }
        String content = detailedBlog.getContent();
        //利用markdown转化器进行转换
        detailedBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        //自增浏览量
        blogDao.updateViews(id);
        //文章评论更新
        blogDao.getCommentCountById(id);

        return detailedBlog;

    }

    @Override
    public List<FirstPageBlog> getByTypeId(Long typeId) {
        return blogDao.getByTypeId(typeId);
    }

    @Override
    public Integer getBlogTotal() {
        return blogDao.getBlogTotal();
    }

    @Override
    public Integer getBlogViewTotal() {
        return blogDao.getBlogViewTotal();
    }

    @Override
    public Integer getBlogCommentTotal() {
        return blogDao.getBlogCommentTotal();
    }

    @Override
    public Integer getBlogMessageTotal() {
        return blogDao.getBlogMessageTotal();
    }
}

package com.ricemarch.ricenokotomybatis.dao;

import com.ricemarch.ricenokotomybatis.entity.Blog;
import com.ricemarch.ricenokotomybatis.queryvo.BlogQuery;
import com.ricemarch.ricenokotomybatis.queryvo.FirstPageBlog;
import com.ricemarch.ricenokotomybatis.queryvo.ShowBlog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author RiceMarch
 * @date 2021/1/2 14:46
 */
@SpringBootTest
class BlogDaoTest {

    @Autowired
    BlogDao blogDao;


    @Test
    void saveBlog() {
        Blog blog = new Blog();
        blog.setTitle("博客标题");
        blog.setContent("博客内容试试");
        int i = blogDao.saveBlog(blog);
        assertEquals(1, i);
    }

    @Test
    void getAllBlog() {
        List<Blog> allBlog = blogDao.getAllBlog();
        for (Blog blog : allBlog) {
            String toString = blog.toString();
            System.out.println(toString);
        }
    }

    @Test
    void getAllBlogQuery() {
        List<BlogQuery> allBlogQuery = blogDao.getAllBlogQuery();
        for (BlogQuery blogQuery : allBlogQuery) {
            String toString = blogQuery.toString();
            System.out.println(toString);
        }
    }

    @Test
    void deleteBlog() {
        int i = blogDao.deleteBlog(1L);
        System.out.println(i);
    }

    @Test
    void updateBlog() {
        ShowBlog blogById = blogDao.getBlogById(63L);
        blogById.setTitle("改一改名字吧");
        int i = blogDao.updateBlog(blogById);
        assertEquals(1, i);
    }

    @Test
    void getBlogById() {
        ShowBlog blogById = blogDao.getBlogById(2L);
        if (blogById != null) {
            System.out.println(blogById.toString());
        }

    }

    @Test
    void getFirstPageBlog() {
        List<FirstPageBlog> firstPageBlog = blogDao.getFirstPageBlog();
        System.out.println(firstPageBlog.toString());
    }
}
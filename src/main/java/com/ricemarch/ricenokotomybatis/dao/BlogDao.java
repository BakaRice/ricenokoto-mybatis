package com.ricemarch.ricenokotomybatis.dao;

import com.ricemarch.ricenokotomybatis.entity.Blog;
import com.ricemarch.ricenokotomybatis.queryvo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 博客持久层接口
 *
 * @author RiceMarch
 * @date 2021/1/2 13:41
 */
@Mapper
@Repository
public interface BlogDao {

    /**
     * 保存博客
     *
     * @param blog
     * @return
     */
    int saveBlog(Blog blog);

    /**
     * 获取全部博客
     *
     * @return
     */
    List<Blog> getAllBlog();

    /**
     * 查询文章管理列表
     *
     * @return
     */
    List<BlogQuery> getAllBlogQuery();

    /**
     * 删除文章
     *
     * @param id
     */
    int deleteBlog(Long id);

    int updateBlog(ShowBlog showBlog);

    /**
     * 查询编辑修改文章
     *
     * @param id
     * @return
     */
    ShowBlog getBlogById(Long id);

    /**
     * 获取所有首屏数据
     *
     * @return
     */
    List<FirstPageBlog> getFirstPageBlog();

    List<BlogQuery> searchByTitleOrTypeOrRecommend(SearchBlog searchBlog);


    List<RecommendBlog> getAllRecommendBlog();

//    List<FirstPageBlog> getNewBlog();

    List<FirstPageBlog> getSearchBlog(String query);

    DetailedBlog getDetailedBlog(Long id);

    int updateViews(Long id);

    //    根据博客id查询出评论数量
    int getCommentCountById(Long id);

    List<FirstPageBlog> getByTypeId(Long typeId);

    Integer getBlogTotal();

    Integer getBlogViewTotal();

    Integer getBlogCommentTotal();

    Integer getBlogMessageTotal();

}

package com.ricemarch.ricenokotomybatis.queryvo;

import lombok.Data;

/**
 * 推荐博客数据实体类
 *
 * @author RiceMarch
 * @date 2021/1/2 19:45
 */
@Data
public class RecommendBlog {
    private Long id;
    private String title;
    private String firstPicture;
    private boolean recommend;
}

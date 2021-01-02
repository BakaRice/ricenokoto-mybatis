package com.ricemarch.ricenokotomybatis.queryvo;

import lombok.Data;

import java.util.Date;

/**
 * 博客首页数据实体类
 *
 * @author RiceMarch
 * @date 2021/1/2 14:58
 */
@Data
public class FirstPageBlog {
    //Blog
    private Long id;
    private String title;
    private String firstPicture;
    private Integer views;
    private Integer commentCount;
    private Date updateTime;
    private String description;

    //Type
    private String typeName;

    //User
    private String nickname;
    private String avatar;

}

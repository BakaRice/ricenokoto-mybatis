package com.ricemarch.ricenokotomybatis.queryvo;

import lombok.Data;

import java.util.Date;

/**
 * @author RiceMarch
 * @date 2021/1/2 19:45
 */
@Data
public class DetailedBlog {
    private Long id;
    private String firstPicture;
    private String flag;
    private String title;
    private String content;

    private Integer views;
    private Integer commentCount;
    private Date updateTime;
    private boolean commentabled;
    private boolean shareStatement;
    private boolean appreciation;
    private String nickname;
    private String avatar;

    //Type
    private String typeName;
}

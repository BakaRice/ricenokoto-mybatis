package com.ricemarch.ricenokotomybatis.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 博客实体类
 *
 * @author RiceMarch
 * @date 2021/1/2 13:28
 */

@Data
public class Blog {
    //    标题，内容，首图，标记，浏览次数，赞赏开启，版权开启，是否发布，创建时间，更新时间，评论开启，描述
    private Long id;
    //标题
    private String title;
    //内容
    private String content;
    private String firstPicture;
    //标记
    private String flag;
    //浏览次数
    private Integer views;
    //评论数
    private Integer commentCount;

    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentabled;
    private boolean published;
    private boolean recommend;
    private Date createTime;
    private Date updateTime;

    private Long typeId;
    private Long userId;
    private String description;
    private Type type;
    private User user;
    private List<Comment> comments = new ArrayList<>();

}

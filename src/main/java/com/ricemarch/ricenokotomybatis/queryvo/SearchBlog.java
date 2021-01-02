package com.ricemarch.ricenokotomybatis.queryvo;

import lombok.Data;

/**
 * 搜索博客管理列表
 *
 * @author RiceMarch
 * @date 2021/1/2 19:46
 */
@Data
public class SearchBlog {
    private String title;
    private Long typeId;
}

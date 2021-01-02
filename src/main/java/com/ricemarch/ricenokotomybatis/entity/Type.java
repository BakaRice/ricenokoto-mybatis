package com.ricemarch.ricenokotomybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类实体类
 *
 * @author RiceMarch
 * @date 2021/1/2 13:33
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Type {
    private Long id;
    private String name;

    private List<Blog> blogs = new ArrayList<>();

}

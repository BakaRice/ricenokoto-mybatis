package com.ricemarch.ricenokotomybatis.queryvo;

import com.ricemarch.ricenokotomybatis.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 显示数据实体类
 *
 * @author RiceMarch
 * @date 2021/1/2 13:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogQuery {
    private Long id;
    private String title;
    private Date updateTime;
    private Boolean recommend;
    private Boolean published;
    private Long typeId;
    private Type type;
}

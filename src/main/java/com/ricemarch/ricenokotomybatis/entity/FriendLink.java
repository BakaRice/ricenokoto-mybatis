package com.ricemarch.ricenokotomybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 友链实体类
 *
 * @author RiceMarch
 * @date 2021/1/2 13:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FriendLink {
    private Long id;
    private String blogname;
    private String blogaddress;
    private String pictureaddress;
    private Date createTime;
}

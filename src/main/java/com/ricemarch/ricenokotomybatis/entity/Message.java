package com.ricemarch.ricenokotomybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 留言实体类
 *
 * @author RiceMarch
 * @date 2021/1/2 13:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;
    private Long parentMessageId;
    private boolean adminMessage;

}

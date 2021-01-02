package com.ricemarch.ricenokotomybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 照片墙实体类
 *
 * @author RiceMarch
 * @date 2021/1/2 13:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Picture {
    private Long id;
    private String picturename;
    private String picturetime;
    private String pictureaddress;
    private String picturedescription;

}

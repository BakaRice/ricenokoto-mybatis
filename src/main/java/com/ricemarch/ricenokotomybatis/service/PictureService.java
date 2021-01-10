package com.ricemarch.ricenokotomybatis.service;

import com.ricemarch.ricenokotomybatis.entity.Picture;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RiceMarch
 * @date 2021/1/10 15:39
 */
public interface PictureService {

    List<Picture> listPicture();

    int savePicture(Picture picture);

    Picture getPicture(Long id);

    int updatePicture(Picture picture);

    int deletePicture(Long id);
}

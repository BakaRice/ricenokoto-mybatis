package com.ricemarch.ricenokotomybatis.service.impl;

import com.ricemarch.ricenokotomybatis.dao.PictureDao;
import com.ricemarch.ricenokotomybatis.entity.Picture;
import com.ricemarch.ricenokotomybatis.service.PictureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RiceMarch
 * @date 2021/1/10 15:41
 */
@Service
@Slf4j
public class PictureServiceImpl implements PictureService {

    @Autowired
    PictureDao pictureDao;

    @Override
    public List<Picture> listPicture() {
        return pictureDao.listPicture();
    }

    @Override
    public int savePicture(Picture picture) {
        return pictureDao.savePicture(picture);
    }

    @Override
    public Picture getPicture(Long id) {
        return pictureDao.getPicture(id);
    }

    @Override
    public int updatePicture(Picture picture) {
        return pictureDao.updatePicture(picture);
    }

    @Override
    public int deletePicture(Long id) {
        return pictureDao.deletePicture(id);
    }
}

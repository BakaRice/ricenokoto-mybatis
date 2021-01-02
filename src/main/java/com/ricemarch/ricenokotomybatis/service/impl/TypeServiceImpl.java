package com.ricemarch.ricenokotomybatis.service.impl;

import com.ricemarch.ricenokotomybatis.dao.TypeDao;
import com.ricemarch.ricenokotomybatis.entity.Type;
import com.ricemarch.ricenokotomybatis.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RiceMarch
 * @date 2021/1/2 19:00
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeDao typeDao;

    @Override
    public int saveType(Type type) {
        return typeDao.saveType(type);
    }

    @Override
    public Type getType(Long id) {
        return typeDao.getType(id);
    }

    @Override
    public List<Type> getAllType() {
        return typeDao.getAllType();
    }

    @Override
    public List<Type> getAllTypeAndBlog() {
        return typeDao.getAllTypeAndBlog();
    }

    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }

    @Override
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }

    @Override
    public int deleteType(Long id) {
        return typeDao.deleteType(id);
    }
}

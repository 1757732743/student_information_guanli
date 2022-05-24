package com.ischoolbar.programmer.service.impl;

import com.ischoolbar.programmer.dao.ClazzDao_new;
import com.ischoolbar.programmer.entity.Clazz_new;
import com.ischoolbar.programmer.entity.Clazz;
import com.ischoolbar.programmer.service.ClazzService_new;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClazzServiceImpl_new implements ClazzService_new {

    @Autowired
    ClazzDao_new clazzDao;

    @Override
    public int getAmount() {
        return clazzDao.getClazzsCount();
    }

    @Override
    public int deleteClazzs(List<Clazz_new> clazzs) {
        return clazzDao.deleteClazzs(clazzs);
    }

    @Override
    public int addClazz(Clazz_new clazz) {
        return clazzDao.insertClazz(clazz);
    }

    @Override
    public int updateClazz(Clazz_new clazz) {
        return clazzDao.updateClazz(clazz);
    }

  
    @Override
    public int getSearchCount(Map<String, Object> searchParam) {
        return clazzDao.getSearchCount(searchParam);
    }

    @Override
    public List<Clazz> queryAllClazzs() {
        return clazzDao.selectClazzs();
    }

	@Override
	public List<Clazz_new> queryClazzs(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Clazz_new> searchClazzs(Integer page, Integer size,
			Map<String, Object> searchParam) {
		// TODO Auto-generated method stub
		return null;
	}



}

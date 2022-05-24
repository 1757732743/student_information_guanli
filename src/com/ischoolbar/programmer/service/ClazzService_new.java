package com.ischoolbar.programmer.service;

import com.ischoolbar.programmer.entity.Clazz_new;
import com.ischoolbar.programmer.entity.Clazz;

import java.util.List;
import java.util.Map;

public interface ClazzService_new {

    List<Clazz_new> queryClazzs(int page, int size);

    int getAmount();

    /**
     * ɾ��ָ���༶
     * @param clazzs
     * @return ɾ���ɹ�������
     */
    int deleteClazzs(List<Clazz_new> clazzs);

    /**
     * ���һ���༶
     * @param clazz
     */
    int addClazz(Clazz_new clazz);

    /**
     * �޸�һ���༶
     * @param clazz
     * @return
     */
    int updateClazz(Clazz_new clazz);

    /**
     * �����༶
     * @param page
     * @param size
     * @param searchParam
     */
    List<Clazz_new> searchClazzs(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * ��ȡ����������
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

    List<Clazz> queryAllClazzs();

}

package com.ischoolbar.programmer.service;

import com.ischoolbar.programmer.entity.Clazz_new;
import com.ischoolbar.programmer.entity.Clazz;

import java.util.List;
import java.util.Map;

public interface ClazzService_new {

    List<Clazz_new> queryClazzs(int page, int size);

    int getAmount();

    /**
     * 删除指定班级
     * @param clazzs
     * @return 删除成功的数量
     */
    int deleteClazzs(List<Clazz_new> clazzs);

    /**
     * 添加一个班级
     * @param clazz
     */
    int addClazz(Clazz_new clazz);

    /**
     * 修改一个班级
     * @param clazz
     * @return
     */
    int updateClazz(Clazz_new clazz);

    /**
     * 搜索班级
     * @param page
     * @param size
     * @param searchParam
     */
    List<Clazz_new> searchClazzs(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * 获取搜索的数量
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

    List<Clazz> queryAllClazzs();

}

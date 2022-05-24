package com.ischoolbar.programmer.dao;

import com.ischoolbar.programmer.entity.Clazz_new;
import com.ischoolbar.programmer.entity.Clazz;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ClazzDao_new {
    /**
     * ��Ӱ༶
     * @param clazz
     * @return
     */
    int insertClazz(Clazz_new clazz);

    /**
     * ɾ���༶
     * @param clazzes
     * @return
     */
    int deleteClazzs(List<Clazz_new> clazzes);

    /**
     * �޸İ༶
     * @param clazz
     * @return
     */
    int updateClazz(Clazz_new clazz);

    /**
     * ��ѯ���а༶
     * @return
     */
    List<Clazz> selectClazzs();

    /**
     * ͨ����ʦ��ѯ����
     */
    List<Clazz_new> getCLazzsByTeacher(int tid);

    /**
     * ��ѯ�༶
     * @param id
     * @return
     */
    Clazz_new selectClazz(int id);

    /**
     * ��ҳ��ѯ�༶
     * @param begin ��ʼ��������0��ʼ
     * @param size  ÿҳ��С
     * @return
     */
    List<Clazz_new> selectClazzsByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * ��ȡ�༶����
     * @return
     */
    int getClazzsCount();

    /**
     * ��ҳ�����༶
     * @param map 4��������begin,size,mname,mdept
     * @return
     */
    List<Clazz_new> searchClazzsByLimit(Map<String,Object> map);

    /**
     * ��ȡ����������
     * @param map 2��������mname,mdept
     * @return
     */
    int getSearchCount(Map<String,Object> map);


}

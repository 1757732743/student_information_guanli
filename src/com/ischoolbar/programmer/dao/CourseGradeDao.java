package com.ischoolbar.programmer.dao;

import com.ischoolbar.programmer.entity.CourseGrade;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CourseGradeDao {
    /**
     * ��ӳɼ�
     * @param courseGrade
     * @return
     */
    int insertCourseGrade(CourseGrade courseGrade);

    /**
     * ɾ���ɼ�
     * @param courseGrades
     * @return
     */
    int deleteCourseGrades(List<CourseGrade> courseGrades);

    /**
     * �޸ĳɼ�
     * @param courseGrade
     * @return
     */
    int updateCourseGrade(CourseGrade courseGrade);

    /**
     * ��ѯ���гɼ�
     * @return
     */
    List<CourseGrade> selectCourseGrades();

    /**
     * ����id��ѯ�ɼ�
     * @param id
     * @return
     */
    CourseGrade selectCourseGrade(Integer id);

    /**
     * ��ҳ��ѯ�ɼ�
     * @param begin ��ʼ��������0��ʼ
     * @param size  ÿҳ��С
     * @return
     */
    List<CourseGrade> selectCourseGradesByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * ��ȡ�ɼ�����
     * @return
     */
    int getCourseGradesCount();

    /**
     * ��ҳ�����ɼ�
     * @param map 4��������begin,size,mname,mdept
     * @return
     */
    List<CourseGrade> searchCourseGradesByLimit(Map<String,Object> map);

    /**
     * ��ȡ����������
     * @param map 2��������mname,mdept
     * @return
     */
    int getSearchCount(Map<String,Object> map);

    CourseGrade selectCourseGradeByOidAndSid(@Param("oid")int oid, @Param("sid")int sid);

    int updateCourseGradeByOidAndSid(CourseGrade courseGrade);
}

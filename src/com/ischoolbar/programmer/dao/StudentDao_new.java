package com.ischoolbar.programmer.dao;

import com.ischoolbar.programmer.entity.Student_new;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao_new {
    /**
     * ���ѧ��
     * @param student
     * @return
     */
    int insertStudent(Student_new student);

    /**
     * ɾ��ѧ��
     * @param list
     * @return
     */
    int deleteStudents(List<Student_new> list);

    /**
     * �޸�ѧ��
     * @param student
     * @return
     */
    int updateStudent(Student_new student);

    /**
     * ����id��ѯѧ��
     * @param sid
     * @return
     */
    Student_new selectStudent(int sid);

    /**
     * ��ҳ��ѯѧ��
     * @param begin ��ʼ��������0��ʼ
     * @param size  ÿҳ��С
     * @return
     */
    List<Student_new> selectStudentsByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * ��ȡѧ������
     * @return
     */
    int getStudentsCount();

    /**
     * ��ҳ����ѧ��
     * @param map 5��������begin,size,sname,snum,sclass
     * @return
     */
    List<Student_new> searchStudentsByLimit(Map<String,Object> map);

    List<Student_new> searchStudentsByLimitByTeacher(Map<String, Object> map);

    /**
     * ��ȡ����������
     * @param map 3��������sname,snum,sclass
     * @return
     */
    int getSearchCount(Map<String,Object> map);

    int getSearchCountByTeacher(Map<String, Object> searchParam);

    /**
     * ����¼
     * @param map 2��������username��password
     * @return
     */
    Student_new checkByUsernameAndPassword(Map<String,Object> map);

    /**
     * ��ý�ʦ����ѧ��������
     * @return
     */
    int getStudentsCountByTeacher(int tid);

    List<Student_new> selectStudentsByLimitByTeacher(@Param("begin")int begin, @Param("size")int size, @Param("tid")int tid);

    List<Student_new> selectStudentsByOid(int oid);

    List<Student_new> selectStudents();
}

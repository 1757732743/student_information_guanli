package com.ischoolbar.programmer.service;

import com.ischoolbar.programmer.entity.Student_new;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface StudentService_new {

    /**
     * ��ҳ������ѧ��
     * @param page
     * @param size
     * @return
     */
    List<Student_new> findStudentsByPage(int page, int size);

    /**
     * ��ȡѧ������
     * @return
     */
    int getStudentsCount();

    /**
     * ɾ��ָ��ѧ��
     * @param students
     * @return ɾ���ɹ�������
     */
    int deleteStudents(List<Student_new> students);

    /**
     * ���һ��ѧ��
     * @param student
     */
    int addStudent(Student_new student);

    /**
     * �޸�һ��ѧ��
     * @param student
     * @return
     */
    int updateStudent(Student_new student);

    /**
     * ����ѧ��
     * @param page
     * @param size
     * @param searchParam
     */
    List<Student_new> searchStudents(Integer page, Integer size, Map<String, Object> searchParam);

    List<Student_new> searchStudentsByTeacher(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * ��ȡ����������
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

    int getSearchCountByTeacher(Map<String, Object> searchParam);

    int getStudentsCountByTeacher(int tid);

    List<Student_new> findStudentsByPageByTeacher(Integer page, Integer size, int tid);

    List<Student_new> findStudentsByOid(int oid);

    Student_new findStudentBySid(Integer sid);

    String print(HttpServletRequest req);
}

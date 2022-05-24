package com.ischoolbar.programmer.service;

import com.ischoolbar.programmer.entity.Student_new;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface StudentService_new {

    /**
     * 分页找所有学生
     * @param page
     * @param size
     * @return
     */
    List<Student_new> findStudentsByPage(int page, int size);

    /**
     * 获取学生总数
     * @return
     */
    int getStudentsCount();

    /**
     * 删除指定学生
     * @param students
     * @return 删除成功的数量
     */
    int deleteStudents(List<Student_new> students);

    /**
     * 添加一个学生
     * @param student
     */
    int addStudent(Student_new student);

    /**
     * 修改一个学生
     * @param student
     * @return
     */
    int updateStudent(Student_new student);

    /**
     * 搜索学生
     * @param page
     * @param size
     * @param searchParam
     */
    List<Student_new> searchStudents(Integer page, Integer size, Map<String, Object> searchParam);

    List<Student_new> searchStudentsByTeacher(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * 获取搜索的数量
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

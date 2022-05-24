package com.ischoolbar.programmer.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.entity.Student;
import com.ischoolbar.programmer.entity.Student_new;
/**
 * 学生service
 * @author llq
 *
 */
@Service
public interface StudentService {
	//将下面这个东西对应到_1这个表单下面
	public Student_new findByUserName(String username);
	public int add(Student student);
	public int edit(Student student);
	public int delete(String ids);
	public List<Student> findList(Map<String,Object> queryMap);
	public List<Student> findAll();
	public int getTotal(Map<String,Object> queryMap);
}

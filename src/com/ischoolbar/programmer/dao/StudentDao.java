package com.ischoolbar.programmer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ischoolbar.programmer.entity.Clazz;
import com.ischoolbar.programmer.entity.Student;
import com.ischoolbar.programmer.entity.Student_new;

/**
 * ѧ??dao
 * @author llq
 *
 */
@Repository
public interface StudentDao {
	public Student_new findByUserName(String username);
	public int add(Student student);
	public int edit(Student student);
	public int delete(String ids);
	public List<Student> findList(Map<String,Object> queryMap);
	public List<Student> findAll();
	public int getTotal(Map<String,Object> queryMap);
}

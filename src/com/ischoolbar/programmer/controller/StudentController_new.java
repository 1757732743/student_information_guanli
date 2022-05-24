package com.ischoolbar.programmer.controller;

import com.ischoolbar.programmer.entity.CourseGrade;
import com.ischoolbar.programmer.entity.Student_new;
import com.ischoolbar.programmer.entity.Teacher;
import com.ischoolbar.programmer.service.CourseGradeService;
import com.ischoolbar.programmer.service.StudentService_new;
import com.ischoolbar.programmer.util.JsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student_new")

public class StudentController_new {

    @Autowired
    StudentService_new service;
    @Autowired
    CourseGradeService courseGradeService;

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("student/student_list_new");
		return model;
	}
    /**
     * 查询所有学生
     * @param page  当前页码
     * @param limit 每页大小
     * @return 学生信息
     */
    @RequestMapping("queryStudents.do")
    public Map<String,Object> queryStudents(Integer page, Integer limit){
        //获取学生数量
        int count = service.getStudentsCount();
        //获取学生信息
        List<Student_new> students = service.findStudentsByPage(page,limit);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", students);

        return res;
    }

    /**
     * 查询学生,这个就是对应的个人信息表了
     * @return 学生信息
     */
    @RequestMapping("queryStudent.do")
    public Student_new queryStudent(Integer sid){
        //获取学生信息
    	Student_new student = service.findStudentBySid(sid);
        return student;
    }

    /**
     * 通过oid查询所有学生
     */
    @RequestMapping("queryStudentsByOid.do")
    public List<Map<String,Object>> queryStudentsByOid(int oid){
        //获取学生学生信息
        List<Student_new> students = service.findStudentsByOid(oid);

        List<Map<String,Object>> res = new ArrayList<>();

        for(Student_new student : students) {
            Map<String,Object> map = new HashMap<>();
            map.put("sid", student.getSid());
            map.put("snum", student.getSnum());
            map.put("sname",student.getSname());
            CourseGrade courseGrade = courseGradeService.findScoreByOidAndSid(oid, student.getSid());
            if(courseGrade == null) map.put("score", null);
            else map.put("score", courseGrade.getScore());

            res.add(map);
        }

        return res;
    }

    /**
     * 删除学生
     * @param json 学生对象的json
     * @return 成功行数
     */
    @RequestMapping("deleteStudents.do")
    public Integer deleteStudents(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //如果不是数组形式，变成数组形式
        List<Student_new> students = JsonUtil.parseList(json, Student_new.class);
        return service.deleteStudents(students);
    }

    /**
     * 添加一个学生
     * @param json 学生对象的json
     * @return 成功标志1
     */
    @RequestMapping("addStudent.do")
    public Integer addStudent(String json){
    	Student_new student = JsonUtil.parseObject(json, Student_new.class);
        return service.addStudent(student);
    }

    /**
     * 修改一个学生
     * @param json 学生对象的json
     * @return 成功标志1
     */
    @RequestMapping("updateStudent.do")
    public Integer updateStudent(String json){
    	Student_new student = JsonUtil.parseObject(json, Student_new.class);
        return service.updateStudent(student);
    }

    /**
     * 获取学生总数
     * @return 学生总数
     */
    @RequestMapping("getAmount.do")
    public Integer getAmount() {
        return service.getStudentsCount();
    }

    /**
     * 搜索学生
     * @param page 当前页码
     * @param limit 每页大小
     * @param json 搜索参数的json
     *             {"sname":学生姓名,"snum":学号,"cid":班级id}
     * @return 学生信息
     */
    @RequestMapping("searchStudents.do")
    public Map<String,Object> searchStudents(Integer page, Integer limit, String json){
        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //获取查询个数
        int count = service.getSearchCount(searchParam);
        //查询学生信息
        List<Student_new> students = service.searchStudents(page, limit, searchParam);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", students);
        return res;
    }

    /**
     * 加载给人信息，当自己登录的就仅仅显示自己的信息
     * @param page 当前页码
     * @param limit 每页大小
     * @param json 搜索参数的json
     *             {"sname":学生姓名,"snum":学号,"cid":班级id}
     * @return 学生信息
     */
    @RequestMapping("gerensearchStudents.do")
    public Map<String,Object> gerensearchStudents(Integer page, Integer limit, String json){
        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //获取查询个数
        int count = service.getSearchCount(searchParam);
        //查询学生信息
        List<Student_new> students = service.searchStudents(page, limit, searchParam);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", students);
        return res;
    }
    
    @RequestMapping("teacher/searchStudentsByTeacher.do")
    public Map<String,Object> searchStudentsByTeacher(Integer page, Integer limit, String json, HttpServletRequest req){
        //获取当前账号信息
        Teacher loginTeacher =  (Teacher) req.getSession().getAttribute("loginObj");

        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        searchParam.put("tid", loginTeacher.getTid());

        //获取查询个数
        int count = service.getSearchCountByTeacher(searchParam);
        //查询学生信息
        List<Student_new> students = service.searchStudentsByTeacher(page, limit, searchParam);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", students);
        return res;
    }

    @RequestMapping("printStudentInformation.do")
    	//下面就是个人信息
    public Map<String, Object> printStudentInformation(HttpServletRequest req) {
        String url = service.print(req);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("url", url);

        return map;
    }
}

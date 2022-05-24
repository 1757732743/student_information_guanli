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
     * ��ѯ����ѧ��
     * @param page  ��ǰҳ��
     * @param limit ÿҳ��С
     * @return ѧ����Ϣ
     */
    @RequestMapping("queryStudents.do")
    public Map<String,Object> queryStudents(Integer page, Integer limit){
        //��ȡѧ������
        int count = service.getStudentsCount();
        //��ȡѧ����Ϣ
        List<Student_new> students = service.findStudentsByPage(page,limit);
        //���map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", students);

        return res;
    }

    /**
     * ��ѯѧ��,������Ƕ�Ӧ�ĸ�����Ϣ����
     * @return ѧ����Ϣ
     */
    @RequestMapping("queryStudent.do")
    public Student_new queryStudent(Integer sid){
        //��ȡѧ����Ϣ
    	Student_new student = service.findStudentBySid(sid);
        return student;
    }

    /**
     * ͨ��oid��ѯ����ѧ��
     */
    @RequestMapping("queryStudentsByOid.do")
    public List<Map<String,Object>> queryStudentsByOid(int oid){
        //��ȡѧ��ѧ����Ϣ
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
     * ɾ��ѧ��
     * @param json ѧ�������json
     * @return �ɹ�����
     */
    @RequestMapping("deleteStudents.do")
    public Integer deleteStudents(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //�������������ʽ�����������ʽ
        List<Student_new> students = JsonUtil.parseList(json, Student_new.class);
        return service.deleteStudents(students);
    }

    /**
     * ���һ��ѧ��
     * @param json ѧ�������json
     * @return �ɹ���־1
     */
    @RequestMapping("addStudent.do")
    public Integer addStudent(String json){
    	Student_new student = JsonUtil.parseObject(json, Student_new.class);
        return service.addStudent(student);
    }

    /**
     * �޸�һ��ѧ��
     * @param json ѧ�������json
     * @return �ɹ���־1
     */
    @RequestMapping("updateStudent.do")
    public Integer updateStudent(String json){
    	Student_new student = JsonUtil.parseObject(json, Student_new.class);
        return service.updateStudent(student);
    }

    /**
     * ��ȡѧ������
     * @return ѧ������
     */
    @RequestMapping("getAmount.do")
    public Integer getAmount() {
        return service.getStudentsCount();
    }

    /**
     * ����ѧ��
     * @param page ��ǰҳ��
     * @param limit ÿҳ��С
     * @param json ����������json
     *             {"sname":ѧ������,"snum":ѧ��,"cid":�༶id}
     * @return ѧ����Ϣ
     */
    @RequestMapping("searchStudents.do")
    public Map<String,Object> searchStudents(Integer page, Integer limit, String json){
        //��������Ĳ���
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //��ȡ��ѯ����
        int count = service.getSearchCount(searchParam);
        //��ѯѧ����Ϣ
        List<Student_new> students = service.searchStudents(page, limit, searchParam);
        //���map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", students);
        return res;
    }

    /**
     * ���ظ�����Ϣ�����Լ���¼�ľͽ�����ʾ�Լ�����Ϣ
     * @param page ��ǰҳ��
     * @param limit ÿҳ��С
     * @param json ����������json
     *             {"sname":ѧ������,"snum":ѧ��,"cid":�༶id}
     * @return ѧ����Ϣ
     */
    @RequestMapping("gerensearchStudents.do")
    public Map<String,Object> gerensearchStudents(Integer page, Integer limit, String json){
        //��������Ĳ���
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //��ȡ��ѯ����
        int count = service.getSearchCount(searchParam);
        //��ѯѧ����Ϣ
        List<Student_new> students = service.searchStudents(page, limit, searchParam);
        //���map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", students);
        return res;
    }
    
    @RequestMapping("teacher/searchStudentsByTeacher.do")
    public Map<String,Object> searchStudentsByTeacher(Integer page, Integer limit, String json, HttpServletRequest req){
        //��ȡ��ǰ�˺���Ϣ
        Teacher loginTeacher =  (Teacher) req.getSession().getAttribute("loginObj");

        //��������Ĳ���
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        searchParam.put("tid", loginTeacher.getTid());

        //��ȡ��ѯ����
        int count = service.getSearchCountByTeacher(searchParam);
        //��ѯѧ����Ϣ
        List<Student_new> students = service.searchStudentsByTeacher(page, limit, searchParam);
        //���map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", students);
        return res;
    }

    @RequestMapping("printStudentInformation.do")
    	//������Ǹ�����Ϣ
    public Map<String, Object> printStudentInformation(HttpServletRequest req) {
        String url = service.print(req);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("url", url);

        return map;
    }
}

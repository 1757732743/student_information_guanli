package com.ischoolbar.programmer.service.impl;

import com.ischoolbar.programmer.dao.CourseGradeDao;
import com.ischoolbar.programmer.entity.CourseGrade;
import com.ischoolbar.programmer.service.CourseGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseGradeServiceImpl implements CourseGradeService {

    @Autowired
    CourseGradeDao courseGradeDao;

    @Override
    public CourseGrade findScoreByOidAndSid(int oid,int sid) {
        CourseGrade courseGrade = courseGradeDao.selectCourseGradeByOidAndSid(oid,sid);
        return courseGrade;
    }

    @Override
    public int saveCourseGrade(CourseGrade courseGrade) {
        //���жϱ�������û�е�ǰ���κ�ѧ��id�ĳɼ�
        CourseGrade cgTmp = courseGradeDao.selectCourseGradeByOidAndSid(courseGrade.getOid(), courseGrade.getSid());
        int res = 0;
        if(cgTmp == null) res = courseGradeDao.insertCourseGrade(courseGrade);
        else res = courseGradeDao.updateCourseGradeByOidAndSid(courseGrade);
        return res;
    }
}

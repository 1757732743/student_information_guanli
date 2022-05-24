package com.ischoolbar.programmer.service;

import com.ischoolbar.programmer.entity.CourseGrade;

public interface CourseGradeService {

    CourseGrade findScoreByOidAndSid(int oid, int sid);

    int saveCourseGrade(CourseGrade courseGrade);
}

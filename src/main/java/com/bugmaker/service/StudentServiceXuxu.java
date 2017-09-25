package com.bugmaker.service;

import com.bugmaker.bean.Internship;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.Survey;
import com.bugmaker.bean.SurveyResult;

import java.util.List;

public interface StudentServiceXuxu {
    //查询所有志愿（选择志愿列表用）
    List<Internship> selectAllInternshipList();

    //模糊查询
    List<Internship> selectInternshipByName(String internshipString);

    //添加志愿填报
    String addInternship(Internship internship);

    //就业信息调查
    String addSurveyResult(SurveyResult surveyResult);

    //查最新调查表
    Survey isUseForSurvey();

    //如果学生已经填写了调查表，根据学生id查询他已填写的调查表。
    SurveyResult selectSurveyByStuId(Student student);
}

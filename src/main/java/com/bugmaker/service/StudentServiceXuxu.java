package com.bugmaker.service;

import com.bugmaker.bean.Internship;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.Survey;
import com.bugmaker.bean.SurveyResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface StudentServiceXuxu {
    //查询所有志愿（选择志愿列表用）
    ModelAndView selectAllInternshipList(String name, String curr);

    //添加志愿填报
    String addInternship(String internshipId);

    //就业信息调查
    String addSurveyResult(String unit_name, String unit_person, String unit_phone, HttpServletRequest request);

    //查最新调查表
    Survey isUseForSurvey();

    //如果学生已经填写了调查表，根据学生id查询他已填写的调查表。
    SurveyResult selectSurveyByStuId(Student student);
}

package com.bugmaker.service.impl;

import com.bugmaker.bean.*;
import com.bugmaker.mapper.InternshipMapper;
import com.bugmaker.mapper.SurveyMapper;
import com.bugmaker.service.StudentServiceXuxu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("studentServiceXuxu")
public class StudentServiceImplXuxu implements StudentServiceXuxu{

    @Autowired
    private InternshipMapper internshipMapper;

    @Autowired
    private SurveyMapper surveyMapper;

    @Autowired
    @Qualifier("studentServiceXuxu")
    StudentServiceXuxu studentServiceXuxu;

    //查询所有志愿（选择志愿列表用）
    @Override
    public List<Internship> selectAllInternshipList() {
        List<Internship> internshipList = internshipMapper.selectAllInternshipAndTeac();
        return internshipList;
    }

    //模糊查询
    @Override
    public List<Internship> selectInternshipByName(String internshipString) {
        System.out.println("执行模糊查询" + internshipString);
        List<Internship> internshipList = internshipMapper.selectInternshipAndTeacByName(internshipString);
//        for(Internship internship : internshipList){
//            System.out.println(internship);
//        }
        return internshipList;
    }

    //添加志愿填报
    @Override
    public String addInternship(Internship internship) {
        return "" + internshipMapper.insertInternship(internship);
    }

    //添加就业信息调查
    @Override
    public String addSurveyResult(String unit_name, String unit_person, String unit_phone, HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        SurveyResult surveyResult = new SurveyResult();
        surveyResult.setCreateTime(new Date());
        surveyResult.setId(UUID.randomUUID().toString().replace("-",""));
        surveyResult.setUnitName(unit_name);
        surveyResult.setUnitPerson(unit_person);
        surveyResult.setUnitPhone(unit_phone);
        Student student = new Student();
        student.setUser(user);
        student.setId(user.getId());
        surveyResult.setStudent(student);
        surveyResult.setSurvey(studentServiceXuxu.isUseForSurvey());
        System.out.println(surveyResult);
        surveyMapper.insertSurveyResult(surveyResult);
        return "redirect:employmentSurvey.do";
    }

    //查最新调查表
    @Override
    public Survey isUseForSurvey() {
        return surveyMapper.isUseForSurvey();
    }

    //如果学生已经填写了调查表，根据学生id查询他已填写的调查表。
    @Override
    public SurveyResult selectSurveyByStuId(Student student) {
        return surveyMapper.selectSurveyByStuId(student);
    }
}

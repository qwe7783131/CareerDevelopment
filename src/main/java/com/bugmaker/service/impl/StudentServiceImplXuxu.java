package com.bugmaker.service.impl;

import com.bugmaker.bean.Internship;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.Survey;
import com.bugmaker.bean.SurveyResult;
import com.bugmaker.mapper.InternshipMapper;
import com.bugmaker.mapper.SurveyMapper;
import com.bugmaker.service.StudentServiceXuxu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentServiceXuxu")
public class StudentServiceImplXuxu implements StudentServiceXuxu{

    @Autowired
    private InternshipMapper internshipMapper;

    @Autowired
    private SurveyMapper surveyMapper;

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

    //就业信息调查
    @Override
    public String addSurveyResult(SurveyResult surveyResult) {
        return "" + surveyMapper.insertSurveyResult(surveyResult);
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

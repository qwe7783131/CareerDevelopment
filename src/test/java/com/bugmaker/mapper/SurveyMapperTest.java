package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Company;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.Survey;
import com.bugmaker.bean.SurveyResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by guan on 2017/9/21.
 */
public class SurveyMapperTest extends BaseTest {
    @Autowired
    SurveyMapper surveyMapper;

    @Test
    public void selectSurveyByStuIdTest() {
        Student student = new Student();
        student.setId("1");
        SurveyResult surveyResult = surveyMapper.selectSurveyByStuId(student);
        System.out.println(surveyResult);
    }


    @Test
    public void insertSurveyResultTest() {
        SurveyResult surveyResult = new SurveyResult();
        Student student = new Student();
        student.setId("12");
        surveyResult.setStudent(student);
        Survey survey = new Survey();
        survey.setId("12");
        surveyResult.setSurvey(survey);
        surveyResult.setUnitName("中软");
        surveyResult.setId(UUID.randomUUID().toString().replace("-",""));
        surveyResult.setUnitPerson("不知道");
        surveyResult.setUnitPhone("10000");
        surveyResult.setCreateTime(new Date());
        int i = surveyMapper.insertSurveyResult(surveyResult);
        System.out.println(i);
    }

    @Test
    public void isUseForSurveyTest() {
        Survey useForSurvey = surveyMapper.isUseForSurvey();
        System.out.println(useForSurvey);

    }
}

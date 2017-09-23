package com.bugmaker.mapper;

import com.bugmaker.bean.Student;
import com.bugmaker.bean.Survey;
import com.bugmaker.bean.SurveyResult;

/**
 * Created by guan on 2017/9/22.
 */
public interface SurveyMapper {
    /**
     *  判断调查表是否可用，查找最新的那一个调查表
     * @return
     */
    Survey isUseForSurvey();

    /**
     * 插入一条调查结果
     * @return
     */
    int insertSurveyResult(SurveyResult surveyResult);

    /**
     * 如果学生已经填写了调查表，根据学生id查询他已填写的调查表。
     * @param stuId
     * @return
     */
    SurveyResult selectSurveyByStuId(Student stuId);

}

package com.bugmaker.mapper;

import com.bugmaker.bean.Student;
import com.bugmaker.bean.Survey;
import com.bugmaker.bean.SurveyResult;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by guan on 2017/9/22.
 */
public interface SurveyMapper {
    /**
     * 根据学生id判断对应学院的系领导对应的调查表状态
     * @param studentId
     * @return
     */
    Survey selectSurveyStatusAndEnableByStuId(@Param("studentId")String studentId);
    /**
     * 根据调查表id获取对应的调查表的结果
     */
    List<SurveyResult> selectSurveyResyltById(@Param("surveyId") String surveyId);

    /**
     * 插入一条调查表
     */
    int addSurvey(@Param("deptId") String deptId, @Param("createTime")Date createTime);
    /**
     * 设置调查表为共私有
     */
    int surveyStatus(@Param("surveyid") String surveyid,@Param("status")int status);

    /**
     * 设置调查表结束，发布
     */
    int surveyEnable(@Param("surveyid")String surveyid, @Param("enable")int enable);

    /**
     * 通过学院获取所有的调查表
     * @return
     */
    List<Survey> selectAllSurveyByDeptId(@Param("deptId") String deptId);
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

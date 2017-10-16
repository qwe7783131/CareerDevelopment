package com.bugmaker.service;


import com.bugmaker.bean.Survey;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface SurveyService {
    /**
     * 根据调查表id获取对应的调查表的结果
     * @param curr
     * @return
     */
    ModelAndView selectSurveyResyltById(String surveyId,String curr);
    /**
     *  通过当前用户获取学院，在通过学院获取所有的调查表
     * @return
     */
    ModelAndView selectAllSurveyByDeptId(String curr);
    /**
     * 添加调查表
     * @return
     */
    int addSurvey();
    /**
     * 设置调查表为共私有
     * @param surveyid
     * @param status
     * @return
     */
    int surveyStatus(String surveyid, String status);

    /**
     * 设置调查表结束，发布
     * @param surveyid
     * @param enable
     * @return
     */
   int surveyEnable(String surveyid, String enable);

    /**
     * 导出调查结果数据
     */
    void dataExcel(HttpServletRequest request, HttpServletResponse response, String surveyId)throws Exception;
}

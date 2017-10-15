package com.bugmaker.service.impl;

import com.bugmaker.bean.*;
import com.bugmaker.mapper.StuLogMapper;
import com.bugmaker.mapper.SurveyMapper;
import com.bugmaker.service.StuLogService;
import com.bugmaker.service.SurveyService;
import com.bugmaker.utils.RequestUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    SurveyMapper surveyMapper;

    /**
     * 根据调查表id获取对应的调查表的结果
     * @param curr
     * @return
     */
    public ModelAndView selectSurveyResyltById(String surveyId,String curr) {
        int nowPage = Integer.valueOf(curr);
        ModelAndView modelAndView = new ModelAndView();
        User user = RequestUtil.getCurrentUser();
        PageHelper.startPage(nowPage, 5);
        List<SurveyResult> surveyResults = surveyMapper.selectSurveyResyltById(surveyId);
        PageInfo<SurveyResult> page = new PageInfo<>(surveyResults);
        modelAndView.addObject("page",page);
        modelAndView.setViewName("leader/surveyResult");
        return modelAndView;
    }

    /**
     *  通过当前用户获取学院，在通过学院获取所有的调查表
     * @return
     */
    public ModelAndView selectAllSurveyByDeptId(String curr) {
        int nowPage = Integer.valueOf(curr);
        ModelAndView modelAndView = new ModelAndView();
        User user = RequestUtil.getCurrentUser();
        PageHelper.startPage(nowPage, 5);
        List<Survey> surveys = surveyMapper.selectAllSurveyByDeptId(user.getDept().getId());
        PageInfo<Survey> page = new PageInfo<>(surveys);
//        System.out.println(page);
        modelAndView.addObject("page",page);
        modelAndView.setViewName("leader/survey");
        return modelAndView;
    }

    /**
     * 添加调查表
     * @return
     */
    public int addSurvey() {
        User user = RequestUtil.getCurrentUser();
        return surveyMapper.addSurvey(user.getDept().getId(), new Date());
    }

    /**
     * 设置调查表为共私有
     * @param surveyid
     * @param status
     * @return
     */
    public int surveyStatus(String surveyid, String status) {
        return surveyMapper.surveyStatus(surveyid,Integer.valueOf(status));
    }

    /**
     * 设置调查表结束，发布
     * @param surveyid
     * @param enable
     * @return
     */
    public int surveyEnable(String surveyid, String enable) {
        return surveyMapper.surveyEnable(surveyid,Integer.valueOf(enable));
    }
}

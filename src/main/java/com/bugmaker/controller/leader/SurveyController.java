package com.bugmaker.controller.leader;

import com.bugmaker.service.SurveyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by guan on 2017/10/15.
 */
@Controller
@RequestMapping("/leader")
public class SurveyController {
    @Resource
    public SurveyService surveyService;

    /**
     * 跳转到调查结果页面
     */
    @RequestMapping("selectSurveyResyltById.do")
    public ModelAndView selectSurveyResyltById(String surveyId,@RequestParam(defaultValue = "1") String curr) {
        return surveyService.selectSurveyResyltById(surveyId,curr);
    }

    /**
     * 跳转到就业调查页面
     */
    @RequestMapping("toSurvey.do")
    public ModelAndView surveyView(@RequestParam(defaultValue = "1") String curr) {
        return surveyService.selectAllSurveyByDeptId(curr);
    }

    /**
     * 添加调查表
     * @return
     */
    @ResponseBody
    @RequestMapping("addSurvey.do")
    public String addSurvey(){
        return ""+surveyService.addSurvey();
    }

    /**
     * 设置调查表为共有
     * @param surveyid
     * @param status
     * @return
     */
    @ResponseBody
    @RequestMapping("publicSurvey.do")
    public String publicSurvey(String surveyid, String status) {
        return ""+surveyService.surveyStatus(surveyid,status);
    }
    /**
     * 设置调查表为私有
     * @param surveyid
     * @param status
     * @return
     */
    @ResponseBody
    @RequestMapping("privateSurvey.do")
    public String privateSurvey(String surveyid, String status) {
        return ""+surveyService.surveyStatus(surveyid,status);
    }
    /**
     * 设置调查表结束
     * @param surveyid
     * @param enable
     * @return
     */
    @ResponseBody
    @RequestMapping("endSurvey.do")
    public String endSurvey(String surveyid, String enable) {
        return ""+surveyService.surveyEnable(surveyid,enable);
    }
    /**
     * 发布调查表
     * @param surveyid
     * @param enable
     * @return
     */
    @ResponseBody
    @RequestMapping("issueSurvey.do")
    public String issueSurvey(String surveyid, String enable) {
        return ""+surveyService.surveyEnable(surveyid,enable);
    }
    /**
     * 根据id查询调查表的信息
     * @param surveyid
     * @return
     */
    @ResponseBody
    @RequestMapping("selectSurveyResultById.do")
    public String selectSurveyResultById(String surveyid) {
        return "1";
    }

}

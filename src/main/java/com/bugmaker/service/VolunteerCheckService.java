package com.bugmaker.service;

import org.springframework.web.servlet.ModelAndView;

/**
 * Created by guan on 2017/9/27.
 */
public interface VolunteerCheckService {

    /**
     * 审核改变项目志愿的状态
     * @param type 跟岗顶岗
     * @param status  是否通过
     * @return
     */
    int modifyAllInsVolunteerStatus(int type,int status);

    /**
     * 审核改变项目志愿的状态
     * @param insVolunteerId
     * @param status
     * @return
     */
    int modifyInsVolunteerStatus(String insVolunteerId,int status);

    /**
     * 获取数据返回视图到志愿审核页面
     * @return
     */
    ModelAndView toVolunteerCheckPage(int jobType, String professClassId,String internshipId,String curr, String statusId);
}

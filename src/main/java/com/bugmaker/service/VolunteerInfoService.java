package com.bugmaker.service;

import org.springframework.web.servlet.ModelAndView;

public interface VolunteerInfoService {

    /**
     *
     * @param deptId
     * @param directId
     * @param status
     * @param curr
     * @return
     */
    ModelAndView toVolunteerPage(String deptId, String directId, Integer status, String curr);

    ModelAndView toDividePage(String deptId, String directId, String classId, String curr);

    /**
     * 修改志愿状态
     * @param enrollId
     * @param status
     * @param reason
     * @return
     */
    boolean modifyEnrollStatus(String enrollId, Integer status, String reason);

}

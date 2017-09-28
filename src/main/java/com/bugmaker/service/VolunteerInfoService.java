package com.bugmaker.service;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Direction;
import com.bugmaker.bean.Enroll;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

public interface VolunteerInfoService {

    /**
     *
     * @param professclassId
     * @param directId
     * @param status
     * @param curr
     * @return
     */
    ModelAndView toVolunteerPage(String professclassId, String directId, Integer status, String curr);

    ModelAndView toDividePage(String directId, String classId, String curr);

    /**
     * 修改志愿状态
     * @param enrollId
     * @param status
     * @param reason
     * @return
     */
    boolean modifyEnrollStatus(String enrollId, Integer status, String reason);

    List<Map> getAllVolunteerInfo(String deptId);

    List<Direction> selectDirectionByDeptId(String deptId);

    List<Enroll> selectAllEnrollByDirectId(String directId);

    int batchUpdateStudentByEnroll(String dcId, List<Enroll> enrolls);

}

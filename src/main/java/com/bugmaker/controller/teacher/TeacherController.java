package com.bugmaker.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wurenjie on 2017/9/12.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    /**
     * 教师首页
     * @return
     */
    @RequestMapping("index.do")
    public String indexView(){
        return "teacher/index";
    }

    /**
     * 查看学生信息的页面
     * @return
     */
    @RequestMapping("selectStu.do")
    public String selectStuView(){
        return "teacher/selectStu";
    }

    /**
     * 查看教师信息的页面
     * @return
     */
    @RequestMapping("selectTea.do")
    public String selectTeaView(){
        return "teacher/selectTea";
    }

    /**
     * 查看专业负责人信息的页面
     * @return
     */
    @RequestMapping("selectProfessTea.do")
    public String selectProfessTeaView(){
        return "teacher/selectProfessTea";
    }

    /**
     * 查看企业教师信息的页面
     * @return
     */
    @RequestMapping("selectOut.do")
    public String selectOutView(){
        return "teacher/selectOut";
    }

    /**
     * 发布专业方向的页面
     * @return
     */
    @RequestMapping("releaseDirect.do")
    public String releaseDirectView(){
        return "teacher/releaseDirect";
    }

    /**
     * 查看学生志愿填报的页面
     * @return
     */
    @RequestMapping("selectVoluntaryReport.do")
    public String selectVoluntaryReportView(){
        return "teacher/selectVoluntaryReport";
    }

    /**
     * 查看分班名单
     * @return
     */
    @RequestMapping("selectClassDivide.do")
    public String selectClassDivideView(){
        return "teacher/selectClassDivide";
    }
}

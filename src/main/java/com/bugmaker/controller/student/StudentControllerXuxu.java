package com.bugmaker.controller.student;

import com.bugmaker.bean.Internship;
import com.bugmaker.bean.User;
import com.bugmaker.service.StudentService;
import com.bugmaker.service.StudentServiceXuxu;
import com.bugmaker.service.impl.StudentServiceImplXuxu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentControllerXuxu {

    @Autowired
    @Qualifier("studentServiceXuxu")
    StudentServiceXuxu studentServiceXuxu;

    //跳转到填报项目界面，获取所有志愿
    @RequestMapping("student/voluntoryReport.do")
    public String voluntoryReport(ModelMap modelMap){
        List<Internship> voluntaryList = studentServiceXuxu.selectAllInternshipList();
        modelMap.put("voluntaryList",voluntaryList);
        List<Internship> internshipList = studentServiceXuxu.selectAllInternshipList();
        modelMap.put("internshipList",internshipList);
//        for(Internship internship : internshipList){
//            System.out.println(internship);
//        }
        return "student/voluntaryReporting";
    }

    //提交志愿填报



    //模糊查询
    @RequestMapping("student/selectByName.do")
    public String selectByName(ModelMap modelMap, String name, HttpServletRequest request){
        System.out.println("name=" + name);
        List<Internship> voluntaryList = studentServiceXuxu.selectInternshipByName(name);
        modelMap.put("voluntaryList",voluntaryList);
        List<Internship> internshipList = studentServiceXuxu.selectAllInternshipList();
        modelMap.put("internshipList",internshipList);
        return "student/voluntaryReporting";
    }
}

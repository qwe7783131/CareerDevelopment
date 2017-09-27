package com.bugmaker.controller.student;

import com.bugmaker.bean.*;
import com.bugmaker.service.StudentService;
import com.bugmaker.service.StudentServiceXuxu;
import com.bugmaker.service.impl.StudentServiceImplXuxu;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class StudentControllerXuxu {

    @Autowired
    @Qualifier("studentServiceXuxu")
    StudentServiceXuxu studentServiceXuxu;

    //跳转到填报项目界面，获取所有志愿, 包括模糊查询
    @RequestMapping("student/voluntoryReport.do")
    public ModelAndView voluntoryReport(@RequestParam(defaultValue = "")String name, @RequestParam(defaultValue = "1") String curr){
        return studentServiceXuxu.selectAllInternshipList(name, curr);
    }

    @ResponseBody
    @RequestMapping("student/studentAddInternship.do")
    public String studentAddInternship(String insVolunteeId) {
        System.out.println("weishenme "+insVolunteeId);
        return studentServiceXuxu.addInternship(insVolunteeId);
    }


    //添加就业信息调查
    @RequestMapping("student/addSurvey.do")
    public String addSurvey(String unit_name,String unit_person,String unit_phone, HttpServletRequest request) throws IOException {
        return studentServiceXuxu.addSurveyResult(unit_name,unit_person,unit_phone,request);
    }


}

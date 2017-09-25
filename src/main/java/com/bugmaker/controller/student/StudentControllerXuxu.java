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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    //添加就业信息调查
    @RequestMapping("student/addSurvey.do")
    public String addSurvey(String unit_name,String unit_person,String unit_phone, HttpServletRequest request,RedirectAttributes attr) throws IOException {
        System.out.println("添加就业信息");
        //System.out.println(unit_name);
        User user = (User)request.getSession().getAttribute("user");
        SurveyResult surveyResult = new SurveyResult();
        surveyResult.setCreateTime(new Date());
        surveyResult.setId(UUID.randomUUID().toString().replace("-",""));
        surveyResult.setUnitName(unit_name);
        surveyResult.setUnitPerson(unit_person);
        surveyResult.setUnitPhone(unit_phone);
        Student student = new Student();
        student.setUser(user);
        student.setId(user.getId());
        surveyResult.setStudent(student);
        surveyResult.setSurvey(studentServiceXuxu.isUseForSurvey());
        System.out.println(surveyResult);
        studentServiceXuxu.addSurveyResult(surveyResult);
        return "redirect:employmentSurvey.do";
    }


}

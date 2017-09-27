package com.bugmaker.service.impl;

import com.bugmaker.bean.*;
import com.bugmaker.mapper.InsVolunteeMapper;
import com.bugmaker.mapper.InternshipMapper;
import com.bugmaker.mapper.SurveyMapper;
import com.bugmaker.service.StudentServiceXuxu;
import com.bugmaker.utils.RequestUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("studentServiceXuxu")
public class StudentServiceImplXuxu implements StudentServiceXuxu{

    @Autowired
    private InternshipMapper internshipMapper;

    @Autowired
    private InsVolunteeMapper insVolunteeMapper;

    @Autowired
    private SurveyMapper surveyMapper;

    @Autowired
    @Qualifier("studentServiceXuxu")
    StudentServiceXuxu studentServiceXuxu;

    //查询所有志愿（选择志愿列表用）,包括模糊查询
    @Override
    public ModelAndView selectAllInternshipList(String name,String curr) {
        int nowPage = Integer.valueOf(curr);
        ModelAndView modelAndView = new ModelAndView();
        List<Internship> internshipList = internshipMapper.selectAllInternshipAndTeac("");
        modelAndView.addObject("internshipList",internshipList);
        modelAndView.addObject("name",name);

        User currentUser = RequestUtil.getCurrentUser();
        //获取当前用户的状态（判断他是否填写过志愿）
        String insVolunteerStatus = insVolunteeMapper.getInsVolunteerStatus(currentUser.getId());
//        System.out.println("isChooiseEnroll"+isChooseEnroll);
        if (insVolunteerStatus == null){     //学生还没填写过,判断为空必须放前面
            modelAndView.addObject("insVolunteerStatus",3);
        } else if(insVolunteerStatus.equals("0")) {   //0表示志愿不通过
            modelAndView.addObject("insVolunteerStatus", 0);
        } else if(insVolunteerStatus.equals("1")){ //表示志愿已经通过
            modelAndView.addObject("insVolunteerStatus",1);
        } else if(insVolunteerStatus.equals("2")){    //表示志愿待审核
            modelAndView.addObject("insVolunteerStatus",2);
        }

        //获取当前用户的志愿录取情况
        InsVoluntee insVoluntee = insVolunteeMapper.selectInsVolunteerByStuId(currentUser.getId());
//        System.out.println(insVoluntee);
        modelAndView.addObject("insVoluntee",insVoluntee);

        //5条一页
        PageHelper.startPage(nowPage, 5);
        //查询，包括模糊查询
        List<Internship> voluntaryList = internshipMapper.selectAllInternshipAndTeac(name.trim());
        PageInfo<Internship> page = new PageInfo<>(voluntaryList);
        modelAndView.addObject("page",page);
//        System.out.println(page);
        modelAndView.setViewName("student/voluntaryReporting");
        return modelAndView;
    }


    //添加志愿填报
    @Override
    public String addInternship(String internshipId) {
//        System.out.println("internshipId:"+internshipId);
        InsVoluntee insVoluntee = new InsVoluntee();
        User user = RequestUtil.getCurrentUser();
        Student student = new Student();
        student.setId(user.getId());
        insVoluntee.setStudent(student);
        Internship internship = new Internship();
        internship.setId(internshipId);
        insVoluntee.setInternship(internship);
        insVoluntee.setCreateTime(new Date());
//        System.out.println(insVoluntee);
        return "" + insVolunteeMapper.insertInsVolunteer(insVoluntee);
    }

    //添加就业信息调查
    @Override
    public String addSurveyResult(String unit_name, String unit_person, String unit_phone, HttpServletRequest request) {
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
//        System.out.println(surveyResult);
        surveyMapper.insertSurveyResult(surveyResult);
        return "redirect:employmentSurvey.do";
    }

    //查最新调查表
    @Override
    public Survey isUseForSurvey() {
        return surveyMapper.isUseForSurvey();
    }

    //如果学生已经填写了调查表，根据学生id查询他已填写的调查表。
    @Override
    public SurveyResult selectSurveyByStuId(Student student) {
        return surveyMapper.selectSurveyByStuId(student);
    }
}

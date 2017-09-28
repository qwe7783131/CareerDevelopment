package com.bugmaker.service.impl;

import com.bugmaker.bean.InsVoluntee;
import com.bugmaker.bean.Internship;
import com.bugmaker.bean.ProfessionClass;
import com.bugmaker.bean.User;
import com.bugmaker.constant.ProtocolConstant;
import com.bugmaker.mapper.InsVolunteeMapper;
import com.bugmaker.mapper.InternshipMapper;
import com.bugmaker.mapper.ProfessionClassMapper;
import com.bugmaker.service.VolunteerCheckService;
import com.bugmaker.utils.RequestUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by guan on 2017/9/27.
 */
@Service
public class VolunteerCheckServiceImpl implements VolunteerCheckService {

    @Autowired
    private ProfessionClassMapper professionClassMapper;
    @Autowired
    private InternshipMapper internshipMapper;
    @Autowired
    private InsVolunteeMapper insVolunteeMapper;

    /**
     * 审核改变所有项目志愿的状态
     * @param status
     * @return
     */
    public int modifyAllInsVolunteerStatus(int type,int status) {
        return insVolunteeMapper.modifyAllInsVolunteerStatus(type,status);
    }

    /**
     * 审核改变项目志愿的状态
     * @param insVolunteerId
     * @param status
     * @return
     */
    public int modifyInsVolunteerStatus(String insVolunteerId,int status) {
        return insVolunteeMapper.modifyInsVolunteerStatus(insVolunteerId,status);
    }

    /**
     * 获取数据返回视图到志愿审核页面
     * @return
     */
    @Override
    public ModelAndView toVolunteerCheckPage(int jobType,String professClassId,String internshipId,String curr,String statusId) {
//        System.out.println("professClassId"+professClassId);
//        System.out.println("statusId"+statusId);
//        System.out.println("internshipId"+internshipId);
        int nowPage = Integer.valueOf(curr);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("professClassId",professClassId);
        modelAndView.addObject("internshipId",internshipId);
        modelAndView.addObject("statusId",statusId);
        int status = Integer.valueOf(statusId);
        User currentUser = RequestUtil.getCurrentUser();
        //根据学院获取学院里所有专业班级
        //先写死数据，不用从登陆，session的值
        List<ProfessionClass> professClasses = professionClassMapper.getProfessClassByDeptId("e2c3cc8ba07a11e7b4d800163e083221");
        modelAndView.addObject("professClasses",professClasses);

        //根据学院获取所有项目
        //先写死数据，不用从登陆，session的值
        List<Internship> internships = internshipMapper.selectInternshipsByDeptId("e2c3cc8ba07a11e7b4d800163e083221");
        modelAndView.addObject("internships",internships);

        //分页，一页5条数据
        PageHelper.startPage(nowPage, 5);
        //根据学院获取所有学生填报的项目志愿
        System.out.println(jobType);
        List<InsVoluntee> insVoluntees = insVolunteeMapper.selectInsVolunteerByParam("e2c3cc8ba07a11e7b4d800163e083221",
                jobType, professClassId,internshipId, status);
//        System.out.println(insVoluntees);
        PageInfo<InsVoluntee> page = new PageInfo<>(insVoluntees);
//        System.out.println(page.getList());
        modelAndView.addObject("page",page);
//        System.out.println(professClasses);
//        System.out.println(internships);

        return modelAndView;
    }
}

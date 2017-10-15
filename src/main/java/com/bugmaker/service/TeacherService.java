package com.bugmaker.service;

import com.bugmaker.bean.User;
import com.bugmaker.bean.UserRole;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

public interface TeacherService {
    List<User> selectAllTea();

    int deleteTea(String id);

    //修改教师信息
    String updateTea(User user);

    //添加教师角色
    String addTeaRole(UserRole userRole);

    //查询教师信息
    ModelAndView selectTeaByParams(User user,String currentPage);
    
  //获取数据跳转到teacherManage
    ModelAndView getAllTeacher(String currentPage);

    ///////////////////////xuxu//////////////////////
    ModelAndView tointernshipRegistrationManage(String curr);

    ModelAndView getInsVolunteeByDept(String curr,String id);

    ModelAndView tointernshipRegistrationManageIn(String curr);

    ModelAndView getInsVolunteeByDeptIn(String curr,String id);
}

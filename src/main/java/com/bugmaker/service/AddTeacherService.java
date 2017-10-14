package com.bugmaker.service;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.User;
import com.bugmaker.bean.UserRole;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface AddTeacherService {
    String addOneTea(String userStirng) throws IOException;

    int addMulTea(HttpServletRequest request) throws IOException;

    List<Dept> selectAllDept();

    List<User> selectAllTea();

    int deleteTea(String id);

    //修改教师信息
    String updateTea(String userString) throws IOException;

    //添加教师角色
    String addTeaRole(UserRole userRole);

    //查询教师信息
    ModelAndView selectTeaByParams(String id, String username , String dept, String currentPage);

    //获取数据跳转到teacherManage
    ModelAndView teacherManageView(String currentPage);
}

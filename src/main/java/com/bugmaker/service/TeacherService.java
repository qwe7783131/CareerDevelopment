package com.bugmaker.service;

import com.bugmaker.bean.User;
import com.bugmaker.bean.UserRole;

import java.util.List;

public interface TeacherService {
    List<User> selectAllTea();

    int deleteTea(String id);

    //修改教师信息
    String updateTea(User user);

    //添加教师角色
    String addTeaRole(UserRole userRole);

    //查询教师信息
    List<User> selectTeaByParams(User user);

}

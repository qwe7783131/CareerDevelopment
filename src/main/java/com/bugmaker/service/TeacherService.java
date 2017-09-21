package com.bugmaker.service;

import com.bugmaker.bean.User;

import java.util.List;

public interface TeacherService {
    List<User> selectAllTea();

    int deleteTea(String id);

    //修改教师信息
    String updateTea(User user);
}

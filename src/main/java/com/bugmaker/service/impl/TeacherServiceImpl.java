package com.bugmaker.service.impl;

import com.bugmaker.bean.User;
import com.bugmaker.mapper.UserMapper;
import com.bugmaker.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selectTeaService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAllTea() {
        System.out.println("2");
        List<User> userList = userMapper.getAllTeacher();
        for(User user : userList){
            System.out.println("的" + user);
        }
        return  userList;
    }

    @Override
    public int deleteTea(String id) {
        int i = userMapper.deleteUserById(id);
        System.out.println("执行删除impl" + i);
        return i;
    }

    @Override
    public String updateTea(User user) {
        System.out.println("执行修改impl");
        return "" + userMapper.updateUserById(user);
    }
}

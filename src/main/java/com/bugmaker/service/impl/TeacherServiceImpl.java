package com.bugmaker.service.impl;

import com.bugmaker.bean.User;
import com.bugmaker.bean.UserRole;
import com.bugmaker.mapper.UserMapper;
import com.bugmaker.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selectTeaService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private UserMapper userMapper;

    //查询所有老师
    @Override
    public List<User> selectAllTea() {
        //System.out.println("2");
        List<User> userList = userMapper.getAllTeacher();
//        for(User user : userList){
//            System.out.println("的" + user);
//        }
        return  userList;
    }

    //删除教师
    @Override
    public int deleteTea(String id) {
        int i = userMapper.deleteUserById(id);
        //System.out.println("执行删除impl" + i);
        return i;
    }

    //修改教师信息
    @Override
    public String updateTea(User user) {
        System.out.println("执行修改impl" + user);
        return "" + userMapper.updateUserById(user);
    }

    //添加教师角色
    @Override
    public String addTeaRole(UserRole userRole) {
        return "" + userMapper.insertUserRole(userRole);
    }

    //模糊查询
    @Override
    public List<User> selectTeaByParams(User user) {
        List<User> userList = userMapper.selectTeacherByParams(user);
//        for(User users : userList){
//            System.out.println(users);
//        }
        return userList;
    }

}

package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Dept;
import com.bugmaker.bean.User;
import com.bugmaker.constant.UserConstant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserMapperTest extends BaseTest{

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        Dept dept = new Dept();
        dept.setId("11111");
        User user = new User();

        user.setId("201424133209");
        user.setUsername("吴仁杰");
        user.setDept(dept);
        user.setAge(20);

        user.setEnable(1);

        user.setType(UserConstant.StudentType);

        System.out.println(userMapper.insertUser(user));
    }

    @Test
    public void testInserts(){
        Dept dept = new Dept();
        dept.setId("11111");
        List<User> users = new ArrayList<User>();
        for(int i = 0 ; i < 5; i ++){
            User user = new User();

            user.setId("20142413321" + i);
            user.setUsername("吴仁杰" + i);
            user.setDept(dept);
            user.setAge(20);

            user.setEnable(1);

            user.setType(UserConstant.StudentType);

            users.add(user);
        }


        System.out.println(userMapper.insertUsers(users));
    }
}

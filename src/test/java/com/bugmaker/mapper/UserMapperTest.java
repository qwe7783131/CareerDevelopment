package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Role;
import com.bugmaker.bean.User;
import com.bugmaker.bean.UserRole;
import com.bugmaker.constant.UserConstant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserMapperTest extends BaseTest{

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectTeacherByParamsTest() {
        User user = new User();
        user.setUsername("李");
        user.setId("");
        Dept dept = new Dept();
        dept.setId("");
        user.setDept(dept);
        System.out.println(user);
        List<User> users = userMapper.selectTeacherByParams(user);
        for (User user1 :
                users) {
            System.out.println(user1);
        }
    }
    @Test
    public void selectStudentByParamsTest() {
        User user = new User();
        user.setUsername("花");
        List<User> users = userMapper.selectTeacherByParams(user);
        for (User user1 :
                users) {
            System.out.println(user1);
        }
    }

    @Test
    public void insertUserRole() {
        UserRole userRole = new UserRole();
        userRole.setId("5");
        User user = new User();
        user.setId("33");
        Role role = new Role();
        role.setId("23");
        userRole.setUser(user);
        userRole.setRole(role);
        int i = userMapper.insertUserRole(userRole);
        System.out.println(i);
    }

    @Test
    public void selectProfessPrincipalByParams(){
        User user = new User();
        user.setUsername("7");
        List<User> users = userMapper.selectProfessPrincipalByParams(user);
        System.out.println(users);
    }

    @Test
    public void getAllProfessPrincipalTest() {
        List<User> allTeacher = userMapper.getAllProfessPrincipal();
        for (User user :
                allTeacher) {
            System.out.println(user);
        }
    }

    @Test
    public void getAllTeacher() {
        List<User> allTeacher = userMapper.getAllTeacher();
        for (User user :
                allTeacher) {
            System.out.println(user);
        }
    }

    @Test
    public void updateTest() {
        User user = new User();
        user.setId("7");
        user.setPassword("333");
        user.setPassword("1");
        Dept dept = new Dept();
        dept.setId("3");
        user.setDept(dept);
        int i = userMapper.updateUserById(user);
        System.out.println(i);
    }

    @Test
    public void deleteTest() {
        int i = userMapper.deleteUserById("9");
        System.out.println(i);
    }

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

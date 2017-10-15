package com.bugmaker.service.impl;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Role;
import com.bugmaker.bean.User;
import com.bugmaker.bean.UserRole;
import com.bugmaker.mapper.DeptMapper;
import com.bugmaker.mapper.UserMapper;
import com.bugmaker.service.AddTeacherService;
import com.bugmaker.service.LeaderService;
import com.bugmaker.service.ProfessteacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("professteacherImpl")
public class ProfessteacherServiceImpl implements ProfessteacherService{
    @Autowired
    private UserMapper userMapper ;
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    @Qualifier("professteacherImpl")
    ProfessteacherService professteacherService;

    @Autowired
    @Qualifier("teaService")
    AddTeacherService teacherService;

    @Override
    public ModelAndView professteacherManageView(String currentPage) {
        Map<String ,Object> map = new HashMap<String, Object>();
        Integer currPage = Integer.valueOf(currentPage);
        PageHelper.startPage(currPage, 6);
        List<User> selectAllProfessteacher = professteacherService.selectAllProfessteacher();
        PageInfo<User> page = new PageInfo<>(selectAllProfessteacher);
        List<Dept> selectAllDept = professteacherService.selectAllDept();
        map.put("page",page);
        map.put("selectAllDept",selectAllDept);
        return new ModelAndView("/admin/professteacherManage","map",map);
    }

    @Override
    public String addOneProfessteacher(String userString) throws IOException {
        //System.out.println(userString);
        ObjectMapper mapper = new ObjectMapper();
        Map userMap = mapper.readValue(userString, Map.class);
        //System.out.println(userMap);
        Dept dept = new Dept();
        dept.setId(userMap.get("dept").toString());
        User user = new User();
        user.setId(userMap.get("id").toString());
        user.setUsername(userMap.get("username").toString());
        user.setPassword((new Md5Hash(userMap.get("id"),userMap.get("password").toString())).toString());
        user.setSex(userMap.get("sex").toString());
        user.setAge(Integer.valueOf(userMap.get("age").toString()));
        user.setPhone(userMap.get("phone").toString());
        user.setEmail(userMap.get("email").toString());
        user.setDept(dept);
        user.setCreatTime(new Date());
        user.setEnable(1);
        user.setType(6);
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        Role role = new Role();
        role.setId("6");
        userRole.setRole(role);
        teacherService.addTeaRole(userRole);
        return  String.valueOf(userMapper.insertUser(user));
    }



    //查询所有学院
    @Override
    public List<Dept> selectAllDept() {
        List<Dept> deptList = deptMapper.selectAllDept();
        return deptList;
    }

    //查询所有系领导
    @Override
    public List<User> selectAllProfessteacher() {
        //System.out.println("2");
        List<User> userList = userMapper.getAllProfessteacher();
        for(User user : userList){
            System.out.println(user);
        }
        return  userList;
    }

    //修改系领导信息
    @Override
    public String updateProfessteacher(String userString,String id) throws IOException {
//        System.out.println("执行修改controller");
//        System.out.println(userString);
        ObjectMapper mapper = new ObjectMapper();
        Map userMap = mapper.readValue(userString, Map.class);
//        System.out.println(userMap);
        Dept dept = new Dept();
        dept.setId(userMap.get("dept").toString());
        User user = new User();
        user.setId(id);
        user.setUsername(userMap.get("username").toString());
        if(userMap.get("password").toString()!=null&&userMap.get("password").toString()!="") {
            user.setPassword((new Md5Hash(id, userMap.get("password").toString())).toString());
        }
        user.setSex(userMap.get("sex").toString());
        user.setAge(Integer.valueOf(userMap.get("age").toString()));
        user.setPhone(userMap.get("phone").toString());
        user.setEmail(userMap.get("email").toString());
        user.setDept(dept);
        user.setCreatTime(new Date());
        user.setEnable(1);
        user.setType(6);
//        System.out.println(user);
        return "" + userMapper.updateUserById(user);
    }

    //删除系领导
    public int deleteProfessteacher(String id) {
        int i = userMapper.deleteUserById(id);
        return i;
    }

    //模糊查询
    @Override
    public ModelAndView selectProfessteacherByParams(String id, String username , String dept, String currentPage) {
//        System.out.println("id:" + id + "username" + username + "dept" + dept);
        Map<String ,Object> map = new HashMap<String, Object>();
        User user = new User();
        user.setUsername(username);
        Dept dept1 = new Dept();
        dept1.setId(dept);
        user.setDept(dept1);
        user.setId(id);
        Integer currPage = Integer.valueOf(currentPage);
        PageHelper.startPage(currPage, 6);
        List<User> userList = userMapper.selectLeaderByParams(user);
        PageInfo<User> page = new PageInfo<>(userList);
//        for(User user1 : userList){
//            System.out.println(user1);
//        }
        map.put("page",page);
        List<Dept> selectAllDept = teacherService.selectAllDept();
        map.put("selectAllDept",selectAllDept);
        if(id.equals("") && username.equals("") && dept.equals("")){
            return new ModelAndView("redirect:/admin/leaderManage.do","map",map);
        }
        else {
            return new ModelAndView("/admin/leaderManage","map",map);
        }
    }
}

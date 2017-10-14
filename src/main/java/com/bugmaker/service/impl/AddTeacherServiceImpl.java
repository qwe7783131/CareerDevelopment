package com.bugmaker.service.impl;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Role;
import com.bugmaker.bean.User;
import com.bugmaker.bean.UserRole;
import com.bugmaker.mapper.DeptMapper;
import com.bugmaker.mapper.UserMapper;
import com.bugmaker.service.AddTeacherService;
import com.bugmaker.utils.UploadUtil;
import com.bugmaker.utils.XslResolveUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.fileupload.FileItem;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service("teaService")
public class AddTeacherServiceImpl implements AddTeacherService {
    @Autowired
    private UserMapper userMapper ;
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    @Qualifier("teaService")
    AddTeacherService teacherService;

    public void setDeptMapper(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //添加单个教师
    @Override
    public String addOneTea(String userString) throws IOException {
        //System.out.println(userString);
        ObjectMapper mapper = new ObjectMapper();
        Map userMap = mapper.readValue(userString, Map.class);
        //System.out.println(userMap);
        Dept dept = new Dept();
        dept.setId(userMap.get("dept").toString());
        User user = new User();
        user.setId(userMap.get("id").toString());
        user.setUsername(userMap.get("username").toString());
        user.setPassword((new Md5Hash(userMap.get("id").toString(),userMap.get("password").toString())).toString());
        user.setSex(userMap.get("sex").toString());
        user.setAge(Integer.valueOf(userMap.get("age").toString()));
        user.setPhone(userMap.get("phone").toString());
        user.setEmail(userMap.get("email").toString());
        user.setDept(dept);
        user.setCreatTime(new Date());
        user.setEnable(Integer.parseInt(userMap.get("enable").toString()));
        user.setType(2);
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        Role role = new Role();
        role.setId("2");
        userRole.setRole(role);
        teacherService.addTeaRole(userRole);
        return  String.valueOf(userMapper.insertUser(user));
    }

    //批量添加教师
    @Override
    public int addMulTea(HttpServletRequest request) throws IOException {
        int result =0;
        List<FileItem> fileItems = UploadUtil.getUploadFileStream(request);
        List<User> teachers = null;
        for(FileItem fileItem : fileItems){
            if(!fileItem.isFormField()){
                InputStream in = fileItem.getInputStream();
                List<Dept> depts = new ArrayList<Dept>();
                teachers = XslResolveUtil.getTeachersFromXSL(in,depts);
                //数据库插入出错的话没处理，会全部插入失败
                result = userMapper.insertUsers(teachers);
                for (User teacher : teachers){
                    System.out.println(teacher.getAge());
                }
            }
        }
        return result;
    }

    //查询所有学院
    @Override
    public List<Dept> selectAllDept() {
        List<Dept> deptList = deptMapper.selectAllDept();
        return deptList;
    }

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
    public String updateTea(String userString) throws IOException {
        System.out.println("执行修改controller");
        System.out.println(userString);
        ObjectMapper mapper = new ObjectMapper();
        Map userMap = mapper.readValue(userString, Map.class);
        System.out.println(userMap);
        Dept dept = new Dept();
        dept.setId(userMap.get("dept").toString());
        com.bugmaker.bean.User user = new User();
        user.setId(userMap.get("id").toString());
        user.setUsername(userMap.get("username").toString());
        user.setPassword((new Md5Hash(userMap.get("id").toString(),userMap.get("password").toString())).toString());
        user.setSex(userMap.get("sex").toString());
        user.setAge(Integer.valueOf(userMap.get("age").toString()));
        user.setPhone(userMap.get("phone").toString());
        user.setEmail(userMap.get("email").toString());
        user.setDept(dept);
        user.setCreatTime(new Date());
        user.setEnable(Integer.parseInt(userMap.get("enable").toString()));
        user.setType(2);
        return "" + userMapper.updateUserById(user);
    }

    //添加教师角色
    @Override
    public String addTeaRole(UserRole userRole) {
        return "" + userMapper.insertUserRole(userRole);
    }

    //模糊查询
    @Override
    public ModelAndView selectTeaByParams(String id, String username , String dept, String currentPage) {
        Map<String ,Object> map = new HashMap<String, Object>();
        User user = new User();
        user.setUsername(username);
        Dept dept1 = new Dept();
        dept1.setId(dept);
        user.setDept(dept1);
        user.setId(id);
        Integer currPage = Integer.valueOf(currentPage);
        PageHelper.startPage(currPage, 6);
        List<User> userList = userMapper.selectTeacherByParams(user);
        PageInfo<User> page = new PageInfo<>(userList);
        map.put("page",page);
        List<Dept> selectAllDept = teacherService.selectAllDept();
        map.put("selectAllDept",selectAllDept);
        if(id.equals("") && username.equals("") && dept.equals("")){
            return new ModelAndView("redirect:/admin/teacherManage.do","map",map);
        }
        else {
            return new ModelAndView("/admin/teacherManage","map",map);
        }
    }

    //获取数据跳转到teacherManage
    public ModelAndView teacherManageView(String currentPage){
        Map<String ,Object> map = new HashMap<String, Object>();
        Integer currPage = Integer.valueOf(currentPage);
        PageHelper.startPage(currPage, 6);
        List<User> selectAllTea = teacherService.selectAllTea();
        PageInfo<User> page = new PageInfo<>(selectAllTea);
        List<Dept> selectAllDept = teacherService.selectAllDept();
        map.put("page",page);
        map.put("selectAllDept",selectAllDept);
        return new ModelAndView("/admin/teacherManage","map",map);
    }
}

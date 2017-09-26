package com.bugmaker.service.impl;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.User;
import com.bugmaker.bean.UserRole;
import com.bugmaker.mapper.DeptMapper;
import com.bugmaker.mapper.UserMapper;
import com.bugmaker.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

@Service("selectTeaService")
public class TeacherServiceImpl implements TeacherService {
	@Resource
    private UserMapper userMapper;
	@Resource
	private DeptMapper deptMapper;
	 

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
    public ModelAndView selectTeaByParams(User user,String currentPage) {
    	Map<String ,Object> map = new HashMap<String, Object>();
        
        Integer currPage = Integer.valueOf(currentPage);
        PageHelper.startPage(currPage, 6);
        List<User> userList = userMapper.selectTeacherByParams(user);
        PageInfo<User> page = new PageInfo<>(userList);
        map.put("page",page);
        List<Dept> selectAllDept = deptMapper.selectAllDept();
        map.put("selectAllDept",selectAllDept);
        
        return new ModelAndView("teacher/selectTea","map",map);
        
    }

	@Override
	public ModelAndView getAllTeacher(String currentPage) {
		Map<String ,Object> map = new HashMap<String, Object>();
		List<Dept> selectAllDept = deptMapper.selectAllDept();
        Integer currPage = Integer.valueOf(currentPage);
        PageHelper.startPage(currPage, 5);
        List<User> selectAllTea = userMapper.getAllTeacher();
        PageInfo<User> page = new PageInfo<>(selectAllTea);
        
        map.put("page",page);
        map.put("selectAllDept",selectAllDept);
        return new ModelAndView("teacher/selectTea","map",map);
	}

}

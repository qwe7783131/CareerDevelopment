package com.bugmaker.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.User;
import com.bugmaker.mapper.UserMapper;
import com.bugmaker.service.ProfessPrincipalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ProfessPrincipalServiceImpl implements ProfessPrincipalService{
	@Resource
	private UserMapper userMapper;

	@Override
	public ModelAndView getAllProfessPrincipal(String curr) {
		
		int nowPage = Integer.valueOf(curr);
		
		PageHelper.startPage(nowPage, 5);
				
		List<User> users = userMapper.getAllProfessPrincipal();
		//System.out.println(users);
		PageInfo<User> page = new PageInfo<>(users);
		return new ModelAndView("teacher/selectProfessTea", "page", page);
	}

	@Override
	public List<User> selectTeacherByParams(User user) {
		List<User> users = userMapper.selectProfessPrincipalByParams(user);
		return users;
	}

	

}

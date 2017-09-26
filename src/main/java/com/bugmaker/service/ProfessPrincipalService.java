package com.bugmaker.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.User;

public interface ProfessPrincipalService {
	//查询所有的专业负责人
	ModelAndView getAllProfessPrincipal(String curr);
	 List<User> selectTeacherByParams(User user);

}

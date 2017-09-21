package com.bugmaker.service;

import org.springframework.web.servlet.ModelAndView;

public interface AdminService {

	//添加单个学生信息
	ModelAndView toAddOneStudentPage(String deptId);

}

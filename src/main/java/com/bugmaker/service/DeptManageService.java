package com.bugmaker.service;


import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Dept;


public interface DeptManageService {
	//分页查询数据并返回视图
	ModelAndView getDeptsPage(String curr);

	//添加一个学院的信息
	int addOneDept(Dept dept);

	//修改学院信息
	int modifyDept(Dept dept);

	//删除学院
	int deleteDept(String deptId);
}

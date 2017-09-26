package com.bugmaker.service;

import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Direction;

public interface DirectionManageService {

	//查询数据并返回视图
	ModelAndView toDirectionManagePage(String curr);

	//添加专业方向信息
	int addDirection(Direction direction);

	//根据方向id查询方向信息并返回视图
	ModelAndView toModifyDirectPage(String directId);

	//修改专业方向信息
	int modifyDirection(Direction direction);

	//删除专业方向信息
	int deleteDirection(String directId);

}

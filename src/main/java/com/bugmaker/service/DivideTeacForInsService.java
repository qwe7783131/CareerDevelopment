package com.bugmaker.service;

import org.springframework.web.servlet.ModelAndView;

public interface DivideTeacForInsService {

	//返回顶岗教师分配页面视图
	ModelAndView toDivideTeachDinggang(String insId);

	/**
	 * 分配教师
	 * @param insId 
	 * @param teacIds 
	 * @return 分配成功与否
	 */
	int diviTeachers(String[] teacIds, String insId);

}

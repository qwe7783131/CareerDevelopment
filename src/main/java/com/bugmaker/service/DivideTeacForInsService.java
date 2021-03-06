package com.bugmaker.service;

import org.springframework.web.servlet.ModelAndView;

public interface DivideTeacForInsService {

	//返回顶岗教师分配页面视图
	ModelAndView toDivideTeachDinggang(String insId, String status, String curr1, String curr2, String curr3);

	/**
	 * 分配教师
	 * @param insId 
	 * @param teacIds 
	 * @param type 
	 * @return 分配成功与否
	 */
	int diviTeachers(String[] teacIds, String insId, String type);

}

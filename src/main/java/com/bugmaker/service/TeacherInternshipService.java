package com.bugmaker.service;

import org.springframework.web.servlet.ModelAndView;

public interface TeacherInternshipService {
	
	//根据学院id查询实习项目
	ModelAndView selectInternshipsByDeptId(String deptId);

}

package com.bugmaker.service;



import org.springframework.web.servlet.ModelAndView;





public interface TeacherInternshipService {
	
	//根据学院id查询实习项目
	ModelAndView tSelectInternshipsByDeptId(String curr);
	
	//插入教师填报的实习项目
	public int addTeacIns(String internshipID);
	
	
}

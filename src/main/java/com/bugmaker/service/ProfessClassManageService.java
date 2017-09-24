package com.bugmaker.service;

import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.ProfessionClass;

public interface ProfessClassManageService {

	ModelAndView toProfessClaPage(String deptId, String professId, String curr);

	//添加专业班级
	int addProfessClass(ProfessionClass professionClass);

	//修改专业班级名称
	int modifyProfessCla(ProfessionClass professionClass);

	//删除专业班级
	int deleteProfessCla(String professClaId);

}

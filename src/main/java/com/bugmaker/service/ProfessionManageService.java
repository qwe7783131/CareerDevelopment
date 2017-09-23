package com.bugmaker.service;

import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Profession;

public interface ProfessionManageService {

	//获取所有的专业
	ModelAndView getAllProfessions(String deptId,String curr);

	//添加专业
	int addProfession(Profession profession);

	//修改专业名称
	int modifyProfession(Profession profession);

	//删除专业
	int deleteProfession(String professId);

}

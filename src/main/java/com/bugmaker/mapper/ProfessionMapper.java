package com.bugmaker.mapper;

import java.util.List;

import com.bugmaker.bean.Profession;

public interface ProfessionMapper {

	//获得所有专业
	List<Profession> getAllProfessions();
	
	//获取所有专业外加学院
	List<Profession> getAllProfessionsAndDept();

	//通过学院id获取专业列表
	List<Profession> getProfessionsByDeptID(String deptId);

	//添加专业
	int insertProfession(Profession profession);

	//修改专业名称
	int modifyProfession(Profession profession);

	//删除专业
	int deleteProfession(String professId);

	//根据专业id获取专业
	Profession selectProfessById(String professId);
}

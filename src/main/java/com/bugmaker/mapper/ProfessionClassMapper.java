package com.bugmaker.mapper;

import java.util.List;

import com.bugmaker.bean.ProfessionClass;

public interface ProfessionClassMapper {

	//获得所有班级
	List<ProfessionClass> getAllProfessClass();

	//根据deptid查询专业班级
	List<ProfessionClass> getProfessClassByDeptId(String deptId);
}

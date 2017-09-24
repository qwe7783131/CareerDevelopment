package com.bugmaker.mapper;

import java.util.List;

import com.bugmaker.bean.ProfessionClass;

public interface ProfessionClassMapper {

	//获得所有班级
	List<ProfessionClass> getAllProfessClass();

	//根据deptid查询专业班级
	List<ProfessionClass> getProfessClassByDeptId(String deptId);

	//根据专业id查询专业班级
	List<ProfessionClass> selectProfessClasByProfessId(String professId);

	//添加专业班级
	int addProfessClass(ProfessionClass professionClass);

	//修改专业班级名称
	int modifyProfessCla(ProfessionClass professionClass);

	//通过id删除专业班级
	int deleteProfessClaById(String professClaId);
}

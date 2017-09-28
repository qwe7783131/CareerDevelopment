package com.bugmaker.mapper;

import java.util.List;

import com.bugmaker.bean.TeacIns;
import com.bugmaker.bean.TeacherInternship;

public interface TeacherInternshipMapper {
	
	 // 插入教师选的负责的实习项目	 
	int insertTeacIns(TeacIns teacIns);
	
	// 根据教师的id查询录取情况
	//List<TeacIns> getTeacInsByTeacherId(String teacherId);
	//List<TeacherInternship> getTeacInsByTeacherId(String teacherId);
	TeacherInternship getTeacInsByTeacherId(String teacherId);

}

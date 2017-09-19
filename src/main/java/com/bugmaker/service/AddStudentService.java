package com.bugmaker.service;

import javax.servlet.http.HttpServletRequest;

import com.bugmaker.bean.Student;

public interface AddStudentService {

	//添加单个学生
	int addOneStudent(Student student);

	//批量添加
	int addMulyiStus(HttpServletRequest request) throws Exception;
	
}

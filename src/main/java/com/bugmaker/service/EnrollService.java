package com.bugmaker.service;

import com.bugmaker.bean.Enroll;
import com.bugmaker.bean.Student;

import javax.servlet.http.HttpServletRequest;

public interface EnrollService {

	/**
	 * 插入学生填报志愿
	 * @param directId
	 * @return
     */
	int insertEnroll(String directId);
	
}

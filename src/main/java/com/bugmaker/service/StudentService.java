package com.bugmaker.service;

import com.bugmaker.bean.Student;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;


public interface StudentService {
	
	//查询所有学生
	ModelAndView selectAllStudent(String currentPage);
	
	//多条件查询学生， 可通过学生id，模糊姓名，学院，班级查询
	public List<Student> selectStudentByParams(Student student);

	/**
	 * 查看我的宿舍安排
	 * @param insType
	 * @param curr 
	 * @return
	 */
	ModelAndView toWatchMyDorm(String insType, String curr);
	
}

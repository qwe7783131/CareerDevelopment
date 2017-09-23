package com.bugmaker.service;

import com.bugmaker.bean.Student;

import java.util.List;


public interface StudentService {
	
	//查询所有学生
	public List<Student> selectAllStudent();
	
	//多条件查询学生， 可通过学生id，模糊姓名，学院，班级查询
	public List<Student> selectStudentByParams(Student student);
	
}

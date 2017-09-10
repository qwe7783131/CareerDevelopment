package com.bugmaker.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bugmaker.bean.Student;
import com.bugmaker.mapper.StudentMapper;
import com.bugmaker.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Resource
	private StudentMapper studentMapper;
	
	public List<Student> selectAllStudent() {
		List<Student> students = studentMapper.selectAllStudent();
		return students;
	}

}

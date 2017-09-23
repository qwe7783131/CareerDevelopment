package com.bugmaker.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bugmaker.bean.Student;
import com.bugmaker.service.StudentService;
import org.springframework.stereotype.Service;

import com.bugmaker.mapper.StudentMapper;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Resource
	private StudentMapper studentMapper;
	
	public List<Student> selectAllStudent() {
		List<Student> students = studentMapper.selectAllStudent();
		return students;
	}

	@Override
	public List<Student> selectStudentByParams(Student student) {
		List<Student> students = studentMapper.selectStudentByParams(student);
		return students;
	}

}

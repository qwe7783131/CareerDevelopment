package com.bugmaker.service.impl.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bugmaker.service.impl.StudentService;
import org.springframework.stereotype.Service;

import com.bugmaker.bean.Student;
import com.bugmaker.mapper.StudentMapper;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Resource
	private StudentMapper studentMapper;
	
	public List<Student> selectAllStudent() {
		List<Student> students = studentMapper.selectAllStudent();
		return students;
	}

}

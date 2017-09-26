package com.bugmaker.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bugmaker.bean.Outteacher;
import com.bugmaker.bean.Student;
import com.bugmaker.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.mapper.StudentMapper;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Resource
	private StudentMapper studentMapper;
	
	public ModelAndView selectAllStudent(String currentPage) {
		int nowPage = Integer.valueOf(currentPage);
		PageHelper.startPage(nowPage, 5);
		List<Student> students = studentMapper.selectAllStudent();
		PageInfo<Student> page = new PageInfo<>(students);
		return new ModelAndView("teacher/selectStu", "page", page);
	}

	@Override
	public List<Student> selectStudentByParams(Student student) {
		List<Student> students = studentMapper.selectStudentByParams(student);
		return students;
	}

}

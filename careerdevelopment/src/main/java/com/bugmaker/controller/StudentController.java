package com.bugmaker.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bugmaker.bean.Student;
import com.bugmaker.service.impl.StudentService;

@Controller
public class StudentController {
	
	@Resource
	public StudentService studentService;
	
	@RequestMapping("test.do")
	public String testcontroller(ModelMap model) {
		List<Student> selectAllStudent = studentService.selectAllStudent();
		model.put("selectAllStudent", selectAllStudent);
		return "index";
	}
}

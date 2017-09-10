package com.bugmaker.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bugmaker.bean.Student;
import com.bugmaker.service.StudentService;

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

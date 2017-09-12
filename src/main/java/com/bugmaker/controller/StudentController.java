package com.bugmaker.controller;


import com.bugmaker.bean.Student;
import com.bugmaker.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

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
	
	@RequestMapping("admin.do")
 	public String admin(ModelMap model) {
		
		return "admin/admin";
	}
	@RequestMapping("counselor.do")
 	public String counselor(ModelMap model) {
		
		return "counselor/counselor";
	}
	@RequestMapping("leader.do")
 	public String leader(ModelMap model) {
		
		return "leader/leader";
	}
	@RequestMapping("outteacher.do")
 	public String outteacher(ModelMap model) {
		
		return "outteacher/outteacher";
	}
	@RequestMapping("professionTeacher.do")
 	public String professionTeacher(ModelMap model) {
		
		return "professionTeacher/professionTeacher";
	}
	@RequestMapping("teacher.do")
 	public String teacher(ModelMap model) {
		
		return "teacher/teacher";
	}
}

package com.bugmaker.controller.student;


import com.bugmaker.bean.Student;
import com.bugmaker.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Resource
	public StudentService studentService;
	@RequestMapping("test.do")
 	public String testcontroller(ModelMap model) {
		List<Student> selectAllStudent = studentService.selectAllStudent();
		model.put("selectAllStudent", selectAllStudent);
		return "index";
	}

	@RequestMapping("index.do")
	public String indexView(){
		return "student/index1";
	}
}

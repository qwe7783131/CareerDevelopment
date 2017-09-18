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
		return "student/index";
	}
	
	 /**
     * 学生文档上传
     * @return
     */
	@RequestMapping("documentUpload.do")
	public String documentUpload(){
		return "student/documentUpload";
	}
	/**
     * 学生就业调查页面
     * @return
     */
	@RequestMapping("employmentSurvey.do")
	public String employmentSurvey(){
		return "student/employmentSurvey";
	}
	/**
     * 学生查询个人成绩页面
     * @return
     */
	@RequestMapping("selectScoreStu.do")
	public String selectScoreStu(){
		return "student/selectScoreStu";
	}
	/**
     * 学生查看指导老师页面
     * @return
     */
	@RequestMapping("teacherRU.do")
	public String teacherRU(){
		return "student/teacherRU";
	}
	/**
     * 学生申请转指导老师页面
     * @return
     */
	@RequestMapping("teacherU.do")
	public String teacherU(){
		return "student/teacherU";
	}
	/**
     * 学生填报志愿页面
     * @return
     */
	@RequestMapping("voluntaryReporting.do")
	public String voluntaryReporting(){
		return "student/voluntaryReporting";
	}
}

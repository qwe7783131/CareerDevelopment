package com.bugmaker.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bugmaker.bean.Student;
import com.bugmaker.service.AddStudentService;

@Controller
public class AddStudentController {

	@Resource
	private AddStudentService addStudentService;
	
	/**
	 * 添加单个学生的控制器
	 * @param student 请求正文参数封装为student对象
	 * @return  返回前台结果
	 */
	@ResponseBody
	@RequestMapping(value = "addOneStu.do", method = RequestMethod.POST)
	public String addOneStu(@RequestBody Student student){
		
		return ""+addStudentService.addOneStudent(student);
	}
	
	/**
	 * 导入表格添加学生控制器
	 * @param request 请求
	 * @return 返回前台结果
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "addMulyiStus", method = RequestMethod.POST)
	public String addMulyiStus(HttpServletRequest request) throws Exception{
		return ""+addStudentService.addMulyiStus(request);
	}
}

package com.bugmaker.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.bugmaker.bean.Student;
import com.bugmaker.service.AddStudentService;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class AddStudentController {

	@Resource
	private AddStudentService studentService;

	//获取数据跳转到studentManage
	@RequestMapping("/admin/studentManage.do")
	public ModelAndView studentManageView(@RequestParam(defaultValue="1") String currentPage) {
		return studentService.studentManageView(currentPage);
	}
	
	/**
	 * 添加单个学生的控制器
	 * @param student 请求正文参数封装为student对象
	 * @return  返回前台结果
	 */
	@ResponseBody
	@RequestMapping(value = "addOneStu.do", method = RequestMethod.POST)
	public String addOneStu(@RequestBody Student student){
		return ""+ studentService.addOneStudent(student);
	}
	
	/**
	 * 导入表格添加学生控制器
	 * @param request 请求
	 * @return 返回前台结果
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "addMulyiStus.do", method = RequestMethod.POST)
	public String addMulyiStus(HttpServletRequest request) throws Exception{
		return ""+ studentService.addMulyiStus(request);
	}

	//跳转到modifyStudent
	@RequestMapping("/admin/modifyStudent.do")
	public ModelAndView modifyStudent(){
		return studentService.modifyStu();
	}

	//修改学生信息
	@RequestMapping(value = "/admin/modifyStudentImpl.do", method = RequestMethod.POST)
	@ResponseBody
	public String modifyStudentImpl(@RequestBody String userString) throws IOException {
//		System.out.println(userString);
		return String.valueOf(studentService.modifyStudentImpl(userString));
	}

	//模糊查询
	@RequestMapping("/admin/studentManage2.do")
	public ModelAndView studentManage2View(String id,String username ,String dept,@RequestParam(defaultValue="1") String currentPage){
		return studentService.selectStuByParams(id,username,dept,currentPage);
	}
}

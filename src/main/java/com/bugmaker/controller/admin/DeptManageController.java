package com.bugmaker.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Dept;
import com.bugmaker.service.DeptManageService;

@Controller
public class DeptManageController {

	/**
	 * 跳转到学院管理页面，并分页查询出数据
	 */
	@Resource
	private DeptManageService deptManageService;
	@RequestMapping("toDeptManegePage.do")
	public ModelAndView toDeptManegePage(@RequestParam(defaultValue="1") String curr){
		return deptManageService.getDeptsPage(curr);
	}
	
	@ResponseBody
	@RequestMapping("addOneDept.do")
	public String addOneDept(@RequestBody Dept dept){
		return ""+deptManageService.addOneDept(dept);
	}
	
	/**
	 * 修改学院名
	 * @param dept 客户端传回待修改的Dept
	 * @return 执行结果
	 */
	@ResponseBody
	@RequestMapping("modifyDept.do")
	public String modifyDept(@RequestBody Dept dept){
		return ""+deptManageService.modifyDept(dept);
	}
	
	/**
	 * 删除指定deptId的学院
	 * @param deptId  客户端发送的deptId
	 * @return 返回结果
	 */
	@ResponseBody
	@RequestMapping("deleteDept.do")
	public String deleteDept(@RequestParam String deptId){
		return ""+deptManageService.deleteDept(deptId);
	}
}

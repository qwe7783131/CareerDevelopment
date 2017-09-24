package com.bugmaker.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.ProfessionClass;
import com.bugmaker.service.ProfessClassManageService;

@Controller
public class ProfessClassManageController {

	@Resource
	private ProfessClassManageService professClassManageService;
	
	/**
	 * 转到专业班级管理
	 * @param deptId 学院id
	 * @param professId 专业id
	 * @param curr 第几页
	 * @return
	 */
	@RequestMapping("toProfessClaPage.do")
	public ModelAndView toProfessClaPage(@RequestParam(required=false) String deptId,@RequestParam(required=false) String professId,@RequestParam(defaultValue="1") String curr){
		return professClassManageService.toProfessClaPage(deptId,professId,curr);
	}
	
	/**
	 * 添加专业班级
	 * @param professionClass 接收客户端的ProfessionClass对象
	 * @return 返回结果
	 */
	@ResponseBody
	@RequestMapping("addProfessClass.do")
	public String addProfessClass(@RequestBody ProfessionClass professionClass){
		return ""+professClassManageService.addProfessClass(professionClass);
	}
	
	/**
	 * 修改专业班级名称
	 * @param professionClass 接收客户端的professionClass对象
	 * @return 返回结果
	 */
	@ResponseBody
	@RequestMapping("modifyProfessCla.do")
	public String modifyProfessCla(@RequestBody ProfessionClass professionClass){
		return ""+professClassManageService.modifyProfessCla(professionClass);
	}
	
	/**
	 * 删除专业班级
	 * @return 返回结果
	 */
	@ResponseBody
	@RequestMapping("deleteProfessCla.do")
	public String deleteProfessCla(@RequestParam String professClaId){
		return ""+professClassManageService.deleteProfessCla(professClaId);
	}
}

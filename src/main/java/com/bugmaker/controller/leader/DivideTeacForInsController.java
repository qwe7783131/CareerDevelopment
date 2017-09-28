package com.bugmaker.controller.leader;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.service.DivideTeacForInsService;

@Controller
public class DivideTeacForInsController {

	@Resource
	private DivideTeacForInsService divideTeacForInsService;
	
	/**
	 * 跳转到顶岗教师分配页面
	 * @return
	 */
	@RequestMapping("toDivideTeachDinggang.do")
	public ModelAndView toDivideTeachDinggang(@RequestParam(required=false) String insId){
		return divideTeacForInsService.toDivideTeachDinggang(insId);
	}
	
	/**
	 * 分配教师
	 * @param teacIds  
	 * @return
	 */
	@ResponseBody
	@RequestMapping("diviTeachers.do")
	public String diviTeachers(@RequestParam String[] teacIds, @RequestParam String insId){
		return ""+divideTeacForInsService.diviTeachers(teacIds,insId);
	}
}

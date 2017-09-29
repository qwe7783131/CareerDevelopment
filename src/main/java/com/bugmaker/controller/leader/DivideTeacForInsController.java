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
	public ModelAndView toDivideTeachDinggang(@RequestParam(required=false) String insId,
			@RequestParam(required=false) String status,
			@RequestParam(defaultValue="1") String curr1, 
			@RequestParam(defaultValue="1") String curr2, 
			@RequestParam(defaultValue="1") String curr3){
		return divideTeacForInsService.toDivideTeachDinggang(insId,status,curr1,curr2,curr3);
	}
	
	/**
	 * 分配教师
	 * @param teacIds  
	 * @return
	 */
	@ResponseBody
	@RequestMapping("diviTeachers.do")
	public String diviTeachers(@RequestParam String[] teacIds, @RequestParam String insId, @RequestParam String type){
		return ""+divideTeacForInsService.diviTeachers(teacIds,insId,type);
	}
}

package com.bugmaker.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Profession;
import com.bugmaker.service.ProfessionManageService;

@Controller
public class ProfessionManageController {

	@Resource
	private ProfessionManageService professionManageService;
	
	/**
	 * 跳转到专业管理页面
	 * @return
	 */
	@RequestMapping("toprofessionManagePage.do")
	public ModelAndView toprofessionManagePage(@RequestParam(required=false) String deptId, @RequestParam(defaultValue="1") String curr){
		return professionManageService.getAllProfessions(deptId,curr);
	}
	
	/**
	 * 添加专业
	 * @param profession 接收客户端返回的profession对象
	 * @return 返回结果
	 */
	@ResponseBody
	@RequestMapping("addProfession.do")
	public String addProfession(@RequestBody Profession profession){
		return ""+professionManageService.addProfession(profession);
	}
	
	/**
	 * 修改专业名称
	 * @param profession 接收客户端发送的profession对象
	 * @return 返回结果
	 */
	@ResponseBody
	@RequestMapping("modifyProfession.do")
	public String modifyProfession(@RequestBody Profession profession){
		return ""+professionManageService.modifyProfession(profession);
	}
	
	/**
	 * 删除专业
	 * @param professId 接收客户端发送的专业id
	 * @return 返回结果
	 */
	@ResponseBody
	@RequestMapping("deleteProfession.do")
	public String deleteProfession(@RequestParam String professId){
		return ""+professionManageService.deleteProfession(professId);
	}
}

package com.bugmaker.controller.leader;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Direction;
import com.bugmaker.service.DirectionManageService;

@Controller
public class DirectionManageController {

	@Resource
	private DirectionManageService directionManageService;
	
	/**
	 * 跳转到专业方向管理页面
	 */
	@RequestMapping("toDirectionManagePage.do")
	public ModelAndView toDirectionManagePage(@RequestParam(defaultValue="1")String curr){
		return directionManageService.toDirectionManagePage(curr);
	}
	
	/**
	 * 发布专业方向信息
	 * @return 返回发布结果
	 */
	@ResponseBody
	@RequestMapping("addDirection.do")
	public String addDirection(@RequestBody Direction direction){
		return ""+directionManageService.addDirection(direction);
	}
	
	/**
	 * 跳转到修改专业方向信息的页面
	 * @param directId 客户端发送的数据
	 * @return 返回视图
	 */
	@RequestMapping("toModifyDirectPage.do")
	public ModelAndView toModifyDirectPage(@RequestParam String directId){
		return directionManageService.toModifyDirectPage(directId);
	}
	
	/**
	 * 修改专业方向信息
	 * @param direction 接收客户端待修改的专业方向信息
	 * @return 返回修改结果
	 */
	@ResponseBody
	@RequestMapping("modifyDirection.do")
	public String modifyDirection(@RequestBody Direction direction){
		return ""+directionManageService.modifyDirection(direction);
	}
	
	/**
	 * 删除专业方向信息
	 * @param directId 专业方向id
	 * @return 删除结果
	 */
	@ResponseBody
	@RequestMapping("deleteDirection.do")
	public String deleteDirection(@RequestParam String directId){
		return ""+directionManageService.deleteDirection(directId);
	}
}

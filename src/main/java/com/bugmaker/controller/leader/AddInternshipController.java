package com.bugmaker.controller.leader;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Internship;
import com.bugmaker.bean.Job;
import com.bugmaker.service.InternshipService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by NY on 2017/9/19.
 */
@Controller
@RequestMapping("/leader")
public class AddInternshipController {
	
	@Resource
	public InternshipService internshipService;

	
	/***
	 * 通过公司的ID获取岗位信息
	 * @param id
	 * @return
	 */
    @RequestMapping("getjobs.do")
    public @ResponseBody List<Job> getjobs(@RequestParam String id){
    	//System.out.println(id);
    	List<Job> jobs = internshipService.getJobByCompanyId(id);
    	return jobs;
    }
    /**
     * 添加项目信息
     * @param internship
     * @return
     */
	@RequestMapping("addOneInternship.do")
	public ModelAndView addOneInternship(Internship internship){
		boolean insertInternship = internshipService.insertInternship(internship);
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("insertInternship", insertInternship);
    	modelAndView.setViewName("leader/addInternship");
		return modelAndView;
	}
	/**
     * 删除项目信息
     * @param id
     * @return
     */
	@RequestMapping(value = "delInternship.do", method = RequestMethod.POST)
	@ResponseBody
	public String delInternship(@RequestBody String id){
		
		internshipService.deleteInternshipById(id.substring(3));
		return "123";
	}
	/**
     * 更新项目信息
     * @param internship
     * @return
     */
	@RequestMapping("updateOneInternship.do")
	public String updateOneInternship(Internship internship){
		internshipService.updateInternshipById(internship);
		return "leader/InternshipCRUD";
	}
	 /**
     * 通过名称获取项目信息
     * @return
     */
	@RequestMapping("getInternshipByName.do")
	public String getInternshipByName(ModelMap model,String name){
		//System.out.println(name);
		List<Internship> ship = internshipService.getInternshipByName(name);
		
		
		model.put("ship",ship);
		return "leader/InternshipCRUD";
	}
	
}

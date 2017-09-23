package com.bugmaker.controller.leader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Company;
import com.bugmaker.bean.Internship;
import com.bugmaker.bean.Job;
import com.bugmaker.service.InternshipService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by wurenjie on 2017/9/12.
 */
@Controller
@RequestMapping("/leader")
public class LeaderController {
	
	@Resource
	public InternshipService internshipService;
	
    @RequestMapping("index.do")
    public String indexView(){
        return "leader/index";
    }
    
    /**
     * 系领导管理顶岗项目页面
     * @return
     */
	@RequestMapping("internshipCRUD.do")
	public String internshipCRUD(Model model,
			@RequestParam(defaultValue="1") String currentPage){
		
		Integer currPage = Integer.valueOf(currentPage);
		PageHelper.startPage(currPage, 5);		
		List<Internship> internships = internshipService.getAllInternship();		
		PageInfo page = new PageInfo(internships, 5);
		page.getNavigatePages();
		model.addAttribute("page",page);
		return "leader/InternshipCRUD";
	}
	
	 /**
     * 添加项目页面
     * @return
     */
	@RequestMapping("addInternship.do")
	public ModelAndView addInternship(){
		Map<String,List<Company>>  map = new HashMap<String,List<Company>>();
		List<Company> companys = internshipService.getAllCompany();
		map.put("companys", companys);
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("map", map);
    	modelAndView.setViewName("leader/addInternship");
		return modelAndView;
	}
	
	/**
	 * 修改项目页面
	 */
	@RequestMapping("updateInternship.do")
	public ModelAndView updateInternship(@RequestParam(defaultValue="1") String internshipID){
		//Map<String,List<Job>>  map = new HashMap<String,List<Job>>();
		//System.out.println(internshipID);
		Map<String,Object>  map = new HashMap<String,Object>();
		List<Job> jobs = internshipService.getAllJob();
		map.put("jobs", jobs);
		map.put("internshipID", internshipID);
		
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("map", map);
    	modelAndView.setViewName("leader/updateInternship");
		return modelAndView;
	}
	
}

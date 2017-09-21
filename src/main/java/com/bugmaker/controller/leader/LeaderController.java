package com.bugmaker.controller.leader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Company;
import com.bugmaker.service.InternshipService;

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
	public String teacherRU(){
		return "leader/internshipCRUD";
	}
	 /**
     * 添加顶岗页面
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
}

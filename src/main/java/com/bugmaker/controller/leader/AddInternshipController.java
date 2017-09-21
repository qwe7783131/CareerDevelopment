package com.bugmaker.controller.leader;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.InternshipBean;
import com.bugmaker.service.InternshipService;

/**
 * Created by NY on 2017/9/19.
 */
@Controller
@RequestMapping("/leader")
public class AddInternshipController {
	
	@Resource
	public InternshipService internshipService;
	/**
     * 系领导添加顶岗项目页面
     * @return
     */
    @RequestMapping("addinternships.do")
    public ModelAndView addinternship(InternshipBean ib){
    	internshipService.insertCompany(ib.getCompany());
    	internshipService.insertJob(ib.getJob());
    	boolean insertInternship = internshipService.insertInternship(ib.getInternship());
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("insertInternship", insertInternship);
    	modelAndView.setViewName("leader/addInternship");
    	/*System.out.println(ib.getInternship().getType());*/
        return modelAndView;

    }
    
	
}

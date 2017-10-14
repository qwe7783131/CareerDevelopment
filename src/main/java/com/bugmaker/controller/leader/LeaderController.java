package com.bugmaker.controller.leader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bugmaker.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Company;
import com.bugmaker.bean.Dept;
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
	public TeacherService teacherService;
	
	@Resource
	public InternshipService internshipService;
	
	/**
	 * 跳转到系领导的首页
	 * @return
     */
    @RequestMapping("index.do")
    public String indexView(){
        return "leader/index";
    }

	/**
	 * 跳转到分班页面
	 */
//	@RequestMapping("toDivideClass.do")
//	public String divideClassView() { return "leader/divideClass"; }

	/**
	 * 跳转到开启和关闭专业选择页面
	 */
	@RequestMapping("toInstershipRegister.do")
	public String instershipRegisterView() { return "leader/instershipRegister"; }

	/**
	 * 跳转到开启和关闭专业填报功能页面
	 */
	@RequestMapping("toSetProfessState.do")
	public String setProfessStateView() { return "leader/setProfessState"; }
	/**
	 * 跳转到就业调查页面
     */
	@RequestMapping("toSurvey.do")
	public String surveyView() { return "leader/survey"; }
	/**
	 * 跳转到调查结果页面
	 */
	@RequestMapping("toSurveyResult.do")
	public String surveyResultView() { return "leader/surveyResult"; }
	/**
	 * 跳转到查看住宿安排页面
	 */
	@RequestMapping("towatchDormitoryArrange.do")
	public String watchDormitoryArrangeView() { return "leader/watchDormitoryArrange"; }

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
		Map<String,Object>  map = new HashMap<String,Object>();
		List<Company> companys = internshipService.getAllCompany();
		List<Dept> depts = internshipService.getAllDept();
		map.put("companys", companys);
		map.put("depts", depts);
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

	///////////////////////////xuxu//////////////////////////////////
	@RequestMapping("internshipRegistrationManage.do")
	public ModelAndView internshipRegistrationManage(@RequestParam(defaultValue = "1") String curr){
		return teacherService.tointernshipRegistrationManage(curr);
	}

	@RequestMapping("getInsVolunteeByDept.do")
	public ModelAndView getInsVolunteeByDept(@RequestParam(defaultValue = "1") String curr,String deptId){
		return teacherService.getInsVolunteeByDept(curr,deptId);
	}

	@RequestMapping("internshipRegistrationManageIn.do")
	public ModelAndView internshipRegistrationManageIn(@RequestParam(defaultValue = "1") String curr){
		return teacherService.tointernshipRegistrationManageIn(curr);
	}

	@RequestMapping("getInsVolunteeByDeptIn.do")
	public ModelAndView getInsVolunteeByDeptIn(@RequestParam(defaultValue = "1") String curr,String deptId){
		return teacherService.getInsVolunteeByDeptIn(curr,deptId);
	}
}

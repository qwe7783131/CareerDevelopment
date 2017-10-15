package com.bugmaker.controller.leader;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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
import com.bugmaker.bean.Score;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import com.bugmaker.constant.ProtocolConstant;
import com.bugmaker.service.GScoreExportService;
import com.bugmaker.service.InternshipService;
import com.bugmaker.service.ScoreExportService;
import com.bugmaker.service.TeacherScoreService;
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
	@Resource
	public TeacherScoreService teacherScoreService;
	@Resource
	public ScoreExportService scoreExportService;
	@Resource
	public GScoreExportService gscoreExportService;
	
	
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
	 * 跳转到查询所有存档资料页面
	 */
	/*@RequestMapping("todocumentDownload.do")
	public String documentDownloadView() { return "leader/documentDownload"; }*/
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
	
	
	//顶岗
    @RequestMapping("selectScroeLea.do")
    public String selectScroeLeaView(Model model,
			@RequestParam(defaultValue="1") String currentPage){
    	Student student =new Student();
    	Integer currPage = Integer.valueOf(currentPage);
		PageHelper.startPage(currPage, 5);		
		List<Score> ins = teacherScoreService.selectScoreByParam(ProtocolConstant.OUTJOB,student);
		PageInfo page = new PageInfo(ins, 5);
		page.getNavigatePages();
		model.addAttribute("page",page);
        return "leader/selectScroeLea";
    }
    @RequestMapping("getScoreByName.do")
    public String getScoreByName(Model model,String name){
    	Student student =new Student();
    	User user = new User();
    	user.setUsername(name);
    	student.setUser(user);
			
		List<Score> scores = teacherScoreService.selectScoreByParam(ProtocolConstant.OUTJOB,student);
		
		model.addAttribute("scores",scores);
        return "leader/selectScroeLea";
    }
    @RequestMapping("scoreExcel.do")
    public void scoreExcel(HttpServletRequest request, HttpServletResponse response)throws Exception{
       
    	Student student =new Student();
		List<Score> scores = teacherScoreService.selectScoreByParam(ProtocolConstant.OUTJOB,student); 
        HSSFWorkbook wb = scoreExportService.export(scores);    
        response.setContentType("application/vnd.ms-excel");    
        response.setHeader("Content-disposition", "attachment;filename=studentLea.xls");    
        OutputStream ouputStream = response.getOutputStream();    
        wb.write(ouputStream);    
        ouputStream.flush();    
        ouputStream.close();  
    	
    }
    
    //跟岗
    @RequestMapping("selectggScroeLea.do")
    public String selectggScroeLeaView(Model model,
			@RequestParam(defaultValue="1") String currentPage){
    	Student student =new Student();
    	Integer currPage = Integer.valueOf(currentPage);
		PageHelper.startPage(currPage, 5);		
		List<Score> ins = teacherScoreService.selectScoreByParam(ProtocolConstant.ONJOB,student);
		PageInfo page = new PageInfo(ins, 5);
		page.getNavigatePages();
		model.addAttribute("page",page);
        return "leader/selectggScroeLea";
    }
    @RequestMapping("getggScoreByName.do")
    public String getggScoreByName(Model model,String name){
    	Student student =new Student();
    	User user = new User();
    	user.setUsername(name);
    	student.setUser(user);
			
		List<Score> scores = teacherScoreService.selectScoreByParam(ProtocolConstant.ONJOB,student);
		
		model.addAttribute("scores",scores);
        return "leader/selectggScroeLea";
    }
    @RequestMapping("ggscoreExcel.do")
    public void ggscoreExcel(HttpServletRequest request, HttpServletResponse response)throws Exception{
       
    	Student student =new Student();
    	List<Score> ins = teacherScoreService.selectScoreByParam(ProtocolConstant.ONJOB,student); 
        //System.out.println(ins);
    	HSSFWorkbook wb = gscoreExportService.export(ins);    
        response.setContentType("application/vnd.ms-excel");    
        response.setHeader("Content-disposition", "attachment;filename=studentscorelea.xls");    
        OutputStream ouputStream = response.getOutputStream();    
        wb.write(ouputStream);    
        ouputStream.flush();    
        ouputStream.close();  
    	
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

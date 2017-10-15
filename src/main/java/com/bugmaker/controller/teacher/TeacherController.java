package com.bugmaker.controller.teacher;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.InsVoluntee;
import com.bugmaker.bean.Internship;
import com.bugmaker.bean.Outteacher;
import com.bugmaker.bean.Score;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import com.bugmaker.constant.ProtocolConstant;
import com.bugmaker.service.AddTeacherService;
import com.bugmaker.service.GScoreExportService;
import com.bugmaker.service.OutTeacherService;
import com.bugmaker.service.ProfessPrincipalService;
import com.bugmaker.service.ScoreExportService;
import com.bugmaker.service.StudentService;
import com.bugmaker.service.TeacherInternshipService;
import com.bugmaker.service.TeacherScoreService;
import com.bugmaker.service.TeacherService;
import com.bugmaker.utils.RequestUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by wurenjie on 2017/9/12.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Resource
	public StudentService studentService;
	@Resource
	public TeacherService teacherService;
	@Resource
	public AddTeacherService addTeacherService;
	@Resource
	public ProfessPrincipalService professsPrincipalService;
	@Resource
	public OutTeacherService outTeacherService;
	@Resource
	public TeacherInternshipService teacherInternshipService;
	@Resource
	public TeacherScoreService teacherScoreService;
	@Resource
	public ScoreExportService scoreExportService;
	@Resource
	public GScoreExportService gscoreExportService;
	
    /**
     * 教师首页
     * @return
     */
    @RequestMapping("index.do")
    public String indexView(){
        return "teacher/index";
    }

    /**
     * 查看学生信息的页面
     * @return
     */ 
  
    /*@RequestMapping("selectStu.do")
    public String selectStuView(Model model,
			@RequestParam(defaultValue="1") String currentPage){
    	Integer currPage = Integer.valueOf(currentPage);
    	PageHelper.startPage(currPage, 5);	
    	List<Student> students = studentService.selectAllStudent();
    	System.out.println(students);
    	PageInfo page = new PageInfo(students, 5);
		page.getNavigatePages();
		model.addAttribute("page",page);
        return "teacher/selectStu";
    }*/
    @RequestMapping("selectStu.do")
    public ModelAndView selectStu(@RequestParam(defaultValue="1") String currentPage){
    	return studentService.selectAllStudent(currentPage);
    }
    /**
     * 查看教师信息的页面
     * @return
     */
   
   
  //获取数据跳转到teacherManage
    @RequestMapping("selectTea.do")
    public ModelAndView selectTeaView(@RequestParam(defaultValue="1") String currentPage) {
        return teacherService.getAllTeacher(currentPage);
    }
    /**
     * 查看专业负责人信息的页面
     * @return
     */
  
    @RequestMapping("selectProfessTea.do")
    public ModelAndView selectProfessTeaView(@RequestParam(defaultValue="1") String curr){
       
    	return professsPrincipalService.getAllProfessPrincipal(curr);
    }

    /**
     * 查看企业教师信息的页面
     * @return
     */
    @RequestMapping("selectOut.do")
    public ModelAndView selectOutView(@RequestParam(defaultValue="1") String curr){
        return outTeacherService.selectAllOutTeacher(curr);
    }

    /**
     * 发布专业方向的页面
     * @return
     */
    @RequestMapping("releaseDirect.do")
    public String releaseDirectView(){
        return "teacher/releaseDirect";
    }
    /**
     * 教师评分的页面
     * @return
     */
    @RequestMapping("teacherScore.do")
    public String teacherScoreView(Model model,
			@RequestParam(defaultValue="1") String currentPage){
    	User currentUser = RequestUtil.getCurrentUser();
    	Integer currPage = Integer.valueOf(currentPage);
		PageHelper.startPage(currPage, 5);		
		List<InsVoluntee> ins = teacherScoreService.selectInsVolunteerByParam(currentUser.getDept().getId(), ProtocolConstant.OUTJOB, "", "", 1);
		PageInfo page = new PageInfo(ins, 5);
		page.getNavigatePages();
		model.addAttribute("page",page);
        return "teacher/teacherScore";
    }
    @RequestMapping("makeScore.do")
    public ModelAndView makeScoreView(@RequestParam(defaultValue="1") String stuid){
    	Map<String,Object>  map = new HashMap<String,Object>();
    	map.put("stuid", stuid);
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("map", map);
    	modelAndView.setViewName("teacher/makeScore");
		return modelAndView;
    }
    @RequestMapping("givestuscore.do")
	public String givestuscore(String stuid,String score,String no){
    	System.out.println(stuid);
    	Integer n = Integer.valueOf(no);
    	Double s = Double.valueOf(score);
		Score sc = new Score();
		Student stu = new Student();
		stu.setId(stuid);
		sc.setStudent(stu);
		sc.setNo(n);
		sc.setTeacScore(s);
		teacherScoreService.giveOneScore(sc);
		return "teacher/makeScore";
	}
    /**
     * 教师查看学生顶岗成绩的页面
     * @return
     */
    @RequestMapping("selectScroeTeac.do")
    public String selectScroeTeacView(Model model,
			@RequestParam(defaultValue="1") String currentPage){
    	Student student =new Student();
    	Integer currPage = Integer.valueOf(currentPage);
		PageHelper.startPage(currPage, 5);		
		List<Score> ins = teacherScoreService.selectScoreByParam(ProtocolConstant.OUTJOB,student);
		PageInfo page = new PageInfo(ins, 5);
		page.getNavigatePages();
		model.addAttribute("page",page);
        return "teacher/selectScroeTeac";
    }
    @RequestMapping("getScoreByName.do")
    public String getScoreByName(Model model,String name){
    	Student student =new Student();
    	User user = new User();
    	user.setUsername(name);
    	student.setUser(user);
			
		List<Score> scores = teacherScoreService.selectScoreByParam(ProtocolConstant.OUTJOB,student);
		
		model.addAttribute("scores",scores);
        return "teacher/selectScroeTeac";
    }
    /**
     * 教师查看学生跟岗成绩的页面
     * @return
     */
    @RequestMapping("selectggScroeTeac.do")
    public String selectggScroeTeacView(Model model,
			@RequestParam(defaultValue="1") String currentPage){
    	Student student =new Student();
    	Integer currPage = Integer.valueOf(currentPage);
		PageHelper.startPage(currPage, 5);		
		List<Score> ins = teacherScoreService.selectScoreByParam(ProtocolConstant.ONJOB,student);
		PageInfo page = new PageInfo(ins, 5);
		page.getNavigatePages();
		model.addAttribute("page",page);
        return "teacher/selectggScroeTeac";
    }
    @RequestMapping("getggScoreByName.do")
    public String getggScoreByName(Model model,String name){
    	Student student =new Student();
    	User user = new User();
    	user.setUsername(name);
    	student.setUser(user);
			
		List<Score> scores = teacherScoreService.selectScoreByParam(ProtocolConstant.ONJOB,student);
		
		model.addAttribute("scores",scores);
        return "teacher/selectggScroeTeac";
    }
    /**
     * 导出学生成绩
     * @return
     */
    @RequestMapping("scoreExcel.do")
    public void scoreExcel(HttpServletRequest request, HttpServletResponse response)throws Exception{
       
    	Student student =new Student();
		List<Score> scores = teacherScoreService.selectScoreByParam(ProtocolConstant.OUTJOB,student); 
        HSSFWorkbook wb = scoreExportService.export(scores);    
        response.setContentType("application/vnd.ms-excel");    
        response.setHeader("Content-disposition", "attachment;filename=student.xls");    
        OutputStream ouputStream = response.getOutputStream();    
        wb.write(ouputStream);    
        ouputStream.flush();    
        ouputStream.close();  
    	
    }
    @RequestMapping("ggscoreExcel.do")
    public void ggscoreExcel(HttpServletRequest request, HttpServletResponse response)throws Exception{
       
    	Student student =new Student();
    	List<Score> ins = teacherScoreService.selectScoreByParam(ProtocolConstant.ONJOB,student); 
        System.out.println(ins);
    	HSSFWorkbook wb = gscoreExportService.export(ins);    
        response.setContentType("application/vnd.ms-excel");    
        response.setHeader("Content-disposition", "attachment;filename=studentscore.xls");    
        OutputStream ouputStream = response.getOutputStream();    
        wb.write(ouputStream);    
        ouputStream.flush();    
        ouputStream.close();  
    	
    }

    /**
     * 查看和完成跟岗实习手册
     */
    @RequestMapping("selectOnJobBook.do")
    public String selectOnJobBookView(){
        return "teacher/selectOnJobBook";
    }

    /**
     * 指导老师分配
     */
    /*@RequestMapping("teacherAssign.do")
    public String teacherAssignView(){
        return "teacher/zhidaofenpei";
    }*/
    @RequestMapping("teacherAssign.do")
    public ModelAndView teacherAssignView(@RequestParam(defaultValue="1") String curr){
    	return teacherInternshipService.tSelectInternshipsByDeptId(curr);
    }
    /**
     * 指导老师分配
     */
    @ResponseBody
    @RequestMapping(value = "addTeacIns.do", method = RequestMethod.POST)
    public String addTeacIns(String[] internshipID){
    	int i=0;
    for (String string : internshipID) {
    	i=teacherInternshipService.addTeacIns(string);
		
	}
    	
        return ""+i;
    }
    /**
     * 查看和完成顶岗实习手册
     * @return
     */
//    @RequestMapping("selectOutJobBook.do")
//    public String selectOutJobBookView(){
//        return "teacher/selectOutJobBook";
//    }

    /**
     * 查看跟岗实习进度
     */
    @RequestMapping("seeLoading.do")
    public String seeLoadingView(){
        return "teacher/intership_load";
    }


    /**
     * 发布专业方向信息跳转用
     */
    @RequestMapping("addDirect.do")
    public String addDirectView(){
        return "teacher/addDirect";
    }
    /**
     * 通过学生姓名、班级或院系查找学生信息
     */
    @RequestMapping("getStudentInfo.do")
    public String getStudentInfo(ModelMap model,Student student){
    	//System.out.println(student);
    	if(student==null){
    		return "redirect:/teacher/selectStu.do";
    	}
    	List<Student> students = studentService.selectStudentByParams(student);
    	//System.out.println(students);
    	model.put("students", students);
        return "teacher/selectStu";
    }
    /**
     * 通过教师姓名、班级或院系查找学生信息
     */
    @RequestMapping("getTeacherInfo.do") 
    public ModelAndView getTeacherInfo(User user,
    		@RequestParam(defaultValue="1") String currentPage){
    	if(user==null){
    	
        return new ModelAndView("redirect:/teacher/selectTea.do");
    	}else{
    	return teacherService.selectTeaByParams(user,currentPage);
    	}
    }
  
    /**
     * 通过企业教师姓名、班级或院系查找学生信息
     */
    @RequestMapping("getprofessInfo.do") 
    public String getprofessInfo(ModelMap model,String username){
        //System.out.println("搜索词为：id："+id + "username:" + username + "dept:" + dept);
        User user = new User();
        user.setUsername(username);
       
        List<User> profess = professsPrincipalService.selectTeacherByParams(user);
        
        
        model.put("profess",profess);
        return "teacher/selectProfessTea";
    }
    /**
     * 多条件查询企业教师,可通过企业教师id，模糊姓名，模糊公司姓名
     */
    @RequestMapping("getOutTeacherInfo.do") 
    public String getOutTeacherInfo(ModelMap model,Outteacher outteacher){
        //System.out.println("搜索词为：id："+id + "username:" + username + "dept:" + dept);
       if(outteacher==null){
    	   return "redirect:/teacher/selectOut.do";
       }
       
       List<Outteacher> outtea = outTeacherService.selectAllOutTeacherByParams(outteacher);
        
        //System.out.println(outtea);
        model.put("outtea",outtea);
        return "teacher/selectOut";
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

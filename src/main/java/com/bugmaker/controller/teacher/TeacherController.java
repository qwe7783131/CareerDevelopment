package com.bugmaker.controller.teacher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Internship;
import com.bugmaker.bean.Outteacher;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import com.bugmaker.service.AddTeacherService;
import com.bugmaker.service.OutTeacherService;
import com.bugmaker.service.ProfessPrincipalService;
import com.bugmaker.service.StudentService;
import com.bugmaker.service.TeacherInternshipService;
import com.bugmaker.service.TeacherService;
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
     * 查看学生志愿填报的页面
     * @return
     */
    @RequestMapping("selectVoluntaryReport.do")
    public String selectVoluntaryReportView(){
        return "teacher/selectVoluntaryReport";
    }

    /**
     * 查看分班名单
     * @return
     */
    @RequestMapping("selectClassDivide.do")
    public String selectClassDivideView(){
        return "teacher/selectClassDivide";
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
    @RequestMapping("selectOutJobBook.do")
    public String selectOutJobBookView(){
        return "teacher/selectOutJobBook";
    }

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

}

package com.bugmaker.controller.teacher;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bugmaker.bean.Internship;
import com.bugmaker.bean.Student;
import com.bugmaker.service.StudentService;
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
  
    @RequestMapping("selectStu.do")
    public String selectStuView(Model model,
			@RequestParam(defaultValue="1") String currentPage){
    	Integer currPage = Integer.valueOf(currentPage);
    	PageHelper.startPage(currPage, 5);	
    	List<Student> students = studentService.selectAllStudent();
    	PageInfo page = new PageInfo(students, 5);
		page.getNavigatePages();
		model.addAttribute("page",page);
        return "teacher/selectStu";
    }
   
    /**
     * 查看教师信息的页面
     * @return
     */
    @RequestMapping("selectTea.do")
    public String selectTeaView(){
        return "teacher/selectTea";
    }

    /**
     * 查看专业负责人信息的页面
     * @return
     */
    @RequestMapping("selectProfessTea.do")
    public String selectProfessTeaView(){
        return "teacher/selectProfessTea";
    }

    /**
     * 查看企业教师信息的页面
     * @return
     */
    @RequestMapping("selectOut.do")
    public String selectOutView(){
        return "teacher/selectOut";
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
    @RequestMapping("teacherAssign.do")
    public String teacherAssignView(){
        return "teacher/zhidaofenpei";
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
    	
    	List<Student> students = studentService.selectStudentByParams(student);
    	model.put("students", students);
        return "teacher/selectStu";
    }
}

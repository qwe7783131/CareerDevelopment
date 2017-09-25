package com.bugmaker.controller.student;


import com.bugmaker.bean.Student;
import com.bugmaker.bean.SurveyResult;
import com.bugmaker.bean.User;
import com.bugmaker.service.StudentService;
import com.bugmaker.service.StudentServiceXuxu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Resource
	public StudentService studentService;
	@Resource
	public StudentServiceXuxu studentServiceXuxu;

	@RequestMapping("test.do")
 	public String testcontroller(ModelMap model) {
		List<Student> selectAllStudent = studentService.selectAllStudent();
		model.put("selectAllStudent", selectAllStudent);
		return "index";
	}

	@RequestMapping("index.do")
	public String indexView(){
		return "student/index";
	}
	
	 /**
     * 学生文档上传
     * @return
     */
	@RequestMapping("documentUpload.do")
	public String documentUpload(){
		return "student/documentUpload";
	}
	/**
     * 学生就业调查页面
     * @return
     */
	@RequestMapping("employmentSurvey.do")
	public String employmentSurvey(ModelMap modelMap, HttpServletRequest request , SurveyResult a){
		Student student = new Student();
		User user = (User)request.getSession().getAttribute("user");
		student.setId(user.getId());
		student.setUser(user);
		studentServiceXuxu.selectSurveyByStuId(student);
		//判断是否填过
		if(!(studentServiceXuxu.selectSurveyByStuId(student)==null)){
			modelMap.put("selectSurvey",studentServiceXuxu.selectSurveyByStuId(student));
			modelMap.put("selectUser",user);
			return "student/alreadyHadEmpolymentSurvey";
		}
		else {
			return "student/employmentSurvey";
		}
	}
	/**
     * 学生查询个人成绩页面
     * @return
     */
	@RequestMapping("selectScoreStu.do")
	public String selectScoreStu(){
		return "student/selectScoreStu";
	}
	/**
     * 学生查看指导老师页面
     * @return
     */
	@RequestMapping("teacherRU.do")
	public String teacherRU(){
		return "student/teacherRU";
	}
	/**
     * 学生申请转指导老师页面
     * @return
     */
	@RequestMapping("teacherU.do")
	public String teacherU(){
		return "student/teacherU";
	}
	/**
     * 学生填报志愿页面
     * @return
     */
	@RequestMapping("voluntaryReporting.do")
	public String voluntaryReporting(){
		return "student/voluntaryReporting";
	}

	/**
	 * 专业方向志愿填报
	 * @return
	 */
	@RequestMapping("direction.do")
	public String direction(){
		return "student/direction";
	}

	/**
	 * 跟岗查看宿舍安排
	 * @return
	 */
	@RequestMapping("dormitoryGenggang.do")
	public String dormitoryGenggang(){
		return "student/dormitoryGenggang";
	}

	/**
	 * 任务书
	 * @return
	 */
	@RequestMapping("task.do")
	public String task(){
		return "student/task";
	}

	/**
	 * 查看实习成绩
	 * @return
	 */
	@RequestMapping("watchScore.do")
	public String watchScore(){
		return "student/watchScore";
	}
}

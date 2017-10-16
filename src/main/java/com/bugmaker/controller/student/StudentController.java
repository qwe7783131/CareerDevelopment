package com.bugmaker.controller.student;


import com.bugmaker.bean.Student;
import com.bugmaker.bean.Survey;
import com.bugmaker.bean.SurveyResult;
import com.bugmaker.bean.User;
import com.bugmaker.constant.ProtocolConstant;
import com.bugmaker.service.IssueTaskBookService;
import com.bugmaker.service.StudentService;
import com.bugmaker.service.StudentServiceXuxu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	@Resource
	public IssueTaskBookService issueTaskBookService;

	/*@RequestMapping("test.do")
 	public String testcontroller(ModelMap model) {
		List<Student> selectAllStudent = studentService.selectAllStudent();
		model.put("selectAllStudent", selectAllStudent);
		return "index";
	}*/

	@RequestMapping("index.do")
	public String indexView(){
		return "student/index";
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

		Survey survey = studentServiceXuxu.selectSurveyStatusAndEnableByStuId(user.getId());
		System.out.println("id"+survey.getId()+"status"+survey.getStatus()+":enable"+survey.getEnable());
		if(survey.getStatus().equals("0")) {
			modelMap.put("surveyStatus", "0");
		} else {
			modelMap.put("surveyStatus", "1");
			if(survey.getEnable().equals("0")) {
				modelMap.put("surveyEnable", "0");
			} else if(survey.getEnable().equals("1")) {
				modelMap.put("surveyEnable", "1");
				studentServiceXuxu.selectSurveyByStuId(student);
				//判断是否填过
				if (!(studentServiceXuxu.selectSurveyByStuId(student) == null)) {
					modelMap.put("tianxie", "1");
					modelMap.put("selectSurvey", studentServiceXuxu.selectSurveyByStuId(student));
					modelMap.put("selectUser", user);
				} else {
					modelMap.put("tianxie", "0");
				}
			} else {
				modelMap.put("surveyEnable", "2");
			}

		}
		return "student/employmentSurvey";
	}

	/**
	 * 查看跟岗任务书
     */
	@RequestMapping("selectFollowIssueTaskBook.do")
	public ModelAndView selectFollowIssueTaskBook(@RequestParam(defaultValue = "1") String status, @RequestParam(defaultValue = "1") String curr) {
		ModelAndView modelAndView = issueTaskBookService.toIssueTaskBookPage(ProtocolConstant.ONJOB, curr, status);
		modelAndView.setViewName("student/selectFollowIssueTaskBook");
		return modelAndView;
	}

	/**
	 * 查看顶岗任务书
	 */
	@RequestMapping("selectIssueTaskBook.do")
	public ModelAndView selectIssueTaskBook(@RequestParam(defaultValue = "1") String status, @RequestParam(defaultValue = "1") String curr) {
		ModelAndView modelAndView = issueTaskBookService.toIssueTaskBookPage(ProtocolConstant.OUTJOB, curr, status);
		modelAndView.setViewName("student/selectIssueTaskBook");
		return modelAndView;
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
	
	/**
	 * 查看我的宿舍安排
	 * @param insType
	 * @return
	 */
	@RequestMapping("toWatchMyDorm.do")
	public ModelAndView toWatchMyDorm(String insType,@RequestParam(defaultValue="1") String curr){
		return studentService.toWatchMyDorm(insType,curr);
	}
}

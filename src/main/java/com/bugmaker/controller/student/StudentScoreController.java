package com.bugmaker.controller.student;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bugmaker.bean.Score;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import com.bugmaker.constant.ProtocolConstant;
import com.bugmaker.service.TeacherScoreService;
import com.bugmaker.utils.RequestUtil;

@Controller
@RequestMapping("/student")
public class StudentScoreController {
	
	@Resource
	public TeacherScoreService teacherScoreService;
	
	/**
	 * 查看跟岗实习成绩
	 * @return
	 */
	@RequestMapping("selectScoreStuByID.do")
	public String selectScoreStu(Model model){
		User currentUser = RequestUtil.getCurrentUser();
		Student student = new Student();
		student.setId(currentUser.getId());
		List<Score> score = teacherScoreService.selectScoreByParam(ProtocolConstant.ONJOB,student);
		//System.out.println(score);
		model.addAttribute("score", score);
		return "student/selectScoreStu";
	}
	/**
	 * 查看顶岗实习成绩
	 * @return
	 */
	@RequestMapping("watchScoreStuByID.do")
	public String watchScoreStuByID(Model model){
		User currentUser = RequestUtil.getCurrentUser();
		Student student = new Student();
		student.setId(currentUser.getId());
		List<Score> score = teacherScoreService.selectScoreByParam(ProtocolConstant.OUTJOB,student);
		//System.out.println(score);
		model.addAttribute("score", score);
		return "student/watchScore";
	}

}

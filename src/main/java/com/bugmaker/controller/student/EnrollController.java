package com.bugmaker.controller.student;


import com.bugmaker.bean.Direction;
import com.bugmaker.service.EnrollService;
import com.bugmaker.service.StudentDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
/**
 * 学生专业方向志愿的填报
 */
@Controller
@RequestMapping("/student")
public class EnrollController{
	@Resource
	private EnrollService enrollService;

	/**
	 * 专业方向志愿填报
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addStudentVolunteer.do", method = RequestMethod.POST)
	public String toDirectionView(@RequestBody Direction direction){
		return ""+enrollService.insertEnroll(direction.getId());
	}
}

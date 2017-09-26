package com.bugmaker.controller.student;


import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.SurveyResult;
import com.bugmaker.bean.User;
import com.bugmaker.service.StudentDirectionService;
import com.bugmaker.service.StudentService;
import com.bugmaker.service.StudentServiceXuxu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 学生专业方向志愿的填报
 */
@Controller
@RequestMapping("/student")
public class DirectionController {
	@Resource
	StudentDirectionService studentDirectionService;
	/**
	 * 专业方向志愿填报
	 * @return
	 */
	@RequestMapping("toDirection.do")
	public ModelAndView toDirectionView(@RequestParam(defaultValue = "1") String curr ){
		return studentDirectionService.selectDirectionByDept(curr);
	}
}

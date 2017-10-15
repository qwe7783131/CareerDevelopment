package com.bugmaker.controller.outteacher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.InsVoluntee;
import com.bugmaker.bean.Score;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import com.bugmaker.constant.ProtocolConstant;
import com.bugmaker.service.TeacherScoreService;
import com.bugmaker.utils.RequestUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by NY on 2017/10/14.
 */
@Controller
@RequestMapping("/outteacher")
public class OutTeacherScoreController {
	
	@Resource
	public TeacherScoreService teacherScoreService;
	
	
	 /**
     * 企业教师评分的页面
     * @return
     */
    @RequestMapping("outTeacherScore.do")
    public String teacherScoreView(Model model,
			@RequestParam(defaultValue="1") String currentPage){
    	User currentUser = RequestUtil.getCurrentUser();
    	Integer currPage = Integer.valueOf(currentPage);
		PageHelper.startPage(currPage, 5);		
		List<InsVoluntee> ins = teacherScoreService.selectStusAndInsByOutteacId(currentUser.getId());
		PageInfo page = new PageInfo(ins, 5);
		page.getNavigatePages();
		model.addAttribute("page",page);
        return "outteacher/outTeacherScore";
    }
    @RequestMapping("outMakeScore.do")
    public ModelAndView outMakeScoreView(@RequestParam(defaultValue="1") String stuid){
    	Map<String,Object>  map = new HashMap<String,Object>();
    	map.put("stuid", stuid);
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("map", map);
    	modelAndView.setViewName("outteacher/outMakeScore");
		return modelAndView;
    }
    @RequestMapping("makestuscore.do")
	public String makestuscore(String stuid,String score,String no){
    	//System.out.println(stuid);
    	Integer n = Integer.valueOf(no);
    	Double s = Double.valueOf(score);
    	System.out.println(s);
		Score sc = new Score();
		Student stu = new Student();
		stu.setId(stuid);
		sc.setStudent(stu);
		sc.setNo(n);
		sc.setOutteacScore(s);
		teacherScoreService.makeOneScore(sc);
		return "outteacher/outMakeScore";
	}

}

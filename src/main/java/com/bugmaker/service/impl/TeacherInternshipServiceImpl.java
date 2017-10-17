package com.bugmaker.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


import com.bugmaker.bean.Internship;
import com.bugmaker.bean.TeacIns;
import com.bugmaker.bean.TeacherInternship;
import com.bugmaker.bean.User;
import com.bugmaker.mapper.InternshipMapper;
import com.bugmaker.mapper.TeacherInternshipMapper;
import com.bugmaker.service.TeacherInternshipService;
import com.bugmaker.utils.RequestUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TeacherInternshipServiceImpl implements TeacherInternshipService{
	@Resource
	InternshipMapper internshipMapper;
	@Resource
	TeacherInternshipMapper teacherInternshipMapper;

	@Override
	public ModelAndView tSelectInternshipsByDeptId(String curr) {
		ModelAndView modelAndView = new ModelAndView();
		int nowPage = Integer.valueOf(curr);
		User currentUser = RequestUtil.getCurrentUser();
//		System.out.println(currentUser.getDept().getId());
		PageHelper.startPage(nowPage, 5);
		List<Internship> internships = internshipMapper.selectInternshipsByDeptId(currentUser.getDept().getId());
//        System.out.println(internships);
		PageInfo<Internship> page = new PageInfo<>(internships);
		modelAndView.addObject("page",page);
		
		TeacherInternship teacherInternship = teacherInternshipMapper.getTeacInsByTeacherId(currentUser.getId());
		if (teacherInternship != null){
			List<TeacIns> teacIns = teacherInternship.getTeacIns();
			//System.out.println(teacIns);
			modelAndView.addObject("teacIns",teacIns);
		}

		modelAndView.setViewName("teacher/zhidaofenpei");
		return modelAndView;
	}

	@Override
	public int addTeacIns(String internshipID) {
		//获取当前用户
		User currentUser = RequestUtil.getCurrentUser();
		TeacIns teacIns = new TeacIns();
		Internship internship = new Internship();
		internship.setId(internshipID);
		
		User user = new User();		
		user.setId(currentUser.getId());
		
		teacIns.setInternship(internship);
		teacIns.setTeacher(user);
		
		/*System.out.println(internshipID);
		System.out.println(currentUser.getId());*/
		int i = teacherInternshipMapper.insertTeacIns(teacIns);
		
		return i;
	}

}

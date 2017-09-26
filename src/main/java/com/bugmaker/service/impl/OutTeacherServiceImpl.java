package com.bugmaker.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Outteacher;
import com.bugmaker.bean.User;
import com.bugmaker.mapper.OutTeacherMapper;
import com.bugmaker.service.OutTeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OutTeacherServiceImpl implements OutTeacherService{
	@Resource
	OutTeacherMapper outTeacherMapper;

	@Override
	public ModelAndView selectAllOutTeacher(String curr) {
		int nowPage = Integer.valueOf(curr);
		PageHelper.startPage(nowPage, 5);
		List<Outteacher> outteachers = outTeacherMapper.selectAllOutTeacher();
		//System.out.println(outteachers);
		PageInfo<Outteacher> page = new PageInfo<>(outteachers);
		return new ModelAndView("teacher/selectOut", "page", page);
	}

	@Override
	public List<Outteacher> selectAllOutTeacherByParams(Outteacher outteacher) {
		List<Outteacher> outteachers = outTeacherMapper.selectAllOutTeacherByParams(outteacher);
		//System.out.println(outteachers);
		return outteachers;
	}

}

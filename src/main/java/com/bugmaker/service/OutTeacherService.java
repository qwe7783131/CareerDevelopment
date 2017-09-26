package com.bugmaker.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Outteacher;

public interface OutTeacherService {
	ModelAndView selectAllOutTeacher(String curr);
	List<Outteacher> selectAllOutTeacherByParams(Outteacher outteacher);

}

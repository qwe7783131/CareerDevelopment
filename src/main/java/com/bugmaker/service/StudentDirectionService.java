package com.bugmaker.service;


import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Direction;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


public interface StudentDirectionService {
	/**
	 * 根据学院查询所有专业方向
	 */
	ModelAndView selectDirectionByDept(String curr);
}

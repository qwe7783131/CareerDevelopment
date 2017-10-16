package com.bugmaker.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bugmaker.bean.DormArrange;
import com.bugmaker.bean.Outteacher;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import com.bugmaker.service.StudentService;
import com.bugmaker.utils.RequestUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.mapper.DormArrangeMapper;
import com.bugmaker.mapper.StudentMapper;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Resource
	private StudentMapper studentMapper;
	
	@Resource
	private DormArrangeMapper dormArrangeMapper;
	
	public ModelAndView selectAllStudent(String currentPage) {
		int nowPage = Integer.valueOf(currentPage);
		PageHelper.startPage(nowPage, 5);
		List<Student> students = studentMapper.selectAllStudent();
		PageInfo<Student> page = new PageInfo<>(students);
		return new ModelAndView("teacher/selectStu", "page", page);
	}

	@Override
	public List<Student> selectStudentByParams(Student student) {
		List<Student> students = studentMapper.selectStudentByParams(student);
		return students;
	}

	//查看我的宿舍安排
	@Override
	public ModelAndView toWatchMyDorm(String insType, String curr) {
		int nowPage = Integer.valueOf(curr);
		ModelAndView view = new ModelAndView("student/dormitoryDinggang");
		String type = null;
		if(insType.equals("0")){
			type = "跟岗";
		}else{
			type = "顶岗";
		}
		User user = RequestUtil.getCurrentUser();
		//查出我的宿舍
		DormArrange dormArrange = dormArrangeMapper.getDormArrangeByStuIdAndInsType(user.getId(),type);
		//查出同个学院同个单位的学生的宿舍
		PageHelper.startPage(nowPage, 5);
		List<DormArrange> dormArranges = dormArrangeMapper.getDormArrangeByDept(user.getDept().getId(),type);
		PageInfo<DormArrange> page = new PageInfo<>(dormArranges);
		//放到model
		view.addObject("insType", insType);
		view.addObject("dormArrange", dormArrange);
		view.addObject("page", page);
		return view;
	}

}

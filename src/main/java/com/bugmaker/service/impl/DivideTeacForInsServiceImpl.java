package com.bugmaker.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Internship;
import com.bugmaker.bean.TeacIns;
import com.bugmaker.bean.User;
import com.bugmaker.mapper.InternshipMapper;
import com.bugmaker.service.DivideTeacForInsService;

@Service
public class DivideTeacForInsServiceImpl implements DivideTeacForInsService {

	@Resource
	private InternshipMapper internshipMapper;

	/**
	 * 返回顶岗教师分配页面视图
	 */
	@Override
	public ModelAndView toDivideTeachDinggang(String insId) {
		String deptId = "13d59d9fa01411e7b4d800163e083221";
		Map<String, Object> map = new HashMap<String, Object>();
		List<Internship> internships = internshipMapper.selectInternshipsByDeptId(deptId);
		if(insId != null && !insId.equals("")){
			List<TeacIns> teacIns=internshipMapper.selectTeachersByInsAndDept(insId,deptId);
			map.put("teacIns", teacIns);
			map.put("insId", insId);
			System.out.println("teacIns"+teacIns);
		}
		
		//查询未选择实习项目的教师
		List<User> teachers = internshipMapper.selectTeachersNoChooseIns(deptId);
		map.put("internships", internships);
		map.put("teachers", teachers);
		
		System.out.println("teachers"+teachers);
		
		return new ModelAndView("leader/divideTeacForIns", "map", map);
	}

	/**
	 * 分配教师
	 */
	@Override
	public int diviTeachers(String[] teacIds, String insId) {
		
		return internshipMapper.updateTeacInsForAcc(teacIds,insId);
	}
}

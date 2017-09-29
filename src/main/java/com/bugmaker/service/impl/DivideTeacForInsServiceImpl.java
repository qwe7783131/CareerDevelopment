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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DivideTeacForInsServiceImpl implements DivideTeacForInsService {

	@Resource
	private InternshipMapper internshipMapper;

	/**
	 * 返回顶岗教师分配页面视图
	 */
	@Override
	public ModelAndView toDivideTeachDinggang(String insId, String status, String curr1, String curr2, String curr3) {
		int nowPage1 = Integer.valueOf(curr1);
		int nowPage2 = Integer.valueOf(curr2);
		int nowPage3 = Integer.valueOf(curr3);
		System.out.println(insId);
		System.out.println(status);
		
		String deptId = "13d59d9fa01411e7b4d800163e083221";
		Map<String, Object> map = new HashMap<String, Object>();
		List<Internship> internships = internshipMapper.selectInternshipsByDeptId(deptId);
		if(insId != null && !insId.equals("") && status !=null && !status.equals("")){
			map.put("insId", insId);
			map.put("status", status);
			PageHelper.startPage(nowPage1, 4);
			List<TeacIns> teacIns=internshipMapper.selectTeacsByInsIdAndStatus(insId,status);
			PageInfo<TeacIns> page = new PageInfo<>(teacIns);
			if(status.equals("2")){
				map.put("page1", page);
			}else if(status.equals("1")){
				map.put("page2", page);
			}else{
				map.put("page0", page);
			}
			System.out.println(status);
			System.out.println(page);
			
		}
		
		//查询未选择实习项目的教师
		PageHelper.startPage(nowPage3, 4);
		List<User> teachers = internshipMapper.selectTeachersNoChooseIns(deptId);
		PageInfo<User> page = new PageInfo<>(teachers);
		map.put("internships", internships);
		map.put("page3", page);
		
		return new ModelAndView("leader/divideTeacForIns", "map", map);
	}

	/**
	 * 分配教师
	 */
	@Override
	public int diviTeachers(String[] teacIds, String insId, String type) {
		int result = 0;
		if(type.equals("1")){
			result = internshipMapper.updateTeacInsForAcc(teacIds,insId,"1");
		}else if(type.equals("2")){
			result = internshipMapper.updateTeacInsForAcc(teacIds,insId,"0");
		}else{
			result = internshipMapper.insertTeacIns(teacIds,insId,"1");
		}
		
		return result;
	}
}

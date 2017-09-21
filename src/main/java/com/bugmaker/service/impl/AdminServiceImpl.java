package com.bugmaker.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.ProfessionClass;
import com.bugmaker.mapper.DeptMapper;
import com.bugmaker.mapper.ProfessionClassMapper;
import com.bugmaker.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Resource
	private ProfessionClassMapper professionClassMapper;
	@Resource
	private DeptMapper deptMapper;
	
	/**
	 * 返回处理过的添加学生页面
	 */
	@Override
	public ModelAndView toAddOneStudentPage(String deptId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Dept> depts = deptMapper.selectAllDept();
		List<ProfessionClass> professionClasses = null;
		if(deptId != null && !deptId.equals("")){
			professionClasses = professionClassMapper.getProfessClassByDeptId(deptId);
			map.put("deptId", deptId);
		}else{
			professionClasses = professionClassMapper.getAllProfessClass();
		}
		
		
		map.put("depts", depts);
		map.put("professionClasses", professionClasses);
		
		return new ModelAndView("admin/addStudent","map",map);
	}

}

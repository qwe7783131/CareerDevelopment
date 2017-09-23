package com.bugmaker.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Profession;
import com.bugmaker.mapper.DeptMapper;
import com.bugmaker.mapper.ProfessionMapper;
import com.bugmaker.service.ProfessionManageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ProfessionManageServiceImpl implements ProfessionManageService {

	@Resource
	private ProfessionMapper professionMapper;
	@Resource
	private DeptMapper deptMapper;

	/**
	 * 获取所有学院并返回视图
	 */
	@Override
	public ModelAndView getAllProfessions(String deptId, String curr) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Dept> depts = deptMapper.selectAllDept();
		List<Profession> professions = null;
		int nowPage = Integer.valueOf(curr);
		PageHelper.startPage(nowPage, 5);
		if(deptId != null && !"".equals(deptId)){
			professions = professionMapper.getProfessionsByDeptID(deptId);
			map.put("deptId", deptId);
		}else{
			professions = professionMapper.getAllProfessionsAndDept();
		}
		PageInfo<Profession> page = new PageInfo<>(professions);
		map.put("depts", depts);
		map.put("page", page);
		return new ModelAndView("admin/professionManage","map",map);
	}

	/**
	 * 添加专业
	 */
	@Override
	public int addProfession(Profession profession) {
		
		return professionMapper.insertProfession(profession);
	}

	/**
	 * 修改专业名称
	 */
	@Override
	public int modifyProfession(Profession profession) {
		
		return professionMapper.modifyProfession(profession);
	}

	/**
	 * 删除专业
	 */
	@Override
	public int deleteProfession(String professId) {
		
		return professionMapper.deleteProfession(professId);
	}
}

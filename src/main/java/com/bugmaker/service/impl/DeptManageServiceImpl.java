package com.bugmaker.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Dept;
import com.bugmaker.mapper.DeptMapper;
import com.bugmaker.service.DeptManageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DeptManageServiceImpl implements DeptManageService {

	@Resource
	private DeptMapper deptMapper;
	/**
	 * 获取当前页curr的学院数据
	 */
	@Override
	public ModelAndView getDeptsPage(String curr) {
		int nowPage = Integer.valueOf(curr);
		//获取第1页，10条内容，默认查询总数count
		PageHelper.startPage(nowPage, 5);
		List<Dept> depts = deptMapper.selectAllDept();
		//用PageInfo对结果进行包装
		PageInfo<Dept> page = new PageInfo<>(depts);
		return new ModelAndView("admin/deptsManage", "page", page);
	}
	
	/**
	 * 添加一个学院的信息
	 */
	@Override
	public int addOneDept(Dept dept) {
		
		return deptMapper.insertOneDept(dept);
	}

	/**
	 * 修改学院信息
	 */
	@Override
	public int modifyDept(Dept dept) {
		
		return deptMapper.modifyDept(dept);
	}

	/**
	 * 删除学院
	 */
	@Override
	public int deleteDept(String deptId) {
		
		return deptMapper.deleteDept(deptId);
	}

}

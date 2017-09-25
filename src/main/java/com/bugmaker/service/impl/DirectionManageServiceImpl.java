package com.bugmaker.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Direction;
import com.bugmaker.mapper.DirectionMapper;
import com.bugmaker.service.DirectionManageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DirectionManageServiceImpl implements DirectionManageService {

	@Resource
	private DirectionMapper directionMapper;
	
	@Override
	public ModelAndView toDirectionManagePage(String curr) {
		int nowPage = Integer.valueOf(curr);
		Dept dept = new Dept();//dept应该从session获取
		dept.setId("13d59d9fa01411e7b4d800163e083221");
		PageHelper.startPage(nowPage, 5);
		List<Direction> directions = directionMapper.selectDirectionByDept(dept); //调用mapper接口，通过学院id查询专业方向
		System.out.println(directions);
		PageInfo<Direction> page = new PageInfo<Direction>(directions);
		System.out.println(page);
		return new ModelAndView("teacher/releaseDirect","page",page);
	}

	/**
	 * 添加专业方向信息
	 */
	@Override
	public int addDirection(Direction direction) {
		Dept dept = new Dept();//dept应该从session获取
		dept.setId("13d59d9fa01411e7b4d800163e083221");//需从session获取
		direction.setDept(dept);
		direction.setEnable(1); //首次发布必须置为有效
		direction.setStatus(0);//发布时暂不开通学生填报权限
		return directionMapper.insertDirection(direction);
	}

	/**
	 * 查询方向信息并返回视图
	 */
	@Override
	public ModelAndView toModifyDirectPage(String directId) {
		Direction direction = directionMapper.selectDirectionById(directId);
		
		return new ModelAndView("teacher/modifyDirect", "direction", direction);
	}

	/**
	 * 修改专业方向信息
	 */
	@Override
	public int modifyDirection(Direction direction) {
		
		return directionMapper.updateDirection(direction);
	}

	/**
	 * 删除专业方向信息
	 */
	@Override
	public int deleteDirection(String directId) {
		
		return directionMapper.deleteDirection(directId);
	}
}

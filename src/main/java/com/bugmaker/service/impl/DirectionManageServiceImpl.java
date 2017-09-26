package com.bugmaker.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	/**
	 * 返回开启和关闭学生填报专业方向志愿页面视图
	 */
	@Override
	public ModelAndView toModifyProfessState(String directId,String curr) {
		
		System.out.println(directId);
		int nowPage = Integer.valueOf(curr);
		Dept dept = new Dept();//dept应该从session获取
		dept.setId("13d59d9fa01411e7b4d800163e083221");//需从session获取
		Map<String, Object> map = new HashMap<String, Object>();
		List<Direction> directions1 = directionMapper.selectDirectionByDept(dept);
		PageInfo<Direction> page = null;
		PageHelper.startPage(nowPage, 5);
		if(directId != null && !directId.equals("")){
			List<Direction> directions = directionMapper.selectDirectByIdAndDeptIdReturnList(directId);
			page = new PageInfo<>(directions);
			map.put("directId", directId);
			
		}else{
			List<Direction> directions = directionMapper.selectDirectionByDept(dept);
			page = new PageInfo<>(directions);
		}
		
		System.out.println(page);
		map.put("directions", directions1);
		map.put("page", page);
		
		return new ModelAndView("leader/setProfessState", "map", map);
	}

	/**
	 * 开启关闭学生选择权限
	 */
	@Override
	public int modifyDirectionState(String directId, String action) {
		int status = 0;
		if(action.equals("1")){
			status = 1;
		}else if(action.equals("0")){
			status = 0;
		}
		
		return directionMapper.updateDirectionState(directId,status);
	}

	/**
	 * 一键开启或关闭
	 */
	@Override
	public int onKeyOpenOrClose(String openOrClose) {
		int status = 0;
		if(openOrClose.equals("1")){
			status = 1;
		}else{
			status = 0;
		}
		Dept dept = new Dept();//dept应该从session获取
		dept.setId("13d59d9fa01411e7b4d800163e083221");//需从session获取
		
		return directionMapper.updateSomeDirectionsStatusByDept(dept.getId(),status);
	}
}

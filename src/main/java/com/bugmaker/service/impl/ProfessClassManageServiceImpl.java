package com.bugmaker.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Profession;
import com.bugmaker.bean.ProfessionClass;
import com.bugmaker.mapper.DeptMapper;
import com.bugmaker.mapper.ProfessionClassMapper;
import com.bugmaker.mapper.ProfessionMapper;
import com.bugmaker.service.ProfessClassManageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ProfessClassManageServiceImpl implements ProfessClassManageService {

	@Resource
	private ProfessionClassMapper professionClassMapper;
	@Resource
	private DeptMapper deptMapper;
	@Resource
	private ProfessionMapper professionMapper;

	/**
	 * 按条件查询出班级并返回视图
	 */
	@Override
	public ModelAndView toProfessClaPage(String deptId, String professId,
			String curr) {
		int nowPage = Integer.valueOf(curr);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Dept> depts = deptMapper.selectAllDept();
		List<Profession> professions = null;
		List<ProfessionClass> professionClasses = null;
		if(deptId != null && !deptId.equals("")){
			System.out.println("有dept");
			professions = professionMapper.getProfessionsByDeptID(deptId);
			PageHelper.startPage(nowPage, 5);
			if(professId != null && !professId.equals("")){
				System.out.println("有profess");
				professionClasses = professionClassMapper.selectProfessClasByProfessId(professId); //根据专业id查询专业班级
				map.put("professId", professId);
			}else{
				System.out.println("没有profess");
				System.out.println(deptId);
				professionClasses = professionClassMapper.getProfessClassByDeptId(deptId); //根据学院id查询专业班级
				System.out.println(professionClasses);
			}
			map.put("deptId", deptId);
			
		}else{
			System.out.println("没有dept");
			if(professId != null && !professId.equals("")){
				System.out.println("有profess");
				PageHelper.startPage(nowPage, 5);
				professionClasses = professionClassMapper.selectProfessClasByProfessId(professId); //根据专业id查询专业班级
				map.put("professId", professId);
				if(!professionClasses.isEmpty()){
					deptId = professionClasses.get(0).getProfession().getDept().getId();
				}else{
					deptId = professionMapper.selectProfessById(professId).getDept().getId(); //根据专业id获取专业
				}
				map.put("deptId", deptId);
				professions = professionMapper.getProfessionsByDeptID(deptId);
			}else{
				System.out.println("没有profess");
				professions = professionMapper.getAllProfessionsAndDept();
				PageHelper.startPage(nowPage, 5);
				professionClasses = professionClassMapper.getAllProfessClass(); //查询所有的专业班级
			}
		}
		PageInfo<ProfessionClass> page = new PageInfo<>(professionClasses);
		map.put("depts", depts);
		map.put("professions", professions);
		map.put("page", page);
		return new ModelAndView("admin/professClassManage", "map", map);
	}

	/**
	 * 添加专业班级
	 */
	@Override
	public int addProfessClass(ProfessionClass professionClass) {
		
		return professionClassMapper.addProfessClass(professionClass);
	}

	/**
	 * 修改专业班级名称
	 */
	@Override
	public int modifyProfessCla(ProfessionClass professionClass) {
		
		return professionClassMapper.modifyProfessCla(professionClass);
	}

	/**
	 * 删除专业班级
	 */
	@Override
	public int deleteProfessCla(String professClaId) {
		
		return professionClassMapper.deleteProfessClaById(professClaId);
	}
}

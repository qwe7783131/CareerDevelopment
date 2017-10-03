package com.bugmaker.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.bean.Outteacher;

public interface OutTeacherService {
	ModelAndView selectAllOutTeacher(String curr);
	List<Outteacher> selectAllOutTeacherByParams(Outteacher outteacher);

	//查询所有企业教师
	public List<Outteacher> getAllOutteacher();

	//查询数据跳转到outteacherManage
	public ModelAndView toOutteacherManage(String currentPage);

	//添加企业教师
	public String addOutteacher(String userInfo) throws IOException;

	//查询出所有企业跳转到addOutteacher
	public ModelAndView toAddOutteacher();

	//删除企业教师
	public String deleteOutteacher(String id);

	//跳转到企业教师
	public ModelAndView toModifyOutteacher(String id,String companyid,String name,String sex,String age,String phone,String email) throws UnsupportedEncodingException;

	//修改企业教师
	public String modifyOutteacher(String userInfo,String id) throws IOException;

	//模糊查询企业教师
	public ModelAndView selectOutTeacherByParams(String compamy,String name,String currentPage);
}

package com.bugmaker.service;

import javax.servlet.http.HttpServletRequest;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import com.bugmaker.bean.UserRole;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

public interface AddStudentService {

	//添加单个学生
	int addOneStudent(Student student);

	//批量添加
	int addMulyiStus(HttpServletRequest request) throws Exception;

	//获取数据跳转到studentManage
	ModelAndView studentManageView(String currentPage);

	//查询学生信息
	ModelAndView selectStuByParams(String id, String username , String dept, String currentPage);

	//修改学生信息
	String updateStu(String userString) throws IOException;

	//添加学生角色
	String addStuRole(UserRole userRole);

	List<Dept> selectAllDept();

	List<Student> selectAllStu();

	int deleteStu(String id);

	//获取所有学院（修改时用）
	public ModelAndView modifyStu();

	//修改学生信息
	public int modifyStudentImpl(String userString) throws IOException;
}

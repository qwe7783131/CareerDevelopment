package com.bugmaker.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.bugmaker.bean.*;
import com.bugmaker.service.AddTeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.fileupload.FileItem;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bugmaker.constant.UserConstant;
import com.bugmaker.mapper.DeptMapper;
import com.bugmaker.mapper.ProfessionClassMapper;
import com.bugmaker.mapper.StudentMapper;
import com.bugmaker.mapper.UserMapper;
import com.bugmaker.service.AddStudentService;
import com.bugmaker.utils.UploadUtil;
import com.bugmaker.utils.XslResolveUtil;
import org.springframework.web.servlet.ModelAndView;

@Service("stuService")
public class AddStudentServiceImpl implements AddStudentService {

	@Autowired
	@Qualifier("stuService")
	AddStudentService studentService;

	@Resource
	private StudentMapper studentMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private DeptMapper deptMapper;
	@Resource
	private ProfessionClassMapper professionClassMapper;

	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public void setDeptMapper(DeptMapper deptMapper) {
		this.deptMapper = deptMapper;
	}

	public void setProfessionClassMapper(ProfessionClassMapper professionClassMapper) {
		this.professionClassMapper = professionClassMapper;
	}

	/**
	 * 调用mapper添加单个学生信息
	 */
	@Override
	public int addOneStudent(Student student) {
		student.getUser().setType(UserConstant.StudentType);
		student.getUser().setCreatTime(new Date());
		student.getUser().setEnable(1);
		student.getUser().setPassword(new Md5Hash(student.getId(), student.getUser().getPassword()).toString());
		int result = studentMapper.insertStudent(student);
		result = userMapper.insertUser(student.getUser());
		UserRole userRole = new UserRole();
		userRole.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		userRole.setUser(student.getUser());
		Role role = new Role();
		role.setId("1");
		userRole.setRole(role);
		userMapper.insertUserRole(userRole);
		return result;
	}

	/**
	 * 批量添加学生信息
	 * @throws Exception 
	 */
	@Override
	public int addMulyiStus(HttpServletRequest request) throws Exception {
		List<FileItem> fileItems = UploadUtil.getUploadFileStream(request);
		System.out.println(fileItems);
		int result = 0;
		for(FileItem fileItem : fileItems){
			if(!fileItem.isFormField()){
				InputStream in = fileItem.getInputStream();
				List<Dept> depts = deptMapper.selectAllDept();
				List<ProfessionClass> classes = professionClassMapper.getAllProfessClass();
				List<Student> students = XslResolveUtil.getStudentsFromXSL(in, classes, depts);
				System.out.println(students);
				result = studentMapper.insertStudents(students);
				List<User> users = new ArrayList<>();
				for(Student student : students){
					users.add(student.getUser());
				}
				result = userMapper.insertUsers(users);
			}
		}
		return result;
	}


	//获取数据跳转到studentManage
	public ModelAndView studentManageView(String currentPage){
		Map<String ,Object> map = new HashMap<String, Object>();
		Integer currPage = Integer.valueOf(currentPage);
		PageHelper.startPage(currPage, 6);
		List<Student> selectAllStu = studentService.selectAllStu();
		PageInfo<Student> page = new PageInfo<>(selectAllStu);
		List<Dept> selectAllDept = studentService.selectAllDept();
		map.put("page",page);
		map.put("selectAllDept",selectAllDept);
		return new ModelAndView("/admin/studentManage","map",map);
	}

	//查询所有学院
	@Override
	public List<Dept> selectAllDept() {
		List<Dept> deptList = deptMapper.selectAllDept();
		return deptList;
	}

	//查询所有学生
	@Override
	public List<Student> selectAllStu() {
		List<Student> userList = studentMapper.selectAllStudent();
//		for(Student student : userList){
//			System.out.println(student);
//		}
		return  userList;
	}

	//删除学生
	@Override
	public int deleteStu(String id) {
		int i = studentMapper.deleteStudentById(id);
		return i;
	}

	//修改学生信息
	@Override
	public String updateStu(String userString) throws IOException {
//		System.out.println("执行修改controller");
//		System.out.println(userString);
		ObjectMapper mapper = new ObjectMapper();
		Map userMap = mapper.readValue(userString, Map.class);
		System.out.println(userMap);
		Dept dept = new Dept();
		dept.setId(userMap.get("dept").toString());
		com.bugmaker.bean.User user = new User();
		user.setId(userMap.get("id").toString());
		user.setUsername(userMap.get("username").toString());
		user.setPassword((new Md5Hash(userMap.get("id").toString(),userMap.get("password").toString())).toString());
		user.setSex(userMap.get("sex").toString());
		user.setAge(Integer.valueOf(userMap.get("age").toString()));
		user.setPhone(userMap.get("phone").toString());
		user.setEmail(userMap.get("email").toString());
		user.setDept(dept);
		user.setCreatTime(new Date());
		user.setEnable(Integer.parseInt(userMap.get("enable").toString()));
		user.setType(2);
		Student student = new Student();
		student.setUser(user);
		return "" + studentMapper.updateStudentById(student);
	}

	//添加教师角色
	@Override
	public String addStuRole(UserRole userRole) {
		return "" + studentMapper.insertStudentRole(userRole);
	}

	//模糊查询
	@Override
	public ModelAndView selectStuByParams(String id, String username , String dept, String currentPage) {
		Map<String ,Object> map = new HashMap<String, Object>();
		User user = new User();
		user.setUsername(username);
		Dept dept1 = new Dept();
		dept1.setId(dept);
		user.setDept(dept1);
		user.setId(id);
		Student student = new Student();
		student.setUser(user);
		Integer currPage = Integer.valueOf(currentPage);
		PageHelper.startPage(currPage, 6);
		List<Student> userList = studentMapper.selectStudentByParams(student);
		for(Student users : userList){
			System.out.println(users);
		}
		PageInfo<Student> page = new PageInfo<>(userList);
		map.put("page",page);
		List<Dept> selectAllDept = studentService.selectAllDept();
		map.put("selectAllDept",selectAllDept);
		if(id.equals("") && username.equals("") && dept.equals("")){
			return new ModelAndView("redirect:/admin/studentManage.do","map",map);
		}
		else {
			return new ModelAndView("/admin/studentManage","map",map);
		}
	}

	//获取所有学院（修改时用）
	public ModelAndView modifyStu(User user){
		Map<String,Object> map = new HashMap<String, Object>();
		List<Dept> deptList = studentService.selectAllDept();
//		for (Dept dept : deptList){
//			System.out.println(dept);
//		}
		List<ProfessionClass> professionClasses = professionClassMapper.getAllProfessClass();
		map.put("selectPC",professionClasses);
		map.put("selectAllDept",deptList);
		map.put("user",user);
//		System.out.println(user);
		return new ModelAndView("admin/modifyStudent","map",map);
	}

	//修改学生信息
	public int modifyStudentImpl(String userString) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map userMap = mapper.readValue(userString, Map.class);
		Student student = new Student();
		User user = new User();
		user.setId(userMap.get("id").toString());
		user.setUsername(userMap.get("username").toString());
		user.setPassword(userMap.get("password").toString());
		user.setSex(userMap.get("sex").toString());
		user.setPhone(userMap.get("phone").toString());
		user.setEmail(userMap.get("email").toString());
		Dept dept = new Dept();
		dept.setId(userMap.get("dept").toString());
		user.setDept(dept);
		DirectionClass directionClass = new DirectionClass();
		directionClass.setId(userMap.get("class").toString());
		student.setDirectionClass(directionClass);
		student.setUser(user);
		userMapper.updateUserById(user);

		return studentMapper.updateStudentById(student);
	}
}

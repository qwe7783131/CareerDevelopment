package com.bugmaker.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.ProfessionClass;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import com.bugmaker.constant.UserConstant;
import com.bugmaker.mapper.DeptMapper;
import com.bugmaker.mapper.ProfessionClassMapper;
import com.bugmaker.mapper.StudentMapper;
import com.bugmaker.mapper.UserMapper;
import com.bugmaker.service.AddStudentService;
import com.bugmaker.utils.UploadUtil;
import com.bugmaker.utils.XslResolveUtil;

@Service
public class AddStudentServiceImpl implements AddStudentService {

	@Resource
	private StudentMapper studentMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private DeptMapper deptMapper;
	@Resource
	private ProfessionClassMapper professionClassMapper;
	
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

}

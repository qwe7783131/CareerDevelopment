package com.bugmaker.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.springframework.stereotype.Service;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.ProfessionClass;
import com.bugmaker.bean.Student;
import com.bugmaker.constant.UserConstant;
import com.bugmaker.mapper.StudentMapper;
import com.bugmaker.service.AddStudentService;
import com.bugmaker.utils.UploadUtil;
import com.bugmaker.utils.XslResolveUtil;

@Service
public class AddStudentServiceImpl implements AddStudentService {

	@Resource
	private StudentMapper studentMapper;
	/**
	 * 调用mapper添加单个学生信息
	 */
	@Override
	public int addOneStudent(Student student) {
		student.getUser().setType(UserConstant.StudentType);
		student.getUser().setCreatTime(new Date());
		
		return studentMapper.insertStudent(student);
	}

	/**
	 * 批量添加学生信息
	 * @throws Exception 
	 */
	@Override
	public int addMulyiStus(HttpServletRequest request) throws Exception {
		List<FileItem> fileItems = UploadUtil.getUploadFileStream(request);
		int result = 0;
		for(FileItem fileItem : fileItems){
			if(!fileItem.isFormField()){
				InputStream in = fileItem.getInputStream();
				List<Dept> depts = new ArrayList<Dept>();
				List<ProfessionClass> classes = new ArrayList<ProfessionClass>();
				List<Student> students = XslResolveUtil.getStudentsFromXSL(in, classes, depts);
				result = studentMapper.insertStudents(students);
			}
		}
		return result;
	}

}

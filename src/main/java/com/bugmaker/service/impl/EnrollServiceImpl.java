package com.bugmaker.service.impl;

import com.bugmaker.bean.*;
import com.bugmaker.constant.UserConstant;
import com.bugmaker.mapper.*;
import com.bugmaker.service.AddStudentService;
import com.bugmaker.service.EnrollService;
import com.bugmaker.utils.RequestUtil;
import com.bugmaker.utils.UploadUtil;
import com.bugmaker.utils.XslResolveUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EnrollServiceImpl implements EnrollService {

	@Resource
	private EnrollMapper enrollMapper;

	/**
	 * 插入学生填报志愿
	 * @param directId
	 * @return
	 */
	@Override
	public int insertEnroll(String directId) {
		Enroll enroll = new Enroll();
		Direction direction = new Direction();
		direction.setId(directId);
		enroll.setDirection(direction);
		//获取当前用户id
		User currentUser = RequestUtil.getCurrentUser();
		Student student = new Student();
		//把当前用户id插入到student中
		student.setId(currentUser.getId());
		enroll.setStudent(student);
		enroll.setCreateTime(new Date());
		int i = enrollMapper.insertEnroll(enroll);
		return i;
	}
}

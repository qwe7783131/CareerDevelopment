package com.bugmaker.service;

import java.util.List;

import com.bugmaker.bean.Company;
import com.bugmaker.bean.Internship;
import com.bugmaker.bean.Job;

public interface InternshipService {
	
	//获取所有公司
	public List<Company> getAllCompany();
	
	//通过公司ID获取岗位信息
	public List<Job> getJobByCompanyId(String id);
	
	//添加项目信息
	public Boolean insertInternship(Internship internship);


}

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
	
	//查询所有项目
	public List<Internship> getAllInternship();
	
	//通过ID删除项目
	public int deleteInternshipById(String internshipId);
	
	//获取所有岗位
	public List<Job> getAllJob();
	
	//修改项目名称、岗位
	public int updateInternshipById(Internship internship);


}

package com.bugmaker.service;

import java.util.List;

import com.bugmaker.bean.Company;
import com.bugmaker.bean.Internship;
import com.bugmaker.bean.Job;

public interface InternshipService {
	//添加项目信息
	/*public boolean insertInternship(Internship internship);
	public boolean insertCompany(Company company);
	public boolean insertJob(Job job);*/
	
	public List<Company> getAllCompany();
	public List<Job> getJobByCompanyId(String id);


}

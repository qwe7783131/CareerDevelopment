package com.bugmaker.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bugmaker.bean.Company;
import com.bugmaker.bean.Internship;
import com.bugmaker.bean.Job;
import com.bugmaker.mapper.CompanyMapper;
import com.bugmaker.mapper.InternshipMapper;
import com.bugmaker.mapper.JobMapper;
import com.bugmaker.service.InternshipService;

@Service
public class InternshipServiceImpl implements InternshipService{
	
	@Resource
	private InternshipMapper internshipMapper;
	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private JobMapper jobMapper;
	
	/*String companyId =null;
	
	String jobId = null;
	String interId = null;
   
	@Override
	public boolean insertInternship(Internship internship) {
		interId = getID();
		internship.setId(interId);
		internship.setJobId(jobId);
		internshipMapper.insertInternship(internship);
		
		return true;
	}

	@Override
	public boolean insertCompany(Company company) {
		
		companyId = getID();
		
		company.setId(companyId);
		companyMapper.insertCompany(company);
		
		
		return true;
	}

	@Override
	public boolean insertJob(Job job) {
		jobId = getID();
		job.setId(jobId);
		job.setCompanyId(companyId);
		job.setOutteacId("1");
		jobMapper.insertJob(job);
		return true;
	}

	 public static String getID(){  
	        
	        String uuid = UUID.randomUUID().toString().replace("-", "");  
	        return uuid;  
	    }*/

	@Override
	public List<Company> getAllCompany() {
		List<Company> companys = companyMapper.getAllCompany();
		return companys;
	}

	@Override
	public List<Job> getJobByCompanyId(String id) {
		List<Job> jobs = jobMapper.getJobByCompanyId(id);
		return jobs;
	}  

}

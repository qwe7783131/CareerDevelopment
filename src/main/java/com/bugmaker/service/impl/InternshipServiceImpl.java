package com.bugmaker.service.impl;

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
	
	String companyId = UUID.randomUUID().toString().replace("-", "");
	String jobId = UUID.randomUUID().toString().replace("-", "");
	String interId = UUID.randomUUID().toString().replace("-", "");

	@Override
	public boolean insertInternship(Internship internship) {
		internship.setId(interId);
		internship.setJobId(jobId);
		internshipMapper.insertInternship(internship);
		return true;
	}

	@Override
	public boolean insertCompany(Company company) {
		
		
		company.setId(companyId);
		companyMapper.insertCompany(company);
		
		
		return true;
	}

	@Override
	public boolean insertJob(Job job) {
		job.setId(jobId);
		job.setCompanyId(companyId);
		job.setOutteacId("1");
		jobMapper.insertJob(job);
		return true;
	}

	

}

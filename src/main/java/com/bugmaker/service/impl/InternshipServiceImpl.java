package com.bugmaker.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bugmaker.bean.Company;
import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Internship;
import com.bugmaker.bean.Job;
import com.bugmaker.bean.User;
import com.bugmaker.mapper.CompanyMapper;
import com.bugmaker.mapper.DeptMapper;
import com.bugmaker.mapper.InternshipMapper;
import com.bugmaker.mapper.JobMapper;
import com.bugmaker.service.InternshipService;
import com.bugmaker.utils.RequestUtil;

@Service
public class InternshipServiceImpl implements InternshipService{
	
	@Resource
	private InternshipMapper internshipMapper;
	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private JobMapper jobMapper;
	@Resource
	private DeptMapper deptMapper;
	
	//获取所有公司
	@Override
	public List<Company> getAllCompany() {
		List<Company> companys = companyMapper.selectAllCompany();
		
		return companys;
	}
	
	//获取所有学院
		@Override
		public List<Dept> getAllDept() {
			
			List<Dept> depts = deptMapper.selectAllDept();
			/*for (Dept dept : depts) {
				System.out.println(dept);
			}*/
			return depts;
		}

	//通过公司ID获取岗位
	@Override
	public List<Job> getJobByCompanyId(String id) {
		List<Job> jobs = jobMapper.getJobByCompanyId(id);
		return jobs;
	}

	//添加实习项目
	@Override
	public Boolean insertInternship(Internship internship) {
		//生成项目UUID
		String interId = null;
		interId = UUID.randomUUID().toString().replace("-", "");
		internship.setId(interId);
		internship.setStatus(0);
		internship.setEnable(1);
		//System.out.println(internship);
		int test = internshipMapper.insertInternship(internship);
		if(test>0)
		{
			return true;
		}else{
			return false;
		}
		
	}

	//获取所有实习项目信息
	@Override
	public List<Internship> getAllInternship() {
		
		User currentUser = RequestUtil.getCurrentUser();
		List<Internship> internships= internshipMapper.selectAllInternship(currentUser.getDept().getId());
		/*for (Internship internship : internships) {
			System.out.println(internship);
		}*/
		return internships;
	}

	@Override
	public int deleteInternshipById(String internshipId) {
		
		return internshipMapper.deleteInternshipById(internshipId);
	}

	@Override
	public List<Job> getAllJob() {
		List<Job> jobs=jobMapper.getAllJob();
		return jobs;
	}

	@Override
	public int updateInternshipById(Internship internship) {
		if(internship.getEnable()!=1){
			internship.setEnable(0);
		}
		
		return internshipMapper.updateInternshipById(internship);
	}

	@Override
	public List<Internship> getInternshipByName(String name) {
		List<Internship> internships = internshipMapper.selectInternshipByName(name);
		return internships;
	}  

}

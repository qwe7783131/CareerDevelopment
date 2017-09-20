package com.bugmaker.bean;
/**
 * 添加项目用的扩展类
 * @author NY
 *
 */
public class InternshipBean {
	private Internship internship;//项目
	private Job job;         //岗位
	private Company company; //公司
	
	
	public Internship getInternship() {
		return internship;
	}
	public void setInternship(Internship internship) {
		this.internship = internship;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
}

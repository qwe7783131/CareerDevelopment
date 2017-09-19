package com.bugmaker.bean;

/**
 * 专业班级，对应profession_class
 */
public class ProfessionClass {

	private String id;
	private Profession profession;	//专业
	private String className;		//班级名称
	private Dept dept;				//学院
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "ProfessionClass [id=" + id + ", profession=" + profession
				+ ", className=" + className + ", dept=" + dept + "]";
	}
	
}

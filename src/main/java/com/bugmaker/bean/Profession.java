package com.bugmaker.bean;
/**
 *      专业表
 */
public class Profession {
    private String id;

    private String name;

    private String describe;

    private Dept dept;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Profession [id=" + id + ", name=" + name + ", describe="
				+ describe + ", dept=" + dept + "]";
	}

    
}
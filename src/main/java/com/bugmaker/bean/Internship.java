package com.bugmaker.bean;

import java.util.List;

/**
 *      实习项目表
 */
public class Internship {
    private String id;

    private String type;

    private Job job;
    
    private String name;

	private List<User> teachers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<User> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "Internship{" +
				"id='" + id + '\'' +
				", type='" + type + '\'' +
				", job=" + job +
				", name='" + name + '\'' +
				", teachers=" + teachers +
				'}';
	}
}
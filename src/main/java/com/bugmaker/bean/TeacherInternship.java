package com.bugmaker.bean;

import java.util.List;

public class TeacherInternship {
	private User teacher;
	private List<TeacIns> teacIns;
	public User getTeacher() {
		return teacher;
	}
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
	public List<TeacIns> getTeacIns() {
		return teacIns;
	}
	public void setTeacIns(List<TeacIns> teacIns) {
		this.teacIns = teacIns;
	}
	@Override
	public String toString() {
		return "TeacherInternship [teacher=" + teacher + ", teacIns=" + teacIns + "]";
	}
	
	
}

package com.bugmaker.bean;

public class Student {
    private String id;
    private String classId;
    private String direc_class_id;
    private User user;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getDirec_class_id() {
		return direc_class_id;
	}
	public void setDirec_class_id(String direc_class_id) {
		this.direc_class_id = direc_class_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", classId=" + classId
				+ ", direc_class_id=" + direc_class_id + ", user=" + user + "]";
	}
}
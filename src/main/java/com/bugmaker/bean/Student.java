package com.bugmaker.bean;

public class Student {
    private String id;
    private ProfessionClass professionClass;	//专业班级
    private DirectionClass directionClass;		//方向班级
    private User user;							//基表
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ProfessionClass getProfessionClass() {
		return professionClass;
	}
	public void setProfessionClass(ProfessionClass professionClass) {
		this.professionClass = professionClass;
	}
	public DirectionClass getDirectionClass() {
		return directionClass;
	}
	public void setDirectionClass(DirectionClass directionClass) {
		this.directionClass = directionClass;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", professionClass=" + professionClass
				+ ", directionClass=" + directionClass + ", user=" + user + "]";
	}
    
}
package com.bugmaker.constant;

public interface UserConstant {

	/**
	 * 用户类型常量
	 */
	public static int StudentType = 1;       //学生用户类型
	public static int TeacherType = 2;       //教师用户类型
	public static int OutTeacherType = 3;    //企业教师用户类型
	public static int CounselorType = 4;     //辅导员用户类型
	public static int LeaderType = 5;        //系领导用户类型

	/**
	 * 用户状态 0为注销，1为正常
	 */
	public static int UserEnable = 1;
	public static int UserDisable = 0;
}

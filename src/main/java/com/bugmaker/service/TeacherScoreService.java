package com.bugmaker.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bugmaker.bean.InsVoluntee;
import com.bugmaker.bean.Score;
import com.bugmaker.bean.Student;

public interface TeacherScoreService {
	
	/**
     * 根据学院获取所有学生填报的项目志愿
     * @param deptId 学院id
     * @param type 顶岗或者跟岗
     * @param professClassId 专业班级id
     * @param status 项目志愿的状态，判断是否通过
     * @return
     */
	List<InsVoluntee> selectInsVolunteerByParam(String deptId,int type,String professClassId,String internshipId,int status);
    
	//教师评分
	int giveOneScore(Score score);
	
	//教师获取学生成绩
	List<Score> selectScoreByParam(Integer jobType, Student student);
	
	/**
     * 根据企业教师id获取所有学生填报的跟岗项目志愿
     * @return
     */
	List<InsVoluntee> selectStusAndInsByOutteacId(String outTeacherId);
	
	//企业教师评分
	int makeOneScore(Score score);
    
}

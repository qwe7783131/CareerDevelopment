package com.bugmaker.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bugmaker.bean.InsVoluntee;
import com.bugmaker.bean.Score;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import com.bugmaker.mapper.InsVolunteeMapper;
import com.bugmaker.mapper.ScoreMapper;
import com.bugmaker.service.TeacherScoreService;
import com.bugmaker.utils.RequestUtil;

@Service
public class TeacherScoreServiceImpl implements TeacherScoreService{
	
	@Resource
	private InsVolunteeMapper insVolunteeMapper;
	@Resource
	private ScoreMapper scoreMapper;

	@Override
	public List<InsVoluntee> selectInsVolunteerByParam(String deptId, int type, String professClassId,
			String internshipId, int status) {
		List<InsVoluntee> ins = insVolunteeMapper.selectInsVolunteerByParam(deptId, type, professClassId, internshipId, status);
		return ins;
	}

	@Override
	public int giveOneScore(Score score) {
		User currentUser = RequestUtil.getCurrentUser();
		User teacher = new User();
		teacher.setId(currentUser.getId());
		score.setTeacher(teacher);
		score.setType("顶岗");
		String id = null;
		id = UUID.randomUUID().toString().replace("-", "");
		score.setId(id);
		//System.out.println(score);
		return scoreMapper.insertOrUpdateScore(score);
	}

	@Override
	public List<Score> selectScoreByParam(Integer jobType, Student student) {
		List<Score> score = scoreMapper.selectScoreByParam(jobType, student);
		//System.out.println(score);
		return score;
	}

	@Override
	public List<InsVoluntee> selectStusAndInsByOutteacId(String outTeacherId) {
		List<InsVoluntee> ins = insVolunteeMapper.selectStusAndInsByOutteacId(outTeacherId);
		return ins;
	}

	@Override
	public int makeOneScore(Score score) {
		User currentUser = RequestUtil.getCurrentUser();
		User teacher = new User();
		teacher.setId(currentUser.getId());
		score.setTeacher(teacher);
		score.setType("跟岗");
		String id = null;
		id = UUID.randomUUID().toString().replace("-", "");
		score.setId(id);
		System.out.println(score);
		return scoreMapper.insertOrUpdateScore(score);
	}

}

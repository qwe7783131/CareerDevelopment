package com.bugmaker.mapper;

import com.bugmaker.bean.Protocol;
import com.bugmaker.bean.Score;
import com.bugmaker.bean.Student;

import java.util.List;

public interface ScoreMapper {

    int insertOrUpdateScore(Score score);

    List<Score> selectScoreByParam(Integer jobType, Student student);
}

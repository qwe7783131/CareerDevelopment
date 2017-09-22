package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Score;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class ScoreMapperTest extends BaseTest {

    @Autowired
    private ScoreMapper scoreMapper;

    @Test
    public void test01(){
        Score score = new Score();

        Student student = new Student();
        User teacher = new User();

        student.setId("aaa");

        teacher.setId("bbbb");

        score.setId(UUID.randomUUID().toString().replace("-", ""));
        score.setNo(1);
        score.setTeacScore(90.4);
        score.setStudent(student);
        score.setTeacher(teacher);
        score.setType("跟岗");

        scoreMapper.insertOrUpdateScore(score);
    }

    @Test
    public void test02(){

        List<Score> scores = scoreMapper.selectScoreByParam(null, null);
        System.out.println(scores);
    }
}

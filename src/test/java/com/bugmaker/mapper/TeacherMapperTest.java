package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Teacher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TeacherMapperTest extends BaseTest {

    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void testInsert(){
        Teacher teacher = new Teacher();
        teacher.setId("121212");

        System.out.println(teacherMapper.insertTeacher(teacher));
    }

    @Test
    public void testInserts(){
        List<Teacher> teachers = new ArrayList<Teacher>();
        for(int i = 0; i < 5; i++){
            Teacher teacher = new Teacher();
            teacher.setId("teahcer" + i);

            teachers.add(teacher);
        }

        System.out.println(teacherMapper.insertTeachers(teachers));
    }
}

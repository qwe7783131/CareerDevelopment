package com.bugmaker.service.impl;

import com.bugmaker.bean.Student;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import org.junit.Test;
/**
 * Created by Administrator on 2017/9/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-base.xml"})
public class StudentServiceTest {
    @Resource
    private StudentService studentService = null;

    @Test
    public void test() {
        List<Student> selectAllStudent = studentService.selectAllStudent();
        System.out.println(selectAllStudent);

    }

    @Test
    public void te() {

    }
}

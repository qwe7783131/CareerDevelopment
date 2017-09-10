package com.bugmaker.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bugmaker.bean.Student;
import com.bugmaker.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-base.xml"})  
public class MyTest {
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

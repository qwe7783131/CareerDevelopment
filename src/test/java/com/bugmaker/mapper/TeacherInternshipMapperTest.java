package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Company;
import com.bugmaker.bean.TeacIns;
import com.bugmaker.bean.TeacherInternship;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by  on 2017/9/21.
 */
public class TeacherInternshipMapperTest extends BaseTest {
    @Autowired
    TeacherInternshipMapper teacherInternshipMapper;

    @Test
    public void getTeacInsByTeacherIdTest() {
        /*List<TeacIns> teacInsByTeacherId = teacherInternshipMapper.getTeacInsByTeacherId("48");
        for (TeacIns teacIns : teacInsByTeacherId) {
			System.out.println(teacIns);
        }*/
    	/*System.out.println("11111111111111");
        List<TeacherInternship> teacInsByTeacherId = teacherInternshipMapper.getTeacInsByTeacherId("48");
        for (TeacherInternship teacherInternship : teacInsByTeacherId) {
			System.out.println(teacherInternship);
		}
       */
    }
}

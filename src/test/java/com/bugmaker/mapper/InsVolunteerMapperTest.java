package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by guan on 2017/9/21.
 */
public class InsVolunteerMapperTest extends BaseTest {
    @Autowired
    InsVolunteeMapper insVolunteeMapper;

    @Test
    public void insertInsVolunteerTest() {
        InsVoluntee insVoluntee = new InsVoluntee();
        insVoluntee.setId("12");
        Internship internship = new Internship();
        internship.setId("1");
        insVoluntee.setInternship(internship);
        Student student = new Student();
        student.setId("1");
        User user = new User();
        user.setId("1");
        insVoluntee.setStudent(student);
        insVoluntee.setTeacher(user);
        insVolunteeMapper.insertInsVolunteer(insVoluntee);
    }

}

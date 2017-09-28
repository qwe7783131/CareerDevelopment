package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.*;
import com.bugmaker.constant.ProtocolConstant;
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
//        insVoluntee.setTeacher(user);
        insVolunteeMapper.insertInsVolunteer(insVoluntee);
    }

    @Test
    public void selectInsVolunteerByParamTest() {
        List<InsVoluntee> insVoluntees = insVolunteeMapper.selectInsVolunteerByParam("e2c3cc8ba07a11e7b4d800163e083221",
                ProtocolConstant.ONJOB, "5e70bcf5a10e11e7b4d800163e083221","", 2);
        System.out.println(insVoluntees);
    }
}

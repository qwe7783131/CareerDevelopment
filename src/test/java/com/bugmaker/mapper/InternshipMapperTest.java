package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by guan on 2017/9/21.
 */
public class InternshipMapperTest extends BaseTest {
    @Autowired
    InternshipMapper internshipMapper;

    @Test
    public void updateTeacherByTeacInsIdTest(){
        TeacIns teacIns = new TeacIns();
        User teacher = new User();
        teacher.setId("5");
        teacIns.setTeacher(teacher);
        teacIns.setId("1");
        internshipMapper.updateTeacherByTeacInsId(teacIns);
    }

    @Test
    public void selectAllTeacherByInternshipIdTest() {
        List<Internship> internships = internshipMapper.selectAllTeacherByInternshipId("4a741aead1834415be26fe71e1ce9c53");
        for (Internship internship :
                internships) {
            System.out.println(internship);
        }
    }

    @Test
    public void selectInsVolunteerByStuIdTest() {
        Internship internship = internshipMapper.selectInsVolunteerByStuId("201424133223");
        System.out.println(internship);
    }

//    @Test
//    public void selectInternshipAndTeacByNameTest() {
//        List<Internship> internships = internshipMapper.selectInternshipAndTeacByName("家");
//        for (Internship internship :
//                internships) {
//            System.out.println(internship);
//        }
//    }

    @Test
    public  void selectAllInternshipAndTeacTest() {
        List<Internship> internships = internshipMapper.selectAllInternshipAndTeac("");
        for (Internship internship :
                internships) {
            System.out.println(internship);
        }
    }

    @Test
    public void selectInternshipByNameTest() {
        List<Internship> internships = internshipMapper.selectInternshipByName("酒店");
        for (Internship internship:
             internships) {
            System.out.println(internship);
        }
    }

    @Test
    public void updateInternshipByIdTest() {
        Internship internship = new Internship();
        Job job = new Job();
        job.setId("1");
        internship.setId("1");
        internship.setJob(job);
        internship.setName("aaa");
        int i = internshipMapper.updateInternshipById(internship);
        System.out.println(i);
    }

    @Test
    public void deleteInternshipByIdTest() {
        int i = internshipMapper.deleteInternshipById("1");
        System.out.println(i);
    }

    @Test
    public void selectAllInternshipTest() {
        List<Internship> internships = internshipMapper.selectAllInternship();
        for (Internship insertship :
                internships) {
            System.out.println(insertship);
        }
    }

    @Test
    public void insertTest() {
        Internship internship = new Internship();
        internship.setId("2");
        internship.setType("顶岗");
        internship.setName("职业生涯规划");
        Job job = new Job();
        job.setId("1");
        internship.setJob(job);
        int i = internshipMapper.insertInternship(internship);
        System.out.println(i);
    }
}

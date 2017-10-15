package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.StuLog;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class StuLogMapperTest extends BaseTest{

    @Autowired
    private StuLogMapper stuLogMapper;

    @Test
    public void testInsert(){
        StuLog stuLog = new StuLog();
        stuLog.setId(UUID.randomUUID().toString().replace("-", ""));

        stuLog.setContent("asasascopcipscipsci按打款后");
        Student student = new Student();
        User user = new User();
        user.setId("aaaa");
        student.setUser(user);
        stuLog.setStudent(student);

        stuLog.setWriteDate(new Date());

        stuLogMapper.insertLog(stuLog);
    }

    @Test
    public void testSelect(){
        String stuId = "aaaa";
        stuLogMapper.selectByParam(stuId);
    }

    @Test
    public void testSelectTeacher(){
        String stuId = "201424133223";

        String Id = stuLogMapper.selectOutTeacherByStuId(stuId);

        System.out.println(Id);
    }

    @Test
    public void testSelectByTea(){
        String teaId = "22";

        List<StuLog> stuLogs = stuLogMapper.selectByTeaId(teaId);

        System.out.println(stuLogs);
    }

}

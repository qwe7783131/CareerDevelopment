package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Protocol;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import com.bugmaker.constant.ProtocolConstant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class ProtocolMapperTest extends BaseTest {

    @Autowired
    ProtocolMapper protocolMapper;

    @Test
    public void test01(){
        Protocol protocol = new Protocol();
        String stuId = "20142413";
        User user = new User();
        user.setId(stuId);
        Student student = new Student();
        student.setUser(user);
        protocol.setStudent(student);
        protocol.setId(UUID.randomUUID().toString().replace("-",""));
        protocol.setReport("aa");
        protocol.setType("跟岗");
        protocolMapper.insertOrUpdateDocument(protocol);
    }

    @Test
    public void test02(){
        String stuId = "20142413";
        Student student = new Student();
        User user = new User();
        user.setId(stuId);
        student.setUser(user);
        List<Protocol> protocols = protocolMapper.selectProtocolByParam(null, student);
        System.out.println(protocols);
    }
}

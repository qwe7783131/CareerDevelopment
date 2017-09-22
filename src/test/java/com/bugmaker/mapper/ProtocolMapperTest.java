package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Protocol;
import com.bugmaker.bean.Student;
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
//        protocol.setId(UUID.randomUUID().toString().replace("-", ""));
        protocol.setId("0991aef4e295453b879b05187cc7fd5c");
        protocol.setType("跟岗");
        Student student = new Student();
        student.setId("asasas");
        protocol.setStudent(student);
        protocol.setReport("report");
        protocol.setSafeProtocal("asasa11sas");
        protocol.setInternshipApplication("accc");
        protocol.setAcceptProve("ass");
        protocol.setInternshipRecord("scscs");

        protocolMapper.insertOrUpdateDocument(protocol);
    }

    @Test
    public void test02(){
        Student student = new Student();
        student.setId("201424133223");
        List<Protocol> protocols = protocolMapper.selectProtocolByParam(ProtocolConstant.ONJOB, student);
        System.out.println(protocols);
    }
}

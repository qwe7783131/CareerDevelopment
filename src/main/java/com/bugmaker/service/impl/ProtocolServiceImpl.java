package com.bugmaker.service.impl;

import com.bugmaker.bean.Protocol;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import com.bugmaker.mapper.ProtocolMapper;
import com.bugmaker.service.ProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProtocolServiceImpl implements ProtocolService{

    @Autowired
    private ProtocolMapper protocolMapper;
    @Override
    public List<Protocol> getProtocolByParam(Integer jobType, Student student) {
        return protocolMapper.selectProtocolByParam(jobType, student);
    }

    @Override
    public Protocol getOneByStuId(Integer jobType, String stuId) {
        Student student = new Student();
        User user = new User();
        user.setId(stuId);
        student.setUser(user);

        Protocol protocol = null;
        List<Protocol> protocols = protocolMapper.selectProtocolByParam(jobType, student);
        if (protocols != null && protocols.size() >= 1){
            protocol = protocols.get(0);
        }
        return protocol;
    }

    @Override
    public boolean setProtocolFileUrl(Protocol protocol) {
        int flag = protocolMapper.insertOrUpdateDocument(protocol);
        return flag == 1 ? true : false;
    }
}

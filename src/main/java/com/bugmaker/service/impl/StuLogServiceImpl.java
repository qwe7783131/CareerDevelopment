package com.bugmaker.service.impl;

import com.bugmaker.bean.StuLog;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import com.bugmaker.mapper.StuLogMapper;
import com.bugmaker.service.StuLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class StuLogServiceImpl implements StuLogService{

    @Autowired
    private StuLogMapper stuLogMapper;
    @Override
    public boolean addLogByStudent(String stuId, String content) {
        StuLog stuLog = new StuLog();
        stuLog.setId(UUID.randomUUID().toString().replace("-", ""));

        stuLog.setContent(content);
        Student student = new Student();
        User user = new User();
        user.setId(stuId);
        student.setUser(user);
        stuLog.setStudent(student);

        stuLog.setWriteDate(new Date());

        int flag = stuLogMapper.insertLog(stuLog);

        return flag == 1 ? true : false;
    }

    @Override
    public List<StuLog> getAllByParam(String stuId) {
        return stuLogMapper.selectByParam(stuId);
    }
}

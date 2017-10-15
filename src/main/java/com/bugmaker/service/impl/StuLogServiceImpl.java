package com.bugmaker.service.impl;

import com.bugmaker.bean.Outteacher;
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

        String outTeacherId = stuLogMapper.selectOutTeacherByStuId(stuId);
        User user1 = new User();

        user1.setId(outTeacherId);
        Outteacher outteacher = new Outteacher();
        outteacher.setUser(user1);

        stuLog.setOutSchoolTeacher(outteacher);

        int flag = stuLogMapper.insertLog(stuLog);

        return flag == 1 ? true : false;
    }

    @Override
    public List<StuLog> getAllByParam(String stuId) {
        return stuLogMapper.selectByParam(stuId);
    }


    @Override
    public List<StuLog> getAllByTeaId(String teaId) {
        return stuLogMapper.selectByTeaId(teaId);
    }

    @Override
    public boolean addTeacherWriteBack(String stuLogId, String teaId, String content) {
        int flag = stuLogMapper.addTeacherWriteBack(stuLogId,teaId,content);
        return flag == 1 ? true : false;
    }

    @Override
    public boolean addOutTeacherWriteBack(String stuLogId, String content) {
        int flag = stuLogMapper.addOutTeacherWriteBack(stuLogId, content);
        return flag == 1 ? true : false;
    }

    @Override
    public List<StuLog> getAllByOutId(String outId) {
        return stuLogMapper.selectByOutTeaId(outId);
    }
}

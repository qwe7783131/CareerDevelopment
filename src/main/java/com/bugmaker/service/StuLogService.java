package com.bugmaker.service;

import com.bugmaker.bean.StuLog;

import java.util.List;

public interface StuLogService {

    boolean addLogByStudent(String stuId, String content);

    List<StuLog> getAllByParam(String stuId);

    List<StuLog> getAllByTeaId(String teaId);

    List<StuLog> getAllByOutId(String outId);

    boolean addTeacherWriteBack(String stuLogId, String teaId, String content);

    boolean addOutTeacherWriteBack(String stuLogId, String content);
}

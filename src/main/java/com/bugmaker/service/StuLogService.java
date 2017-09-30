package com.bugmaker.service;

import com.bugmaker.bean.StuLog;

import java.util.List;

public interface StuLogService {

    boolean addLogByStudent(String stuId, String content);

    List<StuLog> getAllByParam(String stuId);
}

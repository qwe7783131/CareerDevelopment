package com.bugmaker.service;

import com.bugmaker.bean.Protocol;
import com.bugmaker.bean.Student;

import java.util.List;

public interface ProtocolService {

    /**
     * 多条件查询 (岗位类型，学生学号，学生姓名）
     * @param jobType
     * @param student
     * @return
     */
    List<Protocol> getProtocolByParam(Integer jobType, Student student);

    /**
     * 根据学号查看唯一的协议记录
     * @param stuId
     * @return
     */
    Protocol getOneByStuId(Integer jobType, String stuId);

    /**
     * 设置协议的文件链接
     * @param protocol
     * @return
     */
    boolean setProtocolFileUrl(Protocol protocol);
}

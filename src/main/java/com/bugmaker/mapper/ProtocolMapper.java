package com.bugmaker.mapper;

import com.bugmaker.bean.Profession;
import com.bugmaker.bean.Protocol;
import com.bugmaker.bean.Student;

import java.util.List;

public interface ProtocolMapper {

    /**
     * 添加或更新协议
     * @param protocol
     * @return
     */
    int insertOrUpdateDocument(Protocol protocol);
    /**
     * 多条件查询 (文档类型，岗位类型，学生学号，学生姓名）
     * @param jobType 岗位类型
     * @param student
     * @return
     */
    List<Protocol> selectProtocolByParam(Integer jobType, Student student);
}

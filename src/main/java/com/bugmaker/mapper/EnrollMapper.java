package com.bugmaker.mapper;

import com.bugmaker.bean.Enroll;

import java.util.List;

/**
 * Created by guan on 2017/9/25.
 */
public interface EnrollMapper {
    /**
     * 判断当前用户是否填写过志愿
     * @return
     */
    String isChooseEnroll(String studentId);

    /**
     * 插入学生填报志愿
     * @param  enroll
     * @return
     */
    int insertEnroll(Enroll enroll);

    /**
     * 根据学生id查询对应的录取情况
     */
    Enroll selectEnrollByStudentId(String StudentId);
}

package com.bugmaker.mapper;

import com.bugmaker.bean.Teacher;

import java.util.List;

public interface TeacherMapper {
    /**
     * 添加老师
     * @param teacher
     * @return
     */
    int insertTeacher(Teacher teacher);

    /**
     * 批量添加老师
     */
    int insertTeachers(List<Teacher> teachers);
}

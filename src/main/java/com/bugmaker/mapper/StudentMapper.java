package com.bugmaker.mapper;

import com.bugmaker.bean.Student;

import java.util.List;

public interface StudentMapper {
    /**
     * 查询所有学生
     * @return
     */
    public List<Student> selectAllStudent();

    /**
     * 添加学生
     * @param student
     * @return
     */
    public boolean insertStudent(Student student);

    /**
     * 批量插入学生
     * @param students
     * @return
     */
    public boolean insertStudents(List<Student> students);
}
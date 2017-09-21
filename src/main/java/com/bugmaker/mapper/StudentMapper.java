package com.bugmaker.mapper;

import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;

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
    public int insertStudent(Student student);

    /**
     * 批量插入学生
     * @param students
     * @return
     */
    public int insertStudents(List<Student> students);

    /**
     * 多条件查询学生
     * @param student
     * @return
     */
    List<User> selectStudentByParams(Student student);
}
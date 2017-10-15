package com.bugmaker.mapper;

import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import com.bugmaker.bean.UserRole;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
     * 多条件查询学生， 可通过学生id，模糊姓名，学院，班级查询
     * @param student
     * @return
     */
    List<Student> selectStudentByParams(Student student);

    //删除学生
    int deleteStudentById(String id);

    //修改学生信息
    int updateStudentById(Student student);

    //添加教师角色
    int insertStudentRole(UserRole userRole);

    //批量更新学生
    int batchUpdate(List<Student> students);

    /**
     * 根据企业教师获取到企业实习的学生列表
     * @param id
     * @param type 
     * @return
     */
	public List<Student> selectStudentsByOutTeacherId(@Param("id") String id, @Param("type") String type);
}
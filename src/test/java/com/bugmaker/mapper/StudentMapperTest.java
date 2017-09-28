package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.*;
import com.bugmaker.constant.UserConstant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StudentMapperTest extends BaseTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testSelectAll(){
        List<Student> students = studentMapper.selectAllStudent();
        System.out.println(students.size());
        for (Student student: students) {
            System.out.println(student);
        }
        System.out.println(students);
    }
    @Test
    public void testInsert(){
        // 仅测试在student表里插入数据
        // 不会在基表里面插入其他信息
        ProfessionClass professionClass = new ProfessionClass();
        professionClass.setId("1222");

//        DirectionClass directionClass = new DirectionClass();
//        directionClass.setId("3333");

        Student student = new Student();
        student.setId("2011119111");
        student.setProfessionClass(professionClass);
//        student.setDirectionClass(directionClass);

        System.out.println(studentMapper.insertStudent(student));
    }

    @Test
    public void testInserts(){
        // 仅测试在student表里插入数据
        // 不会在基表里面插入其他信息
        ProfessionClass professionClass = new ProfessionClass();
        professionClass.setId("1222");

        DirectionClass directionClass = new DirectionClass();
        directionClass.setId("3333");


        List<Student> students = new ArrayList<Student>();
        for(int i = 0 ; i < 5; i ++){
            Student student = new Student();

            student.setId("aasa" + i);
            student.setDirectionClass(directionClass);
            student.setProfessionClass(professionClass);

            students.add(student);
        }


        System.out.println(studentMapper.insertStudents(students));
    }

    @Test
    public void testSelectParams(){
        Student student = new Student();
        Direction direction = new Direction();
        DirectionClass directionClass = new DirectionClass();
        User user = new User();
        Dept dept = new Dept();

        direction.setId("2312313");
        directionClass.setId("21ce7d8da47c4778981e0493b0d0ee0b");
        directionClass.setDirection(direction);
        dept.setId("e2c3cc8ba07a11e7b4d800163e083221");
        user.setDept(dept);
        student.setDirectionClass(directionClass);
        student.setUser(user);
        List<Student> students = studentMapper.selectStudentByParams(student);
        System.out.println(students);
    }

    @Test
    public void testUpdateStu(){
        Student student = new Student();
        ProfessionClass pc = new ProfessionClass();
        pc.setId("aaaaaa");
        DirectionClass dc = new DirectionClass();
        dc.setId("bbbbbb");
        student.setId("21");
        student.setProfessionClass(pc);
        student.setDirectionClass(dc);

        System.out.println(studentMapper.updateStudentById(student));
    }
}

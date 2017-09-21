package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.DirectionClass;
import com.bugmaker.bean.ProfessionClass;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
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
        System.out.println(students);
    }
    @Test
    public void testInsert(){
        // 仅测试在student表里插入数据
        // 不会在基表里面插入其他信息
        ProfessionClass professionClass = new ProfessionClass();
        professionClass.setId("1222");

        DirectionClass directionClass = new DirectionClass();
        directionClass.setId("3333");

        Student student = new Student();
        student.setId("20111119111");
        student.setProfessionClass(professionClass);
        student.setDirectionClass(directionClass);

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
        //待测试
    }
}

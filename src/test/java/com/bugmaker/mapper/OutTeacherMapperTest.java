package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Outteacher;
import com.bugmaker.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class OutTeacherMapperTest extends BaseTest{

    @Autowired
    private OutTeacherMapper outTeacherMapper;

    @Test
    public void getAllOutTeacherTest() {
        List<Outteacher> outteachers = outTeacherMapper.selectAllOutTeacher();
        System.out.println(outteachers);
    }

    @Test
    public void  selectAllOutTeacherByParamsTest() {
        Outteacher outteacher = new Outteacher();
        User user = new User();
        user.setUsername("冠");
        outteacher.setUser(user);
        List<Outteacher> outteachers = outTeacherMapper.selectAllOutTeacherByParams(outteacher);
        System.out.println(outteachers);
    }

}

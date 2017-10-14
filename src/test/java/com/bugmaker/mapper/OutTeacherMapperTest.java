package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Company;
import com.bugmaker.bean.Outteacher;
import com.bugmaker.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;


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

    @Test
    public void addOutteacher(){
        Outteacher outteacher = new Outteacher();
        outteacher.setId(UUID.randomUUID().toString().replace("-",""));
        User user = new User();
        user.setId(outteacher.getId());
        user.setUsername("企业教师3");
        user.setPassword("345");
        user.setSex("0");
        user.setAge(32);
        user.setPhone("34324");
        user.setEmail("231321");
        user.setType(3);
        user.setEnable(1);
        user.setCreatTime(new Date());
        Company company = new Company();
        company.setId("1");
        outteacher.setCompany(company);
        outteacher.setUser(user);
        outTeacherMapper.insertOutteacherUser(outteacher);
    }
    @Test
    public void delete(){
        outTeacherMapper.deleteOutteacher("912");
    }

    @Test
    public void select(){
        Outteacher outteacher = new Outteacher();
        User user = new User();
        //user.setUsername("1");
        outteacher.setUser(user);
        Company company = new Company();
        company.setId("1");
        outteacher.setCompany(company);
        List<Outteacher> outteachers = outTeacherMapper.selectOutTeacherByParams(outteacher);
        for(Outteacher outteacher1 :outteachers){
            System.out.println(outteacher1);
        }
    }
}

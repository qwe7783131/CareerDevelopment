package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Enroll;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EnrollMapperTest extends BaseTest {

    @Autowired
    private EnrollMapper enrollMapper;

    @Test
    public void testSelectAll(){
        List<Enroll> enrolls = enrollMapper.selectAllEnrolls();

        for(Enroll enroll : enrolls){
            System.out.println(enroll);
        }
    }

    @Test
    public void testSelectByParam(){
        List<Enroll> enrolls = enrollMapper.selectByParam(null,null,null,null);


        for(Enroll enroll : enrolls){
            System.out.println(enroll);
        }
    }

    @Test
    public void testUpdate(){
        int a = enrollMapper.updateEnroll("beeeca46a2af11e7b4d800163e083221", 1, "aa");
        System.out.println(a);
    }
}

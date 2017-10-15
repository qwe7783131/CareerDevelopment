package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Company;
import com.bugmaker.bean.InsVoluntee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by guan on 2017/9/21.
 */
public class InternshipRegistrationMapperTest extends BaseTest {
    @Autowired
    InternshipRegistrationMapper internshipRegistrationMapper;

    @Test
    public void t(){
        List<InsVoluntee> insVolunteeList= internshipRegistrationMapper.getInsVoluntee();
        for(InsVoluntee insVoluntee:insVolunteeList){
            System.out.println(insVoluntee);
        }
    }
    @Test
    public void t2(){
        List<InsVoluntee> insVolunteeList= internshipRegistrationMapper.getInsVolunteeByDept("e2c3cc8ba07a11e7b4d800163e083221");
        for(InsVoluntee insVoluntee:insVolunteeList){
            System.out.println(insVoluntee);
        }
    }

}

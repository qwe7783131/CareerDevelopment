package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.InternshipDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by guan on 2017/9/22.
 */
public class InternshipDetailMapperTest extends BaseTest{

    @Autowired
    InternshipDetailMapper internshipDetailMapper;

    @Test
    public void selectInsTeacherByStuIdTest() {

        List<InternshipDetail> internshipDetails = internshipDetailMapper.selectInsTeacherByStuId("201424133223");
        for (InternshipDetail intershipDetail :
                internshipDetails) {
            System.out.println(intershipDetail);
        }
    }

}

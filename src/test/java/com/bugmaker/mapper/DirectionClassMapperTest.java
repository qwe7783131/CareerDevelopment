package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.DirectionClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DirectionClassMapperTest extends BaseTest {

    @Autowired
    private DirectionClassMapper directionClassMapper;

    @Test
    public void testSelectAll(){
        List<DirectionClass> dcs = directionClassMapper.selectAllDirectionClass();

        for(DirectionClass dc : dcs){
            System.out.println(dc);
        }
    }

    @Test
    public void testSelectByDeptId(){
        String deptId = "e2c3cc8ba07a11e7b4d800163e083221";
        List<DirectionClass> dcs = directionClassMapper.selectDirectionClassByDeptId(deptId);

        for(DirectionClass dc : dcs){
            System.out.println(dc);
        }
    }

    @Test
    public void testSelectByDirectId(){
        String directId = "1";
        List<DirectionClass> dcs = directionClassMapper.selectDirectionClassByDirectId(directId);

        for(DirectionClass dc : dcs){
            System.out.println(dc);
        }
    }
}

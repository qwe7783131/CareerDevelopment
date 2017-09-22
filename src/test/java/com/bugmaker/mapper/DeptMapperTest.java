package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Dept;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeptMapperTest extends BaseTest {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void testSelectAl(){
        List<Dept> depts = deptMapper.selectAllDept();
        for(Dept dept : depts){
            System.out.println(dept);
        }
    }
}

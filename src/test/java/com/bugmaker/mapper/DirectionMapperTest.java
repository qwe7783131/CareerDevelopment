package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Direction;
import com.bugmaker.bean.Profession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class DirectionMapperTest extends BaseTest {

    @Autowired
    private DirectionMapper directionMapper;

    @Test
    public void testInsert(){
        Direction direction = new Direction();
        Dept dept = new Dept();
        dept.setId("e2c3cc8ba07a11e7b4d800163e083221");
        direction.setDept(dept);
        direction.setName("adroid开发");
        direction.setDirectDescribe("因为不适合。如果希望开发长期的项目或者制作产品类网站，那么就需要实现特定的设计，为了在维护项目中可以方便地按设计师要求快速修改样式，肯定会逐步编写出各种业务组件、工具类，相当于为项目自行开发一套框架。——来自知乎@Kayo");

        directionMapper.insertDirection(direction);
    }

    @Test
    public void testSelect(){
        Dept dept = new Dept();
        dept.setId("e2c3cc8ba07a11e7b4d800163e083221");
        List<Direction> directions = directionMapper.selectDirectionByDept(dept);
        for(Direction direction : directions){
            System.out.println(direction);
        }
    }
}

package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
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
        direction.setDescribe("test");
        Profession profession = new Profession();
        profession.setId("2");
        direction.setProfession(profession);

        direction.setId(UUID.randomUUID().toString().replace("-", ""));

        directionMapper.insertDirection(direction);
    }

    @Test
    public void testSelect(){
        List<Direction> directions = directionMapper.selectDirectionByParam();
        for(Direction direction : directions){
            System.out.println(direction);
        }
    }
}

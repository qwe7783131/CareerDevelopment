package com.bugmaker.mapper;

import com.bugmaker.bean.DirectionClass;

import java.util.List;

public interface DirectionClassMapper {
    //获得所有方向班级
    List<DirectionClass> selectAllDirectionClass();

    //根据deptid查询专业方向班级
    List<DirectionClass> selectDirectionClassByDeptId(String deptId);

    //根据专业方向id查询专业方向班级
    List<DirectionClass> selectDirectionClassByDirectId(String directId);

    //添加专业方向班级
    int addDirectionClass(DirectionClass directionClass);

    //修改专业方向班级名称
//    int modifyDirectionClass(DirectionClass directionClass);

    //通过id删除专业方向班级
//    int deleteDirectionClassById(String directionClassId);
}

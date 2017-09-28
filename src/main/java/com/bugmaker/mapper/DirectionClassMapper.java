package com.bugmaker.mapper;

import com.bugmaker.bean.DirectionClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DirectionClassMapper {
    //获得所有方向班级
    List<DirectionClass> selectAllDirectionClass();

    //根据deptid查询专业方向班级
    List<DirectionClass> selectDirectionClassByDeptId(String deptId);

    //根据专业方向id查询专业方向班级
    List<DirectionClass> selectDirectionClassByDirectId(String directId);

    //批量添加专业方向班级
    int addMutiDirectionClass(List<DirectionClass> directionClasses);

    //修改专业方向班级名称
//    int modifyDirectionClass(DirectionClass directionClass);

    //通过id删除专业方向班级
//    int deleteDirectionClassById(String directionClassId);

    //通过pcclassId来查找相应的专业方向班级
    DirectionClass selectDirectionClassById(@Param("id") String id);
}

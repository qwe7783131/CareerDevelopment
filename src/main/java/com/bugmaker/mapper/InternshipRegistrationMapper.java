package com.bugmaker.mapper;


import com.bugmaker.bean.InsVoluntee;

import java.util.List;

public interface InternshipRegistrationMapper {
    //查询实习情况登记表
    List<InsVoluntee> getInsVoluntee();

    //通过学院查数据
    List<InsVoluntee> getInsVolunteeByDept(String deptId);

    //查询实习情况登记表顶岗
    List<InsVoluntee> getInsVolunteeIn();

    //通过学院查数据顶岗
    List<InsVoluntee> getInsVolunteeByDeptIn(String deptId);
}

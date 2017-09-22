package com.bugmaker.service;

import com.bugmaker.bean.Internship;

import java.util.List;

public interface StudentServiceXuxu {
    //查询所有志愿（选择志愿列表用）
    List<Internship> selectAllInternshipList();

    //模糊查询
    List<Internship> selectInternshipByName(String internshipString);

    //添加志愿填报
    String addInternship(Internship internship);
}

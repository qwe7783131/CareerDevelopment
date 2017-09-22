package com.bugmaker.service.impl;

import com.bugmaker.bean.Internship;
import com.bugmaker.mapper.InternshipMapper;
import com.bugmaker.service.StudentServiceXuxu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentServiceXuxu")
public class StudentServiceImplXuxu implements StudentServiceXuxu{

    @Autowired
    private InternshipMapper internshipMapper;

    //查询所有志愿（选择志愿列表用）
    @Override
    public List<Internship> selectAllInternshipList() {
        List<Internship> internshipList = internshipMapper.selectAllInternshipAndTeac();
        return internshipList;
    }

    //模糊查询
    @Override
    public List<Internship> selectInternshipByName(String internshipString) {
        System.out.println("执行模糊查询" + internshipString);
        List<Internship> internshipList = internshipMapper.selectInternshipAndTeacByName(internshipString);
        for(Internship internship : internshipList){
            System.out.println(internship);
        }
        return internshipList;
    }

    //添加志愿填报
    @Override
    public String addInternship(Internship internship) {
        return "" + internshipMapper.insertInternship(internship);
    }
}

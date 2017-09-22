package com.bugmaker.mapper;

import com.bugmaker.bean.Dept;

import java.util.List;

public interface DeptMapper {

	//获取所有学院的数据
    List<Dept> selectAllDept();

    //插入一条学院的数据
	int insertOneDept(Dept dept);
}

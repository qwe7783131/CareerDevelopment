package com.bugmaker.mapper;

import com.bugmaker.bean.Dormitory;

import java.util.List;

public interface DormitoryMapper {

    //获取所有宿舍信息
    List<Dormitory> getAllDorm();

    //添加宿舍信息
    int addDormitory(Dormitory dormitory);

    //修改宿舍信息
    int modifyDormitory(Dormitory dormitory);

    //删除宿舍
    int deleteDormitory(String id);

    //搜索
    List<Dormitory> getDormByCompany(String id);
}

package com.bugmaker.mapper;


import com.bugmaker.bean.Internship;

public interface InternshipMapper {

    /**
     * 添加实习项目
     * @param ship
     * @return
     */
    public boolean insertInternship(Internship ship);

}

package com.bugmaker.mapper;


import com.bugmaker.bean.Internship;

import java.util.List;

public interface InternshipMapper {
    /**
     * 通过项目名称模糊查询项目
     * @param name
     * @return
     */
    List<Internship> selectInternshipByName(String name);
    /**
     * 修改实习项目
     * @param internship
     * @return
     */
    int updateInternshipById(Internship internship);

    /**
     * 添加实习项目
     * @param ship
     * @return
     */
    int insertInternship(Internship ship);

    /**
     * 查询所有的实习项目
     */
    List<Internship> selectAllInternship();

    /**
     * 根据id删除实习项目
     * @param internshipId
     * @return
     */
    int deleteInternshipById(String internshipId);

}

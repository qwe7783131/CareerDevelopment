package com.bugmaker.mapper;


import com.bugmaker.bean.Internship;
import com.bugmaker.bean.TeacIns;
import com.bugmaker.bean.User;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InternshipMapper {
    /**
     * 根据teac_ins的id修改指导老师
     * @param teacIns
     * @return
     */
    int updateTeacherByTeacInsId(TeacIns teacIns);
    /**
     * 根据项目id查询所有的指导教师
     * @param internshipId
     * @return
     */
    List<Internship> selectAllTeacherByInternshipId(String internshipId);
    /**
     * 根据学生id查询项目志愿
     * @return
     */
    Internship selectInsVolunteerByStuId(String id);
    /**
     * 根据项目名称模糊查询所有的项目（包含所有的指导教师）
     * @return
     */
    List<Internship> selectInternshipAndTeacByName(String name);
    /**
     * 查询所有的项目（包含所有的指导教师）
     * @return
     */
    List<Internship> selectAllInternshipAndTeac(@Param("type")String type,@Param("name") String name);
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
    List<Internship> selectAllInternship(String deptID);

    /**
     * 根据id删除实习项目
     * @param internshipId
     * @return
     */
    int deleteInternshipById(String internshipId);
    
    /**
     * 根据学院id查询实现项目
     * @param deptId
     * @return
     */
	List<Internship> selectInternshipsByDeptId(String deptId);
	
	/**
	 * 查询所有未选择实习项目的教师
	 * @param deptId 
	 * @return
	 */
	List<User> selectTeachersNoChooseIns(String deptId);
	
	/**
	 * 查询选择此项目的教师
	 * @param insId  项目id
	 * @return 
	 */
	List<TeacIns> selectTeachersByInsAndDept(@Param("insId") String insId);
	
	/**
	 * 更新教师项目表对应教师和项目为通过
	 * @param teacIds
	 * @param insId
	 * @param status 
	 * @return
	 */
	int updateTeacInsForAcc(@Param("teacIds") String[] teacIds, @Param("insId") String insId, @Param("status") String status);
	
	/**
	 * 根据项目InsId和status查询所有的教师项目
	 * @param insId
	 * @param status
	 * @return
	 */
	List<TeacIns> selectTeacsByInsIdAndStatus(@Param("insId") String insId, @Param("status") String status);
	
	/**
	 * 插入teac_ins
	 * @param teacIds
	 * @param insId
	 * @param status
	 * @return
	 */
	int insertTeacIns(@Param("teacIds") String[] teacIds, @Param("insId") String insId, @Param("status") String status);

}

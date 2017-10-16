package com.bugmaker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bugmaker.bean.DormArrange;

public interface DormArrangeMapper {

	/**
	 * 插入宿舍安排列表
	 * @param dormArranges
	 */
	void insertDormArranges(List<DormArrange> dormArranges);

	/**
	 * 通过企业教师获取宿舍安排表
	 * @param id
	 * @param type 
	 * @return
	 */
	List<DormArrange> selectDormArrangeByOutTeacId(@Param("id") String id, @Param("type") String type);

	/**
	 * 修改宿舍号
	 * @param dormaid
	 * @param changDormId
	 */
	int changeDormByid(@Param("dormaid") String dormaid, @Param("changDormId") String changDormId);

	/**
	 * 通过学生id和实习项目类型获取宿舍安排
	 * @param id
	 * @param type
	 * @return
	 */
	DormArrange getDormArrangeByStuIdAndInsType(@Param("id") String id, @Param("type") String type);

	/**
	 * 根据学院id和项目类型查询宿舍安排
	 * @param id
	 * @param type
	 * @return
	 */
	List<DormArrange> getDormArrangeByDept(@Param("id") String id, @Param("type") String type);

}

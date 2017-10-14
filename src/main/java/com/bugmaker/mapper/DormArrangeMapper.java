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

}

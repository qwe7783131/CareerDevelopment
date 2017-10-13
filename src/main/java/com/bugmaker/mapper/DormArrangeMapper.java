package com.bugmaker.mapper;

import java.util.List;

import com.bugmaker.bean.DormArrange;

public interface DormArrangeMapper {

	//插入宿舍安排列表
	void insertDormArranges(List<DormArrange> dormArranges);

}

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

    /**
     * 查询有剩余空床位的宿舍
     * @param id
     * @return
     */
	List<Dormitory> getDormitoryLeaveByOutTeacherId(String id);

	/**
	 * 更新宿舍信息
	 * @param dormitories
	 */
	void updateDormitorys(List<Dormitory> dormitories);

	/**
	 * 原宿舍人数-1
	 * @param dormid
	 */
	int downOnePersonNum(String dormid);

	/**
	 * 更换的宿舍人数+1
	 * @param changDormId
	 */
	void upOnePersonNum(String changDormId);
}

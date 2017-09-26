package com.bugmaker.mapper;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Direction;

import java.util.List;

/**
 * 专业方向
 */
public interface DirectionMapper {

    /**
     * 添加
     */
    int insertDirection(Direction direction);

    /**
     * 查询
     */
    List<Direction> selectDirectionByDept(Dept dept);

    //根据id查询专业方向信息
	Direction selectDirectionById(String directId);

	//修改专业方向信息
	int updateDirection(Direction direction);

	//删除专业方向信息
	int deleteDirection(String directId);
}

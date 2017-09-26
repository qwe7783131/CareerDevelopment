package com.bugmaker.mapper;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.Direction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

	//更新方向的状态
	int updateDirectionState(@Param("directId") String directId, @Param("status") int status);

	//根据学院id和方向id查询，返回list
	List<Direction> selectDirectByIdAndDeptIdReturnList(@Param("directId") String directId,
			@Param("deptId") String deptId);
}

package com.bugmaker.mapper;

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
    List<Direction> selectDirectionByParam();
}

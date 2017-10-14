package com.bugmaker.mapper;

import com.bugmaker.bean.StuLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuLogMapper {

    int insertLog(StuLog stuLog);

    List<StuLog> selectByParam(@Param("stuId") String stuId);
}

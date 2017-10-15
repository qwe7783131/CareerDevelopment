package com.bugmaker.mapper;

import com.bugmaker.bean.StuLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuLogMapper {

    int insertLog(StuLog stuLog);

    List<StuLog> selectByParam(@Param("stuId") String stuId);

    String selectOutTeacherByStuId(String stuId);

    List<StuLog> selectByTeaId(@Param(value="teacherId") String teacherId);

    List<StuLog> selectByOutTeaId(@Param("outId") String outId);

    int addTeacherWriteBack(@Param(value = "Id") String stuLogId, @Param(value = "teacherId") String teaId, @Param("content") String content);

    int addOutTeacherWriteBack(@Param("Id") String stuLogId, @Param("content") String content);
}

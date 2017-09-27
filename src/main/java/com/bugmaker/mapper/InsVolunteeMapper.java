package com.bugmaker.mapper;

import com.bugmaker.bean.InsVoluntee;
import com.bugmaker.bean.ProfessVolunteer;
import org.apache.ibatis.annotations.Param;

/**
 * Created by guan on 2017/9/22.
 */
public interface InsVolunteeMapper {

    /**
     * 判断当前用户填写过项目志愿的状态
     * @return
     */
    String getInsVolunteerStatus(@Param("StudentId") String StudentId);

    /**
     * 插入学生项目志愿
     * @param insVoluntee
     * @return
     */
    int insertInsVolunteer(InsVoluntee insVoluntee);

    /**
     * 根据学生id查询项目志愿
     * @param StudentId
     * @return
     */
    InsVoluntee selectInsVolunteerByStuId(@Param("studentId") String StudentId);

}

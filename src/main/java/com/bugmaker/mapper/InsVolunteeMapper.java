package com.bugmaker.mapper;

import com.bugmaker.bean.InsVoluntee;
import com.bugmaker.bean.ProfessVolunteer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by guan on 2017/9/22.
 */
public interface InsVolunteeMapper {

    /**
     * 通过企业教师名字查询学生姓名和项目名称
     * @param outeacherId
     * @return
     */
    InsVoluntee selectStusAndInsByOutteacId(@Param("outteacherId") String outeacherId);

    /**
     * 审核改变所有项目志愿的状态
     * @param type
     * @param status
     * @return
     */
    int modifyAllInsVolunteerStatus(@Param("type") int type,@Param("status") int status);

    /**
     * 审核改变项目志愿的状态
     * @param insVolunteerId
     * @param status
     * @return
     */
    int modifyInsVolunteerStatus(@Param("insVolunteerId") String insVolunteerId,@Param("status") int status);

    /**
     * 根据学院获取所有学生填报的项目志愿
     * @param deptId 学院id
     * @param type 顶岗或者跟岗
     * @param professClassId 专业班级id
     * @param status 项目志愿的状态，判断是否通过
     * @return
     */

    List<InsVoluntee> selectInsVolunteerByParam(@Param("deptId")String deptId,
                                                @Param("type") int type,
                                                @Param("professClassId") String professClassId,
                                                @Param("internshipId") String internshipId,
                                                @Param("status") int status);

    /**
     * 判断当前用户填写过项目志愿的状态
     * @return
     */
    String getInsVolunteerStatus(@Param("StudentId") String studentId);

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

package com.bugmaker.mapper;

import com.bugmaker.bean.Enroll;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by guan on 2017/9/25.
 */
public interface EnrollMapper {
    /**
     * 判断当前用户是否填写过志愿
     * @return
     */
    String isChooseEnroll(String studentId);

    /**
     * 插入学生填报志愿
     * @param  enroll
     * @return
     */
    int insertEnroll(Enroll enroll);

    /**
     * 根据学生id查询对应的录取情况
     */
    Enroll selectEnrollByStudentId(String StudentId);

    /**
     * 查看所有志愿
     * @return
     */
    List<Enroll> selectAllEnrolls();

    /**
     * 根据筛选条件查询
     * @param deptId 学院id
     * @param directId 志愿方向id
     * @param professClassId 专业班级id
     * @param status 审核状态
     * @return
     */
    List<Enroll> selectByParam(@Param("deptId")String deptId, @Param("directId") String directId,
                               @Param("professClassId") String professClassId, @Param("status")Integer status );

    int updateEnroll(@Param("enrollId") String enrollId, @Param("status") Integer status,
                     @Param("reason") String reason);

    List<Map> getVolunteerInfo(@Param("deptId") String deptId);
}

package com.bugmaker.mapper;

import com.bugmaker.bean.Outteacher;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OutTeacherMapper {
    /**
     * 查询的企业教师
     * @return
     */
    List<Outteacher> selectAllOutTeacher();

    /**
     * 多条件查询企业教师,可通过企业教师id，模糊姓名，模糊公司姓名
     * @return
     */
    List<Outteacher> selectAllOutTeacherByParams(Outteacher outteacher);

    //添加企业教师
    int insertOutteacher(Outteacher outteacher);

    int insertOutteacherUser(Outteacher outteacher);

    //删除企业教师
    int deleteOutteacher(String id);

    //修改企业教师
    int updateOutteacher(User user);

    List<Outteacher> selectOutTeacherByParams(Outteacher outteacher);

}
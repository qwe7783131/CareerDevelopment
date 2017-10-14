package com.bugmaker.mapper;

import com.bugmaker.bean.User;
import com.bugmaker.bean.UserRole;

import java.util.List;
/**
 * Created by guan on 2017/9/19.
 */
public interface UserMapper {
    /**
     * 多条件查询专业负责人
     * @param user
     * @return
     */
    List<User> selectProfessPrincipalByParams(User user);

    /**
     * 多条件查询教师
     * @param user
     * @return
     */
    List<User> selectTeacherByParams(User user);

    /**
     * 多条件查询辅导员
     * @param user
     * @return
     */
    List<User> selectCounselorByParams(User user);

    /**
     * 多条件查询系领导
     * @param user
     * @return
     */
    List<User> selectLeaderByParams(User user);


    /**
     * 查询所有的专业负责人
     * @return
     */
    List<User> getAllProfessPrincipal();

    /**
     * 查询所有的教师
     * @return
     */
    List<User> getAllTeacher();
    /**
     * 根据id修改用户信息
     * @param user  传入需要修改的用户信息
     * @return
     */
    int updateUserById(User user);
    /**
     * 根据id查询登录用户信息
     * @param userName
     * @return User 返回用户信息
     */
    User getUserByUserName(String userName);

    /**
     * 根据用户id删除对应的用户
     * @param userId
     * @return
     */
    int deleteUserById(String userId);

    /**
     * 插入用户角色
     * @param userRole
     * @return
     */
    int insertUserRole(UserRole userRole);

    /**
     * 插入用户基表数据
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 批量插入用户基表数据
     * @param users
     * @return
     */
    int insertUsers(List<User> users);

    /**
     * 查询所有的辅导员
     * @return
     */
    List<User> getAllCounselor();

    /**
     * 查询所有的系领导
     * @return
     */
    List<User> getAllLeader();

}

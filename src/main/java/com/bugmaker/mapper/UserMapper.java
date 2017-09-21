package com.bugmaker.mapper;

import com.bugmaker.bean.User;
import java.util.List;
/**
 * Created by guan on 2017/9/19.
 */
public interface UserMapper {
    /**
     * 查询所有的教师
     * @param type
     * @return
     */
    List<User> getAllTeacher(int type);
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
}

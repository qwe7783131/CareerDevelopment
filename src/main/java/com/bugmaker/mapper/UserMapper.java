package com.bugmaker.mapper;

import com.bugmaker.bean.User;
import java.util.List;
/**
 * Created by guan on 2017/9/19.
 */
public interface UserMapper {
    /**
     * 登录用户查询用户
     * @param userName
     * @return User 返回用户信息
     */
    User getUserByUserName(String userName);
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

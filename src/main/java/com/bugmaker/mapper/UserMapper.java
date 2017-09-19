package com.bugmaker.mapper;

import com.bugmaker.bean.User;

import java.util.List;

public interface UserMapper {

    /**
     * 插入用户基表数据
     * @param user
     * @return
     */
    public boolean insertUser(User user);

    /**
     * 批量插入用户基表数据
     * @param users
     * @return
     */
    public boolean insertUsers(List<User> users);
}

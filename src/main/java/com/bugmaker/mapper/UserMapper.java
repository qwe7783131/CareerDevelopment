package com.bugmaker.mapper;

import com.bugmaker.bean.User;

/**
 * Created by guan on 2017/9/19.
 */
public interface UserMapper {
    User getUserByUserName(String userName);
}

package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapperTest extends BaseTest{

    @Autowired
    private UserMapper userMapper;

    // 未测试
    @Test
    public void testInsert(){
        User user = new User();
        user.setId("201424133209");
        user.setUsername("吴仁杰");
    }
}

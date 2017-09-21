package com.bugmaker.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by guan on 2017/9/19.
 */
public interface UserService {
    /**
     * 登录操作
     * @param userName  用户名
     * @param password  密码
     * @return
     */
    public ModelAndView doLogin(String userName, String password,String rememberMe, HttpServletResponse response) throws IOException;

    public void doLogout();
}

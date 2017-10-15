package com.bugmaker.service.impl;


import com.bugmaker.bean.User;
import com.bugmaker.mapper.UserMapper;
import com.bugmaker.service.UserService;
import com.bugmaker.utils.Object2Json;
import com.bugmaker.utils.RequestUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guan on 2017/9/19.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public ModelAndView doLogin(String userName, String password, String rememberMe, HttpServletResponse response) throws IOException {
        ModelAndView modelAndView = new ModelAndView("login");
        Map<String, String> map = new HashMap<String, String>();
        System.out.println(userName+"  "+password);
        if(userName == null || userName.trim().equals("") || password == null || password.trim().equals("")){
            map.put("message", "1");
            map.put("state", "error");
            modelAndView.addObject("map",map);
            return modelAndView;
        }

        // 获取用户信息
        User user = userMapper.getUserByUserName(userName.trim());
        if (user == null) { // 账号不存在
            map.put("message", "2");
            map.put("state", "error");
            modelAndView.addObject("map",map);
            return modelAndView;
        } else {
//            System.out.println("输入"+userName);
//            System.out.println(user.getId());
//            System.out.println("输入密码"+password);
//            System.out.println(user.getPassword());
//            System.out.println("加密后"+new Md5Hash(password.trim()).toString());
            if (user.getPassword().equals(new Md5Hash(userName.trim(),password.trim()).toString())) { // 判断密码是否正确
                RequestUtil.loginUserInfo(user);
                System.out.println("11");
                System.out.println(user.getType());
                if(rememberMe == "true") {
                    String userInfo = userName + "," + password;
                    Cookie userCookie = new Cookie("userInfo", userInfo);
                    userCookie.setMaxAge(30 * 24 * 60 * 60);
                    userCookie.setPath("/");
                    response.addCookie(userCookie);
                }
                if(user.getType() == 0) {
                    return new ModelAndView("admin/index");
                } else if(user.getType() == 1) {
                    return new ModelAndView("student/index");
                } else if(user.getType() == 2) {
                    return new ModelAndView("teacher/index");
                } else if(user.getType() == 3) {
                    return new ModelAndView("outteacher/index");
                } else if (user.getType() == 4) {
                    return new ModelAndView("counselor/index");
                } else  if (user.getType() == 5) {
                    return new ModelAndView("leader/index");
                } else  if (user.getType() == 6) {
                    return new ModelAndView("professteacher/index");
                }
            } else {
                map.put("message", "3");
                map.put("state", "error");
                modelAndView.addObject("map",map);
                return modelAndView;
            }
        }
        return null;
    }

    @Override
    public void doLogout() {
        RequestUtil.clearUserInfo();
    }
}

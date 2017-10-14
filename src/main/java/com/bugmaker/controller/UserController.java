package com.bugmaker.controller;

import com.bugmaker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wurenjie on 2017/9/12.
 */
@Controller
public class UserController {

    @Autowired
    public UserService userService;
    
    @RequestMapping("toLoginPage.do")
    public String toLoginPage(){
    	return "login";
    }

    @RequestMapping("login.do")
    public ModelAndView doLogin(String userName, String password,String rememberMe, HttpServletResponse response) throws IOException {
        return  userService.doLogin(userName,password,rememberMe,response);
    }

    @RequestMapping("logout.do")
    public String  doLogout() {
        System.out.println("sss");
        userService.doLogout();
        return "redirect:/";
    }
}

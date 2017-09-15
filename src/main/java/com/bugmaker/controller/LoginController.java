package com.bugmaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wurenjie on 2017/9/12.
 */
@Controller
public class LoginController{
	@RequestMapping("xuxu.do")
    public String indexView(){
        return "outteacher/dormitory";
    }
	@RequestMapping("xuxu2.do")
    public String indexView2(){
        return "outteacher/changeDormApply";
    }
	@RequestMapping("xuxu3.do")
    public String indexView3(){
        return "outteacher/changeDorm";
    }
}

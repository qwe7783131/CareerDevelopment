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
        return "teacher/selectVoluntaryReport";
    }
	@RequestMapping("xuxu2.do")
    public String indexView2(){
        return "teacher/releaseDirect";
    }
}

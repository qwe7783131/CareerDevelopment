package com.bugmaker.controller.counselor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wurenjie on 2017/9/12.
 */
@Controller
@RequestMapping("/counselor")
public class CounselorController {
    @RequestMapping("index.do")
    public String indexView(){
        return "counselor/index";
    }
}

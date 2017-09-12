package com.bugmaker.controller.leader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wurenjie on 2017/9/12.
 */
@Controller
@RequestMapping("/leader")
public class LeaderController {
    @RequestMapping("index.do")
    public String indexView(){
        return "leader/index";
    }
}

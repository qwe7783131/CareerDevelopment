package com.bugmaker.controller.outteacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wurenjie on 2017/9/12.
 */
@Controller
@RequestMapping("/outteacher")
public class OutTeacherController {
    @RequestMapping("index.do")
    public String indexView(){
        return "outteacher/index";
    }
}

package com.bugmaker.controller.professteacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wurenjie on 2017/9/12.
 */
@Controller
@RequestMapping("/professteacher")
public class ProfessTeacherController {
    @RequestMapping("index.do")
    public String indexView(){
        return "professteacher/index";
    }
}

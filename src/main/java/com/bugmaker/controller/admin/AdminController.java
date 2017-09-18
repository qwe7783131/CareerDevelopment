package com.bugmaker.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wurenjie on 2017/9/12.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("index.do")
    public String indexView(){
        return "admin/index";
    }

    @RequestMapping("studentManage.do")
    public String studentManageView() {
        return "admin/adminRight/studentManage";
    }

    @RequestMapping("addStudent.do")
    public String addStudent() {
        return "admin/adminRight/addStudent";
    }

}

package com.bugmaker.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bugmaker.service.AdminService;

/**
 * Created by wurenjie on 2017/9/12.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Resource
	private AdminService adminService;

    @RequestMapping("index.do")
    public String indexView(){
        return "admin/index";
    }

    @RequestMapping("studentManage.do")
    public String studentManageView() {
        return "admin/studentManage";
    }

    /**
     * 单个添加
     */
    @RequestMapping("addStudent.do")
    public ModelAndView addStudent(@RequestParam(required=false) String deptId) {
        return adminService.toAddOneStudentPage(deptId);
    }

}

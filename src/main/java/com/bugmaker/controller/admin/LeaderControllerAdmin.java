package com.bugmaker.controller.admin;

import com.bugmaker.bean.Dept;
import com.bugmaker.service.AddTeacherService;
import com.bugmaker.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class LeaderControllerAdmin {

    @Autowired
    @Qualifier("teaService")
    AddTeacherService teacherService;

    @Autowired
    @Qualifier("leaderImpl")
    LeaderService leaderService;

    //获取数据跳转到leaderManage
    @RequestMapping("/leaderManage.do")
    public ModelAndView leaderManageView(@RequestParam(defaultValue="1") String currentPage) {
        return leaderService.leaderManageView(currentPage);
    }


    // 添加单个系领导的控制器
    @ResponseBody
    @RequestMapping(value = "addOneLeader.do", method = RequestMethod.POST)
    public String addOneLeader(@RequestBody String userString) throws IOException {
//        System.out.println(userString);
        return leaderService.addOneLeader(userString);
    }


    //跳转到modifyCounselor
    @RequestMapping("/modifyLeader.do")
    public ModelAndView modifyLeader(){
        return null;
    }

    //修改系领导信息
    @RequestMapping(value = "/modifyLeaderImpl.do", method = RequestMethod.POST)
    @ResponseBody
    public String modifyLeaderImpl(@RequestBody String userString) throws IOException {
//        System.out.println(userString);
        return leaderService.updateLeader(userString);
    }

    /**
     * 获取学院（添加时用）
     */
    @RequestMapping("/leaderSelectDept.do")
    public  String selectDept(ModelMap model){
        List<Dept> selectAllDept = teacherService.selectAllDept();
        model.put("selectAllDept",selectAllDept);
        return "admin/addLeader";
    }

    /**
     * 获取学院（修改系领导时)
     */
    @RequestMapping("/leaderSelectDept2.do")
    public  String selectDept2(ModelMap model){
        List<Dept> selectAllDept = teacherService.selectAllDept();
        model.put("selectAllDept",selectAllDept);
        return "admin/modifyLeader";
    }

    // 删除系领导
    @RequestMapping(value = "/deleteLeader.do", method = RequestMethod.POST)
    @ResponseBody
    public String deleteLeader(@RequestBody String id) {
        return String.valueOf(leaderService.deleteLeader(id.substring(3)));
    }

    //模糊查询
    @RequestMapping("/leaderSelect.do")
    public ModelAndView LeaderSelect(String id,String username ,String dept,@RequestParam(defaultValue="1") String currentPage){
        return leaderService.selectLeaderByParams(id,username,dept,currentPage);
    }
}

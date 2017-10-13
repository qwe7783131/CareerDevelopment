package com.bugmaker.controller.outteacher;

import com.bugmaker.constant.ProtocolConstant;
import com.bugmaker.service.DormitoryServiceAdmin;
import com.bugmaker.service.IssueTaskBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by wurenjie on 2017/9/12.
 */
@Controller
@RequestMapping("/outteacher")
public class OutTeacherController {

    @Resource
    public IssueTaskBookService issueTaskBookService;
    
    @Resource
    private DormitoryServiceAdmin dormitoryServiceAdmin;

    @RequestMapping("index.do")
    public String indexView(){
        return "outteacher/index";
    }
    @RequestMapping("toDormitoryPage.do")
    public String toDormitoryPage() {
        return "outteacher/dormitory";
    }

    /**
     * 顶岗的任务书
     * 获取到所有状态的任务书后跳转页面。
     * @return
     */
    @RequestMapping("toIssueTaskBookPage.do")
    public ModelAndView toIssueTaskBookPage(@RequestParam(defaultValue = "2") String status, @RequestParam(defaultValue = "1") String curr) {
        ModelAndView modelAndView = issueTaskBookService.toIssueTaskBookPage(ProtocolConstant.OUTJOB, curr, status);
        modelAndView.setViewName("outteacher/issueTaskBook");
        return modelAndView;
    }
    /**
     * 跟岗的任务书
     * 获取到所有状态的任务书后跳转页面。
     * @return
     */
    @RequestMapping("toFollowIssueTaskBookPage.do")
    public ModelAndView toFollowIssueTaskBookPage(@RequestParam(defaultValue = "2") String status, @RequestParam(defaultValue = "1") String curr) {
        ModelAndView modelAndView = issueTaskBookService.toIssueTaskBookPage(ProtocolConstant.ONJOB, curr, status);
        modelAndView.setViewName("outteacher/followIssueTaskBook");
        return modelAndView;
    }
    
    @RequestMapping("toDormitoryManagePage.do")
    public String toDormitoryManagePage(){
    	return "outteacher/dormitory";
    }
    
    @ResponseBody
    @RequestMapping("doArrangeDormitory.do")
    public String doArrangeDormitory(){
    	return ""+dormitoryServiceAdmin.doArrangeDormitory();
    }
}

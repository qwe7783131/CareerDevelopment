package com.bugmaker.controller.outteacher;

import java.util.List;

import com.bugmaker.bean.DormArrange;
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
    
    /**
     * 跳转到宿舍安排界面
     * @return
     */
    @RequestMapping("toDormitoryManagePage.do")
    public ModelAndView toDormitoryManagePage(@RequestParam String insType,@RequestParam(defaultValue="1") String pageNum){
    	
    	return dormitoryServiceAdmin.toDormitoryManagePage(insType,pageNum);
    }
    
    /**
     * 执行一键安排宿舍操作
     * @return
     */
    @ResponseBody
    @RequestMapping("doArrangeDormitory.do")
    public String doArrangeDormitory(@RequestParam String insType){
    	return ""+dormitoryServiceAdmin.doArrangeDormitory(insType);
    }
    
    /**
     * 跳转到更换宿舍页面
     * @param dormaid
     * @param stuid
     * @param dormid
     * @return
     */
    @RequestMapping("toChangeDormPage.do")
    public ModelAndView toChangeDormPage(String dormaid, String stuid, String dormid){
    	
    	return dormitoryServiceAdmin.toChangeDormPage(dormaid,stuid,dormid);
    }
    
    /**
     * 更换宿舍
     * @param dormaid
     * @param stuid
     * @param dormid
     * @param changDormId
     * @return
     */
    @ResponseBody
    @RequestMapping("doChangeDorm.do")
    public String doChangeDorm(String dormaid, String stuid, String dormid,String changDormId){
    	return ""+dormitoryServiceAdmin.doChangeDorm(dormaid,stuid,dormid,changDormId);
    }
    
}

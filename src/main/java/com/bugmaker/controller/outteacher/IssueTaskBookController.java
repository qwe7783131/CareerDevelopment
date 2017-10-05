package com.bugmaker.controller.outteacher;

import com.bugmaker.bean.Task;
import com.bugmaker.service.IssueTaskBookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by guan on 2017/9/29.
 */
@Controller
@RequestMapping("/outteacher")
public class IssueTaskBookController {

    @Resource
    IssueTaskBookService issueTaskBookService;

    @ResponseBody
    @RequestMapping("updateIssueTaskBook.do")
    public String updateIssueTaskBook(@RequestBody Task task) {
        System.out.println(task);
        return ""+ issueTaskBookService.updateIssueTaskBook(task);
    }

    /**
     * 跳转到修改任务书页面
     * @param issuetaskId
     * @return
     */
    @RequestMapping("toUpdateTaskBookPage.do")
    public ModelAndView toUpdateTaskBookPage(String issuetaskId) {
        return issueTaskBookService.toUpdateTaskBookPage(issuetaskId);
    }

    /**
     * 跳转到添加任务书页面
     * @return
     */
    @RequestMapping("toAddIssueTaskBookPage.do")
    public String toAddIssueTaskBookPage() {
        return "outteacher/addIssueTaskBook";
    }

    /**
     * 添加任务书
     * @param task
     * @return
     */
    @ResponseBody
    @RequestMapping("addIssueTaskBook.do")
    public String addIssueTaskBook(@RequestBody Task task) {
        return ""+issueTaskBookService.addIssueTaskBook(task);
    }

    /**
     * 发布任务书
     * @param issuetaskId
     * @return
     */
    @ResponseBody
    @RequestMapping("issueTaskBook.do")
    public String issueTaskBook(String issuetaskId) {
        return ""+issueTaskBookService.issueTaskBook(issuetaskId);
    }

    /**
     * 删除任务书
     * @param issuetaskId
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteTaskBook.do")
    public String deleteTaskBook(String issuetaskId) {
        return ""+issueTaskBookService.deleteTaskBook(issuetaskId);
    }
}

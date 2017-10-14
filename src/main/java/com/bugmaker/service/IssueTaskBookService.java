package com.bugmaker.service;

import com.bugmaker.bean.Task;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by guan on 2017/9/29.
 */
public interface IssueTaskBookService {

    /**
     * 根据id修改任务书
     * @param task
     * @return
     */
    public int updateIssueTaskBook(Task task);

    /**
     * 根据任务书id获取任务书后跳转到修改页面
     * @param issuetaskId
     * @return
     */
    public ModelAndView toUpdateTaskBookPage(String issuetaskId);
    /**
     * 返回顶岗任务书页面需要的东西
     * @param jobType
     * @param curr
     * @param status
     * @return
     */
    ModelAndView toIssueTaskBookPage(int jobType, String curr, String status);

    /**
     * 添加任务书
     * @return
     */
    public int addIssueTaskBook(Task task);

    /**
     * 发布任务书
     * @return
     */
    public int issueTaskBook(String issuetaskId);
    /**
     * 删除任务书
     * @return
     */
    public int deleteTaskBook(String issuetaskId);
}

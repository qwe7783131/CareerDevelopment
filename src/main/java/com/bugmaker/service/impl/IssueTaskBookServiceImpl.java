package com.bugmaker.service.impl;

import com.bugmaker.bean.InsVoluntee;
import com.bugmaker.bean.Job;
import com.bugmaker.bean.Task;
import com.bugmaker.bean.User;
import com.bugmaker.mapper.InsVolunteeMapper;
import com.bugmaker.mapper.IssueTaskBookMapper;
import com.bugmaker.mapper.JobMapper;
import com.bugmaker.service.IssueTaskBookService;
import com.bugmaker.utils.RequestUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by guan on 2017/9/29.
 */
@Service
public class IssueTaskBookServiceImpl implements IssueTaskBookService{
    @Resource
    IssueTaskBookMapper issueTaskBookMapper;
    @Resource
    JobMapper jobMapper;
    @Resource
    InsVolunteeMapper insVolunteeMapper;

    /**
     * 根据id修改任务书
     * @param task
     * @return
     */
    public int updateIssueTaskBook(Task task) {
        System.out.println(task);
        return issueTaskBookMapper.updateIssueTaskBook(task);
    }

    /**
     * 根据任务书id获取任务书后跳转到修改页面
     * @param issuetaskId
     * @return
     */
    public ModelAndView toUpdateTaskBookPage(String issuetaskId) {
        ModelAndView modelAndView = new ModelAndView();
        Task task = issueTaskBookMapper.selectIssueTaskBookById(issuetaskId);
        modelAndView.addObject("task",task);
        modelAndView.setViewName("outteacher/updateaIssueTaskBook");
        return modelAndView;
    }

    /**
     * 发布任务书
     * @return
     */
    public int issueTaskBook(String issuetaskId) {
        return issueTaskBookMapper.issueTaskBook(issuetaskId);
    }

    /**
     * 删除任务书
     * @return
     */
    public int deleteTaskBook(String issuetaskId) {
        return issueTaskBookMapper.deleteTaskBook(issuetaskId);
    }

    /**
     * 添加任务书
     * @param task
     * @return
     */
    public int addIssueTaskBook(Task task) {
        User user = RequestUtil.getCurrentUser();
        Job job = jobMapper.selectJobByOutTeacherId(user.getId());
        task.setJob(job);
        task.setCreateTime(new Date());
//        System.out.println(task);
        return issueTaskBookMapper.addIssueTaskBook(task);
    }

    /**
     * 获取参数跳转到发布任务书页面
     * @param jobType
     * @param curr
     * @param status
     * @return
     */
    public ModelAndView toIssueTaskBookPage(int jobType, String curr, String status) {
        int nowPage = Integer.valueOf(curr);
        int statusId = Integer.valueOf(status);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("status",statusId);
        PageHelper.startPage(nowPage,5);
        //根据企业教师id查询出他发布的所有状态的任务书
        List<Task> tasks;
        User user = RequestUtil.getCurrentUser();
        if(user.getType() != 3) {
            //TODO 不是企业教师的时候，根据用户id获取该用户的企业教师id
            //先获取该学生的项目志愿
//            System.out.println(user.getId());
            InsVoluntee insVoluntee = insVolunteeMapper.selectInsVolunteerByStuId(user.getId());
//            System.out.println(insVoluntee);
//            System.out.println(insVoluntee.getInternship().getJob().getOutteacher().getId());
            tasks = issueTaskBookMapper.selectAllIssueTaskByOutTeacher(jobType,insVoluntee.getInternship().getJob().getOutteacher().getId(),statusId);
        } else {
            // 企业教师的时候直接传id进去，不是企业教师的时候就要获取他的企业教师
            tasks = issueTaskBookMapper.selectAllIssueTaskByOutTeacher(jobType, user.getId(), statusId);
        }
        //分页
        PageInfo<Task> page = new PageInfo<>(tasks);
//        System.out.println(page);
        modelAndView.addObject("page",page);

        return modelAndView;
    }
}

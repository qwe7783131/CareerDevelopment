package com.bugmaker.mapper;

import com.bugmaker.bean.Job;
import com.bugmaker.bean.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by guan on 2017/9/29.
 */
public interface IssueTaskBookMapper {

    /**
     * 根据id修改任务书
     * @param task
     * @return
     */
    public int updateIssueTaskBook(@Param("task") Task task);

    /**
     * 根据任务书id获取任务书.
     * @param issuetaskId
     * @return
     */
    Task selectIssueTaskBookById(String issuetaskId);

    /**
     * 发布任务书
     * @return
     */
    int issueTaskBook(String issuetaskId);

    /**
     * 删除任务书
     * @return
     */
    int deleteTaskBook(String issuetaskId);

    /**
     * 根据企业教师id查询出他发布的所有状态的任务书
     * @param jobType
     * @param outTeacherId
     * @return
     */
    List<Task> selectAllIssueTaskByOutTeacher(@Param("jobType") int jobType, @Param("outTeacherId") String outTeacherId, @Param("statusId") int statusId);

    /**
     * 插入一条任务书
     * @return
     */
    int addIssueTaskBook(@Param("task") Task task);


}

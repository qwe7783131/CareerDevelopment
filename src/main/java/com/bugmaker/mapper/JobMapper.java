package com.bugmaker.mapper;

import java.util.List;


import com.bugmaker.bean.Job;
import com.bugmaker.bean.Outteacher;
import com.bugmaker.bean.User;

import java.util.List;

public interface JobMapper {
    /**
     * 添加岗位
     * @param job
     * @return
     */
    int insertJob(Job job);

    /**
     * 根据公司id查询对应的岗位
     */
    List<Job> getJobByCompanyId(String id);

    List<Job> getAllJob();

    //删除job
    int deleteJob(String id);

    //更新job
    int updateJobById(Job job);

    //根据公司id查询企业教师
    List<User> getOutteacherByCompanyId(String id);

    //模糊查询
    List<Job> selectAllJobByCompanyName(String name);
}

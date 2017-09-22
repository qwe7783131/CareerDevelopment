package com.bugmaker.mapper;

import java.util.List;


import com.bugmaker.bean.Job;

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
     * @param companyId 公司的id
     * @return 返回job的列表
     */
    public  List<Job> getJobByCompanyId(String id);

    List<Job> getAllJob();


}

package com.bugmaker.mapper;

import java.util.List;


import com.bugmaker.bean.Job;

public interface JobMapper {
    /**
     * 添加岗位
     * @param job
     * @return
     */
    int insertJob(Job job);
    public  List<Job> getJobByCompanyId(String id);
}

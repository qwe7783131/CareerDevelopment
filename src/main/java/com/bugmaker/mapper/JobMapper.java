package com.bugmaker.mapper;

import com.bugmaker.bean.Job;

public interface JobMapper {
    /**
     * 添加岗位
     * @param job
     * @return
     */
    int insertJob(Job job);
}
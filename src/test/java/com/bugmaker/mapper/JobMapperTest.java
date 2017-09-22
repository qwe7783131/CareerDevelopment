package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Job;
import org.codehaus.jackson.map.deser.ValueInstantiators;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by guan on 2017/9/20.
 */
public class JobMapperTest extends BaseTest{

    @Autowired
    private JobMapper jobMapper;

    @Test
    public void getAllJobTest() {
        List<Job> allJob = jobMapper.getAllJob();
        for (Job job :
                allJob) {
            System.out.println(job);
        }
    }

    @Test
    public void selectJobByCompanyId() {
        List<Job> jobs = jobMapper.getJobByCompanyId("2");
        for (Job job: jobs) {
            System.out.println(job);
        }
    }


}

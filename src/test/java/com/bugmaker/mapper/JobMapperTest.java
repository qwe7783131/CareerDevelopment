package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Company;
import com.bugmaker.bean.Job;
import com.bugmaker.bean.Outteacher;
import com.bugmaker.bean.User;
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
        for (Job job :allJob) {
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

    @Test
    public void selectJOutByCompany(){
        List<User> users = jobMapper.getOutteacherByCompanyId("1");
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void addJob(){
        Company company = new Company();
        Job job = new Job();
        job.setId("9");
        company.setId("8");
        job.setCompany(company);
        job.setName("java");
        job.setSalary(1212.00);
        Outteacher outteacher = new Outteacher();
        outteacher.setId("911");
        job.setOutteacher(outteacher);
        job.setEnable(1);
        System.out.println(jobMapper.insertJob(job));
    }

    @Test
    public void updateJob(){
        Job job = new Job();
        job.setId("1");
//        job.setName(userMap.get("name").toString());
        job.setSalary(5010.00);
        Outteacher outteacher = new Outteacher();
        outteacher.setId("911");
        job.setOutteacher(outteacher);
        System.out.println(jobMapper.updateJobById(job));
    }

}

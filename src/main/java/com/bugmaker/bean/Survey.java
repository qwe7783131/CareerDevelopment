package com.bugmaker.bean;

import java.util.Date;

/**
 *      就业调查表
 */
public class Survey {
    private String id;


    private String status;

    private String enable;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", enable='" + enable + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
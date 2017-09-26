package com.bugmaker.bean;

import java.util.Date;

/**
 *  录取情况表
 * Created by guan on 2017/9/20.
 */
public class Enroll {
    private String id;

    private  Student student;

    private  Direction direction;

    private String reason;

    private int status;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Enroll{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", direction=" + direction +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}

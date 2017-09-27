package com.bugmaker.bean;

import java.util.Date;

/**
 *   学生志愿表
 */
public class InsVoluntee {
    private String id;

    private Student student;

    private Internship internship ;

    private int status;

    private Date createTime;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "InsVoluntee{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", internship=" + internship +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
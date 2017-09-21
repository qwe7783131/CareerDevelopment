package com.bugmaker.bean;

import java.util.Date;

/**
 * Created by guan on 2017/9/20.
 */
public class surveyResult {
    private String id;

    private Survey survey;

    private Student student;

    private String unitName;

    private String unitPerson;

    private String unitPhone;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitPerson() {
        return unitPerson;
    }

    public void setUnitPerson(String unitPerson) {
        this.unitPerson = unitPerson;
    }

    public String getUnitPhone() {
        return unitPhone;
    }

    public void setUnitPhone(String unitPhone) {
        this.unitPhone = unitPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "surveyResult{" +
                "id='" + id + '\'' +
                ", survey=" + survey +
                ", student=" + student +
                ", unitName='" + unitName + '\'' +
                ", unitPerson='" + unitPerson + '\'' +
                ", unitPhone='" + unitPhone + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

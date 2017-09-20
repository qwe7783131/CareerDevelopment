package com.bugmaker.bean;

import java.util.Date;

/*
 *  考勤表
 */
public class CheckIn {
    private String id;

    private Internship  internship;

    private Student student;

    private String state;

    private Date checkAm;

    private Date checkPm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCheckAm() {
        return checkAm;
    }

    public void setCheckAm(Date checkAm) {
        this.checkAm = checkAm;
    }

    public Date getCheckPm() {
        return checkPm;
    }

    public void setCheckPm(Date checkPm) {
        this.checkPm = checkPm;
    }

    @Override
    public String toString() {
        return "CheckIn{" +
                "id='" + id + '\'' +
                ", internship=" + internship +
                ", student=" + student +
                ", state='" + state + '\'' +
                ", checkAm=" + checkAm +
                ", checkPm=" + checkPm +
                '}';
    }
}
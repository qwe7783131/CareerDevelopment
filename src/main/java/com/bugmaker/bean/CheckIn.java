package com.bugmaker.bean;

import java.util.Date;

/*
 *  考勤表
 */
public class CheckIn {
    private String id;

    private String insId;

    private String stuId;

    private String state;

    private Date checkAm;

    private Date checkPm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInsId() {
        return insId;
    }

    public void setInsId(String insId) {
        this.insId = insId == null ? null : insId.trim();
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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
}
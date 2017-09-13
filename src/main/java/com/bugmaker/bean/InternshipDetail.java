package com.bugmaker.bean;
/**
 *      实习分配情况表
 */
public class InternshipDetail {
    private String id;

    private String stuId;

    private String insId;

    private String teacId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getInsId() {
        return insId;
    }

    public void setInsId(String insId) {
        this.insId = insId == null ? null : insId.trim();
    }

    public String getTeacId() {
        return teacId;
    }

    public void setTeacId(String teacId) {
        this.teacId = teacId == null ? null : teacId.trim();
    }
}
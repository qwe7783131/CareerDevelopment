package com.bugmaker.bean;
/**
 *
 */
public class InsVoluntee {
    private String id;

    private String stuId;

    private String teacId;

    private String insId;

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

    public String getTeacId() {
        return teacId;
    }

    public void setTeacId(String teacId) {
        this.teacId = teacId == null ? null : teacId.trim();
    }

    public String getInsId() {
        return insId;
    }

    public void setInsId(String insId) {
        this.insId = insId == null ? null : insId.trim();
    }
}
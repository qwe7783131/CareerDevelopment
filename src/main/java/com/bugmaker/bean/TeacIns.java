package com.bugmaker.bean;
/**
 *      教师负责的实习项目表
 */
public class TeacIns {
    private String id;

    private String teacId;

    private String insId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
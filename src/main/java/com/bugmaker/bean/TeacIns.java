package com.bugmaker.bean;
/**
 *      教师负责的实习项目表
 */
public class TeacIns {
    private String id;

    private User teacher;

    private String insId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public String getInsId() {
        return insId;
    }

    public void setInsId(String insId) {
        this.insId = insId == null ? null : insId.trim();
    }

    @Override
    public String toString() {
        return "TeacIns{" +
                "id='" + id + '\'' +
                ", teacher=" + teacher +
                ", insId='" + insId + '\'' +
                '}';
    }
}
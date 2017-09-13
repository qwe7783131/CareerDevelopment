package com.bugmaker.bean;
/**
 *      教师表
 */
public class Teacher {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
}
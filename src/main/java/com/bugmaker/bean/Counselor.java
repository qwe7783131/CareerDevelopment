package com.bugmaker.bean;
/**
 *      辅导员
 */
public class Counselor {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
}
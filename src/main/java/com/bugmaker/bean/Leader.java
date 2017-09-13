package com.bugmaker.bean;
/**
 *      系领导
 */
public class Leader {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
}
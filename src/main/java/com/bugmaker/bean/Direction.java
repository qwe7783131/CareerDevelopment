package com.bugmaker.bean;
/**
 *      专业方向表
 */
public class Direction {
    private String id;

    private String name;

    private String professId;

    private String describe;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProfessId() {
        return professId;
    }

    public void setProfessId(String professId) {
        this.professId = professId == null ? null : professId.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}
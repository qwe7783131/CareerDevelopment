package com.bugmaker.bean;

/**
 *    班级表
 */
public class Classroom {
    private String id;

    private String name;

    private String deptId;

    private String direcId;

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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getDirecId() {
        return direcId;
    }

    public void setDirecId(String direcId) {
        this.direcId = direcId == null ? null : direcId.trim();
    }
}
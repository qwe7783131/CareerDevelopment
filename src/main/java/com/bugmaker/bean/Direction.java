package com.bugmaker.bean;
/**
 *      专业方向表
 */
public class Direction {
    private String id;

    private String name;

    private Dept dept;

    private int status;

    private int enable;

    private String directDescribe;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getDirectDescribe() {
        return directDescribe;
    }

    public void setDirectDescribe(String directDescribe) {
        this.directDescribe = directDescribe == null ? null : directDescribe.trim();
    }

    @Override
    public String toString() {
        return "Direction{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dept=" + dept +
                ", status=" + status +
                ", enable=" + enable +
                ", directDescribe='" + directDescribe + '\'' +
                '}';
    }
}
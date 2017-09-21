package com.bugmaker.bean;

/**
 *    班级表
 */
public class DirectionClass {
    private String id;

    private String name;

    private Dept dept;

    private Direction direction;

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

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "DirectionClass{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dept=" + dept +
                ", direction=" + direction +
                '}';
    }
}
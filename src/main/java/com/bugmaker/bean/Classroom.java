package com.bugmaker.bean;

/**
 *    班级表
 */
public class Classroom {
    private String id;

    private String name;

//    private Dept dept;

    private Direction direction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", direction=" + direction +
                '}';
    }
}
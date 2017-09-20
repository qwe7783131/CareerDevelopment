package com.bugmaker.bean;
/**
 *      宿舍安排表
 */
public class DormArrange {
    private String id;

    private Student student;

    private Dormitory dormitory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    @Override
    public String toString() {
        return "DormArrange{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", dormitory=" + dormitory +
                '}';
    }
}
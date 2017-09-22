package com.bugmaker.bean;

import java.util.List;

/**
 *      实习分配情况表
 */
public class InternshipDetail {
    private String id;

    private Student student;

    private Internship  internship ;

    private List<User> teachers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public List<User> getTeacher() {
        return teachers;
    }

    public void setTeacher(List<User> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "InternshipDetail{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", internship=" + internship +
                ", teachers=" + teachers +
                '}';
    }
}
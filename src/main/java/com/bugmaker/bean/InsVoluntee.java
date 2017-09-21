package com.bugmaker.bean;
/**
 *   学生志愿表
 */
public class InsVoluntee {
    private String id;

    private Student student;

    private User teacher;

    private Internship internship ;

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

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    @Override
    public String toString() {
        return "InsVoluntee{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", teacher=" + teacher +
                ", internship=" + internship +
                '}';
    }
}
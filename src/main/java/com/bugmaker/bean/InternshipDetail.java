package com.bugmaker.bean;
/**
 *      实习分配情况表
 */
public class InternshipDetail {
    private String id;

    private Student student;

    private Internship  internship ;

    private User teacher;

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

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "InternshipDetail{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", internship=" + internship +
                ", teacher=" + teacher +
                '}';
    }
}
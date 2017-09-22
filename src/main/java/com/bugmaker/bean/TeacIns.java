package com.bugmaker.bean;
/**
 *      教师负责的实习项目表
 */
public class TeacIns {
    private String id;

    private User teacher;

    private Internship internship;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
        return "TeacIns{" +
                "id='" + id + '\'' +
                ", teacher=" + teacher +
                ", internship=" + internship +
                '}';
    }
}
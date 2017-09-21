package com.bugmaker.bean;
/**
 *      分数表
 *
 */
public class Score {
    private String id;

    private Student student;

    private User teacher;

    private Double teacScore;

    private Double outteacScore;

    private Integer no;

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

    public Double getTeacScore() {
        return teacScore;
    }

    public void setTeacScore(Double teacScore) {
        this.teacScore = teacScore;
    }

    public Double getOutteacScore() {
        return outteacScore;
    }

    public void setOutteacScore(Double outteacScore) {
        this.outteacScore = outteacScore;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", teacher=" + teacher +
                ", teacScore=" + teacScore +
                ", outteacScore=" + outteacScore +
                ", no=" + no +
                '}';
    }
}
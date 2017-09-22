package com.bugmaker.bean;
/**
 *      方向志愿表
 */
public class ProfessVolunteer {
    private String id;

    private Student student;

    private Direction direcId1;

    private Direction direcId2;

    private Direction direcId3;

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

    public Direction getDirecId1() {
        return direcId1;
    }

    public void setDirecId1(Direction direcId1) {
        this.direcId1 = direcId1;
    }

    public Direction getDirecId2() {
        return direcId2;
    }

    public void setDirecId2(Direction direcId2) {
        this.direcId2 = direcId2;
    }

    public Direction getDirecId3() {
        return direcId3;
    }

    public void setDirecId3(Direction direcId3) {
        this.direcId3 = direcId3;
    }

    @Override
    public String toString() {
        return "ProfessVolunteer{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", direcId1=" + direcId1 +
                ", direcId2=" + direcId2 +
                ", direcId3=" + direcId3 +
                '}';
    }
}
package com.bugmaker.bean;
/**
 *      方向志愿表
 */
public class ProfessVolunteer {
    private String id;

    private Student student;

    private String direcId1;

    private String direcId2;

    private String direcId3;

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

    public String getDirecId1() {
        return direcId1;
    }

    public void setDirecId1(String direcId1) {
        this.direcId1 = direcId1 == null ? null : direcId1.trim();
    }

    public String getDirecId2() {
        return direcId2;
    }

    public void setDirecId2(String direcId2) {
        this.direcId2 = direcId2 == null ? null : direcId2.trim();
    }

    public String getDirecId3() {
        return direcId3;
    }

    public void setDirecId3(String direcId3) {
        this.direcId3 = direcId3 == null ? null : direcId3.trim();
    }

    @Override
    public String toString() {
        return "ProfessVolunteer{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", direcId1='" + direcId1 + '\'' +
                ", direcId2='" + direcId2 + '\'' +
                ", direcId3='" + direcId3 + '\'' +
                '}';
    }
}
package com.bugmaker.bean;

import java.util.Date;
/**
 *      学生日志表
 */
public class StuLog {
    private String id;

    private Student student;

    private String content;

    private Date writeDate;

    private User teacher;

    private String schoolTeacWriteback;

    private String schoolTeacSign;

    private Date schoolWritebackDate;

    private Outteacher outSchoolTeacher;

    private String outSchoolTeacWriteback;

    private String outSchoolTeacSign;

    private Date outSchoolWritebackDate;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public String getSchoolTeacWriteback() {
        return schoolTeacWriteback;
    }

    public void setSchoolTeacWriteback(String schoolTeacWriteback) {
        this.schoolTeacWriteback = schoolTeacWriteback == null ? null : schoolTeacWriteback.trim();
    }

    public String getSchoolTeacSign() {
        return schoolTeacSign;
    }

    public void setSchoolTeacSign(String schoolTeacSign) {
        this.schoolTeacSign = schoolTeacSign == null ? null : schoolTeacSign.trim();
    }

    public Date getSchoolWritebackDate() {
        return schoolWritebackDate;
    }

    public void setSchoolWritebackDate(Date schoolWritebackDate) {
        this.schoolWritebackDate = schoolWritebackDate;
    }

    public String getOutSchoolTeacWriteback() {
        return outSchoolTeacWriteback;
    }

    public void setOutSchoolTeacWriteback(String outSchoolTeacWriteback) {
        this.outSchoolTeacWriteback = outSchoolTeacWriteback == null ? null : outSchoolTeacWriteback.trim();
    }

    public String getOutSchoolTeacSign() {
        return outSchoolTeacSign;
    }

    public void setOutSchoolTeacSign(String outSchoolTeacSign) {
        this.outSchoolTeacSign = outSchoolTeacSign == null ? null : outSchoolTeacSign.trim();
    }

    public Date getOutSchoolWritebackDate() {
        return outSchoolWritebackDate;
    }

    public void setOutSchoolWritebackDate(Date outSchoolWritebackDate) {
        this.outSchoolWritebackDate = outSchoolWritebackDate;
    }

    public Outteacher getOutSchoolTeacher() {
        return outSchoolTeacher;
    }

    public void setOutSchoolTeacher(Outteacher outSchoolTeacher) {
        this.outSchoolTeacher = outSchoolTeacher;
    }

    @Override
    public String toString() {
        return "StuLog{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", content='" + content + '\'' +
                ", writeDate=" + writeDate +
                ", teacher=" + teacher +
                ", schoolTeacWriteback='" + schoolTeacWriteback + '\'' +
                ", schoolTeacSign='" + schoolTeacSign + '\'' +
                ", schoolWritebackDate=" + schoolWritebackDate +
                ", outSchoolTeacher=" + outSchoolTeacher +
                ", outSchoolTeacWriteback='" + outSchoolTeacWriteback + '\'' +
                ", outSchoolTeacSign='" + outSchoolTeacSign + '\'' +
                ", outSchoolWritebackDate=" + outSchoolWritebackDate +
                '}';
    }
}
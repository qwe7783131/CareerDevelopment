package com.bugmaker.bean;
/**
 *      各种协议的表
 */
public class Protocol {
    private String id;

    private String safeProtocal;

    private String internshipRecord;

    private String acceptProve;

    private String internshipAssess;

    private String report;

    private String internshipApplication;

    private Student student;

    private String type;

    // 用于查询使用，并非是数据库表的字段
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSafeProtocal() {
        return safeProtocal;
    }

    public void setSafeProtocal(String safeProtocal) {
        this.safeProtocal = safeProtocal == null ? null : safeProtocal.trim();
    }

    public String getInternshipRecord() {
        return internshipRecord;
    }

    public void setInternshipRecord(String internshipRecord) {
        this.internshipRecord = internshipRecord == null ? null : internshipRecord.trim();
    }

    public String getAcceptProve() {
        return acceptProve;
    }

    public void setAcceptProve(String acceptProve) {
        this.acceptProve = acceptProve == null ? null : acceptProve.trim();
    }

    public String getInternshipAssess() {
        return internshipAssess;
    }

    public void setInternshipAssess(String internshipAssess) {
        this.internshipAssess = internshipAssess == null ? null : internshipAssess.trim();
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report == null ? null : report.trim();
    }

    public String getInternshipApplication() {
        return internshipApplication;
    }

    public void setInternshipApplication(String internshipApplication) {
        this.internshipApplication = internshipApplication == null ? null : internshipApplication.trim();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    @Override
    public String toString() {
        return "Protocol{" +
                "id='" + id + '\'' +
                ", safeProtocal='" + safeProtocal + '\'' +
                ", internshipRecord='" + internshipRecord + '\'' +
                ", acceptProve='" + acceptProve + '\'' +
                ", internshipAssess='" + internshipAssess + '\'' +
                ", report='" + report + '\'' +
                ", internshipApplication='" + internshipApplication + '\'' +
                ", student=" + student +
                ", type='" + type + '\'' +
                '}';
    }
}
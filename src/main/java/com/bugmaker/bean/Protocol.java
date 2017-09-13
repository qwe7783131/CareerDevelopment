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

    private Integer stuId;

    private String type;

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

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}
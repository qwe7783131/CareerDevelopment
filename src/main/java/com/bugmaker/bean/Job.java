package com.bugmaker.bean;

/**
 *      工作表
 */
public class Job {
    private String id;

    private String companyId;

    private String name;

    private Double salary;

    private String outteacId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getOutteacId() {
        return outteacId;
    }

    public void setOutteacId(String outteacId) {
        this.outteacId = outteacId == null ? null : outteacId.trim();
    }
}
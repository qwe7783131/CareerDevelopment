package com.bugmaker.bean;

/**
 *      工作表
 */
public class Job {
    private String id;

    private Company company;

    private String name;

    private Double salary;

    private String outteacId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", company=" + company +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", outteacId='" + outteacId + '\'' +
                '}';
    }
}
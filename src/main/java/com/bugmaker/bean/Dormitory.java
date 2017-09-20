package com.bugmaker.bean;
/**
 *      宿舍表
 */
public class Dormitory {
    private String id;

    private Company company;

    private Integer total;

    private Integer personNum;

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    @Override
    public String toString() {
        return "Dormitory{" +
                "id='" + id + '\'' +
                ", company=" + company +
                ", total=" + total +
                ", personNum=" + personNum +
                '}';
    }
}
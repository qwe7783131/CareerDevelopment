package com.bugmaker.bean;
/**
 *      企业教师
 */
public class Outteacher {
    private String id;

    private Company company;

    private User user;		//基表

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Outteacher{" +
                "id='" + id + '\'' +
                ", company=" + company +
                ", user=" + user +
                '}';
    }
}
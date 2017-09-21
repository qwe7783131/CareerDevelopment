package com.bugmaker.bean;

/**
 * Created by guan on 2017/9/21.
 */
public class UserRole {
    private String id;
    private User user;
    private Role Role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public com.bugmaker.bean.Role getRole() {
        return Role;
    }

    public void setRole(com.bugmaker.bean.Role role) {
        Role = role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", Role=" + Role +
                '}';
    }
}

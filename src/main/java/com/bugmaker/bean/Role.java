package com.bugmaker.bean;

import java.util.List;

/**
 *      角色表
 */
public class Role {
    private String id;

    private String roleName;

    private String rolePermiss;

    private List<User> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRolePermiss() {
        return rolePermiss;
    }

    public void setRolePermiss(String rolePermiss) {
        this.rolePermiss = rolePermiss == null ? null : rolePermiss.trim();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
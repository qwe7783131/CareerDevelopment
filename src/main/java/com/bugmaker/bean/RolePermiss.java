package com.bugmaker.bean;
/**
 *      角色权限表
 */
public class RolePermiss {
    private String id;

    private Role role;

    private Permiss permiss;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permiss getPermiss() {
        return permiss;
    }

    public void setPermiss(Permiss permiss) {
        this.permiss = permiss;
    }

    @Override
    public String toString() {
        return "RolePermiss{" +
                "id='" + id + '\'' +
                ", role=" + role +
                ", permiss=" + permiss +
                '}';
    }
}
package com.bugmaker.bean;
/**
 *      角色权限表
 */
public class RolePermiss {
    private String id;

    private String roleId;

    private String permissId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getPermissId() {
        return permissId;
    }

    public void setPermissId(String permissId) {
        this.permissId = permissId == null ? null : permissId.trim();
    }
}
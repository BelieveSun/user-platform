package com.believe.sun.user.model;

import com.believe.sun.user.form.RoleForm;

public class Role {
    private Integer id;

    private String role;

    private String description;

    private String permissionId;

    private Integer status;

    public Role(Integer id, String role, String description, String permissionId, Integer status) {
        this.id = id;
        this.role = role;
        this.description = description;
        this.permissionId = permissionId;
        this.status = status;
    }

    public Role() {
        super();
    }

    public Role(RoleForm form) {
        this.role = form.getRole();
        this.description = form.getDescription();
        this.permissionId = form.getPermissionId();
        this.status = form.getStatus();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
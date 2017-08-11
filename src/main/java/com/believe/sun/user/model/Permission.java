package com.believe.sun.user.model;

import com.believe.sun.user.form.PermissionForm;

public class Permission {
    private Integer id;

    private Integer parentId;

    private String name;

    private String description;

    private Integer status;

    public Permission(Integer id, Integer parentId, String name, String description, Integer status) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Permission(PermissionForm form){
        this.parentId = form.getParentId();
        this.name = form.getName();
        this.description = form.getDescription();
        this.status = form.getStatus();
    }

    public Permission() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
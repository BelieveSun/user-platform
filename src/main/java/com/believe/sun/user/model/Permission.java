package com.believe.sun.user.model;

public class Permission {
    private Integer id;

    private Integer parentId;

    private String name;

    private String descriotion;

    private String status;

    public Permission(Integer id, Integer parentId, String name, String descriotion, String status) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.descriotion = descriotion;
        this.status = status;
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

    public String getDescriotion() {
        return descriotion;
    }

    public void setDescriotion(String descriotion) {
        this.descriotion = descriotion == null ? null : descriotion.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}
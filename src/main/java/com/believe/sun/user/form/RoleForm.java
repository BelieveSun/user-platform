package com.believe.sun.user.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by sungj on 17-7-28.
 */
@ApiModel("角色表单")
public class RoleForm {
    @ApiModelProperty("格式：\"ROLE_\"+name")
    private String role;
    @ApiModelProperty("中文描述")
    private String description;
    @ApiModelProperty("权限id字符串")
    private String permissionId;
    @ApiModelProperty("角色状态,0 待定,1 正常,2 停用")
    private Integer status;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

package com.believe.sun.user.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
/**
 * Created by sungj on 17-7-28.
 */
@ApiModel("权限表单")
public class PermissionForm {
    @ApiModelProperty("父权限id,一级权限父权限为0")
    @NotEmpty
    private Integer parentId;
    @ApiModelProperty("格式：user:*(表示具有user的所有权限) 或者 user:create(表示具有创建用户的权限) ...")
    @NotEmpty
    private String name;
    @ApiModelProperty("中文描述")
    private String description;
    @ApiModelProperty("权限是否启用,0 待定,1 正常,2 停用")
    private Integer status;

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
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

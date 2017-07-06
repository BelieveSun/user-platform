package com.believe.sun.user.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by sungj on 17-6-6.
 */
@ApiModel("用户表单")
public class UserForm {
    @ApiModelProperty("账户")
    private String account;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("电话号码")
    private String cellphone;

    public UserForm() {
    }

    public UserForm(String account, String password, String cellphone) {

        this.account = account;
        this.password = password;
        this.cellphone = cellphone;
    }

    public String getAccount() {

        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}

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
    @ApiModelProperty("密码,前端应对密码进行BCrypt加密")
    private String password;
    @ApiModelProperty("电话号码")
    private String cellphone;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("宝贝的亲属身份（宝妈,宝爸...）")
    private String identity;
    @ApiModelProperty("角色id拼接字符串，以\",\"号分割")
    private String roles;
    @ApiModelProperty("头像地址")
    private String headimage;
    @ApiModelProperty("宝贝的id")
    private String babyid;
    @ApiModelProperty("性别：0,女;1,男")
    private Integer sex;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("真实姓名")
    private String realName;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }

    public String getBabyid() {
        return babyid;
    }

    public void setBabyid(String babyid) {
        this.babyid = babyid;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}

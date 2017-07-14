package com.believe.sun.user.model;

import com.believe.sun.user.form.UserForm;

public class User {
    private Integer id;

    private String account;

    private String cellphone;

    private String email;

    private String password;

    private String nickname;

    private String identity;

    private String roles;

    private String headimage;

    private Integer status;

    private String babyid;

    private Integer sex;

    private Integer age;


    public User(Integer id, String account, String cellphone, String email, String password, String nickname, String identity, String roles, String headimage, Integer status, String babyid, Integer sex, Integer age) {
        this.id = id;
        this.account = account;
        this.cellphone = cellphone;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.identity = identity;
        this.roles = roles;
        this.headimage = headimage;
        this.status = status;
        this.babyid = babyid;
        this.sex = sex;
        this.age = age;
    }

    public User(UserForm userForm) {
        this.account = userForm.getAccount();
        this.password = userForm.getPassword();
        this.cellphone = userForm.getCellphone();
    }

    public User() {}



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage == null ? null : headimage.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBabyid() {
        return babyid;
    }

    public void setBabyid(String babyid) {
        this.babyid = babyid == null ? null : babyid.trim();
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

}
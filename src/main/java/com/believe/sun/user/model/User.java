package com.believe.sun.user.model;

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

    private String status;

    private String babyid;

    private Integer sex;

    private String age;

    private String realname;

    public User(Integer id, String account, String cellphone, String email, String password, String nickname, String identity, String roles, String headimage, String status, String babyid, Integer sex, String age, String realname) {
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
        this.realname = realname;
    }

    public User() {
        super();
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }
}
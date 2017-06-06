package com.believe.sun.user.model;

public class Baby {
    private Integer id;

    private String babyName;

    private Integer babyAge;

    private Integer babySex;

    private String babyNickname;

    private String babyHeadimage;

    private String photo;

    public Baby(Integer id, String babyName, Integer babyAge, Integer babySex, String babyNickname, String babyHeadimage, String photo) {
        this.id = id;
        this.babyName = babyName;
        this.babyAge = babyAge;
        this.babySex = babySex;
        this.babyNickname = babyNickname;
        this.babyHeadimage = babyHeadimage;
        this.photo = photo;
    }

    public Baby() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBabyName() {
        return babyName;
    }

    public void setBabyName(String babyName) {
        this.babyName = babyName == null ? null : babyName.trim();
    }

    public Integer getBabyAge() {
        return babyAge;
    }

    public void setBabyAge(Integer babyAge) {
        this.babyAge = babyAge;
    }

    public Integer getBabySex() {
        return babySex;
    }

    public void setBabySex(Integer babySex) {
        this.babySex = babySex;
    }

    public String getBabyNickname() {
        return babyNickname;
    }

    public void setBabyNickname(String babyNickname) {
        this.babyNickname = babyNickname == null ? null : babyNickname.trim();
    }

    public String getBabyHeadimage() {
        return babyHeadimage;
    }

    public void setBabyHeadimage(String babyHeadimage) {
        this.babyHeadimage = babyHeadimage == null ? null : babyHeadimage.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }
}
package com.bd.android.emeblood;

public class UsersRe extends userId {

    String name ;
    String phone;
    String gov;

    public String getName() {
        return name;
    }
    public String getGov() {
        return gov;
    }

    public String  getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setGov(String name) {
        this.gov = gov;
    }


    public void setPhone(String  phone) {
        this.phone = phone;
    }

    public UsersRe(String name, String  phone , String gov) {
        this.name = name;
        this.phone = phone;
        this.gov = gov;
    }

    public UsersRe() {
    }
}

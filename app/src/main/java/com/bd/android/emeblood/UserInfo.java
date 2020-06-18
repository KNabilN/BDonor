package com.bd.android.emeblood;

public class UserInfo {

    String name;
    String bloodType ;

    public UserInfo (String name , String bloodType){
        this.bloodType = bloodType ;
        this.name = name ;
    }

    public String getName() {
        return name;
    }

    public String getBloodType() {
        return bloodType;
    }
}

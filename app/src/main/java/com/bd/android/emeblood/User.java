package com.bd.android.emeblood;

import java.io.Serializable;

public class User implements Serializable{

    String token ;

    public User() {
    }

    public User( String token) {

        this.token = token;
    }



    public String getToken() {
        return token;
    }



    public void setToken(String token) {
        this.token = token;
    }
}

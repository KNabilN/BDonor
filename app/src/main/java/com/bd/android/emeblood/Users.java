package com.bd.android.emeblood;

public class Users extends userId {

    String message , number , HN , govern;

    int counter ;

    public Users(String message, String number, String HN , int noti_num , String govern) {
        this.message = message;
        this.number = number;
        this.govern = govern;
        this.HN = HN;
        this.counter = noti_num;
    }





    public void setCounter(int noti_num) {
        this.counter = noti_num;
    }

    public int getCounter() {
        return counter;
    }
    public String getGovern() {
        return govern;
    }


    public Users() {
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void setGovern(String govern) {
        this.govern = message;
    }


    public void setNumber(String number) {
        this.number = number;
    }

    public void setHN(String HN) {
        this.HN = HN;
    }

    public String getMessage() {
        return message;
    }

    public String getNumber() {
        return number;
    }

    public String getHN() {
        return HN;
    }
}

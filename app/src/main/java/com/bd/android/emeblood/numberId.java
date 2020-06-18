package com.bd.android.emeblood;

import android.support.annotation.NonNull;

@SuppressWarnings("unchecked")
public class numberId {

    public String number;
    public <T extends numberId> T withId (@NonNull final  String number ){

        this.number = number ;
        return (T) this;
    }
}

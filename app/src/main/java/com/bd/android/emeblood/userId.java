package com.bd.android.emeblood;

import android.support.annotation.NonNull;
@SuppressWarnings("unchecked")
public class userId {
    public Long userId ;
    public String userreId ;

    public <T extends userId> T withId (@NonNull final Long id ){
        this.userId = id;

        return (T) this;
    }


    public <T extends userId> T withId (@NonNull final String id ){
        this.userreId = id;

        return (T) this;
    }
}

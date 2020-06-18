package com.bd.android.emeblood;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class AlertReceiver extends BroadcastReceiver {
    //notification receiver
    @Override
    public void onReceive(Context context, Intent intent) {
        String title = "حالة خطيرة" ;
        String body = "اظهار الاستغاثة" ;
        NotificationHelper.displayNotification(context, title, body);
    }
}

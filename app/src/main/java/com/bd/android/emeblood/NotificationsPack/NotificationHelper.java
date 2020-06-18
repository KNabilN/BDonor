package com.bd.android.emeblood.NotificationsPack;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.bd.android.emeblood.UIS.Option;
import com.bd.android.emeblood.R;
import com.bd.android.emeblood.UIS.SendNoti;

public class NotificationHelper {


    public static void displayNotification(Context context,String title , String body) {

        Intent openAct = new Intent(context, Option.class);
        PendingIntent contentIntent = PendingIntent.getActivity(
                context,
                100,
                openAct,
                PendingIntent.FLAG_CANCEL_CURRENT);


        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, SendNoti.ID)
                .setSmallIcon(R.drawable.boy)
                .setContentTitle(title)
                .setContentText(body)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(1, mBuilder.build());

    }
}

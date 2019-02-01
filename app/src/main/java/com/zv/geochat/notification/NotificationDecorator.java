package com.zv.geochat.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.zv.geochat.ChatActivity;
import com.zv.geochat.R;

import static com.zv.geochat.App.CHANNEL_1_ID;

public class NotificationDecorator {

    private static final String TAG = "NotificationDecorator";
    private final Context context;
    // private final NotificationManager notificationMgr;
    private NotificationManagerCompat notificationMgr;

    public NotificationDecorator(Context context, NotificationManagerCompat notificationManager) {
        // notificationManager = NotificationManagerCompat.from(context);
        this.context = context;
        this.notificationMgr = notificationManager;
    }

    public void displaySimpleNotification(String title, String contentText) {
        Intent intent = new Intent(context, ChatActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // notification message
        try {


            Notification noti = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                    .setSmallIcon(android.R.drawable.ic_dialog_info)
                    .setContentTitle(title)
                    .setContentText(contentText)
                    .setContentIntent(contentIntent)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .build();

            noti.flags |= Notification.FLAG_AUTO_CANCEL;
            notificationMgr.notify(0, noti);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, e.getMessage());
        }
    }
}

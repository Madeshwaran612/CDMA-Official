package com.madesh.CDMA_Official.Services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.madesh.CDMA_Official.R;

import java.util.Map;
import java.util.Random;

public class MyFirebaseInstanceService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (remoteMessage.getData().isEmpty()){
            showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
        }else {
            showNotification(remoteMessage.getData());

        }


    }

    private void showNotification(Map<String,String>data){
        String title = data.get("title").toString();
        String body = data.get("body").toString();

        NotificationManager notificationManager= (NotificationManager)getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID ="maddy.CDMA_Tv.Services.test";

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){

            NotificationChannel notificationChannel = new NotificationChannel(NotificationChannel.DEFAULT_CHANNEL_ID,"Notification",
                    NotificationManager.IMPORTANCE_DEFAULT);

            notificationChannel.setDescription("Code Sphere");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.BLUE);
            notificationChannel.enableLights(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,NOTIFICATION_CHANNEL_ID);

        notificationBuilder.setAutoCancel(true).setDefaults(Notification.DEFAULT_ALL).setWhen(System.currentTimeMillis()).setSmallIcon(R.drawable.ccc)
                .setContentTitle(title).setContentText(body).setContentInfo("Info");
        notificationManager.notify(new Random().nextInt(),notificationBuilder.build());



    }

    private void showNotification (String title, String body){

        NotificationManager notificationManager= (NotificationManager)getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID ="maddy.CDMA_Tv.Services.test";

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){

            NotificationChannel notificationChannel = new NotificationChannel(NotificationChannel.DEFAULT_CHANNEL_ID,"Notification",
                    NotificationManager.IMPORTANCE_DEFAULT);

            notificationChannel.setDescription("Code Sphere");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.BLUE);
            notificationChannel.enableLights(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,NOTIFICATION_CHANNEL_ID);

        notificationBuilder.setAutoCancel(true).setDefaults(Notification.DEFAULT_ALL).setWhen(System.currentTimeMillis()).setSmallIcon(R.drawable.ccc)
                .setContentTitle(title).setContentText(body).setContentInfo("Info");
        notificationManager.notify(new Random().nextInt(),notificationBuilder.build());
    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);

        Log.d("TOKENFIREBASE",s);
    }
}

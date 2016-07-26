package io.github.xudaojie.androiddemo.download;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import io.github.xudaojie.androiddemo.R;

/**
 * Created by xdj on 16/7/26.
 */

public class OkHttpReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int percent = intent.getIntExtra("percent", 0);
        Log.d("OkHttpReceiver", percent + "%");

        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("Title")
                .setContentText("已下载:" + percent + "%")
                .setProgress(100, percent, false)
                .setSmallIcon(R.mipmap.ic_launcher) // 必须设置
//                .setContentIntent(pendingIntent)
                .build();

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(10, notification);
    }
}

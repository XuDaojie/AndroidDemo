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

public class OkDownloadReceiver extends BroadcastReceiver {

    /**
     * 消息被点击
     */
    public static final String NOTIFICATION_CLICK = "action.NOTIFICATION_CLICK";
    /**
     * 下载进度改变时
     */
    public static final String PERCENT_CHANGE = "action.PERCENT_CHANGE";

    @Override
    public void onReceive(Context context, Intent intent) {
        int percent = intent.getIntExtra("percent", 0);
        int id = intent.getIntExtra("id", 0);
        String title = intent.getStringExtra("title");
        Log.d("OkHttpReceiver", percent + "%");

        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("Title")
                .setContentText("已下载:" + percent + "%")
                .setProgress(100, percent, false)
                .setSmallIcon(R.mipmap.ic_launcher) // 必须设置
//                .setContentIntent(pendingIntent)
                .build();
//        notification.flags = Notification.FLAG_AUTO_CANCEL;

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(id, notification);
    }
}

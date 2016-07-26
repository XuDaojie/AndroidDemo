package io.github.xudaojie.androiddemo.download;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;

import com.squareup.okhttp.OkHttpClient;

import io.github.xudaojie.androiddemo.R;

/**
 * Created by xdj on 16/7/25.
 */

public class OkDownloadManager {
    private static final OkHttpClient mHttpClient = new OkHttpClient();

    private static final int mId = 10;

    public OkDownloadManager (Context context) {
//        mHttpClient.networkInterceptors()
//                .add(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        return chain.proceed(chain.request())
//                                .newBuilder()
//                                .body(null)
//                                .build();
//                    }
//                });

        IntentFilter filter = new IntentFilter();
        filter.addAction("notification_clicked");
                    filter.addAction("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");

        NotificationClickReceiver receiver = new NotificationClickReceiver();
        context.registerReceiver(receiver, filter);

        Intent i = new Intent(context, NotificationClickReceiver.class);
        i.setAction("notification_clicked");
        i.putExtra("type", mId);
//        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        // 广播必须在Manifest里注册,代码注册无效
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_ONE_SHOT);

        // Notification.Builder.build() 在Api16中才开始支持
        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("Title")
                .setContentText("Text")
                .setProgress(100, 10, false)
                .setSmallIcon(R.mipmap.ic_launcher) // 必须设置
                .setContentIntent(pendingIntent)
//                .addAction(android.R.mipmap.sym_def_app_icon, "确定", pendingIntent)
                .build();

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(mId, notification);
    }

}

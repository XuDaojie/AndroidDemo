package io.github.xudaojie.androiddemo.download;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.github.xudaojie.androiddemo.R;

/**
 * Created by xdj on 16/7/25.
 */

public class OkDownloadManager extends Service {

    private static OkHttpClient mHttpClient;

    private static final int mId = 10;

//    private String url = "https://qd.myapp.com/myapp/qqteam/AndroidQQ/mobileqq_android.apk";
    private String url = "http://pkg3.fir.im/71da3de01a28cff3f9884ada102e22fdbadaab35.apk?attname=app-release.apk_1.0.apk";

    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Log.d("Service", "onCreate");
        if (mHttpClient == null) {
            mHttpClient = new OkHttpClient();
            mHttpClient.networkInterceptors()
                    .add(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Response response = chain.proceed(chain.request());
                            return response.newBuilder()
                                    .body(new ProgressResponseBody(response.body(), new ProgressResponseBody.ProgressListener() {
                                        @Override
                                        public void update(long bytesRead, long contentLength, boolean done) {
                                            Log.d("xxx", bytesRead + "/" + contentLength);
                                        }
                                    }))
                                    .build();
                        }
                    });
        }

//        IntentFilter filter = new IntentFilter();
//        filter.addAction("notification_clicked");
//        filter.addAction("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");

//        NotificationClickReceiver receiver = new NotificationClickReceiver();
//        mContext.registerReceiver(receiver, filter);

        Intent i = new Intent(mContext, NotificationClickReceiver.class);
        i.setAction("notification_clicked");
        i.putExtra("type", mId);
//        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        // 广播必须在Manifest里注册,代码注册无效
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, 0, i, PendingIntent.FLAG_ONE_SHOT);

        // Notification.Builder.build() 在Api16中才开始支持
        Notification notification = new NotificationCompat.Builder(mContext)
                .setContentTitle("Title")
                .setContentText("Text")
                .setProgress(100, 10, true)
                .setSmallIcon(R.mipmap.ic_launcher) // 必须设置
                .setContentIntent(pendingIntent) // 指定点击事件对应的pendingIntent
//                .addAction(android.R.mipmap.sym_def_app_icon, "确定", pendingIntent)
                .build();

        NotificationManager manager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(mId, notification);

        download();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Service", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void download() {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        mHttpClient.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        Log.d("xxx", "xxxxxxxxxxxxxx");
                        saveFile(Environment.getExternalStorageDirectory() + "/Download/okhttp.apk", response.body().byteStream());
                        stopSelf();
                    }
                });

    }

    private void saveFile(String outPath, InputStream stream) throws IOException {
        File file = new File(outPath);
        int len;
        byte[] buf = new byte[2048];

//        InputStream stream = response.body().byteStream();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            while ((len = stream.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
        } finally {
            fos.flush();
            fos.close();
            stream.close();
        }
    }

}

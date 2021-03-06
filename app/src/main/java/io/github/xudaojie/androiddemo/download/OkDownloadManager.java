package io.github.xudaojie.androiddemo.download;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
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
import java.util.HashMap;
import java.util.Map;

import io.github.xudaojie.androiddemo.R;

/**
 * Created by xdj on 16/7/25.
 */
public class OkDownloadManager extends Service {

    private static final String TAG = "OkDownloadManager";

    private static OkHttpClient mHttpClient;

    private Context mContext;
    private LocalBroadcastManager mBroadcastManager;

    private long mTimeline; // 上次发送广播的时间
    private String mUrl; // 正在进行下载的链接

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
                        public Response intercept(final Chain chain) throws IOException {
                            final Request request = chain.request();
                            final String url = chain.request().urlString();
                            final Map<String, Object> tagMap = (Map<String, Object>)request.tag();

                            Response response = chain.proceed(request);
                            return response.newBuilder()
                                    .body(new ProgressResponseBody(response.body(), new ProgressResponseBody.ProgressListener() {
                                        @Override
                                        public void update(long bytesRead, long contentLength, boolean done) {
                                            int percent = (int) ((float)bytesRead / contentLength * 100);
                                            // 广播接收也是在主界面执行的,全部发送的话会造成系统卡顿
                                            long currentTimeline = System.currentTimeMillis();
                                            if (currentTimeline - mTimeline > 600 || done) {

                                                if (done) {
                                                    mUrl = null;
                                                }

                                                mTimeline = currentTimeline;
                                                int id = 0;
                                                if (tagMap != null && tagMap.get("id") != null) {
                                                    id = (int) tagMap.get("id");
                                                }

                                                Intent i = new Intent();
                                                i.setAction("ok_http_download");
                                                i.putExtra("percent", percent);
                                                i.putExtra("url", url);
                                                i.putExtra("id", id);

                                                // 必须也使用LocalBroadcastReceiver进行注册才能接收
                                                mBroadcastManager.sendBroadcast(i);
                                            }

                                        }
                                    }))
                                    .build();
                        }
                    });
            mBroadcastManager = LocalBroadcastManager.getInstance(mContext);

            OkDownloadReceiver okHttpReceiver = new OkDownloadReceiver();
            IntentFilter filter = new IntentFilter();
            filter.addAction("ok_http_download");
            mBroadcastManager.registerReceiver(okHttpReceiver, filter);
        }

//        download();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Service", "onStartCommand");
        if (intent != null && intent.hasExtra("id") && intent.hasExtra("url")) {
            int id = intent.getIntExtra("id", 0);
            String url = intent.getStringExtra("url");
            String fileName = intent.getStringExtra("fileName");
            download(id, url, fileName);
        } else {
            // 服务尚未停止Apk被回收,会再度启动Service
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.cancelAll();
            stopSelf();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("Service", "onBind");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("Service", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d("Service", "onDestroy");
        super.onDestroy();
    }

    public void download(int id, String url, final String fileName) {
        if (mUrl != null) {
            Log.d(TAG, "同时只能进行一个下载");
            return;
        }

        mUrl = url;

        Intent i = new Intent(mContext, NotificationClickReceiver.class);
        i.setAction("notification_clicked");
        i.putExtra("type", id);
//        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        // 广播必须在Manifest里注册,代码注册无效
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, 0, i, PendingIntent.FLAG_ONE_SHOT);

        // Notification.Builder.build() 在Api16中才开始支持
        Notification notification = new NotificationCompat.Builder(mContext)
                .setContentTitle("Download")
                .setContentText("")
                .setProgress(100, 0, true)
                .setSmallIcon(R.mipmap.ic_launcher) // 必须设置
                .setContentIntent(pendingIntent) // 指定点击事件对应的pendingIntent
//                .addAction(android.R.mipmap.sym_def_app_icon, "确定", pendingIntent)
                .build();

        NotificationManager manager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(id, notification);

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Map<String, Object> tags = new HashMap<>();
        tags.put("origin_tag", request.tag());
        tags.put("id", id);

        request = request.newBuilder()
                .tag(tags)
                .build();

        mHttpClient.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        saveFile(Environment.getExternalStorageDirectory() + "/Download/" + fileName, response.body().byteStream());
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

    class MyBinder extends Binder {
        public OkDownloadManager getService() {
            return OkDownloadManager.this;
        }
    }

}
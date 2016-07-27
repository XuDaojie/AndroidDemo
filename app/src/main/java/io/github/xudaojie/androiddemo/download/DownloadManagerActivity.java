package io.github.xudaojie.androiddemo.download;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.github.xudaojie.androiddemo.BaseActivity;
import io.github.xudaojie.androiddemo.R;

/**
 * Created by xdj on 16/7/13.
 */
public class DownloadManagerActivity extends BaseActivity {

    private static final int EXTERNAL_STORAGE_REQ_CODE = 0;

    // QQ
//    private String url = "https://qd.myapp.com/myapp/qqteam/AndroidQQ/mobileqq_android.apk";
    //
    private String url = "http://pkg3.fir.im/71da3de01a28cff3f9884ada102e22fdbadaab35.apk?attname=app-release.apk_1.0.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_manager_activity);

        final Button downloadBtn = (Button) findViewById(R.id.download_btn);
        Button okDownloadBtn = (Button) findViewById(R.id.ok_download_btn);
        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 判断是否已获得权限
                if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    // 权限申请曾被拒绝,给用户提示
                    if (ActivityCompat.shouldShowRequestPermissionRationale(
                            DownloadManagerActivity.this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE))  {
                        Toast.makeText(mContext, "请在设置中打开文件读写权限", Toast.LENGTH_SHORT).show();
                    } else {
                        ActivityCompat.requestPermissions(DownloadManagerActivity.this,
                                new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                EXTERNAL_STORAGE_REQ_CODE);
                    }
                } else {
                    DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
//                request.setVisibleInDownloadsUi(false);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    request.setTitle("DownloadManager");
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "download_manager.apk");
                    request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI
                            | DownloadManager.Request.NETWORK_MOBILE);
                    long downloadId = downloadManager.enqueue(request);

                    IntentFilter filter = new IntentFilter();
                    filter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
//                    filter.addAction("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");

                    SystemReceiver receiver = new SystemReceiver(downloadId);
                    registerReceiver(receiver, filter);
                }
            }
        });

        okDownloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 判断是否已获得权限
                if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    // 权限申请曾被拒绝,给用户提示
                    if (ActivityCompat.shouldShowRequestPermissionRationale(
                            DownloadManagerActivity.this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE))  {
                        Toast.makeText(mContext, "请在设置中打开文件读写权限", Toast.LENGTH_SHORT).show();
                    } else {
                        ActivityCompat.requestPermissions(DownloadManagerActivity.this,
                                new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                EXTERNAL_STORAGE_REQ_CODE);
                    }
                } else {
//                    OkDownloadManager downloadManager = OkDownloadManager.getDownloadManager(mContext);
//                    downloadManager.download(10, url);

                    Intent i = new Intent(mContext, OkDownloadManager.class);
                    i.putExtra("id", (int) System.currentTimeMillis());
                    i.putExtra("url", url);
                    startService(i);
//                    bindService(i, new ServiceConnection() {
//                        @Override
//                        public void onServiceConnected(ComponentName name, IBinder service) {
//                            Log.d("bindService", "onServiceConnected");
//
//                            OkDownloadManager downloadManager = ((OkDownloadManager.MyBunder)service).getService();
//                            downloadManager.download((int) System.currentTimeMillis(), url);
//                            Log.d("DownloadManagerActivity", downloadManager.toString());
//                        }
//
//                        @Override
//                        public void onServiceDisconnected(ComponentName name) {
//                            Log.d("bindService", "onServiceDisconnected");
//                        }
//                    },
//                    Context.BIND_AUTO_CREATE);
                }

            }
        });

    }

}

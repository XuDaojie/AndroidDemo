package io.github.xudaojie.androiddemo.download;

import android.app.DownloadManager;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import io.github.xudaojie.androiddemo.BaseActivity;
import io.github.xudaojie.androiddemo.R;

/**
 * Created by xdj on 16/7/13.
 */
public class DownloadManagerActivity extends BaseActivity {

    // QQ
//    private String url = "https://qd.myapp.com/myapp/qqteam/AndroidQQ/mobileqq_android.apk";
    //
    private String url = "http://pkg3.fir.im/71da3de01a28cff3f9884ada102e22fdbadaab35.apk?attname=app-release.apk_1.0.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_manager_activity);
        Button downloadBtn = (Button) findViewById(R.id.download_btn);
        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
//                filter.addAction("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");

                SystemReceiver receiver = new SystemReceiver(downloadId);
                registerReceiver(receiver, filter);
            }
        });
    }
}

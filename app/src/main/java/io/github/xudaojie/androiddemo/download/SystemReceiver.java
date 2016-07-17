package io.github.xudaojie.androiddemo.download;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;

import java.io.File;

/**
 * Created by xdj on 16/7/14.
 */
public class SystemReceiver extends BroadcastReceiver {

    private long cDownloadId;

    public SystemReceiver(long cDownloadId) {
        this.cDownloadId = cDownloadId;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        long downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0);
        if (cDownloadId == downloadId) {
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(downloadId);

            Cursor cursor = downloadManager.query(query);
            if (cursor.moveToFirst()) {
                int status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
                switch (status) {
                    case DownloadManager.STATUS_SUCCESSFUL:
                        //如果文件名不为空，说明已经存在了，然后获取uri，进行安装
                        File path = new File(cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME)));
                        if(!path.exists()){
                            return;
                        }
                        Uri uri = Uri.fromFile(path);
                        Intent install = new Intent(Intent.ACTION_VIEW);
                        install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        install.setDataAndType(uri,"application/vnd.android.package-archive");
                        // 执行意图进行安装
                        context.startActivity(install);
                        break;
                    default:
                        downloadManager.remove(downloadId);
                        break;
                }
            }
        }
        context.unregisterReceiver(this);
    }
}

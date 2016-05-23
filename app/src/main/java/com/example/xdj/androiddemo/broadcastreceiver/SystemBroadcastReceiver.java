package com.example.xdj.androiddemo.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by xdj on 15/7/24.
 */
public class SystemBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "SystemBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        //Log.d(TAG, context.toString());
        Toast.makeText(context, "网络变化", Toast.LENGTH_SHORT).show();
    }
}

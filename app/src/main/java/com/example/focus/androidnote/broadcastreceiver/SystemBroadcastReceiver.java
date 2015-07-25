package com.example.focus.androidnote.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by focus on 15/7/24.
 */
public class SystemBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "SystemBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        //Log.d(TAG, context.toString());
        Toast.makeText(context, "网络变化", Toast.LENGTH_SHORT).show();
    }
}

package com.wits.ksw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class LauncherReceiver extends BroadcastReceiver {
    public static final String BOOT_COMPLETED = "android.intent.action.BOOT_COMPLETED";
    private static final String TAG = "LauncherReceiver";

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Log.i(TAG, "onReceive: " + intent.getAction());
        }
    }
}

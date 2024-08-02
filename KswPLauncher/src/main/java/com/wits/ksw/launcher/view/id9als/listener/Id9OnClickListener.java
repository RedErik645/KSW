package com.wits.ksw.launcher.view.id9als.listener;

import android.app.Activity;
import android.view.View;

public class Id9OnClickListener implements View.OnClickListener {
    private final Activity mActivity;

    public Id9OnClickListener(Activity activity) {
        this.mActivity = activity;
    }

    public void onClick(View v) {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.finish();
        }
    }
}

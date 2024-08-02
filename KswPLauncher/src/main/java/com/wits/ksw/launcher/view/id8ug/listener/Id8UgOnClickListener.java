package com.wits.ksw.launcher.view.id8ug.listener;

import android.app.Activity;
import android.view.View;

public class Id8UgOnClickListener implements View.OnClickListener {
    private final Activity mActivity;

    public Id8UgOnClickListener(Activity activity) {
        this.mActivity = activity;
    }

    public void onClick(View v) {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.finish();
        }
    }
}

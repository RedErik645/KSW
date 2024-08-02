package com.wits.ksw.launcher.view.id9als.listener;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class FocusTouchListener implements View.OnTouchListener {
    private static final String TAG = "FocusTouchListener";

    public boolean onTouch(View v, MotionEvent event) {
        Log.w(TAG, "onTouch: isFocused : " + v.isFocused() + " , event.getAction() : " + event.getAction());
        if (v.isFocused() || event.getAction() != 1) {
            return false;
        }
        v.performClick();
        return false;
    }
}

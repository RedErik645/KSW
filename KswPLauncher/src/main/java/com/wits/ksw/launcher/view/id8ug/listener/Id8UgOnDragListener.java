package com.wits.ksw.launcher.view.id8ug.listener;

import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import com.wits.ksw.launcher.view.id8ug.Id8UgEditActivity;

public class Id8UgOnDragListener implements View.OnDragListener {
    private static final String TAG = "CardId8GsOnDragListener";
    private final Id8UgEditActivity editActivity;
    private String mFragmentTag;

    public Id8UgOnDragListener(String fragmentTag, Id8UgEditActivity id8GsEditActivity) {
        this.editActivity = id8GsEditActivity;
        this.mFragmentTag = fragmentTag;
    }

    public boolean onDrag(View v, DragEvent event) {
        Log.w(TAG, "onDrag:  event getAction : " + event.getAction());
        float tempX = event.getX();
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        int currentFragmentX = location[0];
        Log.w(TAG, "Fragment X :" + currentFragmentX);
        switch (event.getAction()) {
            case 2:
                float fingerX = ((float) currentFragmentX) + tempX;
                Log.w(TAG, "onDrag:  fragmentTag : " + this.mFragmentTag + " , currentScreenX : " + currentFragmentX + ", tempX : " + tempX + ", x :" + fingerX);
                this.editActivity.checkAutoScroll(fingerX);
                return true;
            case 3:
                String dragName = event.getClipData().getItemAt(0).getIntent().getStringExtra("name");
                Log.w(TAG, "drag ACTION_DROP name : " + dragName + " mFragmentTag : " + this.mFragmentTag);
                this.editActivity.sort(dragName, this.mFragmentTag);
                return true;
            default:
                return true;
        }
    }
}

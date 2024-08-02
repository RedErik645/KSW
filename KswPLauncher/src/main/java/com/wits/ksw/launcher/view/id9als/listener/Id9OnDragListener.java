package com.wits.ksw.launcher.view.id9als.listener;

import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import com.wits.ksw.KswApplication;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.launcher.view.id9als.Id9AlsViewManager;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class Id9OnDragListener implements View.OnDragListener {
    private static final String TAG = "Id9OnDragListener";
    private final String mFragmentTag;

    public Id9OnDragListener(String fragmentTag) {
        this.mFragmentTag = fragmentTag;
    }

    public boolean onDrag(View v, DragEvent event) {
        event.getY();
        switch (event.getAction()) {
            case 2:
                Log.w(TAG, "ACTION_DRAG_LOCATION   getBottom: " + event.getY() + " mFragmentTag : " + this.mFragmentTag);
                if (this.mFragmentTag.startsWith(Id9AlsConstants.ID9ALS_FREE_WINDOW_EMPTY)) {
                    return true;
                }
                Id9AlsViewManager.getInstance().checkAutoScroll(event.getY(), this.mFragmentTag);
                return true;
            case 3:
                String dragName = event.getClipData().getItemAt(0).getIntent().getStringExtra("name");
                Log.w(TAG, "drag ACTION_DROP name : " + dragName + " mFragmentTag : " + this.mFragmentTag);
                if (this.mFragmentTag.startsWith(Id9AlsConstants.ID9ALS_FREE_WINDOW_EMPTY)) {
                    if (setFreeWindowName(dragName)) {
                        return true;
                    }
                } else if (dragName.startsWith(Id9AlsConstants.ID9ALS_FREE_WINDOW_EMPTY)) {
                    return true;
                }
                Id9AlsViewManager.getInstance().sort(dragName, this.mFragmentTag);
                return true;
            case 4:
            default:
                return true;
            case 5:
                Log.w(TAG, "ACTION_DRAG_ENTERED ");
                return true;
            case 6:
                Log.w(TAG, "ACTION_DRAG_EXITED ");
                return true;
        }
    }

    private boolean setFreeWindowName(String name) {
        String freeWindowName = null;
        try {
            if (Id9AlsConstants.ID9ALS_VIEW_NAVI.equals(name)) {
                freeWindowName = "freeWindow:navi," + Settings.System.getString(KswApplication.appContext.getContentResolver(), KeyConfig.NAVI_DEFUAL);
            }
            if (!TextUtils.isEmpty(freeWindowName)) {
                PowerManagerApp.setSettingsString(Id9AlsConstants.ID9ALS_FREE_WINDOW_NAME, freeWindowName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return !TextUtils.isEmpty(freeWindowName);
    }
}

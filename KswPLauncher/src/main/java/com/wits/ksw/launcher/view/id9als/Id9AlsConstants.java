package com.wits.ksw.launcher.view.id9als;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.databinding.ObservableBoolean;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.IconUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;
import skin.support.SkinCompatManager;

public class Id9AlsConstants {
    public static final String CAMERA_360 = "com.ivicar.avm";
    public static int DEVICES_MODEL_ALL = 0;
    public static int DEVICES_MODEL_LOC = 1;
    public static int DEVICES_MODEL_SD = 4;
    public static int DEVICES_MODEL_USB1 = 2;
    public static int DEVICES_MODEL_USB2 = 3;
    public static final String ID9ALS_FREE_WINDOW_EMPTY = "freeWindow:";
    public static final String ID9ALS_FREE_WINDOW_NAME = "ID9ALS_FREE_WINDOW_NAME";
    public static final String ID9ALS_LAYOUT_MODEL = "ID9ALS_LAYOUT_MODEL";
    public static final String ID9ALS_LAYOUT_MODEL_LTR = "ID9ALS_LAYOUT_MODEL_LTR";
    public static final String ID9ALS_LAYOUT_MODEL_RTL = "ID9ALS_LAYOUT_MODEL_RTL";
    public static final String ID9ALS_SELECT_MODEL_COMFORT = "3";
    public static final String ID9ALS_SELECT_MODEL_ELEGANT = "4";
    public static final String ID9ALS_SELECT_MODEL_MYSTERIOUS = "6";
    public static final String ID9ALS_SELECT_MODEL_NOBLE = "1";
    public static final String ID9ALS_SELECT_MODEL_PASSION = "2";
    public static final String ID9ALS_SELECT_MODEL_STEADY = "7";
    public static final String ID9ALS_SELECT_MODEL_VITALITY = "5";
    public static final String ID9ALS_SELECT_WALLPAPER_CUSTOM = "4";
    public static final String ID9ALS_SELECT_WALLPAPER_NORMAL = "1";
    public static final String ID9ALS_SELECT_WALLPAPER_SECOND = "2";
    public static final String ID9ALS_SELECT_WALLPAPER_THIRD = "3";
    public static final String ID9ALS_SKIN_MODEL = "ID9ALS_SKIN_MODEL";
    public static final String ID9ALS_SKIN_WALLPAPER = "ID9ALS_SKIN_WALLPAPER";
    public static final String ID9ALS_SKIN_WALLPAPER_PATH = "ID9ALS_SKIN_WALLPAPER_PATH";
    public static final String ID9ALS_VIEW_ADD_APP = "ID9ALS_VIEW_ADD_APP";
    public static final String ID9ALS_VIEW_BOARD = "ID9ALS_VIEW_BOARD";
    public static final String ID9ALS_VIEW_BT = "ID9ALS_VIEW_BT";
    public static final String ID9ALS_VIEW_CAR = "ID9ALS_VIEW_CAR";
    public static final String ID9ALS_VIEW_CARD_SORT_LIST = "ID9ALS_VIEW_CARD_SORT_LIST";
    public static final String ID9ALS_VIEW_MODEL = "ID9ALS_VIEW_MODEL";
    public static final String ID9ALS_VIEW_MUSIC = "IID9ALS_VIEW_MUSIC";
    public static final String ID9ALS_VIEW_NAVI = "ID9ALS_VIEW_NAVI";
    public static final String ID9ALS_VIEW_SETTING = "ID9ALS_VIEW_SETTING";
    public static final String ID9ALS_VIEW_VIDEO = "ID9ALS_VIEW_VIDEO";
    public static final String ID9ALS_VIEW_WEATHER = "ID9ALS_VIEW_WEATHER";
    public static final String ID9_FOCUS_VIEW_TAG = "ID9_FOCUS_VIEW_TAG";
    public static final String ID9_FOCUS_VIEW_TAG_CARD = "TagCard";
    public static final String ID9_FOCUS_VIEW_TAG_FREEDOM = "TagFreedom";
    public static final String ID9_FOCUS_VIEW_TAG_MAIN_SETTING = "TagMainSetting";
    public static final int ID9_MAX_ADD_THIRD_NUM = 5;
    public static final int PIC_FILE_MAX_HEIGHT = 3000;
    public static final int PIC_FILE_MAX_WIDTH = 3000;
    public static final String TAG = "Id9AlsConstants";
    public static final String THEME_TYPE = "THEME_TYPE";
    public static final String WALLPAPER_LOC_PATH = "/storage/emulated/0";
    public static final String WALLPAPER_SPECIFY_PATH = "/wallpaper";
    public static String id9Theme = KswApplication.appContext.getString(R.string.benz_ntg6_fy_theme_settings);
    public static Drawable id9ThemeIcon = KswApplication.appContext.getDrawable(R.drawable.id9_model_theme);
    public static ObservableBoolean isLayoutModelRtl = new ObservableBoolean(false);
    static SkinCompatManager.SkinLoaderListener listener = new SkinCompatManager.SkinLoaderListener() {
        /* class com.wits.ksw.launcher.view.id9als.Id9AlsConstants.AnonymousClass1 */

        @Override // skin.support.SkinCompatManager.SkinLoaderListener
        public void onStart() {
            Log.w(Id9AlsConstants.TAG, "onStart: ");
        }

        @Override // skin.support.SkinCompatManager.SkinLoaderListener
        public void onSuccess() {
            Log.w(Id9AlsConstants.TAG, "onSuccess: ");
        }

        @Override // skin.support.SkinCompatManager.SkinLoaderListener
        public void onFailed(String errMsg) {
            Log.w(Id9AlsConstants.TAG, "onFailed: " + errMsg);
        }
    };

    public static void setLayoutModel() {
        try {
            isLayoutModelRtl.set(ID9ALS_LAYOUT_MODEL_RTL.equals(PowerManagerApp.getSettingsString(ID9ALS_LAYOUT_MODEL)));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static Activity scanForActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return scanForActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static String loadCurrentSkin() {
        String skinName = Settings.System.getString(KswApplication.appContext.getContentResolver(), ID9ALS_SKIN_MODEL);
        if (!TextUtils.isEmpty(skinName)) {
            return skinName;
        }
        Settings.System.putString(KswApplication.appContext.getContentResolver(), ID9ALS_SKIN_MODEL, "1");
        return "1";
    }

    public static String getFreedomViewPag() {
        return Settings.System.getString(KswApplication.appContext.getContentResolver(), KeyConfig.NAVI_DEFUAL);
    }

    public static void refreshId9Skin() {
        try {
            String skinName = Settings.System.getString(KswApplication.appContext.getContentResolver(), ID9ALS_SKIN_MODEL);
            Log.i(TAG, "refreshId9Skin: skinName = " + skinName);
            if ("2".equals(skinName)) {
                SkinCompatManager.getInstance().loadSkin("pass", listener, 1);
            } else if ("3".equals(skinName)) {
                SkinCompatManager.getInstance().loadSkin("comfort", listener, 1);
            } else if ("4".equals(skinName)) {
                SkinCompatManager.getInstance().loadSkin("ele", listener, 1);
            } else if (ID9ALS_SELECT_MODEL_VITALITY.equals(skinName)) {
                SkinCompatManager.getInstance().loadSkin("vita", listener, 1);
            } else if (ID9ALS_SELECT_MODEL_MYSTERIOUS.equals(skinName)) {
                SkinCompatManager.getInstance().loadSkin("myst", listener, 1);
            } else if (ID9ALS_SELECT_MODEL_STEADY.equals(skinName)) {
                SkinCompatManager.getInstance().loadSkin("steady", listener, 1);
            } else {
                SkinCompatManager.getInstance().restoreDefaultTheme();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Drawable getIcon(String packName, Drawable drawable) {
        Log.i(TAG, "getIcon: packName = " + packName);
        if (IconUtils.EQ.equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.id9_eq);
        }
        if (IconUtils.ZLINK.equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.id9_zlink);
        }
        if (IconUtils.ESFILE.equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.id9_filemanager);
        }
        if (CAMERA_360.equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.id9_360);
        }
        if (IconUtils.SHELL.equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.id9_user_feedback);
        }
        if ("com.txznet.weather".equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.id9_weather);
        }
        return IconUtils.getInstance().compositeDrawable(drawable, R.drawable.id9_app1_bg);
    }
}

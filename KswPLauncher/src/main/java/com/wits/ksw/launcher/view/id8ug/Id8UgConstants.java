package com.wits.ksw.launcher.view.id8ug;

import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.IconUtils;
import skin.support.SkinCompatManager;

public class Id8UgConstants {
    public static final String ID8UG_CAR_COLOR_STATUS = "ID8UG_CAR_COLOR_STATUS";
    public static final String ID8UG_CAR_MODEL_TYPE = "ID8UG_CAR_MODEL_TYPE";
    public static final String ID8UG_CAR_VOLUME_MUTE = "ID8UG_CAR_VOLUME_MUTE";
    public static final String ID8UG_FRAGMENT_CARD_SORT_LIST = "ID8UG_FRAGMENT_CARD_SORT_LIST";
    public static final String ID8UG_FRAGMENT_CAR_AUTO_PLAY = "ID8UG_FRAGMENT_CAR_AUTO_PLAY";
    public static final String ID8UG_FRAGMENT_CAR_DASHBOARD = "ID8UG_FRAGMENT_CAR_DASHBOARD";
    public static final String ID8UG_FRAGMENT_CAR_DEVICES = "ID8UG_FRAGMENT_CAR_DEVICES";
    public static final String ID8UG_FRAGMENT_CAR_FAVOUR = "ID8UG_FRAGMENT_CAR_FAVOUR";
    public static final String ID8UG_FRAGMENT_CAR_MODEL = "ID8UG_FRAGMENT_CAR_MODEL";
    public static final String ID8UG_FRAGMENT_CAR_MUSIC = "ID8UG_FRAGMENT_CAR_MUSIC";
    public static final String ID8UG_FRAGMENT_CAR_NAVI = "ID8UG_FRAGMENT_CAR_NAVI";
    public static final String ID8UG_FRAGMENT_CAR_SPEED = "ID8UG_FRAGMENT_CAR_SPEED";
    public static final String ID8UG_FRAGMENT_CAR_SPEED_MODEL = "ID8UG_FRAGMENT_CAR_SPEED_MODEL";
    public static final String ID8UG_MUSIC_SELECT_MODEL = "ID8UG_MUSIC_SELECT_MODEL";
    public static final int ID8UG_MUSIC_SELECT_MODEL_BT = 1;
    public static final int ID8UG_MUSIC_SELECT_MODEL_MUSIC = 0;
    public static final String ID8UG_SELECT_MODEL_DAYTIME = "daytime";
    public static final String ID8UG_SELECT_MODEL_NIGHT = "night";
    public static final String ID8UG_SHORT_APP_FIRST_INSTALL = "ID8UG_SHORT_APP_FIRST_INSTALL";
    public static final String ID8UG_SKIN_MODEL = "ID8UG_SKIN_MODEL";
    public static final String ID8_UG_CARD_TAG_AUTO_PLAY = "Id8UgCardAutoPlay";
    public static final String ID8_UG_CARD_TAG_DASHBOARD = "Id8UgCardDashboard";
    public static final String ID8_UG_CARD_TAG_DEVICE = "Id8UgCardDevice";
    public static final String ID8_UG_CARD_TAG_MUSIC = "Id8UgCardMusic";
    public static final String ID8_UG_CARD_TAG_NAVI = "Id8UgCardNavi";
    public static final String OWN_BT_APP_NAME = "com.wits.ksw.bt";
    public static final String OWN_MUSIC_APP_NAME = "com.wits.ksw.music";
    public static final String OWN_VIDEO_APP_NAME = "com.wits.ksw.video";
    public static final String SHORTCUT_APP_NAME_ID8_UG = "shortcutAppNameId8Ug";
    public static final long SHOW_GONE_VIEW_ANIM_TIME = 400;
    public static final int STEP_SPEED_FIRST = 110;
    public static final int STEP_SPEED_SECOND = 70;
    public static final int STEP_SPEED_THIRD = 30;
    public static final String TAG = Id8UgConstants.class.getName();

    public static String loadCurrentSkin() {
        String skinName = Settings.System.getString(KswApplication.appContext.getContentResolver(), ID8UG_SKIN_MODEL);
        if (!TextUtils.isEmpty(skinName)) {
            return skinName;
        }
        Settings.System.putString(KswApplication.appContext.getContentResolver(), ID8UG_SKIN_MODEL, ID8UG_SELECT_MODEL_DAYTIME);
        return ID8UG_SELECT_MODEL_DAYTIME;
    }

    public static Drawable getIcon(String packName, Drawable drawable) {
        Log.i(TAG, "getIcon: packName = " + packName);
        if (OWN_BT_APP_NAME.equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.evoid8_app_bt);
        }
        if (IconUtils.ZLINK.equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.evoid8_app_carplay);
        }
        if (IconUtils.ESFILE.equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.evoid8_app_filemanager);
        }
        if (OWN_MUSIC_APP_NAME.equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.evoid8_app_music);
        }
        if (OWN_VIDEO_APP_NAME.equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.evoid8_app_video);
        }
        if (IconUtils.SETTING.equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.evoid8_app_setting);
        }
        if (IconUtils.APK_INSTALL.equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.evoid8_app_apk);
        }
        if (IconUtils.CHROME.equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.evoid8_app_chrome);
        }
        if (IconUtils.GOOGLE.equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.evoid8_app_google);
        }
        if (IconUtils.GOOGLE_MAP.equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.evoid8_app_maps);
        }
        if (IconUtils.DAB.equals(packName)) {
            return KswApplication.appContext.getDrawable(R.drawable.evoid8_app_dab);
        }
        return drawable;
    }

    public static String getOwnApkName(String packageName) {
        Log.i(TAG, "getOwnApkName packageName: " + packageName);
        if (OWN_BT_APP_NAME.equals(packageName)) {
            return KswApplication.appContext.getString(R.string.ug_bluetooth);
        }
        if (OWN_MUSIC_APP_NAME.equals(packageName)) {
            return KswApplication.appContext.getString(R.string.ksw_id7_music);
        }
        if (OWN_VIDEO_APP_NAME.equals(packageName)) {
            return KswApplication.appContext.getString(R.string.ksw_id7_hd_video);
        }
        return "";
    }

    public static void refreshId8Skin() {
        try {
            String skinName = Settings.System.getString(KswApplication.appContext.getContentResolver(), ID8UG_SKIN_MODEL);
            Log.i(TAG, "refreshId9Skin: skinName = " + skinName);
            if (ID8UG_SELECT_MODEL_NIGHT.equals(skinName)) {
                SkinCompatManager.getInstance().loadSkin(ID8UG_SELECT_MODEL_NIGHT, KswApplication.listener, 1);
            } else {
                SkinCompatManager.getInstance().restoreDefaultTheme();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

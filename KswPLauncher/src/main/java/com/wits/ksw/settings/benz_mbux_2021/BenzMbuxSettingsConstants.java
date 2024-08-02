package com.wits.ksw.settings.benz_mbux_2021;

import android.content.Context;
import android.provider.Settings;
import com.wits.ksw.launcher.utils.Constants;

public class BenzMbuxSettingsConstants {
    public static final int BENZ_MBUX_SKIN_BLUE = 0;
    public static final int BENZ_MBUX_SKIN_BLUE_LIGHT = 5;
    public static final int BENZ_MBUX_SKIN_GREY = 1;
    public static final int BENZ_MBUX_SKIN_ORANGE = 2;
    public static final int BENZ_MBUX_SKIN_PURPLE = 7;
    public static final int BENZ_MBUX_SKIN_PURPLE_LIGHT = 6;
    public static final int BENZ_MBUX_SKIN_RED = 3;
    public static final int BENZ_MBUX_SKIN_YELLOW = 4;
    public static final String NTG6_SKIN_BLUE = "blue";
    public static final String NTG6_SKIN_PURPLE = "purple";
    public static final String NTG6_SKIN_YELLOW = "yellow";
    private static final String TAG = "BenzMbuxEQConstants";
    private static Context context;

    public static void init(Context appContext) {
        context = appContext;
    }

    public static String loadCurrentSkin() {
        int skinNum = Settings.System.getInt(context.getContentResolver(), Constants.NTG6V3_SELECT_THEME_VIEW_MODEL, 0);
        if (skinNum == 0 || skinNum == 1 || skinNum == 5) {
            return "blue";
        }
        if (skinNum == 3 || skinNum == 6 || skinNum == 7) {
            return NTG6_SKIN_PURPLE;
        }
        if (skinNum == 2 || skinNum == 4) {
            return "yellow";
        }
        return "blue";
    }
}

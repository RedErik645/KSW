package com.wits.ksw.launcher.view.benzntg6fy;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityNtg6v3ChangeThemeMainBinding;
import com.wits.ksw.launcher.utils.Constants;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.io.File;

public class Ntg6v3ThemeChangeViewModel extends ViewModel {
    private static String TAG = "Ntg6v3ThemeChangeViewModel";
    public static ObservableBoolean isThemeModeSelect = new ObservableBoolean(true);
    public static ObservableInt ntg6v3ChangeThemeMode = new ObservableInt(0);
    public static ObservableInt ntg6v3ChangeWallpaperMode = new ObservableInt(0);
    private Context context;
    public ContentObserver themeContentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3ThemeChangeViewModel.AnonymousClass1 */

        public void onChange(boolean selfChange, Uri uri) {
            Log.i(Ntg6v3ThemeChangeViewModel.TAG, "themeContentObserver onChange");
            Ntg6v3ThemeChangeViewModel.this.initNtg6v3ThemeViewModel();
        }
    };
    private ActivityNtg6v3ChangeThemeMainBinding themeMainBinding;
    public ContentObserver wallpaperContentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3ThemeChangeViewModel.AnonymousClass2 */

        public void onChange(boolean selfChange, Uri uri) {
            Log.i(Ntg6v3ThemeChangeViewModel.TAG, "wallpaperContentObserver onChange");
            Ntg6v3ThemeChangeViewModel.this.initNtg6v3MaiWallpaperModel();
        }
    };

    public void initData(ActivityNtg6v3ChangeThemeMainBinding themeMainBinding2, Context context2) {
        this.themeMainBinding = themeMainBinding2;
        this.context = context2;
        registerObserver();
    }

    public void registerObserver() {
        this.context.getContentResolver().registerContentObserver(Settings.System.getUriFor(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL), true, this.themeContentObserver);
        this.context.getContentResolver().registerContentObserver(Settings.System.getUriFor(Constants.NTG6V3_SELECT_MAIN_WALLPAPER_MODEL), true, this.wallpaperContentObserver);
        this.context.getContentResolver().registerContentObserver(Settings.System.getUriFor(Constants.NTG6V3_MAIN_WALLPAPER_PATH), true, this.wallpaperContentObserver);
        initNtg6v3ThemeViewModel();
        initNtg6v3MaiWallpaperModel();
    }

    public void initNtg6v3ThemeViewModel() {
        try {
            int model = PowerManagerApp.getSettingsInt(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL);
            Log.i(TAG, "initNtg6v3ThemeViewModel model: " + model);
            ntg6v3ChangeThemeMode.set(model);
            setNtg6v3BgForWallpaper();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void initNtg6v3MaiWallpaperModel() {
        try {
            int model = PowerManagerApp.getSettingsInt(Constants.NTG6V3_SELECT_MAIN_WALLPAPER_MODEL);
            Log.i(TAG, "initNtg6v3MaiWallpaperModel model: " + model);
            ntg6v3ChangeWallpaperMode.set(model);
            setNtg6v3BgForWallpaper();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onNtg6v3ThemeSelectClick(View view, boolean isSelect) {
        isThemeModeSelect.set(isSelect);
        if (view != null) {
            view.requestFocus();
        }
    }

    public void setNtg6v3BgForWallpaper() {
        View view = this.themeMainBinding.ntg6v3ChangeThemeMainBg;
        int wallpaperValue = ntg6v3ChangeWallpaperMode.get();
        int themeValue = ntg6v3ChangeThemeMode.get();
        try {
            if (wallpaperValue == Constants.NTG6V3_THEME_WALLPAPER_MODEL_MAP) {
                view.setBackgroundResource(R.drawable.ntg6v3_main_bg_map);
            } else if (wallpaperValue == Constants.NTG6V3_THEME_WALLPAPER_MODEL_CUSTOM) {
                String path = PowerManagerApp.getSettingsString(Constants.NTG6V3_MAIN_WALLPAPER_PATH);
                if (TextUtils.isEmpty(path) || !new File(path).exists()) {
                    setNtg6v3BgForTheme(view, themeValue);
                } else {
                    view.setBackground(Drawable.createFromPath(path));
                }
            } else {
                setNtg6v3BgForTheme(view, themeValue);
            }
        } catch (RemoteException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void setNtg6v3BgForTheme(View view, int value) {
        if (value == Constants.NTG6V3_THEME_COLOR_BLUE_LIGHT) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_bg_blue2);
        } else if (value == Constants.NTG6V3_THEME_COLOR_GAY) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_bg_gay);
        } else if (value == Constants.NTG6V3_THEME_COLOR_ORANGE) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_bg_orange);
        } else if (value == Constants.NTG6V3_THEME_COLOR_YELLOW) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_bg_yellow);
        } else if (value == Constants.NTG6V3_THEME_COLOR_RED) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_bg_red);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE_LIGHT) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_bg_purple);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_bg_purple2);
        } else {
            view.setBackgroundResource(R.drawable.ntg6v3_main_bg_blue);
        }
    }

    public static void setThemeTitleViewSelect(View view, boolean isSelect) {
        view.setSelected(isSelect);
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(ContextCompat.getColor(KswApplication.appContext, isSelect ? R.color.id8_main_style_color_yellow : R.color.white));
        }
    }

    public void onWallpaperNormalIvClick(View view) {
        try {
            PowerManagerApp.setSettingsInt(Constants.NTG6V3_SELECT_MAIN_WALLPAPER_MODEL, Constants.NTG6V3_THEME_WALLPAPER_MODEL_NORMAL);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onWallpaperMapIvClick(View view) {
        try {
            PowerManagerApp.setSettingsInt(Constants.NTG6V3_SELECT_MAIN_WALLPAPER_MODEL, Constants.NTG6V3_THEME_WALLPAPER_MODEL_MAP);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onWallpaperCustomIvClick(View view) {
        this.context.startActivity(new Intent(this.context, Ntg6v3SelectWallpaperActivity.class));
    }
}

package com.wits.ksw.launcher.model;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wits.ksw.KswApplication;
import com.wits.ksw.MainActivity;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityNtgFyV3LauncherMainBinding;
import com.wits.ksw.launcher.adpater.Ntg6FyV3RecycleViewAdapter;
import com.wits.ksw.launcher.adpater.Ntg6V3AppRecyclerViewAdapter;
import com.wits.ksw.launcher.adpater.Ntg6V3ViewPagerAdapter;
import com.wits.ksw.launcher.base.BaseV3ListAdpater;
import com.wits.ksw.launcher.bean.AppInfo;
import com.wits.ksw.launcher.bean.NtgFyV3Item;
import com.wits.ksw.launcher.utils.Constants;
import com.wits.ksw.launcher.utils.IconUtils;
import com.wits.ksw.launcher.utils.SpfUtils;
import com.wits.ksw.launcher.view.PageIndicatorView;
import com.wits.ksw.launcher.view.PageRecyclerView;
import com.wits.ksw.launcher.view.benzmbux2021new.util.BenzUtils;
import com.wits.ksw.launcher.view.benzntg6fy.BenzNtg6v3FyAppEditActivity;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ntg6v3LauncherViewModel extends BcVieModel {
    private static String TAG = "Ntg6v3LauncherViewModel";
    public static String[] bcItemArrys = KswApplication.appContext.getResources().getStringArray(R.array.allapps_item_text_array);
    public static String[] dialogItemArrys = KswApplication.appContext.getResources().getStringArray(R.array.ntg6_dialog_item_text_array);
    public static ArrayList<String> notSupportShowList;
    public static ObservableInt ntg6v3MaiWallpaperMode = new ObservableInt(0);
    public static int ntg6v3MainPopThemeMode;
    public static ObservableInt ntg6v3MainThemeMode = new ObservableInt(0);
    public static int[] resId = {R.drawable.ntg6_fy_v3_allapp_nav_bg, R.drawable.ntg6_fy_v3_allapp_theme_bg, R.drawable.ntg6_fy_v3_allapp_bt_bg, R.drawable.ntg6_fy_v3_allapp_video_bg, R.drawable.ntg6_fy_v3_allapp_setting_bg, R.drawable.ntg6_fy_v3_allapp_music_bg, R.drawable.ntg6_fy_v3_allapp_eq_bg, R.drawable.ntg6_fy_v3_allapp_phonelink_bg, R.drawable.ntg6_fy_v3_allapp_car_bg, R.drawable.ntg6_fy_v3_allapp_instrument_bg};
    private final String EDIT_APP_LIST = "edit_app_list";
    ActivityNtgFyV3LauncherMainBinding bmwFyNtgV3MainLayoutBinding;
    private String bottomOneItem = "bottomOneItem";
    private String bottomThreeItem = "bottomThreeItem";
    private String bottomTwoItem = "bottomTwoItem";
    private List<AppInfo> currentAppsInfo;
    private final String defaultAppList = "0,1,2,3,4,5,6,7,8,9";
    private AlertDialog dialog;
    private List<AppInfo> dialogApps;
    private PageRecyclerView fyV3recycleView;
    public int gridSpanCount = 5;
    private PageIndicatorView indicator;
    private ImageView[] ivWitstekIndicator;
    public ObservableField<BaseV3ListAdpater<AppInfo>> listAdpater = new ObservableField<>();
    private List<AppInfo> mListLiveData;
    private int mPagePosition = 0;
    public int mPageSize = 10;
    private ViewPager mViewpager;
    private Ntg6FyV3RecycleViewAdapter ntg6FyV3RecycleViewAdapter;
    private BaseQuickAdapter.OnItemClickListener onItemClickListener = new BaseQuickAdapter.OnItemClickListener() {
        /* class com.wits.ksw.launcher.model.$$Lambda$Ntg6v3LauncherViewModel$Yl46NXYnsuPm_978dP1BkElnXM */

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
        public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
            Ntg6v3LauncherViewModel.this.lambda$new$0$Ntg6v3LauncherViewModel(baseQuickAdapter, view, i);
        }
    };
    private AppInfo oneAppInfo;
    public ContentObserver themeContentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel.AnonymousClass1 */

        public void onChange(boolean selfChange, Uri uri) {
            Log.i(Ntg6v3LauncherViewModel.TAG, "themeContentObserver onChange");
            Ntg6v3LauncherViewModel.this.initNtg6v3ThemeViewModel();
        }
    };
    private AppInfo threeAppInfo;
    private int totalPage;
    private AppInfo twoAppInfo;
    private Handler uiHandler = new Handler(Looper.getMainLooper());
    private List<View> viewPagerList;
    public ContentObserver wallpaperContentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel.AnonymousClass2 */

        public void onChange(boolean selfChange, Uri uri) {
            Log.i(Ntg6v3LauncherViewModel.TAG, "wallpaperContentObserver onChange");
            Ntg6v3LauncherViewModel.this.initNtg6v3MaiWallpaperModel();
        }
    };

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        notSupportShowList = arrayList;
        arrayList.add("com.android.settings");
        notSupportShowList.add(BenzUtils.EQ_PKG);
    }

    public void initNtg6v3ObservableData(ActivityNtgFyV3LauncherMainBinding bmwFyNtgV3MainLayoutBinding2) {
        this.bmwFyNtgV3MainLayoutBinding = bmwFyNtgV3MainLayoutBinding2;
        bcItemArrys = KswApplication.appContext.getResources().getStringArray(R.array.allapps_item_text_array);
        initNtg6v3MaiWallpaperModel();
        initNtg6v3ThemeViewModel();
        registerSkinObserver();
    }

    private void registerSkinObserver() {
        this.context.getContentResolver().registerContentObserver(Settings.System.getUriFor(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL), true, this.themeContentObserver);
        this.context.getContentResolver().registerContentObserver(Settings.System.getUriFor(Constants.NTG6V3_SELECT_MAIN_WALLPAPER_MODEL), true, this.wallpaperContentObserver);
        this.context.getContentResolver().registerContentObserver(Settings.System.getUriFor(Constants.NTG6V3_MAIN_WALLPAPER_PATH), true, this.wallpaperContentObserver);
    }

    public void initNtg6v3ThemeViewModel() {
        try {
            int model = PowerManagerApp.getSettingsInt(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL);
            Log.i(TAG, "initNtg6v3ThemeViewModel model: " + model);
            ntg6v3MainThemeMode.set(model);
            setNtg6v3MainBgForWallpaper();
            setNtg6v3PopWindowBg();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void initNtg6v3MaiWallpaperModel() {
        try {
            int model = PowerManagerApp.getSettingsInt(Constants.NTG6V3_SELECT_MAIN_WALLPAPER_MODEL);
            Log.i(TAG, "initNtg6v3MaiWallpaperModel model: " + model);
            ntg6v3MaiWallpaperMode.set(model);
            setNtg6v3MainBgForWallpaper();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void setNtg6v3MainLeftBg(View view, int value) {
        if (value == Constants.NTG6V3_THEME_COLOR_BLUE_LIGHT) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_theme_left_blue2);
        } else if (value == Constants.NTG6V3_THEME_COLOR_GAY) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_theme_left_gay);
        } else if (value == Constants.NTG6V3_THEME_COLOR_ORANGE) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_theme_left_orange);
        } else if (value == Constants.NTG6V3_THEME_COLOR_YELLOW) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_theme_left_yellow);
        } else if (value == Constants.NTG6V3_THEME_COLOR_RED) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_theme_left_red);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_theme_left_purple);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE_LIGHT) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_theme_left_purple2);
        } else {
            view.setBackgroundResource(R.drawable.ntg6v3_main_theme_left_blue);
        }
    }

    public static void setNtg6v3MainBottomCarBg(View view, int value) {
        if (value == Constants.NTG6V3_THEME_COLOR_BLUE_LIGHT) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_car_blue2_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_GAY) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_car_gray_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_ORANGE) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_car_orange_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_YELLOW) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_car_yellow_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_RED) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_car_red_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_car_purple_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE_LIGHT) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_car_purple2_bg);
        } else {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_car_bg);
        }
    }

    public static void setNtg6v3MainBottomNavBg(View view, int value) {
        if (value == Constants.NTG6V3_THEME_COLOR_BLUE_LIGHT) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_nav_blue2_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_GAY) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_nav_gray_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_ORANGE) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_nav_orange_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_YELLOW) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_nav_yellow_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_RED) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_nav_red_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_nav_purple_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE_LIGHT) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_nav_purple2_bg);
        } else {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_nav_bg);
        }
    }

    public static void setNtg6v3MainBottomBtBg(View view, int value, boolean status) {
        if (value == Constants.NTG6V3_THEME_COLOR_BLUE_LIGHT) {
            view.setBackgroundResource(status ? R.drawable.ntg6_fy_v3_home_bt_blue2_bg_connected : R.drawable.ntg6_fy_v3_home_bt_blue2_bg_unconnected);
        } else if (value == Constants.NTG6V3_THEME_COLOR_GAY) {
            view.setBackgroundResource(status ? R.drawable.ntg6_fy_v3_home_bt_gray_bg_connected : R.drawable.ntg6_fy_v3_home_bt_gray_bg_unconnected);
        } else if (value == Constants.NTG6V3_THEME_COLOR_ORANGE) {
            view.setBackgroundResource(status ? R.drawable.ntg6_fy_v3_home_bt_orange_bg_connected : R.drawable.ntg6_fy_v3_home_bt_orange_bg_unconnected);
        } else if (value == Constants.NTG6V3_THEME_COLOR_YELLOW) {
            view.setBackgroundResource(status ? R.drawable.ntg6_fy_v3_home_bt_yellow_bg_connected : R.drawable.ntg6_fy_v3_home_bt_yellow_bg_unconnected);
        } else if (value == Constants.NTG6V3_THEME_COLOR_RED) {
            view.setBackgroundResource(status ? R.drawable.ntg6_fy_v3_home_bt_red_bg_connected : R.drawable.ntg6_fy_v3_home_bt_red_bg_unconnected);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE) {
            view.setBackgroundResource(status ? R.drawable.ntg6_fy_v3_home_bt_purple_bg_connected : R.drawable.ntg6_fy_v3_home_bt_purple_bg_unconnected);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE_LIGHT) {
            view.setBackgroundResource(status ? R.drawable.ntg6_fy_v3_home_bt_purple2_bg_connected : R.drawable.ntg6_fy_v3_home_bt_purple2_bg_unconnected);
        } else {
            view.setBackgroundResource(status ? R.drawable.ntg6_fy_v3_home_bt_bg_connected : R.drawable.ntg6_fy_v3_home_bt_bg_unconnected);
        }
    }

    public static void setNtg6v3MainBottomWeatherBg(View view, int value) {
        if (value == Constants.NTG6V3_THEME_COLOR_BLUE_LIGHT) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_weather_blue2_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_GAY) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_weather_gray_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_ORANGE) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_weather_orange_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_YELLOW) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_weather_yellow_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_RED) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_weather_red_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_weather_purple_bg);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE_LIGHT) {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_weather_purple_bg);
        } else {
            view.setBackgroundResource(R.drawable.ntg6_fy_v3_home_weather_bg);
        }
    }

    public static void setNtg6v3MainLeftItemBg(View view, int value) {
        if (value == Constants.NTG6V3_THEME_COLOR_BLUE_LIGHT) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_left_view_selector_blue2);
        } else if (value == Constants.NTG6V3_THEME_COLOR_GAY) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_left_view_selector_gay);
        } else if (value == Constants.NTG6V3_THEME_COLOR_ORANGE) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_left_view_selector_orange);
        } else if (value == Constants.NTG6V3_THEME_COLOR_YELLOW) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_left_view_selector_yellow);
        } else if (value == Constants.NTG6V3_THEME_COLOR_RED) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_left_view_selector_red);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_left_view_selector_purple);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE_LIGHT) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_left_view_selector_purple2);
        } else {
            view.setBackgroundResource(R.drawable.ntg6v3_main_left_view_selector_blue);
        }
    }

    public static void setNtg6v3AllAppItemBg(View view, int value) {
        if (value == Constants.NTG6V3_THEME_COLOR_BLUE_LIGHT) {
            view.setBackgroundResource(R.drawable.ntg6v3_all_app_icon_bg_blue2);
        } else if (value == Constants.NTG6V3_THEME_COLOR_GAY) {
            view.setBackgroundResource(R.drawable.ntg6v3_all_app_icon_bg_gay);
        } else if (value == Constants.NTG6V3_THEME_COLOR_ORANGE) {
            view.setBackgroundResource(R.drawable.ntg6v3_all_app_icon_bg_orange);
        } else if (value == Constants.NTG6V3_THEME_COLOR_YELLOW) {
            view.setBackgroundResource(R.drawable.ntg6v3_all_app_icon_bg_yellow);
        } else if (value == Constants.NTG6V3_THEME_COLOR_RED) {
            view.setBackgroundResource(R.drawable.ntg6v3_all_app_icon_bg_red);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE_LIGHT) {
            view.setBackgroundResource(R.drawable.ntg6v3_all_app_icon_bg_purple);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE) {
            view.setBackgroundResource(R.drawable.ntg6v3_all_app_icon_bg_purple2);
        } else {
            view.setBackgroundResource(R.drawable.ntg6v3_all_app_icon_bg_blue);
        }
    }

    public void setNtg6v3PopWindowBg() {
        try {
            setNtg6v3AllAppItemBg(this.bmwFyNtgV3MainLayoutBinding.llPopwindowContainer.ntgFyV3PopwindowBg, ntg6v3MainThemeMode.get());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void setNtg6v3MainBgForWallpaper() {
        View view = this.bmwFyNtgV3MainLayoutBinding.ntg6v3LauncherMainBg;
        int wallpaperValue = ntg6v3MaiWallpaperMode.get();
        int themeValue = ntg6v3MainThemeMode.get();
        try {
            if (wallpaperValue == Constants.NTG6V3_THEME_WALLPAPER_MODEL_MAP) {
                view.setBackgroundResource(R.drawable.ntg6v3_main_bg_map);
            } else if (wallpaperValue == Constants.NTG6V3_THEME_WALLPAPER_MODEL_CUSTOM) {
                String path = PowerManagerApp.getSettingsString(Constants.NTG6V3_MAIN_WALLPAPER_PATH);
                if (TextUtils.isEmpty(path) || !new File(path).exists()) {
                    setNtg6v3MainBgForTheme(view, themeValue);
                } else {
                    view.setBackground(Drawable.createFromPath(path));
                }
            } else {
                setNtg6v3MainBgForTheme(view, themeValue);
            }
        } catch (RemoteException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void setNtg6v3MainBgForTheme(View view, int value) {
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

    @Override // com.wits.ksw.launcher.base.BaseViewModel, com.wits.ksw.launcher.model.AppsLoaderTask.AppsLoaderTaskListener
    public void allAppsLoaded(List<AppInfo> appInfos) {
        super.allAppsLoaded(appInfos);
        refreAppsize();
        initBottomItem(appInfos);
        initDialogAdapter(appInfos);
    }

    private void initBottomItem(List<AppInfo> appInfos) {
        String oneItemCls = SpfUtils.getString(this.bottomOneItem, "noItem");
        if (!oneItemCls.equals("noItem")) {
            this.oneAppInfo = setIndexItemBean(appInfos, oneItemCls);
        }
        String twoItemCls = SpfUtils.getString(this.bottomTwoItem, "noItem");
        if (!twoItemCls.equals("noItem")) {
            this.twoAppInfo = setIndexItemBean(appInfos, twoItemCls);
        }
        String threeItemCls = SpfUtils.getString(this.bottomThreeItem, "noItem");
        if (!threeItemCls.equals("noItem")) {
            this.threeAppInfo = setIndexItemBean(appInfos, threeItemCls);
        }
        initBottomItemView();
    }

    private void initBottomItemView() {
        if (this.oneAppInfo != null) {
            this.bmwFyNtgV3MainLayoutBinding.llBottomContainer.ntg3v6MainBottomShoujihlRl.getChildAt(0).setBackground(IconUtils.getInstance().ntg6CompressDrawable(this.oneAppInfo.getAppIcon()));
        }
        if (this.twoAppInfo != null) {
            this.bmwFyNtgV3MainLayoutBinding.llBottomContainer.ntg3v6MainBottomThemeRl.getChildAt(0).setBackground(IconUtils.getInstance().ntg6CompressDrawable(this.twoAppInfo.getAppIcon()));
        }
        if (this.threeAppInfo != null) {
            this.bmwFyNtgV3MainLayoutBinding.llBottomContainer.ntg3v6MainBottomVideoRl.getChildAt(0).setBackground(IconUtils.getInstance().ntg6CompressDrawable(this.threeAppInfo.getAppIcon()));
        }
    }

    private AppInfo setIndexItemBean(List<AppInfo> appInfos, String clsName) {
        if (clsName.contains("Ntg6V3")) {
            for (int i = 0; i < resId.length; i++) {
                if (clsName.equals(dialogItemArrys[i])) {
                    AppInfo appInfo = new AppInfo();
                    appInfo.setAppIcon(KswApplication.appContext.getResources().getDrawable(resId[i]));
                    appInfo.setAppLable(bcItemArrys[i]);
                    appInfo.setApppkg(dialogItemArrys[i]);
                    appInfo.setClassName(dialogItemArrys[i]);
                    return appInfo;
                }
            }
        }
        for (AppInfo info : appInfos) {
            if (info.className.equals(clsName)) {
                return info;
            }
        }
        return null;
    }

    private void initDialogAdapter(List<AppInfo> appInfos) {
        if (this.dialogApps == null) {
            this.dialogApps = new ArrayList();
        }
        this.dialogApps.clear();
        this.dialogApps.addAll(appInfos);
        for (int i = 0; i < resId.length; i++) {
            addCustomApp(this.dialogApps, dialogItemArrys[i], KswApplication.appContext.getResources().getDrawable(resId[i]), bcItemArrys[i]);
        }
        this.listAdpater.set(new BaseV3ListAdpater<>(this.dialogApps, R.layout.ntg6v3_app_dialog_item));
    }

    private void addCustomApp(List<AppInfo> listLiveData, String type, Drawable auxIcon, String auxLable) {
        try {
            AppInfo appInfo = new AppInfo();
            appInfo.setAppIcon(auxIcon);
            appInfo.setAppLable(auxLable);
            appInfo.setApppkg(type);
            appInfo.setClassName(type);
            listLiveData.add(appInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void refreAppsize() {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        if (this.mListLiveData == null) {
            this.mListLiveData = new ArrayList();
        }
        this.mListLiveData.clear();
        for (String str : SpfUtils.getString("edit_app_list", "0,1,2,3,4,5,6,7,8,9").split(",")) {
            int index = Integer.parseInt(str);
            addCustomApp(this.mListLiveData, dialogItemArrys[index], KswApplication.appContext.getResources().getDrawable(resId[index]), bcItemArrys[index]);
        }
        this.mListLiveData.addAll(AppsLoaderTask.getInstance().getmListLiveData());
        int totalDataSize = this.mListLiveData.size();
        this.totalPage = (int) Math.ceil((((double) totalDataSize) * 1.0d) / ((double) this.mPageSize));
        Log.i(TAG, "totalpage =" + this.totalPage + "  listsize =" + totalDataSize);
        this.viewPagerList = new ArrayList();
        this.mPagePosition = 0;
        for (int i = 0; i < this.totalPage; i++) {
            GridLayoutManager layoutManager = new GridLayoutManager(this.context, this.gridSpanCount) {
                /* class com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel.AnonymousClass3 */

                @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
                public boolean canScrollVertically() {
                    return false;
                }
            };
            RecyclerView recyclerview = (RecyclerView) inflater.inflate(R.layout.ntg6v3_recyclerview_layout, (ViewGroup) null, false);
            recyclerview.setLayoutManager(layoutManager);
            List<AppInfo> adapterList = new ArrayList<>();
            int i2 = this.mPageSize;
            int count = (i + 1) * i2 > totalDataSize ? totalDataSize : (i + 1) * i2;
            for (int j = i2 * i; j < count; j++) {
                adapterList.add(this.mListLiveData.get(j));
            }
            Ntg6V3AppRecyclerViewAdapter viewAdapter = new Ntg6V3AppRecyclerViewAdapter(adapterList, layoutManager);
            viewAdapter.setItemClickListener(new Ntg6V3AppRecyclerViewAdapter.ItemClickListener() {
                /* class com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel.AnonymousClass4 */

                @Override // com.wits.ksw.launcher.adpater.Ntg6V3AppRecyclerViewAdapter.ItemClickListener
                public void onItemClick(View view, AppInfo item) {
                    if (!Ntg6v3LauncherViewModel.this.localityAppClick(view, item.getClassName())) {
                        Ntg6v3LauncherViewModel.this.openApp((Ntg6v3LauncherViewModel) new ComponentName(item.getApppkg(), item.getClassName()));
                    }
                }
            });
            viewAdapter.setItemKeyListener(new Ntg6V3AppRecyclerViewAdapter.ItemKeyListener() {
                /* class com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel.AnonymousClass5 */

                @Override // com.wits.ksw.launcher.adpater.Ntg6V3AppRecyclerViewAdapter.ItemKeyListener
                public void onItemKey() {
                    if (Ntg6v3LauncherViewModel.this.mPagePosition > 0) {
                        Ntg6v3LauncherViewModel.this.mViewpager.setCurrentItem(Ntg6v3LauncherViewModel.this.mPagePosition - 1);
                        ((RecyclerView) Ntg6v3LauncherViewModel.this.viewPagerList.get(Ntg6v3LauncherViewModel.this.mPagePosition)).getChildAt(9).requestFocus();
                    }
                }
            });
            recyclerview.setAdapter(viewAdapter);
            this.viewPagerList.add(recyclerview);
        }
        ViewPager viewPager = this.bmwFyNtgV3MainLayoutBinding.llPopwindowContainer.viewpager;
        this.mViewpager = viewPager;
        viewPager.setAdapter(new Ntg6V3ViewPagerAdapter(this.viewPagerList));
        this.mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel.AnonymousClass6 */

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                Ntg6v3LauncherViewModel.this.mPagePosition = position;
                Ntg6v3LauncherViewModel.this.setIndicatorBG(position);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }
        });
        initIndicator();
    }

    private void initIndicator() {
        if (this.totalPage >= 1) {
            this.bmwFyNtgV3MainLayoutBinding.llPopwindowContainer.point.removeAllViews();
            this.ivWitstekIndicator = new ImageView[this.totalPage];
            for (int i = 0; i < this.totalPage; i++) {
                ImageView imageView = new ImageView(this.context);
                if (i == 0) {
                    imageView.setBackgroundResource(R.drawable.ntg6_fy_v3_allapp_red);
                } else {
                    imageView.setBackgroundResource(R.drawable.ntg6_fy_v3_allapp_gray);
                }
                this.ivWitstekIndicator[i] = imageView;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(-2, -2));
                layoutParams.leftMargin = 10;
                layoutParams.width = 15;
                layoutParams.height = 15;
                this.bmwFyNtgV3MainLayoutBinding.llPopwindowContainer.point.addView(imageView, layoutParams);
                this.bmwFyNtgV3MainLayoutBinding.llPopwindowContainer.point.setGravity(17);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setIndicatorBG(int selIndex) {
        if (this.ivWitstekIndicator.length >= 1) {
            int i = 0;
            while (true) {
                ImageView[] imageViewArr = this.ivWitstekIndicator;
                if (i < imageViewArr.length) {
                    if (i == selIndex) {
                        imageViewArr[i].setBackgroundResource(R.drawable.ntg6_fy_v3_allapp_red);
                    } else {
                        imageViewArr[i].setBackgroundResource(R.drawable.ntg6_fy_v3_allapp_gray);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public /* synthetic */ void lambda$new$0$Ntg6v3LauncherViewModel(BaseQuickAdapter adapter, View view, int position) {
        AppInfo appInfo = (AppInfo) adapter.getItem(position);
        if (!localityAppClick(view, appInfo.getClassName())) {
            openApp(new ComponentName(appInfo.getApppkg(), appInfo.getClassName()));
        }
    }

    public void viewRefresh() {
        initBottomItemView();
    }

    private int countIndicatorSize(int sum) {
        if (sum % 10 == 0) {
            return sum;
        }
        return ((sum / 10) * 10) + 10;
    }

    public View getViewPagerView() {
        return this.viewPagerList.get(this.mPagePosition);
    }

    public void clickAllAppEdit() {
        Intent intent = new Intent(this.context, BenzNtg6v3FyAppEditActivity.class);
        intent.addFlags(268435456);
        this.context.startActivity(intent);
    }

    public void onItemClick(View view, NtgFyV3Item item) {
        if (item != null) {
            Log.i(TAG, "onItemClick: " + item.getId());
            addLastViewFocused(view);
            refreshLastViewFocused();
            this.uiHandler.removeCallbacksAndMessages(null);
            if (item.getId() < 10) {
                openNtg6Allapp(view, item.getId());
            } else {
                openAppTask(new ComponentName(item.getApppkg(), item.getClassName()));
            }
        }
    }

    private void openNtg6Allapp(View view, int id) {
        switch (id) {
            case 0:
                openNaviApp();
                return;
            case 1:
                openTheme(view);
                return;
            case 2:
                openBtApp();
                return;
            case 3:
                openVideoMulti(view);
                return;
            case 4:
                openSettings(view);
                return;
            case 5:
                openMusicMulti(view);
                return;
            case 6:
                openNtg6v3Eq(view);
                return;
            case 7:
                openShouJiHuLian(view);
                return;
            case 8:
                openCar(view);
                return;
            case 9:
                openDashboard(view);
                return;
            default:
                return;
        }
    }

    public void initAppsStatus() {
        this.allappPopStatle.set(Boolean.valueOf(SpfUtils.getBoolean("isShowNtg6V3Apps", true)));
    }

    public void itemOneClick(View view) {
        AppInfo appInfo = this.oneAppInfo;
        if (appInfo == null) {
            openShouJiHuLian(view);
        } else if (!localityAppClick(view, appInfo.getClassName())) {
            openApp(new ComponentName(this.oneAppInfo.getApppkg(), this.oneAppInfo.getClassName()));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean localityAppClick(View view, String clsName) {
        for (int i = 0; i < resId.length; i++) {
            if (clsName.equals(dialogItemArrys[i])) {
                openNtg6Allapp(view, i);
                return true;
            }
        }
        return false;
    }

    public void itemTwoClick(View view) {
        AppInfo appInfo = this.twoAppInfo;
        if (appInfo == null) {
            openTheme(view);
        } else if (!localityAppClick(view, appInfo.getClassName())) {
            openApp(new ComponentName(this.twoAppInfo.getApppkg(), this.twoAppInfo.getClassName()));
        }
    }

    public void itemThreeClick(View view) {
        AppInfo appInfo = this.threeAppInfo;
        if (appInfo == null) {
            openVideo(view);
        } else if (!localityAppClick(view, appInfo.getClassName())) {
            openApp(new ComponentName(this.threeAppInfo.getApppkg(), this.threeAppInfo.getClassName()));
        }
    }

    public boolean itemOneLongClick(View view) {
        openNtg6V3Dialog(view, this.bottomOneItem);
        return true;
    }

    public boolean itemTwoLongClick(View view) {
        openNtg6V3Dialog(view, this.bottomTwoItem);
        return true;
    }

    public boolean itemThreeLongClick(View view) {
        openNtg6V3Dialog(view, this.bottomThreeItem);
        return true;
    }

    private void openNtg6V3Dialog(final View itemView, final String itemIndex) {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(MainActivity.mainActivity, (int) R.style.AlertDialogTheme));
        View layout = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.ntg6v3_app_dialog, (ViewGroup) null);
        ListView listview = (ListView) layout.findViewById(R.id.dialog_listview);
        listview.setAdapter((ListAdapter) this.listAdpater.get());
        this.listAdpater.get().notifyDataSetChanged();
        Log.d(TAG, "listadata = " + this.listAdpater.get().getCount());
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel.AnonymousClass7 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AppInfo appInfo = (AppInfo) parent.getItemAtPosition(position);
                SpfUtils.saveData(itemIndex, appInfo.className);
                if (itemIndex.equals(Ntg6v3LauncherViewModel.this.bottomOneItem)) {
                    Ntg6v3LauncherViewModel.this.oneAppInfo = appInfo;
                } else if (itemIndex.equals(Ntg6v3LauncherViewModel.this.bottomTwoItem)) {
                    Ntg6v3LauncherViewModel.this.twoAppInfo = appInfo;
                } else {
                    Ntg6v3LauncherViewModel.this.threeAppInfo = appInfo;
                }
                ((ViewGroup) itemView).getChildAt(0).setBackground(appInfo.getAppIcon());
                if (Ntg6v3LauncherViewModel.this.dialog != null) {
                    Ntg6v3LauncherViewModel.this.dialog.dismiss();
                }
            }
        });
        builder.setView(layout);
        this.dialog = builder.create();
        WindowManager manager = MainActivity.mainActivity.getWindowManager();
        manager.getDefaultDisplay().getMetrics(MainActivity.mainActivity.getResources().getDisplayMetrics());
        Display d = manager.getDefaultDisplay();
        Window window = this.dialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams params = window.getAttributes();
        Log.e(TAG, "crateDialog: " + params.width + "  " + params.height + "  " + d.getWidth() + "  " + d.getHeight());
        params.height = (int) (((double) d.getHeight()) * 0.5d);
        params.gravity = 1;
        params.alpha = 0.99f;
        window.setType(2003);
        window.setAttributes(params);
        this.dialog.show();
        Settings.System.putInt(MainActivity.mainActivity.getContentResolver(), "mPageIndex", 4);
        this.dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel.AnonymousClass8 */

            public void onDismiss(DialogInterface dialogInterface) {
            }
        });
        this.dialog.getWindow().getDecorView().findViewById(16908290).setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel.AnonymousClass9 */

            public void onClick(View view) {
                Ntg6v3LauncherViewModel.this.dialog.dismiss();
            }
        });
    }
}

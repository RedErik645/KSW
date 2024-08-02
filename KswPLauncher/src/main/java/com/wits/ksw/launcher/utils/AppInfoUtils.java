package com.wits.ksw.launcher.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.wits.ksw.BuildConfig;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.lexusls.LexusLsAppSelBean;
import com.wits.ksw.launcher.model.AppsLoaderTask;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.benzmbux2021new.util.BenzUtils;
import com.wits.ksw.launcher.view.id8ug.Id8UgConstants;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.launcher.view.id9als.activity.Id9ChangeModelOrWallpaperActivity;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;
import com.wits.pms.statuscontrol.WitsCommand;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppInfoUtils {
    public static final String[] ALS_ID7_UI_ATYS_DISMISS_DESK = {"com.wits.ksw.bt.StartActivity", "com.android.deskclock.DeskClock", "com.iflytek.inputmethod.LauncherActivity", "com.wits.ksw.MainActivity", "com.wits.screencast.myapplication.MainActivity", "com.android.shell.ui.MainActivity", "com.wits.logcat.MainActivity", "com.wits.log.MainActivity"};
    public static final String[] ATYS_DISMISS = {"com.wits.ksw.bt.StartActivity", "com.android.deskclock.DeskClock", "com.iflytek.inputmethod.LauncherActivity", "com.wits.ksw.MainActivity", "com.wits.ksw.music.StartActivity", "com.wits.ksw.video.StartActivity", "com.wits.screencast.myapplication.MainActivity", "com.wits.log.MainActivity"};
    public static final String[] ATYS_DISMISS_DESK = {"com.autonavi.auto.remote.fill.UsbFillActivity", "com.wits.ksw.bt.StartActivity", "com.android.deskclock.DeskClock", "com.iflytek.inputmethod.LauncherActivity", "com.wits.ksw.MainActivity", "com.wits.screencast.myapplication.MainActivity", "com.android.shell.ui.MainActivity", "com.wits.logcat.MainActivity", "com.wits.log.MainActivity"};
    public static final String[] ATYS_DISMISS_MUSIC = {"com.autonavi.auto.remote.fill.UsbFillActivity", "com.wits.ksw.bt.StartActivity", "com.android.deskclock.DeskClock", "com.iflytek.inputmethod.LauncherActivity", "com.wits.ksw.MainActivity", "com.wits.screencast.myapplication.MainActivity", "com.android.shell.ui.MainActivity", "com.android.vending.AssetBrowserActivity", "com.wits.ksw.MainActivity", "com.navngo.igo.javaclient.MainActivity", "com.estrongs.android.pop.view.FileExplorerActivity", "com.google.android.maps.MapsActivity", "com.autonavi.auto.remote.fill.UsbFillActivity", "com.android.settings.Settings", "com.wits.csp.eq.view.StartActivity", "com.wits.apk.MainActivity", LauncherViewModel.CLS_CHROME, "com.wits.log.MainActivity", "com.wits.othersapp.activity.MainActivity", "com.txznet.weather.MainActivity", "com.android.stk.StkMain", "com.wits.logcat.MainActivity"};
    public static final String[] ID7_ALS_DISMISS_DESK = {"com.autonavi.auto.remote.fill.UsbFillActivity", "com.wits.ksw.bt.StartActivity", "com.android.deskclock.DeskClock", "com.iflytek.inputmethod.LauncherActivity", "com.wits.ksw.MainActivity", "com.wits.screencast.myapplication.MainActivity", "com.android.shell.ui.MainActivity", "com.suding.speedplay.ui.MainActivity", "com.wits.logcat.MainActivity", "com.wits.log.MainActivity"};
    public static final String[] PKGS_DISMISS = {"com.autonavi.amapauto", Id8UgConstants.OWN_BT_APP_NAME, "com.android.deskclock", "com.iflytek.inputmethod.google", BuildConfig.APPLICATION_ID, Id8UgConstants.OWN_MUSIC_APP_NAME, Id8UgConstants.OWN_VIDEO_APP_NAME};
    public static final String[] PKG_FREEDOM_MAP = {"com.autonavi.amapauto", BenzUtils.GOOGLE_MAP, "com.kingwaytek.naviking3d", "com.nng.igo.primong.igoworld", "com.nng.igo.primong.palestine", "com.nng.igoprimo.javaclient", "com.nng.igo.primong.hun10th", "com.nng.igoprimoisr2013march24.javaclient"};
    private static final String TAG = AppInfoUtils.class.getSimpleName();

    public static boolean isContainFreedomMap(String pkg) {
        int i = 0;
        while (true) {
            String[] strArr = PKG_FREEDOM_MAP;
            if (i >= strArr.length) {
                return false;
            }
            if (strArr[i].equals(pkg)) {
                return true;
            }
            i++;
        }
    }

    public static boolean isContainApp(String cls) {
        int i = 0;
        while (true) {
            String[] strArr = ATYS_DISMISS;
            if (i >= strArr.length) {
                return false;
            }
            if (strArr[i].equals(cls)) {
                return true;
            }
            i++;
        }
    }

    public static boolean isContainCls(String[] strings, String cls) {
        if (strings == null || strings.length <= 0) {
            return false;
        }
        for (int i = 0; i < strings.length; i++) {
            Log.i(TAG, strings[i]);
            if (strings[i].equals(cls)) {
                return true;
            }
        }
        return false;
    }

    public static List<LexusLsAppSelBean> findLexusLsAllApp(Context context) {
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> infos = getAllApps(context);
        List<LexusLsAppSelBean> beans = new ArrayList<>();
        int tmpAppIndex = 0;
        for (ResolveInfo info : infos) {
            LexusLsAppSelBean bean = new LexusLsAppSelBean();
            bean.setAppIcon(info.activityInfo.loadIcon(pm));
            bean.setAppName((String) info.activityInfo.loadLabel(pm));
            bean.setAppPkg(info.activityInfo.packageName);
            bean.setAppMainAty(info.activityInfo.name);
            bean.setItemPos(tmpAppIndex);
            beans.add(bean);
            tmpAppIndex++;
        }
        getFactorySettingAppLexusBean(tmpAppIndex, beans);
        return beans;
    }

    public static List<LexusLsAppSelBean> findLexusLsAllAppDeleteDesk(Context context) {
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> infos = getAllApps(context);
        List<LexusLsAppSelBean> beans = new ArrayList<>();
        int tmpAppIndex = 0;
        for (ResolveInfo info : infos) {
            Log.e(TAG, "findSelApps..name " + ((Object) info.activityInfo.loadLabel(pm)) + "  " + info.activityInfo.packageName + " mainAty:" + info.activityInfo.name);
            if (!isContainApp(info.activityInfo.name) && !info.activityInfo.packageName.equals("com.wits.logcat") && !info.activityInfo.packageName.equals("com.android.documentsui")) {
                if (info.activityInfo.packageName.equals(BenzUtils.EQ_PKG)) {
                    try {
                        if (PowerManagerApp.getSettingsInt(KeyConfig.EQ_APP) != 0) {
                            LexusLsAppSelBean bean = new LexusLsAppSelBean();
                            bean.setAppIcon(info.activityInfo.loadIcon(pm));
                            bean.setAppName((String) info.activityInfo.loadLabel(pm));
                            bean.setAppPkg(BenzUtils.EQ_PKG);
                            bean.setAppMainAty("com.wits.csp.eq.view.MainActivity");
                            bean.setItemPos(tmpAppIndex);
                            beans.add(bean);
                            tmpAppIndex++;
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                LexusLsAppSelBean bean2 = new LexusLsAppSelBean();
                bean2.setAppIcon(info.activityInfo.loadIcon(pm));
                bean2.setAppName((String) info.activityInfo.loadLabel(pm));
                bean2.setAppPkg(info.activityInfo.packageName);
                bean2.setAppMainAty(info.activityInfo.name);
                bean2.setItemPos(tmpAppIndex);
                beans.add(bean2);
                tmpAppIndex++;
            }
        }
        getFactorySettingAppLexusBean(tmpAppIndex, beans);
        return beans;
    }

    private static void getFactorySettingAppLexusBean(int appIndex, List<LexusLsAppSelBean> beans) {
        try {
            if (PowerManagerApp.getSettingsInt("DTV_Type") == 1) {
                LexusLsAppSelBean bean = new LexusLsAppSelBean();
                bean.setAppIcon(AppsLoaderTask.dtvIcon);
                bean.setAppName(AppsLoaderTask.dtvLable);
                bean.setAppPkg("DTV_Type");
                bean.setAppMainAty(AppsLoaderTask.dtvLable);
                bean.setItemPos(appIndex);
                beans.add(bean);
                appIndex++;
            }
            if (PowerManagerApp.getSettingsInt("Front_view_camera") == 1) {
                LexusLsAppSelBean bean2 = new LexusLsAppSelBean();
                bean2.setAppIcon(AppsLoaderTask.fcamIcon);
                bean2.setAppName(AppsLoaderTask.fcamLable);
                bean2.setAppPkg("Front_view_camera");
                bean2.setAppMainAty(AppsLoaderTask.fcamLable);
                bean2.setItemPos(appIndex);
                beans.add(bean2);
                appIndex++;
            }
            if (PowerManagerApp.getSettingsInt("AUX_Type") == 1) {
                LexusLsAppSelBean bean3 = new LexusLsAppSelBean();
                bean3.setAppIcon(AppsLoaderTask.auxIcon);
                bean3.setAppName(AppsLoaderTask.auxLable);
                bean3.setAppPkg("AUX_Type");
                bean3.setAppMainAty(AppsLoaderTask.auxLable);
                bean3.setItemPos(appIndex);
                beans.add(bean3);
                appIndex++;
            }
            if (PowerManagerApp.getSettingsInt("DVR_Type") == 1) {
                LexusLsAppSelBean bean4 = new LexusLsAppSelBean();
                bean4.setAppIcon(AppsLoaderTask.dvrIcon);
                bean4.setAppName(AppsLoaderTask.dvrLable);
                bean4.setAppPkg("DVR_Type");
                bean4.setAppMainAty(AppsLoaderTask.dvrLable);
                bean4.setItemPos(appIndex);
                beans.add(bean4);
                appIndex++;
            }
            if (UiThemeUtils.isUI_EVOID9_ALS(KswApplication.appContext)) {
                LexusLsAppSelBean bean5 = new LexusLsAppSelBean();
                bean5.setAppIcon(Id9AlsConstants.id9ThemeIcon);
                bean5.setAppName(Id9AlsConstants.id9Theme);
                bean5.setAppPkg(Id9AlsConstants.THEME_TYPE);
                bean5.setAppMainAty(Id9AlsConstants.id9Theme);
                bean5.setItemPos(appIndex);
                beans.add(bean5);
                int appIndex2 = appIndex + 1;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static List<LexusLsAppSelBean> findAllAppsByExclude(String[] cls, int TYPE, Context context) {
        String appCls2;
        String appCls1;
        Log.i(TAG, "TYPE = " + TYPE);
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> infos = getAllApps(context);
        List<LexusLsAppSelBean> beans = new ArrayList<>();
        int tmpAppIndex = 0;
        for (ResolveInfo info : infos) {
            String str = TAG;
            Log.e(str, "findAllAppExclude..name " + ((Object) info.activityInfo.loadLabel(pm)) + "  " + info.activityInfo.packageName + " mainAty:" + info.activityInfo.name);
            LexusLsAppSelBean bean = new LexusLsAppSelBean();
            if (!isContainCls(cls, info.activityInfo.name) && !info.activityInfo.name.contains("com.android.documentsui.LauncherActivity")) {
                if ("com.wits.ksw.music.StartActivity".equals(info.activityInfo.name)) {
                    LexusLsAppSelBean bean_music = new LexusLsAppSelBean();
                    bean_music.setAppIcon(context.getResources().getDrawable(R.drawable.id7_main_music_n));
                    bean_music.setAppName(context.getResources().getString(R.string.ksw_id7_music));
                    bean_music.setAppPkg(KeyConfig.CLS_LOCAL_MUSIC);
                    bean_music.setAppMainAty(KeyConfig.CLS_LOCAL_MUSIC);
                    bean_music.setItemPos(tmpAppIndex);
                    if (TYPE == 1) {
                        appCls1 = Settings.System.getString(context.getContentResolver(), KeyConfig.KEY_THIRD_APP_MUSIC_CLS);
                    } else {
                        appCls1 = Settings.System.getString(context.getContentResolver(), KeyConfig.KEY_THIRD_APP_VIDEO_CLS);
                    }
                    if (TextUtils.isEmpty(appCls1) || !appCls1.equals(KeyConfig.CLS_LOCAL_MUSIC)) {
                        bean_music.setChecked(false);
                    } else {
                        Log.i(str, "findAllAppsByExclude app music cls1 =" + appCls1);
                        bean_music.setChecked(true);
                    }
                    beans.add(bean_music);
                    tmpAppIndex++;
                } else if ("com.wits.ksw.video.StartActivity".equals(info.activityInfo.name)) {
                    LexusLsAppSelBean bean_video = new LexusLsAppSelBean();
                    bean_video.setAppIcon(context.getResources().getDrawable(R.drawable.id7_main_video_n));
                    bean_video.setAppName(context.getResources().getString(R.string.ksw_id7_hd_video));
                    bean_video.setAppPkg(KeyConfig.CLS_LOCAL_VIDEO);
                    bean_video.setAppMainAty(KeyConfig.CLS_LOCAL_VIDEO);
                    bean_video.setItemPos(tmpAppIndex);
                    if (TYPE == 1) {
                        appCls2 = Settings.System.getString(context.getContentResolver(), KeyConfig.KEY_THIRD_APP_MUSIC_CLS);
                    } else {
                        appCls2 = Settings.System.getString(context.getContentResolver(), KeyConfig.KEY_THIRD_APP_VIDEO_CLS);
                    }
                    if (TextUtils.isEmpty(appCls2) || !appCls2.equals(KeyConfig.CLS_LOCAL_VIDEO)) {
                        bean_video.setChecked(false);
                    } else {
                        Log.i(str, "findAllAppsByExclude app video cls2 =" + appCls2);
                        bean_video.setChecked(true);
                    }
                    beans.add(bean_video);
                    tmpAppIndex++;
                } else if ("com.txznet.weather.MainActivity".equals(info.activityInfo.name)) {
                    if (Settings.System.getInt(context.getContentResolver(), KeyConfig.GLOBAL_WEATHER_APP, 1) != 0) {
                        LexusLsAppSelBean weather_bean = new LexusLsAppSelBean();
                        weather_bean.setAppIcon(info.activityInfo.loadIcon(pm));
                        weather_bean.setAppName((String) info.activityInfo.loadLabel(pm));
                        weather_bean.setAppPkg("com.txznet.weather");
                        weather_bean.setAppMainAty("com.txznet.weather.MainActivity");
                        weather_bean.setItemPos(tmpAppIndex);
                        beans.add(weather_bean);
                        tmpAppIndex++;
                    }
                } else if (!BenzUtils.EQ_PKG.equals(info.activityInfo.packageName)) {
                    bean.setAppIcon(info.activityInfo.loadIcon(pm));
                    bean.setAppName((String) info.activityInfo.loadLabel(pm));
                    bean.setAppPkg(info.activityInfo.packageName);
                    bean.setAppMainAty(info.activityInfo.name);
                    bean.setItemPos(tmpAppIndex);
                    if (TYPE == 1) {
                        String appCls12 = Settings.System.getString(context.getContentResolver(), KeyConfig.KEY_THIRD_APP_MUSIC_CLS);
                        if (TextUtils.isEmpty(appCls12) || !appCls12.equals(info.activityInfo.name)) {
                            bean.setChecked(false);
                        } else {
                            Log.i(str, "TYPE == 1 findAllAppsByExclude app pkg =" + appCls12);
                            bean.setChecked(true);
                        }
                    } else if (TYPE == 2) {
                        String appCls22 = Settings.System.getString(context.getContentResolver(), KeyConfig.KEY_THIRD_APP_VIDEO_CLS);
                        if (TextUtils.isEmpty(appCls22) || !appCls22.equals(info.activityInfo.name)) {
                            bean.setChecked(false);
                        } else {
                            Log.i(str, "TYPE == 2 findAllAppsByExclude app pkg =" + appCls22);
                            bean.setChecked(true);
                        }
                    }
                    beans.add(bean);
                    tmpAppIndex++;
                } else if (Settings.System.getInt(context.getContentResolver(), KeyConfig.EQ_APP, 1) != 0) {
                    LexusLsAppSelBean EQ_bean = new LexusLsAppSelBean();
                    EQ_bean.setAppIcon(info.activityInfo.loadIcon(pm));
                    EQ_bean.setAppName((String) info.activityInfo.loadLabel(pm));
                    EQ_bean.setAppPkg(BenzUtils.EQ_PKG);
                    EQ_bean.setAppMainAty("com.wits.csp.eq.view.MainActivity");
                    EQ_bean.setItemPos(tmpAppIndex);
                    beans.add(EQ_bean);
                    tmpAppIndex++;
                }
            }
        }
        return beans;
    }

    public static ResolveInfo findAppByPackageName(Context context, String packageName) {
        new ArrayList();
        PackageManager pm = context.getPackageManager();
        Intent mainIntent = new Intent("android.intent.action.MAIN", (Uri) null);
        mainIntent.addCategory("android.intent.category.LAUNCHER");
        mainIntent.setPackage(packageName);
        List<ResolveInfo> tmpInfos = pm.queryIntentActivities(mainIntent, 0);
        if (tmpInfos.size() <= 0) {
            return null;
        }
        return tmpInfos.get(0);
    }

    public static ResolveInfo findAppByPkgAndCls(Context context, String packageName, String clsName) {
        new ArrayList();
        PackageManager pm = context.getPackageManager();
        Intent mainIntent = new Intent("android.intent.action.MAIN", (Uri) null);
        mainIntent.addCategory("android.intent.category.LAUNCHER");
        mainIntent.setClassName(packageName, clsName);
        List<ResolveInfo> tmpInfos = pm.queryIntentActivities(mainIntent, 0);
        if (tmpInfos.size() <= 0) {
            return null;
        }
        return tmpInfos.get(0);
    }

    public static ArrayList<String> getAppsPackage(List<ResolveInfo> all) {
        ArrayList<String> pkgs = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            pkgs.add(all.get(i).activityInfo.packageName);
        }
        return pkgs;
    }

    public static List<ResolveInfo> getAllApps(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        new ArrayList();
        List<ResolveInfo> allApps = context.getPackageManager().queryIntentActivities(intent, 0);
        Collections.sort(allApps, new ResolveInfo.DisplayNameComparator(context.getPackageManager()));
        return allApps;
    }

    public static List<PackageInfo> getAllPkgs(Context context) {
        List<PackageInfo> apps = new ArrayList<>();
        List<PackageInfo> packlist = context.getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < packlist.size(); i++) {
            PackageInfo pak = packlist.get(i);
            apps.add(pak);
            int i2 = pak.applicationInfo.flags;
            ApplicationInfo applicationInfo = pak.applicationInfo;
            if ((i2 & 1) <= 0) {
                apps.add(pak);
            }
        }
        return apps;
    }

    public static boolean openFactorySettingApp(ComponentName component) {
        if (component == null) {
            return false;
        }
        return openFactorySettingApp(component.getPackageName());
    }

    public static boolean openFactorySettingApp(String pkg) {
        Log.i(TAG, "openFactorySettingApp pkg: " + pkg);
        if ("DTV_Type".equals(pkg)) {
            onSendCommand(1, WitsCommand.SystemCommand.OPEN_DTV);
            return true;
        } else if ("Front_view_camera".equals(pkg)) {
            onSendCommand(1, WitsCommand.SystemCommand.OPEN_F_CAM);
            return true;
        } else if ("AUX_Type".equals(pkg)) {
            onSendCommand(1, WitsCommand.SystemCommand.OPEN_AUX);
            return true;
        } else if ("DVR_Type".equals(pkg)) {
            onSendCommand(1, WitsCommand.SystemCommand.OPEN_CVBSDVR);
            return true;
        } else if (!Id9AlsConstants.THEME_TYPE.equals(pkg)) {
            return false;
        } else {
            KswApplication.appContext.startActivity(new Intent(KswApplication.appContext, Id9ChangeModelOrWallpaperActivity.class).addFlags(268435456));
            return true;
        }
    }

    public static void onSendCommand(int command, int subCommand) {
        Log.i(TAG, "onSendCommand: command:" + command + " subCommand:" + subCommand);
        try {
            WitsCommand.sendCommand(command, subCommand, null);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "onSendCommand: " + e.getMessage());
        }
    }

    public static String getStoragePath(Context mContext, boolean is_removale) {
        StorageManager mStorageManager = (StorageManager) mContext.getSystemService("storage");
        try {
            Class<?> storageVolumeClazz = Class.forName("android.os.storage.StorageVolume");
            Method getVolumeList = mStorageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method getPath = storageVolumeClazz.getMethod("getPath", new Class[0]);
            Method isRemovable = storageVolumeClazz.getMethod("isRemovable", new Class[0]);
            Object result = getVolumeList.invoke(mStorageManager, new Object[0]);
            int length = Array.getLength(result);
            for (int i = 0; i < length; i++) {
                Object storageVolumeElement = Array.get(result, i);
                String path = (String) getPath.invoke(storageVolumeElement, new Object[0]);
                if (is_removale == ((Boolean) isRemovable.invoke(storageVolumeElement, new Object[0])).booleanValue()) {
                    return path;
                }
            }
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static boolean isFactorySettingAppExist(String pkg) {
        try {
            Log.i(TAG, "isFactorySettingAppExist pkg: " + pkg);
            if ("DTV_Type".equals(pkg) && PowerManagerApp.getSettingsInt("DTV_Type") == 1) {
                return true;
            }
            if ("DVR_Type".equals(pkg) && PowerManagerApp.getSettingsInt("DVR_Type") == 1) {
                return true;
            }
            if ("AUX_Type".equals(pkg) && PowerManagerApp.getSettingsInt("AUX_Type") == 1) {
                return true;
            }
            if (!"Front_view_camera".equals(pkg) || PowerManagerApp.getSettingsInt("Front_view_camera") != 1) {
                return false;
            }
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isAppPakExist(Context context, String packageName) {
        boolean isExist = false;
        if (isFactorySettingAppExist(packageName)) {
            return true;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.i(TAG, "isAppPakExist: app not installed, packageName" + packageName);
        }
        if (applicationInfo != null) {
            isExist = true;
        }
        Log.i(TAG, "isAppPakExist: isExist = " + isExist);
        return isExist;
    }

    public static int dip2px(Context context, float dpValue) {
        return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Drawable zoomDrawable(Drawable drawable, int w, int h) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap oldbmp = drawableToBitmap(drawable);
        Matrix matrix = new Matrix();
        matrix.postScale(((float) w) / ((float) width), ((float) h) / ((float) height));
        return new BitmapDrawable((Resources) null, Bitmap.createBitmap(oldbmp, 0, 0, width, height, matrix, true));
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap.Config config;
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }
}

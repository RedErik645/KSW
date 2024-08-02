package com.wits.ksw.launcher.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.AppInfo;
import com.wits.ksw.launcher.dabebase.AppInfoRoomDatabase;
import com.wits.ksw.launcher.dabebase.AppList;
import com.wits.ksw.launcher.utils.ClientManager;
import com.wits.ksw.launcher.utils.IconUtils;
import com.wits.ksw.launcher.utils.UiThemeUtils;
import com.wits.ksw.launcher.view.id8ug.Id8UgConstants;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppsLoaderTask {
    public static final String AUX_TYPE = "AUX_Type";
    private static final String DESKCLOCK_PKG = "com.android.deskclock";
    private static final String DOCUMENTS_UI = "com.android.documentsui";
    public static final String DTV_TYPE = "DTV_Type";
    public static final String DVR = "com.ankai.cardvr";
    public static final String DVR_TYPE = "DVR_Type";
    private static final String EQ_PKG = "com.wits.csp.eq";
    private static final String E_CAR = "com.ecar.assistantnew";
    public static final String F_CAM_Type = "Front_view_camera";
    private static final String GAODE_MAP_PKG = "com.autonavi.amapauto";
    private static final String GN_TXZ = "com.txznet.adapter";
    private static final String GOOGLE_ASSISTANT_PKG = "com.google.android.apps.googleassistant";
    private static final String GOOGLE_MAP = "com.google.android.apps.maps";
    private static final String GOOGLE_PLAY = "com.android.vending";
    private static final String GOOGLE_SEARCH_PKG = "com.google.android.googlequicksearchbox";
    private static final String HY_TXZ = "com.txznet.smartadapter";
    private static final String IFLYTEK_PKG = "com.iflytek.inputmethod.google";
    private static final String PRE_SET_APP = "preset_app";
    private static final String SIM_APK = "com.android.stk";
    private static final String SOUGOU_PKG = "com.sohu.inputmethod.sogou";
    private static final String SPEEDPLAY_PKG = "com.suding.speedplay";
    private static final String TAG = "AppsLoaderTask";
    private static final String TS_TXZ = "com.txznet.aipal";
    public static final String WEATHER_PKG = "com.txznet.weather";
    private static final String WITS_LOG_PKG = "com.wits.log";
    private static final String ZLINK_PKG = "com.zjinnova.zlink";
    public static Drawable auxIcon = KswApplication.appContext.getDrawable(R.drawable.ic_aux);
    public static String auxLable = KswApplication.appContext.getString(R.string.app_aux);
    public static Drawable dtvIcon = KswApplication.appContext.getDrawable(R.drawable.ic_dtv);
    public static String dtvLable = KswApplication.appContext.getString(R.string.app_dtv);
    public static Drawable dvrIcon = KswApplication.appContext.getDrawable(R.drawable.ic_dvr);
    public static String dvrLable = KswApplication.appContext.getString(R.string.app_dvr);
    public static Drawable fcamIcon = KswApplication.appContext.getDrawable(R.drawable.icon_fcam);
    public static String fcamLable = KswApplication.appContext.getString(R.string.app_fcam);
    public static List<AppList> mAppLists = new ArrayList();
    public static Context mContext;
    public static List<AppInfo> mListLiveData = new ArrayList();
    public static List<AppsLoaderTaskListener> mLoaderTaskListenerList;
    public static AppsLoaderTask singleton;

    public interface AppsLoaderTaskListener {
        void allAppsLoaded(List<AppInfo> list);

        void dialogAppsListLoaded(List<AppInfo> list);

        void shortcutsLoaded(List<AppInfo> list);

        void updateShortcuts(List<AppInfo> list);
    }

    private AppsLoaderTask() {
        mContext = KswApplication.appContext;
        if (mLoaderTaskListenerList == null) {
            mLoaderTaskListenerList = new ArrayList();
        }
    }

    public static AppsLoaderTask getInstance() {
        if (singleton == null) {
            synchronized (AppsLoaderTask.class) {
                if (singleton == null) {
                    singleton = new AppsLoaderTask();
                }
            }
        }
        return singleton;
    }

    public void setLoaderTaskListener(AppsLoaderTaskListener listener) {
        mLoaderTaskListenerList.add(listener);
    }

    public List<AppInfo> getmListLiveData() {
        return mListLiveData;
    }

    public void queryAllApps() {
        Log.i(TAG, "queryAllApps: ");
        new QueryAppsAsyncTask().execute(new Void[0]);
    }

    private class QueryAppsAsyncTask extends AsyncTask<Void, Void, List<AppInfo>> {
        private QueryAppsAsyncTask() {
        }

        public List<AppInfo> queryApps() {
            Log.i(AppsLoaderTask.TAG, "queryApps: ");
            AppsLoaderTask.mAppLists = AppInfoRoomDatabase.getDatabase(KswApplication.appContext).getAppInfoDao().queryAll();
            List<ResolveInfo> resolveInfoList = getResolveInfos();
            PackageManager pm = KswApplication.appContext.getPackageManager();
            List<AppInfo> appInfoList = new ArrayList<>();
            if (resolveInfoList != null || !resolveInfoList.isEmpty()) {
                for (ResolveInfo resolveInfo : resolveInfoList) {
                    String packageName = resolveInfo.activityInfo.packageName;
                    Log.d(AppsLoaderTask.TAG, ((Object) resolveInfo.activityInfo.loadLabel(AppsLoaderTask.mContext.getPackageManager())) + "  " + packageName + "  " + resolveInfo.activityInfo.name);
                    if (!AppsLoaderTask.this.isOutTXZ(packageName) && !AppsLoaderTask.this.isFilterAllGoogleAPP(packageName) && !AppsLoaderTask.this.isFilterSimCardAPP(packageName) && !AppsLoaderTask.this.isOutECAR(packageName) && !AppsLoaderTask.this.isOutEQ(packageName) && !AppsLoaderTask.this.isOutWeather(packageName) && !AppsLoaderTask.this.filterAppDisplay(packageName)) {
                        AppInfo appInfo = new AppInfo();
                        Drawable iconDrawable = resolveInfo.loadIcon(pm);
                        appInfo.setAppIcon(iconDrawable);
                        String label = resolveInfo.loadLabel(pm).toString();
                        appInfo.setAppLable(label);
                        appInfo.setApppkg(packageName);
                        appInfo.setClassName(resolveInfo.activityInfo.name);
                        if (ClientManager.getInstance().isAls6208Client() && IconUtils.getInstance().isRoundStyle()) {
                            AppsLoaderTask.this.loadRoundRectIcon(packageName, appInfo, iconDrawable, label);
                        }
                        if (UiThemeUtils.isUI_EVOID9_ALS(KswApplication.appContext)) {
                            AppsLoaderTask.this.loadId9AppIcon(packageName, appInfo, iconDrawable, label);
                        }
                        if (UiThemeUtils.isEVOID8_UG(KswApplication.appContext)) {
                            AppsLoaderTask.this.loadId8UgAppIcon(packageName, appInfo, iconDrawable, label);
                        }
                        appInfoList.add(appInfo);
                    }
                }
            }
            return appInfoList;
        }

        public List<ResolveInfo> getResolveInfos() {
            PackageManager pm = KswApplication.appContext.getPackageManager();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            return pm.queryIntentActivities(intent, 131072);
        }

        /* access modifiers changed from: protected */
        public List<AppInfo> doInBackground(Void... voids) {
            return queryApps();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(List<AppInfo> listLiveData) {
            super.onPostExecute((Object) listLiveData);
            AppsLoaderTask.addCustomApp(listLiveData, "AUX_Type", AppsLoaderTask.auxIcon, AppsLoaderTask.auxLable);
            AppsLoaderTask.addCustomApp(listLiveData, "DTV_Type", AppsLoaderTask.dtvIcon, AppsLoaderTask.dtvLable);
            AppsLoaderTask.addCustomApp(listLiveData, "DVR_Type", AppsLoaderTask.dvrIcon, AppsLoaderTask.dvrLable);
            AppsLoaderTask.addCustomApp(listLiveData, "Front_view_camera", AppsLoaderTask.fcamIcon, AppsLoaderTask.fcamLable);
            if (UiThemeUtils.isUI_EVOID9_ALS(KswApplication.appContext)) {
                AppInfo appInfo = new AppInfo();
                appInfo.setAppIcon(Id9AlsConstants.id9ThemeIcon);
                appInfo.setAppLable(Id9AlsConstants.id9Theme);
                appInfo.setApppkg(Id9AlsConstants.THEME_TYPE);
                appInfo.setClassName(Id9AlsConstants.THEME_TYPE);
                listLiveData.add(appInfo);
            }
            AppsLoaderTask.mListLiveData.clear();
            for (int i = 0; i < AppsLoaderTask.mAppLists.size(); i++) {
                int j = 0;
                while (true) {
                    if (j >= listLiveData.size()) {
                        break;
                    } else if (AppsLoaderTask.mAppLists.get(i).getClassName().equals(listLiveData.get(j).getClassName())) {
                        AppsLoaderTask.mListLiveData.add(listLiveData.get(j));
                        listLiveData.remove(j);
                        break;
                    } else {
                        j++;
                    }
                }
            }
            for (AppInfo appInfo2 : listLiveData) {
                AppsLoaderTask.mListLiveData.add(appInfo2);
            }
            AppsLoaderTask.SaveAppList();
            if (AppsLoaderTask.mLoaderTaskListenerList != null && AppsLoaderTask.mLoaderTaskListenerList.size() > 0) {
                for (AppsLoaderTaskListener listener : AppsLoaderTask.mLoaderTaskListenerList) {
                    listener.allAppsLoaded(AppsLoaderTask.mListLiveData);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadId9AppIcon(String packageName, AppInfo appInfo, Drawable drawable, String label) {
        appInfo.setAppIcon(Id9AlsConstants.getIcon(packageName, drawable));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadId8UgAppIcon(String packageName, AppInfo appInfo, Drawable drawable, String label) {
        Drawable roundIcon = Id8UgConstants.getIcon(packageName, drawable);
        String ownPakName = Id8UgConstants.getOwnApkName(packageName);
        if (!TextUtils.isEmpty(ownPakName)) {
            appInfo.setAppLable(ownPakName);
        }
        appInfo.setAppIcon(roundIcon);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadRoundRectIcon(String packageName, AppInfo appInfo, Drawable drawable, String label) {
        appInfo.setAppIcon(IconUtils.getInstance().getIcon(packageName, appInfo, drawable, label));
    }

    public boolean isOutTXZ(String packageName) {
        try {
            if (PowerManagerApp.getSettingsInt(KeyConfig.TXZ) != 0) {
                return false;
            }
            if (packageName.contains(HY_TXZ) || packageName.contains(GN_TXZ) || packageName.contains(TS_TXZ)) {
                return true;
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isOutECAR(String packageName) {
        try {
            if (PowerManagerApp.getSettingsInt(KeyConfig.E_CAR) != 0 || !packageName.contains(E_CAR)) {
                return false;
            }
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isOutEQ(String packageName) {
        try {
            if (PowerManagerApp.getSettingsInt(KeyConfig.EQ_APP) != 0 || !packageName.contains("com.wits.csp.eq")) {
                return false;
            }
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isOutWeather(String packageName) {
        try {
            if (PowerManagerApp.getSettingsInt(KeyConfig.GLOBAL_WEATHER_APP) != 0 || !packageName.contains("com.txznet.weather")) {
                return false;
            }
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isFilterAllGoogleAPP(String packageName) {
        try {
            if (PowerManagerApp.getSettingsInt(KeyConfig.GOOGLE_APP) != 0) {
                return false;
            }
            if (packageName.contains("com.android.vending") || packageName.contains("com.google.android.apps.maps") || packageName.contains("com.google.android.googlequicksearchbox") || packageName.contains("com.google.android.apps.googleassistant")) {
                return true;
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isFilterSimCardAPP(String packageName) {
        return packageName.contains(SIM_APK);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean filterAppDisplay(String packageName) {
        if (packageName.contains(mContext.getClass().getPackage().toString()) || packageName.contains(IFLYTEK_PKG) || packageName.contains(DESKCLOCK_PKG) || packageName.contains(WITS_LOG_PKG) || packageName.contains(DOCUMENTS_UI) || packageName.contains(SOUGOU_PKG)) {
            return true;
        }
        if (!UiThemeUtils.isEVOID8_UG(KswApplication.appContext) && packageName.contains(KswApplication.appContext.getPackageName())) {
            Log.d(TAG, "filterAppDisplay packageName: " + packageName);
            return true;
        } else if (packageName.equals(KswApplication.appContext.getPackageName())) {
            Log.d(TAG, "filterAppDisplay packageName: " + packageName);
            return true;
        } else {
            int speed_play_switch = Settings.System.getInt(mContext.getContentResolver(), "speed_play_switch", 1);
            if (speed_play_switch != 2 && packageName.contains(SPEEDPLAY_PKG)) {
                return true;
            }
            if (speed_play_switch == 2 && packageName.contains(ZLINK_PKG)) {
                return true;
            }
            if (!Arrays.asList(mContext.getResources().getStringArray(R.array.exclude_class_list)).contains(packageName)) {
                return false;
            }
            Log.d(TAG, "filterAppDisplay: excludeClassArray packagename =" + packageName);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public static void addCustomApp(List<AppInfo> listLiveData, String type, Drawable auxIcon2, String auxLable2) {
        try {
            if (PowerManagerApp.getSettingsInt(type) == 1) {
                AppInfo appInfo = new AppInfo();
                appInfo.setAppIcon(auxIcon2);
                appInfo.setAppLable(auxLable2);
                appInfo.setApppkg(type);
                appInfo.setClassName(type);
                listLiveData.add(appInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void SaveAppList() {
        synchronized (AppsLoaderTask.class) {
            final List<AppList> newAppList = new ArrayList<>();
            for (AppInfo appInfo : mListLiveData) {
                AppList appList = new AppList();
                appList.setClassName(appInfo.getClassName());
                newAppList.add(appList);
                Log.d(TAG, "SaveAppList: appinfo=" + appInfo.getClassName());
                if (TextUtils.isEmpty(appInfo.getClassName())) {
                    Log.e(TAG, "SaveAppList: appinfo ClassName isEmpty AppLable = " + appInfo.getAppLable());
                    return;
                }
            }
            new Thread(new Runnable() {
                /* class com.wits.ksw.launcher.model.AppsLoaderTask.AnonymousClass1 */

                public void run() {
                    AppInfoRoomDatabase.getDatabase(AppsLoaderTask.mContext).getAppInfoDao().deleteAll();
                    AppInfoRoomDatabase.getDatabase(AppsLoaderTask.mContext).getAppInfoDao().insert(newAppList);
                }
            }).start();
        }
    }
}

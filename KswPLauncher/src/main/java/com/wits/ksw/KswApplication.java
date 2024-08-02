package com.wits.ksw;

import android.app.Application;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.wits.ksw.launcher.bmw_id8_ui.GSID8LauncherConstants;
import com.wits.ksw.launcher.bmw_id8_ui.ID8LauncherConstants;
import com.wits.ksw.launcher.bmw_id8_ui.PempID8LauncherConstants;
import com.wits.ksw.launcher.model.AppsLoaderTask;
import com.wits.ksw.launcher.utils.Constants;
import com.wits.ksw.launcher.utils.SettingsSystemUtil;
import com.wits.ksw.launcher.utils.SpfUtils;
import com.wits.ksw.launcher.utils.UiThemeUtils;
import com.wits.ksw.launcher.view.benzmbux2021new.util.BenzUtils;
import com.wits.ksw.launcher.view.id8ug.Id8UgConstants;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.settings.benz_mbux_2021.BenzMbuxSettingsConstants;
import com.wits.ksw.settings.utlis_view.DialogViews;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.ksw.settings.utlis_view.McuUtil;
import com.wits.ksw.settings.utlis_view.UtilsInfo;
import com.wits.pms.IContentObserver;
import com.wits.pms.statuscontrol.PowerManagerApp;
import com.wits.pms.statuscontrol.WitsCommand;
import skin.support.SkinCompatManager;
import skin.support.app.SkinCardViewInflater;
import skin.support.constraint.app.SkinConstraintViewInflater;
import skin.support.design.app.SkinMaterialViewInflater;

public class KswApplication extends Application {
    public static final String SKIN_NAME = "SkinName";
    public static final String TAG = "KswApplication";
    public static Context appContext;
    public static boolean factoryUsbHost = true;
    public static SkinCompatManager.SkinLoaderListener listener = new SkinCompatManager.SkinLoaderListener() {
        /* class com.wits.ksw.KswApplication.AnonymousClass2 */

        @Override // skin.support.SkinCompatManager.SkinLoaderListener
        public void onStart() {
            Log.w(KswApplication.TAG, "onStart: ");
        }

        @Override // skin.support.SkinCompatManager.SkinLoaderListener
        public void onSuccess() {
            Log.w(KswApplication.TAG, "onSuccess: ");
        }

        @Override // skin.support.SkinCompatManager.SkinLoaderListener
        public void onFailed(String errMsg) {
            Log.w(KswApplication.TAG, "onFailed: " + errMsg);
        }
    };
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        /* class com.wits.ksw.KswApplication.AnonymousClass4 */

        public void onReceive(Context context, Intent intent) {
            Log.i(KswApplication.TAG, "onReceive: " + intent.getAction());
            AppsLoaderTask.getInstance().queryAllApps();
        }
    };
    public ContentObserver contentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.KswApplication.AnonymousClass3 */

        public void onChange(boolean selfChange, Uri uri) {
            Log.d(KswApplication.TAG, "onChange: 11111111111");
            KswApplication.getSkinNameAndRefresh();
        }
    };
    private DevicePolicyManager mDPM;
    private KswBroadcastReceiver mKswBroadcastReceiver;
    private PackageManager mPm;

    public void onCreate() {
        appContext = this;
        Log.i(TAG, "App onCreate  name=1.0");
        SpfUtils.init(this);
        PowerManagerApp.init(appContext);
        registerKswBroadcastReceiver();
        registerReceiver();
        refreshApp();
        ID8LauncherConstants.init(appContext);
        GSID8LauncherConstants.init(appContext);
        PempID8LauncherConstants.init(appContext);
        BenzMbuxSettingsConstants.init(appContext);
        if (UiThemeUtils.isUiChanged(this) && (UiThemeUtils.isBMW_ID8_UI(this) || UiThemeUtils.isUI_GS_ID8(this) || UiThemeUtils.isUI_PEMP_ID8(this))) {
            Settings.System.putString(appContext.getContentResolver(), ID8LauncherConstants.ID8_SKIN, "yellow");
        }
        if (UiThemeUtils.isEVOID8_UG(this)) {
            SettingsSystemUtil.putString(appContext.getContentResolver(), ID8LauncherConstants.ID8_SKIN, "blue");
        }
        if (UiThemeUtils.isALS_ID7_UI(this) || UiThemeUtils.isBMW_ID8_UI(this) || UiThemeUtils.isUI_GS_ID8(this) || UiThemeUtils.isUI_PEMP_ID8(this) || UiThemeUtils.isUI_NTG6_FY_V3(this) || UiThemeUtils.isUI_EVOID9_ALS(this) || UiThemeUtils.isEVOID8_UG(this)) {
            initSkin();
            getSkinNameAndRefresh();
            registerSkinObserver();
        }
        registerTopAppObserver();
        super.onCreate();
    }

    private void registerTopAppObserver() {
        PowerManagerApp.registerIContentObserver("topApp", new IContentObserver.Stub() {
            /* class com.wits.ksw.KswApplication.AnonymousClass1 */

            @Override // com.wits.pms.IContentObserver
            public void onChange() throws RemoteException {
                try {
                    String topApp = PowerManagerApp.getStatusString("topApp");
                    Log.i(KswApplication.TAG, "topAppObserver: " + topApp);
                    if (!TextUtils.isEmpty(topApp) && topApp.contains("com.kugou.android")) {
                        WitsCommand.sendCommand(1, WitsCommand.SystemCommand.OPEN_MODE, "13");
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void getSkinNameAndRefresh() {
        String skinName = null;
        String benzSkinName = null;
        if (UiThemeUtils.isALS_ID7_UI(appContext)) {
            skinName = Settings.System.getString(appContext.getContentResolver(), SKIN_NAME);
            if (TextUtils.isEmpty(skinName)) {
                skinName = "blue";
            }
        }
        if (UiThemeUtils.isBMW_ID8_UI(appContext) || UiThemeUtils.isUI_GS_ID8(appContext) || UiThemeUtils.isUI_PEMP_ID8(appContext)) {
            skinName = ID8LauncherConstants.loadCurrentSkin();
            if (TextUtils.isEmpty(skinName)) {
                skinName = "yellow";
            }
        }
        if (UiThemeUtils.isUI_NTG6_FY_V3(appContext)) {
            benzSkinName = BenzMbuxSettingsConstants.loadCurrentSkin();
            Log.d(TAG, "onCreate: benzSkinName= " + benzSkinName);
            if (TextUtils.isEmpty(benzSkinName)) {
                benzSkinName = "blue";
            }
        }
        if (UiThemeUtils.isUI_EVOID9_ALS(appContext)) {
            Id9AlsConstants.refreshId9Skin();
        } else if (UiThemeUtils.isEVOID8_UG(appContext)) {
            Id8UgConstants.refreshId8Skin();
        } else {
            Log.d(TAG, "getSkinName:  skinName= " + skinName);
            if (TextUtils.isEmpty(skinName) && TextUtils.isEmpty(benzSkinName)) {
                return;
            }
            if (ID8LauncherConstants.ID8_SKIN_SPORT.equals(skinName) || BenzMbuxSettingsConstants.NTG6_SKIN_PURPLE.equals(benzSkinName)) {
                SkinCompatManager.getInstance().loadSkin("red.skin", listener, 0);
            } else if ("yellow".equals(skinName) || "yellow".equals(benzSkinName)) {
                SkinCompatManager.getInstance().loadSkin("yellow.skin", listener, 0);
            } else {
                SkinCompatManager.getInstance().restoreDefaultTheme();
            }
        }
    }

    private void registerSkinObserver() {
        getContentResolver().registerContentObserver(Settings.System.getUriFor(SKIN_NAME), true, this.contentObserver);
        getContentResolver().registerContentObserver(Settings.System.getUriFor(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL), true, this.contentObserver);
        getContentResolver().registerContentObserver(Settings.System.getUriFor(Id9AlsConstants.ID9ALS_SKIN_MODEL), true, this.contentObserver);
        getContentResolver().registerContentObserver(Settings.System.getUriFor(Id8UgConstants.ID8UG_SKIN_MODEL), true, this.contentObserver);
    }

    public void onLowMemory() {
        super.onLowMemory();
        Log.i(TAG, "onLowMemory: ");
    }

    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.i(TAG, "onTrimMemory: level=" + level);
    }

    public void initSkin() {
        SkinCompatManager.withoutActivity(this).addInflater(new SkinMaterialViewInflater()).addInflater(new SkinConstraintViewInflater()).addInflater(new SkinCardViewInflater()).setSkinStatusBarColorEnable(false).setSkinWindowBackgroundEnable(false);
    }

    private void registerKswBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ksw.mcu.send");
        KswBroadcastReceiver kswBroadcastReceiver = new KswBroadcastReceiver();
        this.mKswBroadcastReceiver = kswBroadcastReceiver;
        registerReceiver(kswBroadcastReceiver, intentFilter);
    }

    public class KswBroadcastReceiver extends BroadcastReceiver {
        private static final String MCU_ACTION = "readver";
        private static final String MCU_FACTORY_CONFIG = "update.factory_config";
        private static final String MCU_START = "update.start";
        private static final String MCU_STATUS = "update.ready";
        private DialogViews dialogViews;

        public KswBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            this.dialogViews = new DialogViews(context);
            Intent intent_recv = new Intent("com.ksw.mcu.recv");
            if (!intent.getAction().equals("com.ksw.mcu.send")) {
                return;
            }
            if (intent.getStringExtra("action").equals(MCU_ACTION)) {
                String mvformat = McuUtil.getMcuVersion();
                intent_recv.putExtra("action", "mcuver");
                intent_recv.putExtra("value", mvformat);
                context.sendBroadcast(intent_recv);
            } else if (intent.getStringExtra("action").equals(MCU_START)) {
                Intent intent1 = new Intent(context, McuDialogActivity.class);
                intent1.setFlags(268435456);
                context.startActivity(intent1);
            } else if (intent.getStringExtra("action").equals(MCU_FACTORY_CONFIG)) {
                this.dialogViews.updateDefXml();
            }
        }
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        appContext.registerReceiver(this.broadcastReceiver, intentFilter);
    }

    private void refreshApp() {
        try {
            String baseBand = UtilsInfo.getBaseband_Ver();
            Log.i(TAG, "refreshApp: baseBand " + baseBand);
            int googleApp = Settings.System.getInt(getContentResolver(), KeyConfig.GOOGLE_APP, 0);
            if (googleApp == 0) {
                DevicePolicyManager devicePolicyManager = (DevicePolicyManager) getSystemService("device_policy");
                this.mDPM = devicePolicyManager;
                devicePolicyManager.removeActiveAdmin(new ComponentName("com.google.android.gms", "com.google.android.gms.mdm.receivers.MdmDeviceAdminReceiver"));
                this.mPm = getPackageManager();
                if (TextUtils.isEmpty(baseBand) || (!baseBand.contains("M501") && !baseBand.contains("8953"))) {
                    this.mPm.setApplicationEnabledSetting(BenzUtils.GOOGLE_ASSISTANT_PKG, 3, 0);
                    this.mPm.setApplicationEnabledSetting("com.google.android.ims", 3, 0);
                    this.mPm.setApplicationEnabledSetting(BenzUtils.GOOGLE_PLAY, 3, 0);
                    this.mPm.setApplicationEnabledSetting(BenzUtils.GOOGLE_MAP, 3, 0);
                    this.mPm.setApplicationEnabledSetting("com.google.android.partnersetup", 3, 0);
                    this.mPm.setApplicationEnabledSetting("com.google.android.gms", 3, 0);
                    this.mPm.setApplicationEnabledSetting("com.google.android.inputmethod.latin", 3, 0);
                    this.mPm.setApplicationEnabledSetting(BenzUtils.GOOGLE_SEARCH_PKG, 3, 0);
                } else {
                    this.mPm.setApplicationEnabledSetting(BenzUtils.GOOGLE_PLAY, 3, 0);
                    this.mPm.setApplicationEnabledSetting(BenzUtils.GOOGLE_MAP, 3, 0);
                    this.mPm.setApplicationEnabledSetting("com.google.android.partnersetup", 3, 0);
                    this.mPm.setApplicationEnabledSetting("com.google.android.gms", 3, 0);
                    this.mPm.setApplicationEnabledSetting("com.google.android.inputmethod.latin", 3, 0);
                    this.mPm.setApplicationEnabledSetting(BenzUtils.GOOGLE_SEARCH_PKG, 3, 0);
                }
            } else if (googleApp == 1) {
                this.mPm = getPackageManager();
                if (TextUtils.isEmpty(baseBand) || (!baseBand.contains("M501") && !baseBand.contains("8953"))) {
                    this.mPm.setApplicationEnabledSetting(BenzUtils.GOOGLE_ASSISTANT_PKG, 1, 0);
                    this.mPm.setApplicationEnabledSetting("com.google.android.ims", 1, 0);
                    this.mPm.setApplicationEnabledSetting(BenzUtils.GOOGLE_PLAY, 1, 0);
                    this.mPm.setApplicationEnabledSetting(BenzUtils.GOOGLE_MAP, 1, 0);
                    this.mPm.setApplicationEnabledSetting("com.google.android.partnersetup", 1, 0);
                    this.mPm.setApplicationEnabledSetting("com.google.android.gms", 1, 0);
                    this.mPm.setApplicationEnabledSetting("com.google.android.inputmethod.latin", 1, 0);
                    this.mPm.setApplicationEnabledSetting(BenzUtils.GOOGLE_SEARCH_PKG, 1, 0);
                } else {
                    this.mPm.setApplicationEnabledSetting(BenzUtils.GOOGLE_PLAY, 1, 0);
                    this.mPm.setApplicationEnabledSetting(BenzUtils.GOOGLE_MAP, 1, 0);
                    this.mPm.setApplicationEnabledSetting("com.google.android.partnersetup", 1, 0);
                    this.mPm.setApplicationEnabledSetting("com.google.android.gms", 1, 0);
                    this.mPm.setApplicationEnabledSetting("com.google.android.inputmethod.latin", 1, 0);
                    this.mPm.setApplicationEnabledSetting(BenzUtils.GOOGLE_SEARCH_PKG, 1, 0);
                }
            }
            AppsLoaderTask.getInstance().queryAllApps();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAppsData() {
        Log.i(TAG, "loadAppsData: ");
        AppsLoaderTask.getInstance().queryAllApps();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        loadAppsData();
    }
}

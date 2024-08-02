package com.wits.ksw.launcher.base;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;
import com.wits.ksw.BlackActivity;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.AppInfo;
import com.wits.ksw.launcher.model.AppsLoaderTask;
import com.wits.ksw.launcher.utils.AppInfoUtils;
import com.wits.ksw.launcher.utils.UiThemeUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;
import com.wits.pms.statuscontrol.WitsCommand;
import java.util.List;

public abstract class BaseViewModel extends ViewModel implements AppsLoaderTask.AppsLoaderTaskListener {
    private static final String TAG = BaseViewModel.class.getSimpleName();
    protected Activity activity;
    public AppsLoaderTask appsLoaderTask = AppsLoaderTask.getInstance();
    protected ContentResolver contentResolver;
    protected Context context;
    private boolean igoFree = false;
    private boolean igoToFull = false;
    protected PackageManager mPackageManager;
    protected String unknow;

    public abstract void resumeViewModel();

    public BaseViewModel() {
        Log.i(TAG, "BaseViewModel: ");
        Context context2 = KswApplication.appContext;
        this.context = context2;
        if (this.unknow == null) {
            this.unknow = context2.getString(17039374);
        }
        if (this.contentResolver == null) {
            this.contentResolver = this.context.getContentResolver();
        }
        if (this.mPackageManager == null) {
            this.mPackageManager = this.context.getPackageManager();
        }
        this.appsLoaderTask.setLoaderTaskListener(this);
    }

    public void setActivity(Activity activity2) {
        this.activity = activity2;
    }

    /* access modifiers changed from: protected */
    public void openApp(ComponentName component) {
        try {
            if (!AppInfoUtils.openFactorySettingApp(component)) {
                Intent intent = new Intent();
                intent.setComponent(component);
                this.activity.startActivity(intent);
                Log.i(TAG, "openApp: " + component.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Context context2 = this.context;
            Toast.makeText(context2, context2.getString(R.string.uninstall), 0).show();
        }
    }

    public void openAppTask(ComponentName component) {
        boolean isVersion12 = Build.VERSION.RELEASE.contains("12") || Build.VERSION.RELEASE.contains("13");
        String str = TAG;
        Log.w(str, "isVersion12 :" + isVersion12);
        if (!AppInfoUtils.openFactorySettingApp(component)) {
            if (component.getPackageName().contains("com.locnall.KimGiSa")) {
                this.context.getPackageManager().setApplicationEnabledSetting("com.google.android.gms", 3, 0);
                this.context.getPackageManager().setApplicationEnabledSetting("com.google.android.gms", 0, 0);
            }
            if (!isVersion12 || !AppInfoUtils.isContainFreedomMap(component.getPackageName()) || (!UiThemeUtils.isUI_GS_ID8(this.activity) && !UiThemeUtils.isUI_EVOID9_ALS(this.activity))) {
                try {
                    Intent intent = new Intent();
                    intent.setComponent(component);
                    intent.setFlags(268435456);
                    this.activity.startActivity(intent);
                    Log.i(str, "openApp: " + component.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    Context context2 = this.context;
                    Toast.makeText(context2, context2.getString(R.string.uninstall), 0).show();
                }
            } else {
                launchApp(component.getPackageName(), 1);
            }
        }
    }

    public void launchApp(String packageName, int windowsMode) {
        if (packageName.contains("com.nng.igo.primong.palestine")) {
            handleIgoNavi(packageName, windowsMode);
        } else {
            launchAppByWindowMode(packageName, windowsMode);
        }
    }

    private void handleIgoNavi(final String packageName, final int windowsMode) {
        if (windowsMode == 5) {
            new Handler().postDelayed(new Runnable() {
                /* class com.wits.ksw.launcher.base.BaseViewModel.AnonymousClass1 */

                public void run() {
                    BaseViewModel.this.igoFree = true;
                    BaseViewModel.this.igoToFull = false;
                    BaseViewModel.this.launchAppByWindowMode(packageName, windowsMode);
                    new Handler().postDelayed(new Runnable() {
                        /* class com.wits.ksw.launcher.base.BaseViewModel.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            BaseViewModel.this.igoFree = false;
                            if (BaseViewModel.this.igoToFull) {
                                BaseViewModel.this.gotoFullByBlack(packageName, 1);
                            }
                        }
                    }, 2000);
                }
            }, 200);
        } else if (this.igoFree) {
            this.igoToFull = true;
        } else {
            this.igoToFull = false;
            gotoFullByBlack(packageName, windowsMode);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gotoFullByBlack(String packageName, int windowsMode) {
        if (windowsMode == 1) {
            this.activity.startActivity(new Intent(this.activity, BlackActivity.class));
        }
        launchAppByWindowMode(packageName, windowsMode);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void launchAppByWindowMode(String packageName, int windowsMode) {
        WitsCommand.sendCommand(20, 100, packageName + "," + windowsMode);
    }

    private Rect getDisplayRect(int windowsMode) {
        DisplayMetrics metric = new DisplayMetrics();
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        int screenWidth = metric.widthPixels;
        int screenHeight = metric.heightPixels;
        if (windowsMode == 5) {
            return new Rect(180, 120, 870, 648);
        }
        return new Rect(0, 0, screenWidth, screenHeight);
    }

    public void openApp(Intent intent) {
        try {
            this.activity.startActivity(intent);
            Log.i(TAG, "openApp: " + intent.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Context context2 = this.context;
            Toast.makeText(context2, context2.getString(R.string.uninstall), 0).show();
        }
    }

    public void openMapApp(Intent intent) {
        try {
            this.activity.startActivity(intent);
            Log.i(TAG, "openApp: " + intent.toString());
        } catch (Exception e) {
            e.printStackTrace();
            try {
                int googleApp = PowerManagerApp.getSettingsInt(KeyConfig.GOOGLE_APP);
                Log.d(TAG, "openApp: googleApp=" + googleApp);
                if (googleApp == 0) {
                    try {
                        this.activity.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.autonavi.amapauto"));
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        Context context2 = this.context;
                        Toast.makeText(context2, context2.getString(R.string.uninstall), 0).show();
                    }
                } else {
                    Context context3 = this.context;
                    Toast.makeText(context3, context3.getString(R.string.uninstall), 0).show();
                }
            } catch (RemoteException e1) {
                e1.printStackTrace();
                Context context4 = this.context;
                Toast.makeText(context4, context4.getString(R.string.uninstall), 0).show();
            }
        }
    }

    @Override // com.wits.ksw.launcher.model.AppsLoaderTask.AppsLoaderTaskListener
    public void allAppsLoaded(List<AppInfo> list) {
    }

    @Override // com.wits.ksw.launcher.model.AppsLoaderTask.AppsLoaderTaskListener
    public void updateShortcuts(List<AppInfo> list) {
    }

    @Override // com.wits.ksw.launcher.model.AppsLoaderTask.AppsLoaderTaskListener
    public void shortcutsLoaded(List<AppInfo> list) {
    }

    @Override // com.wits.ksw.launcher.model.AppsLoaderTask.AppsLoaderTaskListener
    public void dialogAppsListLoaded(List<AppInfo> list) {
    }

    /* access modifiers changed from: protected */
    @Override // android.arch.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Log.i(TAG, "onCleared: ");
    }
}

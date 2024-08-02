package com.wits.ksw.settings.utlis_view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.wits.ksw.launcher.model.AppsLoaderTask;
import com.wits.ksw.launcher.view.benzmbux2021new.util.BenzUtils;
import com.wits.ksw.launcher.view.id8ug.Id8UgConstants;
import com.wits.ksw.settings.id7.bean.DevBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScanDevList {
    private String devDefual;
    private List<DevBean> devList;
    private boolean isScanDev;
    private boolean isScanPlay;
    private List<DevBean> playAppList;

    private ScanDevList() {
        this.devDefual = "";
        this.isScanDev = false;
        this.isScanPlay = false;
    }

    /* access modifiers changed from: private */
    public static class SingletonInstance {
        private static final ScanDevList INSTANCE = new ScanDevList();

        private SingletonInstance() {
        }
    }

    public static ScanDevList getInstance() {
        return SingletonInstance.INSTANCE;
    }

    public List<DevBean> scanList(final List<String> naviList, String devDefual2, final Context context) {
        this.devList = new ArrayList();
        this.devDefual = devDefual2;
        new Thread(new Runnable() {
            /* class com.wits.ksw.settings.utlis_view.ScanDevList.AnonymousClass1 */

            public void run() {
                if (!ScanDevList.this.isScanDev) {
                    ScanDevList.this.isScanDev = true;
                    for (String paca : naviList) {
                        ScanDevList scanDevList = ScanDevList.this;
                        scanDevList.isAvilible(context, paca, scanDevList.devList);
                    }
                }
                ScanDevList.this.isScanDev = false;
            }
        }).start();
        return this.devList;
    }

    public List<DevBean> playAppList(final Context context, final String defPlayApp) {
        this.playAppList = new ArrayList();
        new Thread(new Runnable() {
            /* class com.wits.ksw.settings.utlis_view.ScanDevList.AnonymousClass2 */

            public void run() {
                if (!ScanDevList.this.isScanPlay) {
                    ScanDevList.this.isScanPlay = true;
                    ScanDevList scanDevList = ScanDevList.this;
                    scanDevList.scanPlayApp(context, defPlayApp, scanDevList.playAppList);
                }
                ScanDevList.this.isScanPlay = false;
            }
        }).start();
        return this.playAppList;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void isAvilible(final Context context, String packageName, List<DevBean> mbList) {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List apps = context.getPackageManager().queryIntentActivities(intent, 0);
        Collections.sort(apps, new Comparator<ResolveInfo>() {
            /* class com.wits.ksw.settings.utlis_view.ScanDevList.AnonymousClass3 */

            public int compare(ResolveInfo a, ResolveInfo b) {
                return String.CASE_INSENSITIVE_ORDER.compare(a.loadLabel(context.getPackageManager()).toString(), b.loadLabel(context.getPackageManager()).toString());
            }
        });
        for (int i = 0; i < apps.size(); i++) {
            ResolveInfo info = apps.get(i);
            String packName = info.activityInfo.packageName;
            CharSequence appName = info.activityInfo.loadLabel(context.getPackageManager());
            Drawable iconbm = info.activityInfo.loadIcon(context.getPackageManager());
            if (packageName.equals(packName)) {
                DevBean devBean = new DevBean();
                devBean.setPackageName(packName);
                devBean.setName(appName.toString());
                devBean.setAppicon(iconbm);
                if (packName.equals(this.devDefual)) {
                    devBean.setCheck(true);
                }
                mbList.add(devBean);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void scanPlayApp(final Context context, String packageName, List<DevBean> mbList) {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List apps = context.getPackageManager().queryIntentActivities(intent, 0);
        Collections.sort(apps, new Comparator<ResolveInfo>() {
            /* class com.wits.ksw.settings.utlis_view.ScanDevList.AnonymousClass4 */

            public int compare(ResolveInfo a, ResolveInfo b) {
                return String.CASE_INSENSITIVE_ORDER.compare(a.loadLabel(context.getPackageManager()).toString(), b.loadLabel(context.getPackageManager()).toString());
            }
        });
        addMediaPackageInfo(context, packageName, Id8UgConstants.OWN_MUSIC_APP_NAME, mbList);
        addMediaPackageInfo(context, packageName, Id8UgConstants.OWN_VIDEO_APP_NAME, mbList);
        for (int i = 0; i < apps.size(); i++) {
            ResolveInfo info = apps.get(i);
            String packName = info.activityInfo.packageName;
            CharSequence appName = info.activityInfo.loadLabel(context.getPackageManager());
            Drawable iconbm = info.activityInfo.loadIcon(context.getPackageManager());
            if (packName.lastIndexOf("wits") < 0 && !TextUtils.equals(packName, "com.estrongs.android.pop") && !TextUtils.equals(packName, "com.cyanogenmod.filemanager") && !TextUtils.equals(packName, "com.iflytek.inputmethod.google") && !TextUtils.equals(packName, BenzUtils.GOOGLE_SEARCH_PKG) && !TextUtils.equals(packName, BenzUtils.GOOGLE_PLAY) && !TextUtils.equals(packName, AppsLoaderTask.DVR) && !TextUtils.equals(packName, "com.android.chrome") && !TextUtils.equals(packName, BenzUtils.GOOGLE_MAP) && !TextUtils.equals(packName, "com.android.shell") && !TextUtils.equals(packName, "com.android.settings") && !TextUtils.equals(packName, "com.autonavi.amapauto")) {
                Log.d("ScanPlayApp", "packname:" + packName);
                DevBean devBean = new DevBean();
                devBean.setPackageName(packName);
                devBean.setName(appName.toString());
                devBean.setAppicon(iconbm);
                if (packName.equals(packageName)) {
                    devBean.setCheck(true);
                }
                mbList.add(devBean);
            }
        }
    }

    private void addMediaPackageInfo(Context context, String packageName, String packageName1, List<DevBean> mbList) {
        try {
            PackageManager pm = context.getPackageManager();
            ApplicationInfo appInfo = pm.getPackageInfo(packageName1, 0).applicationInfo;
            DevBean devBean = new DevBean();
            devBean.setPackageName(packageName1);
            devBean.setName(appInfo.loadLabel(pm).toString());
            devBean.setAppicon(appInfo.loadIcon(pm));
            if (packageName.equals(packageName1)) {
                devBean.setCheck(true);
            }
            mbList.add(devBean);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}

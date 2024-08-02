package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class AppUtils {
    private AppUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void registerAppStatusChangedListener(Utils.OnAppStatusChangedListener listener) {
        if (listener != null) {
            UtilsBridge.addOnAppStatusChangedListener(listener);
            return;
        }
        throw new NullPointerException("Argument 'listener' of type Utils.OnAppStatusChangedListener (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void unregisterAppStatusChangedListener(Utils.OnAppStatusChangedListener listener) {
        if (listener != null) {
            UtilsBridge.removeOnAppStatusChangedListener(listener);
            return;
        }
        throw new NullPointerException("Argument 'listener' of type Utils.OnAppStatusChangedListener (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void installApp(String filePath) {
        installApp(UtilsBridge.getFileByPath(filePath));
    }

    public static void installApp(File file) {
        Intent installAppIntent = UtilsBridge.getInstallAppIntent(file);
        if (installAppIntent != null) {
            Utils.getApp().startActivity(installAppIntent);
        }
    }

    public static void installApp(Uri uri) {
        Intent installAppIntent = UtilsBridge.getInstallAppIntent(uri);
        if (installAppIntent != null) {
            Utils.getApp().startActivity(installAppIntent);
        }
    }

    public static void uninstallApp(String packageName) {
        if (!UtilsBridge.isSpace(packageName)) {
            Utils.getApp().startActivity(UtilsBridge.getUninstallAppIntent(packageName));
        }
    }

    public static boolean isAppInstalled(String pkgName) {
        if (UtilsBridge.isSpace(pkgName)) {
            return false;
        }
        try {
            return Utils.getApp().getPackageManager().getApplicationInfo(pkgName, 0).enabled;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean isAppRoot() {
        if (UtilsBridge.execCmd("echo root", true).result == 0) {
            return true;
        }
        return false;
    }

    public static boolean isAppDebug() {
        return isAppDebug(Utils.getApp().getPackageName());
    }

    public static boolean isAppDebug(String packageName) {
        ApplicationInfo ai;
        if (UtilsBridge.isSpace(packageName) || (ai = Utils.getApp().getApplicationInfo()) == null || (ai.flags & 2) == 0) {
            return false;
        }
        return true;
    }

    public static boolean isAppSystem() {
        return isAppSystem(Utils.getApp().getPackageName());
    }

    public static boolean isAppSystem(String packageName) {
        if (UtilsBridge.isSpace(packageName)) {
            return false;
        }
        try {
            ApplicationInfo ai = Utils.getApp().getPackageManager().getApplicationInfo(packageName, 0);
            if (ai == null || (ai.flags & 1) == 0) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isAppForeground() {
        List<ActivityManager.RunningAppProcessInfo> info;
        ActivityManager am = (ActivityManager) Utils.getApp().getSystemService("activity");
        if (am == null || (info = am.getRunningAppProcesses()) == null || info.size() == 0) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo aInfo : info) {
            if (aInfo.importance == 100 && aInfo.processName.equals(Utils.getApp().getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAppForeground(String pkgName) {
        if (pkgName != null) {
            return !UtilsBridge.isSpace(pkgName) && pkgName.equals(UtilsBridge.getForegroundProcessName());
        }
        throw new NullPointerException("Argument 'pkgName' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean isAppRunning(String pkgName) {
        if (UtilsBridge.isSpace(pkgName)) {
            return false;
        }
        int uid = Utils.getApp().getApplicationInfo().uid;
        ActivityManager am = (ActivityManager) Utils.getApp().getSystemService("activity");
        if (am != null) {
            List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(Integer.MAX_VALUE);
            if (taskInfo != null && taskInfo.size() > 0) {
                for (ActivityManager.RunningTaskInfo aInfo : taskInfo) {
                    if (aInfo.baseActivity != null && pkgName.equals(aInfo.baseActivity.getPackageName())) {
                        return true;
                    }
                }
            }
            List<ActivityManager.RunningServiceInfo> serviceInfo = am.getRunningServices(Integer.MAX_VALUE);
            if (serviceInfo != null && serviceInfo.size() > 0) {
                for (ActivityManager.RunningServiceInfo aInfo2 : serviceInfo) {
                    if (uid == aInfo2.uid) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void launchApp(String packageName) {
        if (!UtilsBridge.isSpace(packageName)) {
            Intent launchAppIntent = UtilsBridge.getLaunchAppIntent(packageName);
            if (launchAppIntent == null) {
                Log.e("AppUtils", "Didn't exist launcher activity.");
            } else {
                Utils.getApp().startActivity(launchAppIntent);
            }
        }
    }

    public static void relaunchApp() {
        relaunchApp(false);
    }

    public static void relaunchApp(boolean isKillProcess) {
        Intent intent = UtilsBridge.getLaunchAppIntent(Utils.getApp().getPackageName());
        if (intent == null) {
            Log.e("AppUtils", "Didn't exist launcher activity.");
            return;
        }
        intent.addFlags(335577088);
        Utils.getApp().startActivity(intent);
        if (isKillProcess) {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }

    public static void launchAppDetailsSettings() {
        launchAppDetailsSettings(Utils.getApp().getPackageName());
    }

    public static void launchAppDetailsSettings(String pkgName) {
        if (!UtilsBridge.isSpace(pkgName)) {
            Intent intent = UtilsBridge.getLaunchAppDetailsSettingsIntent(pkgName, true);
            if (UtilsBridge.isIntentAvailable(intent)) {
                Utils.getApp().startActivity(intent);
            }
        }
    }

    public static void launchAppDetailsSettings(Activity activity, int requestCode) {
        launchAppDetailsSettings(activity, requestCode, Utils.getApp().getPackageName());
    }

    public static void launchAppDetailsSettings(Activity activity, int requestCode, String pkgName) {
        if (activity != null && !UtilsBridge.isSpace(pkgName)) {
            Intent intent = UtilsBridge.getLaunchAppDetailsSettingsIntent(pkgName, false);
            if (UtilsBridge.isIntentAvailable(intent)) {
                activity.startActivityForResult(intent, requestCode);
            }
        }
    }

    public static void exitApp() {
        UtilsBridge.finishAllActivities();
        System.exit(0);
    }

    public static Drawable getAppIcon() {
        return getAppIcon(Utils.getApp().getPackageName());
    }

    public static Drawable getAppIcon(String packageName) {
        Drawable drawable = null;
        if (UtilsBridge.isSpace(packageName)) {
            return null;
        }
        try {
            PackageManager pm = Utils.getApp().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            if (pi != null) {
                drawable = pi.applicationInfo.loadIcon(pm);
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getAppIconId() {
        return getAppIconId(Utils.getApp().getPackageName());
    }

    public static int getAppIconId(String packageName) {
        int i = 0;
        if (UtilsBridge.isSpace(packageName)) {
            return 0;
        }
        try {
            PackageInfo pi = Utils.getApp().getPackageManager().getPackageInfo(packageName, 0);
            if (pi != null) {
                i = pi.applicationInfo.icon;
            }
            return i;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getAppPackageName() {
        return Utils.getApp().getPackageName();
    }

    public static String getAppName() {
        return getAppName(Utils.getApp().getPackageName());
    }

    public static String getAppName(String packageName) {
        if (UtilsBridge.isSpace(packageName)) {
            return "";
        }
        try {
            PackageManager pm = Utils.getApp().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            if (pi == null) {
                return null;
            }
            return pi.applicationInfo.loadLabel(pm).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getAppPath() {
        return getAppPath(Utils.getApp().getPackageName());
    }

    public static String getAppPath(String packageName) {
        if (UtilsBridge.isSpace(packageName)) {
            return "";
        }
        try {
            PackageInfo pi = Utils.getApp().getPackageManager().getPackageInfo(packageName, 0);
            if (pi == null) {
                return null;
            }
            return pi.applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getAppVersionName() {
        return getAppVersionName(Utils.getApp().getPackageName());
    }

    public static String getAppVersionName(String packageName) {
        if (UtilsBridge.isSpace(packageName)) {
            return "";
        }
        try {
            PackageInfo pi = Utils.getApp().getPackageManager().getPackageInfo(packageName, 0);
            if (pi == null) {
                return null;
            }
            return pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getAppVersionCode() {
        return getAppVersionCode(Utils.getApp().getPackageName());
    }

    public static int getAppVersionCode(String packageName) {
        if (UtilsBridge.isSpace(packageName)) {
            return -1;
        }
        try {
            PackageInfo pi = Utils.getApp().getPackageManager().getPackageInfo(packageName, 0);
            if (pi == null) {
                return -1;
            }
            return pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static Signature[] getAppSignature() {
        return getAppSignature(Utils.getApp().getPackageName());
    }

    public static Signature[] getAppSignature(String packageName) {
        if (UtilsBridge.isSpace(packageName)) {
            return null;
        }
        try {
            PackageInfo pi = Utils.getApp().getPackageManager().getPackageInfo(packageName, 64);
            if (pi == null) {
                return null;
            }
            return pi.signatures;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAppSignatureSHA1() {
        return getAppSignatureSHA1(Utils.getApp().getPackageName());
    }

    public static String getAppSignatureSHA1(String packageName) {
        return getAppSignatureHash(packageName, "SHA1");
    }

    public static String getAppSignatureSHA256() {
        return getAppSignatureSHA256(Utils.getApp().getPackageName());
    }

    public static String getAppSignatureSHA256(String packageName) {
        return getAppSignatureHash(packageName, "SHA256");
    }

    public static String getAppSignatureMD5() {
        return getAppSignatureMD5(Utils.getApp().getPackageName());
    }

    public static String getAppSignatureMD5(String packageName) {
        return getAppSignatureHash(packageName, "MD5");
    }

    public static int getAppUid() {
        return getAppUid(Utils.getApp().getPackageName());
    }

    public static int getAppUid(String pkgName) {
        try {
            return Utils.getApp().getPackageManager().getApplicationInfo(pkgName, 0).uid;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static String getAppSignatureHash(String packageName, String algorithm) {
        Signature[] signature;
        if (!UtilsBridge.isSpace(packageName) && (signature = getAppSignature(packageName)) != null && signature.length > 0) {
            return UtilsBridge.bytes2HexString(UtilsBridge.hashTemplate(signature[0].toByteArray(), algorithm)).replaceAll("(?<=[0-9A-F]{2})[0-9A-F]{2}", ":$0");
        }
        return "";
    }

    public static AppInfo getAppInfo() {
        return getAppInfo(Utils.getApp().getPackageName());
    }

    public static AppInfo getAppInfo(String packageName) {
        try {
            PackageManager pm = Utils.getApp().getPackageManager();
            if (pm == null) {
                return null;
            }
            return getBean(pm, pm.getPackageInfo(packageName, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<AppInfo> getAppsInfo() {
        List<AppInfo> list = new ArrayList<>();
        PackageManager pm = Utils.getApp().getPackageManager();
        if (pm == null) {
            return list;
        }
        for (PackageInfo pi : pm.getInstalledPackages(0)) {
            AppInfo ai = getBean(pm, pi);
            if (ai != null) {
                list.add(ai);
            }
        }
        return list;
    }

    public static AppInfo getApkInfo(File apkFile) {
        if (apkFile == null || !apkFile.isFile() || !apkFile.exists()) {
            return null;
        }
        return getApkInfo(apkFile.getAbsolutePath());
    }

    public static AppInfo getApkInfo(String apkFilePath) {
        PackageManager pm;
        PackageInfo pi;
        if (UtilsBridge.isSpace(apkFilePath) || (pm = Utils.getApp().getPackageManager()) == null || (pi = pm.getPackageArchiveInfo(apkFilePath, 0)) == null) {
            return null;
        }
        ApplicationInfo appInfo = pi.applicationInfo;
        appInfo.sourceDir = apkFilePath;
        appInfo.publicSourceDir = apkFilePath;
        return getBean(pm, pi);
    }

    private static AppInfo getBean(PackageManager pm, PackageInfo pi) {
        if (pi == null) {
            return null;
        }
        ApplicationInfo ai = pi.applicationInfo;
        return new AppInfo(pi.packageName, ai.loadLabel(pm).toString(), ai.loadIcon(pm), ai.sourceDir, pi.versionName, pi.versionCode, (ai.flags & 1) != 0);
    }

    public static class AppInfo {
        private Drawable icon;
        private boolean isSystem;
        private String name;
        private String packageName;
        private String packagePath;
        private int versionCode;
        private String versionName;

        public Drawable getIcon() {
            return this.icon;
        }

        public void setIcon(Drawable icon2) {
            this.icon = icon2;
        }

        public boolean isSystem() {
            return this.isSystem;
        }

        public void setSystem(boolean isSystem2) {
            this.isSystem = isSystem2;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String packageName2) {
            this.packageName = packageName2;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name2) {
            this.name = name2;
        }

        public String getPackagePath() {
            return this.packagePath;
        }

        public void setPackagePath(String packagePath2) {
            this.packagePath = packagePath2;
        }

        public int getVersionCode() {
            return this.versionCode;
        }

        public void setVersionCode(int versionCode2) {
            this.versionCode = versionCode2;
        }

        public String getVersionName() {
            return this.versionName;
        }

        public void setVersionName(String versionName2) {
            this.versionName = versionName2;
        }

        public AppInfo(String packageName2, String name2, Drawable icon2, String packagePath2, String versionName2, int versionCode2, boolean isSystem2) {
            setName(name2);
            setIcon(icon2);
            setPackageName(packageName2);
            setPackagePath(packagePath2);
            setVersionName(versionName2);
            setVersionCode(versionCode2);
            setSystem(isSystem2);
        }

        public String toString() {
            return "{\n    pkg name: " + getPackageName() + "\n    app icon: " + getIcon() + "\n    app name: " + getName() + "\n    app path: " + getPackagePath() + "\n    app v name: " + getVersionName() + "\n    app v code: " + getVersionCode() + "\n    is system: " + isSystem() + "\n}";
        }
    }
}

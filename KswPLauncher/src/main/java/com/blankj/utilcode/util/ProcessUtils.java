package com.blankj.utilcode.util;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ProcessUtils {
    private ProcessUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String getForegroundProcessName() {
        List<ActivityManager.RunningAppProcessInfo> pInfo = ((ActivityManager) Utils.getApp().getSystemService("activity")).getRunningAppProcesses();
        if (pInfo != null && pInfo.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo aInfo : pInfo) {
                if (aInfo.importance == 100) {
                    return aInfo.processName;
                }
            }
        }
        if (Build.VERSION.SDK_INT > 21) {
            PackageManager pm = Utils.getApp().getPackageManager();
            Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
            List<ResolveInfo> list = pm.queryIntentActivities(intent, 65536);
            Log.i("ProcessUtils", list.toString());
            if (list.size() <= 0) {
                Log.i("ProcessUtils", "getForegroundProcessName: noun of access to usage information.");
                return "";
            }
            try {
                ApplicationInfo info = pm.getApplicationInfo(Utils.getApp().getPackageName(), 0);
                AppOpsManager aom = (AppOpsManager) Utils.getApp().getSystemService("appops");
                if (aom.checkOpNoThrow("android:get_usage_stats", info.uid, info.packageName) != 0) {
                    intent.addFlags(268435456);
                    Utils.getApp().startActivity(intent);
                }
                if (aom.checkOpNoThrow("android:get_usage_stats", info.uid, info.packageName) != 0) {
                    Log.i("ProcessUtils", "getForegroundProcessName: refuse to device usage stats.");
                    return "";
                }
                UsageStatsManager usageStatsManager = (UsageStatsManager) Utils.getApp().getSystemService("usagestats");
                List<UsageStats> usageStatsList = null;
                if (usageStatsManager != null) {
                    long endTime = System.currentTimeMillis();
                    usageStatsList = usageStatsManager.queryUsageStats(4, endTime - 604800000, endTime);
                }
                if (usageStatsList != null) {
                    if (!usageStatsList.isEmpty()) {
                        UsageStats recentStats = null;
                        for (UsageStats usageStats : usageStatsList) {
                            if (recentStats == null || usageStats.getLastTimeUsed() > recentStats.getLastTimeUsed()) {
                                recentStats = usageStats;
                            }
                        }
                        if (recentStats == null) {
                            return null;
                        }
                        return recentStats.getPackageName();
                    }
                }
                return "";
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static Set<String> getAllBackgroundProcesses() {
        List<ActivityManager.RunningAppProcessInfo> info = ((ActivityManager) Utils.getApp().getSystemService("activity")).getRunningAppProcesses();
        Set<String> set = new HashSet<>();
        if (info != null) {
            for (ActivityManager.RunningAppProcessInfo aInfo : info) {
                Collections.addAll(set, aInfo.pkgList);
            }
        }
        return set;
    }

    public static Set<String> killAllBackgroundProcesses() {
        ActivityManager am = (ActivityManager) Utils.getApp().getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> info = am.getRunningAppProcesses();
        Set<String> set = new HashSet<>();
        if (info == null) {
            return set;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = info.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String[] strArr = it.next().pkgList;
            for (String pkg : strArr) {
                am.killBackgroundProcesses(pkg);
                set.add(pkg);
            }
        }
        for (ActivityManager.RunningAppProcessInfo aInfo : am.getRunningAppProcesses()) {
            for (String pkg2 : aInfo.pkgList) {
                set.remove(pkg2);
            }
        }
        return set;
    }

    public static boolean killBackgroundProcesses(String packageName) {
        if (packageName != null) {
            ActivityManager am = (ActivityManager) Utils.getApp().getSystemService("activity");
            List<ActivityManager.RunningAppProcessInfo> info = am.getRunningAppProcesses();
            if (info == null || info.size() == 0) {
                return true;
            }
            for (ActivityManager.RunningAppProcessInfo aInfo : info) {
                if (Arrays.asList(aInfo.pkgList).contains(packageName)) {
                    am.killBackgroundProcesses(packageName);
                }
            }
            List<ActivityManager.RunningAppProcessInfo> info2 = am.getRunningAppProcesses();
            if (info2 == null || info2.size() == 0) {
                return true;
            }
            for (ActivityManager.RunningAppProcessInfo aInfo2 : info2) {
                if (Arrays.asList(aInfo2.pkgList).contains(packageName)) {
                    return false;
                }
            }
            return true;
        }
        throw new NullPointerException("Argument 'packageName' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean isMainProcess() {
        return Utils.getApp().getPackageName().equals(getCurrentProcessName());
    }

    public static String getCurrentProcessName() {
        String name = getCurrentProcessNameByFile();
        if (!TextUtils.isEmpty(name)) {
            return name;
        }
        String name2 = getCurrentProcessNameByAms();
        if (!TextUtils.isEmpty(name2)) {
            return name2;
        }
        return getCurrentProcessNameByReflect();
    }

    private static String getCurrentProcessNameByFile() {
        try {
            BufferedReader mBufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String processName = mBufferedReader.readLine().trim();
            mBufferedReader.close();
            return processName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String getCurrentProcessNameByAms() {
        List<ActivityManager.RunningAppProcessInfo> info;
        try {
            ActivityManager am = (ActivityManager) Utils.getApp().getSystemService("activity");
            if (!(am == null || (info = am.getRunningAppProcesses()) == null)) {
                if (info.size() != 0) {
                    int pid = Process.myPid();
                    for (ActivityManager.RunningAppProcessInfo aInfo : info) {
                        if (aInfo.pid == pid && aInfo.processName != null) {
                            return aInfo.processName;
                        }
                    }
                    return "";
                }
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    private static String getCurrentProcessNameByReflect() {
        try {
            Application app = Utils.getApp();
            Field loadedApkField = app.getClass().getField("mLoadedApk");
            loadedApkField.setAccessible(true);
            Object loadedApk = loadedApkField.get(app);
            Field activityThreadField = loadedApk.getClass().getDeclaredField("mActivityThread");
            activityThreadField.setAccessible(true);
            Object activityThread = activityThreadField.get(loadedApk);
            return (String) activityThread.getClass().getDeclaredMethod("getProcessName", new Class[0]).invoke(activityThread, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}

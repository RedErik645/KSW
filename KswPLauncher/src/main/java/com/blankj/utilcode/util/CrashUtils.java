package com.blankj.utilcode.util;

import android.os.Build;
import java.io.File;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class CrashUtils {
    private static final Thread.UncaughtExceptionHandler DEFAULT_UNCAUGHT_EXCEPTION_HANDLER = Thread.getDefaultUncaughtExceptionHandler();
    private static final String FILE_SEP = System.getProperty("file.separator");

    public interface OnCrashListener {
        void onCrash(String str, Throwable th);
    }

    private CrashUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void init() {
        init("");
    }

    public static void init(File crashDir) {
        if (crashDir != null) {
            init(crashDir.getAbsolutePath(), (OnCrashListener) null);
            return;
        }
        throw new NullPointerException("Argument 'crashDir' of type File (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void init(String crashDirPath) {
        init(crashDirPath, (OnCrashListener) null);
    }

    public static void init(OnCrashListener onCrashListener) {
        init("", onCrashListener);
    }

    public static void init(File crashDir, OnCrashListener onCrashListener) {
        if (crashDir != null) {
            init(crashDir.getAbsolutePath(), onCrashListener);
            return;
        }
        throw new NullPointerException("Argument 'crashDir' of type File (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void init(String crashDirPath, OnCrashListener onCrashListener) {
        String dirPath;
        if (!UtilsBridge.isSpace(crashDirPath)) {
            String dirPath2 = FILE_SEP;
            dirPath = crashDirPath.endsWith(dirPath2) ? crashDirPath : crashDirPath + dirPath2;
        } else if (!UtilsBridge.isSDCardEnableByEnvironment() || Utils.getApp().getExternalFilesDir(null) == null) {
            StringBuilder append = new StringBuilder().append(Utils.getApp().getFilesDir());
            String str = FILE_SEP;
            dirPath = append.append(str).append("crash").append(str).toString();
        } else {
            StringBuilder append2 = new StringBuilder().append(Utils.getApp().getExternalFilesDir(null));
            String str2 = FILE_SEP;
            dirPath = append2.append(str2).append("crash").append(str2).toString();
        }
        Thread.setDefaultUncaughtExceptionHandler(getUncaughtExceptionHandler(dirPath, onCrashListener));
    }

    private static Thread.UncaughtExceptionHandler getUncaughtExceptionHandler(final String dirPath, final OnCrashListener onCrashListener) {
        return new Thread.UncaughtExceptionHandler() {
            /* class com.blankj.utilcode.util.CrashUtils.AnonymousClass1 */

            public void uncaughtException(Thread t, Throwable e) {
                if (t == null) {
                    throw new NullPointerException("Argument 't' of type Thread (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
                } else if (e != null) {
                    String time = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss").format(new Date());
                    StringBuilder sb = new StringBuilder();
                    sb.append("************* Log Head ****************\nTime Of Crash      : " + time + "\nDevice Manufacturer: " + Build.MANUFACTURER + "\nDevice Model       : " + Build.MODEL + "\nAndroid Version    : " + Build.VERSION.RELEASE + "\nAndroid SDK        : " + Build.VERSION.SDK_INT + "\nApp VersionName    : " + UtilsBridge.getAppVersionName() + "\nApp VersionCode    : " + UtilsBridge.getAppVersionCode() + "\n************* Log Head ****************\n\n").append(UtilsBridge.getFullStackTrace(e));
                    String crashInfo = sb.toString();
                    UtilsBridge.writeFileFromString(dirPath + time + ".txt", crashInfo, true);
                    OnCrashListener onCrashListener = onCrashListener;
                    if (onCrashListener != null) {
                        onCrashListener.onCrash(crashInfo, e);
                    }
                    if (CrashUtils.DEFAULT_UNCAUGHT_EXCEPTION_HANDLER != null) {
                        CrashUtils.DEFAULT_UNCAUGHT_EXCEPTION_HANDLER.uncaughtException(t, e);
                    }
                } else {
                    throw new NullPointerException("Argument 'e' of type Throwable (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
                }
            }
        };
    }
}

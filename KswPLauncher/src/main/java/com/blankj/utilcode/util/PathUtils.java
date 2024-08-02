package com.blankj.utilcode.util;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

public final class PathUtils {
    private static final char SEP = File.separatorChar;

    private PathUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String join(String parent, String child) {
        if (TextUtils.isEmpty(child)) {
            return parent;
        }
        if (parent == null) {
            parent = "";
        }
        int len = parent.length();
        String legalSegment = getLegalSegment(child);
        if (len == 0) {
            return SEP + legalSegment;
        }
        char charAt = parent.charAt(len - 1);
        char c = SEP;
        if (charAt == c) {
            return parent + legalSegment;
        }
        return parent + c + legalSegment;
    }

    private static String getLegalSegment(String segment) {
        int st = -1;
        int end = -1;
        char[] charArray = segment.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != SEP) {
                if (st == -1) {
                    st = i;
                }
                end = i;
            }
        }
        if (st >= 0 && end >= st) {
            return segment.substring(st, end + 1);
        }
        throw new IllegalArgumentException("segment of <" + segment + "> is illegal");
    }

    public static String getRootPath() {
        return getAbsolutePath(Environment.getRootDirectory());
    }

    public static String getDataPath() {
        return getAbsolutePath(Environment.getDataDirectory());
    }

    public static String getDownloadCachePath() {
        return getAbsolutePath(Environment.getDownloadCacheDirectory());
    }

    public static String getInternalAppDataPath() {
        if (Build.VERSION.SDK_INT < 24) {
            return Utils.getApp().getApplicationInfo().dataDir;
        }
        return getAbsolutePath(Utils.getApp().getDataDir());
    }

    public static String getInternalAppCodeCacheDir() {
        if (Build.VERSION.SDK_INT < 21) {
            return Utils.getApp().getApplicationInfo().dataDir + "/code_cache";
        }
        return getAbsolutePath(Utils.getApp().getCodeCacheDir());
    }

    public static String getInternalAppCachePath() {
        return getAbsolutePath(Utils.getApp().getCacheDir());
    }

    public static String getInternalAppDbsPath() {
        return Utils.getApp().getApplicationInfo().dataDir + "/databases";
    }

    public static String getInternalAppDbPath(String name) {
        return getAbsolutePath(Utils.getApp().getDatabasePath(name));
    }

    public static String getInternalAppFilesPath() {
        return getAbsolutePath(Utils.getApp().getFilesDir());
    }

    public static String getInternalAppSpPath() {
        return Utils.getApp().getApplicationInfo().dataDir + "/shared_prefs";
    }

    public static String getInternalAppNoBackupFilesPath() {
        if (Build.VERSION.SDK_INT < 21) {
            return Utils.getApp().getApplicationInfo().dataDir + "/no_backup";
        }
        return getAbsolutePath(Utils.getApp().getNoBackupFilesDir());
    }

    public static String getExternalStoragePath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Environment.getExternalStorageDirectory());
    }

    public static String getExternalMusicPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));
    }

    public static String getExternalPodcastsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS));
    }

    public static String getExternalRingtonesPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES));
    }

    public static String getExternalAlarmsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS));
    }

    public static String getExternalNotificationsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS));
    }

    public static String getExternalPicturesPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
    }

    public static String getExternalMoviesPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES));
    }

    public static String getExternalDownloadsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
    }

    public static String getExternalDcimPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
    }

    public static String getExternalDocumentsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        if (Build.VERSION.SDK_INT < 19) {
            return getAbsolutePath(Environment.getExternalStorageDirectory()) + "/Documents";
        }
        return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS));
    }

    public static String getExternalAppDataPath() {
        File externalCacheDir;
        if (UtilsBridge.isSDCardEnableByEnvironment() && (externalCacheDir = Utils.getApp().getExternalCacheDir()) != null) {
            return getAbsolutePath(externalCacheDir.getParentFile());
        }
        return "";
    }

    public static String getExternalAppCachePath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Utils.getApp().getExternalCacheDir());
    }

    public static String getExternalAppFilesPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(null));
    }

    public static String getExternalAppMusicPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_MUSIC));
    }

    public static String getExternalAppPodcastsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_PODCASTS));
    }

    public static String getExternalAppRingtonesPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_RINGTONES));
    }

    public static String getExternalAppAlarmsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_ALARMS));
    }

    public static String getExternalAppNotificationsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_NOTIFICATIONS));
    }

    public static String getExternalAppPicturesPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_PICTURES));
    }

    public static String getExternalAppMoviesPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_MOVIES));
    }

    public static String getExternalAppDownloadPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
    }

    public static String getExternalAppDcimPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_DCIM));
    }

    public static String getExternalAppDocumentsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        if (Build.VERSION.SDK_INT < 19) {
            return getAbsolutePath(Utils.getApp().getExternalFilesDir(null)) + "/Documents";
        }
        return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS));
    }

    public static String getExternalAppObbPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        return getAbsolutePath(Utils.getApp().getObbDir());
    }

    public static String getRootPathExternalFirst() {
        String rootPath = getExternalStoragePath();
        if (TextUtils.isEmpty(rootPath)) {
            return getRootPath();
        }
        return rootPath;
    }

    public static String getAppDataPathExternalFirst() {
        String appDataPath = getExternalAppDataPath();
        if (TextUtils.isEmpty(appDataPath)) {
            return getInternalAppDataPath();
        }
        return appDataPath;
    }

    public static String getFilesPathExternalFirst() {
        String filePath = getExternalAppFilesPath();
        if (TextUtils.isEmpty(filePath)) {
            return getInternalAppFilesPath();
        }
        return filePath;
    }

    public static String getCachePathExternalFirst() {
        String appPath = getExternalAppCachePath();
        if (TextUtils.isEmpty(appPath)) {
            return getInternalAppCachePath();
        }
        return appPath;
    }

    private static String getAbsolutePath(File file) {
        if (file == null) {
            return "";
        }
        return file.getAbsolutePath();
    }
}

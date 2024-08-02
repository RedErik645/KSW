package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.view.View;
import com.blankj.utilcode.util.ShellUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class UtilsBridge {
    UtilsBridge() {
    }

    static void init(Application app) {
        UtilsActivityLifecycleImpl.INSTANCE.init(app);
    }

    static void unInit(Application app) {
        UtilsActivityLifecycleImpl.INSTANCE.unInit(app);
    }

    static void preLoad() {
        preLoad(AdaptScreenUtils.getPreLoadRunnable());
    }

    static Activity getTopActivity() {
        return UtilsActivityLifecycleImpl.INSTANCE.getTopActivity();
    }

    static void addOnAppStatusChangedListener(Utils.OnAppStatusChangedListener listener) {
        UtilsActivityLifecycleImpl.INSTANCE.addOnAppStatusChangedListener(listener);
    }

    static void removeOnAppStatusChangedListener(Utils.OnAppStatusChangedListener listener) {
        UtilsActivityLifecycleImpl.INSTANCE.removeOnAppStatusChangedListener(listener);
    }

    static void addActivityLifecycleCallbacks(Activity activity, Utils.ActivityLifecycleCallbacks callbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.addActivityLifecycleCallbacks(activity, callbacks);
    }

    static void removeActivityLifecycleCallbacks(Activity activity) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(activity);
    }

    static void removeActivityLifecycleCallbacks(Activity activity, Utils.ActivityLifecycleCallbacks callbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(activity, callbacks);
    }

    static List<Activity> getActivityList() {
        return UtilsActivityLifecycleImpl.INSTANCE.getActivityList();
    }

    static Application getApplicationByReflect() {
        return UtilsActivityLifecycleImpl.INSTANCE.getApplicationByReflect();
    }

    static boolean isActivityAlive(Activity activity) {
        return ActivityUtils.isActivityAlive(activity);
    }

    static String getLauncherActivity() {
        return ActivityUtils.getLauncherActivity();
    }

    static String getLauncherActivity(String pkg) {
        return ActivityUtils.getLauncherActivity(pkg);
    }

    static Activity getActivityByContext(Context context) {
        return ActivityUtils.getActivityByContext(context);
    }

    static void startHomeActivity() {
        ActivityUtils.startHomeActivity();
    }

    static void finishAllActivities() {
        ActivityUtils.finishAllActivities();
    }

    static Context getTopActivityOrApp() {
        if (!AppUtils.isAppForeground()) {
            return Utils.getApp();
        }
        Activity topActivity = getTopActivity();
        return topActivity == null ? Utils.getApp() : topActivity;
    }

    static boolean isAppRunning(String pkgName) {
        if (pkgName != null) {
            return AppUtils.isAppRunning(pkgName);
        }
        throw new NullPointerException("Argument 'pkgName' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    static boolean isAppInstalled(String pkgName) {
        return AppUtils.isAppInstalled(pkgName);
    }

    static String getAppVersionName() {
        return AppUtils.getAppVersionName();
    }

    static int getAppVersionCode() {
        return AppUtils.getAppVersionCode();
    }

    static boolean isAppDebug() {
        return AppUtils.isAppDebug();
    }

    static int getStatusBarHeight() {
        return BarUtils.getStatusBarHeight();
    }

    static int getNavBarHeight() {
        return BarUtils.getNavBarHeight();
    }

    static String bytes2HexString(byte[] bytes) {
        return ConvertUtils.bytes2HexString(bytes);
    }

    static byte[] hexString2Bytes(String hexString) {
        return ConvertUtils.hexString2Bytes(hexString);
    }

    static byte[] string2Bytes(String string) {
        return ConvertUtils.string2Bytes(string);
    }

    static String bytes2String(byte[] bytes) {
        return ConvertUtils.bytes2String(bytes);
    }

    static byte[] jsonObject2Bytes(JSONObject jsonObject) {
        return ConvertUtils.jsonObject2Bytes(jsonObject);
    }

    static JSONObject bytes2JSONObject(byte[] bytes) {
        return ConvertUtils.bytes2JSONObject(bytes);
    }

    static byte[] jsonArray2Bytes(JSONArray jsonArray) {
        return ConvertUtils.jsonArray2Bytes(jsonArray);
    }

    static JSONArray bytes2JSONArray(byte[] bytes) {
        return ConvertUtils.bytes2JSONArray(bytes);
    }

    static byte[] parcelable2Bytes(Parcelable parcelable) {
        return ConvertUtils.parcelable2Bytes(parcelable);
    }

    static <T> T bytes2Parcelable(byte[] bytes, Parcelable.Creator<T> creator) {
        return (T) ConvertUtils.bytes2Parcelable(bytes, creator);
    }

    static byte[] serializable2Bytes(Serializable serializable) {
        return ConvertUtils.serializable2Bytes(serializable);
    }

    static Object bytes2Object(byte[] bytes) {
        return ConvertUtils.bytes2Object(bytes);
    }

    static String byte2FitMemorySize(long byteSize) {
        return ConvertUtils.byte2FitMemorySize(byteSize);
    }

    static byte[] inputStream2Bytes(InputStream is) {
        return ConvertUtils.inputStream2Bytes(is);
    }

    static ByteArrayOutputStream input2OutputStream(InputStream is) {
        return ConvertUtils.input2OutputStream(is);
    }

    static List<String> inputStream2Lines(InputStream is, String charsetName) {
        return ConvertUtils.inputStream2Lines(is, charsetName);
    }

    static byte[] base64Encode(byte[] input) {
        return EncodeUtils.base64Encode(input);
    }

    static byte[] base64Decode(byte[] input) {
        return EncodeUtils.base64Decode(input);
    }

    static byte[] hashTemplate(byte[] data, String algorithm) {
        return EncryptUtils.hashTemplate(data, algorithm);
    }

    static boolean writeFileFromBytes(File file, byte[] bytes) {
        return FileIOUtils.writeFileFromBytesByChannel(file, bytes, true);
    }

    static byte[] readFile2Bytes(File file) {
        return FileIOUtils.readFile2BytesByChannel(file);
    }

    static boolean writeFileFromString(String filePath, String content, boolean append) {
        return FileIOUtils.writeFileFromString(filePath, content, append);
    }

    static boolean writeFileFromIS(String filePath, InputStream is) {
        return FileIOUtils.writeFileFromIS(filePath, is);
    }

    static boolean isFileExists(File file) {
        return FileUtils.isFileExists(file);
    }

    static File getFileByPath(String filePath) {
        return FileUtils.getFileByPath(filePath);
    }

    static boolean deleteAllInDir(File dir) {
        return FileUtils.deleteAllInDir(dir);
    }

    static boolean createOrExistsFile(File file) {
        return FileUtils.createOrExistsFile(file);
    }

    static boolean createOrExistsDir(File file) {
        return FileUtils.createOrExistsDir(file);
    }

    static boolean createFileByDeleteOldFile(File file) {
        return FileUtils.createFileByDeleteOldFile(file);
    }

    static long getFsTotalSize(String path) {
        return FileUtils.getFsTotalSize(path);
    }

    static long getFsAvailableSize(String path) {
        return FileUtils.getFsAvailableSize(path);
    }

    static void notifySystemToScan(File file) {
        FileUtils.notifySystemToScan(file);
    }

    static String toJson(Object object) {
        return GsonUtils.toJson(object);
    }

    static <T> T fromJson(String json, Type type) {
        return (T) GsonUtils.fromJson(json, type);
    }

    static Gson getGson4LogUtils() {
        return GsonUtils.getGson4LogUtils();
    }

    static byte[] bitmap2Bytes(Bitmap bitmap) {
        return ImageUtils.bitmap2Bytes(bitmap);
    }

    static byte[] bitmap2Bytes(Bitmap bitmap, Bitmap.CompressFormat format, int quality) {
        return ImageUtils.bitmap2Bytes(bitmap, format, quality);
    }

    static Bitmap bytes2Bitmap(byte[] bytes) {
        return ImageUtils.bytes2Bitmap(bytes);
    }

    static byte[] drawable2Bytes(Drawable drawable) {
        return ImageUtils.drawable2Bytes(drawable);
    }

    static byte[] drawable2Bytes(Drawable drawable, Bitmap.CompressFormat format, int quality) {
        return ImageUtils.drawable2Bytes(drawable, format, quality);
    }

    static Drawable bytes2Drawable(byte[] bytes) {
        return ImageUtils.bytes2Drawable(bytes);
    }

    static Bitmap view2Bitmap(View view) {
        return ImageUtils.view2Bitmap(view);
    }

    static Bitmap drawable2Bitmap(Drawable drawable) {
        return ImageUtils.drawable2Bitmap(drawable);
    }

    static Drawable bitmap2Drawable(Bitmap bitmap) {
        return ImageUtils.bitmap2Drawable(bitmap);
    }

    static boolean isIntentAvailable(Intent intent) {
        return IntentUtils.isIntentAvailable(intent);
    }

    static Intent getLaunchAppIntent(String pkgName) {
        return IntentUtils.getLaunchAppIntent(pkgName);
    }

    static Intent getInstallAppIntent(File file) {
        return IntentUtils.getInstallAppIntent(file);
    }

    static Intent getInstallAppIntent(Uri uri) {
        return IntentUtils.getInstallAppIntent(uri);
    }

    static Intent getUninstallAppIntent(String pkgName) {
        return IntentUtils.getUninstallAppIntent(pkgName);
    }

    static Intent getDialIntent(String phoneNumber) {
        return IntentUtils.getDialIntent(phoneNumber);
    }

    static Intent getCallIntent(String phoneNumber) {
        return IntentUtils.getCallIntent(phoneNumber);
    }

    static Intent getSendSmsIntent(String phoneNumber, String content) {
        return IntentUtils.getSendSmsIntent(phoneNumber, content);
    }

    static Intent getLaunchAppDetailsSettingsIntent(String pkgName, boolean isNewTask) {
        return IntentUtils.getLaunchAppDetailsSettingsIntent(pkgName, isNewTask);
    }

    static String formatJson(String json) {
        return JsonUtils.formatJson(json);
    }

    static void fixSoftInputLeaks(Activity activity) {
        KeyboardUtils.fixSoftInputLeaks(activity);
    }

    static void applyLanguage(Activity activity) {
        LanguageUtils.applyLanguage(activity);
    }

    static boolean isGranted(String... permissions) {
        return PermissionUtils.isGranted(permissions);
    }

    static boolean isGrantedDrawOverlays() {
        return PermissionUtils.isGrantedDrawOverlays();
    }

    static boolean isMainProcess() {
        return ProcessUtils.isMainProcess();
    }

    static String getForegroundProcessName() {
        return ProcessUtils.getForegroundProcessName();
    }

    static String getCurrentProcessName() {
        return ProcessUtils.getCurrentProcessName();
    }

    static String getSDCardPathByEnvironment() {
        return SDCardUtils.getSDCardPathByEnvironment();
    }

    static boolean isSDCardEnableByEnvironment() {
        return SDCardUtils.isSDCardEnableByEnvironment();
    }

    static boolean isServiceRunning(String className) {
        return ServiceUtils.isServiceRunning(className);
    }

    static ShellUtils.CommandResult execCmd(String command, boolean isRooted) {
        return ShellUtils.execCmd(command, isRooted);
    }

    static int dp2px(float dpValue) {
        return SizeUtils.dp2px(dpValue);
    }

    static int px2dp(float pxValue) {
        return SizeUtils.px2dp(pxValue);
    }

    static int sp2px(float spValue) {
        return SizeUtils.sp2px(spValue);
    }

    static int px2sp(float pxValue) {
        return SizeUtils.px2sp(pxValue);
    }

    static SPUtils getSpUtils4Utils() {
        return SPUtils.getInstance("Utils");
    }

    static boolean isSpace(String s) {
        return StringUtils.isSpace(s);
    }

    static boolean equals(CharSequence s1, CharSequence s2) {
        return StringUtils.equals(s1, s2);
    }

    static <T> Utils.Task<T> doAsync(Utils.Task<T> task) {
        ThreadUtils.getCachedPool().execute(task);
        return task;
    }

    static void runOnUiThread(Runnable runnable) {
        ThreadUtils.runOnUiThread(runnable);
    }

    static void runOnUiThreadDelayed(Runnable runnable, long delayMillis) {
        ThreadUtils.runOnUiThreadDelayed(runnable, delayMillis);
    }

    static String getFullStackTrace(Throwable throwable) {
        return ThrowableUtils.getFullStackTrace(throwable);
    }

    static String millis2FitTimeSpan(long millis, int precision) {
        return TimeUtils.millis2FitTimeSpan(millis, precision);
    }

    static void toastShowShort(CharSequence text) {
        ToastUtils.showShort(text);
    }

    static void toastCancel() {
        ToastUtils.cancel();
    }

    private static void preLoad(Runnable... runs) {
        for (Runnable r : runs) {
            ThreadUtils.getCachedPool().execute(r);
        }
    }

    static Uri file2Uri(File file) {
        return UriUtils.file2Uri(file);
    }

    static File uri2File(Uri uri) {
        return UriUtils.uri2File(uri);
    }
}

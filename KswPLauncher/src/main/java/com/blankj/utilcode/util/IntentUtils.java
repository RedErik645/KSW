package com.blankj.utilcode.util;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class IntentUtils {
    private IntentUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isIntentAvailable(Intent intent) {
        return Utils.getApp().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static Intent getInstallAppIntent(String filePath) {
        return getInstallAppIntent(UtilsBridge.getFileByPath(filePath));
    }

    public static Intent getInstallAppIntent(File file) {
        Uri uri;
        if (!UtilsBridge.isFileExists(file)) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 24) {
            uri = Uri.fromFile(file);
        } else {
            uri = FileProvider.getUriForFile(Utils.getApp(), Utils.getApp().getPackageName() + ".utilcode.provider", file);
        }
        return getInstallAppIntent(uri);
    }

    public static Intent getInstallAppIntent(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.setFlags(1);
        }
        return intent.addFlags(268435456);
    }

    public static Intent getUninstallAppIntent(String pkgName) {
        Intent intent = new Intent("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + pkgName));
        return intent.addFlags(268435456);
    }

    public static Intent getLaunchAppIntent(String pkgName) {
        String launcherActivity = UtilsBridge.getLauncherActivity(pkgName);
        if (UtilsBridge.isSpace(launcherActivity)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setClassName(pkgName, launcherActivity);
        return intent.addFlags(268435456);
    }

    public static Intent getLaunchAppDetailsSettingsIntent(String pkgName) {
        return getLaunchAppDetailsSettingsIntent(pkgName, false);
    }

    public static Intent getLaunchAppDetailsSettingsIntent(String pkgName, boolean isNewTask) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + pkgName));
        return getIntent(intent, isNewTask);
    }

    public static Intent getShareTextIntent(String content) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", content);
        return getIntent(intent, true);
    }

    public static Intent getShareImageIntent(String content, String imagePath) {
        if (UtilsBridge.isSpace(imagePath)) {
            return null;
        }
        return getShareImageIntent(content, new File(imagePath));
    }

    public static Intent getShareImageIntent(String content, File image) {
        if (image == null || !image.isFile()) {
            return null;
        }
        return getShareImageIntent(content, UtilsBridge.file2Uri(image));
    }

    public static Intent getShareImageIntent(String content, Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", content);
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setType("image/*");
        return getIntent(intent, true);
    }

    public static Intent getShareImageIntent(String content, LinkedList<String> imagePaths) {
        if (imagePaths == null || imagePaths.isEmpty()) {
            return null;
        }
        List<File> files = new ArrayList<>();
        Iterator<String> it = imagePaths.iterator();
        while (it.hasNext()) {
            files.add(new File(it.next()));
        }
        return getShareImageIntent(content, files);
    }

    public static Intent getShareImageIntent(String content, List<File> images) {
        if (images == null || images.isEmpty()) {
            return null;
        }
        ArrayList<Uri> uris = new ArrayList<>();
        for (File image : images) {
            if (image.isFile()) {
                uris.add(UtilsBridge.file2Uri(image));
            }
        }
        return getShareImageIntent(content, uris);
    }

    public static Intent getShareImageIntent(String content, ArrayList<Uri> uris) {
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.putExtra("android.intent.extra.TEXT", content);
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", uris);
        intent.setType("image/*");
        return getIntent(intent, true);
    }

    public static Intent getComponentIntent(String pkgName, String className) {
        return getComponentIntent(pkgName, className, null, false);
    }

    public static Intent getComponentIntent(String pkgName, String className, boolean isNewTask) {
        return getComponentIntent(pkgName, className, null, isNewTask);
    }

    public static Intent getComponentIntent(String pkgName, String className, Bundle bundle) {
        return getComponentIntent(pkgName, className, bundle, false);
    }

    public static Intent getComponentIntent(String pkgName, String className, Bundle bundle, boolean isNewTask) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(pkgName, className));
        return getIntent(intent, isNewTask);
    }

    public static Intent getShutdownIntent() {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 26) {
            intent = new Intent("android.intent.action.ACTION_SHUTDOWN");
        } else {
            intent = new Intent("com.android.internal.intent.action.REQUEST_SHUTDOWN");
        }
        intent.putExtra("android.intent.extra.KEY_CONFIRM", false);
        return intent.addFlags(268435456);
    }

    public static Intent getDialIntent(String phoneNumber) {
        return getIntent(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + phoneNumber)), true);
    }

    public static Intent getCallIntent(String phoneNumber) {
        return getIntent(new Intent("android.intent.action.CALL", Uri.parse("tel:" + phoneNumber)), true);
    }

    public static Intent getSendSmsIntent(String phoneNumber, String content) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + phoneNumber));
        intent.putExtra("sms_body", content);
        return getIntent(intent, true);
    }

    public static Intent getCaptureIntent(Uri outUri) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", outUri);
        intent.addFlags(1);
        return getIntent(intent, true);
    }

    private static Intent getIntent(Intent intent, boolean isNewTask) {
        return isNewTask ? intent.addFlags(268435456) : intent;
    }
}

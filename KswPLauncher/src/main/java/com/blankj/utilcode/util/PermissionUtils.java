package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.MotionEvent;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.UtilsTransActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class PermissionUtils {
    private static PermissionUtils sInstance;
    private static SimpleCallback sSimpleCallback4DrawOverlays;
    private static SimpleCallback sSimpleCallback4WriteSettings;
    private FullCallback mFullCallback;
    private OnRationaleListener mOnRationaleListener;
    private Set<String> mPermissions;
    private List<String> mPermissionsDenied;
    private List<String> mPermissionsDeniedForever;
    private List<String> mPermissionsGranted;
    private String[] mPermissionsParam;
    private List<String> mPermissionsRequest;
    private SimpleCallback mSimpleCallback;
    private SingleCallback mSingleCallback;
    private ThemeCallback mThemeCallback;

    public interface FullCallback {
        void onDenied(List<String> list, List<String> list2);

        void onGranted(List<String> list);
    }

    public interface OnRationaleListener {

        public interface ShouldRequest {
            void again(boolean z);
        }

        void rationale(UtilsTransActivity utilsTransActivity, ShouldRequest shouldRequest);
    }

    public interface SimpleCallback {
        void onDenied();

        void onGranted();
    }

    public interface SingleCallback {
        void callback(boolean z, List<String> list, List<String> list2, List<String> list3);
    }

    public interface ThemeCallback {
        void onActivityCreate(Activity activity);
    }

    public static List<String> getPermissions() {
        return getPermissions(Utils.getApp().getPackageName());
    }

    public static List<String> getPermissions(String packageName) {
        try {
            String[] permissions = Utils.getApp().getPackageManager().getPackageInfo(packageName, 4096).requestedPermissions;
            if (permissions == null) {
                return Collections.emptyList();
            }
            return Arrays.asList(permissions);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static boolean isGranted(String... permissions) {
        for (String permission : permissions) {
            if (!isGranted(permission)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isGranted(String permission) {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(Utils.getApp(), permission) == 0;
    }

    public static boolean isGrantedWriteSettings() {
        return Settings.System.canWrite(Utils.getApp());
    }

    public static void requestWriteSettings(SimpleCallback callback) {
        if (!isGrantedWriteSettings()) {
            sSimpleCallback4WriteSettings = callback;
            PermissionActivityImpl.start(2);
        } else if (callback != null) {
            callback.onGranted();
        }
    }

    /* access modifiers changed from: private */
    public static void startWriteSettingsActivity(Activity activity, int requestCode) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + Utils.getApp().getPackageName()));
        if (!UtilsBridge.isIntentAvailable(intent)) {
            launchAppDetailsSettings();
        } else {
            activity.startActivityForResult(intent, requestCode);
        }
    }

    public static boolean isGrantedDrawOverlays() {
        return Settings.canDrawOverlays(Utils.getApp());
    }

    public static void requestDrawOverlays(SimpleCallback callback) {
        if (!isGrantedDrawOverlays()) {
            sSimpleCallback4DrawOverlays = callback;
            PermissionActivityImpl.start(3);
        } else if (callback != null) {
            callback.onGranted();
        }
    }

    /* access modifiers changed from: private */
    public static void startOverlayPermissionActivity(Activity activity, int requestCode) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + Utils.getApp().getPackageName()));
        if (!UtilsBridge.isIntentAvailable(intent)) {
            launchAppDetailsSettings();
        } else {
            activity.startActivityForResult(intent, requestCode);
        }
    }

    public static void launchAppDetailsSettings() {
        Intent intent = UtilsBridge.getLaunchAppDetailsSettingsIntent(Utils.getApp().getPackageName(), true);
        if (UtilsBridge.isIntentAvailable(intent)) {
            Utils.getApp().startActivity(intent);
        }
    }

    public static PermissionUtils permission(String... permissions) {
        return new PermissionUtils(permissions);
    }

    private PermissionUtils(String... permissions) {
        this.mPermissionsParam = permissions;
        sInstance = this;
    }

    public PermissionUtils rationale(OnRationaleListener listener) {
        this.mOnRationaleListener = listener;
        return this;
    }

    public PermissionUtils callback(SingleCallback callback) {
        this.mSingleCallback = callback;
        return this;
    }

    public PermissionUtils callback(SimpleCallback callback) {
        this.mSimpleCallback = callback;
        return this;
    }

    public PermissionUtils callback(FullCallback callback) {
        this.mFullCallback = callback;
        return this;
    }

    public PermissionUtils theme(ThemeCallback callback) {
        this.mThemeCallback = callback;
        return this;
    }

    public void request() {
        String[] strArr = this.mPermissionsParam;
        if (strArr == null || strArr.length <= 0) {
            Log.w("PermissionUtils", "No permissions to request.");
            return;
        }
        this.mPermissions = new LinkedHashSet();
        this.mPermissionsRequest = new ArrayList();
        this.mPermissionsGranted = new ArrayList();
        this.mPermissionsDenied = new ArrayList();
        this.mPermissionsDeniedForever = new ArrayList();
        List<String> appPermissions = getPermissions();
        String[] strArr2 = this.mPermissionsParam;
        for (String param : strArr2) {
            boolean isIncludeInManifest = false;
            String[] permissions = PermissionConstants.getPermissions(param);
            for (String permission : permissions) {
                if (appPermissions.contains(permission)) {
                    this.mPermissions.add(permission);
                    isIncludeInManifest = true;
                }
            }
            if (!isIncludeInManifest) {
                this.mPermissionsDenied.add(param);
                Log.e("PermissionUtils", "U should add the permission of " + param + " in manifest.");
            }
        }
        if (Build.VERSION.SDK_INT < 23) {
            this.mPermissionsGranted.addAll(this.mPermissions);
            requestCallback();
            return;
        }
        for (String permission2 : this.mPermissions) {
            if (isGranted(permission2)) {
                this.mPermissionsGranted.add(permission2);
            } else {
                this.mPermissionsRequest.add(permission2);
            }
        }
        if (this.mPermissionsRequest.isEmpty()) {
            requestCallback();
        } else {
            startPermissionActivity();
        }
    }

    private void startPermissionActivity() {
        PermissionActivityImpl.start(1);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean shouldRationale(UtilsTransActivity activity, Runnable againRunnable) {
        boolean isRationale = false;
        if (this.mOnRationaleListener != null) {
            Iterator<String> it = this.mPermissionsRequest.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (activity.shouldShowRequestPermissionRationale(it.next())) {
                        rationalInner(activity, againRunnable);
                        isRationale = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.mOnRationaleListener = null;
        }
        return isRationale;
    }

    private void rationalInner(final UtilsTransActivity activity, final Runnable againRunnable) {
        getPermissionsStatus(activity);
        this.mOnRationaleListener.rationale(activity, new OnRationaleListener.ShouldRequest() {
            /* class com.blankj.utilcode.util.PermissionUtils.AnonymousClass1 */

            @Override // com.blankj.utilcode.util.PermissionUtils.OnRationaleListener.ShouldRequest
            public void again(boolean again) {
                if (again) {
                    PermissionUtils.this.mPermissionsDenied = new ArrayList();
                    PermissionUtils.this.mPermissionsDeniedForever = new ArrayList();
                    againRunnable.run();
                    return;
                }
                activity.finish();
                PermissionUtils.this.requestCallback();
            }
        });
    }

    private void getPermissionsStatus(Activity activity) {
        for (String permission : this.mPermissionsRequest) {
            if (isGranted(permission)) {
                this.mPermissionsGranted.add(permission);
            } else {
                this.mPermissionsDenied.add(permission);
                if (!activity.shouldShowRequestPermissionRationale(permission)) {
                    this.mPermissionsDeniedForever.add(permission);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void requestCallback() {
        SingleCallback singleCallback = this.mSingleCallback;
        if (singleCallback != null) {
            singleCallback.callback(this.mPermissionsDenied.isEmpty(), this.mPermissionsGranted, this.mPermissionsDeniedForever, this.mPermissionsDenied);
            this.mSingleCallback = null;
        }
        if (this.mSimpleCallback != null) {
            if (this.mPermissionsDenied.isEmpty()) {
                this.mSimpleCallback.onGranted();
            } else {
                this.mSimpleCallback.onDenied();
            }
            this.mSimpleCallback = null;
        }
        if (this.mFullCallback != null) {
            if (this.mPermissionsRequest.size() == 0 || this.mPermissionsGranted.size() > 0) {
                this.mFullCallback.onGranted(this.mPermissionsGranted);
            }
            if (!this.mPermissionsDenied.isEmpty()) {
                this.mFullCallback.onDenied(this.mPermissionsDeniedForever, this.mPermissionsDenied);
            }
            this.mFullCallback = null;
        }
        this.mOnRationaleListener = null;
        this.mThemeCallback = null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onRequestPermissionsResult(Activity activity) {
        getPermissionsStatus(activity);
        requestCallback();
    }

    /* access modifiers changed from: package-private */
    public static final class PermissionActivityImpl extends UtilsTransActivity.TransActivityDelegate {
        private static PermissionActivityImpl INSTANCE = new PermissionActivityImpl();
        private static final String TYPE = "TYPE";
        private static final int TYPE_DRAW_OVERLAYS = 3;
        private static final int TYPE_RUNTIME = 1;
        private static final int TYPE_WRITE_SETTINGS = 2;
        private static int currentRequestCode = -1;

        PermissionActivityImpl() {
        }

        public static void start(final int type) {
            UtilsTransActivity.start(new Utils.Consumer<Intent>() {
                /* class com.blankj.utilcode.util.PermissionUtils.PermissionActivityImpl.AnonymousClass1 */

                public void accept(Intent data) {
                    data.putExtra("TYPE", type);
                }
            }, INSTANCE);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onCreated(final UtilsTransActivity activity, Bundle savedInstanceState) {
            activity.getWindow().addFlags(262160);
            int type = activity.getIntent().getIntExtra("TYPE", -1);
            if (type == 1) {
                if (PermissionUtils.sInstance == null) {
                    Log.e("PermissionUtils", "request permissions failed");
                    activity.finish();
                    return;
                }
                if (PermissionUtils.sInstance.mThemeCallback != null) {
                    PermissionUtils.sInstance.mThemeCallback.onActivityCreate(activity);
                }
                if (!PermissionUtils.sInstance.shouldRationale(activity, new Runnable() {
                    /* class com.blankj.utilcode.util.PermissionUtils.PermissionActivityImpl.AnonymousClass2 */

                    public void run() {
                        PermissionActivityImpl.this.requestPermissions(activity);
                    }
                })) {
                    requestPermissions(activity);
                }
            } else if (type == 2) {
                currentRequestCode = 2;
                PermissionUtils.startWriteSettingsActivity(activity, 2);
            } else if (type == 3) {
                currentRequestCode = 3;
                PermissionUtils.startOverlayPermissionActivity(activity, 3);
            } else {
                activity.finish();
                Log.e("PermissionUtils", "type is wrong.");
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void requestPermissions(Activity activity) {
            if (PermissionUtils.sInstance.mPermissionsRequest != null) {
                int size = PermissionUtils.sInstance.mPermissionsRequest.size();
                if (size <= 0) {
                    activity.finish();
                } else {
                    activity.requestPermissions((String[]) PermissionUtils.sInstance.mPermissionsRequest.toArray(new String[size]), 1);
                }
            }
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onRequestPermissionsResult(UtilsTransActivity activity, int requestCode, String[] permissions, int[] grantResults) {
            activity.finish();
            if (PermissionUtils.sInstance != null && PermissionUtils.sInstance.mPermissionsRequest != null) {
                PermissionUtils.sInstance.onRequestPermissionsResult(activity);
            }
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public boolean dispatchTouchEvent(UtilsTransActivity activity, MotionEvent ev) {
            activity.finish();
            return true;
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onDestroy(UtilsTransActivity activity) {
            int i = currentRequestCode;
            if (i != -1) {
                checkRequestCallback(i);
                currentRequestCode = -1;
            }
            super.onDestroy(activity);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onActivityResult(UtilsTransActivity activity, int requestCode, int resultCode, Intent data) {
            activity.finish();
        }

        private void checkRequestCallback(int requestCode) {
            if (requestCode == 2) {
                if (PermissionUtils.sSimpleCallback4WriteSettings != null) {
                    if (PermissionUtils.isGrantedWriteSettings()) {
                        PermissionUtils.sSimpleCallback4WriteSettings.onGranted();
                    } else {
                        PermissionUtils.sSimpleCallback4WriteSettings.onDenied();
                    }
                    SimpleCallback unused = PermissionUtils.sSimpleCallback4WriteSettings = null;
                }
            } else if (requestCode == 3 && PermissionUtils.sSimpleCallback4DrawOverlays != null) {
                if (PermissionUtils.isGrantedDrawOverlays()) {
                    PermissionUtils.sSimpleCallback4DrawOverlays.onGranted();
                } else {
                    PermissionUtils.sSimpleCallback4DrawOverlays.onDenied();
                }
                SimpleCallback unused2 = PermissionUtils.sSimpleCallback4DrawOverlays = null;
            }
        }
    }
}

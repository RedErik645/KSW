package com.blankj.utilcode.util;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import com.blankj.utilcode.util.Utils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* access modifiers changed from: package-private */
public final class UtilsActivityLifecycleImpl implements Application.ActivityLifecycleCallbacks {
    static final UtilsActivityLifecycleImpl INSTANCE = new UtilsActivityLifecycleImpl();
    private final Map<Activity, List<Utils.ActivityLifecycleCallbacks>> mActivityLifecycleCallbacksMap = new ConcurrentHashMap();
    private final LinkedList<Activity> mActivityList = new LinkedList<>();
    private int mConfigCount = 0;
    private int mForegroundCount = 0;
    private boolean mIsBackground = false;
    private final List<Utils.OnAppStatusChangedListener> mStatusListeners = new ArrayList();

    UtilsActivityLifecycleImpl() {
    }

    /* access modifiers changed from: package-private */
    public void init(Application app) {
        app.registerActivityLifecycleCallbacks(this);
    }

    /* access modifiers changed from: package-private */
    public void unInit(Application app) {
        this.mActivityList.clear();
        app.unregisterActivityLifecycleCallbacks(this);
    }

    /* access modifiers changed from: package-private */
    public Activity getTopActivity() {
        for (Activity activity : getActivityList()) {
            if (UtilsBridge.isActivityAlive(activity)) {
                return activity;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public List<Activity> getActivityList() {
        if (!this.mActivityList.isEmpty()) {
            return this.mActivityList;
        }
        this.mActivityList.addAll(getActivitiesByReflect());
        return this.mActivityList;
    }

    /* access modifiers changed from: package-private */
    public void addOnAppStatusChangedListener(Utils.OnAppStatusChangedListener listener) {
        this.mStatusListeners.add(listener);
    }

    /* access modifiers changed from: package-private */
    public void removeOnAppStatusChangedListener(Utils.OnAppStatusChangedListener listener) {
        this.mStatusListeners.remove(listener);
    }

    /* access modifiers changed from: package-private */
    public void addActivityLifecycleCallbacks(final Activity activity, final Utils.ActivityLifecycleCallbacks listener) {
        if (activity != null && listener != null) {
            UtilsBridge.runOnUiThread(new Runnable() {
                /* class com.blankj.utilcode.util.UtilsActivityLifecycleImpl.AnonymousClass1 */

                public void run() {
                    UtilsActivityLifecycleImpl.this.addActivityLifecycleCallbacksInner(activity, listener);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public Application getApplicationByReflect() {
        try {
            Class activityThreadClass = Class.forName("android.app.ActivityThread");
            Object app = activityThreadClass.getMethod("getApplication", new Class[0]).invoke(getActivityThread(), new Object[0]);
            if (app == null) {
                return null;
            }
            return (Application) app;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addActivityLifecycleCallbacksInner(Activity activity, Utils.ActivityLifecycleCallbacks lifecycleCallbacks) {
        List<Utils.ActivityLifecycleCallbacks> callbacks = this.mActivityLifecycleCallbacksMap.get(activity);
        if (callbacks == null) {
            callbacks = new ArrayList();
            this.mActivityLifecycleCallbacksMap.put(activity, callbacks);
        } else if (callbacks.contains(lifecycleCallbacks)) {
            return;
        }
        callbacks.add(lifecycleCallbacks);
    }

    /* access modifiers changed from: package-private */
    public void removeActivityLifecycleCallbacks(final Activity activity) {
        if (activity != null) {
            UtilsBridge.runOnUiThread(new Runnable() {
                /* class com.blankj.utilcode.util.UtilsActivityLifecycleImpl.AnonymousClass2 */

                public void run() {
                    UtilsActivityLifecycleImpl.this.mActivityLifecycleCallbacksMap.remove(activity);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void removeActivityLifecycleCallbacks(final Activity activity, final Utils.ActivityLifecycleCallbacks callbacks) {
        if (activity != null && callbacks != null) {
            UtilsBridge.runOnUiThread(new Runnable() {
                /* class com.blankj.utilcode.util.UtilsActivityLifecycleImpl.AnonymousClass3 */

                public void run() {
                    UtilsActivityLifecycleImpl.this.removeActivityLifecycleCallbacksInner(activity, callbacks);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeActivityLifecycleCallbacksInner(Activity activity, Utils.ActivityLifecycleCallbacks lifecycleCallbacks) {
        List<Utils.ActivityLifecycleCallbacks> callbacks = this.mActivityLifecycleCallbacksMap.get(activity);
        if (callbacks != null && !callbacks.isEmpty()) {
            callbacks.remove(lifecycleCallbacks);
        }
    }

    private void consumeActivityLifecycleCallbacks(Activity activity, Lifecycle.Event event) {
        List<Utils.ActivityLifecycleCallbacks> listeners = this.mActivityLifecycleCallbacksMap.get(activity);
        if (listeners != null) {
            for (Utils.ActivityLifecycleCallbacks listener : listeners) {
                listener.onLifecycleChanged(activity, event);
                if (event.equals(Lifecycle.Event.ON_CREATE)) {
                    listener.onActivityCreated(activity);
                } else if (event.equals(Lifecycle.Event.ON_START)) {
                    listener.onActivityStarted(activity);
                } else if (event.equals(Lifecycle.Event.ON_RESUME)) {
                    listener.onActivityResumed(activity);
                } else if (event.equals(Lifecycle.Event.ON_PAUSE)) {
                    listener.onActivityPaused(activity);
                } else if (event.equals(Lifecycle.Event.ON_STOP)) {
                    listener.onActivityStopped(activity);
                } else if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                    listener.onActivityDestroyed(activity);
                }
            }
            if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                this.mActivityLifecycleCallbacksMap.remove(activity);
            }
        }
    }

    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (activity != null) {
            UtilsBridge.applyLanguage(activity);
            setAnimatorsEnabled();
            setTopActivity(activity);
            consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_CREATE);
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void onActivityStarted(Activity activity) {
        if (activity != null) {
            if (!this.mIsBackground) {
                setTopActivity(activity);
            }
            int i = this.mConfigCount;
            if (i < 0) {
                this.mConfigCount = i + 1;
            } else {
                this.mForegroundCount++;
            }
            consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_START);
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void onActivityResumed(Activity activity) {
        if (activity != null) {
            setTopActivity(activity);
            if (this.mIsBackground) {
                this.mIsBackground = false;
                postStatus(activity, true);
            }
            processHideSoftInputOnActivityDestroy(activity, false);
            consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_RESUME);
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void onActivityPaused(Activity activity) {
        if (activity != null) {
            consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_PAUSE);
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.mConfigCount--;
        } else {
            int i = this.mForegroundCount - 1;
            this.mForegroundCount = i;
            if (i <= 0) {
                this.mIsBackground = true;
                postStatus(activity, false);
            }
        }
        processHideSoftInputOnActivityDestroy(activity, true);
        consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_STOP);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (activity != null) {
            this.mActivityList.remove(activity);
            UtilsBridge.fixSoftInputLeaks(activity);
            consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_DESTROY);
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    private void processHideSoftInputOnActivityDestroy(final Activity activity, boolean isSave) {
        if (isSave) {
            activity.getWindow().getDecorView().setTag(-123, Integer.valueOf(activity.getWindow().getAttributes().softInputMode));
            activity.getWindow().setSoftInputMode(3);
            return;
        }
        final Object tag = activity.getWindow().getDecorView().getTag(-123);
        if (tag instanceof Integer) {
            UtilsBridge.runOnUiThreadDelayed(new Runnable() {
                /* class com.blankj.utilcode.util.UtilsActivityLifecycleImpl.AnonymousClass4 */

                public void run() {
                    Window window = activity.getWindow();
                    if (window != null) {
                        window.setSoftInputMode(((Integer) tag).intValue());
                    }
                }
            }, 100);
        }
    }

    private void postStatus(Activity activity, boolean isForeground) {
        if (!this.mStatusListeners.isEmpty()) {
            for (Utils.OnAppStatusChangedListener statusListener : this.mStatusListeners) {
                if (isForeground) {
                    statusListener.onForeground(activity);
                } else {
                    statusListener.onBackground(activity);
                }
            }
        }
    }

    private void setTopActivity(Activity activity) {
        if (!this.mActivityList.contains(activity)) {
            this.mActivityList.addFirst(activity);
        } else if (!this.mActivityList.getFirst().equals(activity)) {
            this.mActivityList.remove(activity);
            this.mActivityList.addFirst(activity);
        }
    }

    private List<Activity> getActivitiesByReflect() {
        LinkedList<Activity> list = new LinkedList<>();
        Activity topActivity = null;
        try {
            Object activityThread = getActivityThread();
            Field mActivitiesField = activityThread.getClass().getDeclaredField("mActivities");
            mActivitiesField.setAccessible(true);
            Object mActivities = mActivitiesField.get(activityThread);
            if (!(mActivities instanceof Map)) {
                return list;
            }
            for (Object activityRecord : ((Map) mActivities).values()) {
                Class activityClientRecordClass = activityRecord.getClass();
                Field activityField = activityClientRecordClass.getDeclaredField("activity");
                activityField.setAccessible(true);
                Activity activity = (Activity) activityField.get(activityRecord);
                if (topActivity == null) {
                    Field pausedField = activityClientRecordClass.getDeclaredField("paused");
                    pausedField.setAccessible(true);
                    if (!pausedField.getBoolean(activityRecord)) {
                        topActivity = activity;
                    } else {
                        list.add(activity);
                    }
                } else {
                    list.add(activity);
                }
            }
            if (topActivity != null) {
                list.addFirst(topActivity);
            }
            return list;
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivitiesByReflect: " + e.getMessage());
        }
    }

    private Object getActivityThread() {
        Object activityThread = getActivityThreadInActivityThreadStaticField();
        if (activityThread != null) {
            return activityThread;
        }
        Object activityThread2 = getActivityThreadInActivityThreadStaticMethod();
        if (activityThread2 != null) {
            return activityThread2;
        }
        return getActivityThreadInLoadedApkField();
    }

    private Object getActivityThreadInActivityThreadStaticField() {
        try {
            Field sCurrentActivityThreadField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            sCurrentActivityThreadField.setAccessible(true);
            return sCurrentActivityThreadField.get(null);
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e.getMessage());
            return null;
        }
    }

    private Object getActivityThreadInActivityThreadStaticMethod() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e.getMessage());
            return null;
        }
    }

    private Object getActivityThreadInLoadedApkField() {
        try {
            Field mLoadedApkField = Application.class.getDeclaredField("mLoadedApk");
            mLoadedApkField.setAccessible(true);
            Object mLoadedApk = mLoadedApkField.get(Utils.getApp());
            Field mActivityThreadField = mLoadedApk.getClass().getDeclaredField("mActivityThread");
            mActivityThreadField.setAccessible(true);
            return mActivityThreadField.get(mLoadedApk);
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInLoadedApkField: " + e.getMessage());
            return null;
        }
    }

    private static void setAnimatorsEnabled() {
        if (Build.VERSION.SDK_INT < 26 || !ValueAnimator.areAnimatorsEnabled()) {
            try {
                Field sDurationScaleField = ValueAnimator.class.getDeclaredField("sDurationScale");
                sDurationScaleField.setAccessible(true);
                if (((Float) sDurationScaleField.get(null)).floatValue() == 0.0f) {
                    sDurationScaleField.set(null, Float.valueOf(1.0f));
                    Log.i("UtilsActivityLifecycle", "setAnimatorsEnabled: Animators are enabled now!");
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }
}

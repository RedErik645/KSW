package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.blankj.utilcode.util.Utils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class ActivityUtils {
    private ActivityUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void addActivityLifecycleCallbacks(Activity activity, Utils.ActivityLifecycleCallbacks callbacks) {
        UtilsBridge.addActivityLifecycleCallbacks(activity, callbacks);
    }

    public static void removeActivityLifecycleCallbacks(Activity activity) {
        UtilsBridge.removeActivityLifecycleCallbacks(activity);
    }

    public static void removeActivityLifecycleCallbacks(Activity activity, Utils.ActivityLifecycleCallbacks callbacks) {
        UtilsBridge.removeActivityLifecycleCallbacks(activity, callbacks);
    }

    public static Activity getActivityByContext(Context context) {
        Activity activity = getActivityByContextInner(context);
        if (!isActivityAlive(activity)) {
            return null;
        }
        return activity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x000d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.app.Activity getActivityByContextInner(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x0009:
            boolean r2 = r4 instanceof android.content.ContextWrapper
            if (r2 == 0) goto L_0x0031
            boolean r2 = r4 instanceof android.app.Activity
            if (r2 == 0) goto L_0x0015
            r0 = r4
            android.app.Activity r0 = (android.app.Activity) r0
            return r0
        L_0x0015:
            android.app.Activity r2 = getActivityFromDecorContext(r4)
            if (r2 == 0) goto L_0x001c
            return r2
        L_0x001c:
            r1.add(r4)
            r3 = r4
            android.content.ContextWrapper r3 = (android.content.ContextWrapper) r3
            android.content.Context r4 = r3.getBaseContext()
            if (r4 != 0) goto L_0x0029
            return r0
        L_0x0029:
            boolean r3 = r1.contains(r4)
            if (r3 == 0) goto L_0x0030
            return r0
        L_0x0030:
            goto L_0x0009
        L_0x0031:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ActivityUtils.getActivityByContextInner(android.content.Context):android.app.Activity");
    }

    private static Activity getActivityFromDecorContext(Context context) {
        if (context != null && context.getClass().getName().equals("com.android.internal.policy.DecorContext")) {
            try {
                Field mActivityContextField = context.getClass().getDeclaredField("mActivityContext");
                mActivityContextField.setAccessible(true);
                return (Activity) ((WeakReference) mActivityContextField.get(context)).get();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static boolean isActivityExists(String pkg, String cls) {
        if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            Intent intent = new Intent();
            intent.setClassName(pkg, cls);
            PackageManager pm = Utils.getApp().getPackageManager();
            if (pm.resolveActivity(intent, 0) == null || intent.resolveActivity(pm) == null || pm.queryIntentActivities(intent, 0).size() == 0) {
                return false;
            }
            return true;
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Class<? extends Activity> clz) {
        if (clz != null) {
            Context context = UtilsBridge.getTopActivityOrApp();
            startActivity(context, (Bundle) null, context.getPackageName(), clz.getName(), (Bundle) null);
            return;
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void startActivity(Class<? extends Activity> clz, Bundle options) {
        if (clz != null) {
            Context context = UtilsBridge.getTopActivityOrApp();
            startActivity(context, (Bundle) null, context.getPackageName(), clz.getName(), options);
            return;
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void startActivity(Class<? extends Activity> clz, int enterAnim, int exitAnim) {
        if (clz != null) {
            Context context = UtilsBridge.getTopActivityOrApp();
            startActivity(context, (Bundle) null, context.getPackageName(), clz.getName(), getOptionsBundle(context, enterAnim, exitAnim));
            if (Build.VERSION.SDK_INT < 16 && (context instanceof Activity)) {
                ((Activity) context).overridePendingTransition(enterAnim, exitAnim);
                return;
            }
            return;
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void startActivity(Activity activity, Class<? extends Activity> clz) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivity(activity, (Bundle) null, activity.getPackageName(), clz.getName(), (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Activity activity, Class<? extends Activity> clz, Bundle options) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivity(activity, (Bundle) null, activity.getPackageName(), clz.getName(), options);
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Activity activity, Class<? extends Activity> clz, View... sharedElements) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivity(activity, (Bundle) null, activity.getPackageName(), clz.getName(), getOptionsBundle(activity, sharedElements));
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Activity activity, Class<? extends Activity> clz, int enterAnim, int exitAnim) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivity(activity, (Bundle) null, activity.getPackageName(), clz.getName(), getOptionsBundle(activity, enterAnim, exitAnim));
            if (Build.VERSION.SDK_INT < 16) {
                activity.overridePendingTransition(enterAnim, exitAnim);
            }
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Bundle extras, Class<? extends Activity> clz) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            Context context = UtilsBridge.getTopActivityOrApp();
            startActivity(context, extras, context.getPackageName(), clz.getName(), (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Bundle extras, Class<? extends Activity> clz, Bundle options) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            Context context = UtilsBridge.getTopActivityOrApp();
            startActivity(context, extras, context.getPackageName(), clz.getName(), options);
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Bundle extras, Class<? extends Activity> clz, int enterAnim, int exitAnim) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            Context context = UtilsBridge.getTopActivityOrApp();
            startActivity(context, extras, context.getPackageName(), clz.getName(), getOptionsBundle(context, enterAnim, exitAnim));
            if (Build.VERSION.SDK_INT < 16 && (context instanceof Activity)) {
                ((Activity) context).overridePendingTransition(enterAnim, exitAnim);
            }
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Bundle extras, Activity activity, Class<? extends Activity> clz) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivity(activity, extras, activity.getPackageName(), clz.getName(), (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#2 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Bundle extras, Activity activity, Class<? extends Activity> clz, Bundle options) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivity(activity, extras, activity.getPackageName(), clz.getName(), options);
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#2 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Bundle extras, Activity activity, Class<? extends Activity> clz, View... sharedElements) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivity(activity, extras, activity.getPackageName(), clz.getName(), getOptionsBundle(activity, sharedElements));
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#2 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Bundle extras, Activity activity, Class<? extends Activity> clz, int enterAnim, int exitAnim) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivity(activity, extras, activity.getPackageName(), clz.getName(), getOptionsBundle(activity, enterAnim, exitAnim));
            if (Build.VERSION.SDK_INT < 16) {
                activity.overridePendingTransition(enterAnim, exitAnim);
            }
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#2 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(String pkg, String cls) {
        if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivity(UtilsBridge.getTopActivityOrApp(), (Bundle) null, pkg, cls, (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(String pkg, String cls, Bundle options) {
        if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivity(UtilsBridge.getTopActivityOrApp(), (Bundle) null, pkg, cls, options);
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(String pkg, String cls, int enterAnim, int exitAnim) {
        if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            Context context = UtilsBridge.getTopActivityOrApp();
            startActivity(context, (Bundle) null, pkg, cls, getOptionsBundle(context, enterAnim, exitAnim));
            if (Build.VERSION.SDK_INT < 16 && (context instanceof Activity)) {
                ((Activity) context).overridePendingTransition(enterAnim, exitAnim);
            }
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Activity activity, String pkg, String cls) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivity(activity, (Bundle) null, pkg, cls, (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#2 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Activity activity, String pkg, String cls, Bundle options) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivity(activity, (Bundle) null, pkg, cls, options);
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#2 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Activity activity, String pkg, String cls, View... sharedElements) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivity(activity, (Bundle) null, pkg, cls, getOptionsBundle(activity, sharedElements));
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#2 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Activity activity, String pkg, String cls, int enterAnim, int exitAnim) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#1 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivity(activity, (Bundle) null, pkg, cls, getOptionsBundle(activity, enterAnim, exitAnim));
            if (Build.VERSION.SDK_INT < 16) {
                activity.overridePendingTransition(enterAnim, exitAnim);
            }
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#2 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Bundle extras, String pkg, String cls) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivity(UtilsBridge.getTopActivityOrApp(), extras, pkg, cls, (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#2 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Bundle extras, String pkg, String cls, Bundle options) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivity(UtilsBridge.getTopActivityOrApp(), extras, pkg, cls, options);
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#2 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Bundle extras, String pkg, String cls, int enterAnim, int exitAnim) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#1 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            Context context = UtilsBridge.getTopActivityOrApp();
            startActivity(context, extras, pkg, cls, getOptionsBundle(context, enterAnim, exitAnim));
            if (Build.VERSION.SDK_INT < 16 && (context instanceof Activity)) {
                ((Activity) context).overridePendingTransition(enterAnim, exitAnim);
            }
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#2 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Bundle extras, Activity activity, String pkg, String cls) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#2 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivity(activity, extras, pkg, cls, (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#3 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Bundle extras, Activity activity, String pkg, String cls, Bundle options) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#2 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivity(activity, extras, pkg, cls, options);
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#3 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Bundle extras, Activity activity, String pkg, String cls, View... sharedElements) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#2 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivity(activity, extras, pkg, cls, getOptionsBundle(activity, sharedElements));
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#3 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Bundle extras, Activity activity, String pkg, String cls, int enterAnim, int exitAnim) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#1 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#2 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivity(activity, extras, pkg, cls, getOptionsBundle(activity, enterAnim, exitAnim));
            if (Build.VERSION.SDK_INT < 16) {
                activity.overridePendingTransition(enterAnim, exitAnim);
            }
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#3 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static boolean startActivity(Intent intent) {
        if (intent != null) {
            return startActivity(intent, UtilsBridge.getTopActivityOrApp(), (Bundle) null);
        }
        throw new NullPointerException("Argument 'intent' of type Intent (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean startActivity(Intent intent, Bundle options) {
        if (intent != null) {
            return startActivity(intent, UtilsBridge.getTopActivityOrApp(), options);
        }
        throw new NullPointerException("Argument 'intent' of type Intent (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean startActivity(Intent intent, int enterAnim, int exitAnim) {
        if (intent != null) {
            Context context = UtilsBridge.getTopActivityOrApp();
            boolean isSuccess = startActivity(intent, context, getOptionsBundle(context, enterAnim, exitAnim));
            if (isSuccess && Build.VERSION.SDK_INT < 16 && (context instanceof Activity)) {
                ((Activity) context).overridePendingTransition(enterAnim, exitAnim);
            }
            return isSuccess;
        }
        throw new NullPointerException("Argument 'intent' of type Intent (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void startActivity(Activity activity, Intent intent) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (intent != null) {
            startActivity(intent, activity, (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'intent' of type Intent (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Activity activity, Intent intent, Bundle options) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (intent != null) {
            startActivity(intent, activity, options);
        } else {
            throw new NullPointerException("Argument 'intent' of type Intent (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Activity activity, Intent intent, View... sharedElements) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (intent != null) {
            startActivity(intent, activity, getOptionsBundle(activity, sharedElements));
        } else {
            throw new NullPointerException("Argument 'intent' of type Intent (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivity(Activity activity, Intent intent, int enterAnim, int exitAnim) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (intent != null) {
            startActivity(intent, activity, getOptionsBundle(activity, enterAnim, exitAnim));
            if (Build.VERSION.SDK_INT < 16) {
                activity.overridePendingTransition(enterAnim, exitAnim);
            }
        } else {
            throw new NullPointerException("Argument 'intent' of type Intent (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Activity activity, Class<? extends Activity> clz, int requestCode) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivityForResult(activity, (Bundle) null, activity.getPackageName(), clz.getName(), requestCode, (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Activity activity, Class<? extends Activity> clz, int requestCode, Bundle options) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivityForResult(activity, (Bundle) null, activity.getPackageName(), clz.getName(), requestCode, options);
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Activity activity, Class<? extends Activity> clz, int requestCode, View... sharedElements) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivityForResult(activity, (Bundle) null, activity.getPackageName(), clz.getName(), requestCode, getOptionsBundle(activity, sharedElements));
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Activity activity, Class<? extends Activity> clz, int requestCode, int enterAnim, int exitAnim) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivityForResult(activity, (Bundle) null, activity.getPackageName(), clz.getName(), requestCode, getOptionsBundle(activity, enterAnim, exitAnim));
            if (Build.VERSION.SDK_INT < 16) {
                activity.overridePendingTransition(enterAnim, exitAnim);
            }
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#1 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Bundle extras, Activity activity, Class<? extends Activity> clz, int requestCode) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivityForResult(activity, extras, activity.getPackageName(), clz.getName(), requestCode, (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#2 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Bundle extras, Activity activity, Class<? extends Activity> clz, int requestCode, Bundle options) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivityForResult(activity, extras, activity.getPackageName(), clz.getName(), requestCode, options);
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#2 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Bundle extras, Activity activity, Class<? extends Activity> clz, int requestCode, View... sharedElements) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivityForResult(activity, extras, activity.getPackageName(), clz.getName(), requestCode, getOptionsBundle(activity, sharedElements));
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#2 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Bundle extras, Activity activity, Class<? extends Activity> clz, int requestCode, int enterAnim, int exitAnim) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#1 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivityForResult(activity, extras, activity.getPackageName(), clz.getName(), requestCode, getOptionsBundle(activity, enterAnim, exitAnim));
            if (Build.VERSION.SDK_INT < 16) {
                activity.overridePendingTransition(enterAnim, exitAnim);
            }
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#2 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Bundle extras, Activity activity, String pkg, String cls, int requestCode) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#2 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivityForResult(activity, extras, pkg, cls, requestCode, (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#3 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Bundle extras, Activity activity, String pkg, String cls, int requestCode, Bundle options) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#1 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#2 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivityForResult(activity, extras, pkg, cls, requestCode, options);
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#3 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Bundle extras, Activity activity, String pkg, String cls, int requestCode, View... sharedElements) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#1 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#2 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivityForResult(activity, extras, pkg, cls, requestCode, getOptionsBundle(activity, sharedElements));
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#3 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Bundle extras, Activity activity, String pkg, String cls, int requestCode, int enterAnim, int exitAnim) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 7, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#1 out of 7, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#2 out of 7, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivityForResult(activity, extras, pkg, cls, requestCode, getOptionsBundle(activity, enterAnim, exitAnim));
            if (Build.VERSION.SDK_INT < 16) {
                activity.overridePendingTransition(enterAnim, exitAnim);
            }
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#3 out of 7, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int requestCode) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (intent != null) {
            startActivityForResult(intent, activity, requestCode, (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'intent' of type Intent (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int requestCode, Bundle options) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (intent != null) {
            startActivityForResult(intent, activity, requestCode, options);
        } else {
            throw new NullPointerException("Argument 'intent' of type Intent (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int requestCode, View... sharedElements) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (intent != null) {
            startActivityForResult(intent, activity, requestCode, getOptionsBundle(activity, sharedElements));
        } else {
            throw new NullPointerException("Argument 'intent' of type Intent (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int requestCode, int enterAnim, int exitAnim) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (intent != null) {
            startActivityForResult(intent, activity, requestCode, getOptionsBundle(activity, enterAnim, exitAnim));
            if (Build.VERSION.SDK_INT < 16) {
                activity.overridePendingTransition(enterAnim, exitAnim);
            }
        } else {
            throw new NullPointerException("Argument 'intent' of type Intent (#1 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Fragment fragment, Class<? extends Activity> clz, int requestCode) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivityForResult(fragment, (Bundle) null, Utils.getApp().getPackageName(), clz.getName(), requestCode, (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Fragment fragment, Class<? extends Activity> clz, int requestCode, Bundle options) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivityForResult(fragment, (Bundle) null, Utils.getApp().getPackageName(), clz.getName(), requestCode, options);
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Fragment fragment, Class<? extends Activity> clz, int requestCode, View... sharedElements) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivityForResult(fragment, (Bundle) null, Utils.getApp().getPackageName(), clz.getName(), requestCode, getOptionsBundle(fragment, sharedElements));
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Fragment fragment, Class<? extends Activity> clz, int requestCode, int enterAnim, int exitAnim) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#0 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivityForResult(fragment, (Bundle) null, Utils.getApp().getPackageName(), clz.getName(), requestCode, getOptionsBundle(fragment, enterAnim, exitAnim));
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#1 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Bundle extras, Fragment fragment, Class<? extends Activity> clz, int requestCode) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivityForResult(fragment, extras, Utils.getApp().getPackageName(), clz.getName(), requestCode, (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#2 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Bundle extras, Fragment fragment, Class<? extends Activity> clz, int requestCode, Bundle options) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivityForResult(fragment, extras, Utils.getApp().getPackageName(), clz.getName(), requestCode, options);
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#2 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Bundle extras, Fragment fragment, Class<? extends Activity> clz, int requestCode, View... sharedElements) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivityForResult(fragment, extras, Utils.getApp().getPackageName(), clz.getName(), requestCode, getOptionsBundle(fragment, sharedElements));
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#2 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Bundle extras, Fragment fragment, Class<? extends Activity> clz, int requestCode, int enterAnim, int exitAnim) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (clz != null) {
            startActivityForResult(fragment, extras, Utils.getApp().getPackageName(), clz.getName(), requestCode, getOptionsBundle(fragment, enterAnim, exitAnim));
        } else {
            throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#2 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Bundle extras, Fragment fragment, String pkg, String cls, int requestCode) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#2 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivityForResult(fragment, extras, pkg, cls, requestCode, (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#3 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Bundle extras, Fragment fragment, String pkg, String cls, int requestCode, Bundle options) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#2 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivityForResult(fragment, extras, pkg, cls, requestCode, options);
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#3 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Bundle extras, Fragment fragment, String pkg, String cls, int requestCode, View... sharedElements) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#2 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivityForResult(fragment, extras, pkg, cls, requestCode, getOptionsBundle(fragment, sharedElements));
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#3 out of 6, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Bundle extras, Fragment fragment, String pkg, String cls, int requestCode, int enterAnim, int exitAnim) {
        if (extras == null) {
            throw new NullPointerException("Argument 'extras' of type Bundle (#0 out of 7, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 7, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#2 out of 7, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (cls != null) {
            startActivityForResult(fragment, extras, pkg, cls, requestCode, getOptionsBundle(fragment, enterAnim, exitAnim));
        } else {
            throw new NullPointerException("Argument 'cls' of type String (#3 out of 7, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, int requestCode) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (intent != null) {
            startActivityForResult(intent, fragment, requestCode, (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'intent' of type Intent (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, int requestCode, Bundle options) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (intent != null) {
            startActivityForResult(intent, fragment, requestCode, options);
        } else {
            throw new NullPointerException("Argument 'intent' of type Intent (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, int requestCode, View... sharedElements) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (intent != null) {
            startActivityForResult(intent, fragment, requestCode, getOptionsBundle(fragment, sharedElements));
        } else {
            throw new NullPointerException("Argument 'intent' of type Intent (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, int requestCode, int enterAnim, int exitAnim) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#0 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (intent != null) {
            startActivityForResult(intent, fragment, requestCode, getOptionsBundle(fragment, enterAnim, exitAnim));
        } else {
            throw new NullPointerException("Argument 'intent' of type Intent (#1 out of 5, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivities(Intent[] intents) {
        if (intents != null) {
            startActivities(intents, UtilsBridge.getTopActivityOrApp(), (Bundle) null);
            return;
        }
        throw new NullPointerException("Argument 'intents' of type Intent[] (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void startActivities(Intent[] intents, Bundle options) {
        if (intents != null) {
            startActivities(intents, UtilsBridge.getTopActivityOrApp(), options);
            return;
        }
        throw new NullPointerException("Argument 'intents' of type Intent[] (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void startActivities(Intent[] intents, int enterAnim, int exitAnim) {
        if (intents != null) {
            Context context = UtilsBridge.getTopActivityOrApp();
            startActivities(intents, context, getOptionsBundle(context, enterAnim, exitAnim));
            if (Build.VERSION.SDK_INT < 16 && (context instanceof Activity)) {
                ((Activity) context).overridePendingTransition(enterAnim, exitAnim);
                return;
            }
            return;
        }
        throw new NullPointerException("Argument 'intents' of type Intent[] (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void startActivities(Activity activity, Intent[] intents) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (intents != null) {
            startActivities(intents, activity, (Bundle) null);
        } else {
            throw new NullPointerException("Argument 'intents' of type Intent[] (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivities(Activity activity, Intent[] intents, Bundle options) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (intents != null) {
            startActivities(intents, activity, options);
        } else {
            throw new NullPointerException("Argument 'intents' of type Intent[] (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startActivities(Activity activity, Intent[] intents, int enterAnim, int exitAnim) {
        if (activity == null) {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (intents != null) {
            startActivities(intents, activity, getOptionsBundle(activity, enterAnim, exitAnim));
            if (Build.VERSION.SDK_INT < 16) {
                activity.overridePendingTransition(enterAnim, exitAnim);
            }
        } else {
            throw new NullPointerException("Argument 'intents' of type Intent[] (#1 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startHomeActivity() {
        Intent homeIntent = new Intent("android.intent.action.MAIN");
        homeIntent.addCategory("android.intent.category.HOME");
        homeIntent.setFlags(268435456);
        startActivity(homeIntent);
    }

    public static void startLauncherActivity() {
        startLauncherActivity(Utils.getApp().getPackageName());
    }

    public static void startLauncherActivity(String pkg) {
        if (pkg != null) {
            String launcherActivity = getLauncherActivity(pkg);
            if (!TextUtils.isEmpty(launcherActivity)) {
                startActivity(pkg, launcherActivity);
                return;
            }
            return;
        }
        throw new NullPointerException("Argument 'pkg' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static List<Activity> getActivityList() {
        return UtilsBridge.getActivityList();
    }

    public static String getLauncherActivity() {
        return getLauncherActivity(Utils.getApp().getPackageName());
    }

    public static String getLauncherActivity(String pkg) {
        if (pkg == null) {
            throw new NullPointerException("Argument 'pkg' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (UtilsBridge.isSpace(pkg)) {
            return "";
        } else {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(pkg);
            List<ResolveInfo> info = Utils.getApp().getPackageManager().queryIntentActivities(intent, 0);
            if (info == null || info.size() == 0) {
                return "";
            }
            return info.get(0).activityInfo.name;
        }
    }

    public static List<String> getMainActivities() {
        return getMainActivities(Utils.getApp().getPackageName());
    }

    public static List<String> getMainActivities(String pkg) {
        if (pkg != null) {
            List<String> ret = new ArrayList<>();
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.setPackage(pkg);
            List<ResolveInfo> info = Utils.getApp().getPackageManager().queryIntentActivities(intent, 0);
            int size = info.size();
            if (size == 0) {
                return ret;
            }
            for (int i = 0; i < size; i++) {
                ResolveInfo ri = info.get(i);
                if (ri.activityInfo.processName.equals(pkg)) {
                    ret.add(ri.activityInfo.name);
                }
            }
            return ret;
        }
        throw new NullPointerException("Argument 'pkg' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static Activity getTopActivity() {
        return UtilsBridge.getTopActivity();
    }

    public static boolean isActivityAlive(Context context) {
        return isActivityAlive(getActivityByContext(context));
    }

    public static boolean isActivityAlive(Activity activity) {
        return activity != null && !activity.isFinishing() && (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed());
    }

    public static boolean isActivityExistsInStack(Activity activity) {
        if (activity != null) {
            for (Activity aActivity : UtilsBridge.getActivityList()) {
                if (aActivity.equals(activity)) {
                    return true;
                }
            }
            return false;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean isActivityExistsInStack(Class<? extends Activity> clz) {
        if (clz != null) {
            for (Activity aActivity : UtilsBridge.getActivityList()) {
                if (aActivity.getClass().equals(clz)) {
                    return true;
                }
            }
            return false;
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void finishActivity(Activity activity) {
        if (activity != null) {
            finishActivity(activity, false);
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void finishActivity(Activity activity, boolean isLoadAnim) {
        if (activity != null) {
            activity.finish();
            if (!isLoadAnim) {
                activity.overridePendingTransition(0, 0);
                return;
            }
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void finishActivity(Activity activity, int enterAnim, int exitAnim) {
        if (activity != null) {
            activity.finish();
            activity.overridePendingTransition(enterAnim, exitAnim);
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void finishActivity(Class<? extends Activity> clz) {
        if (clz != null) {
            finishActivity(clz, false);
            return;
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void finishActivity(Class<? extends Activity> clz, boolean isLoadAnim) {
        if (clz != null) {
            for (Activity activity : UtilsBridge.getActivityList()) {
                if (activity.getClass().equals(clz)) {
                    activity.finish();
                    if (!isLoadAnim) {
                        activity.overridePendingTransition(0, 0);
                    }
                }
            }
            return;
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void finishActivity(Class<? extends Activity> clz, int enterAnim, int exitAnim) {
        if (clz != null) {
            for (Activity activity : UtilsBridge.getActivityList()) {
                if (activity.getClass().equals(clz)) {
                    activity.finish();
                    activity.overridePendingTransition(enterAnim, exitAnim);
                }
            }
            return;
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean finishToActivity(Activity activity, boolean isIncludeSelf) {
        if (activity != null) {
            return finishToActivity(activity, isIncludeSelf, false);
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean finishToActivity(Activity activity, boolean isIncludeSelf, boolean isLoadAnim) {
        if (activity != null) {
            for (Activity act : UtilsBridge.getActivityList()) {
                if (!act.equals(activity)) {
                    finishActivity(act, isLoadAnim);
                } else if (!isIncludeSelf) {
                    return true;
                } else {
                    finishActivity(act, isLoadAnim);
                    return true;
                }
            }
            return false;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean finishToActivity(Activity activity, boolean isIncludeSelf, int enterAnim, int exitAnim) {
        if (activity != null) {
            for (Activity act : UtilsBridge.getActivityList()) {
                if (!act.equals(activity)) {
                    finishActivity(act, enterAnim, exitAnim);
                } else if (!isIncludeSelf) {
                    return true;
                } else {
                    finishActivity(act, enterAnim, exitAnim);
                    return true;
                }
            }
            return false;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean finishToActivity(Class<? extends Activity> clz, boolean isIncludeSelf) {
        if (clz != null) {
            return finishToActivity(clz, isIncludeSelf, false);
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean finishToActivity(Class<? extends Activity> clz, boolean isIncludeSelf, boolean isLoadAnim) {
        if (clz != null) {
            for (Activity act : UtilsBridge.getActivityList()) {
                if (!act.getClass().equals(clz)) {
                    finishActivity(act, isLoadAnim);
                } else if (!isIncludeSelf) {
                    return true;
                } else {
                    finishActivity(act, isLoadAnim);
                    return true;
                }
            }
            return false;
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean finishToActivity(Class<? extends Activity> clz, boolean isIncludeSelf, int enterAnim, int exitAnim) {
        if (clz != null) {
            for (Activity act : UtilsBridge.getActivityList()) {
                if (!act.getClass().equals(clz)) {
                    finishActivity(act, enterAnim, exitAnim);
                } else if (!isIncludeSelf) {
                    return true;
                } else {
                    finishActivity(act, enterAnim, exitAnim);
                    return true;
                }
            }
            return false;
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void finishOtherActivities(Class<? extends Activity> clz) {
        if (clz != null) {
            finishOtherActivities(clz, false);
            return;
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void finishOtherActivities(Class<? extends Activity> clz, boolean isLoadAnim) {
        if (clz != null) {
            for (Activity act : UtilsBridge.getActivityList()) {
                if (!act.getClass().equals(clz)) {
                    finishActivity(act, isLoadAnim);
                }
            }
            return;
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void finishOtherActivities(Class<? extends Activity> clz, int enterAnim, int exitAnim) {
        if (clz != null) {
            for (Activity act : UtilsBridge.getActivityList()) {
                if (!act.getClass().equals(clz)) {
                    finishActivity(act, enterAnim, exitAnim);
                }
            }
            return;
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void finishAllActivities() {
        finishAllActivities(false);
    }

    public static void finishAllActivities(boolean isLoadAnim) {
        for (Activity act : UtilsBridge.getActivityList()) {
            act.finish();
            if (!isLoadAnim) {
                act.overridePendingTransition(0, 0);
            }
        }
    }

    public static void finishAllActivities(int enterAnim, int exitAnim) {
        for (Activity act : UtilsBridge.getActivityList()) {
            act.finish();
            act.overridePendingTransition(enterAnim, exitAnim);
        }
    }

    public static void finishAllActivitiesExceptNewest() {
        finishAllActivitiesExceptNewest(false);
    }

    public static void finishAllActivitiesExceptNewest(boolean isLoadAnim) {
        List<Activity> activities = UtilsBridge.getActivityList();
        for (int i = 1; i < activities.size(); i++) {
            finishActivity(activities.get(i), isLoadAnim);
        }
    }

    public static void finishAllActivitiesExceptNewest(int enterAnim, int exitAnim) {
        List<Activity> activities = UtilsBridge.getActivityList();
        for (int i = 1; i < activities.size(); i++) {
            finishActivity(activities.get(i), enterAnim, exitAnim);
        }
    }

    public static Drawable getActivityIcon(Activity activity) {
        if (activity != null) {
            return getActivityIcon(activity.getComponentName());
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static Drawable getActivityIcon(Class<? extends Activity> clz) {
        if (clz != null) {
            return getActivityIcon(new ComponentName(Utils.getApp(), clz));
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static Drawable getActivityIcon(ComponentName activityName) {
        if (activityName != null) {
            try {
                return Utils.getApp().getPackageManager().getActivityIcon(activityName);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            throw new NullPointerException("Argument 'activityName' of type ComponentName (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static Drawable getActivityLogo(Activity activity) {
        if (activity != null) {
            return getActivityLogo(activity.getComponentName());
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static Drawable getActivityLogo(Class<? extends Activity> clz) {
        if (clz != null) {
            return getActivityLogo(new ComponentName(Utils.getApp(), clz));
        }
        throw new NullPointerException("Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static Drawable getActivityLogo(ComponentName activityName) {
        if (activityName != null) {
            try {
                return Utils.getApp().getPackageManager().getActivityLogo(activityName);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            throw new NullPointerException("Argument 'activityName' of type ComponentName (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    private static void startActivity(Context context, Bundle extras, String pkg, String cls, Bundle options) {
        Intent intent = new Intent();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.setComponent(new ComponentName(pkg, cls));
        startActivity(intent, context, options);
    }

    private static boolean startActivity(Intent intent, Context context, Bundle options) {
        if (!isIntentAvailable(intent)) {
            Log.e("ActivityUtils", "intent is unavailable");
            return false;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (options == null || Build.VERSION.SDK_INT < 16) {
            context.startActivity(intent);
            return true;
        }
        context.startActivity(intent, options);
        return true;
    }

    private static boolean isIntentAvailable(Intent intent) {
        return Utils.getApp().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    private static boolean startActivityForResult(Activity activity, Bundle extras, String pkg, String cls, int requestCode, Bundle options) {
        Intent intent = new Intent();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.setComponent(new ComponentName(pkg, cls));
        return startActivityForResult(intent, activity, requestCode, options);
    }

    private static boolean startActivityForResult(Intent intent, Activity activity, int requestCode, Bundle options) {
        if (!isIntentAvailable(intent)) {
            Log.e("ActivityUtils", "intent is unavailable");
            return false;
        } else if (options == null || Build.VERSION.SDK_INT < 16) {
            activity.startActivityForResult(intent, requestCode);
            return true;
        } else {
            activity.startActivityForResult(intent, requestCode, options);
            return true;
        }
    }

    private static void startActivities(Intent[] intents, Context context, Bundle options) {
        if (!(context instanceof Activity)) {
            for (Intent intent : intents) {
                intent.addFlags(268435456);
            }
        }
        if (options == null || Build.VERSION.SDK_INT < 16) {
            context.startActivities(intents);
        } else {
            context.startActivities(intents, options);
        }
    }

    private static boolean startActivityForResult(Fragment fragment, Bundle extras, String pkg, String cls, int requestCode, Bundle options) {
        Intent intent = new Intent();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.setComponent(new ComponentName(pkg, cls));
        return startActivityForResult(intent, fragment, requestCode, options);
    }

    private static boolean startActivityForResult(Intent intent, Fragment fragment, int requestCode, Bundle options) {
        if (!isIntentAvailable(intent)) {
            Log.e("ActivityUtils", "intent is unavailable");
            return false;
        } else if (fragment.getActivity() == null) {
            Log.e("ActivityUtils", "Fragment " + fragment + " not attached to Activity");
            return false;
        } else if (options == null || Build.VERSION.SDK_INT < 16) {
            fragment.startActivityForResult(intent, requestCode);
            return true;
        } else {
            fragment.startActivityForResult(intent, requestCode, options);
            return true;
        }
    }

    private static Bundle getOptionsBundle(Fragment fragment, int enterAnim, int exitAnim) {
        Activity activity = fragment.getActivity();
        if (activity == null) {
            return null;
        }
        return ActivityOptionsCompat.makeCustomAnimation(activity, enterAnim, exitAnim).toBundle();
    }

    private static Bundle getOptionsBundle(Context context, int enterAnim, int exitAnim) {
        return ActivityOptionsCompat.makeCustomAnimation(context, enterAnim, exitAnim).toBundle();
    }

    private static Bundle getOptionsBundle(Fragment fragment, View[] sharedElements) {
        Activity activity = fragment.getActivity();
        if (activity == null) {
            return null;
        }
        return getOptionsBundle(activity, sharedElements);
    }

    private static Bundle getOptionsBundle(Activity activity, View[] sharedElements) {
        int len;
        if (Build.VERSION.SDK_INT < 21 || sharedElements == null || (len = sharedElements.length) <= 0) {
            return null;
        }
        Pair<View, String>[] pairs = new Pair[len];
        for (int i = 0; i < len; i++) {
            pairs[i] = Pair.create(sharedElements[i], sharedElements[i].getTransitionName());
        }
        return ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pairs).toBundle();
    }
}
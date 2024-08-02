package com.wits.ksw.launcher.utils;

import android.util.Log;
import java.lang.reflect.Method;

public class KswSystemProperties {
    private static final String TAG = "KswSystemProperties";
    private static Method getBooleanMethod = null;

    public static long getLong(String key, long def) {
        try {
            return ((Long) Class.forName("android.os.SystemProperties").getMethod("getLong", String.class, Long.TYPE).invoke(null, key, Long.valueOf(def))).longValue();
        } catch (Exception e) {
            Log.e(TAG, "getLong Exception: " + e.toString());
            return def;
        }
    }

    public static boolean getBoolean(String key, boolean def) {
        try {
            if (getBooleanMethod == null) {
                getBooleanMethod = Class.forName("android.os.SystemProperties").getMethod("getBoolean", String.class, Boolean.TYPE);
            }
            return ((Boolean) getBooleanMethod.invoke(null, key, Boolean.valueOf(def))).booleanValue();
        } catch (Exception e) {
            Log.e(TAG, "getBoolean Exception: " + e.toString());
            return def;
        }
    }

    public static void set(String key, String viewId) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            c.getMethod("set", String.class, String.class).invoke(c, key, viewId);
        } catch (Exception e) {
            Log.e(TAG, "set Exception: " + e.toString());
        }
    }
}

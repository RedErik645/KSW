package com.blankj.utilcode.util;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ServiceUtils {
    private ServiceUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Set getAllRunningServices() {
        List<ActivityManager.RunningServiceInfo> info = ((ActivityManager) Utils.getApp().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        Set<String> names = new HashSet<>();
        if (info == null || info.size() == 0) {
            return null;
        }
        for (ActivityManager.RunningServiceInfo aInfo : info) {
            names.add(aInfo.service.getClassName());
        }
        return names;
    }

    public static void startService(String className) {
        if (className != null) {
            try {
                startService(Class.forName(className));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("Argument 'className' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void startService(Class<?> cls) {
        if (cls != null) {
            Utils.getApp().startService(new Intent(Utils.getApp(), cls));
            return;
        }
        throw new NullPointerException("Argument 'cls' of type Class<?> (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean stopService(String className) {
        if (className != null) {
            try {
                return stopService(Class.forName(className));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            throw new NullPointerException("Argument 'className' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static boolean stopService(Class<?> cls) {
        if (cls != null) {
            return Utils.getApp().stopService(new Intent(Utils.getApp(), cls));
        }
        throw new NullPointerException("Argument 'cls' of type Class<?> (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void bindService(String className, ServiceConnection conn, int flags) {
        if (className == null) {
            throw new NullPointerException("Argument 'className' of type String (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (conn != null) {
            try {
                bindService(Class.forName(className), conn, flags);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("Argument 'conn' of type ServiceConnection (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void bindService(Class<?> cls, ServiceConnection conn, int flags) {
        if (cls == null) {
            throw new NullPointerException("Argument 'cls' of type Class<?> (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (conn != null) {
            Utils.getApp().bindService(new Intent(Utils.getApp(), cls), conn, flags);
        } else {
            throw new NullPointerException("Argument 'conn' of type ServiceConnection (#1 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static void unbindService(ServiceConnection conn) {
        if (conn != null) {
            Utils.getApp().unbindService(conn);
            return;
        }
        throw new NullPointerException("Argument 'conn' of type ServiceConnection (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean isServiceRunning(Class<?> cls) {
        if (cls != null) {
            return isServiceRunning(cls.getName());
        }
        throw new NullPointerException("Argument 'cls' of type Class<?> (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean isServiceRunning(String className) {
        if (className != null) {
            List<ActivityManager.RunningServiceInfo> info = ((ActivityManager) Utils.getApp().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
            if (info == null || info.size() == 0) {
                return false;
            }
            for (ActivityManager.RunningServiceInfo aInfo : info) {
                if (className.equals(aInfo.service.getClassName())) {
                    return true;
                }
            }
            return false;
        }
        throw new NullPointerException("Argument 'className' of type String (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }
}

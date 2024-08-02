package com.wits.pms.statuscontrol;

import android.os.IBinder;
import android.util.Log;

public class ServiceManager {
    public static final String TAG = ServiceManager.class.getSimpleName();

    public static IBinder getService(String serviceName) {
        try {
            Class<?> serviceManager = Class.forName("android.os.ServiceManager");
            return (IBinder) serviceManager.getMethod("getService", String.class).invoke(serviceManager, serviceName);
        } catch (Exception var4) {
            Log.e(TAG, "error service init - " + serviceName, var4);
            return null;
        }
    }

    public static void addService(String serviceName, IBinder binder) {
        try {
            Class<?> serviceManager = Class.forName("android.os.ServiceManager");
            serviceManager.getMethod("addService", String.class, IBinder.class).invoke(serviceManager, serviceName, binder);
        } catch (Exception var4) {
            Log.e(TAG, "error service - " + serviceName, var4);
        }
    }
}
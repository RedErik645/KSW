package com.wits.ksw.launcher.utils;

import android.os.storage.StorageManager;
import android.text.TextUtils;
import android.util.Log;
import com.wits.ksw.KswApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DevicesUtils {
    private static String TAG = "DevicesUtils";

    public static List<String> getAllExternalSdcardPath(boolean isNeedExternal) {
        List<String> data = new ArrayList<>();
        try {
            StorageManager storageManager = (StorageManager) KswApplication.appContext.getSystemService("storage");
            String[] paths = (String[]) StorageManager.class.getMethod("getVolumePaths", new Class[0]).invoke(storageManager, new Object[0]);
            for (String path : paths) {
                Log.d(TAG, new StringBuilder().append("getExistDevices path = ").append(path).append("  state =").append((String) StorageManager.class.getMethod("getVolumeState", String.class).invoke(storageManager, path)).toString());
                if (isNeedExternal) {
                    data.add(path);
                } else if (!TextUtils.equals("/storage/emulated/0", path)) {
                    data.add(path);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(TAG, "getExistDevices data = " + data);
        return data;
    }

    public static boolean isPathExist(String path) {
        if (TextUtils.isEmpty(path)) {
            Log.i(TAG, "isPathExist: path is empty");
            return false;
        } else if (!new File(path).exists()) {
            Log.i(TAG, "isPathExist: path is not exist");
            return false;
        } else {
            for (String device : getAllExternalSdcardPath(true)) {
                if (path.contains(device)) {
                    return true;
                }
            }
            Log.i(TAG, "isPathExist: Devices is not exist");
            return false;
        }
    }
}

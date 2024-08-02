package com.txznet.weatherquery;

import android.util.Log;
import com.google.gson.Gson;
import java.lang.reflect.Type;

public class GsonUtil {
    private static final String TAG = "GsonUtil";

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static <T> T fromJson(byte[] byteJson, Class<T> classOfT) {
        if (byteJson == null) {
            return null;
        }
        try {
            return (T) fromJson(new String(byteJson), (Class) classOfT);
        } catch (Exception e) {
            Log.e(TAG, "json parse error", e);
            return null;
        }
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return (T) new Gson().fromJson(json, (Class) classOfT);
    }

    public static <T> T fromJson(byte[] byteJson, Type type) {
        if (byteJson == null) {
            return null;
        }
        return (T) fromJson(new String(byteJson), type);
    }

    public static <T> T fromJson(String json, Type type) {
        return (T) new Gson().fromJson(json, type);
    }
}

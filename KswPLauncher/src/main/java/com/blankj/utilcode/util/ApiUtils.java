package com.blankj.utilcode.util;

import android.util.Log;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ApiUtils {
    private static final String TAG = "ApiUtils";
    private Map<Class, BaseApi> mApiMap;
    private Map<Class, Class> mInjectApiImplMap;

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    public @interface Api {
        boolean isMock() default false;
    }

    public static class BaseApi {
    }

    private ApiUtils() {
        this.mApiMap = new ConcurrentHashMap();
        this.mInjectApiImplMap = new HashMap();
        init();
    }

    private void init() {
    }

    private void registerImpl(Class implClass) {
        this.mInjectApiImplMap.put(implClass.getSuperclass(), implClass);
    }

    public static <T extends BaseApi> T getApi(Class<T> apiClass) {
        if (apiClass != null) {
            return (T) ((BaseApi) getInstance().getApiInner(apiClass));
        }
        throw new NullPointerException("Argument 'apiClass' of type Class<T> (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void register(Class<? extends BaseApi> implClass) {
        getInstance().registerImpl(implClass);
    }

    public static String toString_() {
        return getInstance().toString();
    }

    public String toString() {
        return "ApiUtils: " + this.mInjectApiImplMap;
    }

    private static ApiUtils getInstance() {
        return LazyHolder.INSTANCE;
    }

    private <Result> Result getApiInner(Class apiClass) {
        Result result = (Result) this.mApiMap.get(apiClass);
        if (result != null) {
            return result;
        }
        synchronized (apiClass) {
            Result result2 = (Result) this.mApiMap.get(apiClass);
            if (result2 != null) {
                return result2;
            }
            Class implClass = this.mInjectApiImplMap.get(apiClass);
            if (implClass != null) {
                try {
                    Result result3 = (Result) ((BaseApi) implClass.newInstance());
                    this.mApiMap.put(apiClass, result3);
                    return result3;
                } catch (Exception e) {
                    Log.e(TAG, "The <" + implClass + "> has no parameterless constructor.");
                    return null;
                }
            } else {
                Log.e(TAG, "The <" + apiClass + "> doesn't implement.");
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    public static class LazyHolder {
        private static final ApiUtils INSTANCE = new ApiUtils();

        private LazyHolder() {
        }
    }
}
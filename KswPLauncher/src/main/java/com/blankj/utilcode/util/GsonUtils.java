package com.blankj.utilcode.util;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class GsonUtils {
    private static final Map<String, Gson> GSONS = new ConcurrentHashMap();
    private static final String KEY_DEFAULT = "defaultGson";
    private static final String KEY_DELEGATE = "delegateGson";
    private static final String KEY_LOG_UTILS = "logUtilsGson";

    private GsonUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void setGsonDelegate(Gson delegate) {
        if (delegate != null) {
            GSONS.put(KEY_DELEGATE, delegate);
        }
    }

    public static void setGson(String key, Gson gson) {
        if (!TextUtils.isEmpty(key) && gson != null) {
            GSONS.put(key, gson);
        }
    }

    public static Gson getGson(String key) {
        return GSONS.get(key);
    }

    public static Gson getGson() {
        Map<String, Gson> map = GSONS;
        Gson gsonDelegate = map.get(KEY_DELEGATE);
        if (gsonDelegate != null) {
            return gsonDelegate;
        }
        Gson gsonDefault = map.get(KEY_DEFAULT);
        if (gsonDefault != null) {
            return gsonDefault;
        }
        Gson gsonDefault2 = createGson();
        map.put(KEY_DEFAULT, gsonDefault2);
        return gsonDefault2;
    }

    public static String toJson(Object object) {
        return toJson(getGson(), object);
    }

    public static String toJson(Object src, Type typeOfSrc) {
        if (typeOfSrc != null) {
            return toJson(getGson(), src, typeOfSrc);
        }
        throw new NullPointerException("Argument 'typeOfSrc' of type Type (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static String toJson(Gson gson, Object object) {
        if (gson != null) {
            return gson.toJson(object);
        }
        throw new NullPointerException("Argument 'gson' of type Gson (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static String toJson(Gson gson, Object src, Type typeOfSrc) {
        if (gson == null) {
            throw new NullPointerException("Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (typeOfSrc != null) {
            return gson.toJson(src, typeOfSrc);
        } else {
            throw new NullPointerException("Argument 'typeOfSrc' of type Type (#2 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static <T> T fromJson(String json, Class<T> type) {
        if (type != null) {
            return (T) fromJson(getGson(), json, (Class) type);
        }
        throw new NullPointerException("Argument 'type' of type Class<T> (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static <T> T fromJson(String json, Type type) {
        if (type != null) {
            return (T) fromJson(getGson(), json, type);
        }
        throw new NullPointerException("Argument 'type' of type Type (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static <T> T fromJson(Reader reader, Class<T> type) {
        if (reader == null) {
            throw new NullPointerException("Argument 'reader' of type Reader (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (type != null) {
            return (T) fromJson(getGson(), reader, (Class) type);
        } else {
            throw new NullPointerException("Argument 'type' of type Class<T> (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static <T> T fromJson(Reader reader, Type type) {
        if (reader == null) {
            throw new NullPointerException("Argument 'reader' of type Reader (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (type != null) {
            return (T) fromJson(getGson(), reader, type);
        } else {
            throw new NullPointerException("Argument 'type' of type Type (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static <T> T fromJson(Gson gson, String json, Class<T> type) {
        if (gson == null) {
            throw new NullPointerException("Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (type != null) {
            return (T) gson.fromJson(json, (Class) type);
        } else {
            throw new NullPointerException("Argument 'type' of type Class<T> (#2 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static <T> T fromJson(Gson gson, String json, Type type) {
        if (gson == null) {
            throw new NullPointerException("Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (type != null) {
            return (T) gson.fromJson(json, type);
        } else {
            throw new NullPointerException("Argument 'type' of type Type (#2 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static <T> T fromJson(Gson gson, Reader reader, Class<T> type) {
        if (gson == null) {
            throw new NullPointerException("Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (type != null) {
            return (T) gson.fromJson(reader, (Class) type);
        } else {
            throw new NullPointerException("Argument 'type' of type Class<T> (#2 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static <T> T fromJson(Gson gson, Reader reader, Type type) {
        if (gson == null) {
            throw new NullPointerException("Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (type != null) {
            return (T) gson.fromJson(reader, type);
        } else {
            throw new NullPointerException("Argument 'type' of type Type (#2 out of 3, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static Type getListType(Type type) {
        if (type != null) {
            return TypeToken.getParameterized(List.class, type).getType();
        }
        throw new NullPointerException("Argument 'type' of type Type (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static Type getSetType(Type type) {
        if (type != null) {
            return TypeToken.getParameterized(Set.class, type).getType();
        }
        throw new NullPointerException("Argument 'type' of type Type (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static Type getMapType(Type keyType, Type valueType) {
        if (keyType == null) {
            throw new NullPointerException("Argument 'keyType' of type Type (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (valueType != null) {
            return TypeToken.getParameterized(Map.class, keyType, valueType).getType();
        } else {
            throw new NullPointerException("Argument 'valueType' of type Type (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static Type getArrayType(Type type) {
        if (type != null) {
            return TypeToken.getArray(type).getType();
        }
        throw new NullPointerException("Argument 'type' of type Type (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static Type getType(Type rawType, Type... typeArguments) {
        if (rawType == null) {
            throw new NullPointerException("Argument 'rawType' of type Type (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (typeArguments != null) {
            return TypeToken.getParameterized(rawType, typeArguments).getType();
        } else {
            throw new NullPointerException("Argument 'typeArguments' of type Type[] (#1 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    static Gson getGson4LogUtils() {
        Map<String, Gson> map = GSONS;
        Gson gson4LogUtils = map.get(KEY_LOG_UTILS);
        if (gson4LogUtils != null) {
            return gson4LogUtils;
        }
        Gson gson4LogUtils2 = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        map.put(KEY_LOG_UTILS, gson4LogUtils2);
        return gson4LogUtils2;
    }

    private static Gson createGson() {
        return new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    }
}

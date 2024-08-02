package com.wits.ksw.settings.utlis_view;

public class SystemProperties {
    public static void set(String key, String val) {
        try {
            Class<?> systemProperties = Class.forName("android.os.SystemProperties");
            systemProperties.getMethod("set", String.class, String.class).invoke(systemProperties, key, val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        try {
            Class<?> systemProperties = Class.forName("android.os.SystemProperties");
            return (String) systemProperties.getMethod("get", String.class).invoke(systemProperties, key);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}

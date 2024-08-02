package com.blankj.utilcode.util;

import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public final class PhoneUtils {
    private PhoneUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isPhone() {
        return getTelephonyManager().getPhoneType() != 0;
    }

    public static String getDeviceId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        TelephonyManager tm = getTelephonyManager();
        String deviceId = tm.getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return "";
        }
        String imei = tm.getImei();
        if (!TextUtils.isEmpty(imei)) {
            return imei;
        }
        String meid = tm.getMeid();
        if (TextUtils.isEmpty(meid)) {
            return "";
        }
        return meid;
    }

    public static String getSerial() {
        if (Build.VERSION.SDK_INT < 29) {
            return Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : Build.SERIAL;
        }
        try {
            return Build.getSerial();
        } catch (SecurityException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getIMEI() {
        return getImeiOrMeid(true);
    }

    public static String getMEID() {
        return getImeiOrMeid(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e3 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getImeiOrMeid(boolean r13) {
        /*
        // Method dump skipped, instructions count: 228
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.PhoneUtils.getImeiOrMeid(boolean):java.lang.String");
    }

    private static String getMinOne(String s0, String s1) {
        boolean empty0 = TextUtils.isEmpty(s0);
        boolean empty1 = TextUtils.isEmpty(s1);
        if (empty0 && empty1) {
            return "";
        }
        if (empty0 || empty1) {
            if (!empty0) {
                return s0;
            }
            return s1;
        } else if (s0.compareTo(s1) <= 0) {
            return s0;
        } else {
            return s1;
        }
    }

    private static String getSystemPropertyByReflect(String key) {
        try {
            Class<?> clz = Class.forName("android.os.SystemProperties");
            return (String) clz.getMethod("get", String.class, String.class).invoke(clz, key, "");
        } catch (Exception e) {
            return "";
        }
    }

    public static String getIMSI() {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                getTelephonyManager().getSubscriberId();
            } catch (SecurityException e) {
                e.printStackTrace();
                return "";
            }
        }
        return getTelephonyManager().getSubscriberId();
    }

    public static int getPhoneType() {
        return getTelephonyManager().getPhoneType();
    }

    public static boolean isSimCardReady() {
        return getTelephonyManager().getSimState() == 5;
    }

    public static String getSimOperatorName() {
        return getTelephonyManager().getSimOperatorName();
    }

    public static String getSimOperatorByMnc() {
        String operator = getTelephonyManager().getSimOperator();
        if (operator == null) {
            return "";
        }
        char c = 65535;
        switch (operator.hashCode()) {
            case 49679470:
                if (operator.equals("46000")) {
                    c = 0;
                    break;
                }
                break;
            case 49679471:
                if (operator.equals("46001")) {
                    c = 4;
                    break;
                }
                break;
            case 49679472:
                if (operator.equals("46002")) {
                    c = 1;
                    break;
                }
                break;
            case 49679473:
                if (operator.equals("46003")) {
                    c = 7;
                    break;
                }
                break;
            case 49679475:
                if (operator.equals("46005")) {
                    c = '\b';
                    break;
                }
                break;
            case 49679476:
                if (operator.equals("46006")) {
                    c = 5;
                    break;
                }
                break;
            case 49679477:
                if (operator.equals("46007")) {
                    c = 2;
                    break;
                }
                break;
            case 49679479:
                if (operator.equals("46009")) {
                    c = 6;
                    break;
                }
                break;
            case 49679502:
                if (operator.equals("46011")) {
                    c = '\t';
                    break;
                }
                break;
            case 49679532:
                if (operator.equals("46020")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
                return "中国移动";
            case 4:
            case 5:
            case 6:
                return "中国联通";
            case 7:
            case '\b':
            case '\t':
                return "中国电信";
            default:
                return operator;
        }
    }

    public static void dial(String phoneNumber) {
        Utils.getApp().startActivity(UtilsBridge.getDialIntent(phoneNumber));
    }

    public static void call(String phoneNumber) {
        Utils.getApp().startActivity(UtilsBridge.getCallIntent(phoneNumber));
    }

    public static void sendSms(String phoneNumber, String content) {
        Utils.getApp().startActivity(UtilsBridge.getSendSmsIntent(phoneNumber, content));
    }

    private static TelephonyManager getTelephonyManager() {
        return (TelephonyManager) Utils.getApp().getSystemService("phone");
    }
}

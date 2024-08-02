package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.Locale;

public class LanguageUtils {
    private static final String KEY_LOCALE = "KEY_LOCALE";
    private static final String VALUE_FOLLOW_SYSTEM = "VALUE_FOLLOW_SYSTEM";

    private LanguageUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void applySystemLanguage() {
        if (!isAppliedSystemLanguage()) {
            applyLanguage(Resources.getSystem().getConfiguration().locale, "", true, false);
        }
    }

    public static void applySystemLanguage(Class<? extends Activity> activityClz) {
        applyLanguage(Resources.getSystem().getConfiguration().locale, activityClz, true, true);
    }

    public static void applySystemLanguage(String activityClassName) {
        applyLanguage(Resources.getSystem().getConfiguration().locale, activityClassName, true, true);
    }

    public static void applyLanguage(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Argument 'locale' of type Locale (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (!isAppliedLanguage(locale)) {
            applyLanguage(locale, "", false, false);
        }
    }

    public static void applyLanguage(Locale locale, Class<? extends Activity> activityClz) {
        if (locale != null) {
            applyLanguage(locale, activityClz, false, true);
            return;
        }
        throw new NullPointerException("Argument 'locale' of type Locale (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void applyLanguage(Locale locale, String activityClassName) {
        if (locale != null) {
            applyLanguage(locale, activityClassName, false, true);
            return;
        }
        throw new NullPointerException("Argument 'locale' of type Locale (#0 out of 2, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    private static void applyLanguage(Locale locale, Class<? extends Activity> activityClz, boolean isFollowSystem, boolean isNeedStartActivity) {
        if (locale == null) {
            throw new NullPointerException("Argument 'locale' of type Locale (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else if (activityClz == null) {
            applyLanguage(locale, "", isFollowSystem, isNeedStartActivity);
        } else {
            applyLanguage(locale, activityClz.getName(), isFollowSystem, isNeedStartActivity);
        }
    }

    private static void applyLanguage(Locale locale, String activityClassName, boolean isFollowSystem, boolean isNeedStartActivity) {
        if (locale != null) {
            if (isFollowSystem) {
                UtilsBridge.getSpUtils4Utils().put(KEY_LOCALE, VALUE_FOLLOW_SYSTEM);
            } else {
                UtilsBridge.getSpUtils4Utils().put(KEY_LOCALE, locale2String(locale));
            }
            updateLanguage(Utils.getApp(), locale);
            if (isNeedStartActivity) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(Utils.getApp(), TextUtils.isEmpty(activityClassName) ? UtilsBridge.getLauncherActivity() : activityClassName));
                intent.addFlags(335577088);
                Utils.getApp().startActivity(intent);
                return;
            }
            return;
        }
        throw new NullPointerException("Argument 'locale' of type Locale (#0 out of 4, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean isAppliedSystemLanguage() {
        return VALUE_FOLLOW_SYSTEM.equals(UtilsBridge.getSpUtils4Utils().getString(KEY_LOCALE));
    }

    public static boolean isAppliedLanguage() {
        return !TextUtils.isEmpty(UtilsBridge.getSpUtils4Utils().getString(KEY_LOCALE));
    }

    public static boolean isAppliedLanguage(Locale locale) {
        Locale settingLocale;
        String spLocale = UtilsBridge.getSpUtils4Utils().getString(KEY_LOCALE);
        if (!TextUtils.isEmpty(spLocale) && !VALUE_FOLLOW_SYSTEM.equals(spLocale) && (settingLocale = string2Locale(spLocale)) != null) {
            return isSameLocale(settingLocale, locale);
        }
        return false;
    }

    public static Locale getCurrentLocale() {
        return Utils.getApp().getResources().getConfiguration().locale;
    }

    static void applyLanguage(Activity activity) {
        if (activity != null) {
            String spLocale = UtilsBridge.getSpUtils4Utils().getString(KEY_LOCALE);
            if (!TextUtils.isEmpty(spLocale)) {
                if (VALUE_FOLLOW_SYSTEM.equals(spLocale)) {
                    Locale sysLocale = Resources.getSystem().getConfiguration().locale;
                    updateLanguage(Utils.getApp(), sysLocale);
                    updateLanguage(activity, sysLocale);
                    return;
                }
                Locale settingLocale = string2Locale(spLocale);
                if (settingLocale != null) {
                    updateLanguage(Utils.getApp(), settingLocale);
                    updateLanguage(activity, settingLocale);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    private static String locale2String(Locale locale) {
        String localLanguage = locale.getLanguage();
        return localLanguage + "$" + locale.getCountry();
    }

    private static Locale string2Locale(String str) {
        String[] language_country = str.split("\\$");
        if (language_country.length == 2) {
            return new Locale(language_country[0], language_country[1]);
        }
        Log.e("LanguageUtils", "The string of " + str + " is not in the correct format.");
        return null;
    }

    private static void updateLanguage(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration config = resources.getConfiguration();
        if (!isSameLocale(config.locale, locale)) {
            DisplayMetrics dm = resources.getDisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                config.setLocale(locale);
                if (context instanceof Application) {
                    Context newContext = context.createConfigurationContext(config);
                    try {
                        Field mBaseField = ContextWrapper.class.getDeclaredField("mBase");
                        mBaseField.setAccessible(true);
                        mBaseField.set(context, newContext);
                    } catch (Exception e) {
                    }
                }
            } else {
                config.locale = locale;
            }
            resources.updateConfiguration(config, dm);
        }
    }

    private static boolean isSameLocale(Locale l0, Locale l1) {
        return UtilsBridge.equals(l1.getLanguage(), l0.getLanguage()) && UtilsBridge.equals(l1.getCountry(), l0.getCountry());
    }
}

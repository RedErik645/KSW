package com.wits.ksw.launcher.view.benzmbux2021new.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.AppsLoaderTask;
import com.wits.ksw.launcher.model.BcVieModel;
import com.wits.ksw.launcher.utils.AppInfoUtils;
import com.wits.ksw.launcher.utils.ClientManager;
import com.wits.ksw.launcher.utils.SettingsSystemUtil;
import com.wits.ksw.launcher.utils.UiThemeUtils;
import com.wits.ksw.launcher.view.benzmbux2021new.adapter.Benzmbux2021newAdapter;
import com.wits.ksw.launcher.view.benzmbux2021new.bean.BenzCardItem;
import com.wits.ksw.launcher.view.benzmbux2021new.bean.BenzCardMenu;
import com.wits.ksw.launcher.view.benzntg6fynew.adapter.BenzNtgfyNewAdapter;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BenzUtils {
    public static final String APPS = "APPS";
    public static final String BENZ_MBUX_ORDER = "benz_mbux_card_order";
    public static final String BENZ_MBUX_ORDER_DEFAULT = "NAVI;MUSIC;BT;CAR;SET;VIDEO;APPS;LINK;DASHBOARD;DVR";
    public static final String BENZ_MBUX_V2_ORDER = "benz_mbux_v2_card_order";
    public static final String BENZ_MBUX_V2_ORDER_DEFAULT = "NAVI;MUSIC;BT;WEATHER;SET;VIDEO;APPS;CAR;DASHBOARD;DVR";
    public static final String BENZ_NTG6_FY_ORDER = "benz_ntg_fy_card_order";
    public static final String BENZ_NTG6_FY_ORDER_DEFAULT = "NAVI;MUSIC;BT;CAR;SET;VIDEO;APPS;LINK;DASHBOARD;DVR";
    public static final String BENZ_NTG6_FY_V2_ORDER = "benz_ntg_fy_v2_card_order";
    public static final String BENZ_NTG6_FY_V2_ORDER_DEFAULT = "NAVI;MUSIC;BT;WEATHER;CAR;SET;VIDEO;APPS;LINK;DASHBOARD";
    public static final String BT = "BT";
    public static final String CAR = "CAR";
    public static final int CARD_MAX = 20;
    public static final String DASHBOARD = "DASHBOARD";
    public static final String DVR = "DVR";
    public static final String EQ_PKG = "com.wits.csp.eq";
    public static final String GOOGLE_ASSISTANT_PKG = "com.google.android.apps.googleassistant";
    public static final String GOOGLE_MAP = "com.google.android.apps.maps";
    public static final String GOOGLE_PLAY = "com.android.vending";
    public static final String GOOGLE_SEARCH_PKG = "com.google.android.googlequicksearchbox";
    public static final String LINK = "LINK";
    public static final String MUSIC = "MUSIC";
    public static final String NAVI = "NAVI";
    public static final int RESULT_CODE = 120;
    public static final String SET = "SET";
    private static final String TAG = "BenzUtils";
    public static final String VIDEO = "VIDEO";
    public static final String WEATHER = "WEATHER";
    public static final String WEATHER_PKG = "com.txznet.weather";
    private static Context context;
    private static BcVieModel mBcVieModel;
    public static List<BenzCardMenu> mCardList = new ArrayList();
    public static List<String> nameList = new ArrayList();

    public static void init(Context appContext, BcVieModel vieModel) {
        context = appContext;
        mBcVieModel = vieModel;
        loadSeq();
    }

    public static List<BenzCardMenu> loadCardMenuList() {
        mCardList.clear();
        for (String cardName : nameList) {
            if (cardName.startsWith("3rd")) {
                mCardList.add(getThirdCard(cardName));
            } else if ((!UiThemeUtils.isBenz_NTG6_FY(context) || !ClientManager.getInstance().isAls6208Client()) && (!UiThemeUtils.isUI_NTG6_FY_V2(context) || !ClientManager.getInstance().isAls6208Client())) {
                mCardList.add(getLocalCard(cardName));
            } else {
                mCardList.add(getNtgLocalCard(cardName));
            }
        }
        Log.i(TAG, "loadCardMenuList: mCardList " + mCardList.size());
        return mCardList;
    }

    public static void loadSeq() {
        nameList.clear();
        String cardSeq = "";
        if (UiThemeUtils.isBenz_MBUX_2021_KSW(context)) {
            cardSeq = getBenzCardStr(context, BENZ_MBUX_ORDER, "NAVI;MUSIC;BT;CAR;SET;VIDEO;APPS;LINK;DASHBOARD;DVR");
        } else if (UiThemeUtils.isBenz_MBUX_2021_KSW_V2(context)) {
            cardSeq = getBenzCardStr(context, BENZ_MBUX_V2_ORDER, BENZ_MBUX_V2_ORDER_DEFAULT);
        } else if (UiThemeUtils.isBenz_NTG6_FY(context) && ClientManager.getInstance().isAls6208Client()) {
            cardSeq = getBenzCardStr(context, BENZ_NTG6_FY_ORDER, "NAVI;MUSIC;BT;CAR;SET;VIDEO;APPS;LINK;DASHBOARD;DVR");
        } else if (UiThemeUtils.isUI_NTG6_FY_V2(context) && ClientManager.getInstance().isAls6208Client()) {
            cardSeq = getBenzCardStr(context, BENZ_NTG6_FY_V2_ORDER, BENZ_NTG6_FY_V2_ORDER_DEFAULT);
        }
        Log.i(TAG, "loadSeq: cardSeq " + cardSeq);
        if (TextUtils.isEmpty(cardSeq)) {
            initNameList();
            return;
        }
        String[] split = cardSeq.split(";");
        if (split == null || split.length < 10) {
            initNameList();
            return;
        }
        nameList.addAll(Arrays.asList(split));
        Log.i(TAG, "loadSeq: nameList " + nameList.size());
    }

    private static void initNameList() {
        if (UiThemeUtils.isBenz_MBUX_2021_KSW(context)) {
            nameList.add(NAVI);
            nameList.add("MUSIC");
            nameList.add(BT);
            nameList.add(CAR);
            nameList.add(SET);
            nameList.add("VIDEO");
            nameList.add(APPS);
            nameList.add(LINK);
            nameList.add("DASHBOARD");
            nameList.add(DVR);
        } else if (UiThemeUtils.isBenz_MBUX_2021_KSW_V2(context)) {
            nameList.add(NAVI);
            nameList.add("MUSIC");
            nameList.add(BT);
            nameList.add("WEATHER");
            nameList.add(SET);
            nameList.add("VIDEO");
            nameList.add(APPS);
            nameList.add(CAR);
            nameList.add("DASHBOARD");
            nameList.add(DVR);
        } else if (UiThemeUtils.isBenz_NTG6_FY(context) && ClientManager.getInstance().isAls6208Client()) {
            nameList.add(NAVI);
            nameList.add("MUSIC");
            nameList.add(BT);
            nameList.add(CAR);
            nameList.add(SET);
            nameList.add("VIDEO");
            nameList.add(APPS);
            nameList.add(LINK);
            nameList.add("DASHBOARD");
            nameList.add(DVR);
        } else if (!UiThemeUtils.isUI_NTG6_FY_V2(context) || !ClientManager.getInstance().isAls6208Client()) {
            nameList.add(NAVI);
            nameList.add("MUSIC");
            nameList.add(BT);
            nameList.add(CAR);
            nameList.add(SET);
            nameList.add("VIDEO");
            nameList.add(APPS);
            nameList.add(LINK);
            nameList.add("DASHBOARD");
            nameList.add(DVR);
        } else {
            nameList.add(NAVI);
            nameList.add("MUSIC");
            nameList.add(BT);
            nameList.add("WEATHER");
            nameList.add(CAR);
            nameList.add(SET);
            nameList.add("VIDEO");
            nameList.add(APPS);
            nameList.add(LINK);
            nameList.add("DASHBOARD");
        }
    }

    private static void removeFactorySettingApp() {
        Log.i(TAG, "removeFactorySettingApp");
        Iterator<String> it = nameList.iterator();
        while (it.hasNext()) {
            try {
                String cardName = it.next();
                if (!TextUtils.isEmpty(cardName) && cardName.length() > 5 && cardName.contains(",")) {
                    String pkg = cardName.substring(4).split(",")[0];
                    if ("DTV_Type".equals(pkg)) {
                        if (PowerManagerApp.getSettingsInt("DTV_Type") != 1) {
                            it.remove();
                        }
                    } else if ("DVR_Type".equals(pkg)) {
                        if (PowerManagerApp.getSettingsInt("DVR_Type") != 1) {
                            it.remove();
                        }
                    } else if ("AUX_Type".equals(pkg)) {
                        if (PowerManagerApp.getSettingsInt("AUX_Type") != 1) {
                            it.remove();
                        }
                    } else if ("Front_view_camera".equals(pkg) && PowerManagerApp.getSettingsInt("Front_view_camera") != 1) {
                        it.remove();
                    }
                }
            } catch (RemoteException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public static void saveSystemCardSeq() {
        List<String> list = nameList;
        if (list != null && list.size() != 0) {
            removeFactorySettingApp();
            StringBuilder stringBuilder = new StringBuilder();
            for (String name : nameList) {
                stringBuilder.append(name);
                stringBuilder.append(";");
            }
            String nameListStr = stringBuilder.toString();
            Log.i(TAG, "saveSystemCardSeq: nameListStr " + nameListStr);
            if (UiThemeUtils.isBenz_MBUX_2021_KSW(context)) {
                SettingsSystemUtil.putString(KswApplication.appContext.getContentResolver(), BENZ_MBUX_ORDER, nameListStr);
            } else if (UiThemeUtils.isBenz_MBUX_2021_KSW_V2(context)) {
                SettingsSystemUtil.putString(KswApplication.appContext.getContentResolver(), BENZ_MBUX_V2_ORDER, nameListStr);
            } else if (UiThemeUtils.isBenz_NTG6_FY(context) && ClientManager.getInstance().isAls6208Client()) {
                SettingsSystemUtil.putString(KswApplication.appContext.getContentResolver(), BENZ_NTG6_FY_ORDER, nameListStr);
            } else if (UiThemeUtils.isUI_NTG6_FY_V2(context) && ClientManager.getInstance().isAls6208Client()) {
                SettingsSystemUtil.putString(KswApplication.appContext.getContentResolver(), BENZ_NTG6_FY_V2_ORDER, nameListStr);
            }
        }
    }

    public static void addTrdApp(String pkg, String cls) {
        Log.i(TAG, "addTrdApp: pkg " + pkg + " cls " + cls);
        if (nameList.size() >= 20) {
            Log.e(TAG, "卡片数量已达上限");
        } else if (UiThemeUtils.isBenz_MBUX_2021_KSW_V2(context) && TextUtils.equals(pkg, "com.txznet.weather")) {
            Log.w(TAG, "Benz_MBUX_2021_KSW_V2 无法添加全球天气");
        } else if (!UiThemeUtils.isUI_NTG6_FY_V2(context) || !ClientManager.getInstance().isAls6208Client() || !TextUtils.equals(pkg, "com.txznet.weather")) {
            String pkgInfo = "3rd:" + pkg + "," + cls;
            if (!nameList.contains(pkgInfo)) {
                List<String> list = nameList;
                list.add(list.size(), pkgInfo);
                if (pkgInfo.startsWith("3rd")) {
                    mCardList.add(getThirdCard(pkgInfo));
                }
            }
            saveSystemCardSeq();
        } else {
            Log.w(TAG, "Benz_MBUX_2021_KSW_V2 无法添加全球天气");
        }
    }

    public static void removeByPkg(String pkg) {
        Log.i(TAG, "removeByPkg: pkg " + pkg);
        if (!TextUtils.isEmpty(pkg)) {
            for (int i = 0; i < nameList.size(); i++) {
                if (nameList.get(i).contains(pkg)) {
                    Log.i(TAG, "removeByPkg: 存在此卡片 i " + i);
                    nameList.remove(i);
                    return;
                }
            }
        }
    }

    public static BenzCardMenu getLocalCard(String cardName) {
        Log.i(TAG, "getLocalCard: cardName " + cardName);
        if (TextUtils.isEmpty(cardName)) {
            return null;
        }
        char c = 65535;
        switch (cardName.hashCode()) {
            case 2130:
                if (cardName.equals(BT)) {
                    c = 2;
                    break;
                }
                break;
            case 66484:
                if (cardName.equals(CAR)) {
                    c = 3;
                    break;
                }
                break;
            case 68096:
                if (cardName.equals(DVR)) {
                    c = '\t';
                    break;
                }
                break;
            case 81986:
                if (cardName.equals(SET)) {
                    c = 4;
                    break;
                }
                break;
            case 2015858:
                if (cardName.equals(APPS)) {
                    c = 6;
                    break;
                }
                break;
            case 2336762:
                if (cardName.equals(LINK)) {
                    c = 7;
                    break;
                }
                break;
            case 2388902:
                if (cardName.equals(NAVI)) {
                    c = 0;
                    break;
                }
                break;
            case 73725445:
                if (cardName.equals("MUSIC")) {
                    c = 1;
                    break;
                }
                break;
            case 81665115:
                if (cardName.equals("VIDEO")) {
                    c = 5;
                    break;
                }
                break;
            case 1738734196:
                if (cardName.equals("DASHBOARD")) {
                    c = '\b';
                    break;
                }
                break;
            case 1941423060:
                if (cardName.equals("WEATHER")) {
                    c = '\n';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf(NAVI), NAVI, context.getString(R.string.ksw_id7_navi), context.getString(R.string.ksw_id7_real_time_navi), mBcVieModel.itemIconClassical.get() ? R.drawable.ksw_mbux2_navi_1_n : R.drawable.ksw_mbux2_navi_2_n, null, R.drawable.ksw_mbux2_navi_icon1_n, R.drawable.ksw_mbux2_navi_icon2_n, false));
            case 1:
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf("MUSIC"), "MUSIC", context.getString(R.string.ksw_id7_music), context.getString(R.string.ksw_idf7_unkonw_soung), mBcVieModel.itemIconClassical.get() ? R.drawable.ksw_mbux2_music_1_n : R.drawable.ksw_mbux2_music_2_n, null, R.drawable.ksw_mbux2_music_icon1_n, R.drawable.ksw_mbux2_music_icon2_n, false));
            case 2:
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf(BT), BT, context.getString(R.string.id6_phone), "", mBcVieModel.itemIconClassical.get() ? R.drawable.ksw_mbux2_phone_1_n : R.drawable.ksw_mbux2_phone_2_n, null, R.drawable.ksw_mbux2_phone_icon1_n, R.drawable.ksw_mbux2_phone_icon2_n, false));
            case 3:
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf(CAR), CAR, context.getString(R.string.ksw_id7_car_info), context.getString(R.string.ksw_id7_switch_to_carinfo_window), mBcVieModel.itemIconClassical.get() ? R.drawable.ksw_mbux2_car_1_n : R.drawable.ksw_mbux2_car_2_n, null, R.drawable.ksw_mbux2_dvr_icon2_n, R.drawable.ksw_mbux2_car_icon2_n, false));
            case 4:
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf(SET), SET, context.getString(R.string.ksw_id7_setting), context.getString(R.string.item1), mBcVieModel.itemIconClassical.get() ? R.drawable.ksw_mbux2_settings_1_n : R.drawable.ksw_mbux2_settings_2_n, null, R.drawable.ksw_mbux2_settings_icon1_n, R.drawable.ksw_mbux2_settings_icon2_n, false));
            case 5:
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf("VIDEO"), "VIDEO", context.getString(R.string.ksw_id7_hd_video), context.getString(R.string.ksw_id7_hd_video_warning), mBcVieModel.itemIconClassical.get() ? R.drawable.ksw_mbux2_video_1_n : R.drawable.ksw_mbux2_video_2_n, null, R.drawable.ksw_mbux2_video_icon1_n, R.drawable.ksw_mbux2_video_icon2_n, false));
            case 6:
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf(APPS), APPS, context.getString(R.string.ksw_id7_apps), context.getString(R.string.ug_apps_text), mBcVieModel.itemIconClassical.get() ? R.drawable.ksw_mbux2_app_1_n : R.drawable.ksw_mbux2_app_2_n, null, R.drawable.ksw_mbux_apps_left_icon_n, R.drawable.ksw_mbux2_app_icon2_n, false));
            case 7:
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf(LINK), LINK, context.getString(R.string.id6_shouj_hulian), context.getString(R.string.id6_shouj_hulian_mess), mBcVieModel.itemIconClassical.get() ? R.drawable.ksw_mbux2_easyconn_1_n : R.drawable.ksw_mbux2_easyconn_2_n, null, R.drawable.ksw_mbux2_easyconn_icon1_n, R.drawable.ksw_mbux2_easyconn_icon2_n, false));
            case '\b':
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf("DASHBOARD"), "DASHBOARD", context.getString(R.string.ksw_id7_dashboard_lable), "", mBcVieModel.itemIconClassical.get() ? R.drawable.ksw_mbux2_dashboard_1_n : R.drawable.ksw_mbux2_dashboard_2_n, null, R.drawable.ksw_mbux2_dashboard_icon1_n, R.drawable.ksw_mbux2_dashboard_icon2_n, false));
            case '\t':
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf(DVR), DVR, context.getString(R.string.app_dvr), context.getString(R.string.id6_xingchejily_mess), mBcVieModel.itemIconClassical.get() ? R.drawable.ksw_mbux2_dvr_1_n : R.drawable.ksw_mbux2_dvr_2_n, null, R.drawable.ksw_mbux2_dvr_icon1_n, R.drawable.ksw_mbux2_dvr_icon2_n, false));
            case '\n':
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf("WEATHER"), "WEATHER", context.getString(R.string.benz_mbux_2021_weather), context.getString(R.string.benz_mbux_2021_weather_content), mBcVieModel.itemIconClassical.get() ? R.drawable.benz_mbux_2021_ksw_v2_weather_icon1_n : R.drawable.benz_mbux_2021_ksw_v2_weather_icon2_n, null, R.drawable.benz_mbux_2021_ksw_v2_weather1_n, R.drawable.benz_mbux_2021_ksw_v2_weather2_n, false));
            default:
                return null;
        }
    }

    public static BenzCardMenu getNtgLocalCard(String cardName) {
        Log.i(TAG, "getNtgLocalCard: cardName " + cardName);
        if (TextUtils.isEmpty(cardName)) {
            return null;
        }
        char c = 65535;
        switch (cardName.hashCode()) {
            case 2130:
                if (cardName.equals(BT)) {
                    c = 2;
                    break;
                }
                break;
            case 66484:
                if (cardName.equals(CAR)) {
                    c = 3;
                    break;
                }
                break;
            case 68096:
                if (cardName.equals(DVR)) {
                    c = '\t';
                    break;
                }
                break;
            case 81986:
                if (cardName.equals(SET)) {
                    c = 4;
                    break;
                }
                break;
            case 2015858:
                if (cardName.equals(APPS)) {
                    c = 6;
                    break;
                }
                break;
            case 2336762:
                if (cardName.equals(LINK)) {
                    c = 7;
                    break;
                }
                break;
            case 2388902:
                if (cardName.equals(NAVI)) {
                    c = 0;
                    break;
                }
                break;
            case 73725445:
                if (cardName.equals("MUSIC")) {
                    c = 1;
                    break;
                }
                break;
            case 81665115:
                if (cardName.equals("VIDEO")) {
                    c = 5;
                    break;
                }
                break;
            case 1738734196:
                if (cardName.equals("DASHBOARD")) {
                    c = '\b';
                    break;
                }
                break;
            case 1941423060:
                if (cardName.equals("WEATHER")) {
                    c = '\n';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf(NAVI), NAVI, context.getString(R.string.ksw_id7_navi), context.getString(R.string.ksw_id7_real_time_navi), R.drawable.fy_mbux_navi_n, null, R.drawable.ksw_mbux2_navi_icon1_n, R.drawable.ksw_mbux2_navi_icon2_n, false));
            case 1:
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf("MUSIC"), "MUSIC", context.getString(R.string.ksw_id7_music), context.getString(R.string.ksw_idf7_unkonw_soung), R.drawable.fy_mbux_music_n, null, R.drawable.ksw_mbux2_music_icon1_n, R.drawable.ksw_mbux2_music_icon2_n, false));
            case 2:
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf(BT), BT, context.getString(R.string.id6_phone), "", R.drawable.fy_mbux_phone_n, null, R.drawable.ksw_mbux2_phone_icon1_n, R.drawable.ksw_mbux2_phone_icon2_n, false));
            case 3:
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf(CAR), CAR, context.getString(R.string.ksw_id7_car_info), context.getString(R.string.ksw_id7_switch_to_carinfo_window), R.drawable.fy_mbux_car_n, null, R.drawable.ksw_mbux2_dvr_icon2_n, R.drawable.ksw_mbux2_car_icon2_n, false));
            case 4:
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf(SET), SET, context.getString(R.string.ksw_id7_setting), context.getString(R.string.item1), R.drawable.fy_mbux_settings_n, null, R.drawable.ksw_mbux2_settings_icon1_n, R.drawable.ksw_mbux2_settings_icon2_n, false));
            case 5:
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf("VIDEO"), "VIDEO", context.getString(R.string.ksw_id7_hd_video), context.getString(R.string.ksw_id7_hd_video_warning), R.drawable.fy_mbux_video_n, null, R.drawable.ksw_mbux2_video_icon1_n, R.drawable.ksw_mbux2_video_icon2_n, false));
            case 6:
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf(APPS), APPS, context.getString(R.string.ksw_id7_apps), context.getString(R.string.ug_apps_text), R.drawable.fy_mbux_app_n, null, R.drawable.ksw_mbux_apps_left_icon_n, R.drawable.ksw_mbux2_app_icon2_n, false));
            case 7:
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf(LINK), LINK, context.getString(R.string.id6_shouj_hulian), context.getString(R.string.id6_shouj_hulian_mess), R.drawable.fy_mbux_easyconn_n, null, R.drawable.ksw_mbux2_easyconn_icon1_n, R.drawable.ksw_mbux2_easyconn_icon2_n, false));
            case '\b':
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf("DASHBOARD"), "DASHBOARD", context.getString(R.string.ksw_id7_dashboard_lable), "", R.drawable.fy_mbux_dashboard_n, null, R.drawable.ksw_mbux2_dashboard_icon1_n, R.drawable.ksw_mbux2_dashboard_icon2_n, false));
            case '\t':
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf(DVR), DVR, context.getString(R.string.app_dvr), context.getString(R.string.id6_xingchejily_mess), R.drawable.fy_mbux_dvr_n, null, R.drawable.ksw_mbux2_dvr_icon1_n, R.drawable.ksw_mbux2_dvr_icon2_n, false));
            case '\n':
                return new BenzCardMenu(1, new BenzCardItem(nameList.indexOf("WEATHER"), "WEATHER", context.getString(R.string.benz_mbux_2021_weather), context.getString(R.string.benz_mbux_2021_weather_content), R.drawable.fy_mbux2_weather_1_n, null, R.drawable.benz_mbux_2021_ksw_v2_weather1_n, R.drawable.benz_mbux_2021_ksw_v2_weather2_n, false));
            default:
                return null;
        }
    }

    private static BenzCardItem getFactorySettingAppCardItem(String cardName) {
        Log.i(TAG, "getFactorySettingAppCardItem cardName: " + cardName);
        if (TextUtils.isEmpty(cardName)) {
            Log.i(TAG, "getFactorySettingAppCardItem: cardName is null");
            return null;
        }
        try {
            String[] split = cardName.substring(4).split(",");
            String pkg = split[0];
            String str = split[1];
            BenzCardItem item = new BenzCardItem();
            item.setNumber(nameList.indexOf(cardName));
            item.setThird(true);
            item.setName(cardName);
            item.setImgBg(R.drawable.ksw_mbux_third_bg_n);
            if ("DTV_Type".equals(pkg) && PowerManagerApp.getSettingsInt("DTV_Type") == 1) {
                item.setTitle(AppsLoaderTask.dtvLable);
                item.setImgSrc(AppsLoaderTask.dtvIcon);
                return item;
            } else if ("Front_view_camera".equals(pkg) && PowerManagerApp.getSettingsInt("Front_view_camera") == 1) {
                item.setTitle(AppsLoaderTask.fcamLable);
                item.setImgSrc(AppsLoaderTask.fcamIcon);
                return item;
            } else if (!"AUX_Type".equals(pkg) || PowerManagerApp.getSettingsInt("AUX_Type") != 1) {
                if ("DVR_Type".equals(pkg) && PowerManagerApp.getSettingsInt("DVR_Type") == 1) {
                    item.setTitle(AppsLoaderTask.dvrLable);
                    item.setImgSrc(AppsLoaderTask.dvrIcon);
                    return item;
                }
                return null;
            } else {
                item.setTitle(AppsLoaderTask.auxLable);
                item.setImgSrc(AppsLoaderTask.auxIcon);
                return item;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BenzCardMenu getThirdCard(String cardName) {
        try {
            if (TextUtils.isEmpty(cardName)) {
                Log.i(TAG, "getThirdCard: cardName is null");
                return null;
            }
            BenzCardItem itemFactory = getFactorySettingAppCardItem(cardName);
            if (itemFactory != null) {
                return new BenzCardMenu(2, itemFactory);
            }
            BenzCardItem item = new BenzCardItem();
            item.setNumber(nameList.indexOf(cardName));
            boolean z = true;
            item.setThird(true);
            String[] split = cardName.substring(4).split(",");
            String pkg = split[0];
            String cls = split[1];
            ResolveInfo resolveInfo = AppInfoUtils.findAppByPkgAndCls(context, pkg, cls);
            PackageManager pm = KswApplication.appContext.getPackageManager();
            StringBuilder append = new StringBuilder().append("getThirdCard: resolveInfo == null");
            if (resolveInfo != null) {
                z = false;
            }
            Log.w(TAG, append.append(z).append(", pkg : ").append(pkg).append(", cls : ").append(cls).toString());
            if (resolveInfo == null) {
                try {
                    String appName = pm.getApplicationLabel(pm.getApplicationInfo(pkg, 128)).toString();
                    Drawable appIcon = pm.getApplicationIcon(pkg);
                    item.setName(cardName);
                    item.setTitle(appName);
                    item.setImgBg(R.drawable.ksw_mbux_third_bg_n);
                    item.setImgSrc(appIcon);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                item.setName(cardName);
                item.setTitle(resolveInfo.loadLabel(pm).toString());
                item.setImgBg(R.drawable.ksw_mbux_third_bg_n);
                item.setImgSrc(resolveInfo.loadIcon(pm));
            }
            return new BenzCardMenu(2, item);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void changeCardItemPosition(int position, boolean isLeft, PagingScrollHelper scrollHelper, Benzmbux2021newAdapter adapter) {
        List<BenzCardMenu> list = mCardList;
        if (list != null && list.size() >= 10) {
            if (position < 10) {
                if (position == 0 && isLeft) {
                    return;
                }
                if (position == 9 && !isLeft) {
                    return;
                }
            } else if (position != 10 || !isLeft) {
                try {
                    if (position == nameList.size() - 1 && !isLeft) {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            } else {
                return;
            }
            Log.i(TAG, "changeCardItemPosition: position " + position + " isLeft " + isLeft);
            Collections.swap(mCardList, position, isLeft ? position - 1 : position + 1);
            Collections.swap(nameList, position, isLeft ? position - 1 : position + 1);
            if (isLeft && (position == 5 || position == 10 || position == 15)) {
                scrollHelper.scrollToPosition((position / 5) - 1);
            }
            if (!isLeft && (position == 4 || position == 9 || position == 14)) {
                scrollHelper.scrollToPosition((position + 1) / 5);
            }
            saveSystemCardSeq();
            adapter.setCardList(mCardList);
        }
    }

    public static void changeCardItemPosition(int position, boolean isLeft, PagingScrollHelper scrollHelper, BenzNtgfyNewAdapter adapter) {
        List<BenzCardMenu> list = mCardList;
        if (list != null && list.size() >= 10) {
            if (position < 10) {
                if (position == 0 && isLeft) {
                    return;
                }
                if (position == 9 && !isLeft) {
                    return;
                }
            } else if (position != 10 || !isLeft) {
                try {
                    if (position == nameList.size() - 1 && !isLeft) {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            } else {
                return;
            }
            Log.i(TAG, "changeCardItemPosition: position " + position + " isLeft " + isLeft);
            Collections.swap(mCardList, position, isLeft ? position - 1 : position + 1);
            Collections.swap(nameList, position, isLeft ? position - 1 : position + 1);
            if (isLeft && (position == 5 || position == 10 || position == 15)) {
                scrollHelper.scrollToPosition((position / 5) - 1);
            }
            if (!isLeft && (position == 4 || position == 9 || position == 14)) {
                scrollHelper.scrollToPosition((position + 1) / 5);
            }
            saveSystemCardSeq();
            adapter.setCardList(mCardList);
        }
    }

    public static void changeCardItemPosition(int fromPosition, int toPosition) {
        try {
            Collections.swap(nameList, fromPosition, toPosition);
            saveSystemCardSeq();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteItemByPosition(int position, BcVieModel vieModel, Benzmbux2021newAdapter adapter, PagingScrollHelper scrollHelper) {
        try {
            mCardList.remove(position);
            nameList.remove(position);
            if (position == nameList.size()) {
                vieModel.selectCardName.set(nameList.get(position - 1));
            } else {
                vieModel.selectCardName.set(nameList.get(position));
            }
            adapter.setCardList(mCardList);
            saveSystemCardSeq();
            if (position == 15 && mCardList.size() == 15) {
                scrollHelper.scrollToPosition(2);
            }
            if (position == 10 && mCardList.size() == 10) {
                scrollHelper.scrollToPosition(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteItemByPosition(int position, BcVieModel vieModel, BenzNtgfyNewAdapter adapter, PagingScrollHelper scrollHelper) {
        try {
            mCardList.remove(position);
            nameList.remove(position);
            if (position == nameList.size()) {
                vieModel.selectCardName.set(nameList.get(position - 1));
            } else {
                vieModel.selectCardName.set(nameList.get(position));
            }
            adapter.setCardList(mCardList);
            saveSystemCardSeq();
            if (position == 15 && mCardList.size() == 15) {
                scrollHelper.scrollToPosition(2);
            }
            if (position == 10 && mCardList.size() == 10) {
                scrollHelper.scrollToPosition(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getBenzCardStr(Context context2, String name, String defaultStr) {
        String str = Settings.System.getString(context2.getContentResolver(), name);
        if (TextUtils.isEmpty(str)) {
            return defaultStr;
        }
        return str;
    }
}

package com.wits.ksw.launcher.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.launcher.base.BaseListAdpater;
import com.wits.ksw.launcher.bean.AppInfo;
import com.wits.ksw.launcher.bmw_id8_ui.GSID8LauncherConstants;
import com.wits.ksw.launcher.bmw_id8_ui.ID8LauncherConstants;
import com.wits.ksw.launcher.bmw_id8_ui.PempID8LauncherConstants;
import com.wits.ksw.launcher.dabebase.AppInfoRoomDatabase;
import com.wits.ksw.launcher.dabebase.AppList;
import com.wits.ksw.launcher.utils.AppInfoUtils;
import com.wits.ksw.launcher.utils.ClientManager;
import com.wits.ksw.launcher.utils.IconUtils;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.launcher.utils.UiThemeUtils;
import com.wits.ksw.launcher.view.DragGridView;
import com.wits.ksw.launcher.view.benzmbux2021new.util.BenzUtils;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.launcher.view.id9als.Id9AlsViewManager;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.util.ArrayList;
import java.util.List;

public final class AppViewModel extends LauncherViewModel {
    private static final String DESKCLOCK_PKG = "com.android.deskclock";
    private static final String DOCUMENTS_UI = "com.android.documentsui";
    private static final String EQ_PKG = "com.wits.csp.eq";
    private static final String E_CAR = "com.ecar.assistantnew";
    private static final String GAODE_MAP_PKG = "com.autonavi.amapauto";
    private static final String GN_TXZ = "com.txznet.adapter";
    private static final String GOOGLE_ASSISTANT_PKG = "com.google.android.apps.googleassistant";
    private static final String GOOGLE_MAP = "com.google.android.apps.maps";
    private static final String GOOGLE_PLAY = "com.android.vending";
    private static final String GOOGLE_SEARCH_PKG = "com.google.android.googlequicksearchbox";
    private static final String HY_TXZ = "com.txznet.smartadapter";
    private static final String IFLYTEK_PKG = "com.iflytek.inputmethod.google";
    private static final String SIM_APK = "com.android.stk";
    private static final String SOUGOU_PKG = "com.sohu.inputmethod.sogou";
    private static final String SPEEDPLAY_PKG = "com.suding.speedplay";
    private static final String TS_TXZ = "com.txznet.aipal";
    private static final String WEATHER_PKG = "com.txznet.weather";
    private static final String WITS_LOG_PKG = "com.wits.log";
    private static final String ZLINK_PKG = "com.zjinnova.zlink";
    public ObservableField<BaseListAdpater<AppInfo>> listAdpater = new ObservableField<>();
    List<AppList> mAppLists = new ArrayList();
    List<AppInfo> mListLiveData = new ArrayList();
    public DragGridView.onItemChangerListener onItemChangerListener = new DragGridView.onItemChangerListener() {
        /* class com.wits.ksw.launcher.model.AppViewModel.AnonymousClass3 */

        @Override // com.wits.ksw.launcher.view.DragGridView.onItemChangerListener
        public void onChange(GridView gridView, int from, int to) {
            Log.i(LauncherViewModel.TAG, "onChange: ");
            try {
                AppsLoaderTask.getInstance().getmListLiveData().set(from, AppsLoaderTask.getInstance().getmListLiveData().get(to));
                AppsLoaderTask.getInstance().getmListLiveData().set(to, AppsLoaderTask.getInstance().getmListLiveData().get(from));
                AppViewModel.this.updateItem(gridView, to);
                AppViewModel.this.updateItem(gridView, from);
                AppViewModel.this.SaveAppList();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.wits.ksw.launcher.view.DragGridView.onItemChangerListener
        public void onStartMoving() {
            Log.i(LauncherViewModel.TAG, "onStartMoving: ");
            try {
                String topApp = PowerManagerApp.getManager().getStatusString("topApp");
                Log.i(LauncherViewModel.TAG, "onStartMoving: topApp=" + topApp);
                if (!"com.google.android.packageinstaller".equals(topApp)) {
                    Log.i(LauncherViewModel.TAG, "onStartMoving: return");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.w(LauncherViewModel.TAG, "sendKeyDownUpSync: KEYCODE_ESCAPE");
            KswUtils.sendKeyDownUpSync(111);
        }
    };
    public AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        /* class com.wits.ksw.launcher.model.AppViewModel.AnonymousClass1 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            boolean isEdit = AppViewModel.this.activity.getIntent().getBooleanExtra("isEdit", false);
            AppInfo appInfo = (AppInfo) parent.getItemAtPosition(position);
            if (isEdit) {
                String pkg = appInfo.getApppkg();
                String cls = appInfo.getClassName();
                Log.w(LauncherViewModel.TAG, "onItemClick: pkg :" + pkg);
                Log.w(LauncherViewModel.TAG, "onItemClick: cls :" + cls);
                if (!"com.android.settings".equals(pkg)) {
                    if (UiThemeUtils.isBMW_ID8_UI(AppViewModel.this.context)) {
                        ID8LauncherConstants.addTrdApp(pkg, cls);
                    } else if (UiThemeUtils.isUI_PEMP_ID8(AppViewModel.this.context)) {
                        PempID8LauncherConstants.addTrdApp(pkg, cls);
                    } else if (UiThemeUtils.isBenz_MBUX_2021_KSW(AppViewModel.this.context) || UiThemeUtils.isBenz_MBUX_2021_KSW_V2(AppViewModel.this.context) || ((UiThemeUtils.isBenz_NTG6_FY(AppViewModel.this.context) && ClientManager.getInstance().isAls6208Client()) || (UiThemeUtils.isUI_NTG6_FY_V2(AppViewModel.this.context) && ClientManager.getInstance().isAls6208Client()))) {
                        BenzUtils.addTrdApp(pkg, cls);
                        AppViewModel.this.activity.setResult(120);
                    } else if (UiThemeUtils.isUI_EVOID9_ALS(AppViewModel.this.context)) {
                        Id9AlsViewManager.getInstance().addTrdApp(pkg, cls);
                    } else {
                        GSID8LauncherConstants.addTrdApp(pkg, cls);
                    }
                    AppViewModel.this.activity.finish();
                }
            } else if (!AppInfoUtils.openFactorySettingApp(appInfo.getApppkg())) {
                AppViewModel.this.openAppTask(new ComponentName(appInfo.getApppkg(), appInfo.getClassName()));
            }
        }
    };
    public AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        /* class com.wits.ksw.launcher.model.AppViewModel.AnonymousClass2 */

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            AppInfo appInfo = (AppInfo) parent.getItemAtPosition(position);
            Log.i("AppViewModel", "onItemLongClick: " + appInfo.toString());
            if (TextUtils.equals(appInfo.getApppkg(), "AUX_Type") || TextUtils.equals(appInfo.getApppkg(), "DTV_Type") || TextUtils.equals(appInfo.getApppkg(), "DVR_Type") || KswUtils.isSystemapp(appInfo.getApppkg()) || TextUtils.equals(appInfo.getApppkg(), "Front_view_camera") || TextUtils.equals(appInfo.getApppkg(), Id9AlsConstants.THEME_TYPE)) {
                Toast.makeText(view.getContext(), view.getContext().getString(R.string.ksw_id7_system_app_not_uninstall), 0).show();
                return true;
            }
            AppViewModel.this.uninstallAppIntent(appInfo.getApppkg(), view.getContext());
            return true;
        }
    };

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void uninstallAppIntent(String pkg, Context context) {
        Intent intent = new Intent("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + pkg));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    @Override // android.arch.lifecycle.ViewModel, com.wits.ksw.launcher.base.BaseViewModel, com.wits.ksw.launcher.model.LauncherViewModel
    public void onCleared() {
        super.onCleared();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void SaveAppList() {
        try {
            final List<AppList> newAppList = new ArrayList<>();
            for (AppInfo appInfo : AppsLoaderTask.getInstance().getmListLiveData()) {
                AppList appList = new AppList();
                appList.setClassName(appInfo.getClassName());
                newAppList.add(appList);
                if (TextUtils.isEmpty(appInfo.getClassName())) {
                    Log.e(TAG, "SaveAppList: appinfo ClassName isEmpty AppLable = " + appInfo.getAppLable());
                    return;
                }
            }
            new Thread(new Runnable() {
                /* class com.wits.ksw.launcher.model.AppViewModel.AnonymousClass4 */

                public void run() {
                    AppInfoRoomDatabase.getDatabase(KswApplication.appContext).getAppInfoDao().deleteAll();
                    AppInfoRoomDatabase.getDatabase(KswApplication.appContext).getAppInfoDao().insert(newAppList);
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateItem(GridView gridView, int position) {
        int firstVisiblePosition = gridView.getFirstVisiblePosition();
        int lastVisiblePosition = gridView.getLastVisiblePosition();
        if (position >= firstVisiblePosition && position <= lastVisiblePosition) {
            this.listAdpater.get().getView(position, gridView.getChildAt(position - firstVisiblePosition), gridView);
        }
    }

    @Override // com.wits.ksw.launcher.base.BaseViewModel, com.wits.ksw.launcher.model.AppsLoaderTask.AppsLoaderTaskListener
    public void allAppsLoaded(List<AppInfo> list) {
        Log.i(TAG, "allAppsLoaded: ");
        refreshList();
    }

    @Override // com.wits.ksw.launcher.base.BaseViewModel, com.wits.ksw.launcher.model.AppsLoaderTask.AppsLoaderTaskListener
    public void updateShortcuts(List<AppInfo> list) {
    }

    @Override // com.wits.ksw.launcher.base.BaseViewModel, com.wits.ksw.launcher.model.AppsLoaderTask.AppsLoaderTaskListener
    public void shortcutsLoaded(List<AppInfo> list) {
    }

    @Override // com.wits.ksw.launcher.base.BaseViewModel, com.wits.ksw.launcher.model.AppsLoaderTask.AppsLoaderTaskListener
    public void dialogAppsListLoaded(List<AppInfo> list) {
    }

    public void refreshList() {
        Log.i(TAG, "refreshList: ");
        try {
            if (this.listAdpater != null && AppsLoaderTask.getInstance().getmListLiveData() != null) {
                if (ClientManager.getInstance().isAls6208Client() && IconUtils.getInstance().isRoundStyle()) {
                    this.listAdpater.set(new BaseListAdpater<>(AppsLoaderTask.getInstance().getmListLiveData(), R.layout.round_app_item));
                } else if (UiThemeUtils.isEVOID8_UG(this.context)) {
                    this.listAdpater.set(new BaseListAdpater<>(AppsLoaderTask.getInstance().getmListLiveData(), R.layout.item_evoid8_app_round));
                } else {
                    this.listAdpater.set(new BaseListAdpater<>(AppsLoaderTask.getInstance().getmListLiveData(), R.layout.id7_app_item));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

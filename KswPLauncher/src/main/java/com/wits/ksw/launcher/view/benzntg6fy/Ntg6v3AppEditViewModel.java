package com.wits.ksw.launcher.view.benzntg6fy;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityNtg6v3AppEditMainBinding;
import com.wits.ksw.launcher.adpater.Ntg6V3ItemDragAdapter;
import com.wits.ksw.launcher.bean.AppInfo;
import com.wits.ksw.launcher.dabebase.AppInfoRoomDatabase;
import com.wits.ksw.launcher.dabebase.AppList;
import com.wits.ksw.launcher.model.AppsLoaderTask;
import com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel;
import com.wits.ksw.launcher.utils.Constants;
import com.wits.ksw.launcher.utils.SpfUtils;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.pms.statuscontrol.PowerManagerApp;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ntg6v3AppEditViewModel extends ViewModel {
    private static String TAG = "Ntg6v3AppEditViewModel";
    private static boolean isLocality = false;
    public static ObservableBoolean isThemeModeSelect = new ObservableBoolean(true);
    public static ObservableInt ntg6v3ChangeThemeMode = new ObservableInt(0);
    public static ObservableInt ntg6v3ChangeWallpaperMode = new ObservableInt(0);
    private String EDIT_APP_LIST = "edit_app_list";
    private ActivityNtg6v3AppEditMainBinding appEditMainBinding;
    public String[] bcItemArrys = KswApplication.appContext.getResources().getStringArray(R.array.allapps_item_text_array);
    private Context context;
    private String defaultAppList = "0,1,2,3,4,5,6,7,8,9";
    public String[] dialogItemArrys = KswApplication.appContext.getResources().getStringArray(R.array.ntg6_dialog_item_text_array);
    private ArrayList<String> editAppNameList;
    private boolean isEditApp;
    private boolean isNeedRefresh = false;
    private String[] mAppEditList = {"1", "2", "3", "4", Id9AlsConstants.ID9ALS_SELECT_MODEL_VITALITY};
    private ArrayList<AppInfo> mListLiveData;
    private RecyclerView mRecyclerView;
    List<AppList> newAppList = new ArrayList();
    public int[] resId = {R.drawable.ntg6_fy_v3_allapp_nav_bg, R.drawable.ntg6_fy_v3_allapp_theme_bg, R.drawable.ntg6_fy_v3_allapp_bt_bg, R.drawable.ntg6_fy_v3_allapp_video_bg, R.drawable.ntg6_fy_v3_allapp_setting_bg, R.drawable.ntg6_fy_v3_allapp_music_bg, R.drawable.ntg6_fy_v3_allapp_eq_bg, R.drawable.ntg6_fy_v3_allapp_phonelink_bg, R.drawable.ntg6_fy_v3_allapp_car_bg, R.drawable.ntg6_fy_v3_allapp_instrument_bg};
    public ContentObserver themeContentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3AppEditViewModel.AnonymousClass1 */

        public void onChange(boolean selfChange, Uri uri) {
            Log.i(Ntg6v3AppEditViewModel.TAG, "themeContentObserver onChange");
            Ntg6v3AppEditViewModel.this.initNtg6v3ThemeViewModel();
        }
    };
    public ContentObserver wallpaperContentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3AppEditViewModel.AnonymousClass2 */

        public void onChange(boolean selfChange, Uri uri) {
            Log.i(Ntg6v3AppEditViewModel.TAG, "wallpaperContentObserver onChange");
            Ntg6v3AppEditViewModel.this.initNtg6v3MaiWallpaperModel();
        }
    };

    public void initData(ActivityNtg6v3AppEditMainBinding themeMainBinding, Context context2) {
        this.appEditMainBinding = themeMainBinding;
        this.context = context2;
        registerObserver();
        initRecyclevView();
    }

    public void registerObserver() {
        this.context.getContentResolver().registerContentObserver(Settings.System.getUriFor(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL), true, this.themeContentObserver);
        this.context.getContentResolver().registerContentObserver(Settings.System.getUriFor(Constants.NTG6V3_SELECT_MAIN_WALLPAPER_MODEL), true, this.wallpaperContentObserver);
        this.context.getContentResolver().registerContentObserver(Settings.System.getUriFor(Constants.NTG6V3_MAIN_WALLPAPER_PATH), true, this.wallpaperContentObserver);
        initNtg6v3ThemeViewModel();
        initNtg6v3MaiWallpaperModel();
    }

    public void initNtg6v3ThemeViewModel() {
        try {
            int model = PowerManagerApp.getSettingsInt(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL);
            Log.i(TAG, "initNtg6v3ThemeViewModel model: " + model);
            ntg6v3ChangeThemeMode.set(model);
            setNtg6v3BgForWallpaper();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void initNtg6v3MaiWallpaperModel() {
        try {
            int model = PowerManagerApp.getSettingsInt(Constants.NTG6V3_SELECT_MAIN_WALLPAPER_MODEL);
            Log.i(TAG, "initNtg6v3MaiWallpaperModel model: " + model);
            ntg6v3ChangeWallpaperMode.set(model);
            setNtg6v3BgForWallpaper();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setNtg6v3BgForWallpaper() {
        View view = this.appEditMainBinding.ntg6v3ChangeThemeMainBg;
        int wallpaperValue = ntg6v3ChangeWallpaperMode.get();
        int themeValue = ntg6v3ChangeThemeMode.get();
        try {
            if (wallpaperValue == Constants.NTG6V3_THEME_WALLPAPER_MODEL_MAP) {
                view.setBackgroundResource(R.drawable.ntg6v3_main_bg_map);
            } else if (wallpaperValue == Constants.NTG6V3_THEME_WALLPAPER_MODEL_CUSTOM) {
                String path = PowerManagerApp.getSettingsString(Constants.NTG6V3_MAIN_WALLPAPER_PATH);
                if (TextUtils.isEmpty(path) || !new File(path).exists()) {
                    setNtg6v3BgForTheme(view, themeValue);
                } else {
                    view.setBackground(Drawable.createFromPath(path));
                }
            } else {
                setNtg6v3BgForTheme(view, themeValue);
            }
        } catch (RemoteException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void setNtg6v3BgForTheme(View view, int value) {
        if (value == Constants.NTG6V3_THEME_COLOR_BLUE_LIGHT) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_bg_blue2);
        } else if (value == Constants.NTG6V3_THEME_COLOR_GAY) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_bg_gay);
        } else if (value == Constants.NTG6V3_THEME_COLOR_ORANGE) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_bg_orange);
        } else if (value == Constants.NTG6V3_THEME_COLOR_YELLOW) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_bg_yellow);
        } else if (value == Constants.NTG6V3_THEME_COLOR_RED) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_bg_red);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE_LIGHT) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_bg_purple);
        } else if (value == Constants.NTG6V3_THEME_COLOR_PURPLE) {
            view.setBackgroundResource(R.drawable.ntg6v3_main_bg_purple2);
        } else {
            view.setBackgroundResource(R.drawable.ntg6v3_main_bg_blue);
        }
    }

    public static void setThemeTitleViewSelect(View view, boolean isSelect) {
        view.setSelected(isSelect);
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(ContextCompat.getColor(KswApplication.appContext, isSelect ? R.color.id8_main_style_color_yellow : R.color.white));
        }
    }

    public void initRecyclevView() {
        if (this.editAppNameList == null) {
            this.editAppNameList = new ArrayList<>();
        }
        this.editAppNameList.clear();
        this.editAppNameList.addAll(Arrays.asList(SpfUtils.getString(this.EDIT_APP_LIST, this.defaultAppList).split(",")));
        if (this.mListLiveData == null) {
            this.mListLiveData = new ArrayList<>();
        }
        this.mListLiveData.clear();
        this.newAppList.clear();
        if (isLocality) {
            Iterator<String> it = this.editAppNameList.iterator();
            while (it.hasNext()) {
                int index = Integer.parseInt(it.next());
                addCustomApp(this.mListLiveData, this.dialogItemArrys[index], KswApplication.appContext.getResources().getDrawable(Ntg6v3LauncherViewModel.resId[index]), this.bcItemArrys[index]);
            }
        } else {
            this.mListLiveData.addAll(AppsLoaderTask.getInstance().getmListLiveData());
            initThreeAppList();
        }
        if (this.mRecyclerView == null) {
            this.mRecyclerView = this.appEditMainBinding.rvList;
        }
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(this.context, 5));
        OnItemDragListener listener = new OnItemDragListener() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3AppEditViewModel.AnonymousClass3 */

            @Override // com.chad.library.adapter.base.listener.OnItemDragListener
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
                Log.d(Ntg6v3AppEditViewModel.TAG, "drag start  " + pos);
                BaseViewHolder baseViewHolder = (BaseViewHolder) viewHolder;
            }

            @Override // com.chad.library.adapter.base.listener.OnItemDragListener
            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
                Log.d(Ntg6v3AppEditViewModel.TAG, "move from: " + source.getAdapterPosition() + " to: " + target.getAdapterPosition() + " from: " + from + "  to222 :" + to);
                Ntg6v3AppEditViewModel.this.isEditApp = true;
                if (Ntg6v3AppEditViewModel.isLocality) {
                    String formStr = (String) Ntg6v3AppEditViewModel.this.editAppNameList.get(from);
                    if (from > to) {
                        Ntg6v3AppEditViewModel.this.editAppNameList.add(to, formStr);
                        Ntg6v3AppEditViewModel.this.editAppNameList.remove(from + 1);
                    } else {
                        Ntg6v3AppEditViewModel.this.editAppNameList.add(to + 1, formStr);
                        Ntg6v3AppEditViewModel.this.editAppNameList.remove(from);
                    }
                } else {
                    AppList appList = Ntg6v3AppEditViewModel.this.newAppList.get(from);
                    if (from > to) {
                        Ntg6v3AppEditViewModel.this.newAppList.add(to, appList);
                        Ntg6v3AppEditViewModel.this.newAppList.remove(from + 1);
                    } else {
                        Ntg6v3AppEditViewModel.this.newAppList.add(to + 1, appList);
                        Ntg6v3AppEditViewModel.this.newAppList.remove(from);
                    }
                }
                Log.d(Ntg6v3AppEditViewModel.TAG, "xxxx");
            }

            @Override // com.chad.library.adapter.base.listener.OnItemDragListener
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
                Log.d(Ntg6v3AppEditViewModel.TAG, "drag end  " + pos);
                if (Ntg6v3AppEditViewModel.this.isEditApp) {
                    if (!Ntg6v3AppEditViewModel.isLocality) {
                        Ntg6v3AppEditViewModel.this.saveAppListDao();
                    } else {
                        SpfUtils.saveData(Ntg6v3AppEditViewModel.this.EDIT_APP_LIST, Ntg6v3AppEditViewModel$3$$ExternalSynthetic0.m0(",", Ntg6v3AppEditViewModel.this.editAppNameList));
                    }
                    Ntg6v3AppEditViewModel.this.isEditApp = false;
                    Ntg6v3AppEditViewModel.this.isNeedRefresh = true;
                }
            }
        };
        Ntg6V3ItemDragAdapter mAdapter = new Ntg6V3ItemDragAdapter(this.mListLiveData);
        ItemDragAndSwipeCallback mItemDragAndSwipeCallback = new ItemDragAndSwipeCallback(mAdapter);
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(mItemDragAndSwipeCallback);
        mItemTouchHelper.attachToRecyclerView(this.mRecyclerView);
        mItemDragAndSwipeCallback.setSwipeMoveFlags(48);
        mAdapter.enableDragItem(mItemTouchHelper);
        mAdapter.setOnItemDragListener(listener);
        this.mRecyclerView.setAdapter(mAdapter);
    }

    private void initThreeAppList() {
        Iterator<AppInfo> it = this.mListLiveData.iterator();
        while (it.hasNext()) {
            AppInfo appInfo = it.next();
            AppList appList = new AppList();
            appList.setClassName(appInfo.getClassName());
            this.newAppList.add(appList);
            Log.d(TAG, "SaveAppList: appinfo=" + appInfo.getClassName());
            if (TextUtils.isEmpty(appInfo.getClassName())) {
                Log.e(TAG, "SaveAppList: appinfo ClassName isEmpty AppLable = " + appInfo.getAppLable());
                return;
            }
        }
    }

    private void addCustomApp(List<AppInfo> listLiveData, String type, Drawable auxIcon, String auxLable) {
        try {
            AppInfo appInfo = new AppInfo();
            appInfo.setAppIcon(auxIcon);
            appInfo.setAppLable(auxLable);
            appInfo.setApppkg(type);
            appInfo.setClassName(type);
            listLiveData.add(appInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void saveAppListDao() {
        new Thread(new Runnable() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3AppEditViewModel.AnonymousClass4 */

            public void run() {
                AppInfoRoomDatabase.getDatabase(Ntg6v3AppEditViewModel.this.context).getAppInfoDao().deleteAll();
                AppInfoRoomDatabase.getDatabase(Ntg6v3AppEditViewModel.this.context).getAppInfoDao().insert(Ntg6v3AppEditViewModel.this.newAppList);
            }
        }).start();
    }

    public boolean getIsNeedRefresh() {
        return this.isNeedRefresh;
    }

    public void changeList() {
        isLocality = !isLocality;
        this.context.startActivity(new Intent(this.context, BenzNtg6v3FyAppEditActivity.class));
        ((Activity) this.context).finish();
    }
}

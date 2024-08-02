package com.wits.ksw.launcher.view.id8ug;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.blankj.utilcode.util.SPUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.wits.ksw.KswApplication;
import com.wits.ksw.R;
import com.wits.ksw.launcher.bean.AppInfo;
import com.wits.ksw.launcher.model.AppsLoaderTask;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.launcher.view.benzmbux2021new.util.BenzUtils;
import com.wits.ksw.launcher.view.id8ug.adapter.BaseAddShortcutAdapter;
import com.wits.ksw.launcher.view.id8ug.adapter.BaseShortcutRecyclerViewAdapter;
import com.wits.pms.statuscontrol.WitsCommand;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

public class Id8UgLauncherViewModel extends LauncherViewModel {
    private static String TAG = Id8UgLauncherViewModel.class.getName();
    private List<AppInfo> allAppDatas = new ArrayList();
    public ObservableField<String> btMusicAtist = new ObservableField<>();
    public ObservableField<String> btMusicCurrentTime = new ObservableField<>();
    public ObservableInt btMusicMaxProgress = new ObservableInt(0);
    public ObservableField<String> btMusicName = new ObservableField<>();
    BroadcastReceiver btMusicProfile = new BroadcastReceiver() {
        /* class com.wits.ksw.launcher.view.id8ug.Id8UgLauncherViewModel.AnonymousClass1 */

        public void onReceive(Context context, Intent intent) {
            BtMusicStatus btMusicStatus;
            try {
                if ("com.wits.bt.broadcast".equals(intent.getAction())) {
                    String btMusicProfile = intent.getStringExtra("btMusicProfile");
                    if (!TextUtils.isEmpty(btMusicProfile) && (btMusicStatus = (BtMusicStatus) new Gson().fromJson(btMusicProfile, BtMusicStatus.class)) != null) {
                        Log.i(Id8UgLauncherViewModel.TAG, "onReceive: " + btMusicStatus.toString());
                        Id8UgLauncherViewModel.this.btMusicCurrentTime.set(KswUtils.formatMusicPlayTime(((long) btMusicStatus.getPos()) * 1000));
                        Id8UgLauncherViewModel.this.btMusicTotalTime.set(KswUtils.formatMusicPlayTime(((long) btMusicStatus.getTotal()) * 1000));
                        Id8UgLauncherViewModel.this.btMusicProgress.set(btMusicStatus.getPos());
                        Id8UgLauncherViewModel.this.btMusicMaxProgress.set(btMusicStatus.getTotal());
                        Id8UgLauncherViewModel.this.btMusicName.set(btMusicStatus.getName());
                        Id8UgLauncherViewModel.this.btMusicAtist.set(btMusicStatus.getArtist());
                    }
                }
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        }
    };
    public ObservableInt btMusicProgress = new ObservableInt(0);
    public ObservableField<String> btMusicTotalTime = new ObservableField<>();
    public ObservableBoolean id8BtMusicType = new ObservableBoolean(false);
    public ObservableField<String> id8MusicCardName = new ObservableField<>();
    private boolean isShortcutAddApp;
    private RecyclerView mRecyclerView;
    public List<AppInfo> mShortcutLiveData = new ArrayList();
    private Dialog shortcutDialog;
    private BaseShortcutRecyclerViewAdapter shortcutViewAdapter;

    @Override // com.wits.ksw.launcher.base.BaseViewModel, com.wits.ksw.launcher.model.AppsLoaderTask.AppsLoaderTaskListener
    public void allAppsLoaded(List<AppInfo> appInfos) {
        super.allAppsLoaded(appInfos);
        Log.i(TAG, "allAppsLoaded appInfos: " + appInfos);
        if (appInfos != null) {
            this.allAppDatas.clear();
            this.allAppDatas.addAll(appInfos);
            updateShortcutAdapterData();
        }
    }

    @Override // com.wits.ksw.launcher.model.LauncherViewModel
    public void initData() {
        super.initData();
        Log.i(TAG, "initData");
        this.allAppDatas.clear();
        this.allAppDatas.addAll(AppsLoaderTask.getInstance().getmListLiveData());
        registerBtMusicReceiver();
    }

    private void registerBtMusicReceiver() {
        if (this.activity != null) {
            this.activity.registerReceiver(this.btMusicProfile, new IntentFilter("com.wits.bt.broadcast"));
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.arch.lifecycle.ViewModel, com.wits.ksw.launcher.base.BaseViewModel, com.wits.ksw.launcher.model.LauncherViewModel
    public void onCleared() {
        super.onCleared();
        if (this.activity != null) {
            this.activity.unregisterReceiver(this.btMusicProfile);
        }
    }

    public void id8UgMusicPlayOrPause(View view) {
        Log.i(TAG, "id8UgMusicPlayOrPause: " + this.id8BtMusicType.get());
        if (this.id8BtMusicType.get()) {
            setLastMode(3);
            onSendCommand(3, WitsCommand.SystemCommand.UPDATE_SYSTEM);
            return;
        }
        id8GsOpenPauseMusic(view);
    }

    public void id8UgMusicPre(View view) {
        Log.i(TAG, "id8UgMusicPlayOrPause: " + this.id8BtMusicType.get());
        if (this.id8BtMusicType.get()) {
            setLastMode(3);
            onSendCommand(3, WitsCommand.SystemCommand.UPDATE_MCU);
            return;
        }
        id8GsPreMusic(view);
    }

    public void id8UgMusicNext(View view) {
        Log.i(TAG, "id8UgMusicPlayOrPause: " + this.id8BtMusicType.get());
        if (this.id8BtMusicType.get()) {
            setLastMode(3);
            onSendCommand(3, WitsCommand.SystemCommand.UPDATE_POWER_VOLTAGE);
            return;
        }
        id8GsNextMusic(view);
    }

    public void setRecyclerView(RecyclerView mRecyclerView2) {
        this.mRecyclerView = mRecyclerView2;
        initShortcutRecyclerView();
    }

    public void initShortcutRecyclerView() {
        if (this.mRecyclerView != null) {
            this.shortcutViewAdapter = new BaseShortcutRecyclerViewAdapter(R.layout.item_evoid8_shortcut, this.mShortcutLiveData);
            Log.i(TAG, "initShortcutRecyclerView: " + this.mShortcutLiveData.size());
            this.mRecyclerView.setLayoutManager(new GridLayoutManager(this.activity, 3));
            this.mRecyclerView.setAdapter(this.shortcutViewAdapter);
            boolean isEditModel = false;
            if (this.activity != null && (this.activity instanceof Id8UgEditActivity)) {
                isEditModel = true;
            }
            if (!isEditModel) {
                this.shortcutViewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgLauncherViewModel$qc0qOMYkl0hWX5YqLPyKJk0yjk */

                    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                        Id8UgLauncherViewModel.this.lambda$initShortcutRecyclerView$0$Id8UgLauncherViewModel(baseQuickAdapter, view, i);
                    }
                });
                this.shortcutViewAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
                    /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgLauncherViewModel$geAgOgMxVcsVhETeoSSAM9TwX68 */

                    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
                    public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                        return Id8UgLauncherViewModel.this.lambda$initShortcutRecyclerView$1$Id8UgLauncherViewModel(baseQuickAdapter, view, i);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$initShortcutRecyclerView$0$Id8UgLauncherViewModel(BaseQuickAdapter adapter, View view, int position) {
        AppInfo appInfo = (AppInfo) adapter.getItem(position);
        if (!this.isShortcutAddApp || position != adapter.getItemCount() - 1) {
            openAppTask(new ComponentName(appInfo.getApppkg(), appInfo.getClassName()));
        } else {
            showAddShortcutDialog();
        }
    }

    public /* synthetic */ boolean lambda$initShortcutRecyclerView$1$Id8UgLauncherViewModel(BaseQuickAdapter adapter, View view, int position) {
        if (position == adapter.getItemCount() - 1 && this.isShortcutAddApp) {
            return true;
        }
        List<ShortcutAppEntity> shortcutAppEntityList = getSaveShortcutEntitys();
        AppInfo appInfo = (AppInfo) adapter.getItem(position);
        if (shortcutAppEntityList == null || shortcutAppEntityList.size() <= 0) {
            return false;
        }
        Iterator<ShortcutAppEntity> iterator = shortcutAppEntityList.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                break;
            }
            ShortcutAppEntity appEntity = iterator.next();
            String pag = appEntity.getPagName();
            String className = appEntity.getClassName();
            if (!TextUtils.isEmpty(pag) && pag.equals(appInfo.getApppkg()) && !TextUtils.isEmpty(className) && className.equals(appInfo.getClassName())) {
                iterator.remove();
                break;
            }
        }
        saveShortcutEntitys(shortcutAppEntityList);
        updateShortcutAdapterData();
        return false;
    }

    private void saveShortcutEntitys(List<ShortcutAppEntity> list) {
        if (list != null) {
            SPUtils.getInstance().put(getShortcutAppNameKey(), new Gson().toJson(list));
        }
    }

    public void updateShortcutAdapterData() {
        if (this.mRecyclerView != null) {
            List<AppInfo> list = this.mShortcutLiveData;
            if (list == null) {
                this.mShortcutLiveData = new ArrayList();
            } else {
                list.clear();
            }
            this.mShortcutLiveData.addAll(getShortcutAppDatas(getSaveShortcutEntitys()));
            AppInfo addApp = getAddAppInfo();
            if (addApp != null) {
                this.isShortcutAddApp = true;
                this.mShortcutLiveData.add(addApp);
            }
            Log.i(TAG, "updateShortcutAdapterData: " + this.mShortcutLiveData.size());
            BaseShortcutRecyclerViewAdapter baseShortcutRecyclerViewAdapter = this.shortcutViewAdapter;
            if (baseShortcutRecyclerViewAdapter != null) {
                baseShortcutRecyclerViewAdapter.setNewData(this.mShortcutLiveData);
            }
        }
    }

    private List<ShortcutAppEntity> getSaveShortcutEntitys() {
        String shortcutAppName = SPUtils.getInstance().getString(getShortcutAppNameKey(), "");
        if (!TextUtils.isEmpty(shortcutAppName)) {
            return (List) new Gson().fromJson(shortcutAppName, new TypeToken<ArrayList<ShortcutAppEntity>>() {
                /* class com.wits.ksw.launcher.view.id8ug.Id8UgLauncherViewModel.AnonymousClass2 */
            }.getType());
        }
        if (!SPUtils.getInstance().getBoolean(Id8UgConstants.ID8UG_SHORT_APP_FIRST_INSTALL, true)) {
            return new ArrayList();
        }
        SPUtils.getInstance().put(Id8UgConstants.ID8UG_SHORT_APP_FIRST_INSTALL, false);
        List<ShortcutAppEntity> list = new ArrayList<>();
        list.add(new ShortcutAppEntity(Id8UgConstants.OWN_BT_APP_NAME, "com.wits.ksw.bt.StartActivity"));
        list.add(new ShortcutAppEntity(Id8UgConstants.OWN_VIDEO_APP_NAME, "com.wits.ksw.video.FirstActivity"));
        list.add(new ShortcutAppEntity("com.estrongs.android.pop", "com.estrongs.android.pop.view.FileExplorerActivity"));
        list.add(new ShortcutAppEntity("com.wits.apk", "com.wits.apk.HomeActivity"));
        list.add(new ShortcutAppEntity("com.zjinnova.zlink", "com.zjinnova.android.zlink.features.main.MainActivity"));
        list.add(new ShortcutAppEntity(BenzUtils.EQ_PKG, "com.wits.csp.eq.view.StartActivity"));
        list.add(new ShortcutAppEntity("com.android.settings", "com.android.settings.Settings"));
        list.add(new ShortcutAppEntity("com.txznet.weather", "com.txznet.weather.MainActivity"));
        saveShortcutEntitys(list);
        return list;
    }

    private List<AppInfo> getShortcutAppDatas(List<ShortcutAppEntity> appNameArray) {
        List<AppInfo> list = new ArrayList<>();
        List<AppInfo> list2 = this.allAppDatas;
        if (list2 == null || list2.isEmpty() || appNameArray == null || appNameArray.size() == 0) {
            return list;
        }
        for (ShortcutAppEntity entity : appNameArray) {
            Iterator<AppInfo> it = this.allAppDatas.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AppInfo appInfo = it.next();
                String str = entity.getPagName();
                String className = entity.getClassName();
                if (!TextUtils.isEmpty(str) && str.equals(appInfo.getApppkg()) && !TextUtils.isEmpty(className) && className.equals(appInfo.getClassName())) {
                    list.add(appInfo);
                    break;
                }
            }
        }
        return list;
    }

    public String getShortcutAppNameKey() {
        return Id8UgConstants.SHORTCUT_APP_NAME_ID8_UG;
    }

    public AppInfo getAddAppInfo() {
        AppInfo appInfo = new AppInfo();
        appInfo.setAppLable("Add");
        appInfo.setAppIcon(SkinCompatResources.getDrawable(this.activity, R.drawable.evoid8_shortcut_app_selector));
        return appInfo;
    }

    private void showAddShortcutDialog() {
        Dialog dialog = this.shortcutDialog;
        if (dialog == null || !dialog.isShowing()) {
            View layout = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.dialog_base_shortcut_app, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) layout.findViewById(R.id.dialog_recyclerView);
            BaseAddShortcutAdapter addAdapter = new BaseAddShortcutAdapter(getAddAppDatas());
            recyclerView.setLayoutManager(new GridLayoutManager(this.activity, 5));
            recyclerView.setAdapter(addAdapter);
            addAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgLauncherViewModel$GpaVIdPo_YELrsPCmeQ5KbJsXqM */

                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    Id8UgLauncherViewModel.this.lambda$showAddShortcutDialog$2$Id8UgLauncherViewModel(baseQuickAdapter, view, i);
                }
            });
            layout.findViewById(R.id.dialog_base_shortcut_ll).setBackgroundColor(TextUtils.equals(Id8UgConstants.ID8UG_SELECT_MODEL_NIGHT, Settings.System.getString(KswApplication.appContext.getContentResolver(), Id8UgConstants.ID8UG_SKIN_MODEL)) ? ViewCompat.MEASURED_STATE_MASK : -1);
            Dialog dialog2 = new Dialog(this.activity);
            this.shortcutDialog = dialog2;
            dialog2.setContentView(layout);
            WindowManager manager = this.activity.getWindowManager();
            manager.getDefaultDisplay().getMetrics(this.activity.getResources().getDisplayMetrics());
            Display d = manager.getDefaultDisplay();
            Window window = this.shortcutDialog.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams params = window.getAttributes();
            Log.e(TAG, "crateDialog: " + params.width + "  " + params.height + "  " + d.getWidth() + "  " + d.getHeight());
            params.height = (int) (((double) d.getHeight()) * 0.85d);
            params.width = KswUtils.dip2px(KswApplication.appContext, 640.0f);
            params.gravity = 1;
            params.alpha = 0.99f;
            window.setType(2003);
            window.setAttributes(params);
            this.shortcutDialog.show();
            window.getDecorView().findViewById(16908290).setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.launcher.view.id8ug.$$Lambda$Id8UgLauncherViewModel$416qVO4i182bk9KprJDTNp5SdU */

                public final void onClick(View view) {
                    Id8UgLauncherViewModel.this.lambda$showAddShortcutDialog$3$Id8UgLauncherViewModel(view);
                }
            });
            return;
        }
        this.shortcutDialog.dismiss();
    }

    public /* synthetic */ void lambda$showAddShortcutDialog$2$Id8UgLauncherViewModel(BaseQuickAdapter adapter, View view, int position) {
        AppInfo appInfo = (AppInfo) adapter.getItem(position);
        List<ShortcutAppEntity> saveList = getSaveShortcutEntitys();
        saveList.add(new ShortcutAppEntity(appInfo.getApppkg(), appInfo.getClassName()));
        saveShortcutEntitys(saveList);
        updateShortcutAdapterData();
        Dialog dialog = this.shortcutDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public /* synthetic */ void lambda$showAddShortcutDialog$3$Id8UgLauncherViewModel(View view) {
        this.shortcutDialog.dismiss();
    }

    private List<AppInfo> getAddAppDatas() {
        List<AppInfo> list = new ArrayList<>();
        List<AppInfo> list2 = this.allAppDatas;
        if (list2 == null || list2.isEmpty()) {
            return list;
        }
        list.addAll(this.allAppDatas);
        Iterator<AppInfo> iterator = list.iterator();
        while (iterator.hasNext()) {
            AppInfo appEntity = iterator.next();
            String pkgName = appEntity.getApppkg();
            String className = appEntity.getClassName();
            List<AppInfo> list3 = this.mShortcutLiveData;
            if (list3 != null && !list3.isEmpty()) {
                Iterator<AppInfo> it = this.mShortcutLiveData.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AppInfo appInfo = it.next();
                    if (!TextUtils.isEmpty(pkgName) && pkgName.equals(appInfo.getApppkg()) && !TextUtils.isEmpty(className) && className.equals(appInfo.getClassName())) {
                        iterator.remove();
                        break;
                    }
                }
            }
        }
        return list;
    }

    public void dismissShortcutDialog() {
        Log.i(TAG, "dismissShortcutDialog");
        Dialog dialog = this.shortcutDialog;
        if (dialog != null && dialog.isShowing()) {
            this.shortcutDialog.dismiss();
        }
    }

    public static void setID8UgMusicAlbumIcon(ImageView imageView, BitmapDrawable data) {
        if (Boolean.TRUE.equals(bThirdMusic.get())) {
            data = null;
        }
        ((RequestBuilder) ((RequestBuilder) Glide.with(imageView.getContext()).load((Drawable) data).placeholder(SkinCompatResources.getDrawable(imageView.getContext(), R.drawable.evoid8_music_icon_bg))).error(SkinCompatResources.getDrawable(imageView.getContext(), R.drawable.evoid8_music_icon_bg))).into(imageView);
    }
}

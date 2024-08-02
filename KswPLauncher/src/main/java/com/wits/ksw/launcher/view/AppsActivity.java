package com.wits.ksw.launcher.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.database.ContentObserver;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.wits.ksw.MainActivity;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityAlsId7AppsBinding;
import com.wits.ksw.databinding.ActivityEvoid8AppsBinding;
import com.wits.ksw.databinding.ActivityId7AppsBinding;
import com.wits.ksw.databinding.ActivityId8AppsBinding;
import com.wits.ksw.databinding.ActivityId9AppsBinding;
import com.wits.ksw.launcher.base.BaseThemeActivity;
import com.wits.ksw.launcher.bmw_id8_ui.ID8LauncherConstants;
import com.wits.ksw.launcher.model.AppViewModel;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.utils.ClientManager;
import com.wits.ksw.launcher.utils.IconUtils;
import com.wits.ksw.launcher.utils.UiThemeUtils;
import com.wits.ksw.launcher.view.id8ug.Id8UgConstants;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public final class AppsActivity extends BaseThemeActivity {
    private ActivityAlsId7AppsBinding alsBinding;
    private ActivityId7AppsBinding binding;
    public ContentObserver contentObserver = new ContentObserver(new Handler()) {
        /* class com.wits.ksw.launcher.view.AppsActivity.AnonymousClass1 */

        public void onChange(boolean selfChange, Uri uri) {
            AppsActivity.this.setLayoutBg();
        }
    };
    private ActivityEvoid8AppsBinding evoid8Binding;
    private ActivityId8AppsBinding id8Binding;
    private ActivityId9AppsBinding id9Binding;
    private boolean isRightCarDoor = false;
    String screenFile = "";
    private Handler screenHandler = new Handler() {
        /* class com.wits.ksw.launcher.view.AppsActivity.AnonymousClass2 */

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 666:
                    AppsActivity appsActivity = AppsActivity.this;
                    appsActivity.screenFile = MainActivity.screenShotByShell(appsActivity);
                    Log.d("liuhao", AppsActivity.this.screenFile);
                    return;
                default:
                    return;
            }
        }
    };
    private AppViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initUIKSWID7View() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwid5UiView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwid6UiView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwid6CuspUiView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwEvoId6GS() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwid7UiView() {
        AppViewModel appViewModel = (AppViewModel) ViewModelProviders.of(this).get(AppViewModel.class);
        this.viewModel = appViewModel;
        appViewModel.setActivity(this);
        this.binding = (ActivityId7AppsBinding) DataBindingUtil.setContentView(this, R.layout.activity_id7_apps);
        if (ClientManager.getInstance().isAls6208Client() && IconUtils.getInstance().isRoundStyle()) {
            if (getResources().getDisplayMetrics().widthPixels == 1024) {
                this.binding.appGridView.setNumColumns(5);
            } else {
                this.binding.appGridView.setNumColumns(6);
            }
        }
        this.binding.setAppViewModel(this.viewModel);
        this.viewModel.refreshList();
    }

    private void initBenzMbux2021UiView() {
        AppViewModel appViewModel = (AppViewModel) ViewModelProviders.of(this).get(AppViewModel.class);
        this.viewModel = appViewModel;
        appViewModel.setActivity(this);
        this.binding = (ActivityId7AppsBinding) DataBindingUtil.setContentView(this, R.layout.activity_id7_apps);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        if (width == 1024 || (width == 1280 && height == 720)) {
            this.binding.appGridView.setNumColumns(5);
        } else {
            this.binding.appGridView.setNumColumns(7);
        }
        this.binding.setAppViewModel(this.viewModel);
        this.viewModel.refreshList();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBcUiView() {
        initBenzMbux2021UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenzGSView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initGSUiView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initCommonUIGSUGView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenzMBUXView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenz_MBUX_2021_View() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenz_MBUX_2021_KSW_View() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenz_MBUX_2021_KSW_View_new() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenz_MBUX_2021_KSW_View_V2() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenz_MBUX_2021_View2() {
        initBenzMbux2021UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenz_NTG6_FY_View() {
        initBenzMbux2021UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initUI_NTG6_FY_ViewV2() {
        initBenzMbux2021UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenz_NTG6_FY_View_new() {
        initBenzMbux2021UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initUI_NTG6_FY_ViewV3() {
        initBenzMbux2021UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initEVOID8_UG() {
        AppViewModel appViewModel = (AppViewModel) ViewModelProviders.of(this).get(AppViewModel.class);
        this.viewModel = appViewModel;
        appViewModel.setActivity(this);
        ActivityEvoid8AppsBinding inflate = ActivityEvoid8AppsBinding.inflate(getLayoutInflater());
        this.evoid8Binding = inflate;
        setContentView(inflate.getRoot());
        this.evoid8Binding.setAppViewModel(this.viewModel);
        LauncherViewModel launcherViewModel = (LauncherViewModel) ViewModelProviders.of(this).get(LauncherViewModel.class);
        this.evoid8Binding.setLauncherViewModel(launcherViewModel);
        launcherViewModel.setActivity(this);
        this.viewModel.refreshList();
        boolean z = true;
        getContentResolver().registerContentObserver(Settings.System.getUriFor(Id8UgConstants.ID8UG_SKIN_MODEL), true, this.contentObserver);
        int i = 0;
        try {
            if (PowerManagerApp.getSettingsInt(KeyConfig.CAR_DOOR_SELECT) != 1) {
                z = false;
            }
            this.isRightCarDoor = z;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.evoid8Binding.leftLinearLayout.setVisibility(this.isRightCarDoor ? 8 : 0);
        LinearLayout linearLayout = this.evoid8Binding.rightLinearLayout;
        if (!this.isRightCarDoor) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        setLayoutBg();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setLayoutBg() {
        boolean isNightModel = TextUtils.equals(Id8UgConstants.ID8UG_SELECT_MODEL_NIGHT, Settings.System.getString(getContentResolver(), Id8UgConstants.ID8UG_SKIN_MODEL));
        this.evoid8Binding.id8UgMain.setBackgroundResource(isNightModel ? R.drawable.evoid8_main_bg_shape_night : R.drawable.evoid8_main_bg_shape);
        boolean z = this.isRightCarDoor;
        int i = R.drawable.bmw_evoid8_main_icon_settings_night;
        int i2 = R.drawable.bmw_evoid8_main_icon_apps_night;
        int i3 = R.drawable.bmw_evoid8_main_icon_bluetooth_night;
        int i4 = R.drawable.bmw_evoid8_main_icon_carplay_night;
        int i5 = R.drawable.bmw_evoid8_main_icon_nvai_night;
        if (z) {
            this.evoid8Binding.llRightContainer.llRightBarContainer.setImageResource(isNightModel ? R.drawable.evoid8_main_right_bg_night : R.drawable.evoid8_main_right_bg);
            ImageView imageView = this.evoid8Binding.llRightContainer.ivRight1;
            if (!isNightModel) {
                i5 = R.drawable.bmw_evoid8_main_icon_nvai;
            }
            imageView.setImageResource(i5);
            ImageView imageView2 = this.evoid8Binding.llRightContainer.ivRight2;
            if (!isNightModel) {
                i4 = R.drawable.bmw_evoid8_main_icon_carplay;
            }
            imageView2.setImageResource(i4);
            ImageView imageView3 = this.evoid8Binding.llRightContainer.ivRight3;
            if (!isNightModel) {
                i3 = R.drawable.bmw_evoid8_main_icon_bluetooth;
            }
            imageView3.setImageResource(i3);
            ImageView imageView4 = this.evoid8Binding.llRightContainer.ivRight4;
            if (!isNightModel) {
                i2 = R.drawable.bmw_evoid8_main_icon_apps;
            }
            imageView4.setImageResource(i2);
            ImageView imageView5 = this.evoid8Binding.llRightContainer.ivRight5;
            if (!isNightModel) {
                i = R.drawable.bmw_evoid8_main_icon_settings;
            }
            imageView5.setImageResource(i);
            return;
        }
        this.evoid8Binding.llLeftContainer.llLeftBarContainer.setImageResource(isNightModel ? R.drawable.evoid8_main_left_bg_night : R.drawable.evoid8_main_left_bg);
        ImageView imageView6 = this.evoid8Binding.llLeftContainer.ivLeft1;
        if (!isNightModel) {
            i5 = R.drawable.bmw_evoid8_main_icon_nvai;
        }
        imageView6.setImageResource(i5);
        ImageView imageView7 = this.evoid8Binding.llLeftContainer.ivLeft2;
        if (!isNightModel) {
            i4 = R.drawable.bmw_evoid8_main_icon_carplay;
        }
        imageView7.setImageResource(i4);
        ImageView imageView8 = this.evoid8Binding.llLeftContainer.ivLeft3;
        if (!isNightModel) {
            i3 = R.drawable.bmw_evoid8_main_icon_bluetooth;
        }
        imageView8.setImageResource(i3);
        ImageView imageView9 = this.evoid8Binding.llLeftContainer.ivLeft4;
        if (!isNightModel) {
            i2 = R.drawable.bmw_evoid8_main_icon_apps;
        }
        imageView9.setImageResource(i2);
        ImageView imageView10 = this.evoid8Binding.llLeftContainer.ivLeft5;
        if (!isNightModel) {
            i = R.drawable.bmw_evoid8_main_icon_settings;
        }
        imageView10.setImageResource(i);
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAudiView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAudiMbi3View() {
        initAudiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAudiMbi3ViewV2() {
        initAudiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBenzNTG5View() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAlsView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBwmNbt() {
        Log.d("zgy", "---initBwmNbt()--AAA--");
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initLexus() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initLexusLs() {
        AppViewModel appViewModel = (AppViewModel) ViewModelProviders.of(this).get(AppViewModel.class);
        this.viewModel = appViewModel;
        appViewModel.setActivity(this);
        this.binding = (ActivityId7AppsBinding) DataBindingUtil.setContentView(this, R.layout.activity_id7_apps);
        if (ClientManager.getInstance().isAls6208Client() && IconUtils.getInstance().isRoundStyle()) {
            if (getResources().getDisplayMetrics().widthPixels == 1024) {
                this.binding.appGridView.setNumColumns(5);
            } else {
                this.binding.appGridView.setNumColumns(6);
            }
        }
        this.binding.setAppViewModel(this.viewModel);
        this.viewModel.refreshList();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initLexusLsDrag() {
        AppViewModel appViewModel = (AppViewModel) ViewModelProviders.of(this).get(AppViewModel.class);
        this.viewModel = appViewModel;
        appViewModel.setActivity(this);
        this.binding = (ActivityId7AppsBinding) DataBindingUtil.setContentView(this, R.layout.activity_id7_apps);
        if (ClientManager.getInstance().isAls6208Client() && IconUtils.getInstance().isRoundStyle()) {
            if (getResources().getDisplayMetrics().widthPixels == 1024) {
                this.binding.appGridView.setNumColumns(5);
            } else {
                this.binding.appGridView.setNumColumns(6);
            }
        }
        this.binding.setAppViewModel(this.viewModel);
        this.viewModel.refreshList();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initLexusLsDragV2() {
        AppViewModel appViewModel = (AppViewModel) ViewModelProviders.of(this).get(AppViewModel.class);
        this.viewModel = appViewModel;
        appViewModel.setActivity(this);
        this.binding = (ActivityId7AppsBinding) DataBindingUtil.setContentView(this, R.layout.activity_id7_apps);
        if (ClientManager.getInstance().isAls6208Client() && IconUtils.getInstance().isRoundStyle()) {
            if (getResources().getDisplayMetrics().widthPixels == 1024) {
                this.binding.appGridView.setNumColumns(5);
            } else {
                this.binding.appGridView.setNumColumns(6);
            }
        }
        this.binding.setAppViewModel(this.viewModel);
        this.viewModel.refreshList();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBwmID7Hicar() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initRomeo() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initRomeo_V2() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initCommonUIGSUG1024View() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initCommonUIKSWMBUX1024View() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAlsId7UI() {
        AppViewModel appViewModel = (AppViewModel) ViewModelProviders.of(this).get(AppViewModel.class);
        this.viewModel = appViewModel;
        appViewModel.setActivity(this);
        this.alsBinding = (ActivityAlsId7AppsBinding) DataBindingUtil.setContentView(this, R.layout.activity_als_id7_apps);
        if (ClientManager.getInstance().isAls6208Client() && IconUtils.getInstance().isRoundStyle()) {
            if (getResources().getDisplayMetrics().widthPixels == 1024) {
                this.alsBinding.appGridView.setNumColumns(5);
            } else {
                this.alsBinding.appGridView.setNumColumns(6);
            }
        }
        this.alsBinding.setAppViewModel(this.viewModel);
        this.viewModel.refreshList();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAlsId7UI_V2() {
        AppViewModel appViewModel = (AppViewModel) ViewModelProviders.of(this).get(AppViewModel.class);
        this.viewModel = appViewModel;
        appViewModel.setActivity(this);
        this.alsBinding = (ActivityAlsId7AppsBinding) DataBindingUtil.setContentView(this, R.layout.activity_als_id7_apps);
        if (ClientManager.getInstance().isAls6208Client() && IconUtils.getInstance().isRoundStyle()) {
            if (getResources().getDisplayMetrics().widthPixels == 1024) {
                this.alsBinding.appGridView.setNumColumns(5);
            } else {
                this.alsBinding.appGridView.setNumColumns(8);
            }
        }
        this.alsBinding.setAppViewModel(this.viewModel);
        this.viewModel.refreshList();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initLandRover() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAlsId7UiView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAudi_mib3_FyUiView() {
        initAudiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAudi_mib3_Fy_V2_UiView() {
        initAudiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initAudiMib3Ty() {
        initAudiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwId8UiView() {
        AppViewModel appViewModel = (AppViewModel) ViewModelProviders.of(this).get(AppViewModel.class);
        this.viewModel = appViewModel;
        appViewModel.setActivity(this);
        ActivityId8AppsBinding activityId8AppsBinding = (ActivityId8AppsBinding) DataBindingUtil.setContentView(this, R.layout.activity_id8_apps);
        this.id8Binding = activityId8AppsBinding;
        activityId8AppsBinding.setAppViewModel(this.viewModel);
        this.viewModel.refreshList();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwId8PempUiView() {
        AppViewModel appViewModel = (AppViewModel) ViewModelProviders.of(this).get(AppViewModel.class);
        this.viewModel = appViewModel;
        appViewModel.setActivity(this);
        ActivityId8AppsBinding activityId8AppsBinding = (ActivityId8AppsBinding) DataBindingUtil.setContentView(this, R.layout.activity_id8_apps);
        this.id8Binding = activityId8AppsBinding;
        activityId8AppsBinding.setAppViewModel(this.viewModel);
        this.viewModel.refreshList();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwId8GsUiView() {
        AppViewModel appViewModel = (AppViewModel) ViewModelProviders.of(this).get(AppViewModel.class);
        this.viewModel = appViewModel;
        appViewModel.setActivity(this);
        ActivityId8AppsBinding activityId8AppsBinding = (ActivityId8AppsBinding) DataBindingUtil.setContentView(this, R.layout.activity_id8_apps);
        this.id8Binding = activityId8AppsBinding;
        activityId8AppsBinding.setAppViewModel(this.viewModel);
        this.viewModel.refreshList();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initBmwid7V2UiView() {
        initBmwid7UiView();
    }

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.launcher.base.BaseThemeActivity
    public void initEVOID9_ALSUIView() {
        AppViewModel appViewModel = (AppViewModel) ViewModelProviders.of(this).get(AppViewModel.class);
        this.viewModel = appViewModel;
        appViewModel.setActivity(this);
        ActivityId9AppsBinding inflate = ActivityId9AppsBinding.inflate(getLayoutInflater());
        this.id9Binding = inflate;
        setContentView(inflate.getRoot());
        this.id9Binding.setAppViewModel(this.viewModel);
        this.viewModel.refreshList();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        int drawableId;
        int drawableId2;
        int drawableId3;
        super.onResume();
        Log.w("AppsActivity", "onresume");
        if (UiThemeUtils.isLAND_ROVER(this)) {
            Log.w("AppsActivity", "onresume isLAND_ROVER");
            setFullActivity(false);
        }
        if (Settings.System.getInt(getContentResolver(), "multi_window", -1) == 1) {
            sendBroadcastAsUser(new Intent("com.wits.on_multi_window_mode").putExtra("multi_window", false), Process.myUserHandle());
        }
        if (UiThemeUtils.isLEXUS_LS_UI(this) || UiThemeUtils.isLEXUS_LS_UI_V2(this)) {
            this.screenHandler.sendEmptyMessageDelayed(666, 1800);
        }
        if (UiThemeUtils.isBMW_ID8_UI(this) || UiThemeUtils.isUI_GS_ID8(this) || UiThemeUtils.isUI_PEMP_ID8(this)) {
            String skinName = ID8LauncherConstants.loadCurrentSkin();
            if (ID8LauncherConstants.ID8_SKIN_SPORT.equals(skinName)) {
                drawableId3 = R.drawable.ksw_id8_btn_selector_red;
            } else if ("blue".equals(skinName)) {
                drawableId3 = R.drawable.ksw_id8_btn_selector_blue;
            } else {
                drawableId3 = R.drawable.ksw_id8_btn_selector_yellow;
            }
            this.id8Binding.appGridView.setSelector(drawableId3);
        }
        if (UiThemeUtils.isUI_EVOID9_ALS(this)) {
            String skinName2 = Id9AlsConstants.loadCurrentSkin();
            if ("2".equals(skinName2)) {
                drawableId2 = R.drawable.ksw_id8_btn_selector_red;
            } else if ("3".equals(skinName2)) {
                drawableId2 = R.drawable.ksw_id8_btn_selector_blue;
            } else if ("4".equals(skinName2)) {
                drawableId2 = R.drawable.ksw_id8_btn_selector_blue;
            } else if (Id9AlsConstants.ID9ALS_SELECT_MODEL_VITALITY.equals(skinName2)) {
                drawableId2 = R.drawable.ksw_id8_btn_selector_blue;
            } else if (Id9AlsConstants.ID9ALS_SELECT_MODEL_MYSTERIOUS.equals(skinName2)) {
                drawableId2 = R.drawable.ksw_id8_btn_selector_blue;
            } else if (Id9AlsConstants.ID9ALS_SELECT_MODEL_STEADY.equals(skinName2)) {
                drawableId2 = R.drawable.ksw_id8_btn_selector_blue;
            } else {
                drawableId2 = R.drawable.id9_app_bg_f;
            }
            this.id9Binding.appGridView.setSelector(drawableId2);
        }
        if (UiThemeUtils.isEVOID8_UG(this)) {
            if (Id8UgConstants.ID8UG_SELECT_MODEL_NIGHT.equals(Id8UgConstants.loadCurrentSkin())) {
                drawableId = R.drawable.ksw_id8_btn_selector_blue;
            } else {
                drawableId = R.drawable.ksw_id8_btn_selector_blue;
            }
            this.evoid8Binding.appGridView.setSelector(drawableId);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        if (UiThemeUtils.isLEXUS_LS_UI(this) || UiThemeUtils.isLEXUS_LS_UI_V2(this)) {
            this.screenHandler.removeMessages(666);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("AppsActivity", "onKeyDown: " + keyCode);
        ActivityId7AppsBinding activityId7AppsBinding = this.binding;
        if (activityId7AppsBinding != null) {
            if (keyCode == 20 || keyCode == 22) {
                return activityId7AppsBinding.appGridView.onKeyUp(22, event);
            }
            if (keyCode == 19 || keyCode == 21) {
                return activityId7AppsBinding.appGridView.onKeyUp(21, event);
            }
            if (keyCode == 66) {
                return activityId7AppsBinding.appGridView.onKeyUp(66, event);
            }
        }
        ActivityAlsId7AppsBinding activityAlsId7AppsBinding = this.alsBinding;
        if (activityAlsId7AppsBinding != null) {
            if (keyCode == 20 || keyCode == 22) {
                return activityAlsId7AppsBinding.appGridView.onKeyUp(22, event);
            }
            if (keyCode == 19 || keyCode == 21) {
                return activityAlsId7AppsBinding.appGridView.onKeyUp(21, event);
            }
            if (keyCode == 66) {
                return activityAlsId7AppsBinding.appGridView.onKeyUp(66, event);
            }
        }
        ActivityId8AppsBinding activityId8AppsBinding = this.id8Binding;
        if (activityId8AppsBinding != null) {
            if (keyCode == 20 || keyCode == 22) {
                return activityId8AppsBinding.appGridView.onKeyUp(22, event);
            }
            if (keyCode == 19 || keyCode == 21) {
                return activityId8AppsBinding.appGridView.onKeyUp(21, event);
            }
            if (keyCode == 66) {
                return activityId8AppsBinding.appGridView.onKeyUp(66, event);
            }
        }
        ActivityId9AppsBinding activityId9AppsBinding = this.id9Binding;
        if (activityId9AppsBinding != null) {
            if (keyCode == 20 || keyCode == 22) {
                return activityId9AppsBinding.appGridView.onKeyUp(22, event);
            }
            if (keyCode == 19 || keyCode == 21) {
                return activityId9AppsBinding.appGridView.onKeyUp(21, event);
            }
            if (keyCode == 66) {
                return activityId9AppsBinding.appGridView.onKeyUp(66, event);
            }
        }
        ActivityEvoid8AppsBinding activityEvoid8AppsBinding = this.evoid8Binding;
        if (activityEvoid8AppsBinding != null) {
            if (keyCode == 20 || keyCode == 22) {
                return activityEvoid8AppsBinding.appGridView.onKeyUp(22, event);
            }
            if (keyCode == 19 || keyCode == 21) {
                return activityEvoid8AppsBinding.appGridView.onKeyUp(21, event);
            }
            if (keyCode == 66) {
                return activityEvoid8AppsBinding.appGridView.onKeyUp(66, event);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}

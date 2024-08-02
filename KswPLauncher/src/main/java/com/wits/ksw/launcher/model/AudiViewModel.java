package com.wits.ksw.launcher.model;

import android.database.ContentObserver;
import android.databinding.Observable;
import android.databinding.ObservableInt;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.LoopRotarySwitchView;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AudiViewModel extends LauncherViewModel {
    public LoopRotarySwitchView.OnItemSelectedListener OnItemSelectedListener;
    private final int RIGHT_UI_CARINFO;
    private final int RIGHT_UI_LOGO_AND_NAVI;
    private final int RIGHT_UI_LOGO_ONLY;
    private final int RIGHT_UI_MEDIA;
    private final int RIGHT_UI_NOTHING;
    public ObservableInt carBgPicId;
    public ObservableInt carInfoView;
    private int[] carPic;
    public ObservableInt carPicId;
    private int defaultLeftId;
    private int defaultRightId;
    private int leftUiId;
    private List<ObservableInt> listShowView;
    public ObservableInt logoView;
    public ObservableInt mediaView;
    public ObservableInt noView;
    public LoopRotarySwitchView.OnItemClickListener onItemClickListener;
    Observable.OnPropertyChangedCallback onPropertyChangedCallback;
    private int rightUiId;

    public AudiViewModel() {
        this.defaultLeftId = 1;
        this.defaultRightId = 0;
        this.leftUiId = 0;
        this.rightUiId = 0;
        this.carPicId = new ObservableInt();
        this.carBgPicId = new ObservableInt();
        this.carPic = new int[]{0, R.drawable.audi_left_car_a4, R.drawable.audi_left_car_a4_old, R.drawable.audi_left_car_a4l, R.drawable.audi_left_car_a3, R.drawable.audi_left_car_a5, R.drawable.audi_left_car_a6, R.drawable.audi_left_car_q3, R.drawable.audi_left_car_q5, R.drawable.audi_left_car_q7};
        this.noView = new ObservableInt();
        this.logoView = new ObservableInt();
        this.carInfoView = new ObservableInt();
        this.mediaView = new ObservableInt();
        this.RIGHT_UI_NOTHING = 0;
        this.RIGHT_UI_LOGO_AND_NAVI = 1;
        this.RIGHT_UI_LOGO_ONLY = 2;
        this.RIGHT_UI_CARINFO = 3;
        this.RIGHT_UI_MEDIA = 4;
        this.listShowView = new ArrayList();
        this.onItemClickListener = new LoopRotarySwitchView.OnItemClickListener() {
            /* class com.wits.ksw.launcher.model.AudiViewModel.AnonymousClass3 */

            @Override // com.wits.ksw.launcher.view.LoopRotarySwitchView.OnItemClickListener
            public void onItemClick(int item, View view) {
                AudiViewModel.this.onClick(view);
            }
        };
        this.OnItemSelectedListener = new LoopRotarySwitchView.OnItemSelectedListener() {
            /* class com.wits.ksw.launcher.model.AudiViewModel.AnonymousClass4 */

            @Override // com.wits.ksw.launcher.view.LoopRotarySwitchView.OnItemSelectedListener
            public void selected(int item, View view) {
                AudiViewModel.this.refreshCarBgPic(view);
            }
        };
        this.onPropertyChangedCallback = new Observable.OnPropertyChangedCallback() {
            /* class com.wits.ksw.launcher.model.AudiViewModel.AnonymousClass5 */

            @Override // android.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (AudiViewModel.this.rightUiId != 1) {
                    return;
                }
                if (AudiViewModel.this.naviInfo.showGuideView.get() == 8) {
                    AudiViewModel.this.logoView.set(0);
                } else {
                    AudiViewModel.this.logoView.set(8);
                }
            }
        };
        this.listShowView = Arrays.asList(this.noView, this.naviInfo.showGuideView, this.logoView, this.carInfoView, this.mediaView);
        this.naviInfo.showGuideView.addOnPropertyChangedCallback(this.onPropertyChangedCallback);
        initLeftUi();
        initRightUi();
        this.context.getContentResolver().registerContentObserver(Settings.System.getUriFor(KeyConfig.AUDI_UI_LEFT_ID), false, new ContentObserver(new Handler()) {
            /* class com.wits.ksw.launcher.model.AudiViewModel.AnonymousClass1 */

            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                AudiViewModel.this.initLeftUi();
            }
        });
        this.context.getContentResolver().registerContentObserver(Settings.System.getUriFor(KeyConfig.AUDI_UI_RIGHT_ID), false, new ContentObserver(new Handler()) {
            /* class com.wits.ksw.launcher.model.AudiViewModel.AnonymousClass2 */

            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                AudiViewModel.this.initRightUi();
            }
        });
    }

    public void initLeftUi() {
        int i = Settings.System.getInt(this.context.getContentResolver(), KeyConfig.AUDI_UI_LEFT_ID, this.defaultLeftId);
        this.leftUiId = i;
        if (i >= 0) {
            int[] iArr = this.carPic;
            if (i < iArr.length) {
                this.carPicId.set(iArr[i]);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initRightUi() {
        int i = Settings.System.getInt(this.context.getContentResolver(), KeyConfig.AUDI_UI_RIGHT_ID, this.defaultRightId);
        this.rightUiId = i;
        setRightUi(i);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_apps /*{ENCODED_INT: 2131232470}*/:
                openApps(view);
                break;
            case R.id.rl_bt /*{ENCODED_INT: 2131232471}*/:
                openBtApp(view);
                break;
            case R.id.rl_car /*{ENCODED_INT: 2131232472}*/:
                openCar(view);
                break;
            case R.id.rl_dashboard /*{ENCODED_INT: 2131232474}*/:
                openDashboard(view);
                break;
            case R.id.rl_dvr /*{ENCODED_INT: 2131232475}*/:
                openDvr(view);
                break;
            case R.id.rl_easyconnection /*{ENCODED_INT: 2131232476}*/:
                openShouJiHuLian(view);
                break;
            case R.id.rl_music /*{ENCODED_INT: 2131232478}*/:
                openMusicMulti(view);
                break;
            case R.id.rl_navi /*{ENCODED_INT: 2131232479}*/:
                openNaviApp(view);
                break;
            case R.id.rl_settings /*{ENCODED_INT: 2131232480}*/:
                openSettings(view);
                break;
            case R.id.rl_video /*{ENCODED_INT: 2131232481}*/:
                openVideoMulti(view);
                break;
        }
        refreshCarBgPic(view);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void refreshCarBgPic(View view) {
        switch (view.getId()) {
            case R.id.rl_apps /*{ENCODED_INT: 2131232470}*/:
                this.carBgPicId.set(R.drawable.audi_left_bk_app);
                return;
            case R.id.rl_bt /*{ENCODED_INT: 2131232471}*/:
                this.carBgPicId.set(R.drawable.audi_left_bk_bt);
                return;
            case R.id.rl_car /*{ENCODED_INT: 2131232472}*/:
                this.carBgPicId.set(R.drawable.audi_left_bk_car);
                return;
            case R.id.rl_contain /*{ENCODED_INT: 2131232473}*/:
            case R.id.rl_modus_container /*{ENCODED_INT: 2131232477}*/:
            default:
                return;
            case R.id.rl_dashboard /*{ENCODED_INT: 2131232474}*/:
                this.carBgPicId.set(R.drawable.audi_left_bk_dashboard);
                return;
            case R.id.rl_dvr /*{ENCODED_INT: 2131232475}*/:
                this.carBgPicId.set(R.drawable.audi_left_bk_dvr);
                return;
            case R.id.rl_easyconnection /*{ENCODED_INT: 2131232476}*/:
                this.carBgPicId.set(R.drawable.audi_left_bk_easyconnection);
                return;
            case R.id.rl_music /*{ENCODED_INT: 2131232478}*/:
                this.carBgPicId.set(R.drawable.audi_left_bk_music);
                return;
            case R.id.rl_navi /*{ENCODED_INT: 2131232479}*/:
            case R.id.rl_video /*{ENCODED_INT: 2131232481}*/:
                this.carBgPicId.set(R.drawable.audi_left_bk_navi);
                return;
            case R.id.rl_settings /*{ENCODED_INT: 2131232480}*/:
                this.carBgPicId.set(R.drawable.audi_left_bk_settings);
                return;
        }
    }

    private void setRightUi(int ui) {
        this.rightUiId = ui;
        for (int i = 0; i < this.listShowView.size(); i++) {
            if (ui == i) {
                this.listShowView.get(i).set(0);
            } else {
                this.listShowView.get(i).set(8);
            }
        }
        if (ui == 1) {
            this.listShowView.get(1).set(8);
            this.listShowView.get(2).set(0);
            this.naviInfo.setShowGuideEnable(true);
            return;
        }
        this.naviInfo.setShowGuideEnable(false);
    }

    /* access modifiers changed from: protected */
    @Override // android.arch.lifecycle.ViewModel, com.wits.ksw.launcher.base.BaseViewModel, com.wits.ksw.launcher.model.LauncherViewModel
    public void onCleared() {
        super.onCleared();
        if (this.onPropertyChangedCallback != null) {
            this.naviInfo.showGuideView.removeOnPropertyChangedCallback(this.onPropertyChangedCallback);
        }
        if (this.otherReceiver != null) {
            this.context.unregisterReceiver(this.otherReceiver);
        }
    }
}

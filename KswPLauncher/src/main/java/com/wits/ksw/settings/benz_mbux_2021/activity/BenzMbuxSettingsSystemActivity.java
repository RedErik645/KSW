package com.wits.ksw.settings.benz_mbux_2021.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityBenzMbuxSettingsSystemLayoutBinding;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.launcher.utils.ScreenUtil;
import com.wits.ksw.settings.BaseSkinActivity;
import com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemAuxLay;
import com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemBrightnessLay;
import com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemCameraLay;
import com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemFuelLay;
import com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemLanguageLay;
import com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemMusicLay;
import com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemTempLay;
import com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemTimeLay;
import com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemVideoLay;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BenzMbuxSettingsSystemActivity extends BaseSkinActivity implements View.OnClickListener {
    private final String TAG = "BenzMbuxSettingsSystemActivity";
    private int[] isSecondViewId = {R.id.mbux_settings_system_time, R.id.mbux_settings_system_language, R.id.mbux_settings_system_camera, R.id.mbux_settings_system_brightness, R.id.mbux_settings_system_temp, R.id.mbux_settings_system_fuel, R.id.mbux_settings_system_music, R.id.mbux_settings_system_video};
    private BenzMbuxSettingsSystemAuxLay mAuxLay;
    private ActivityBenzMbuxSettingsSystemLayoutBinding mBinding;
    private BenzMbuxSettingsSystemBrightnessLay mBrightnessLay;
    private BenzMbuxSettingsSystemCameraLay mCameraLay;
    private CountDownTimer mCountDownTimer;
    private BenzMbuxSettingsSystemFuelLay mFuelLay;
    private BenzMbuxSettingsSystemLanguageLay mLanguageLay;
    private BenzMbuxSettingsSystemMusicLay mMusicLay;
    private int mOffset = ScreenUtil.dip2px(4.0f);
    private BenzMbuxSettingsSystemTempLay mTempLay;
    private BenzMbuxSettingsSystemTimeLay mTimeLay;
    private BenzMbuxSettingsSystemVideoLay mVideoLay;
    private BenzMbuxSettingsViewModel mViewModel;
    private int nbauxsw = 0;
    private int[] relativeLayoutId = {R.id.mbux_settings_system_mirror, R.id.mbux_settings_system_motion, R.id.mbux_settings_system_lines, R.id.mbux_settings_system_radar, R.id.mbux_settings_system_mute, R.id.mbux_settings_system_time, R.id.mbux_settings_system_language, R.id.mbux_settings_system_camera, R.id.mbux_settings_system_aux, R.id.mbux_settings_system_brightness, R.id.mbux_settings_system_temp, R.id.mbux_settings_system_fuel, R.id.mbux_settings_system_music, R.id.mbux_settings_system_video};
    private int scrollActualHeight;

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseSkinActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BenzMbuxSettingsSystemActivity", " onCreate ");
        this.mBinding = (ActivityBenzMbuxSettingsSystemLayoutBinding) DataBindingUtil.setContentView(this, R.layout.activity_benz_mbux_settings_system_layout);
        BenzMbuxSettingsViewModel instance = BenzMbuxSettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        initView();
    }

    private void initView() {
        try {
            this.mTimeLay = new BenzMbuxSettingsSystemTimeLay(this);
            this.mLanguageLay = new BenzMbuxSettingsSystemLanguageLay(this);
            this.mCameraLay = new BenzMbuxSettingsSystemCameraLay(this);
            this.mAuxLay = new BenzMbuxSettingsSystemAuxLay(this);
            this.mBrightnessLay = new BenzMbuxSettingsSystemBrightnessLay(this);
            this.mTempLay = new BenzMbuxSettingsSystemTempLay(this);
            this.mFuelLay = new BenzMbuxSettingsSystemFuelLay(this);
            this.mMusicLay = new BenzMbuxSettingsSystemMusicLay(this);
            this.mVideoLay = new BenzMbuxSettingsSystemVideoLay(this);
            int settingsInt = PowerManagerApp.getSettingsInt(KeyConfig.NBT_AUX_SW);
            this.nbauxsw = settingsInt;
            boolean z = false;
            if (settingsInt == 3) {
                this.mBinding.mbuxSettingsSystemAux.setVisibility(0);
            } else {
                this.mBinding.mbuxSettingsSystemAux.setVisibility(8);
            }
            int i = 0;
            while (true) {
                int[] iArr = this.relativeLayoutId;
                if (i >= iArr.length) {
                    break;
                }
                findViewById(iArr[i]).setOnClickListener(this);
                findViewById(this.relativeLayoutId[i]).setOnTouchListener(new View.OnTouchListener() {
                    /* class com.wits.ksw.settings.benz_mbux_2021.activity.BenzMbuxSettingsSystemActivity.AnonymousClass1 */

                    public boolean onTouch(View v, MotionEvent event) {
                        Log.i("BenzMbuxSettingsSystemActivity", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
                        if (event.getAction() != 1 || v.isFocused()) {
                            return false;
                        }
                        v.requestFocus();
                        return false;
                    }
                });
                i++;
            }
            this.mViewModel.rearMirror.set(PowerManagerApp.getSettingsInt(KeyConfig.HOU_SHI_SX) != 0);
            this.mViewModel.disableVideo.set(PowerManagerApp.getSettingsInt(KeyConfig.XING_CHE_JZSP) != 0);
            this.mViewModel.parkLines.set(PowerManagerApp.getSettingsInt(KeyConfig.DAO_CHE_GJ) != 0);
            this.mViewModel.parkRadar.set(PowerManagerApp.getSettingsInt(KeyConfig.DAO_CHE_LD) != 0);
            ObservableBoolean observableBoolean = this.mViewModel.parkMute;
            if (PowerManagerApp.getSettingsInt(KeyConfig.DAO_CHE_JY) != 0) {
                z = true;
            }
            observableBoolean.set(z);
            this.mBinding.getRoot().getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
                /* class com.wits.ksw.settings.benz_mbux_2021.activity.BenzMbuxSettingsSystemActivity.AnonymousClass2 */

                public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                    Log.i("BenzMbuxSettingsSystemActivity", "onGlobalFocusChanged: " + BenzMbuxSettingsSystemActivity.this.mBinding.mbuxSettingsSystemScroll.hasFocus());
                    if (BenzMbuxSettingsSystemActivity.this.mBinding.mbuxSettingsSystemScroll.hasFocus()) {
                        BenzMbuxSettingsSystemActivity.this.mViewModel.systemBgShow.set(true);
                    }
                    if (newFocus != null && BenzMbuxSettingsSystemActivity.this.isSecondId(newFocus.getId())) {
                        newFocus.setFocusableInTouchMode(true);
                    }
                    if (oldFocus != null && BenzMbuxSettingsSystemActivity.this.isSecondId(oldFocus.getId())) {
                        oldFocus.setFocusableInTouchMode(false);
                    }
                }
            });
            this.mBinding.mbuxSettingsSystemScroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                /* class com.wits.ksw.settings.benz_mbux_2021.activity.BenzMbuxSettingsSystemActivity.AnonymousClass3 */

                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    Log.i("BenzMbuxSettingsSystemActivity", " onScrollChange oldScrollY " + oldScrollY + " scrollY " + scrollY);
                    BenzMbuxSettingsSystemActivity.this.startCount();
                }
            });
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("BenzMbuxSettingsSystemActivity", " onNewIntent ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i("BenzMbuxSettingsSystemActivity", " onResume ");
        initData();
    }

    private void initData() {
        try {
            selectLayout(null, 0);
            this.mViewModel.systemBgShow.set(true);
            this.mBinding.mbuxSettingsSystemScroll.scrollTo(0, 0);
            if (getCurrentFocus() == null) {
                this.mBinding.mbuxSettingsSystemMirror.requestFocus();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mbux_settings_system_aux /*{ENCODED_INT: 2131232069}*/:
                selectLayout(this.mAuxLay, v.getId());
                this.mAuxLay.requestFocus();
                return;
            case R.id.mbux_settings_system_brightness /*{ENCODED_INT: 2131232070}*/:
                selectLayout(this.mBrightnessLay, v.getId());
                this.mBrightnessLay.requestFocus();
                return;
            case R.id.mbux_settings_system_camera /*{ENCODED_INT: 2131232071}*/:
                selectLayout(this.mCameraLay, v.getId());
                this.mCameraLay.requestFocus();
                return;
            case R.id.mbux_settings_system_fuel /*{ENCODED_INT: 2131232078}*/:
                selectLayout(this.mFuelLay, v.getId());
                this.mFuelLay.requestFocus();
                return;
            case R.id.mbux_settings_system_language /*{ENCODED_INT: 2131232083}*/:
                selectLayout(this.mLanguageLay, v.getId());
                this.mLanguageLay.requestFocus();
                return;
            case R.id.mbux_settings_system_lines /*{ENCODED_INT: 2131232084}*/:
                this.mViewModel.parkLines.set(!this.mViewModel.parkLines.get());
                FileUtils.savaData(KeyConfig.DAO_CHE_GJ, this.mViewModel.parkLines.get());
                selectLayout(null, 0);
                return;
            case R.id.mbux_settings_system_mirror /*{ENCODED_INT: 2131232085}*/:
                this.mViewModel.rearMirror.set(!this.mViewModel.rearMirror.get());
                FileUtils.savaData(KeyConfig.HOU_SHI_SX, this.mViewModel.rearMirror.get());
                selectLayout(null, 0);
                return;
            case R.id.mbux_settings_system_motion /*{ENCODED_INT: 2131232086}*/:
                this.mViewModel.disableVideo.set(!this.mViewModel.disableVideo.get());
                FileUtils.savaData(KeyConfig.XING_CHE_JZSP, this.mViewModel.disableVideo.get());
                selectLayout(null, 0);
                return;
            case R.id.mbux_settings_system_music /*{ENCODED_INT: 2131232087}*/:
                selectLayout(this.mMusicLay, v.getId());
                this.mMusicLay.requestFocus();
                return;
            case R.id.mbux_settings_system_mute /*{ENCODED_INT: 2131232088}*/:
                this.mViewModel.parkMute.set(!this.mViewModel.parkMute.get());
                FileUtils.savaData(KeyConfig.DAO_CHE_JY, this.mViewModel.parkMute.get());
                selectLayout(null, 0);
                return;
            case R.id.mbux_settings_system_radar /*{ENCODED_INT: 2131232089}*/:
                this.mViewModel.parkRadar.set(!this.mViewModel.parkRadar.get());
                FileUtils.savaData(KeyConfig.DAO_CHE_LD, this.mViewModel.parkRadar.get());
                selectLayout(null, 0);
                return;
            case R.id.mbux_settings_system_temp /*{ENCODED_INT: 2131232091}*/:
                selectLayout(this.mTempLay, v.getId());
                this.mTempLay.requestFocus();
                return;
            case R.id.mbux_settings_system_time /*{ENCODED_INT: 2131232095}*/:
                selectLayout(this.mTimeLay, v.getId());
                this.mTimeLay.requestFocus();
                return;
            case R.id.mbux_settings_system_video /*{ENCODED_INT: 2131232097}*/:
                selectLayout(this.mVideoLay, v.getId());
                this.mVideoLay.requestFocus();
                return;
            default:
                return;
        }
    }

    private void selectLayout(View view, int viewId) {
        try {
            Log.i("BenzMbuxSettingsSystemActivity", "selectLayout view " + view + " viewId " + viewId);
            this.mBinding.mbuxSettingsSystemFramelay.removeAllViews();
            int i = 0;
            while (true) {
                int[] iArr = this.relativeLayoutId;
                if (i >= iArr.length) {
                    break;
                }
                if (viewId == iArr[i]) {
                    findViewById(iArr[i]).setSelected(true);
                } else {
                    findViewById(iArr[i]).setSelected(false);
                }
                i++;
            }
            if (view != null) {
                this.mBinding.mbuxSettingsSystemFramelay.addView(view);
                this.mViewModel.systemIconShow.set(false);
                return;
            }
            this.mViewModel.systemIconShow.set(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        int action = event.getAction();
        View view = getCurrentFocus();
        Log.i("BenzMbuxSettingsSystemActivity", "dispatchKeyEvent keyCode " + keyCode + " action " + action);
        switch (action) {
            case 0:
                if (event.getKeyCode() == 21 && view != null && this.mBinding.mbuxSettingsSystemScroll.hasFocus()) {
                    Log.i("BenzMbuxSettingsSystemActivity", "dispatchKeyEvent ACTION_DOWN focusView " + view.toString() + " view.isFocused() " + view.isFocused());
                    KswUtils.sendKeyDownUpSync(4);
                    return true;
                }
        }
        return super.dispatchKeyEvent(event);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isSecondId(int viewId) {
        int i = 0;
        while (true) {
            try {
                int[] iArr = this.isSecondViewId;
                if (i >= iArr.length) {
                    return false;
                }
                if (viewId == iArr[i]) {
                    return true;
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public CountDownTimer getCountDownTimer() {
        try {
            if (this.mCountDownTimer == null) {
                this.mCountDownTimer = new CountDownTimer(100, 50) {
                    /* class com.wits.ksw.settings.benz_mbux_2021.activity.BenzMbuxSettingsSystemActivity.AnonymousClass4 */

                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        int scrolly = BenzMbuxSettingsSystemActivity.this.mBinding.mbuxSettingsSystemScroll.getScrollY();
                        if (BenzMbuxSettingsSystemActivity.this.mBinding.mbuxSettingsSystemScroll.hasFocus()) {
                            int focusIndex = ((LinearLayout) BenzMbuxSettingsSystemActivity.this.mBinding.mbuxSettingsSystemScroll.getChildAt(0)).indexOfChild(BenzMbuxSettingsSystemActivity.this.mBinding.mbuxSettingsSystemScroll.findFocus());
                            Log.e("BenzMbuxSettingsSystemActivity", "onFinish: scrolly " + scrolly + " focusIndex " + focusIndex);
                            if (focusIndex >= 0) {
                                int itemHeight = BenzMbuxSettingsSystemActivity.this.mBinding.mbuxSettingsSystemMirror.getHeight() - BenzMbuxSettingsSystemActivity.this.mOffset;
                                int scrollHeight = BenzMbuxSettingsSystemActivity.this.mBinding.mbuxSettingsSystemScroll.getHeight() + scrolly;
                                BenzMbuxSettingsSystemActivity benzMbuxSettingsSystemActivity = BenzMbuxSettingsSystemActivity.this;
                                benzMbuxSettingsSystemActivity.scrollActualHeight = ((LinearLayout) benzMbuxSettingsSystemActivity.mBinding.mbuxSettingsSystemScroll.getChildAt(0)).getBottom();
                                int focusViewHeight = (focusIndex + 1) * itemHeight;
                                int focusViewHeight2 = focusViewHeight > BenzMbuxSettingsSystemActivity.this.scrollActualHeight ? BenzMbuxSettingsSystemActivity.this.scrollActualHeight : focusViewHeight;
                                Log.e("BenzMbuxSettingsSystemActivity", "onFinish: focusViewHeight " + focusViewHeight2 + " itemHeight " + itemHeight + " scrollHeight " + scrollHeight);
                                if (focusViewHeight2 < scrolly || (focusViewHeight2 - itemHeight) + BenzMbuxSettingsSystemActivity.this.mOffset > scrollHeight) {
                                    int refresIndex = (int) Math.ceil((double) ((((float) scrolly) * 1.0f) / ((float) BenzMbuxSettingsSystemActivity.this.mBinding.mbuxSettingsSystemMirror.getHeight())));
                                    Log.e("BenzMbuxSettingsSystemActivity", "onFinish: refresIndex " + refresIndex);
                                    View focusView = ((LinearLayout) BenzMbuxSettingsSystemActivity.this.mBinding.mbuxSettingsSystemScroll.getChildAt(0)).getChildAt(refresIndex);
                                    focusView.setFocusableInTouchMode(true);
                                    focusView.requestFocus();
                                }
                            }
                        }
                    }
                };
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.mCountDownTimer;
    }

    public void startCount() {
        getCountDownTimer().cancel();
        getCountDownTimer().start();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        Log.i("BenzMbuxSettingsSystemActivity", " onPause ");
        getCountDownTimer().cancel();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i("BenzMbuxSettingsSystemActivity", " onStop ");
        getCountDownTimer().cancel();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("BenzMbuxSettingsSystemActivity", " onDestroy ");
    }
}

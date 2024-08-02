package com.wits.ksw.settings.bmw_id9.activity;

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
import com.wits.ksw.databinding.ActivityBmwId9SettingsSystemLayoutBinding;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.launcher.utils.ScreenUtil;
import com.wits.ksw.settings.BaseSkinActivity;
import com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemBrightnessLay;
import com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemCameraLay;
import com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemFuelLay;
import com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemLanguageLay;
import com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemMusicLay;
import com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemTempLay;
import com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemTimeLay;
import com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemVideoLay;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BmwId9SettingsSystemActivity extends BaseSkinActivity implements View.OnClickListener {
    private final String TAG = "BmwId9SettingsSystemActivity";
    private int[] isSecondViewId = {R.id.bmw_id9_settings_system_time, R.id.bmw_id9_settings_system_language, R.id.bmw_id9_settings_system_camera, R.id.bmw_id9_settings_system_brightness, R.id.bmw_id9_settings_system_temp, R.id.bmw_id9_settings_system_fuel, R.id.bmw_id9_settings_system_music, R.id.bmw_id9_settings_system_video};
    private ActivityBmwId9SettingsSystemLayoutBinding mBinding;
    private BmwId9SettingsSystemBrightnessLay mBrightnessLay;
    private BmwId9SettingsSystemCameraLay mCameraLay;
    private CountDownTimer mCountDownTimer;
    private BmwId9SettingsSystemFuelLay mFuelLay;
    private BmwId9SettingsSystemLanguageLay mLanguageLay;
    private BmwId9SettingsSystemMusicLay mMusicLay;
    private int mOffset = ScreenUtil.dip2px(4.0f);
    private BmwId9SettingsSystemTempLay mTempLay;
    private BmwId9SettingsSystemTimeLay mTimeLay;
    private BmwId9SettingsSystemVideoLay mVideoLay;
    private BmwId9SettingsViewModel mViewModel;
    private int[] relativeLayoutId = {R.id.bmw_id9_settings_system_mirror, R.id.bmw_id9_settings_system_motion, R.id.bmw_id9_settings_system_lines, R.id.bmw_id9_settings_system_radar, R.id.bmw_id9_settings_system_mute, R.id.bmw_id9_settings_system_time, R.id.bmw_id9_settings_system_language, R.id.bmw_id9_settings_system_camera, R.id.bmw_id9_settings_system_brightness, R.id.bmw_id9_settings_system_temp, R.id.bmw_id9_settings_system_fuel, R.id.bmw_id9_settings_system_music, R.id.bmw_id9_settings_system_video};
    private int scrollActualHeight;

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseSkinActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BmwId9SettingsSystemActivity", " onCreate ");
        this.mBinding = (ActivityBmwId9SettingsSystemLayoutBinding) DataBindingUtil.setContentView(this, R.layout.activity_bmw_id9_settings_system_layout);
        BmwId9SettingsViewModel instance = BmwId9SettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        initView();
    }

    private void initView() {
        try {
            this.mTimeLay = new BmwId9SettingsSystemTimeLay(this);
            this.mLanguageLay = new BmwId9SettingsSystemLanguageLay(this);
            this.mCameraLay = new BmwId9SettingsSystemCameraLay(this);
            this.mBrightnessLay = new BmwId9SettingsSystemBrightnessLay(this);
            this.mTempLay = new BmwId9SettingsSystemTempLay(this);
            this.mFuelLay = new BmwId9SettingsSystemFuelLay(this);
            this.mMusicLay = new BmwId9SettingsSystemMusicLay(this);
            this.mVideoLay = new BmwId9SettingsSystemVideoLay(this);
            int i = 0;
            while (true) {
                int[] iArr = this.relativeLayoutId;
                if (i >= iArr.length) {
                    break;
                }
                findViewById(iArr[i]).setOnClickListener(this);
                findViewById(this.relativeLayoutId[i]).setOnTouchListener(new View.OnTouchListener() {
                    /* class com.wits.ksw.settings.bmw_id9.activity.BmwId9SettingsSystemActivity.AnonymousClass1 */

                    public boolean onTouch(View v, MotionEvent event) {
                        Log.i("BmwId9SettingsSystemActivity", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
                        if (event.getAction() != 1 || v.isFocused()) {
                            return false;
                        }
                        v.requestFocus();
                        return false;
                    }
                });
                i++;
            }
            boolean z = false;
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
                /* class com.wits.ksw.settings.bmw_id9.activity.BmwId9SettingsSystemActivity.AnonymousClass2 */

                public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                    Log.i("BmwId9SettingsSystemActivity", "onGlobalFocusChanged: " + BmwId9SettingsSystemActivity.this.mBinding.bmwId9SettingsSystemScroll.hasFocus());
                    if (BmwId9SettingsSystemActivity.this.mBinding.bmwId9SettingsSystemScroll.hasFocus()) {
                        BmwId9SettingsSystemActivity.this.mViewModel.systemBgShow.set(true);
                    }
                    if (newFocus != null && BmwId9SettingsSystemActivity.this.isSecondId(newFocus.getId())) {
                        newFocus.setFocusableInTouchMode(true);
                    }
                    if (oldFocus != null && BmwId9SettingsSystemActivity.this.isSecondId(oldFocus.getId())) {
                        oldFocus.setFocusableInTouchMode(false);
                    }
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
        Log.i("BmwId9SettingsSystemActivity", " onNewIntent ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i("BmwId9SettingsSystemActivity", " onResume ");
        initData();
    }

    private void initData() {
        try {
            selectLayout(null, 0);
            this.mViewModel.systemBgShow.set(true);
            this.mBinding.bmwId9SettingsSystemScroll.scrollTo(0, 0);
            if (getCurrentFocus() == null) {
                this.mBinding.bmwId9SettingsSystemMirror.requestFocus();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bmw_id9_settings_system_brightness /*{ENCODED_INT: 2131231205}*/:
                this.mViewModel.systemBgShow.set(false);
                selectLayout(this.mBrightnessLay, v.getId());
                this.mBrightnessLay.requestFocus();
                return;
            case R.id.bmw_id9_settings_system_camera /*{ENCODED_INT: 2131231206}*/:
                this.mViewModel.systemBgShow.set(false);
                selectLayout(this.mCameraLay, v.getId());
                this.mCameraLay.requestFocus();
                return;
            case R.id.bmw_id9_settings_system_fuel /*{ENCODED_INT: 2131231213}*/:
                this.mViewModel.systemBgShow.set(false);
                selectLayout(this.mFuelLay, v.getId());
                this.mFuelLay.requestFocus();
                return;
            case R.id.bmw_id9_settings_system_language /*{ENCODED_INT: 2131231218}*/:
                this.mViewModel.systemBgShow.set(false);
                selectLayout(this.mLanguageLay, v.getId());
                this.mLanguageLay.requestFocus();
                return;
            case R.id.bmw_id9_settings_system_lines /*{ENCODED_INT: 2131231219}*/:
                this.mViewModel.parkLines.set(!this.mViewModel.parkLines.get());
                FileUtils.savaData(KeyConfig.DAO_CHE_GJ, this.mViewModel.parkLines.get());
                selectLayout(null, 0);
                return;
            case R.id.bmw_id9_settings_system_mirror /*{ENCODED_INT: 2131231220}*/:
                this.mViewModel.rearMirror.set(!this.mViewModel.rearMirror.get());
                FileUtils.savaData(KeyConfig.HOU_SHI_SX, this.mViewModel.rearMirror.get());
                selectLayout(null, 0);
                return;
            case R.id.bmw_id9_settings_system_motion /*{ENCODED_INT: 2131231221}*/:
                this.mViewModel.disableVideo.set(!this.mViewModel.disableVideo.get());
                FileUtils.savaData(KeyConfig.XING_CHE_JZSP, this.mViewModel.disableVideo.get());
                selectLayout(null, 0);
                return;
            case R.id.bmw_id9_settings_system_music /*{ENCODED_INT: 2131231222}*/:
                this.mViewModel.systemBgShow.set(false);
                selectLayout(this.mMusicLay, v.getId());
                this.mMusicLay.requestFocus();
                return;
            case R.id.bmw_id9_settings_system_mute /*{ENCODED_INT: 2131231223}*/:
                this.mViewModel.parkMute.set(!this.mViewModel.parkMute.get());
                FileUtils.savaData(KeyConfig.DAO_CHE_JY, this.mViewModel.parkMute.get());
                selectLayout(null, 0);
                return;
            case R.id.bmw_id9_settings_system_radar /*{ENCODED_INT: 2131231224}*/:
                this.mViewModel.parkRadar.set(!this.mViewModel.parkRadar.get());
                FileUtils.savaData(KeyConfig.DAO_CHE_LD, this.mViewModel.parkRadar.get());
                selectLayout(null, 0);
                return;
            case R.id.bmw_id9_settings_system_temp /*{ENCODED_INT: 2131231226}*/:
                this.mViewModel.systemBgShow.set(false);
                selectLayout(this.mTempLay, v.getId());
                this.mTempLay.requestFocus();
                return;
            case R.id.bmw_id9_settings_system_time /*{ENCODED_INT: 2131231230}*/:
                this.mViewModel.systemBgShow.set(false);
                selectLayout(this.mTimeLay, v.getId());
                this.mTimeLay.requestFocus();
                return;
            case R.id.bmw_id9_settings_system_video /*{ENCODED_INT: 2131231232}*/:
                this.mViewModel.systemBgShow.set(false);
                selectLayout(this.mVideoLay, v.getId());
                this.mVideoLay.requestFocus();
                return;
            default:
                return;
        }
    }

    private void selectLayout(View view, int viewId) {
        try {
            Log.i("BmwId9SettingsSystemActivity", "selectLayout view " + view + " viewId " + viewId);
            this.mBinding.bmwId9SettingsSystemFramelay.removeAllViews();
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
                this.mBinding.bmwId9SettingsSystemFramelay.addView(view);
                this.mViewModel.systemIconShow.set(false);
                return;
            }
            this.mViewModel.systemBgShow.set(true);
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
        Log.i("BmwId9SettingsSystemActivity", "dispatchKeyEvent keyCode " + keyCode + " action " + action);
        switch (action) {
            case 0:
                if (event.getKeyCode() == 21 && view != null && this.mBinding.bmwId9SettingsSystemScroll.hasFocus()) {
                    Log.i("BmwId9SettingsSystemActivity", "dispatchKeyEvent ACTION_DOWN focusView " + view.toString() + " view.isFocused() " + view.isFocused());
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
                    /* class com.wits.ksw.settings.bmw_id9.activity.BmwId9SettingsSystemActivity.AnonymousClass3 */

                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        int scrolly = BmwId9SettingsSystemActivity.this.mBinding.bmwId9SettingsSystemScroll.getScrollY();
                        if (BmwId9SettingsSystemActivity.this.mBinding.bmwId9SettingsSystemScroll.hasFocus()) {
                            int focusIndex = ((LinearLayout) BmwId9SettingsSystemActivity.this.mBinding.bmwId9SettingsSystemScroll.getChildAt(0)).indexOfChild(BmwId9SettingsSystemActivity.this.mBinding.bmwId9SettingsSystemScroll.findFocus());
                            Log.e("BmwId9SettingsSystemActivity", "onFinish: scrolly " + scrolly + " focusIndex " + focusIndex);
                            if (focusIndex >= 0) {
                                int itemHeight = BmwId9SettingsSystemActivity.this.mBinding.bmwId9SettingsSystemMirror.getHeight() - BmwId9SettingsSystemActivity.this.mOffset;
                                int scrollHeight = BmwId9SettingsSystemActivity.this.mBinding.bmwId9SettingsSystemScroll.getHeight() + scrolly;
                                BmwId9SettingsSystemActivity bmwId9SettingsSystemActivity = BmwId9SettingsSystemActivity.this;
                                bmwId9SettingsSystemActivity.scrollActualHeight = ((LinearLayout) bmwId9SettingsSystemActivity.mBinding.bmwId9SettingsSystemScroll.getChildAt(0)).getBottom();
                                int focusViewHeight = (focusIndex + 1) * itemHeight;
                                int focusViewHeight2 = focusViewHeight > BmwId9SettingsSystemActivity.this.scrollActualHeight ? BmwId9SettingsSystemActivity.this.scrollActualHeight : focusViewHeight;
                                Log.e("BmwId9SettingsSystemActivity", "onFinish: focusViewHeight " + focusViewHeight2 + " itemHeight " + itemHeight + " scrollHeight " + scrollHeight);
                                if (focusViewHeight2 < scrolly || (focusViewHeight2 - itemHeight) + BmwId9SettingsSystemActivity.this.mOffset > scrollHeight) {
                                    int refresIndex = (int) Math.ceil((double) ((((float) scrolly) * 1.0f) / ((float) BmwId9SettingsSystemActivity.this.mBinding.bmwId9SettingsSystemMirror.getHeight())));
                                    Log.e("BmwId9SettingsSystemActivity", "onFinish: refresIndex " + refresIndex);
                                    View focusView = ((LinearLayout) BmwId9SettingsSystemActivity.this.mBinding.bmwId9SettingsSystemScroll.getChildAt(0)).getChildAt(refresIndex);
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
        Log.i("BmwId9SettingsSystemActivity", " onPause ");
        getCountDownTimer().cancel();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i("BmwId9SettingsSystemActivity", " onStop ");
        getCountDownTimer().cancel();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("BmwId9SettingsSystemActivity", " onDestroy ");
    }
}

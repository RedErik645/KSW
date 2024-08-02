package com.wits.ksw.settings.benz_mbux_2021.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityBenzMbuxSettingsAudioLayoutBinding;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.settings.BaseSkinActivity;
import com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsAudioAndroidLay;
import com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsAudioOEMLay;
import com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsAudioSoundLay;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public class BenzMbuxSettingsAudioActivity extends BaseSkinActivity implements View.OnClickListener {
    private final String TAG = "BenzMbuxSettingsAudioActivity";
    private BenzMbuxSettingsAudioAndroidLay mAudioAndroidLay;
    private BenzMbuxSettingsAudioOEMLay mAudioOEMLay;
    private BenzMbuxSettingsAudioSoundLay mAudioSoundLay;
    private ActivityBenzMbuxSettingsAudioLayoutBinding mBinding;
    private BenzMbuxSettingsViewModel mViewModel;
    private int[] relativeLayoutId = {R.id.mbux_settings_audio_android_item, R.id.mbux_settings_audio_oem_item, R.id.mbux_settings_audio_sound_item};

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseSkinActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BenzMbuxSettingsAudioActivity", " onCreate ");
        this.mBinding = (ActivityBenzMbuxSettingsAudioLayoutBinding) DataBindingUtil.setContentView(this, R.layout.activity_benz_mbux_settings_audio_layout);
        BenzMbuxSettingsViewModel instance = BenzMbuxSettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        initView();
        initData();
    }

    private void initView() {
        try {
            this.mAudioAndroidLay = new BenzMbuxSettingsAudioAndroidLay(this);
            this.mAudioOEMLay = new BenzMbuxSettingsAudioOEMLay(this);
            this.mAudioSoundLay = new BenzMbuxSettingsAudioSoundLay(this);
            int i = 0;
            while (true) {
                int[] iArr = this.relativeLayoutId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnClickListener(this);
                    i++;
                } else {
                    this.mBinding.getRoot().getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
                        /* class com.wits.ksw.settings.benz_mbux_2021.activity.BenzMbuxSettingsAudioActivity.AnonymousClass1 */

                        public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                            Log.i("BenzMbuxSettingsAudioActivity", "onGlobalFocusChanged: " + BenzMbuxSettingsAudioActivity.this.mBinding.mbuxSettingsAudioLay.hasFocus());
                            if (BenzMbuxSettingsAudioActivity.this.mBinding.mbuxSettingsAudioLay.hasFocus()) {
                                BenzMbuxSettingsAudioActivity.this.mViewModel.audioBgShow.set(true);
                            }
                            if (newFocus != null) {
                                newFocus.setFocusableInTouchMode(true);
                            }
                            if (oldFocus != null) {
                                oldFocus.setFocusableInTouchMode(false);
                            }
                        }
                    });
                    return;
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("BenzMbuxSettingsAudioActivity", " onNewIntent ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i("BenzMbuxSettingsAudioActivity", " onResume ");
    }

    private void initData() {
        try {
            Intent intent = getIntent();
            String toEqSettings = intent.getStringExtra("voiceEqData");
            String toVoiceSettings = intent.getStringExtra("voiceData");
            if (toEqSettings != null) {
                selectLayout(this.mAudioSoundLay, R.id.mbux_settings_audio_sound_item);
                this.mAudioSoundLay.requestFocus();
                this.mViewModel.audioBgShow.set(false);
            } else if (toVoiceSettings != null) {
                selectLayout(this.mAudioAndroidLay, R.id.mbux_settings_audio_android_item);
                this.mAudioAndroidLay.requestFocus();
                this.mViewModel.audioBgShow.set(false);
            } else {
                selectLayout(null, 0);
                this.mViewModel.audioBgShow.set(true);
            }
            if (getCurrentFocus() == null) {
                this.mBinding.mbuxSettingsAudioAndroidItem.setFocusableInTouchMode(true);
                this.mBinding.mbuxSettingsAudioAndroidItem.requestFocus();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mbux_settings_audio_android_item /*{ENCODED_INT: 2131231998}*/:
                selectLayout(this.mAudioAndroidLay, v.getId());
                this.mAudioAndroidLay.requestFocus();
                return;
            case R.id.mbux_settings_audio_oem_item /*{ENCODED_INT: 2131232005}*/:
                selectLayout(this.mAudioOEMLay, v.getId());
                this.mAudioOEMLay.requestFocus();
                return;
            case R.id.mbux_settings_audio_sound_item /*{ENCODED_INT: 2131232009}*/:
                selectLayout(this.mAudioSoundLay, v.getId());
                this.mAudioSoundLay.requestFocus();
                return;
            default:
                return;
        }
    }

    private void selectLayout(View view, int viewId) {
        try {
            Log.i("BenzMbuxSettingsAudioActivity", " view " + view + " viewId " + viewId);
            this.mBinding.mbuxSettingsAudioFramelay.removeAllViews();
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
                this.mBinding.mbuxSettingsAudioFramelay.addView(view);
                this.mViewModel.audioIconShow.set(false);
                return;
            }
            this.mViewModel.audioIconShow.set(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        int action = event.getAction();
        View view = getCurrentFocus();
        Log.i("BenzMbuxSettingsAudioActivity", "dispatchKeyEvent keyCode " + keyCode + " action " + action);
        switch (action) {
            case 0:
                if (event.getKeyCode() == 21 && view != null && this.mBinding.mbuxSettingsAudioLay.hasFocus()) {
                    Log.i("BenzMbuxSettingsAudioActivity", "dispatchKeyEvent ACTION_DOWN focusView " + view.toString() + " view.isFocused() " + view.isFocused());
                    KswUtils.sendKeyDownUpSync(4);
                    return true;
                }
        }
        return super.dispatchKeyEvent(event);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        Log.i("BenzMbuxSettingsAudioActivity", " onPause ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i("BenzMbuxSettingsAudioActivity", " onStop ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("BenzMbuxSettingsAudioActivity", " onDestroy ");
    }
}

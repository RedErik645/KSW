package com.wits.ksw.settings.bmw_id9.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityBmwId9SettingsAudioLayoutBinding;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.settings.BaseSkinActivity;
import com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsAudioAndroidLay;
import com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsAudioOEMLay;
import com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsAudioSoundLay;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public class BmwId9SettingsAudioActivity extends BaseSkinActivity implements View.OnClickListener {
    private final String TAG = "BmwId9SettingsAudioActivity";
    private BmwId9SettingsAudioAndroidLay mAudioAndroidLay;
    private BmwId9SettingsAudioOEMLay mAudioOEMLay;
    private BmwId9SettingsAudioSoundLay mAudioSoundLay;
    private ActivityBmwId9SettingsAudioLayoutBinding mBinding;
    private BmwId9SettingsViewModel mViewModel;
    private int[] relativeLayoutId = {R.id.bmw_id9_settings_audio_android_item, R.id.bmw_id9_settings_audio_oem_item, R.id.bmw_id9_settings_audio_sound_item};

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseSkinActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BmwId9SettingsAudioActivity", " onCreate ");
        this.mBinding = (ActivityBmwId9SettingsAudioLayoutBinding) DataBindingUtil.setContentView(this, R.layout.activity_bmw_id9_settings_audio_layout);
        BmwId9SettingsViewModel instance = BmwId9SettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        initView();
        initData();
    }

    private void initView() {
        try {
            this.mViewModel.systemBgShow.set(true);
            this.mAudioAndroidLay = new BmwId9SettingsAudioAndroidLay(this);
            this.mAudioOEMLay = new BmwId9SettingsAudioOEMLay(this);
            this.mAudioSoundLay = new BmwId9SettingsAudioSoundLay(this);
            int i = 0;
            while (true) {
                int[] iArr = this.relativeLayoutId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnClickListener(this);
                    i++;
                } else {
                    this.mBinding.getRoot().getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
                        /* class com.wits.ksw.settings.bmw_id9.activity.BmwId9SettingsAudioActivity.AnonymousClass1 */

                        public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                            Log.i("BmwId9SettingsAudioActivity", "onGlobalFocusChanged: " + BmwId9SettingsAudioActivity.this.mBinding.bmwId9SettingsAudioLay.hasFocus());
                            if (BmwId9SettingsAudioActivity.this.mBinding.bmwId9SettingsAudioLay.hasFocus()) {
                                BmwId9SettingsAudioActivity.this.mViewModel.systemBgShow.set(true);
                                BmwId9SettingsAudioActivity.this.mViewModel.audioBgShow.set(true);
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
        Log.i("BmwId9SettingsAudioActivity", " onNewIntent ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i("BmwId9SettingsAudioActivity", " onResume ");
    }

    private void initData() {
        try {
            Intent intent = getIntent();
            String toEqSettings = intent.getStringExtra("voiceEqData");
            String toVoiceSettings = intent.getStringExtra("voiceData");
            if (toEqSettings != null) {
                selectLayout(this.mAudioSoundLay, R.id.bmw_id9_settings_audio_sound_item);
                this.mAudioSoundLay.requestFocus();
                this.mViewModel.audioBgShow.set(false);
            } else if (toVoiceSettings != null) {
                selectLayout(this.mAudioAndroidLay, R.id.bmw_id9_settings_audio_android_item);
                this.mAudioAndroidLay.requestFocus();
                this.mViewModel.audioBgShow.set(false);
            } else {
                selectLayout(null, 0);
                this.mViewModel.audioBgShow.set(true);
            }
            if (getCurrentFocus() == null) {
                this.mBinding.bmwId9SettingsAudioAndroidItem.setFocusableInTouchMode(true);
                this.mBinding.bmwId9SettingsAudioAndroidItem.requestFocus();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bmw_id9_settings_audio_android_item /*{ENCODED_INT: 2131231140}*/:
                this.mViewModel.systemBgShow.set(false);
                selectLayout(this.mAudioAndroidLay, v.getId());
                this.mAudioAndroidLay.requestFocus();
                return;
            case R.id.bmw_id9_settings_audio_oem_item /*{ENCODED_INT: 2131231146}*/:
                this.mViewModel.systemBgShow.set(false);
                selectLayout(this.mAudioOEMLay, v.getId());
                this.mAudioOEMLay.requestFocus();
                return;
            case R.id.bmw_id9_settings_audio_sound_item /*{ENCODED_INT: 2131231150}*/:
                this.mViewModel.systemBgShow.set(false);
                selectLayout(this.mAudioSoundLay, v.getId());
                this.mAudioSoundLay.requestFocus();
                return;
            default:
                return;
        }
    }

    private void selectLayout(View view, int viewId) {
        try {
            Log.i("BmwId9SettingsAudioActivity", " view " + view + " viewId " + viewId);
            this.mBinding.bmwId9SettingsAudioFramelay.removeAllViews();
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
                this.mBinding.bmwId9SettingsAudioFramelay.addView(view);
                this.mViewModel.systemIconShow.set(false);
                this.mViewModel.audioIconShow.set(false);
                return;
            }
            this.mViewModel.systemBgShow.set(true);
            this.mViewModel.systemIconShow.set(true);
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
        Log.i("BmwId9SettingsAudioActivity", "dispatchKeyEvent keyCode " + keyCode + " action " + action);
        switch (action) {
            case 0:
                if (event.getKeyCode() == 21 && view != null && this.mBinding.bmwId9SettingsAudioLay.hasFocus()) {
                    Log.i("BmwId9SettingsAudioActivity", "dispatchKeyEvent ACTION_DOWN focusView " + view.toString() + " view.isFocused() " + view.isFocused());
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
        Log.i("BmwId9SettingsAudioActivity", " onPause ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i("BmwId9SettingsAudioActivity", " onStop ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("BmwId9SettingsAudioActivity", " onDestroy ");
    }
}

package com.wits.ksw.settings.bmw_id8.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.wits.ksw.R;
import com.wits.ksw.databinding.BmwId8SettingsAudioLayoutBinding;
import com.wits.ksw.launcher.utils.AnimationUtils;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.settings.BaseSkinActivity;
import com.wits.ksw.settings.bmw_id8.layout.BmwId8SettingsAudioAndroidLay;
import com.wits.ksw.settings.bmw_id8.layout.BmwId8SettingsAudioOEMLay;
import com.wits.ksw.settings.bmw_id8.layout.BmwId8SettingsAudioSoundLay;
import com.wits.ksw.settings.bmw_id8.vm.BmwId8SettingsViewModel;

public class BmwId8SettingsAudioActivity extends BaseSkinActivity implements View.OnClickListener {
    private final String TAG = "BmwId8SettingsAudioActivity";
    private BmwId8SettingsAudioAndroidLay mAudioAndroidLay;
    private BmwId8SettingsAudioOEMLay mAudioOEMLay;
    private BmwId8SettingsAudioSoundLay mAudioSoundLay;
    private BmwId8SettingsAudioLayoutBinding mBinding;
    private BmwId8SettingsViewModel mViewModel;
    private int[] relativeLayoutId = {R.id.bmw_id8_settings_audio_android_item, R.id.bmw_id8_settings_audio_oem_item, R.id.bmw_id8_settings_audio_sound_item};

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseSkinActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BmwId8SettingsAudioActivity", " onCreate ");
        this.mBinding = (BmwId8SettingsAudioLayoutBinding) DataBindingUtil.setContentView(this, R.layout.bmw_id8_settings_audio_layout);
        BmwId8SettingsViewModel instance = BmwId8SettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        initView();
        initData();
    }

    private void initView() {
        try {
            this.mAudioAndroidLay = new BmwId8SettingsAudioAndroidLay(this);
            this.mAudioOEMLay = new BmwId8SettingsAudioOEMLay(this);
            this.mAudioSoundLay = new BmwId8SettingsAudioSoundLay(this);
            int i = 0;
            while (true) {
                int[] iArr = this.relativeLayoutId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnClickListener(this);
                    i++;
                } else {
                    this.mViewModel.audioBgShow.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
                        /* class com.wits.ksw.settings.bmw_id8.activity.BmwId8SettingsAudioActivity.AnonymousClass1 */

                        @Override // android.databinding.Observable.OnPropertyChangedCallback
                        public void onPropertyChanged(Observable sender, int propertyId) {
                            Log.i("BmwId8SettingsAudioActivity", " onPropertyChanged " + BmwId8SettingsAudioActivity.this.mViewModel.audioBgShow.get());
                            if (BmwId8SettingsAudioActivity.this.mViewModel.audioBgShow.get()) {
                                BmwId8SettingsAudioActivity.this.mBinding.bmwId8SettingsAudioRightArrow.clearAnimation();
                                AnimationUtils.playAnimation(BmwId8SettingsAudioActivity.this.getApplicationContext(), BmwId8SettingsAudioActivity.this.mBinding.bmwId8SettingsAudioLeftArrow, false);
                                return;
                            }
                            BmwId8SettingsAudioActivity.this.mBinding.bmwId8SettingsAudioLeftArrow.clearAnimation();
                            AnimationUtils.playAnimation(BmwId8SettingsAudioActivity.this.getApplicationContext(), BmwId8SettingsAudioActivity.this.mBinding.bmwId8SettingsAudioRightArrow, false);
                        }
                    });
                    this.mBinding.getRoot().getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
                        /* class com.wits.ksw.settings.bmw_id8.activity.BmwId8SettingsAudioActivity.AnonymousClass2 */

                        public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                            Log.i("BmwId8SettingsAudioActivity", "onGlobalFocusChanged: " + BmwId8SettingsAudioActivity.this.mBinding.bmwId8SettingsAudioLay.hasFocus());
                            if (BmwId8SettingsAudioActivity.this.mBinding.bmwId8SettingsAudioLay.hasFocus()) {
                                BmwId8SettingsAudioActivity.this.mViewModel.audioBgShow.set(true);
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
        Log.i("BmwId8SettingsAudioActivity", " onNewIntent ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i("BmwId8SettingsAudioActivity", " onResume ");
    }

    private void initData() {
        try {
            Intent intent = getIntent();
            String toEqSettings = intent.getStringExtra("voiceEqData");
            String toVoiceSettings = intent.getStringExtra("voiceData");
            if (toEqSettings != null) {
                selectLayout(this.mAudioSoundLay, R.id.bmw_id8_settings_audio_sound_item);
                this.mAudioSoundLay.requestFocus();
                this.mViewModel.audioBgShow.set(false);
            } else if (toVoiceSettings != null) {
                selectLayout(this.mAudioAndroidLay, R.id.bmw_id8_settings_audio_android_item);
                this.mAudioAndroidLay.requestFocus();
                this.mViewModel.audioBgShow.set(false);
            } else {
                selectLayout(null, 0);
                this.mViewModel.audioBgShow.set(true);
            }
            if (getCurrentFocus() == null) {
                this.mBinding.bmwId8SettingsAudioAndroidItem.setFocusableInTouchMode(true);
                this.mBinding.bmwId8SettingsAudioAndroidItem.requestFocus();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bmw_id8_settings_audio_android_item /*{ENCODED_INT: 2131231010}*/:
                selectLayout(this.mAudioAndroidLay, v.getId());
                this.mAudioAndroidLay.requestFocus();
                return;
            case R.id.bmw_id8_settings_audio_oem_item /*{ENCODED_INT: 2131231018}*/:
                selectLayout(this.mAudioOEMLay, v.getId());
                this.mAudioOEMLay.requestFocus();
                return;
            case R.id.bmw_id8_settings_audio_sound_item /*{ENCODED_INT: 2131231023}*/:
                selectLayout(this.mAudioSoundLay, v.getId());
                this.mAudioSoundLay.requestFocus();
                return;
            default:
                return;
        }
    }

    private void selectLayout(View view, int viewId) {
        try {
            Log.i("BmwId8SettingsAudioActivity", " view " + view + " viewId " + viewId);
            this.mBinding.bmwId8SettingsAudioFramelay.removeAllViews();
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
                this.mBinding.bmwId8SettingsAudioFramelay.addView(view);
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
        Log.i("BmwId8SettingsAudioActivity", "dispatchKeyEvent keyCode " + keyCode + " action " + action);
        switch (action) {
            case 0:
                if (event.getKeyCode() == 21 && view != null && this.mBinding.bmwId8SettingsAudioLay.hasFocus()) {
                    Log.i("BmwId8SettingsAudioActivity", "dispatchKeyEvent ACTION_DOWN focusView " + view.toString() + " view.isFocused() " + view.isFocused());
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
        Log.i("BmwId8SettingsAudioActivity", " onPause ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i("BmwId8SettingsAudioActivity", " onStop ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("BmwId8SettingsAudioActivity", " onDestroy ");
    }
}

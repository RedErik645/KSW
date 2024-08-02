package com.wits.ksw.settings.bmw_id9.layout;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.databinding.BmwId9SettingsAudioAndroidLayoutBinding;
import com.wits.ksw.settings.bmw_id9.view.BmwId9ProgressBar;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BmwId9SettingsAudioAndroidLay extends RelativeLayout implements BmwId9ProgressBar.OnValueChangeListener, BmwId9ProgressBar.OnTouchChangeListener {
    private final String TAG = "BmwId9SettingsAudioAndroidLay";
    private Context context;
    private int[] imageButtonId = {R.id.bmw_id9_settings_meida_sub_btn, R.id.bmw_id9_settings_meida_add_btn, R.id.bmw_id9_settings_android_call_sub_btn, R.id.bmw_id9_settings_android_call_add_btn};
    private BmwId9SettingsAudioAndroidLayoutBinding mBinding;
    private BmwId9SettingsViewModel mViewModel;

    public BmwId9SettingsAudioAndroidLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BmwId9SettingsAudioAndroidLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.bmw_id9_settings_audio_android_layout, null, false);
        this.mBinding.getRoot().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        BmwId9SettingsViewModel instance = BmwId9SettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        addView(this.mBinding.getRoot());
        initView();
        initData();
    }

    private void initView() {
        try {
            this.mBinding.bmwId9SettingsMeidaSeekbar.setOnValueChangeListener(this);
            this.mBinding.bmwId9SettingsAndroidCallSeekbar.setOnValueChangeListener(this);
            this.mBinding.bmwId9SettingsMeidaSeekbar.setOnTouchChangeListener(this);
            this.mBinding.bmwId9SettingsAndroidCallSeekbar.setOnTouchChangeListener(this);
            int i = 0;
            while (true) {
                int[] iArr = this.imageButtonId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnTouchListener(new View.OnTouchListener() {
                        /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsAudioAndroidLay.AnonymousClass1 */

                        public boolean onTouch(View v, MotionEvent event) {
                            Log.i("BmwId9SettingsAudioAndroidLay", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
                            if (event.getAction() != 1 || v.isFocused()) {
                                return false;
                            }
                            v.requestFocus();
                            return false;
                        }
                    });
                    i++;
                } else {
                    this.mBinding.getRoot().getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
                        /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsAudioAndroidLay.AnonymousClass2 */

                        public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                            Log.i("BmwId9SettingsAudioAndroidLay", "onGlobalFocusChanged: " + BmwId9SettingsAudioAndroidLay.this.mBinding.bmwId9SettingsAudioAndroidLay.hasFocus());
                            if (BmwId9SettingsAudioAndroidLay.this.mBinding.bmwId9SettingsAudioAndroidLay.hasFocus()) {
                                BmwId9SettingsAudioAndroidLay.this.mViewModel.audioBgShow.set(false);
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

    private void initData() {
        try {
            this.mViewModel.androidMediaVolume.set(PowerManagerApp.getSettingsInt(KeyConfig.ANDROID_MEDIA_VOL));
            this.mViewModel.androidCallVolume.set(PowerManagerApp.getSettingsInt(KeyConfig.ANDROID_PHONE_VOL));
            ContentResolver contentResolver = getContext().getContentResolver();
            contentResolver.registerContentObserver(Settings.System.getUriFor(KeyConfig.ANDROID_MEDIA_VOL), true, new ContentObserver(new Handler()) {
                /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsAudioAndroidLay.AnonymousClass3 */

                public void onChange(boolean selfChange) {
                    Log.i("BmwId9SettingsAudioAndroidLay", "KeyConfig.ANDROID_MEDIA_VOL onChange ");
                    try {
                        BmwId9SettingsAudioAndroidLay.this.mViewModel.androidMediaVolume.set(PowerManagerApp.getSettingsInt(KeyConfig.ANDROID_MEDIA_VOL));
                    } catch (RemoteException e) {
                    }
                }
            });
            contentResolver.registerContentObserver(Settings.System.getUriFor(KeyConfig.ANDROID_PHONE_VOL), true, new ContentObserver(new Handler()) {
                /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsAudioAndroidLay.AnonymousClass4 */

                public void onChange(boolean selfChange) {
                    Log.i("BmwId9SettingsAudioAndroidLay", "KeyConfig.ANDROID_PHONE_VOL onChange ");
                    try {
                        BmwId9SettingsAudioAndroidLay.this.mViewModel.androidCallVolume.set(PowerManagerApp.getSettingsInt(KeyConfig.ANDROID_PHONE_VOL));
                    } catch (RemoteException e) {
                    }
                }
            });
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override // com.wits.ksw.settings.bmw_id9.view.BmwId9ProgressBar.OnValueChangeListener
    public void onValueChange(BmwId9ProgressBar progressBar, int value, float progress) {
        switch (progressBar.getId()) {
            case R.id.bmw_id9_settings_android_call_seekbar /*{ENCODED_INT: 2131231138}*/:
                FileUtils.savaIntData(KeyConfig.ANDROID_PHONE_VOL, value);
                this.mViewModel.androidCallVolume.set(value);
                return;
            case R.id.bmw_id9_settings_meida_seekbar /*{ENCODED_INT: 2131231188}*/:
                FileUtils.savaIntData(KeyConfig.ANDROID_MEDIA_VOL, value);
                this.mViewModel.androidMediaVolume.set(value);
                return;
            default:
                return;
        }
    }

    @Override // com.wits.ksw.settings.bmw_id9.view.BmwId9ProgressBar.OnTouchChangeListener
    public void onStartTrackingTouch(BmwId9ProgressBar progressBar) {
        this.mViewModel.audioBgShow.set(false);
        progressBar.requestFocus();
    }

    @Override // com.wits.ksw.settings.bmw_id9.view.BmwId9ProgressBar.OnTouchChangeListener
    public void onStopTrackingTouch(BmwId9ProgressBar progressBar) {
    }
}

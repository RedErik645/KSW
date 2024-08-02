package com.wits.ksw.settings.benz_mbux_2021.layout;

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
import com.wits.ksw.databinding.BenzMbuxSettingsAudioAndroidLayoutBinding;
import com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BenzMbuxSettingsAudioAndroidLay extends RelativeLayout implements BenzMbuxProgressBar.OnValueChangeListener, BenzMbuxProgressBar.OnTouchChangeListener {
    private final String TAG = "BenzMbuxSettingsAudioAndroidLay";
    private Context context;
    private int[] imageButtonId = {R.id.mbux_settings_meida_sub_btn, R.id.mbux_settings_meida_add_btn, R.id.mbux_settings_android_call_sub_btn, R.id.mbux_settings_android_call_add_btn};
    private BenzMbuxSettingsAudioAndroidLayoutBinding mBinding;
    private BenzMbuxSettingsViewModel mViewModel;

    public BenzMbuxSettingsAudioAndroidLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BenzMbuxSettingsAudioAndroidLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.benz_mbux_settings_audio_android_layout, null, false);
        this.mBinding.getRoot().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        BenzMbuxSettingsViewModel instance = BenzMbuxSettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        addView(this.mBinding.getRoot());
        initView();
        initData();
    }

    private void initView() {
        try {
            this.mBinding.mbuxSettingsMeidaSeekbar.setOnValueChangeListener(this);
            this.mBinding.mbuxSettingsAndroidCallSeekbar.setOnValueChangeListener(this);
            this.mBinding.mbuxSettingsMeidaSeekbar.setOnTouchChangeListener(this);
            this.mBinding.mbuxSettingsAndroidCallSeekbar.setOnTouchChangeListener(this);
            int i = 0;
            while (true) {
                int[] iArr = this.imageButtonId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnTouchListener(new View.OnTouchListener() {
                        /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsAudioAndroidLay.AnonymousClass1 */

                        public boolean onTouch(View v, MotionEvent event) {
                            Log.i("BenzMbuxSettingsAudioAndroidLay", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
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
                        /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsAudioAndroidLay.AnonymousClass2 */

                        public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                            Log.i("BenzMbuxSettingsAudioAndroidLay", "onGlobalFocusChanged: " + BenzMbuxSettingsAudioAndroidLay.this.mBinding.mbuxSettingsAudioAndroidLay.hasFocus());
                            if (BenzMbuxSettingsAudioAndroidLay.this.mBinding.mbuxSettingsAudioAndroidLay.hasFocus()) {
                                BenzMbuxSettingsAudioAndroidLay.this.mViewModel.audioBgShow.set(false);
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
                /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsAudioAndroidLay.AnonymousClass3 */

                public void onChange(boolean selfChange) {
                    Log.i("BenzMbuxSettingsAudioAndroidLay", "KeyConfig.ANDROID_MEDIA_VOL onChange ");
                    try {
                        BenzMbuxSettingsAudioAndroidLay.this.mViewModel.androidMediaVolume.set(PowerManagerApp.getSettingsInt(KeyConfig.ANDROID_MEDIA_VOL));
                    } catch (RemoteException e) {
                    }
                }
            });
            contentResolver.registerContentObserver(Settings.System.getUriFor(KeyConfig.ANDROID_PHONE_VOL), true, new ContentObserver(new Handler()) {
                /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsAudioAndroidLay.AnonymousClass4 */

                public void onChange(boolean selfChange) {
                    Log.i("BenzMbuxSettingsAudioAndroidLay", "KeyConfig.ANDROID_PHONE_VOL onChange ");
                    try {
                        BenzMbuxSettingsAudioAndroidLay.this.mViewModel.androidCallVolume.set(PowerManagerApp.getSettingsInt(KeyConfig.ANDROID_PHONE_VOL));
                    } catch (RemoteException e) {
                    }
                }
            });
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override // com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar.OnValueChangeListener
    public void onValueChange(BenzMbuxProgressBar progressBar, int value, float progress) {
        switch (progressBar.getId()) {
            case R.id.mbux_settings_android_call_seekbar /*{ENCODED_INT: 2131231996}*/:
                FileUtils.savaIntData(KeyConfig.ANDROID_PHONE_VOL, value);
                this.mViewModel.androidCallVolume.set(value);
                return;
            case R.id.mbux_settings_meida_seekbar /*{ENCODED_INT: 2131232052}*/:
                FileUtils.savaIntData(KeyConfig.ANDROID_MEDIA_VOL, value);
                this.mViewModel.androidMediaVolume.set(value);
                return;
            default:
                return;
        }
    }

    @Override // com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar.OnTouchChangeListener
    public void onStartTrackingTouch(BenzMbuxProgressBar progressBar) {
        this.mViewModel.audioBgShow.set(false);
        progressBar.requestFocus();
    }

    @Override // com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar.OnTouchChangeListener
    public void onStopTrackingTouch(BenzMbuxProgressBar progressBar) {
    }
}

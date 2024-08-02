package com.wits.ksw.settings.benz_mbux_2021.layout;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.databinding.BenzMbuxSettingsAudioOemLayoutBinding;
import com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BenzMbuxSettingsAudioOEMLay extends RelativeLayout implements BenzMbuxProgressBar.OnValueChangeListener, BenzMbuxProgressBar.OnTouchChangeListener {
    private final String TAG = "BenzMbuxSettingsAudioOEMLay";
    private Context context;
    private int[] imageButtonId = {R.id.mbux_settings_oem_call_sub_btn, R.id.mbux_settings_oem_call_add_btn, R.id.mbux_settings_navi_sub_btn, R.id.mbux_settings_navi_add_btn};
    private BenzMbuxSettingsAudioOemLayoutBinding mBinding;
    private BenzMbuxSettingsViewModel mViewModel;

    public BenzMbuxSettingsAudioOEMLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BenzMbuxSettingsAudioOemLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.benz_mbux_settings_audio_oem_layout, null, false);
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
            this.mBinding.mbuxSettingsOemCallSeekbar.setOnValueChangeListener(this);
            this.mBinding.mbuxSettingsNaviSeekbar.setOnValueChangeListener(this);
            this.mBinding.mbuxSettingsOemCallSeekbar.setOnTouchChangeListener(this);
            this.mBinding.mbuxSettingsNaviSeekbar.setOnTouchChangeListener(this);
            int i = 0;
            while (true) {
                int[] iArr = this.imageButtonId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnTouchListener(new View.OnTouchListener() {
                        /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsAudioOEMLay.AnonymousClass1 */

                        public boolean onTouch(View v, MotionEvent event) {
                            Log.i("BenzMbuxSettingsAudioOEMLay", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
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
                        /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsAudioOEMLay.AnonymousClass2 */

                        public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                            Log.i("BenzMbuxSettingsAudioOEMLay", "onGlobalFocusChanged: " + BenzMbuxSettingsAudioOEMLay.this.mBinding.mbuxSettingsAudioOemLay.hasFocus());
                            if (BenzMbuxSettingsAudioOEMLay.this.mBinding.mbuxSettingsAudioOemLay.hasFocus()) {
                                BenzMbuxSettingsAudioOEMLay.this.mViewModel.audioBgShow.set(false);
                            }
                        }
                    });
                    this.mViewModel.oemCallVolume.set(PowerManagerApp.getSettingsInt(KeyConfig.CAR_PHONE_VOL));
                    this.mViewModel.oemNaviVolume.set(PowerManagerApp.getSettingsInt(KeyConfig.CAR_NAVI_VOL));
                    return;
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private void initData() {
    }

    @Override // com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar.OnValueChangeListener
    public void onValueChange(BenzMbuxProgressBar progressBar, int value, float progress) {
        switch (progressBar.getId()) {
            case R.id.mbux_settings_navi_seekbar /*{ENCODED_INT: 2131232061}*/:
                FileUtils.savaIntData(KeyConfig.CAR_NAVI_VOL, value);
                this.mViewModel.oemNaviVolume.set(value);
                return;
            case R.id.mbux_settings_oem_call_seekbar /*{ENCODED_INT: 2131232064}*/:
                FileUtils.savaIntData(KeyConfig.CAR_PHONE_VOL, value);
                this.mViewModel.oemCallVolume.set(value);
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

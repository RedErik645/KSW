package com.wits.ksw.settings.bmw_id9.layout;

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
import com.wits.ksw.databinding.BmwId9SettingsAudioOemLayoutBinding;
import com.wits.ksw.settings.bmw_id9.view.BmwId9ProgressBar;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BmwId9SettingsAudioOEMLay extends RelativeLayout implements BmwId9ProgressBar.OnValueChangeListener, BmwId9ProgressBar.OnTouchChangeListener {
    private final String TAG = "BmwId9SettingsAudioOEMLay";
    private Context context;
    private int[] imageButtonId = {R.id.bmw_id9_settings_oem_call_sub_btn, R.id.bmw_id9_settings_oem_call_add_btn, R.id.bmw_id9_settings_navi_sub_btn, R.id.bmw_id9_settings_navi_add_btn};
    private BmwId9SettingsAudioOemLayoutBinding mBinding;
    private BmwId9SettingsViewModel mViewModel;

    public BmwId9SettingsAudioOEMLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BmwId9SettingsAudioOemLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.bmw_id9_settings_audio_oem_layout, null, false);
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
            this.mBinding.bmwId9SettingsOemCallSeekbar.setOnValueChangeListener(this);
            this.mBinding.bmwId9SettingsNaviSeekbar.setOnValueChangeListener(this);
            this.mBinding.bmwId9SettingsOemCallSeekbar.setOnTouchChangeListener(this);
            this.mBinding.bmwId9SettingsNaviSeekbar.setOnTouchChangeListener(this);
            int i = 0;
            while (true) {
                int[] iArr = this.imageButtonId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnTouchListener(new View.OnTouchListener() {
                        /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsAudioOEMLay.AnonymousClass1 */

                        public boolean onTouch(View v, MotionEvent event) {
                            Log.i("BmwId9SettingsAudioOEMLay", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
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
                        /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsAudioOEMLay.AnonymousClass2 */

                        public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                            Log.i("BmwId9SettingsAudioOEMLay", "onGlobalFocusChanged: " + BmwId9SettingsAudioOEMLay.this.mBinding.bmwId9SettingsAudioOemLay.hasFocus());
                            if (BmwId9SettingsAudioOEMLay.this.mBinding.bmwId9SettingsAudioOemLay.hasFocus()) {
                                BmwId9SettingsAudioOEMLay.this.mViewModel.audioBgShow.set(false);
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

    @Override // com.wits.ksw.settings.bmw_id9.view.BmwId9ProgressBar.OnValueChangeListener
    public void onValueChange(BmwId9ProgressBar progressBar, int value, float progress) {
        switch (progressBar.getId()) {
            case R.id.bmw_id9_settings_navi_seekbar /*{ENCODED_INT: 2131231197}*/:
                FileUtils.savaIntData(KeyConfig.CAR_NAVI_VOL, value);
                this.mViewModel.oemNaviVolume.set(value);
                return;
            case R.id.bmw_id9_settings_oem_call_seekbar /*{ENCODED_INT: 2131231200}*/:
                FileUtils.savaIntData(KeyConfig.CAR_PHONE_VOL, value);
                this.mViewModel.oemCallVolume.set(value);
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

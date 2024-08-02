package com.wits.ksw.settings.bmw_id8.layout;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.databinding.BmwId8SettingsAudioSoundLayoutBinding;
import com.wits.ksw.launcher.bmw_id8_ui.view.ID8AudioProgressBar;
import com.wits.ksw.settings.bmw_id8.vm.BmwId8SettingsViewModel;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BmwId8SettingsAudioSoundLay extends RelativeLayout implements View.OnClickListener, ID8AudioProgressBar.OnTouchChangeListener, ID8AudioProgressBar.OnValueChangeListener {
    private final String TAG = "BmwId8SettingsAudioSoundLay";
    private int bass = 12;
    private Context context;
    private int eqModel = 0;
    private BmwId8SettingsAudioSoundLayoutBinding mBinding;
    private BmwId8SettingsViewModel mViewModel;
    private int mid = 12;
    private int[] relativeLayoutId = {R.id.bmw_id8_settings_audio_sound_user, R.id.bmw_id8_settings_audio_sound_pop, R.id.bmw_id8_settings_audio_sound_class, R.id.bmw_id8_settings_audio_sound_rock, R.id.bmw_id8_settings_audio_sound_jazz, R.id.bmw_id8_settings_audio_sound_dance, R.id.bmw_id8_settings_bass_sub_btn, R.id.bmw_id8_settings_bass_add_btn, R.id.bmw_id8_settings_mid_sub_btn, R.id.bmw_id8_settings_mid_add_btn, R.id.bmw_id8_settings_tre_sub_btn, R.id.bmw_id8_settings_tre_add_btn};
    private int tre = 12;

    public BmwId8SettingsAudioSoundLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BmwId8SettingsAudioSoundLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.bmw_id8_settings_audio_sound_layout, null, false);
        this.mBinding.getRoot().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        BmwId8SettingsViewModel instance = BmwId8SettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        addView(this.mBinding.getRoot());
        initView();
        initData();
    }

    private void initView() {
        int i = 0;
        while (true) {
            try {
                int[] iArr = this.relativeLayoutId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnClickListener(this);
                    findViewById(this.relativeLayoutId[i]).setOnTouchListener(new View.OnTouchListener() {
                        /* class com.wits.ksw.settings.bmw_id8.layout.BmwId8SettingsAudioSoundLay.AnonymousClass1 */

                        public boolean onTouch(View v, MotionEvent event) {
                            Log.i("BmwId8SettingsAudioSoundLay", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
                            if (event.getAction() != 1 || v.isFocused()) {
                                return false;
                            }
                            v.setFocusableInTouchMode(true);
                            v.requestFocus();
                            return false;
                        }
                    });
                    i++;
                } else {
                    this.mBinding.getRoot().getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
                        /* class com.wits.ksw.settings.bmw_id8.layout.BmwId8SettingsAudioSoundLay.AnonymousClass2 */

                        public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                            Log.i("BmwId8SettingsAudioSoundLay", "onGlobalFocusChanged: " + BmwId8SettingsAudioSoundLay.this.mBinding.bmwId8SettingsAudioSoundLay.hasFocus());
                            if (BmwId8SettingsAudioSoundLay.this.mBinding.bmwId8SettingsAudioSoundLay.hasFocus()) {
                                BmwId8SettingsAudioSoundLay.this.mViewModel.audioBgShow.set(false);
                            }
                        }
                    });
                    this.mBinding.bmwId8SettingsAudioLow.setOnTouchChangeListener(this);
                    this.mBinding.bmwId8SettingsAudioLow.setOnValueChangeListener(this);
                    this.mBinding.bmwId8SettingsAudioMid.setOnTouchChangeListener(this);
                    this.mBinding.bmwId8SettingsAudioMid.setOnValueChangeListener(this);
                    this.mBinding.bmwId8SettingsAudioTre.setOnTouchChangeListener(this);
                    this.mBinding.bmwId8SettingsAudioTre.setOnValueChangeListener(this);
                    return;
                }
            } catch (Exception e) {
                e.getStackTrace();
                return;
            }
        }
    }

    private void initData() {
        try {
            this.bass = PowerManagerApp.getSettingsInt(KeyConfig.EQ_BASS);
            this.mid = PowerManagerApp.getSettingsInt(KeyConfig.EQ_MIDDLE);
            this.tre = PowerManagerApp.getSettingsInt(KeyConfig.EQ_TREBLE);
            this.eqModel = PowerManagerApp.getSettingsInt(KeyConfig.EQ_MODE);
            Log.i("BmwId8SettingsAudioSoundLay", "initData: bass " + this.bass + " mid " + this.mid + " tre " + this.tre + " eqModel " + this.eqModel);
            this.mViewModel.eqType.set(this.eqModel);
            this.mViewModel.bassVolume.set(this.bass);
            this.mViewModel.bassVolumeStr.set(getVolumeStr(this.mViewModel.bassVolume));
            this.mViewModel.midVolume.set(this.mid);
            this.mViewModel.midVolumeStr.set(getVolumeStr(this.mViewModel.midVolume));
            this.mViewModel.treVolume.set(this.tre);
            this.mViewModel.treVolumeStr.set(getVolumeStr(this.mViewModel.treVolume));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bmw_id8_settings_audio_sound_class /*{ENCODED_INT: 2131231021}*/:
                FileUtils.savaIntData(KeyConfig.EQ_MODE, 2);
                this.mViewModel.eqType.set(2);
                return;
            case R.id.bmw_id8_settings_audio_sound_dance /*{ENCODED_INT: 2131231022}*/:
                FileUtils.savaIntData(KeyConfig.EQ_MODE, 5);
                this.mViewModel.eqType.set(5);
                return;
            case R.id.bmw_id8_settings_audio_sound_jazz /*{ENCODED_INT: 2131231024}*/:
                FileUtils.savaIntData(KeyConfig.EQ_MODE, 4);
                this.mViewModel.eqType.set(4);
                return;
            case R.id.bmw_id8_settings_audio_sound_pop /*{ENCODED_INT: 2131231026}*/:
                FileUtils.savaIntData(KeyConfig.EQ_MODE, 1);
                this.mViewModel.eqType.set(1);
                return;
            case R.id.bmw_id8_settings_audio_sound_rock /*{ENCODED_INT: 2131231027}*/:
                FileUtils.savaIntData(KeyConfig.EQ_MODE, 3);
                this.mViewModel.eqType.set(3);
                return;
            case R.id.bmw_id8_settings_audio_sound_user /*{ENCODED_INT: 2131231028}*/:
                this.mViewModel.userTypeShow.set(!this.mViewModel.userTypeShow.get());
                FileUtils.savaIntData(KeyConfig.EQ_MODE, 0);
                this.mViewModel.eqType.set(0);
                return;
            case R.id.bmw_id8_settings_bass_add_btn /*{ENCODED_INT: 2131231030}*/:
                calcAddVolume(this.mViewModel.bassVolume, 24, KeyConfig.EQ_BASS);
                this.mViewModel.bassVolumeStr.set(getVolumeStr(this.mViewModel.bassVolume));
                return;
            case R.id.bmw_id8_settings_bass_sub_btn /*{ENCODED_INT: 2131231031}*/:
                calcSubVolume(this.mViewModel.bassVolume, 0, KeyConfig.EQ_BASS);
                this.mViewModel.bassVolumeStr.set(getVolumeStr(this.mViewModel.bassVolume));
                return;
            case R.id.bmw_id8_settings_mid_add_btn /*{ENCODED_INT: 2131231065}*/:
                calcAddVolume(this.mViewModel.midVolume, 24, KeyConfig.EQ_MIDDLE);
                this.mViewModel.midVolumeStr.set(getVolumeStr(this.mViewModel.midVolume));
                return;
            case R.id.bmw_id8_settings_mid_sub_btn /*{ENCODED_INT: 2131231066}*/:
                calcSubVolume(this.mViewModel.midVolume, 0, KeyConfig.EQ_MIDDLE);
                this.mViewModel.midVolumeStr.set(getVolumeStr(this.mViewModel.midVolume));
                return;
            case R.id.bmw_id8_settings_tre_add_btn /*{ENCODED_INT: 2131231118}*/:
                calcAddVolume(this.mViewModel.treVolume, 24, KeyConfig.EQ_TREBLE);
                this.mViewModel.treVolumeStr.set(getVolumeStr(this.mViewModel.treVolume));
                return;
            case R.id.bmw_id8_settings_tre_sub_btn /*{ENCODED_INT: 2131231119}*/:
                calcSubVolume(this.mViewModel.treVolume, 0, KeyConfig.EQ_TREBLE);
                this.mViewModel.treVolumeStr.set(getVolumeStr(this.mViewModel.treVolume));
                return;
            default:
                return;
        }
    }

    private void calcSubVolume(ObservableInt observableInt, int min, String key) {
        try {
            int value = observableInt.get() - 1;
            if (value >= min) {
                FileUtils.savaIntData(key, value);
                observableInt.set(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void calcAddVolume(ObservableInt observableInt, int max, String key) {
        try {
            int value = observableInt.get() + 1;
            if (value <= max) {
                FileUtils.savaIntData(key, value);
                observableInt.set(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getVolumeStr(ObservableInt observableInt) {
        int value = observableInt.get() - 12;
        if (value > 0) {
            return "+" + value;
        }
        return String.valueOf(value);
    }

    @Override // com.wits.ksw.launcher.bmw_id8_ui.view.ID8AudioProgressBar.OnValueChangeListener
    public void onValueChange(ID8AudioProgressBar progressBar, int value) {
        switch (progressBar.getId()) {
            case R.id.bmw_id8_settings_audio_low /*{ENCODED_INT: 2131231016}*/:
                this.mViewModel.bassVolume.set(value);
                this.mViewModel.bassVolumeStr.set(getVolumeStr(this.mViewModel.bassVolume));
                FileUtils.savaIntData(KeyConfig.EQ_BASS, value);
                return;
            case R.id.bmw_id8_settings_audio_mid /*{ENCODED_INT: 2131231017}*/:
                this.mViewModel.midVolume.set(value);
                this.mViewModel.midVolumeStr.set(getVolumeStr(this.mViewModel.midVolume));
                FileUtils.savaIntData(KeyConfig.EQ_MIDDLE, value);
                return;
            case R.id.bmw_id8_settings_audio_tre /*{ENCODED_INT: 2131231029}*/:
                this.mViewModel.treVolume.set(value);
                this.mViewModel.treVolumeStr.set(getVolumeStr(this.mViewModel.treVolume));
                FileUtils.savaIntData(KeyConfig.EQ_TREBLE, value);
                return;
            default:
                return;
        }
    }

    @Override // com.wits.ksw.launcher.bmw_id8_ui.view.ID8AudioProgressBar.OnTouchChangeListener
    public void onStartTrackingTouch(ID8AudioProgressBar progressBar) {
        this.mViewModel.audioBgShow.set(false);
        progressBar.setFocusableInTouchMode(true);
        progressBar.requestFocus();
    }

    @Override // com.wits.ksw.launcher.bmw_id8_ui.view.ID8AudioProgressBar.OnTouchChangeListener
    public void onStopTrackingTouch(ID8AudioProgressBar progressBar) {
    }
}

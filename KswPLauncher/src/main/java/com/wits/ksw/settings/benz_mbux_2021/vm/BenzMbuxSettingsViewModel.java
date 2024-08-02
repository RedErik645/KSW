package com.wits.ksw.settings.benz_mbux_2021.vm;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.settings.TxzMessage;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.ksw.settings.utlis_view.SystemProperties;

public class BenzMbuxSettingsViewModel extends ViewModel {
    private static volatile BenzMbuxSettingsViewModel benzMbuxSettingsViewModel = null;
    public ObservableInt androidCallVolume = new ObservableInt(0);
    public ObservableInt androidMediaVolume = new ObservableInt(0);
    public ObservableInt androidOemVolumeMax = new ObservableInt(40);
    public ObservableField<String> appVersionStr = new ObservableField<>();
    public ObservableBoolean audioBgShow = new ObservableBoolean(true);
    public ObservableBoolean audioIconShow = new ObservableBoolean(true);
    public ObservableInt bassVolume = new ObservableInt(0);
    public ObservableField<String> bassVolumeStr = new ObservableField<>(TxzMessage.TXZ_DISMISS);
    public ObservableInt brightness = new ObservableInt(0);
    public ObservableField<String> cpuInfoStr = new ObservableField<>();
    public ObservableBoolean disableVideo = new ObservableBoolean();
    public ObservableInt eqType = new ObservableInt(0);
    public ObservableInt fuelUnit = new ObservableInt(0);
    public ObservableField<String> mcuVersionStr = new ObservableField<>();
    public ObservableInt midVolume = new ObservableInt(0);
    public ObservableField<String> midVolumeStr = new ObservableField<>(TxzMessage.TXZ_DISMISS);
    public ObservableInt oemCallVolume = new ObservableInt(0);
    public ObservableInt oemNaviVolume = new ObservableInt(0);
    public ObservableBoolean parkLines = new ObservableBoolean();
    public ObservableBoolean parkMute = new ObservableBoolean();
    public ObservableBoolean parkRadar = new ObservableBoolean();
    public ObservableField<String> ramStr = new ObservableField<>();
    public ObservableInt rearCameraType = new ObservableInt(0);
    public ObservableBoolean rearMirror = new ObservableBoolean();
    public ObservableField<String> storageStr = new ObservableField<>();
    public ObservableBoolean systemBgShow = new ObservableBoolean(true);
    public ObservableBoolean systemIconShow = new ObservableBoolean(true);
    public ObservableField<String> systemVersionStr = new ObservableField<>();
    public ObservableInt tempUnit = new ObservableInt(0);
    public ObservableBoolean timeFormatShow = new ObservableBoolean();
    public ObservableInt timeFormatState = new ObservableInt(1);
    public ObservableBoolean timeSyncShow = new ObservableBoolean();
    public ObservableInt timeSyncState = new ObservableInt(1);
    public ObservableInt treVolume = new ObservableInt(0);
    public ObservableField<String> treVolumeStr = new ObservableField<>(TxzMessage.TXZ_DISMISS);
    public ObservableBoolean userTypeShow = new ObservableBoolean();

    public static BenzMbuxSettingsViewModel getInstance() {
        if (benzMbuxSettingsViewModel == null) {
            synchronized (BenzMbuxSettingsViewModel.class) {
                if (benzMbuxSettingsViewModel == null) {
                    benzMbuxSettingsViewModel = new BenzMbuxSettingsViewModel();
                }
            }
        }
        return benzMbuxSettingsViewModel;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mbux_settings_android_call_add_btn /*{ENCODED_INT: 2131231995}*/:
                this.audioBgShow.set(false);
                calcAddVolume(this.androidCallVolume, this.androidOemVolumeMax.get(), KeyConfig.ANDROID_PHONE_VOL);
                return;
            case R.id.mbux_settings_android_call_sub_btn /*{ENCODED_INT: 2131231997}*/:
                this.audioBgShow.set(false);
                calcSubVolume(this.androidCallVolume, 0, KeyConfig.ANDROID_PHONE_VOL);
                return;
            case R.id.mbux_settings_meida_add_btn /*{ENCODED_INT: 2131232051}*/:
                this.audioBgShow.set(false);
                calcAddVolume(this.androidMediaVolume, this.androidOemVolumeMax.get(), KeyConfig.ANDROID_MEDIA_VOL);
                return;
            case R.id.mbux_settings_meida_sub_btn /*{ENCODED_INT: 2131232053}*/:
                this.audioBgShow.set(false);
                calcSubVolume(this.androidMediaVolume, 0, KeyConfig.ANDROID_MEDIA_VOL);
                return;
            case R.id.mbux_settings_navi_add_btn /*{ENCODED_INT: 2131232057}*/:
                this.audioBgShow.set(false);
                calcAddVolume(this.oemNaviVolume, this.androidOemVolumeMax.get(), KeyConfig.CAR_NAVI_VOL);
                return;
            case R.id.mbux_settings_navi_sub_btn /*{ENCODED_INT: 2131232062}*/:
                this.audioBgShow.set(false);
                calcSubVolume(this.oemNaviVolume, 0, KeyConfig.CAR_NAVI_VOL);
                return;
            case R.id.mbux_settings_oem_call_add_btn /*{ENCODED_INT: 2131232063}*/:
                this.audioBgShow.set(false);
                calcAddVolume(this.oemCallVolume, this.androidOemVolumeMax.get(), KeyConfig.CAR_PHONE_VOL);
                return;
            case R.id.mbux_settings_oem_call_sub_btn /*{ENCODED_INT: 2131232065}*/:
                this.audioBgShow.set(false);
                calcSubVolume(this.oemCallVolume, 0, KeyConfig.CAR_PHONE_VOL);
                return;
            case R.id.mbux_settings_system_camera_360 /*{ENCODED_INT: 2131232072}*/:
                this.systemBgShow.set(false);
                this.rearCameraType.set(2);
                FileUtils.savaIntData(KeyConfig.DAO_CHE_SXT, 2);
                return;
            case R.id.mbux_settings_system_camera_360_built /*{ENCODED_INT: 2131232073}*/:
                this.systemBgShow.set(false);
                this.rearCameraType.set(3);
                FileUtils.savaIntData(KeyConfig.DAO_CHE_SXT, 3);
                SystemProperties.set("persist.sys.camera.preview.size", "1920x4344");
                return;
            case R.id.mbux_settings_system_camera_after /*{ENCODED_INT: 2131232074}*/:
                this.systemBgShow.set(false);
                this.rearCameraType.set(0);
                FileUtils.savaIntData(KeyConfig.DAO_CHE_SXT, 0);
                return;
            case R.id.mbux_settings_system_camera_oem /*{ENCODED_INT: 2131232076}*/:
                this.systemBgShow.set(false);
                this.rearCameraType.set(1);
                FileUtils.savaIntData(KeyConfig.DAO_CHE_SXT, 1);
                return;
            case R.id.mbux_settings_system_fuel_l /*{ENCODED_INT: 2131232079}*/:
                this.systemBgShow.set(false);
                this.fuelUnit.set(0);
                FileUtils.savaIntData(KeyConfig.FUEL_UNIT, 0);
                return;
            case R.id.mbux_settings_system_fuel_uk /*{ENCODED_INT: 2131232081}*/:
                this.systemBgShow.set(false);
                this.fuelUnit.set(2);
                FileUtils.savaIntData(KeyConfig.FUEL_UNIT, 2);
                return;
            case R.id.mbux_settings_system_fuel_us /*{ENCODED_INT: 2131232082}*/:
                this.systemBgShow.set(false);
                this.fuelUnit.set(1);
                FileUtils.savaIntData(KeyConfig.FUEL_UNIT, 1);
                return;
            case R.id.mbux_settings_system_temp_c /*{ENCODED_INT: 2131232092}*/:
                this.systemBgShow.set(false);
                this.tempUnit.set(0);
                FileUtils.savaIntData(KeyConfig.TempUnit, 0);
                return;
            case R.id.mbux_settings_system_temp_f /*{ENCODED_INT: 2131232093}*/:
                this.systemBgShow.set(false);
                this.tempUnit.set(1);
                FileUtils.savaIntData(KeyConfig.TempUnit, 1);
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
        if (observableInt.get() > 0) {
            return "+" + observableInt.get();
        }
        return String.valueOf(observableInt.get());
    }
}

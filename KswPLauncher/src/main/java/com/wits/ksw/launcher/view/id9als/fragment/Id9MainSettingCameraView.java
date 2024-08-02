package com.wits.ksw.launcher.view.id9als.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.databinding.ViewId9MainSettingsCameraBinding;
import com.wits.ksw.settings.bmw_id8.vm.BmwId8SettingsViewModel;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class Id9MainSettingCameraView extends RelativeLayout {
    private final String TAG = Id9MainSettingCameraView.class.getSimpleName();
    private Context context;
    private ViewId9MainSettingsCameraBinding mBinding;
    public BmwId8SettingsViewModel mViewModel;

    public Id9MainSettingCameraView(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = ViewId9MainSettingsCameraBinding.inflate(LayoutInflater.from(context2), null, false);
        this.mBinding.getRoot().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        BmwId8SettingsViewModel instance = BmwId8SettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        addView(this.mBinding.getRoot());
        initView();
        initData();
    }

    private void initView() {
    }

    private void initData() {
        try {
            this.mViewModel.rearCameraType.set(PowerManagerApp.getSettingsInt(KeyConfig.DAO_CHE_SXT));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}

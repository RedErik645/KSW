package com.wits.ksw.launcher.view.id9als.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.databinding.ViewId9MainSettingsTimeBinding;
import com.wits.ksw.settings.bmw_id8.vm.BmwId8SettingsViewModel;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class Id9MainSettingTimeView extends RelativeLayout {
    private final String TAG = "Id9MainSettingTimeView";
    private Context context;
    private ViewId9MainSettingsTimeBinding mBinding;
    private int mCameraType = 0;
    public BmwId8SettingsViewModel mViewModel;

    public Id9MainSettingTimeView(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = ViewId9MainSettingsTimeBinding.inflate(LayoutInflater.from(context2), null, false);
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
            this.mViewModel.timeSyncShow.set(false);
            this.mViewModel.timeFormatShow.set(false);
            this.mViewModel.timeSyncState.set(PowerManagerApp.getSettingsInt(KeyConfig.TIME_SOURCE));
            this.mViewModel.timeFormatState.set(PowerManagerApp.getSettingsInt(KeyConfig.TIME_FORMAT));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}

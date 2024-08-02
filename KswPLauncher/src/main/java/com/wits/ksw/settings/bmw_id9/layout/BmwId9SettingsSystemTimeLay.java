package com.wits.ksw.settings.bmw_id9.layout;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.databinding.BmwId9SettingsSystemTimeLayoutBinding;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BmwId9SettingsSystemTimeLay extends RelativeLayout implements RadioGroup.OnCheckedChangeListener {
    private final String TAG = "BmwId9SettingsSystemTimeLay";
    private Context context;
    private BmwId9SettingsSystemTimeLayoutBinding mBinding;
    private BmwId9SettingsViewModel mViewModel;
    private int timeFormat;
    private int[] timeSettingsId = {R.id.bmw_id9_settings_time_car, R.id.bmw_id9_settings_time_android, R.id.bmw_id9_time_format_12, R.id.bmw_id9_time_format_24};
    private int timeSync;

    public BmwId9SettingsSystemTimeLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BmwId9SettingsSystemTimeLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.bmw_id9_settings_system_time_layout, null, false);
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
            this.mBinding.getRoot().getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
                /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemTimeLay.AnonymousClass1 */

                public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                    Log.i("BmwId9SettingsSystemTimeLay", "onGlobalFocusChanged: " + BmwId9SettingsSystemTimeLay.this.mBinding.bmwId9SettingsSystemTimeLay.hasFocus());
                    if (BmwId9SettingsSystemTimeLay.this.mBinding.bmwId9SettingsSystemTimeLay.hasFocus()) {
                        BmwId9SettingsSystemTimeLay.this.mViewModel.systemBgShow.set(false);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initData() {
        try {
            this.timeSync = PowerManagerApp.getSettingsInt(KeyConfig.TIME_SOURCE);
            this.timeFormat = PowerManagerApp.getSettingsInt(KeyConfig.TIME_FORMAT);
            this.mBinding.bmwId9SettingsTimeSync.setOnCheckedChangeListener(this);
            this.mBinding.bmwId9SettingsTimeSync.check(this.timeSync == 0 ? R.id.bmw_id9_settings_time_android : R.id.bmw_id9_settings_time_car);
            this.mBinding.bmwId9SettingsTimeFormat.setOnCheckedChangeListener(this);
            this.mBinding.bmwId9SettingsTimeFormat.check(this.timeFormat == 0 ? R.id.bmw_id9_time_format_24 : R.id.bmw_id9_time_format_12);
            int i = 0;
            while (true) {
                int[] iArr = this.timeSettingsId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnTouchListener(new View.OnTouchListener() {
                        /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemTimeLay.AnonymousClass2 */

                        public boolean onTouch(View v, MotionEvent event) {
                            Log.i("BmwId9SettingsSystemTimeLay", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
                            if (event.getAction() != 1 || v.isFocused()) {
                                return false;
                            }
                            v.requestFocus();
                            return false;
                        }
                    });
                    i++;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.bmw_id9_settings_time_android /*{ENCODED_INT: 2131231233}*/:
                FileUtils.savaIntData(KeyConfig.TIME_SOURCE, 0);
                return;
            case R.id.bmw_id9_settings_time_car /*{ENCODED_INT: 2131231234}*/:
                FileUtils.savaIntData(KeyConfig.TIME_SOURCE, 1);
                return;
            case R.id.bmw_id9_time_format_12 /*{ENCODED_INT: 2131231240}*/:
                FileUtils.savaIntData(KeyConfig.TIME_FORMAT, 1);
                return;
            case R.id.bmw_id9_time_format_24 /*{ENCODED_INT: 2131231241}*/:
                FileUtils.savaIntData(KeyConfig.TIME_FORMAT, 0);
                return;
            default:
                return;
        }
    }
}

package com.wits.ksw.settings.benz_mbux_2021.layout;

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
import com.wits.ksw.databinding.BenzMbuxSettingsSystemTimeLayoutBinding;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BenzMbuxSettingsSystemTimeLay extends RelativeLayout implements RadioGroup.OnCheckedChangeListener {
    private final String TAG = "BenzMbuxSettingsSystemTimeLay";
    private Context context;
    private BenzMbuxSettingsSystemTimeLayoutBinding mBinding;
    private BenzMbuxSettingsViewModel mViewModel;
    private int timeFormat;
    private int[] timeSettingsId = {R.id.mbux_settings_time_car, R.id.mbux_settings_time_android, R.id.mbux_time_format_12, R.id.mbux_time_format_24};
    private int timeSync;

    public BenzMbuxSettingsSystemTimeLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BenzMbuxSettingsSystemTimeLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.benz_mbux_settings_system_time_layout, null, false);
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
            this.mBinding.getRoot().getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
                /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemTimeLay.AnonymousClass1 */

                public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                    Log.i("BenzMbuxSettingsSystemTimeLay", "onGlobalFocusChanged: " + BenzMbuxSettingsSystemTimeLay.this.mBinding.mbuxSettingsSystemTimeLay.hasFocus());
                    if (BenzMbuxSettingsSystemTimeLay.this.mBinding.mbuxSettingsSystemTimeLay.hasFocus()) {
                        BenzMbuxSettingsSystemTimeLay.this.mViewModel.systemBgShow.set(false);
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
            this.mBinding.mbuxSettingsTimeSync.setOnCheckedChangeListener(this);
            this.mBinding.mbuxSettingsTimeSync.check(this.timeSync == 0 ? R.id.mbux_settings_time_android : R.id.mbux_settings_time_car);
            this.mBinding.mbuxSettingsTimeFormat.setOnCheckedChangeListener(this);
            this.mBinding.mbuxSettingsTimeFormat.check(this.timeFormat == 0 ? R.id.mbux_time_format_24 : R.id.mbux_time_format_12);
            int i = 0;
            while (true) {
                int[] iArr = this.timeSettingsId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnTouchListener(new View.OnTouchListener() {
                        /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemTimeLay.AnonymousClass2 */

                        public boolean onTouch(View v, MotionEvent event) {
                            Log.i("BenzMbuxSettingsSystemTimeLay", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
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
            case R.id.mbux_settings_time_android /*{ENCODED_INT: 2131232098}*/:
                FileUtils.savaIntData(KeyConfig.TIME_SOURCE, 0);
                return;
            case R.id.mbux_settings_time_car /*{ENCODED_INT: 2131232099}*/:
                FileUtils.savaIntData(KeyConfig.TIME_SOURCE, 1);
                return;
            case R.id.mbux_time_format_12 /*{ENCODED_INT: 2131232105}*/:
                FileUtils.savaIntData(KeyConfig.TIME_FORMAT, 1);
                return;
            case R.id.mbux_time_format_24 /*{ENCODED_INT: 2131232106}*/:
                FileUtils.savaIntData(KeyConfig.TIME_FORMAT, 0);
                return;
            default:
                return;
        }
    }
}

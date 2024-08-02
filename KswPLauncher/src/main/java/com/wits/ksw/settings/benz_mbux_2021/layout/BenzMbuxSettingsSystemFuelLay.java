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
import com.wits.ksw.databinding.BenzMbuxSettingsSystemFuelLayoutBinding;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BenzMbuxSettingsSystemFuelLay extends RelativeLayout {
    private final String TAG = "BenzMbuxSettingsSystemFuelLay";
    private Context context;
    private BenzMbuxSettingsSystemFuelLayoutBinding mBinding;
    private int mFuelUnit = 0;
    private BenzMbuxSettingsViewModel mViewModel;
    private int[] relativeLayoutId = {R.id.mbux_settings_system_fuel_l, R.id.mbux_settings_system_fuel_us, R.id.mbux_settings_system_fuel_uk};

    public BenzMbuxSettingsSystemFuelLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BenzMbuxSettingsSystemFuelLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.benz_mbux_settings_system_fuel_layout, null, false);
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
                /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemFuelLay.AnonymousClass1 */

                public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                    Log.i("BenzMbuxSettingsSystemFuelLay", "onGlobalFocusChanged: " + BenzMbuxSettingsSystemFuelLay.this.mBinding.mbuxSettingsSystemFuelLay.hasFocus());
                    if (BenzMbuxSettingsSystemFuelLay.this.mBinding.mbuxSettingsSystemFuelLay.hasFocus()) {
                        BenzMbuxSettingsSystemFuelLay.this.mViewModel.systemBgShow.set(false);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initData() {
        try {
            this.mFuelUnit = PowerManagerApp.getSettingsInt(KeyConfig.FUEL_UNIT);
            this.mViewModel.fuelUnit.set(this.mFuelUnit);
            Log.i("BenzMbuxSettingsSystemFuelLay", " mFuelUnit " + this.mFuelUnit);
            int i = 0;
            while (true) {
                int[] iArr = this.relativeLayoutId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnTouchListener(new View.OnTouchListener() {
                        /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemFuelLay.AnonymousClass2 */

                        public boolean onTouch(View v, MotionEvent event) {
                            Log.i("BenzMbuxSettingsSystemFuelLay", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
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
}

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
import com.wits.ksw.databinding.BmwId9SettingsSystemFuelLayoutBinding;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BmwId9SettingsSystemFuelLay extends RelativeLayout {
    private final String TAG = "BmwId9SettingsSystemFuelLay";
    private Context context;
    private BmwId9SettingsSystemFuelLayoutBinding mBinding;
    private int mFuelUnit = 0;
    private BmwId9SettingsViewModel mViewModel;
    private int[] relativeLayoutId = {R.id.bmw_id9_settings_system_fuel_l, R.id.bmw_id9_settings_system_fuel_us, R.id.bmw_id9_settings_system_fuel_uk};

    public BmwId9SettingsSystemFuelLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BmwId9SettingsSystemFuelLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.bmw_id9_settings_system_fuel_layout, null, false);
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
                /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemFuelLay.AnonymousClass1 */

                public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                    Log.i("BmwId9SettingsSystemFuelLay", "onGlobalFocusChanged: " + BmwId9SettingsSystemFuelLay.this.mBinding.bmwId9SettingsSystemFuelLay.hasFocus());
                    if (BmwId9SettingsSystemFuelLay.this.mBinding.bmwId9SettingsSystemFuelLay.hasFocus()) {
                        BmwId9SettingsSystemFuelLay.this.mViewModel.systemBgShow.set(false);
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
            Log.i("BmwId9SettingsSystemFuelLay", " mFuelUnit " + this.mFuelUnit);
            int i = 0;
            while (true) {
                int[] iArr = this.relativeLayoutId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnTouchListener(new View.OnTouchListener() {
                        /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemFuelLay.AnonymousClass2 */

                        public boolean onTouch(View v, MotionEvent event) {
                            Log.i("BmwId9SettingsSystemFuelLay", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
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

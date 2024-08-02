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
import com.wits.ksw.databinding.BmwId9SettingsSystemTempLayoutBinding;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BmwId9SettingsSystemTempLay extends RelativeLayout {
    private final String TAG = "BmwId9SettingsSystemTempLay";
    private Context context;
    private BmwId9SettingsSystemTempLayoutBinding mBinding;
    private int mTempUnit = 0;
    private BmwId9SettingsViewModel mViewModel;
    private int[] relativeLayoutId = {R.id.bmw_id9_settings_system_temp_c, R.id.bmw_id9_settings_system_temp_f};

    public BmwId9SettingsSystemTempLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BmwId9SettingsSystemTempLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.bmw_id9_settings_system_temp_layout, null, false);
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
                /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemTempLay.AnonymousClass1 */

                public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                    Log.i("BmwId9SettingsSystemTempLay", "onGlobalFocusChanged: " + BmwId9SettingsSystemTempLay.this.mBinding.bmwId9SettingsSystemTempLay.hasFocus());
                    if (BmwId9SettingsSystemTempLay.this.mBinding.bmwId9SettingsSystemTempLay.hasFocus()) {
                        BmwId9SettingsSystemTempLay.this.mViewModel.systemBgShow.set(false);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initData() {
        try {
            this.mTempUnit = PowerManagerApp.getSettingsInt(KeyConfig.TempUnit);
            this.mViewModel.tempUnit.set(this.mTempUnit);
            Log.i("BmwId9SettingsSystemTempLay", " mTempUnit " + this.mTempUnit);
            int i = 0;
            while (true) {
                int[] iArr = this.relativeLayoutId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnTouchListener(new View.OnTouchListener() {
                        /* class com.wits.ksw.settings.bmw_id9.layout.BmwId9SettingsSystemTempLay.AnonymousClass2 */

                        public boolean onTouch(View v, MotionEvent event) {
                            Log.i("BmwId9SettingsSystemTempLay", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
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

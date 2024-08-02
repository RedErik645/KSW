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
import com.wits.ksw.databinding.BenzMbuxSettingsSystemCameraLayoutBinding;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BenzMbuxSettingsSystemCameraLay extends RelativeLayout {
    private final String TAG = "BenzMbuxSettingsSystemCameraLay";
    private Context context;
    private BenzMbuxSettingsSystemCameraLayoutBinding mBinding;
    private int mCameraType = 0;
    private BenzMbuxSettingsViewModel mViewModel;
    private int[] relativeLayoutId = {R.id.mbux_settings_system_camera_after, R.id.mbux_settings_system_camera_oem, R.id.mbux_settings_system_camera_360, R.id.mbux_settings_system_camera_360_built};

    public BenzMbuxSettingsSystemCameraLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BenzMbuxSettingsSystemCameraLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.benz_mbux_settings_system_camera_layout, null, false);
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
                /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemCameraLay.AnonymousClass1 */

                public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                    Log.i("BenzMbuxSettingsSystemCameraLay", "onGlobalFocusChanged: " + BenzMbuxSettingsSystemCameraLay.this.mBinding.mbuxSettingsSystemCameraLay.hasFocus());
                    if (BenzMbuxSettingsSystemCameraLay.this.mBinding.mbuxSettingsSystemCameraLay.hasFocus()) {
                        BenzMbuxSettingsSystemCameraLay.this.mViewModel.systemBgShow.set(false);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initData() {
        try {
            this.mCameraType = PowerManagerApp.getSettingsInt(KeyConfig.DAO_CHE_SXT);
            this.mViewModel.rearCameraType.set(this.mCameraType);
            Log.i("BenzMbuxSettingsSystemCameraLay", " mCameraType " + this.mCameraType);
            int i = 0;
            while (true) {
                int[] iArr = this.relativeLayoutId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnTouchListener(new View.OnTouchListener() {
                        /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemCameraLay.AnonymousClass2 */

                        public boolean onTouch(View v, MotionEvent event) {
                            Log.i("BenzMbuxSettingsSystemCameraLay", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
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

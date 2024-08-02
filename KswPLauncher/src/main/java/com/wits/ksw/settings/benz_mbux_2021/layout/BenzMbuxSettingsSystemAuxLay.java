package com.wits.ksw.settings.benz_mbux_2021.layout;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.databinding.BenzMbuxSettingsSystemAuxLayoutBinding;
import com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BenzMbuxSettingsSystemAuxLay extends RelativeLayout implements View.OnClickListener, BenzMbuxProgressBar.OnValueChangeListener, BenzMbuxProgressBar.OnTouchChangeListener {
    private final String TAG = "BenzMbuxSettingsSystemAuxLay";
    private int aux_index1;
    private int aux_index2;
    private Context context;
    private int[] imageButtonId = {R.id.mbux_settings_aux1_sub_btn, R.id.mbux_settings_aux1_add_btn, R.id.mbux_settings_aux2_sub_btn, R.id.mbux_settings_aux2_add_btn};
    private Handler mBackgroundHandler;
    private BenzMbuxSettingsSystemAuxLayoutBinding mBinding;
    private BenzMbuxSettingsViewModel mViewModel;

    public BenzMbuxSettingsSystemAuxLay(Context context2) {
        super(context2);
        this.context = context2;
        this.mBinding = (BenzMbuxSettingsSystemAuxLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context2), R.layout.benz_mbux_settings_system_aux_layout, null, false);
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
            this.mBinding.mbuxSettingsAux1Seekbar.setOnValueChangeListener(this);
            this.mBinding.mbuxSettingsAux1Seekbar.setOnTouchChangeListener(this);
            this.mBinding.mbuxSettingsAux2Seekbar.setOnValueChangeListener(this);
            this.mBinding.mbuxSettingsAux2Seekbar.setOnTouchChangeListener(this);
            int i = 0;
            while (true) {
                int[] iArr = this.imageButtonId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnClickListener(this);
                    findViewById(this.imageButtonId[i]).setOnTouchListener(new View.OnTouchListener() {
                        /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemAuxLay.AnonymousClass1 */

                        public boolean onTouch(View v, MotionEvent event) {
                            Log.i("BenzMbuxSettingsSystemAuxLay", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
                            if (event.getAction() != 1 || v.isFocused()) {
                                return false;
                            }
                            v.requestFocus();
                            return false;
                        }
                    });
                    i++;
                } else {
                    this.mBinding.getRoot().getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
                        /* class com.wits.ksw.settings.benz_mbux_2021.layout.BenzMbuxSettingsSystemAuxLay.AnonymousClass2 */

                        public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                            Log.i("BenzMbuxSettingsSystemAuxLay", "onGlobalFocusChanged: " + BenzMbuxSettingsSystemAuxLay.this.mBinding.mbuxSettingsAuxLay.hasFocus());
                            if (BenzMbuxSettingsSystemAuxLay.this.mBinding.mbuxSettingsAuxLay.hasFocus()) {
                                BenzMbuxSettingsSystemAuxLay.this.mViewModel.systemBgShow.set(false);
                            }
                        }
                    });
                    return;
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private void initData() {
        try {
            this.mBackgroundHandler = new Handler(Looper.getMainLooper());
            this.aux_index1 = PowerManagerApp.getSettingsInt(KeyConfig.CAR_AUX_INDEX1);
            this.aux_index2 = PowerManagerApp.getSettingsInt(KeyConfig.CAR_AUX_INDEX2);
            this.mBinding.mbuxSettingsAux1TextValue.setText(String.valueOf(this.aux_index1));
            this.mBinding.mbuxSettingsAux1Seekbar.setMax(12);
            this.mBinding.mbuxSettingsAux1Seekbar.setValue(this.aux_index1);
            this.mBinding.mbuxSettingsAux2TextValue.setText(String.valueOf(this.aux_index2));
            this.mBinding.mbuxSettingsAux2Seekbar.setMax(12);
            this.mBinding.mbuxSettingsAux2Seekbar.setValue(this.aux_index2);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mbux_settings_aux1_add_btn /*{ENCODED_INT: 2131232016}*/:
                this.mBinding.mbuxSettingsAux1Seekbar.setValue(this.mBinding.mbuxSettingsAux1Seekbar.getValue() + 1);
                return;
            case R.id.mbux_settings_aux1_sub_btn /*{ENCODED_INT: 2131232018}*/:
                this.mBinding.mbuxSettingsAux1Seekbar.setValue(this.mBinding.mbuxSettingsAux1Seekbar.getValue() - 1);
                return;
            case R.id.mbux_settings_aux2_add_btn /*{ENCODED_INT: 2131232021}*/:
                this.mBinding.mbuxSettingsAux2Seekbar.setValue(this.mBinding.mbuxSettingsAux2Seekbar.getValue() + 1);
                return;
            case R.id.mbux_settings_aux2_sub_btn /*{ENCODED_INT: 2131232023}*/:
                this.mBinding.mbuxSettingsAux2Seekbar.setValue(this.mBinding.mbuxSettingsAux2Seekbar.getValue() - 1);
                return;
            default:
                return;
        }
    }

    @Override // com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar.OnValueChangeListener
    public void onValueChange(BenzMbuxProgressBar progressBar, int value, float progress) {
        Log.i("BenzMbuxSettingsSystemAuxLay", " value " + value);
        if (progressBar.getId() == R.id.mbux_settings_aux1_seekbar) {
            this.mBinding.mbuxSettingsAux1TextValue.setText(String.valueOf(value));
            FileUtils.savaIntData(KeyConfig.CAR_AUX_INDEX1, value);
        } else if (progressBar.getId() == R.id.mbux_settings_aux2_seekbar) {
            this.mBinding.mbuxSettingsAux2TextValue.setText(String.valueOf(value));
            FileUtils.savaIntData(KeyConfig.CAR_AUX_INDEX2, value);
        }
    }

    @Override // com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar.OnTouchChangeListener
    public void onStartTrackingTouch(BenzMbuxProgressBar progressBar) {
        this.mViewModel.systemBgShow.set(false);
        progressBar.requestFocus();
    }

    @Override // com.wits.ksw.launcher.view.benzmbux2021new.BenzMbuxProgressBar.OnTouchChangeListener
    public void onStopTrackingTouch(BenzMbuxProgressBar progressBar) {
    }
}

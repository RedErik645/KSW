package com.wits.ksw.settings.benz_mbux_2021.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityBenzMbuxSettingsFactoryLayoutBinding;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.settings.BaseSkinActivity;
import com.wits.ksw.settings.TxzMessage;
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;
import com.wits.ksw.settings.id7.FactoryActivity;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BenzMbuxSettingsFactoryActivity extends BaseSkinActivity implements View.OnClickListener {
    private final String TAG = "BenzMbuxSettingsFactoryActivity";
    private String defPwd = "1314";
    private int[] imageViewId = {R.id.mbux_settings_factory_1_btn, R.id.mbux_settings_factory_2_btn, R.id.mbux_settings_factory_3_btn, R.id.mbux_settings_factory_4_btn, R.id.mbux_settings_factory_5_btn, R.id.mbux_settings_factory_6_btn, R.id.mbux_settings_factory_7_btn, R.id.mbux_settings_factory_8_btn, R.id.mbux_settings_factory_9_btn, R.id.mbux_settings_factory_0_btn, R.id.mbux_settings_factory_del_btn, R.id.mbux_settings_factory_enter_btn};
    private ActivityBenzMbuxSettingsFactoryLayoutBinding mBinding;
    private BenzMbuxSettingsViewModel mViewModel;
    private StringBuffer pwdInput;

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseSkinActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BenzMbuxSettingsFactoryActivity", " onCreate ");
        this.mBinding = (ActivityBenzMbuxSettingsFactoryLayoutBinding) DataBindingUtil.setContentView(this, R.layout.activity_benz_mbux_settings_factory_layout);
        BenzMbuxSettingsViewModel instance = BenzMbuxSettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        initView();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("BenzMbuxSettingsFactoryActivity", " onNewIntent ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i("BenzMbuxSettingsFactoryActivity", " onResume ");
        initData();
    }

    private void initView() {
        this.pwdInput = new StringBuffer();
        int i = 0;
        while (true) {
            int[] iArr = this.imageViewId;
            if (i < iArr.length) {
                findViewById(iArr[i]).setOnClickListener(this);
                i++;
            } else {
                this.mBinding.mbuxSettingsFactoryDelBtn.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class com.wits.ksw.settings.benz_mbux_2021.activity.BenzMbuxSettingsFactoryActivity.AnonymousClass1 */

                    public boolean onLongClick(View view) {
                        BenzMbuxSettingsFactoryActivity.this.deletePwdText();
                        return true;
                    }
                });
                return;
            }
        }
    }

    private void initData() {
        try {
            deletePwdText();
            this.defPwd = PowerManagerApp.getSettingsString(KeyConfig.PASSWORD);
            Log.d("BenzMbuxSettingsFactoryActivity", "===pwd====:" + this.defPwd);
            if (TextUtils.isEmpty(this.defPwd)) {
                this.defPwd = "1314";
            }
        } catch (Exception e) {
            e.getStackTrace();
            this.defPwd = "1314";
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mbux_settings_factory_0_btn /*{ENCODED_INT: 2131232034}*/:
                inputPwdText(TxzMessage.TXZ_DISMISS);
                return;
            case R.id.mbux_settings_factory_1_btn /*{ENCODED_INT: 2131232035}*/:
                inputPwdText("1");
                return;
            case R.id.mbux_settings_factory_2_btn /*{ENCODED_INT: 2131232036}*/:
                inputPwdText("2");
                return;
            case R.id.mbux_settings_factory_3_btn /*{ENCODED_INT: 2131232037}*/:
                inputPwdText("3");
                return;
            case R.id.mbux_settings_factory_4_btn /*{ENCODED_INT: 2131232038}*/:
                inputPwdText("4");
                return;
            case R.id.mbux_settings_factory_5_btn /*{ENCODED_INT: 2131232039}*/:
                inputPwdText(Id9AlsConstants.ID9ALS_SELECT_MODEL_VITALITY);
                return;
            case R.id.mbux_settings_factory_6_btn /*{ENCODED_INT: 2131232040}*/:
                inputPwdText(Id9AlsConstants.ID9ALS_SELECT_MODEL_MYSTERIOUS);
                return;
            case R.id.mbux_settings_factory_7_btn /*{ENCODED_INT: 2131232041}*/:
                inputPwdText(Id9AlsConstants.ID9ALS_SELECT_MODEL_STEADY);
                return;
            case R.id.mbux_settings_factory_8_btn /*{ENCODED_INT: 2131232042}*/:
                inputPwdText("8");
                return;
            case R.id.mbux_settings_factory_9_btn /*{ENCODED_INT: 2131232043}*/:
                inputPwdText("9");
                return;
            case R.id.mbux_settings_factory_del_btn /*{ENCODED_INT: 2131232044}*/:
                if (TextUtils.equals(this.mBinding.mbuxSettingsFactoryPsw.getText().toString(), getResources().getString(R.string.lb_password_error))) {
                    deletePwdText();
                }
                if (this.pwdInput.length() > 0) {
                    StringBuffer stringBuffer = this.pwdInput;
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    this.mBinding.mbuxSettingsFactoryPsw.setText(this.pwdInput.toString());
                    return;
                }
                return;
            case R.id.mbux_settings_factory_enter_btn /*{ENCODED_INT: 2131232045}*/:
                if (TextUtils.equals(this.defPwd, this.pwdInput.toString())) {
                    deletePwdText();
                    startActivity(new Intent(this, FactoryActivity.class));
                    finish();
                    return;
                }
                this.mBinding.mbuxSettingsFactoryPsw.setText(getResources().getString(R.string.lb_password_error));
                return;
            default:
                return;
        }
    }

    private void inputPwdText(String str) {
        try {
            if (TextUtils.equals(this.mBinding.mbuxSettingsFactoryPsw.getText().toString(), getResources().getString(R.string.lb_password_error))) {
                deletePwdText();
            }
            if (this.pwdInput.length() <= 8) {
                this.pwdInput.append(str);
                this.mBinding.mbuxSettingsFactoryPsw.setText(this.pwdInput.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void deletePwdText() {
        if (this.pwdInput.length() > 0) {
            StringBuffer stringBuffer = this.pwdInput;
            stringBuffer.delete(0, stringBuffer.length());
            this.mBinding.mbuxSettingsFactoryPsw.setText(this.pwdInput.toString());
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i("BenzMbuxSettingsFactoryActivity", " onStop ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("BenzMbuxSettingsFactoryActivity", " onDestroy ");
    }

    public void onPointerCaptureChanged(boolean hasCapture) {
    }
}

package com.wits.ksw.settings.bmw_id9.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityBmwId9SettingsFactoryLayoutBinding;
import com.wits.ksw.launcher.view.id9als.Id9AlsConstants;
import com.wits.ksw.settings.BaseSkinActivity;
import com.wits.ksw.settings.TxzMessage;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;
import com.wits.ksw.settings.id7.FactoryActivity;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BmwId9SettingsFactoryActivity extends BaseSkinActivity implements View.OnClickListener {
    private final String TAG = "BmwId9SettingsFactoryActivity";
    private String defPwd = "1314";
    private int[] imageViewId = {R.id.bmw_id9_settings_factory_1_btn, R.id.bmw_id9_settings_factory_2_btn, R.id.bmw_id9_settings_factory_3_btn, R.id.bmw_id9_settings_factory_4_btn, R.id.bmw_id9_settings_factory_5_btn, R.id.bmw_id9_settings_factory_6_btn, R.id.bmw_id9_settings_factory_7_btn, R.id.bmw_id9_settings_factory_8_btn, R.id.bmw_id9_settings_factory_9_btn, R.id.bmw_id9_settings_factory_0_btn, R.id.bmw_id9_settings_factory_del_btn, R.id.bmw_id9_settings_factory_enter_btn};
    private ActivityBmwId9SettingsFactoryLayoutBinding mBinding;
    private BmwId9SettingsViewModel mViewModel;
    private StringBuffer pwdInput;

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseSkinActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BmwId9SettingsFactoryActivity", " onCreate ");
        this.mBinding = (ActivityBmwId9SettingsFactoryLayoutBinding) DataBindingUtil.setContentView(this, R.layout.activity_bmw_id9_settings_factory_layout);
        BmwId9SettingsViewModel instance = BmwId9SettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        initView();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("BmwId9SettingsFactoryActivity", " onNewIntent ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i("BmwId9SettingsFactoryActivity", " onResume ");
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
                this.mBinding.bmwId9SettingsFactoryDelBtn.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class com.wits.ksw.settings.bmw_id9.activity.BmwId9SettingsFactoryActivity.AnonymousClass1 */

                    public boolean onLongClick(View view) {
                        BmwId9SettingsFactoryActivity.this.deletePwdText();
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
            Log.d("BmwId9SettingsFactoryActivity", "===pwd====:" + this.defPwd);
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
            case R.id.bmw_id9_settings_factory_0_btn /*{ENCODED_INT: 2131231164}*/:
                inputPwdText(TxzMessage.TXZ_DISMISS);
                return;
            case R.id.bmw_id9_settings_factory_1_btn /*{ENCODED_INT: 2131231165}*/:
                inputPwdText("1");
                return;
            case R.id.bmw_id9_settings_factory_2_btn /*{ENCODED_INT: 2131231166}*/:
                inputPwdText("2");
                return;
            case R.id.bmw_id9_settings_factory_3_btn /*{ENCODED_INT: 2131231167}*/:
                inputPwdText("3");
                return;
            case R.id.bmw_id9_settings_factory_4_btn /*{ENCODED_INT: 2131231168}*/:
                inputPwdText("4");
                return;
            case R.id.bmw_id9_settings_factory_5_btn /*{ENCODED_INT: 2131231169}*/:
                inputPwdText(Id9AlsConstants.ID9ALS_SELECT_MODEL_VITALITY);
                return;
            case R.id.bmw_id9_settings_factory_6_btn /*{ENCODED_INT: 2131231170}*/:
                inputPwdText(Id9AlsConstants.ID9ALS_SELECT_MODEL_MYSTERIOUS);
                return;
            case R.id.bmw_id9_settings_factory_7_btn /*{ENCODED_INT: 2131231171}*/:
                inputPwdText(Id9AlsConstants.ID9ALS_SELECT_MODEL_STEADY);
                return;
            case R.id.bmw_id9_settings_factory_8_btn /*{ENCODED_INT: 2131231172}*/:
                inputPwdText("8");
                return;
            case R.id.bmw_id9_settings_factory_9_btn /*{ENCODED_INT: 2131231173}*/:
                inputPwdText("9");
                return;
            case R.id.bmw_id9_settings_factory_del_btn /*{ENCODED_INT: 2131231174}*/:
                if (TextUtils.equals(this.mBinding.bmwId9SettingsFactoryPsw.getText().toString(), getResources().getString(R.string.lb_password_error))) {
                    deletePwdText();
                }
                if (this.pwdInput.length() > 0) {
                    StringBuffer stringBuffer = this.pwdInput;
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    this.mBinding.bmwId9SettingsFactoryPsw.setText(this.pwdInput.toString());
                    return;
                }
                return;
            case R.id.bmw_id9_settings_factory_enter_btn /*{ENCODED_INT: 2131231175}*/:
                if (TextUtils.equals(this.defPwd, this.pwdInput.toString())) {
                    deletePwdText();
                    startActivity(new Intent(this, FactoryActivity.class));
                    finish();
                    return;
                }
                this.mBinding.bmwId9SettingsFactoryPsw.setText(getResources().getString(R.string.lb_password_error));
                return;
            default:
                return;
        }
    }

    private void inputPwdText(String str) {
        try {
            if (TextUtils.equals(this.mBinding.bmwId9SettingsFactoryPsw.getText().toString(), getResources().getString(R.string.lb_password_error))) {
                deletePwdText();
            }
            if (this.pwdInput.length() <= 8) {
                this.pwdInput.append(str);
                this.mBinding.bmwId9SettingsFactoryPsw.setText(this.pwdInput.toString());
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
            this.mBinding.bmwId9SettingsFactoryPsw.setText(this.pwdInput.toString());
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i("BmwId9SettingsFactoryActivity", " onStop ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("BmwId9SettingsFactoryActivity", " onDestroy ");
    }

    public void onPointerCaptureChanged(boolean hasCapture) {
    }
}

package com.wits.ksw.settings.audi_mib3;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.databinding.AudiMib3PasswordBinding;
import com.wits.ksw.settings.BaseActivity;
import com.wits.ksw.settings.audi_mib3.vm.AudiMib3SettingViewModel;
import com.wits.ksw.settings.utlis_view.ToastUtils;

public class AudiMib3PasswordActivity extends BaseActivity {
    private AudiMib3SettingViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AudiMib3PasswordBinding binding = (AudiMib3PasswordBinding) DataBindingUtil.setContentView(this, R.layout.audi_mib3_password);
        AudiMib3SettingViewModel audiMib3SettingViewModel = (AudiMib3SettingViewModel) ViewModelProviders.of(this).get(AudiMib3SettingViewModel.class);
        this.viewModel = audiMib3SettingViewModel;
        binding.setVm(audiMib3SettingViewModel);
        binding.audiKeyOk.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.audi_mib3.$$Lambda$AudiMib3PasswordActivity$bo7bbOL4xcmbWX3npz5vgQBGYwY */

            public final void onClick(View view) {
                AudiMib3PasswordActivity.this.lambda$onCreate$0$AudiMib3PasswordActivity(view);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$AudiMib3PasswordActivity(View v) {
        if (this.viewModel.isPasswordCorrect()) {
            AudiMib3StartUtil.FactoryActivity(this);
            finish();
            return;
        }
        ToastUtils.showToast(this, getString(R.string.lb_password_error), 0);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AudiMib3SettingViewModel audiMib3SettingViewModel = this.viewModel;
        if (audiMib3SettingViewModel != null) {
            audiMib3SettingViewModel.onDeleteLongClick(null);
        }
        super.onDestroy();
    }
}
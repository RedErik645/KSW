package com.wits.ksw.settings.audi;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.databinding.AudiPasswordBinding;
import com.wits.ksw.settings.BaseActivity;
import com.wits.ksw.settings.audi.vm.AudiSettingViewModel;
import com.wits.ksw.settings.utlis_view.ToastUtils;

public class AudiPasswordActivity extends BaseActivity {
    private AudiSettingViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AudiPasswordBinding binding = (AudiPasswordBinding) DataBindingUtil.setContentView(this, R.layout.audi_password);
        AudiSettingViewModel audiSettingViewModel = (AudiSettingViewModel) ViewModelProviders.of(this).get(AudiSettingViewModel.class);
        this.viewModel = audiSettingViewModel;
        binding.setVm(audiSettingViewModel);
        binding.audiKeyOk.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.audi.$$Lambda$AudiPasswordActivity$7lFtVRrtPk1dOhhjohvTJdSMKA */

            public final void onClick(View view) {
                AudiPasswordActivity.this.lambda$onCreate$0$AudiPasswordActivity(view);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$AudiPasswordActivity(View v) {
        if (this.viewModel.isPasswordCorrect()) {
            StartUtil.FactoryActivity(this);
            finish();
            return;
        }
        ToastUtils.showToast(this, getString(R.string.lb_password_error), 0);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AudiSettingViewModel audiSettingViewModel = this.viewModel;
        if (audiSettingViewModel != null) {
            audiSettingViewModel.onDeleteLongClick(null);
        }
        super.onDestroy();
    }
}

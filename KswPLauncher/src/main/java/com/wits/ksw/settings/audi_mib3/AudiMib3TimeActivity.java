package com.wits.ksw.settings.audi_mib3;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityAudiMib3TimeBinding;
import com.wits.ksw.settings.audi_mib3.vm.AudiMib3SettingViewModel;

public class AudiMib3TimeActivity extends AudiMib3SubActivity {
    private ActivityAudiMib3TimeBinding binding;
    private AudiMib3SettingViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.settings.audi_mib3.AudiMib3SubActivity, android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = (ActivityAudiMib3TimeBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_audi_mib3_time, null, false);
        this.contentLayout.addView(this.binding.getRoot(), -1, -1);
        AudiMib3SettingViewModel audiMib3SettingViewModel = (AudiMib3SettingViewModel) ViewModelProviders.of(this).get(AudiMib3SettingViewModel.class);
        this.viewModel = audiMib3SettingViewModel;
        this.binding.setVm(audiMib3SettingViewModel);
        this.tv_title_set.setText(getResources().getString(R.string.item6));
    }
}

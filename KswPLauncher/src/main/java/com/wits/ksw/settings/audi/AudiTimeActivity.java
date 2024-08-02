package com.wits.ksw.settings.audi;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityAudiTimeBinding;
import com.wits.ksw.settings.audi.vm.AudiSettingViewModel;

public class AudiTimeActivity extends AudiSubActivity {
    private ActivityAudiTimeBinding binding;
    private AudiSettingViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.settings.audi.AudiSubActivity, android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = (ActivityAudiTimeBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_audi_time, null, false);
        this.contentLayout.addView(this.binding.getRoot(), -1, -1);
        AudiSettingViewModel audiSettingViewModel = (AudiSettingViewModel) ViewModelProviders.of(this).get(AudiSettingViewModel.class);
        this.viewModel = audiSettingViewModel;
        this.binding.setVm(audiSettingViewModel);
        this.tv_title_set.setText(getResources().getString(R.string.item6));
    }
}

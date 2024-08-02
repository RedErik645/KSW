package com.wits.ksw.settings.audi_mib3;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.wits.ksw.R;
import com.wits.ksw.databinding.AudiMib3EqCustomViewBinding;
import com.wits.ksw.settings.audi_mib3.vm.AudiMib3EQViewModel;

public class AudiMib3EqCustomActivity extends AudiMib3SubActivity {
    private AudiMib3EqCustomViewBinding binding;
    private AudiMib3EQViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.settings.audi_mib3.AudiMib3SubActivity, android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = (AudiMib3EqCustomViewBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.audi_mib3_eq_custom_view, null, false);
        this.contentLayout.addView(this.binding.getRoot(), -1, -1);
        AudiMib3EQViewModel audiMib3EQViewModel = (AudiMib3EQViewModel) ViewModelProviders.of(this).get(AudiMib3EQViewModel.class);
        this.viewModel = audiMib3EQViewModel;
        this.binding.setVm(audiMib3EQViewModel);
        this.tv_title_set.setText(getResources().getString(R.string.audi_set_eq_user));
    }
}

package com.wits.ksw.settings.audi;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.wits.ksw.R;
import com.wits.ksw.databinding.AudiEqViewBinding;
import com.wits.ksw.settings.audi.vm.EQViewModel;

public class AudiEqActivity extends AudiSubActivity {
    private AudiEqViewBinding binding;
    private EQViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.settings.audi.AudiSubActivity, android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = (AudiEqViewBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.audi_eq_view, null, false);
        this.contentLayout.addView(this.binding.getRoot(), -1, -1);
        EQViewModel eQViewModel = (EQViewModel) ViewModelProviders.of(this).get(EQViewModel.class);
        this.viewModel = eQViewModel;
        this.binding.setVm(eQViewModel);
        this.tv_title_set.setText(getResources().getString(R.string.item4));
    }
}

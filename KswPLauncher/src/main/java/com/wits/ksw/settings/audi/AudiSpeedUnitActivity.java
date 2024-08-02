package com.wits.ksw.settings.audi;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.wits.ksw.R;
import com.wits.ksw.databinding.AudiSpeedUnitBinding;

public class AudiSpeedUnitActivity extends AudiSubActivity {
    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.settings.audi.AudiSubActivity, android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AudiSpeedUnitBinding binding = (AudiSpeedUnitBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.audi_speed_unit, null, false);
        this.contentLayout.addView(binding.getRoot(), -1, -1);
        binding.setVm(AudiSettingMainActivity.getInstance.viewModel);
        this.tv_title_set.setText(getResources().getString(R.string.function_text24));
    }
}
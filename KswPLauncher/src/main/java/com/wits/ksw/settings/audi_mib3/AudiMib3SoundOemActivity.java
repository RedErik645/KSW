package com.wits.ksw.settings.audi_mib3;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityAudiMib3SoundOemBinding;
import com.wits.ksw.settings.audi_mib3.vm.AudiMib3VolumeViewModel;

public class AudiMib3SoundOemActivity extends AudiMib3SubActivity {
    private ActivityAudiMib3SoundOemBinding binding;
    private AudiMib3VolumeViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.settings.audi_mib3.AudiMib3SubActivity, android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = (ActivityAudiMib3SoundOemBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_audi_mib3_sound_oem, null, false);
        this.contentLayout.addView(this.binding.getRoot(), -1, -1);
        AudiMib3VolumeViewModel audiMib3VolumeViewModel = (AudiMib3VolumeViewModel) ViewModelProviders.of(this).get(AudiMib3VolumeViewModel.class);
        this.viewModel = audiMib3VolumeViewModel;
        this.binding.setVm(audiMib3VolumeViewModel);
        this.tv_title_set.setText(getResources().getString(R.string.audi_set_sound_yc_ms));
    }
}

package com.wits.ksw.settings.audi_mib3;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.databinding.AudiMib3SystemSetBinding;
import com.wits.ksw.settings.audi_mib3.vm.AudiMib3SystemViewModel;

public class AudiMib3SystemActivity extends AudiMib3SubActivity {
    private AudiMib3SystemSetBinding binding;
    private AudiMib3SystemViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.settings.audi_mib3.AudiMib3SubActivity, android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AudiMib3SystemSetBinding audiMib3SystemSetBinding = (AudiMib3SystemSetBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.audi_mib3_system_set, null, false);
        this.binding = audiMib3SystemSetBinding;
        this.contentLayout.addView(audiMib3SystemSetBinding.getRoot(), -1, -1);
        AudiMib3SystemViewModel audiMib3SystemViewModel = (AudiMib3SystemViewModel) ViewModelProviders.of(AudiMib3SettingMainActivity.getInstance).get(AudiMib3SystemViewModel.class);
        this.viewModel = audiMib3SystemViewModel;
        this.binding.setVm(audiMib3SystemViewModel);
        int childView = this.binding.audiSystemSetParentPanel.getChildCount();
        for (int i = 0; i < childView; i++) {
            this.binding.audiSystemSetParentPanel.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.settings.audi_mib3.$$Lambda$AudiMib3SystemActivity$HjuFyJbeJEL4KOJQTlXhtbwqWXg */

                public final void onClick(View view) {
                    AudiMib3SystemActivity.this.onClick(view);
                }
            });
        }
        this.tv_title_set.setText(getResources().getString(R.string.item1));
    }

    /* access modifiers changed from: private */
    public void onClick(View view) {
        this.binding.audiSystemSetParentPanel.setSeleted(view);
        switch (view.getId()) {
            case R.id.audi_system_aux_postion /*{ENCODED_INT: 2131230863}*/:
                AudiMib3StartUtil.AudiAuxActivity(this);
                return;
            case R.id.audi_system_brightness /*{ENCODED_INT: 2131230864}*/:
                AudiMib3StartUtil.AudiBrightnessActivity(this);
                return;
            case R.id.audi_system_rever_camera /*{ENCODED_INT: 2131230866}*/:
                AudiMib3StartUtil.AudiReverCameraActivity(this);
                return;
            case R.id.audi_system_speed_unit /*{ENCODED_INT: 2131230871}*/:
                AudiMib3StartUtil.AudiSpeedUnitActivity(this);
                return;
            case R.id.audi_system_temp_unit /*{ENCODED_INT: 2131230872}*/:
                AudiMib3StartUtil.AudiTempActivity(this);
                return;
            case R.id.tv_music_app /*{ENCODED_INT: 2131232767}*/:
                AudiMib3StartUtil.toAudiSelMusicApp(this);
                return;
            case R.id.tv_video_app /*{ENCODED_INT: 2131232809}*/:
                AudiMib3StartUtil.toAudiSelVideoApp(this);
                return;
            default:
                return;
        }
    }
}

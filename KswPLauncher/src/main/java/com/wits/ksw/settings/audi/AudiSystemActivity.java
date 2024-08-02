package com.wits.ksw.settings.audi;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.databinding.AudiSystemSetBinding;
import com.wits.ksw.settings.audi.vm.AudiSystemViewModel;

public class AudiSystemActivity extends AudiSubActivity {
    private AudiSystemSetBinding binding;
    private AudiSystemViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.settings.audi.AudiSubActivity, android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AudiSystemSetBinding audiSystemSetBinding = (AudiSystemSetBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.audi_system_set, null, false);
        this.binding = audiSystemSetBinding;
        this.contentLayout.addView(audiSystemSetBinding.getRoot(), -1, -1);
        AudiSystemViewModel audiSystemViewModel = (AudiSystemViewModel) ViewModelProviders.of(AudiSettingMainActivity.getInstance).get(AudiSystemViewModel.class);
        this.viewModel = audiSystemViewModel;
        this.binding.setVm(audiSystemViewModel);
        int childView = this.binding.audiSystemSetParentPanel.getChildCount();
        for (int i = 0; i < childView; i++) {
            this.binding.audiSystemSetParentPanel.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                /* class com.wits.ksw.settings.audi.$$Lambda$AudiSystemActivity$2W3iY3WAmuZY5AXaTzdQ8wVNwEU */

                public final void onClick(View view) {
                    AudiSystemActivity.lambda$2W3iY3WAmuZY5AXaTzdQ8wVNwEU(AudiSystemActivity.this, view);
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
                StartUtil.AudiAuxActivity(this);
                return;
            case R.id.audi_system_brightness /*{ENCODED_INT: 2131230864}*/:
                StartUtil.AudiBrightnessActivity(this);
                return;
            case R.id.audi_system_rever_camera /*{ENCODED_INT: 2131230866}*/:
                StartUtil.AudiReverCameraActivity(this);
                return;
            case R.id.audi_system_speed_unit /*{ENCODED_INT: 2131230871}*/:
                StartUtil.AudiSpeedUnitActivity(this);
                return;
            case R.id.audi_system_temp_unit /*{ENCODED_INT: 2131230872}*/:
                StartUtil.AudiTempActivity(this);
                return;
            case R.id.tv_music_app /*{ENCODED_INT: 2131232767}*/:
                StartUtil.toAudiSelMusicApp(this);
                return;
            case R.id.tv_video_app /*{ENCODED_INT: 2131232809}*/:
                StartUtil.toAudiSelVideoApp(this);
                return;
            default:
                return;
        }
    }
}

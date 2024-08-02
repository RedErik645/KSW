package com.wits.ksw.settings.audi_mib3;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.RadioGroup;
import com.wits.ksw.R;
import com.wits.ksw.databinding.AudiMib3EqViewBinding;
import com.wits.ksw.settings.audi_mib3.vm.AudiMib3EQViewModel;

public class AudiMib3EqActivity extends AudiMib3SubActivity {
    private AudiMib3EqViewBinding binding;
    private boolean mControlEnable = false;
    private AudiMib3EQViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.settings.audi_mib3.AudiMib3SubActivity, android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = (AudiMib3EqViewBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.audi_mib3_eq_view, null, false);
        this.contentLayout.addView(this.binding.getRoot(), -1, -1);
        AudiMib3EQViewModel audiMib3EQViewModel = (AudiMib3EQViewModel) ViewModelProviders.of(this).get(AudiMib3EQViewModel.class);
        this.viewModel = audiMib3EQViewModel;
        this.binding.setVm(audiMib3EQViewModel);
        this.tv_title_set.setText(getResources().getString(R.string.item4));
        this.binding.rgList.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /* class com.wits.ksw.settings.audi_mib3.$$Lambda$AudiMib3EqActivity$E6cNs5UpGwjiJI2mbzmM1HpkupE */

            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                AudiMib3EqActivity.this.lambda$onCreate$0$AudiMib3EqActivity(radioGroup, i);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$AudiMib3EqActivity(RadioGroup group, int checkedId) {
        if (!this.mControlEnable) {
            this.mControlEnable = true;
        } else if (checkedId == R.id.aaa) {
            startActivity(new Intent(this, AudiMib3EqCustomActivity.class));
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("AudiMib3EQ", "-------> onDestroy");
    }
}
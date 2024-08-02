package com.wits.ksw.settings.audi_mib3;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.databinding.AudiMib3SysinfoBinding;
import com.wits.ksw.settings.TxzMessage;
import com.wits.ksw.settings.audi_mib3.vm.AudiMib3SettingViewModel;
import com.wits.ksw.settings.utlis_view.DialogViews;
import com.wits.ksw.settings.utlis_view.UtilsInfo;

public class AudiMib3SystemInfoActivity extends AudiMib3SubActivity {
    private AudiMib3SysinfoBinding binding;
    private DialogViews dialogViews;
    Handler handler = new Handler() {
        /* class com.wits.ksw.settings.audi_mib3.AudiMib3SystemInfoActivity.AnonymousClass1 */

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (AudiMib3SystemInfoActivity.this.viewModel != null) {
                    AudiMib3SystemInfoActivity.this.viewModel.updatMcuVersion();
                }
            } else if (msg.what == 1) {
                Intent resetIntent = new Intent("android.intent.action.FACTORY_RESET");
                resetIntent.setPackage("android");
                resetIntent.setFlags(268435456);
                resetIntent.putExtra("android.intent.extra.REASON", "ResetConfirmFragment");
                AudiMib3SystemInfoActivity.this.sendBroadcast(resetIntent);
            }
        }
    };
    private TextView tv_cpuinfo;
    private AudiMib3SettingViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.settings.audi_mib3.AudiMib3SubActivity, android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AudiMib3SysinfoBinding audiMib3SysinfoBinding = (AudiMib3SysinfoBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.audi_mib3_sysinfo, null, false);
        this.binding = audiMib3SysinfoBinding;
        this.contentLayout.addView(audiMib3SysinfoBinding.getRoot(), -1, -1);
        AudiMib3SettingViewModel audiMib3SettingViewModel = (AudiMib3SettingViewModel) ViewModelProviders.of(this).get(AudiMib3SettingViewModel.class);
        this.viewModel = audiMib3SettingViewModel;
        this.binding.setVm(audiMib3SettingViewModel);
        this.dialogViews = new DialogViews(this);
        int count = this.binding.audiSysInfParentPanel.getChildCount();
        for (int i = 0; i < count; i++) {
            View childView = this.binding.audiSysInfParentPanel.getChildAt(i);
            if (childView instanceof TextView) {
                childView.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.settings.audi_mib3.$$Lambda$M13UadNXyC12D25TOeIjWf64iQ */

                    public final void onClick(View view) {
                        AudiMib3SystemInfoActivity.this.onClick(view);
                    }
                });
            }
        }
        this.tv_title_set.setText(getResources().getString(R.string.item7));
        String cpuformat = String.format(getResources().getString(R.string.settings_cpuinfo), UtilsInfo.getCpuInfo(this));
        TextView textView = (TextView) findViewById(R.id.audiSysInfoCpu);
        this.tv_cpuinfo = textView;
        textView.setText(cpuformat);
        this.tv_cpuinfo.post(new Runnable() {
            /* class com.wits.ksw.settings.audi_mib3.$$Lambda$AudiMib3SystemInfoActivity$2hl9d0R3grIJR3MCibOpLfY0tU0 */

            public final void run() {
                AudiMib3SystemInfoActivity.this.lambda$onCreate$0$AudiMib3SystemInfoActivity();
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$AudiMib3SystemInfoActivity() {
        this.tv_cpuinfo.setSelected(true);
    }

    public void onClick(View v) {
        this.binding.audiSysInfParentPanel.setSeleted(v);
        switch (v.getId()) {
            case R.id.audiSysInfoSysVer /*{ENCODED_INT: 2131230840}*/:
                UtilsInfo.showQRCode(this);
                return;
            case R.id.audioSysInfoMcuUpdata /*{ENCODED_INT: 2131230877}*/:
                this.dialogViews.updateMcu(getString(R.string.update_mcu_file));
                return;
            case R.id.audioSysInfoRestoreFactory /*{ENCODED_INT: 2131230879}*/:
                this.dialogViews.isQuestView(getString(R.string.update_reset_all), this.handler);
                return;
            case R.id.audioSysInfoUpDateFactory /*{ENCODED_INT: 2131230880}*/:
                new TxzMessage(2070, "system.ota.check", null).sendBroadCast(this);
                return;
            default:
                return;
        }
    }
}

package com.wits.ksw.settings.audi;

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
import com.wits.ksw.databinding.AudiSysinfoBinding;
import com.wits.ksw.settings.TxzMessage;
import com.wits.ksw.settings.audi.vm.AudiSettingViewModel;
import com.wits.ksw.settings.utlis_view.DialogViews;
import com.wits.ksw.settings.utlis_view.UtilsInfo;

public class AudiSystemInfoActivity extends AudiSubActivity {
    private AudiSysinfoBinding binding;
    private DialogViews dialogViews;
    Handler handler = new Handler() {
        /* class com.wits.ksw.settings.audi.AudiSystemInfoActivity.AnonymousClass1 */

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (AudiSystemInfoActivity.this.viewModel != null) {
                    AudiSystemInfoActivity.this.viewModel.updatMcuVersion();
                }
            } else if (msg.what == 1) {
                Intent resetIntent = new Intent("android.intent.action.FACTORY_RESET");
                resetIntent.setPackage("android");
                resetIntent.setFlags(268435456);
                resetIntent.putExtra("android.intent.extra.REASON", "ResetConfirmFragment");
                AudiSystemInfoActivity.this.sendBroadcast(resetIntent);
            }
        }
    };
    private TextView tv_cpuinfo;
    private AudiSettingViewModel viewModel;

    /* access modifiers changed from: protected */
    @Override // com.wits.ksw.settings.audi.AudiSubActivity, android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AudiSysinfoBinding audiSysinfoBinding = (AudiSysinfoBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.audi_sysinfo, null, false);
        this.binding = audiSysinfoBinding;
        this.contentLayout.addView(audiSysinfoBinding.getRoot(), -1, -1);
        AudiSettingViewModel audiSettingViewModel = (AudiSettingViewModel) ViewModelProviders.of(this).get(AudiSettingViewModel.class);
        this.viewModel = audiSettingViewModel;
        this.binding.setVm(audiSettingViewModel);
        this.dialogViews = new DialogViews(this);
        int count = this.binding.audiSysInfParentPanel.getChildCount();
        for (int i = 0; i < count; i++) {
            View childView = this.binding.audiSysInfParentPanel.getChildAt(i);
            if (childView instanceof TextView) {
                childView.setOnClickListener(new View.OnClickListener() {
                    /* class com.wits.ksw.settings.audi.$$Lambda$QMfPLHNrIFj5KFMgiBKHHiAYGRY */

                    public final void onClick(View view) {
                        AudiSystemInfoActivity.this.onClick(view);
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
            /* class com.wits.ksw.settings.audi.$$Lambda$AudiSystemInfoActivity$I78WnUte9SFHHFLKQaXlSCWyK_4 */

            public final void run() {
                AudiSystemInfoActivity.this.lambda$onCreate$0$AudiSystemInfoActivity();
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$AudiSystemInfoActivity() {
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

package com.wits.ksw.settings.bmw_id9.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.wits.ksw.R;
import com.wits.ksw.databinding.ActivityBmwId9SettingsInfoLayoutBinding;
import com.wits.ksw.launcher.utils.KswUtils;
import com.wits.ksw.settings.BaseSkinActivity;
import com.wits.ksw.settings.TxzMessage;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;
import com.wits.ksw.settings.utlis_view.DialogViews;
import com.wits.ksw.settings.utlis_view.McuUtil;
import com.wits.ksw.settings.utlis_view.UtilsInfo;
import com.wits.pms.IContentObserver;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BmwId9SettingsInfoActivity extends BaseSkinActivity implements View.OnClickListener {
    private final String TAG = "BmwId9SettingsInfoActivity";
    private DialogViews dialogViews;
    Handler handler = new Handler() {
        /* class com.wits.ksw.settings.bmw_id9.activity.BmwId9SettingsInfoActivity.AnonymousClass1 */

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                try {
                    BmwId9SettingsInfoActivity.this.mViewModel.mcuVersionStr.set(McuUtil.getMcuVersion());
                } catch (Exception e) {
                    e.getStackTrace();
                }
            } else if (msg.what == 1) {
                Intent resetIntent = new Intent("android.intent.action.FACTORY_RESET");
                resetIntent.setPackage("android");
                resetIntent.setFlags(268435456);
                resetIntent.putExtra("android.intent.extra.REASON", "ResetConfirmFragment");
                BmwId9SettingsInfoActivity.this.sendBroadcast(resetIntent);
            }
        }
    };
    private ActivityBmwId9SettingsInfoLayoutBinding mBinding;
    private BmwId9SettingsViewModel mViewModel;
    private int[] relativeLayoutId = {R.id.bmw_id9_info_mcu_upgrade, R.id.bmw_id9_info_system_recovery, R.id.bmw_id9_info_system_update};

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, com.wits.ksw.settings.BaseSkinActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BmwId9SettingsInfoActivity", " onCreate ");
        this.mBinding = (ActivityBmwId9SettingsInfoLayoutBinding) DataBindingUtil.setContentView(this, R.layout.activity_bmw_id9_settings_info_layout);
        BmwId9SettingsViewModel instance = BmwId9SettingsViewModel.getInstance();
        this.mViewModel = instance;
        this.mBinding.setViewModel(instance);
        this.dialogViews = new DialogViews(this);
        initData();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("BmwId9SettingsInfoActivity", " onNewIntent ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Log.i("BmwId9SettingsInfoActivity", " onResume ");
        try {
            if (getCurrentFocus() == null) {
                this.mBinding.bmwId9InfoMcuVer.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initData() {
        try {
            PowerManagerApp.registerIContentObserver("mcuVerison", new IContentObserver.Stub() {
                /* class com.wits.ksw.settings.bmw_id9.activity.BmwId9SettingsInfoActivity.AnonymousClass2 */

                @Override // com.wits.pms.IContentObserver
                public void onChange() throws RemoteException {
                    BmwId9SettingsInfoActivity.this.handler.sendEmptyMessage(0);
                }
            });
            this.mViewModel.mcuVersionStr.set(McuUtil.getMcuVersion());
            this.mViewModel.appVersionStr.set("Witstek-" + UtilsInfo.changeM785());
            this.mViewModel.systemVersionStr.set(UtilsInfo.getSettingsVer(this) + "-" + UtilsInfo.getIMEI());
            this.mViewModel.cpuInfoStr.set(UtilsInfo.getCpuInfo(this));
            this.mViewModel.storageStr.set(UtilsInfo.getROMSize());
            this.mViewModel.ramStr.set(UtilsInfo.getRAMSize(this));
            this.mBinding.bmwId9InfoSystemVersion.setOnClickListener(this);
            int i = 0;
            while (true) {
                int[] iArr = this.relativeLayoutId;
                if (i < iArr.length) {
                    findViewById(iArr[i]).setOnClickListener(this);
                    findViewById(this.relativeLayoutId[i]).setOnTouchListener(new View.OnTouchListener() {
                        /* class com.wits.ksw.settings.bmw_id9.activity.BmwId9SettingsInfoActivity.AnonymousClass3 */

                        public boolean onTouch(View v, MotionEvent event) {
                            Log.i("BmwId9SettingsInfoActivity", " onTouch v " + v.toString() + " Action " + event.getAction() + " v.isFocused() " + v.isFocused());
                            if (event.getAction() != 1 || v.isFocused()) {
                                return false;
                            }
                            v.requestFocus();
                            return false;
                        }
                    });
                    i++;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bmw_id9_info_mcu_upgrade /*{ENCODED_INT: 2131231131}*/:
                this.dialogViews.updateMcu(getString(R.string.update_mcu_file));
                return;
            case R.id.bmw_id9_info_mcu_ver /*{ENCODED_INT: 2131231132}*/:
            default:
                return;
            case R.id.bmw_id9_info_system_recovery /*{ENCODED_INT: 2131231133}*/:
                this.dialogViews.isBmwId9QuestView(getString(R.string.update_reset_all), this.handler);
                return;
            case R.id.bmw_id9_info_system_update /*{ENCODED_INT: 2131231134}*/:
                new TxzMessage(2070, "system.ota.check", null).sendBroadCast(this);
                return;
            case R.id.bmw_id9_info_system_version /*{ENCODED_INT: 2131231135}*/:
                UtilsInfo.showQRCode(this);
                return;
        }
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        int action = event.getAction();
        View view = getCurrentFocus();
        Log.i("BmwId9SettingsInfoActivity", "dispatchKeyEvent keyCode " + keyCode + " action " + action);
        switch (action) {
            case 0:
                if (event.getKeyCode() == 21 && view != null && this.mBinding.bmwId9SettingsInfoLay.hasFocus()) {
                    Log.i("BmwId9SettingsInfoActivity", " focusView " + view.toString() + " view.isFocused() " + view.isFocused());
                    KswUtils.sendKeyDownUpSync(4);
                    break;
                }
        }
        return super.dispatchKeyEvent(event);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Log.i("BmwId9SettingsInfoActivity", " onStop ");
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("BmwId9SettingsInfoActivity", " onDestroy ");
    }

    public void onPointerCaptureChanged(boolean hasCapture) {
    }
}

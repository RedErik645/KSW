package com.wits.ksw.settings.alsid7.layout_one;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.TxzMessage;
import com.wits.ksw.settings.utlis_view.DialogViews;
import com.wits.ksw.settings.utlis_view.McuUtil;
import com.wits.ksw.settings.utlis_view.UtilsInfo;
import com.wits.pms.IContentObserver;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class AlsID7SetSystemInfoLayout extends RelativeLayout implements View.OnClickListener {
    private Context context;
    private DialogViews dialogViews;
    Handler handler = new Handler() {
        /* class com.wits.ksw.settings.alsid7.layout_one.AlsID7SetSystemInfoLayout.AnonymousClass1 */

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                try {
                    AlsID7SetSystemInfoLayout.this.tv_infoMcuv.setText(String.format(AlsID7SetSystemInfoLayout.this.getResources().getString(R.string.text_8), McuUtil.getMcuVersion()));
                } catch (Exception e) {
                    e.getStackTrace();
                }
            } else if (msg.what == 1) {
                Intent resetIntent = new Intent("android.intent.action.FACTORY_RESET");
                resetIntent.setPackage("android");
                resetIntent.setFlags(268435456);
                resetIntent.putExtra("android.intent.extra.REASON", "ResetConfirmFragment");
                AlsID7SetSystemInfoLayout.this.context.sendBroadcast(resetIntent);
            }
        }
    };
    private TextView tv_infoAppv;
    private TextView tv_infoCpu;
    private TextView tv_infoMcuUp;
    private TextView tv_infoMcuv;
    private TextView tv_infoSysRest;
    private TextView tv_infoSysUpDate;
    private TextView tv_infoSysv;
    private TextView tv_systemInfo;
    private TextView tv_systemInfo2;

    public AlsID7SetSystemInfoLayout(Context context2) {
        super(context2);
        this.context = context2;
        View view = LayoutInflater.from(context2).inflate(R.layout.als_layout_set_sys_info, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        initData();
        initView(view);
        view.setLayoutParams(layoutParams);
        addView(view);
    }

    private void initData() {
    }

    private void initView(View view) {
        this.dialogViews = new DialogViews(this.context);
        try {
            String mvformat = String.format(getResources().getString(R.string.text_8), McuUtil.getMcuVersion());
            TextView textView = (TextView) view.findViewById(R.id.tv_infoMcuv);
            this.tv_infoMcuv = textView;
            textView.setText(mvformat);
        } catch (Exception e) {
            e.getStackTrace();
        }
        PowerManagerApp.registerIContentObserver("mcuVerison", new IContentObserver.Stub() {
            /* class com.wits.ksw.settings.alsid7.layout_one.AlsID7SetSystemInfoLayout.AnonymousClass2 */

            @Override // com.wits.pms.IContentObserver
            public void onChange() throws RemoteException {
                AlsID7SetSystemInfoLayout.this.handler.sendEmptyMessage(0);
            }
        });
        String avformat = String.format(getResources().getString(R.string.text_9), getVersion());
        TextView textView2 = (TextView) view.findViewById(R.id.tv_infoAppv);
        this.tv_infoAppv = textView2;
        textView2.setText(avformat);
        String.format(getResources().getString(R.string.text_10), Build.VERSION.RELEASE);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_infoSysv);
        this.tv_infoSysv = textView3;
        textView3.setText(UtilsInfo.getSettingsVer(this.context) + "-" + UtilsInfo.getIMEI());
        this.tv_infoSysv.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.alsid7.layout_one.AlsID7SetSystemInfoLayout.AnonymousClass3 */

            public void onClick(View v) {
                UtilsInfo.showQRCode(AlsID7SetSystemInfoLayout.this.context);
            }
        });
        String cpuformat = String.format(getResources().getString(R.string.settings_cpuinfo), UtilsInfo.getCpuInfo(this.context));
        TextView textView4 = (TextView) view.findViewById(R.id.tv_infoCpu);
        this.tv_infoCpu = textView4;
        textView4.setText(cpuformat);
        this.tv_infoCpu.post(new Runnable() {
            /* class com.wits.ksw.settings.alsid7.layout_one.AlsID7SetSystemInfoLayout.AnonymousClass4 */

            public void run() {
                AlsID7SetSystemInfoLayout.this.tv_infoCpu.setSelected(true);
            }
        });
        TextView textView5 = (TextView) view.findViewById(R.id.tv_infoMcuUp);
        this.tv_infoMcuUp = textView5;
        textView5.setOnClickListener(this);
        TextView textView6 = (TextView) view.findViewById(R.id.tv_infoSysRest);
        this.tv_infoSysRest = textView6;
        textView6.setOnClickListener(this);
        String allRAM = String.format(getResources().getString(R.string.text_14), UtilsInfo.getRAMSize(this.context));
        TextView textView7 = (TextView) view.findViewById(R.id.tv_systemInfo2);
        this.tv_systemInfo2 = textView7;
        textView7.setText(allRAM);
        String allROM = String.format(getResources().getString(R.string.text_15), UtilsInfo.getROMSize());
        TextView textView8 = (TextView) view.findViewById(R.id.tv_systemInfo);
        this.tv_systemInfo = textView8;
        textView8.setText(allROM);
        TextView textView9 = (TextView) view.findViewById(R.id.tv_infoSysUpDate);
        this.tv_infoSysUpDate = textView9;
        textView9.setOnClickListener(this);
    }

    private String getVersion() {
        try {
            this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
            return "Witstek-" + UtilsInfo.changeM785();
        } catch (Exception e) {
            e.printStackTrace();
            return "找不到版本号";
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_infoMcuUp /*{ENCODED_INT: 2131232745}*/:
                this.dialogViews.updateMcu(this.context.getString(R.string.update_mcu_file));
                return;
            case R.id.tv_infoMcuv /*{ENCODED_INT: 2131232746}*/:
            case R.id.tv_infoRam /*{ENCODED_INT: 2131232747}*/:
            default:
                return;
            case R.id.tv_infoSysRest /*{ENCODED_INT: 2131232748}*/:
                this.dialogViews.isQuestView(this.context.getString(R.string.update_reset_all), this.handler);
                return;
            case R.id.tv_infoSysUpDate /*{ENCODED_INT: 2131232749}*/:
                new TxzMessage(2070, "system.ota.check", null).sendBroadCast(this.context);
                return;
        }
    }
}

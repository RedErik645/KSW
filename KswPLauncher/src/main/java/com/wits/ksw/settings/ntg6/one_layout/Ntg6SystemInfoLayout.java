package com.wits.ksw.settings.ntg6.one_layout;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;
import com.wits.ksw.settings.TxzMessage;
import com.wits.ksw.settings.utlis_view.DialogViews;
import com.wits.ksw.settings.utlis_view.McuUtil;
import com.wits.ksw.settings.utlis_view.UtilsInfo;
import com.wits.pms.IContentObserver;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class Ntg6SystemInfoLayout extends RelativeLayout implements View.OnClickListener {
    private Context context;
    private DialogViews dialogViews;
    private Handler fhandler;
    Handler handler = new Handler() {
        /* class com.wits.ksw.settings.ntg6.one_layout.Ntg6SystemInfoLayout.AnonymousClass1 */

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                try {
                    String mvformat = String.format(Ntg6SystemInfoLayout.this.getResources().getString(R.string.text_8), McuUtil.getMcuVersion());
                    SpannableString ss1 = new SpannableString(mvformat);
                    ss1.setSpan(new RelativeSizeSpan(0.7f), Ntg6SystemInfoLayout.this.getResources().getString(R.string.text_8).length() - 2, mvformat.length(), 17);
                    Ntg6SystemInfoLayout.this.tv_infoMcuv.setText(ss1);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            } else if (msg.what == 1) {
                Intent resetIntent = new Intent("android.intent.action.FACTORY_RESET");
                resetIntent.setPackage("android");
                resetIntent.setFlags(268435456);
                resetIntent.putExtra("android.intent.extra.REASON", "ResetConfirmFragment");
                Ntg6SystemInfoLayout.this.context.sendBroadcast(resetIntent);
            }
        }
    };
    private ImageView img_TwoBack;
    private MarqueeTextView tv_infoAppv;
    private MarqueeTextView tv_infoCpu;
    private TextView tv_infoMcuUp;
    private MarqueeTextView tv_infoMcuv;
    private TextView tv_infoSysRest;
    private TextView tv_infoSysUpDate;
    private MarqueeTextView tv_infoSysv;

    public Ntg6SystemInfoLayout(Context context2, Handler handler2) {
        super(context2);
        this.context = context2;
        this.fhandler = handler2;
        View view = LayoutInflater.from(context2).inflate(R.layout.layout_ntg6_sys_info, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        initData();
        initView(view);
        view.setLayoutParams(layoutParams);
        addView(view);
    }

    private void initData() {
    }

    public void getFocus() {
        this.img_TwoBack.requestFocus();
    }

    public void getFocus1() {
        this.tv_infoMcuv.setSelected(true);
        this.tv_infoAppv.setSelected(true);
        this.tv_infoSysv.setSelected(true);
        this.tv_infoCpu.setSelected(true);
    }

    private void initView(View view) {
        this.dialogViews = new DialogViews(this.context);
        this.img_TwoBack = (ImageView) view.findViewById(R.id.img_TwoBack);
        try {
            String mvformat = String.format(getResources().getString(R.string.text_8), McuUtil.getMcuVersion());
            SpannableString ss1 = new SpannableString(mvformat);
            ss1.setSpan(new RelativeSizeSpan(0.7f), getResources().getString(R.string.text_8).length() - 2, mvformat.length(), 17);
            MarqueeTextView marqueeTextView = (MarqueeTextView) view.findViewById(R.id.tv_infoMcuv);
            this.tv_infoMcuv = marqueeTextView;
            marqueeTextView.setText(ss1);
        } catch (Exception e) {
            e.getStackTrace();
        }
        PowerManagerApp.registerIContentObserver("mcuVerison", new IContentObserver.Stub() {
            /* class com.wits.ksw.settings.ntg6.one_layout.Ntg6SystemInfoLayout.AnonymousClass2 */

            @Override // com.wits.pms.IContentObserver
            public void onChange() throws RemoteException {
                Ntg6SystemInfoLayout.this.handler.sendEmptyMessage(0);
            }
        });
        String avformat = String.format(getResources().getString(R.string.text_9), getVersion());
        SpannableString ss2 = new SpannableString(avformat);
        ss2.setSpan(new RelativeSizeSpan(0.7f), getResources().getString(R.string.text_9).length() - 2, avformat.length(), 17);
        MarqueeTextView marqueeTextView2 = (MarqueeTextView) view.findViewById(R.id.tv_infoAppv);
        this.tv_infoAppv = marqueeTextView2;
        marqueeTextView2.setText(ss2);
        String svformat = String.format(getResources().getString(R.string.text_10), UtilsInfo.getSettingsVersion(this.context) + "-" + UtilsInfo.getIMEI());
        SpannableString ss3 = new SpannableString(svformat);
        ss3.setSpan(new RelativeSizeSpan(0.7f), getResources().getString(R.string.text_10).length() - 2, svformat.length(), 17);
        MarqueeTextView marqueeTextView3 = (MarqueeTextView) view.findViewById(R.id.tv_infoSysv);
        this.tv_infoSysv = marqueeTextView3;
        marqueeTextView3.setText(ss3);
        String cpuformat = String.format(getResources().getString(R.string.settings_cpuinfo), UtilsInfo.getCpuInfo(this.context));
        SpannableString ss4 = new SpannableString(cpuformat);
        ss4.setSpan(new RelativeSizeSpan(0.7f), getResources().getString(R.string.settings_cpuinfo).length() - 2, cpuformat.length(), 17);
        MarqueeTextView marqueeTextView4 = (MarqueeTextView) view.findViewById(R.id.tv_infoCpu);
        this.tv_infoCpu = marqueeTextView4;
        marqueeTextView4.setText(ss4);
        this.tv_infoSysv.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.ntg6.one_layout.Ntg6SystemInfoLayout.AnonymousClass3 */

            public void onClick(View v) {
                UtilsInfo.showQRCode(Ntg6SystemInfoLayout.this.context);
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.tv_infoMcuUp);
        this.tv_infoMcuUp = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_infoSysRest);
        this.tv_infoSysRest = textView2;
        textView2.setOnClickListener(this);
        this.img_TwoBack.setOnClickListener(new View.OnClickListener() {
            /* class com.wits.ksw.settings.ntg6.one_layout.Ntg6SystemInfoLayout.AnonymousClass4 */

            public void onClick(View v) {
                Ntg6SystemInfoLayout.this.fhandler.sendEmptyMessage(1);
            }
        });
        TextView textView3 = (TextView) view.findViewById(R.id.tv_infoSysUpDate);
        this.tv_infoSysUpDate = textView3;
        textView3.setOnClickListener(this);
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

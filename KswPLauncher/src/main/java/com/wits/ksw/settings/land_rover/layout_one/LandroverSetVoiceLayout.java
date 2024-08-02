package com.wits.ksw.settings.land_rover.layout_one;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.benzmbux2021new.util.BenzUtils;
import com.wits.ksw.settings.utlis_view.FileUtils;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class LandroverSetVoiceLayout extends RelativeLayout implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    private Context context;
    private int daohan = 26;
    private int htongh = 28;
    private int meiti = 26;
    private SeekBar seek_daohvoicb;
    private SeekBar seek_mtb;
    private SeekBar seek_tonghb;
    private SeekBar seek_yuancthb;
    private TextView tv_daohvoicsize;
    private TextView tv_eq;
    private TextView tv_mtsize;
    private TextView tv_tonghsize;
    private TextView tv_yuancthsize;
    private int ytongh = 26;

    public LandroverSetVoiceLayout(Context context2) {
        super(context2);
        this.context = context2;
        View view = LayoutInflater.from(context2).inflate(R.layout.land_rover_layout_set_voice, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        initData();
        initView(view);
        view.setLayoutParams(layoutParams);
        addView(view);
    }

    private void initData() {
        try {
            this.meiti = PowerManagerApp.getSettingsInt(KeyConfig.ANDROID_MEDIA_VOL);
            this.htongh = PowerManagerApp.getSettingsInt(KeyConfig.ANDROID_PHONE_VOL);
            this.ytongh = PowerManagerApp.getSettingsInt(KeyConfig.CAR_PHONE_VOL);
            this.daohan = PowerManagerApp.getSettingsInt(KeyConfig.CAR_NAVI_VOL);
        } catch (Exception e) {
            e.getStackTrace();
        }
        getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor(KeyConfig.ANDROID_MEDIA_VOL), true, new ContentObserver(new Handler()) {
            /* class com.wits.ksw.settings.land_rover.layout_one.LandroverSetVoiceLayout.AnonymousClass1 */

            public void onChange(boolean selfChange) {
                try {
                    LandroverSetVoiceLayout.this.seek_mtb.setProgress(PowerManagerApp.getSettingsInt(KeyConfig.ANDROID_MEDIA_VOL));
                } catch (RemoteException e) {
                }
            }
        });
    }

    private void initView(View view) {
        this.seek_mtb = (SeekBar) view.findViewById(R.id.seek_mtb);
        this.tv_mtsize = (TextView) view.findViewById(R.id.tv_mtsize);
        this.seek_mtb.setMax(40);
        this.seek_mtb.setProgress(this.meiti);
        this.tv_mtsize.setText(this.meiti + "");
        this.seek_tonghb = (SeekBar) view.findViewById(R.id.seek_tonghb);
        this.tv_tonghsize = (TextView) view.findViewById(R.id.tv_tonghsize);
        this.seek_tonghb.setMax(40);
        this.seek_tonghb.setProgress(this.htongh);
        this.tv_tonghsize.setText(this.htongh + "");
        this.seek_yuancthb = (SeekBar) view.findViewById(R.id.seek_yuancthb);
        this.tv_yuancthsize = (TextView) view.findViewById(R.id.tv_yuancthsize);
        this.seek_yuancthb.setMax(40);
        this.seek_yuancthb.setProgress(this.ytongh);
        this.tv_yuancthsize.setText(this.ytongh + "");
        this.seek_daohvoicb = (SeekBar) view.findViewById(R.id.seek_daohvoicb);
        this.tv_daohvoicsize = (TextView) view.findViewById(R.id.tv_daohvoicsize);
        this.seek_daohvoicb.setMax(40);
        this.seek_daohvoicb.setProgress(this.daohan);
        this.tv_daohvoicsize.setText(this.daohan + "");
        this.seek_mtb.setOnSeekBarChangeListener(this);
        this.seek_tonghb.setOnSeekBarChangeListener(this);
        this.seek_yuancthb.setOnSeekBarChangeListener(this);
        this.seek_daohvoicb.setOnSeekBarChangeListener(this);
        TextView textView = (TextView) view.findViewById(R.id.tv_eq);
        this.tv_eq = textView;
        textView.setOnClickListener(this);
    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seek_daohvoicb /*{ENCODED_INT: 2131232549}*/:
                this.tv_daohvoicsize.setText(progress + "");
                FileUtils.savaIntData(KeyConfig.CAR_NAVI_VOL, progress);
                return;
            case R.id.seek_mtb /*{ENCODED_INT: 2131232552}*/:
                this.tv_mtsize.setText(progress + "");
                FileUtils.savaIntData(KeyConfig.ANDROID_MEDIA_VOL, progress);
                return;
            case R.id.seek_tonghb /*{ENCODED_INT: 2131232556}*/:
                this.tv_tonghsize.setText(progress + "");
                FileUtils.savaIntData(KeyConfig.ANDROID_PHONE_VOL, progress);
                return;
            case R.id.seek_yuancthb /*{ENCODED_INT: 2131232557}*/:
                this.tv_yuancthsize.setText(progress + "");
                FileUtils.savaIntData(KeyConfig.CAR_PHONE_VOL, progress);
                return;
            default:
                return;
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void onClick(View v) {
        if (v.getId() == R.id.tv_eq) {
            Intent intent = new Intent();
            intent.setClassName(BenzUtils.EQ_PKG, "com.wits.csp.eq.view.MainActivity");
            this.context.startActivity(intent);
        }
    }
}

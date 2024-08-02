package com.wits.ksw.settings.id7.layout_factory;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.KeyConfig;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class ReverseExitTimeSelect extends FrameLayout {
    private static final String TAG = "ReverseExitTimeSelect";
    private FrameLayout.LayoutParams layoutParams;
    private Context m_con;
    private String mode = "0-0";
    private RadioGroup reverse_exit_time_radiogroup;
    private SeekBar seek_exit;
    private TextView tv_exit_value;
    private View view;

    public ReverseExitTimeSelect(Context context) {
        super(context);
        this.m_con = context;
        this.view = LayoutInflater.from(context).inflate(R.layout.factory_reverse_exit_time, (ViewGroup) null);
        Log.d(TAG, " view " + this.view);
        this.layoutParams = new FrameLayout.LayoutParams(-1, -1);
        initData();
        initView();
        this.view.setLayoutParams(this.layoutParams);
        addView(this.view);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0072, code lost:
        if (r3.equals(com.wits.ksw.settings.TxzMessage.TXZ_DISMISS) != false) goto L_0x0076;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initView() {
        /*
        // Method dump skipped, instructions count: 254
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.settings.id7.layout_factory.ReverseExitTimeSelect.initView():void");
    }

    private void initData() {
        try {
            this.mode = PowerManagerApp.getSettingsString(KeyConfig.REVERSE_TIME);
            Log.d(TAG, "initData: mode=" + this.mode);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

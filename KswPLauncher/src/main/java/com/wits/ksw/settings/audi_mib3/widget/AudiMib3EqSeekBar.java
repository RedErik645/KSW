package com.wits.ksw.settings.audi_mib3.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;

public class AudiMib3EqSeekBar extends AppCompatSeekBar {
    public AudiMib3EqSeekBar(Context context) {
        this(context, null);
    }

    public AudiMib3EqSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }
}

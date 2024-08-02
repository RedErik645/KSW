package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;

public final class FactoryMicBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final SeekBar seekMic;
    public final TextView tvMic;
    public final TextView tvMicValue;

    private FactoryMicBinding(LinearLayout rootView2, SeekBar seekMic2, TextView tvMic2, TextView tvMicValue2) {
        this.rootView = rootView2;
        this.seekMic = seekMic2;
        this.tvMic = tvMic2;
        this.tvMicValue = tvMicValue2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FactoryMicBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FactoryMicBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.factory_mic, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FactoryMicBinding bind(View rootView2) {
        int id = R.id.seek_mic;
        SeekBar seekMic2 = (SeekBar) rootView2.findViewById(R.id.seek_mic);
        if (seekMic2 != null) {
            id = R.id.tv_mic;
            TextView tvMic2 = (TextView) rootView2.findViewById(R.id.tv_mic);
            if (tvMic2 != null) {
                id = R.id.tv_mic_value;
                TextView tvMicValue2 = (TextView) rootView2.findViewById(R.id.tv_mic_value);
                if (tvMicValue2 != null) {
                    return new FactoryMicBinding((LinearLayout) rootView2, seekMic2, tvMic2, tvMicValue2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

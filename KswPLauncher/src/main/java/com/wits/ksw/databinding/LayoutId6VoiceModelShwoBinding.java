package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;

public final class LayoutId6VoiceModelShwoBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final SeekBar seekbarMdi;
    public final SeekBar seekbarMgo;
    public final SeekBar seekbarMzh;
    public final TextView tvMdiSize;
    public final TextView tvMgoSize;
    public final TextView tvMzhSize;

    private LayoutId6VoiceModelShwoBinding(RelativeLayout rootView2, SeekBar seekbarMdi2, SeekBar seekbarMgo2, SeekBar seekbarMzh2, TextView tvMdiSize2, TextView tvMgoSize2, TextView tvMzhSize2) {
        this.rootView = rootView2;
        this.seekbarMdi = seekbarMdi2;
        this.seekbarMgo = seekbarMgo2;
        this.seekbarMzh = seekbarMzh2;
        this.tvMdiSize = tvMdiSize2;
        this.tvMgoSize = tvMgoSize2;
        this.tvMzhSize = tvMzhSize2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutId6VoiceModelShwoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutId6VoiceModelShwoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_id6_voice_model_shwo, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutId6VoiceModelShwoBinding bind(View rootView2) {
        int id = R.id.seekbar_mdi;
        SeekBar seekbarMdi2 = (SeekBar) rootView2.findViewById(R.id.seekbar_mdi);
        if (seekbarMdi2 != null) {
            id = R.id.seekbar_mgo;
            SeekBar seekbarMgo2 = (SeekBar) rootView2.findViewById(R.id.seekbar_mgo);
            if (seekbarMgo2 != null) {
                id = R.id.seekbar_mzh;
                SeekBar seekbarMzh2 = (SeekBar) rootView2.findViewById(R.id.seekbar_mzh);
                if (seekbarMzh2 != null) {
                    id = R.id.tv_mdiSize;
                    TextView tvMdiSize2 = (TextView) rootView2.findViewById(R.id.tv_mdiSize);
                    if (tvMdiSize2 != null) {
                        id = R.id.tv_mgoSize;
                        TextView tvMgoSize2 = (TextView) rootView2.findViewById(R.id.tv_mgoSize);
                        if (tvMgoSize2 != null) {
                            id = R.id.tv_mzhSize;
                            TextView tvMzhSize2 = (TextView) rootView2.findViewById(R.id.tv_mzhSize);
                            if (tvMzhSize2 != null) {
                                return new LayoutId6VoiceModelShwoBinding((RelativeLayout) rootView2, seekbarMdi2, seekbarMgo2, seekbarMzh2, tvMdiSize2, tvMgoSize2, tvMzhSize2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

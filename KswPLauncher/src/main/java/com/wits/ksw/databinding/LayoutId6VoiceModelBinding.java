package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;

public final class LayoutId6VoiceModelBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final SeekBar seekbarMdi;
    public final SeekBar seekbarMgo;
    public final SeekBar seekbarMzh;
    public final TextView tvEqgud;
    public final TextView tvEqjues;
    public final TextView tvEqliux;
    public final TextView tvEqwuq;
    public final TextView tvEqyaog;
    public final TextView tvEqyongh;
    public final TextView tvMdiSize;
    public final TextView tvMgoSize;
    public final TextView tvMzhSize;

    private LayoutId6VoiceModelBinding(LinearLayout rootView2, SeekBar seekbarMdi2, SeekBar seekbarMgo2, SeekBar seekbarMzh2, TextView tvEqgud2, TextView tvEqjues2, TextView tvEqliux2, TextView tvEqwuq2, TextView tvEqyaog2, TextView tvEqyongh2, TextView tvMdiSize2, TextView tvMgoSize2, TextView tvMzhSize2) {
        this.rootView = rootView2;
        this.seekbarMdi = seekbarMdi2;
        this.seekbarMgo = seekbarMgo2;
        this.seekbarMzh = seekbarMzh2;
        this.tvEqgud = tvEqgud2;
        this.tvEqjues = tvEqjues2;
        this.tvEqliux = tvEqliux2;
        this.tvEqwuq = tvEqwuq2;
        this.tvEqyaog = tvEqyaog2;
        this.tvEqyongh = tvEqyongh2;
        this.tvMdiSize = tvMdiSize2;
        this.tvMgoSize = tvMgoSize2;
        this.tvMzhSize = tvMzhSize2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutId6VoiceModelBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutId6VoiceModelBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_id6_voice_model, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutId6VoiceModelBinding bind(View rootView2) {
        int id = R.id.seekbar_mdi;
        SeekBar seekbarMdi2 = (SeekBar) rootView2.findViewById(R.id.seekbar_mdi);
        if (seekbarMdi2 != null) {
            id = R.id.seekbar_mgo;
            SeekBar seekbarMgo2 = (SeekBar) rootView2.findViewById(R.id.seekbar_mgo);
            if (seekbarMgo2 != null) {
                id = R.id.seekbar_mzh;
                SeekBar seekbarMzh2 = (SeekBar) rootView2.findViewById(R.id.seekbar_mzh);
                if (seekbarMzh2 != null) {
                    id = R.id.tv_eqgud;
                    TextView tvEqgud2 = (TextView) rootView2.findViewById(R.id.tv_eqgud);
                    if (tvEqgud2 != null) {
                        id = R.id.tv_eqjues;
                        TextView tvEqjues2 = (TextView) rootView2.findViewById(R.id.tv_eqjues);
                        if (tvEqjues2 != null) {
                            id = R.id.tv_eqliux;
                            TextView tvEqliux2 = (TextView) rootView2.findViewById(R.id.tv_eqliux);
                            if (tvEqliux2 != null) {
                                id = R.id.tv_eqwuq;
                                TextView tvEqwuq2 = (TextView) rootView2.findViewById(R.id.tv_eqwuq);
                                if (tvEqwuq2 != null) {
                                    id = R.id.tv_eqyaog;
                                    TextView tvEqyaog2 = (TextView) rootView2.findViewById(R.id.tv_eqyaog);
                                    if (tvEqyaog2 != null) {
                                        id = R.id.tv_eqyongh;
                                        TextView tvEqyongh2 = (TextView) rootView2.findViewById(R.id.tv_eqyongh);
                                        if (tvEqyongh2 != null) {
                                            id = R.id.tv_mdiSize;
                                            TextView tvMdiSize2 = (TextView) rootView2.findViewById(R.id.tv_mdiSize);
                                            if (tvMdiSize2 != null) {
                                                id = R.id.tv_mgoSize;
                                                TextView tvMgoSize2 = (TextView) rootView2.findViewById(R.id.tv_mgoSize);
                                                if (tvMgoSize2 != null) {
                                                    id = R.id.tv_mzhSize;
                                                    TextView tvMzhSize2 = (TextView) rootView2.findViewById(R.id.tv_mzhSize);
                                                    if (tvMzhSize2 != null) {
                                                        return new LayoutId6VoiceModelBinding((LinearLayout) rootView2, seekbarMdi2, seekbarMgo2, seekbarMzh2, tvEqgud2, tvEqjues2, tvEqliux2, tvEqwuq2, tvEqyaog2, tvEqyongh2, tvMdiSize2, tvMgoSize2, tvMzhSize2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

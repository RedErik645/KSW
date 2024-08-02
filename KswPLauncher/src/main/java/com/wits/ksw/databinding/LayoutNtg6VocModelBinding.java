package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlRadioButton;

public final class LayoutNtg6VocModelBinding implements ViewBinding {
    public final ImageView imgTwoBack;
    public final ImageView layoutNtg6TimeBg;
    public final RtlRadioButton rdbVocmd1;
    public final RtlRadioButton rdbVocmd2;
    public final RtlRadioButton rdbVocmd3;
    public final RtlRadioButton rdbVocmd4;
    public final RtlRadioButton rdbVocmd5;
    public final RtlRadioButton rdbVocmd6;
    public final RadioGroup rdgVocmd;
    private final RelativeLayout rootView;
    public final SeekBar seekbarMdi;
    public final SeekBar seekbarMgo;
    public final SeekBar seekbarMzh;
    public final TextView tvMdiSize;
    public final TextView tvMgoSize;
    public final TextView tvMzhSize;

    private LayoutNtg6VocModelBinding(RelativeLayout rootView2, ImageView imgTwoBack2, ImageView layoutNtg6TimeBg2, RtlRadioButton rdbVocmd12, RtlRadioButton rdbVocmd22, RtlRadioButton rdbVocmd32, RtlRadioButton rdbVocmd42, RtlRadioButton rdbVocmd52, RtlRadioButton rdbVocmd62, RadioGroup rdgVocmd2, SeekBar seekbarMdi2, SeekBar seekbarMgo2, SeekBar seekbarMzh2, TextView tvMdiSize2, TextView tvMgoSize2, TextView tvMzhSize2) {
        this.rootView = rootView2;
        this.imgTwoBack = imgTwoBack2;
        this.layoutNtg6TimeBg = layoutNtg6TimeBg2;
        this.rdbVocmd1 = rdbVocmd12;
        this.rdbVocmd2 = rdbVocmd22;
        this.rdbVocmd3 = rdbVocmd32;
        this.rdbVocmd4 = rdbVocmd42;
        this.rdbVocmd5 = rdbVocmd52;
        this.rdbVocmd6 = rdbVocmd62;
        this.rdgVocmd = rdgVocmd2;
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

    public static LayoutNtg6VocModelBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutNtg6VocModelBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_ntg6_voc_model, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutNtg6VocModelBinding bind(View rootView2) {
        int id = R.id.img_TwoBack;
        ImageView imgTwoBack2 = (ImageView) rootView2.findViewById(R.id.img_TwoBack);
        if (imgTwoBack2 != null) {
            id = R.id.layout_ntg6_time_bg;
            ImageView layoutNtg6TimeBg2 = (ImageView) rootView2.findViewById(R.id.layout_ntg6_time_bg);
            if (layoutNtg6TimeBg2 != null) {
                id = R.id.rdb_vocmd1;
                RtlRadioButton rdbVocmd12 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_vocmd1);
                if (rdbVocmd12 != null) {
                    id = R.id.rdb_vocmd2;
                    RtlRadioButton rdbVocmd22 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_vocmd2);
                    if (rdbVocmd22 != null) {
                        id = R.id.rdb_vocmd3;
                        RtlRadioButton rdbVocmd32 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_vocmd3);
                        if (rdbVocmd32 != null) {
                            id = R.id.rdb_vocmd4;
                            RtlRadioButton rdbVocmd42 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_vocmd4);
                            if (rdbVocmd42 != null) {
                                id = R.id.rdb_vocmd5;
                                RtlRadioButton rdbVocmd52 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_vocmd5);
                                if (rdbVocmd52 != null) {
                                    id = R.id.rdb_vocmd6;
                                    RtlRadioButton rdbVocmd62 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_vocmd6);
                                    if (rdbVocmd62 != null) {
                                        id = R.id.rdg_vocmd;
                                        RadioGroup rdgVocmd2 = (RadioGroup) rootView2.findViewById(R.id.rdg_vocmd);
                                        if (rdgVocmd2 != null) {
                                            id = R.id.seekbar_mdi;
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
                                                                    return new LayoutNtg6VocModelBinding((RelativeLayout) rootView2, imgTwoBack2, layoutNtg6TimeBg2, rdbVocmd12, rdbVocmd22, rdbVocmd32, rdbVocmd42, rdbVocmd52, rdbVocmd62, rdgVocmd2, seekbarMdi2, seekbarMgo2, seekbarMzh2, tvMdiSize2, tvMgoSize2, tvMzhSize2);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

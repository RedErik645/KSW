package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;

public final class LexusLayoutSetVoiceTwoBinding implements ViewBinding {
    public final ImageView imgTwoDefaul;
    public final LinearLayout llBv;
    public final LinearLayout llOv;
    private final FrameLayout rootView;
    public final SeekBar seekDaohvoicb;
    public final SeekBar seekMtb;
    public final SeekBar seekTonghb;
    public final SeekBar seekYuancthb;
    public final TextView tvDaohvoicsize;
    public final TextView tvMtsize;
    public final TextView tvTonghsize;
    public final TextView tvYuancthsize;

    private LexusLayoutSetVoiceTwoBinding(FrameLayout rootView2, ImageView imgTwoDefaul2, LinearLayout llBv2, LinearLayout llOv2, SeekBar seekDaohvoicb2, SeekBar seekMtb2, SeekBar seekTonghb2, SeekBar seekYuancthb2, TextView tvDaohvoicsize2, TextView tvMtsize2, TextView tvTonghsize2, TextView tvYuancthsize2) {
        this.rootView = rootView2;
        this.imgTwoDefaul = imgTwoDefaul2;
        this.llBv = llBv2;
        this.llOv = llOv2;
        this.seekDaohvoicb = seekDaohvoicb2;
        this.seekMtb = seekMtb2;
        this.seekTonghb = seekTonghb2;
        this.seekYuancthb = seekYuancthb2;
        this.tvDaohvoicsize = tvDaohvoicsize2;
        this.tvMtsize = tvMtsize2;
        this.tvTonghsize = tvTonghsize2;
        this.tvYuancthsize = tvYuancthsize2;
    }

    @Override // android.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LexusLayoutSetVoiceTwoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LexusLayoutSetVoiceTwoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.lexus_layout_set_voice_two, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LexusLayoutSetVoiceTwoBinding bind(View rootView2) {
        int id = R.id.img_twoDefaul;
        ImageView imgTwoDefaul2 = (ImageView) rootView2.findViewById(R.id.img_twoDefaul);
        if (imgTwoDefaul2 != null) {
            id = R.id.ll_bv;
            LinearLayout llBv2 = (LinearLayout) rootView2.findViewById(R.id.ll_bv);
            if (llBv2 != null) {
                id = R.id.ll_ov;
                LinearLayout llOv2 = (LinearLayout) rootView2.findViewById(R.id.ll_ov);
                if (llOv2 != null) {
                    id = R.id.seek_daohvoicb;
                    SeekBar seekDaohvoicb2 = (SeekBar) rootView2.findViewById(R.id.seek_daohvoicb);
                    if (seekDaohvoicb2 != null) {
                        id = R.id.seek_mtb;
                        SeekBar seekMtb2 = (SeekBar) rootView2.findViewById(R.id.seek_mtb);
                        if (seekMtb2 != null) {
                            id = R.id.seek_tonghb;
                            SeekBar seekTonghb2 = (SeekBar) rootView2.findViewById(R.id.seek_tonghb);
                            if (seekTonghb2 != null) {
                                id = R.id.seek_yuancthb;
                                SeekBar seekYuancthb2 = (SeekBar) rootView2.findViewById(R.id.seek_yuancthb);
                                if (seekYuancthb2 != null) {
                                    id = R.id.tv_daohvoicsize;
                                    TextView tvDaohvoicsize2 = (TextView) rootView2.findViewById(R.id.tv_daohvoicsize);
                                    if (tvDaohvoicsize2 != null) {
                                        id = R.id.tv_mtsize;
                                        TextView tvMtsize2 = (TextView) rootView2.findViewById(R.id.tv_mtsize);
                                        if (tvMtsize2 != null) {
                                            id = R.id.tv_tonghsize;
                                            TextView tvTonghsize2 = (TextView) rootView2.findViewById(R.id.tv_tonghsize);
                                            if (tvTonghsize2 != null) {
                                                id = R.id.tv_yuancthsize;
                                                TextView tvYuancthsize2 = (TextView) rootView2.findViewById(R.id.tv_yuancthsize);
                                                if (tvYuancthsize2 != null) {
                                                    return new LexusLayoutSetVoiceTwoBinding((FrameLayout) rootView2, imgTwoDefaul2, llBv2, llOv2, seekDaohvoicb2, seekMtb2, seekTonghb2, seekYuancthb2, tvDaohvoicsize2, tvMtsize2, tvTonghsize2, tvYuancthsize2);
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

package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;

public final class LayoutId6VoiceShwoBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final SeekBar seekDaohvoicb;
    public final SeekBar seekMtb;
    public final SeekBar seekTonghb;
    public final SeekBar seekYuancthb;
    public final TextView tvDaohvoicsize;
    public final TextView tvHouzvoc;
    public final TextView tvMtsize;
    public final TextView tvTonghsize;
    public final TextView tvYuancthsize;
    public final TextView tvYuancvoc;

    private LayoutId6VoiceShwoBinding(RelativeLayout rootView2, SeekBar seekDaohvoicb2, SeekBar seekMtb2, SeekBar seekTonghb2, SeekBar seekYuancthb2, TextView tvDaohvoicsize2, TextView tvHouzvoc2, TextView tvMtsize2, TextView tvTonghsize2, TextView tvYuancthsize2, TextView tvYuancvoc2) {
        this.rootView = rootView2;
        this.seekDaohvoicb = seekDaohvoicb2;
        this.seekMtb = seekMtb2;
        this.seekTonghb = seekTonghb2;
        this.seekYuancthb = seekYuancthb2;
        this.tvDaohvoicsize = tvDaohvoicsize2;
        this.tvHouzvoc = tvHouzvoc2;
        this.tvMtsize = tvMtsize2;
        this.tvTonghsize = tvTonghsize2;
        this.tvYuancthsize = tvYuancthsize2;
        this.tvYuancvoc = tvYuancvoc2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutId6VoiceShwoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutId6VoiceShwoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_id6_voice_shwo, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutId6VoiceShwoBinding bind(View rootView2) {
        int id = R.id.seek_daohvoicb;
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
                            id = R.id.tv_houzvoc;
                            TextView tvHouzvoc2 = (TextView) rootView2.findViewById(R.id.tv_houzvoc);
                            if (tvHouzvoc2 != null) {
                                id = R.id.tv_mtsize;
                                TextView tvMtsize2 = (TextView) rootView2.findViewById(R.id.tv_mtsize);
                                if (tvMtsize2 != null) {
                                    id = R.id.tv_tonghsize;
                                    TextView tvTonghsize2 = (TextView) rootView2.findViewById(R.id.tv_tonghsize);
                                    if (tvTonghsize2 != null) {
                                        id = R.id.tv_yuancthsize;
                                        TextView tvYuancthsize2 = (TextView) rootView2.findViewById(R.id.tv_yuancthsize);
                                        if (tvYuancthsize2 != null) {
                                            id = R.id.tv_yuancvoc;
                                            TextView tvYuancvoc2 = (TextView) rootView2.findViewById(R.id.tv_yuancvoc);
                                            if (tvYuancvoc2 != null) {
                                                return new LayoutId6VoiceShwoBinding((RelativeLayout) rootView2, seekDaohvoicb2, seekMtb2, seekTonghb2, seekYuancthb2, tvDaohvoicsize2, tvHouzvoc2, tvMtsize2, tvTonghsize2, tvYuancthsize2, tvYuancvoc2);
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

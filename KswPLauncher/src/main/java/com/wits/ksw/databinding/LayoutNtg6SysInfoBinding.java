package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;

public final class LayoutNtg6SysInfoBinding implements ViewBinding {
    public final ImageView imgTwoBack;
    public final ImageView ntg6SystemTitle;
    private final RelativeLayout rootView;
    public final MarqueeTextView tvInfoAppv;
    public final MarqueeTextView tvInfoCpu;
    public final TextView tvInfoMcuUp;
    public final MarqueeTextView tvInfoMcuv;
    public final TextView tvInfoSysRest;
    public final TextView tvInfoSysUpDate;
    public final MarqueeTextView tvInfoSysv;

    private LayoutNtg6SysInfoBinding(RelativeLayout rootView2, ImageView imgTwoBack2, ImageView ntg6SystemTitle2, MarqueeTextView tvInfoAppv2, MarqueeTextView tvInfoCpu2, TextView tvInfoMcuUp2, MarqueeTextView tvInfoMcuv2, TextView tvInfoSysRest2, TextView tvInfoSysUpDate2, MarqueeTextView tvInfoSysv2) {
        this.rootView = rootView2;
        this.imgTwoBack = imgTwoBack2;
        this.ntg6SystemTitle = ntg6SystemTitle2;
        this.tvInfoAppv = tvInfoAppv2;
        this.tvInfoCpu = tvInfoCpu2;
        this.tvInfoMcuUp = tvInfoMcuUp2;
        this.tvInfoMcuv = tvInfoMcuv2;
        this.tvInfoSysRest = tvInfoSysRest2;
        this.tvInfoSysUpDate = tvInfoSysUpDate2;
        this.tvInfoSysv = tvInfoSysv2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutNtg6SysInfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutNtg6SysInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_ntg6_sys_info, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutNtg6SysInfoBinding bind(View rootView2) {
        int id = R.id.img_TwoBack;
        ImageView imgTwoBack2 = (ImageView) rootView2.findViewById(R.id.img_TwoBack);
        if (imgTwoBack2 != null) {
            id = R.id.ntg6SystemTitle;
            ImageView ntg6SystemTitle2 = (ImageView) rootView2.findViewById(R.id.ntg6SystemTitle);
            if (ntg6SystemTitle2 != null) {
                id = R.id.tv_infoAppv;
                MarqueeTextView tvInfoAppv2 = (MarqueeTextView) rootView2.findViewById(R.id.tv_infoAppv);
                if (tvInfoAppv2 != null) {
                    id = R.id.tv_infoCpu;
                    MarqueeTextView tvInfoCpu2 = (MarqueeTextView) rootView2.findViewById(R.id.tv_infoCpu);
                    if (tvInfoCpu2 != null) {
                        id = R.id.tv_infoMcuUp;
                        TextView tvInfoMcuUp2 = (TextView) rootView2.findViewById(R.id.tv_infoMcuUp);
                        if (tvInfoMcuUp2 != null) {
                            id = R.id.tv_infoMcuv;
                            MarqueeTextView tvInfoMcuv2 = (MarqueeTextView) rootView2.findViewById(R.id.tv_infoMcuv);
                            if (tvInfoMcuv2 != null) {
                                id = R.id.tv_infoSysRest;
                                TextView tvInfoSysRest2 = (TextView) rootView2.findViewById(R.id.tv_infoSysRest);
                                if (tvInfoSysRest2 != null) {
                                    id = R.id.tv_infoSysUpDate;
                                    TextView tvInfoSysUpDate2 = (TextView) rootView2.findViewById(R.id.tv_infoSysUpDate);
                                    if (tvInfoSysUpDate2 != null) {
                                        id = R.id.tv_infoSysv;
                                        MarqueeTextView tvInfoSysv2 = (MarqueeTextView) rootView2.findViewById(R.id.tv_infoSysv);
                                        if (tvInfoSysv2 != null) {
                                            return new LayoutNtg6SysInfoBinding((RelativeLayout) rootView2, imgTwoBack2, ntg6SystemTitle2, tvInfoAppv2, tvInfoCpu2, tvInfoMcuUp2, tvInfoMcuv2, tvInfoSysRest2, tvInfoSysUpDate2, tvInfoSysv2);
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

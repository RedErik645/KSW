package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;

public final class LayoutId6SysInfoBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView tvInfoAppv;
    public final MarqueeTextView tvInfoCpu;
    public final TextView tvInfoFlash;
    public final TextView tvInfoMcuUp;
    public final TextView tvInfoMcuv;
    public final TextView tvInfoRam;
    public final TextView tvInfoSysRest;
    public final TextView tvInfoSysUpDate;
    public final TextView tvInfoSysv;

    private LayoutId6SysInfoBinding(RelativeLayout rootView2, TextView tvInfoAppv2, MarqueeTextView tvInfoCpu2, TextView tvInfoFlash2, TextView tvInfoMcuUp2, TextView tvInfoMcuv2, TextView tvInfoRam2, TextView tvInfoSysRest2, TextView tvInfoSysUpDate2, TextView tvInfoSysv2) {
        this.rootView = rootView2;
        this.tvInfoAppv = tvInfoAppv2;
        this.tvInfoCpu = tvInfoCpu2;
        this.tvInfoFlash = tvInfoFlash2;
        this.tvInfoMcuUp = tvInfoMcuUp2;
        this.tvInfoMcuv = tvInfoMcuv2;
        this.tvInfoRam = tvInfoRam2;
        this.tvInfoSysRest = tvInfoSysRest2;
        this.tvInfoSysUpDate = tvInfoSysUpDate2;
        this.tvInfoSysv = tvInfoSysv2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutId6SysInfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutId6SysInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_id6_sys_info, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutId6SysInfoBinding bind(View rootView2) {
        int id = R.id.tv_infoAppv;
        TextView tvInfoAppv2 = (TextView) rootView2.findViewById(R.id.tv_infoAppv);
        if (tvInfoAppv2 != null) {
            id = R.id.tv_infoCpu;
            MarqueeTextView tvInfoCpu2 = (MarqueeTextView) rootView2.findViewById(R.id.tv_infoCpu);
            if (tvInfoCpu2 != null) {
                id = R.id.tv_infoFlash;
                TextView tvInfoFlash2 = (TextView) rootView2.findViewById(R.id.tv_infoFlash);
                if (tvInfoFlash2 != null) {
                    id = R.id.tv_infoMcuUp;
                    TextView tvInfoMcuUp2 = (TextView) rootView2.findViewById(R.id.tv_infoMcuUp);
                    if (tvInfoMcuUp2 != null) {
                        id = R.id.tv_infoMcuv;
                        TextView tvInfoMcuv2 = (TextView) rootView2.findViewById(R.id.tv_infoMcuv);
                        if (tvInfoMcuv2 != null) {
                            id = R.id.tv_infoRam;
                            TextView tvInfoRam2 = (TextView) rootView2.findViewById(R.id.tv_infoRam);
                            if (tvInfoRam2 != null) {
                                id = R.id.tv_infoSysRest;
                                TextView tvInfoSysRest2 = (TextView) rootView2.findViewById(R.id.tv_infoSysRest);
                                if (tvInfoSysRest2 != null) {
                                    id = R.id.tv_infoSysUpDate;
                                    TextView tvInfoSysUpDate2 = (TextView) rootView2.findViewById(R.id.tv_infoSysUpDate);
                                    if (tvInfoSysUpDate2 != null) {
                                        id = R.id.tv_infoSysv;
                                        TextView tvInfoSysv2 = (TextView) rootView2.findViewById(R.id.tv_infoSysv);
                                        if (tvInfoSysv2 != null) {
                                            return new LayoutId6SysInfoBinding((RelativeLayout) rootView2, tvInfoAppv2, tvInfoCpu2, tvInfoFlash2, tvInfoMcuUp2, tvInfoMcuv2, tvInfoRam2, tvInfoSysRest2, tvInfoSysUpDate2, tvInfoSysv2);
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

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
import com.wits.ksw.settings.utlis_view.RtlCheckBox;

public final class LayoutNtg6SystemsetOneBinding implements ViewBinding {
    public final MarqueeTextView benzSysTempUnit;
    public final RtlCheckBox cboxSysDcgj;
    public final RtlCheckBox cboxSysDcjy;
    public final RtlCheckBox cboxSysDcld;
    public final RtlCheckBox cboxSysHjs;
    public final RtlCheckBox cboxSysXcjz;
    public final ImageView imgTwoBack;
    public final ImageView layoutNtg6SystemsetOneBg;
    private final RelativeLayout rootView;
    public final MarqueeTextView tvMusicApp;
    public final MarqueeTextView tvSysBgld;
    public final TextView tvSysCaux;
    public final MarqueeTextView tvSysDcsxt;
    public final MarqueeTextView tvVideoApp;

    private LayoutNtg6SystemsetOneBinding(RelativeLayout rootView2, MarqueeTextView benzSysTempUnit2, RtlCheckBox cboxSysDcgj2, RtlCheckBox cboxSysDcjy2, RtlCheckBox cboxSysDcld2, RtlCheckBox cboxSysHjs2, RtlCheckBox cboxSysXcjz2, ImageView imgTwoBack2, ImageView layoutNtg6SystemsetOneBg2, MarqueeTextView tvMusicApp2, MarqueeTextView tvSysBgld2, TextView tvSysCaux2, MarqueeTextView tvSysDcsxt2, MarqueeTextView tvVideoApp2) {
        this.rootView = rootView2;
        this.benzSysTempUnit = benzSysTempUnit2;
        this.cboxSysDcgj = cboxSysDcgj2;
        this.cboxSysDcjy = cboxSysDcjy2;
        this.cboxSysDcld = cboxSysDcld2;
        this.cboxSysHjs = cboxSysHjs2;
        this.cboxSysXcjz = cboxSysXcjz2;
        this.imgTwoBack = imgTwoBack2;
        this.layoutNtg6SystemsetOneBg = layoutNtg6SystemsetOneBg2;
        this.tvMusicApp = tvMusicApp2;
        this.tvSysBgld = tvSysBgld2;
        this.tvSysCaux = tvSysCaux2;
        this.tvSysDcsxt = tvSysDcsxt2;
        this.tvVideoApp = tvVideoApp2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutNtg6SystemsetOneBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutNtg6SystemsetOneBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_ntg6_systemset_one, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutNtg6SystemsetOneBinding bind(View rootView2) {
        int id = R.id.benz_sysTempUnit;
        MarqueeTextView benzSysTempUnit2 = (MarqueeTextView) rootView2.findViewById(R.id.benz_sysTempUnit);
        if (benzSysTempUnit2 != null) {
            id = R.id.cbox_sysDcgj;
            RtlCheckBox cboxSysDcgj2 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_sysDcgj);
            if (cboxSysDcgj2 != null) {
                id = R.id.cbox_sysDcjy;
                RtlCheckBox cboxSysDcjy2 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_sysDcjy);
                if (cboxSysDcjy2 != null) {
                    id = R.id.cbox_sysDcld;
                    RtlCheckBox cboxSysDcld2 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_sysDcld);
                    if (cboxSysDcld2 != null) {
                        id = R.id.cbox_sysHjs;
                        RtlCheckBox cboxSysHjs2 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_sysHjs);
                        if (cboxSysHjs2 != null) {
                            id = R.id.cbox_sysXcjz;
                            RtlCheckBox cboxSysXcjz2 = (RtlCheckBox) rootView2.findViewById(R.id.cbox_sysXcjz);
                            if (cboxSysXcjz2 != null) {
                                id = R.id.img_TwoBack;
                                ImageView imgTwoBack2 = (ImageView) rootView2.findViewById(R.id.img_TwoBack);
                                if (imgTwoBack2 != null) {
                                    id = R.id.layout_ntg6_systemset_one_bg;
                                    ImageView layoutNtg6SystemsetOneBg2 = (ImageView) rootView2.findViewById(R.id.layout_ntg6_systemset_one_bg);
                                    if (layoutNtg6SystemsetOneBg2 != null) {
                                        id = R.id.tv_music_app;
                                        MarqueeTextView tvMusicApp2 = (MarqueeTextView) rootView2.findViewById(R.id.tv_music_app);
                                        if (tvMusicApp2 != null) {
                                            id = R.id.tv_sysBgld;
                                            MarqueeTextView tvSysBgld2 = (MarqueeTextView) rootView2.findViewById(R.id.tv_sysBgld);
                                            if (tvSysBgld2 != null) {
                                                id = R.id.tv_sysCaux;
                                                TextView tvSysCaux2 = (TextView) rootView2.findViewById(R.id.tv_sysCaux);
                                                if (tvSysCaux2 != null) {
                                                    id = R.id.tv_sysDcsxt;
                                                    MarqueeTextView tvSysDcsxt2 = (MarqueeTextView) rootView2.findViewById(R.id.tv_sysDcsxt);
                                                    if (tvSysDcsxt2 != null) {
                                                        id = R.id.tv_video_app;
                                                        MarqueeTextView tvVideoApp2 = (MarqueeTextView) rootView2.findViewById(R.id.tv_video_app);
                                                        if (tvVideoApp2 != null) {
                                                            return new LayoutNtg6SystemsetOneBinding((RelativeLayout) rootView2, benzSysTempUnit2, cboxSysDcgj2, cboxSysDcjy2, cboxSysDcld2, cboxSysHjs2, cboxSysXcjz2, imgTwoBack2, layoutNtg6SystemsetOneBg2, tvMusicApp2, tvSysBgld2, tvSysCaux2, tvSysDcsxt2, tvVideoApp2);
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

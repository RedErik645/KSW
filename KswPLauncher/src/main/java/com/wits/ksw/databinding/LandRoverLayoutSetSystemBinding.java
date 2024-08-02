package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlCheckBox;

public final class LandRoverLayoutSetSystemBinding implements ViewBinding {
    public final RtlCheckBox cboxSysDcgj;
    public final RtlCheckBox cboxSysDcjy;
    public final RtlCheckBox cboxSysDcld;
    public final RtlCheckBox cboxSysHjs;
    public final RtlCheckBox cboxSysXcjz;
    public final LinearLayout relateBeigld;
    private final ScrollView rootView;
    public final SeekBar seekbarBrightness;
    public final TextView tvBeigSize;
    public final TextView tvMusicApp;
    public final TextView tvSysBgld;
    public final TextView tvSysCaux;
    public final TextView tvSysDcsxt;
    public final TextView tvSysTempUnit;
    public final TextView tvVideoApp;

    private LandRoverLayoutSetSystemBinding(ScrollView rootView2, RtlCheckBox cboxSysDcgj2, RtlCheckBox cboxSysDcjy2, RtlCheckBox cboxSysDcld2, RtlCheckBox cboxSysHjs2, RtlCheckBox cboxSysXcjz2, LinearLayout relateBeigld2, SeekBar seekbarBrightness2, TextView tvBeigSize2, TextView tvMusicApp2, TextView tvSysBgld2, TextView tvSysCaux2, TextView tvSysDcsxt2, TextView tvSysTempUnit2, TextView tvVideoApp2) {
        this.rootView = rootView2;
        this.cboxSysDcgj = cboxSysDcgj2;
        this.cboxSysDcjy = cboxSysDcjy2;
        this.cboxSysDcld = cboxSysDcld2;
        this.cboxSysHjs = cboxSysHjs2;
        this.cboxSysXcjz = cboxSysXcjz2;
        this.relateBeigld = relateBeigld2;
        this.seekbarBrightness = seekbarBrightness2;
        this.tvBeigSize = tvBeigSize2;
        this.tvMusicApp = tvMusicApp2;
        this.tvSysBgld = tvSysBgld2;
        this.tvSysCaux = tvSysCaux2;
        this.tvSysDcsxt = tvSysDcsxt2;
        this.tvSysTempUnit = tvSysTempUnit2;
        this.tvVideoApp = tvVideoApp2;
    }

    @Override // android.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static LandRoverLayoutSetSystemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LandRoverLayoutSetSystemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.land_rover_layout_set_system, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LandRoverLayoutSetSystemBinding bind(View rootView2) {
        int id = R.id.cbox_sysDcgj;
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
                            id = R.id.relate_beigld;
                            LinearLayout relateBeigld2 = (LinearLayout) rootView2.findViewById(R.id.relate_beigld);
                            if (relateBeigld2 != null) {
                                id = R.id.seekbar_brightness;
                                SeekBar seekbarBrightness2 = (SeekBar) rootView2.findViewById(R.id.seekbar_brightness);
                                if (seekbarBrightness2 != null) {
                                    id = R.id.tv_beigSize;
                                    TextView tvBeigSize2 = (TextView) rootView2.findViewById(R.id.tv_beigSize);
                                    if (tvBeigSize2 != null) {
                                        id = R.id.tv_music_app;
                                        TextView tvMusicApp2 = (TextView) rootView2.findViewById(R.id.tv_music_app);
                                        if (tvMusicApp2 != null) {
                                            id = R.id.tv_sysBgld;
                                            TextView tvSysBgld2 = (TextView) rootView2.findViewById(R.id.tv_sysBgld);
                                            if (tvSysBgld2 != null) {
                                                id = R.id.tv_sysCaux;
                                                TextView tvSysCaux2 = (TextView) rootView2.findViewById(R.id.tv_sysCaux);
                                                if (tvSysCaux2 != null) {
                                                    id = R.id.tv_sysDcsxt;
                                                    TextView tvSysDcsxt2 = (TextView) rootView2.findViewById(R.id.tv_sysDcsxt);
                                                    if (tvSysDcsxt2 != null) {
                                                        id = R.id.tv_sysTempUnit;
                                                        TextView tvSysTempUnit2 = (TextView) rootView2.findViewById(R.id.tv_sysTempUnit);
                                                        if (tvSysTempUnit2 != null) {
                                                            id = R.id.tv_video_app;
                                                            TextView tvVideoApp2 = (TextView) rootView2.findViewById(R.id.tv_video_app);
                                                            if (tvVideoApp2 != null) {
                                                                return new LandRoverLayoutSetSystemBinding((ScrollView) rootView2, cboxSysDcgj2, cboxSysDcjy2, cboxSysDcld2, cboxSysHjs2, cboxSysXcjz2, relateBeigld2, seekbarBrightness2, tvBeigSize2, tvMusicApp2, tvSysBgld2, tvSysCaux2, tvSysDcsxt2, tvSysTempUnit2, tvVideoApp2);
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

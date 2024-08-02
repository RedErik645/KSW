package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlCheckBox;

public final class LayoutId6SetSystemBinding implements ViewBinding {
    public final RtlCheckBox cboxSysDcgj;
    public final RtlCheckBox cboxSysDcjy;
    public final RtlCheckBox cboxSysDcld;
    public final RtlCheckBox cboxSysHjs;
    public final RtlCheckBox cboxSysXcjz;
    public final TextView id6SysFuelUnit;
    public final TextView id6SysTempUnit;
    private final ScrollView rootView;
    public final SeekBar seekbarBrightness;
    public final TextView tvBeigSize;
    public final TextView tvMusicApp;
    public final TextView tvSysCaux;
    public final TextView tvSysDcsxt;
    public final TextView tvVideoApp;

    private LayoutId6SetSystemBinding(ScrollView rootView2, RtlCheckBox cboxSysDcgj2, RtlCheckBox cboxSysDcjy2, RtlCheckBox cboxSysDcld2, RtlCheckBox cboxSysHjs2, RtlCheckBox cboxSysXcjz2, TextView id6SysFuelUnit2, TextView id6SysTempUnit2, SeekBar seekbarBrightness2, TextView tvBeigSize2, TextView tvMusicApp2, TextView tvSysCaux2, TextView tvSysDcsxt2, TextView tvVideoApp2) {
        this.rootView = rootView2;
        this.cboxSysDcgj = cboxSysDcgj2;
        this.cboxSysDcjy = cboxSysDcjy2;
        this.cboxSysDcld = cboxSysDcld2;
        this.cboxSysHjs = cboxSysHjs2;
        this.cboxSysXcjz = cboxSysXcjz2;
        this.id6SysFuelUnit = id6SysFuelUnit2;
        this.id6SysTempUnit = id6SysTempUnit2;
        this.seekbarBrightness = seekbarBrightness2;
        this.tvBeigSize = tvBeigSize2;
        this.tvMusicApp = tvMusicApp2;
        this.tvSysCaux = tvSysCaux2;
        this.tvSysDcsxt = tvSysDcsxt2;
        this.tvVideoApp = tvVideoApp2;
    }

    @Override // android.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static LayoutId6SetSystemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutId6SetSystemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_id6_set_system, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutId6SetSystemBinding bind(View rootView2) {
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
                            id = R.id.id6_sysFuelUnit;
                            TextView id6SysFuelUnit2 = (TextView) rootView2.findViewById(R.id.id6_sysFuelUnit);
                            if (id6SysFuelUnit2 != null) {
                                id = R.id.id6_sysTempUnit;
                                TextView id6SysTempUnit2 = (TextView) rootView2.findViewById(R.id.id6_sysTempUnit);
                                if (id6SysTempUnit2 != null) {
                                    id = R.id.seekbar_brightness;
                                    SeekBar seekbarBrightness2 = (SeekBar) rootView2.findViewById(R.id.seekbar_brightness);
                                    if (seekbarBrightness2 != null) {
                                        id = R.id.tv_beigSize;
                                        TextView tvBeigSize2 = (TextView) rootView2.findViewById(R.id.tv_beigSize);
                                        if (tvBeigSize2 != null) {
                                            id = R.id.tv_music_app;
                                            TextView tvMusicApp2 = (TextView) rootView2.findViewById(R.id.tv_music_app);
                                            if (tvMusicApp2 != null) {
                                                id = R.id.tv_sysCaux;
                                                TextView tvSysCaux2 = (TextView) rootView2.findViewById(R.id.tv_sysCaux);
                                                if (tvSysCaux2 != null) {
                                                    id = R.id.tv_sysDcsxt;
                                                    TextView tvSysDcsxt2 = (TextView) rootView2.findViewById(R.id.tv_sysDcsxt);
                                                    if (tvSysDcsxt2 != null) {
                                                        id = R.id.tv_video_app;
                                                        TextView tvVideoApp2 = (TextView) rootView2.findViewById(R.id.tv_video_app);
                                                        if (tvVideoApp2 != null) {
                                                            return new LayoutId6SetSystemBinding((ScrollView) rootView2, cboxSysDcgj2, cboxSysDcjy2, cboxSysDcld2, cboxSysHjs2, cboxSysXcjz2, id6SysFuelUnit2, id6SysTempUnit2, seekbarBrightness2, tvBeigSize2, tvMusicApp2, tvSysCaux2, tvSysDcsxt2, tvVideoApp2);
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

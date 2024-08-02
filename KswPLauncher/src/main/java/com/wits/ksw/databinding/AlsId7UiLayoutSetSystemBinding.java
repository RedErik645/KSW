package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.CustomSkinCheckBox;

public final class AlsId7UiLayoutSetSystemBinding implements ViewBinding {
    public final ImageView auxBottomIv;
    public final CustomSkinCheckBox cboxSysDcgj;
    public final CustomSkinCheckBox cboxSysDcjy;
    public final CustomSkinCheckBox cboxSysDcld;
    public final CustomSkinCheckBox cboxSysHjs;
    public final CustomSkinCheckBox cboxSysXcjz;
    private final ScrollView rootView;
    public final TextView tvMusicApp;
    public final TextView tvSysBgld;
    public final TextView tvSysCaux;
    public final TextView tvSysDcsxt;
    public final TextView tvSysFuelUnit;
    public final TextView tvSysTempUnit;
    public final TextView tvVideoApp;

    private AlsId7UiLayoutSetSystemBinding(ScrollView rootView2, ImageView auxBottomIv2, CustomSkinCheckBox cboxSysDcgj2, CustomSkinCheckBox cboxSysDcjy2, CustomSkinCheckBox cboxSysDcld2, CustomSkinCheckBox cboxSysHjs2, CustomSkinCheckBox cboxSysXcjz2, TextView tvMusicApp2, TextView tvSysBgld2, TextView tvSysCaux2, TextView tvSysDcsxt2, TextView tvSysFuelUnit2, TextView tvSysTempUnit2, TextView tvVideoApp2) {
        this.rootView = rootView2;
        this.auxBottomIv = auxBottomIv2;
        this.cboxSysDcgj = cboxSysDcgj2;
        this.cboxSysDcjy = cboxSysDcjy2;
        this.cboxSysDcld = cboxSysDcld2;
        this.cboxSysHjs = cboxSysHjs2;
        this.cboxSysXcjz = cboxSysXcjz2;
        this.tvMusicApp = tvMusicApp2;
        this.tvSysBgld = tvSysBgld2;
        this.tvSysCaux = tvSysCaux2;
        this.tvSysDcsxt = tvSysDcsxt2;
        this.tvSysFuelUnit = tvSysFuelUnit2;
        this.tvSysTempUnit = tvSysTempUnit2;
        this.tvVideoApp = tvVideoApp2;
    }

    @Override // android.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static AlsId7UiLayoutSetSystemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AlsId7UiLayoutSetSystemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.als_id7_ui_layout_set_system, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AlsId7UiLayoutSetSystemBinding bind(View rootView2) {
        int id = R.id.aux_bottom_iv;
        ImageView auxBottomIv2 = (ImageView) rootView2.findViewById(R.id.aux_bottom_iv);
        if (auxBottomIv2 != null) {
            id = R.id.cbox_sysDcgj;
            CustomSkinCheckBox cboxSysDcgj2 = (CustomSkinCheckBox) rootView2.findViewById(R.id.cbox_sysDcgj);
            if (cboxSysDcgj2 != null) {
                id = R.id.cbox_sysDcjy;
                CustomSkinCheckBox cboxSysDcjy2 = (CustomSkinCheckBox) rootView2.findViewById(R.id.cbox_sysDcjy);
                if (cboxSysDcjy2 != null) {
                    id = R.id.cbox_sysDcld;
                    CustomSkinCheckBox cboxSysDcld2 = (CustomSkinCheckBox) rootView2.findViewById(R.id.cbox_sysDcld);
                    if (cboxSysDcld2 != null) {
                        id = R.id.cbox_sysHjs;
                        CustomSkinCheckBox cboxSysHjs2 = (CustomSkinCheckBox) rootView2.findViewById(R.id.cbox_sysHjs);
                        if (cboxSysHjs2 != null) {
                            id = R.id.cbox_sysXcjz;
                            CustomSkinCheckBox cboxSysXcjz2 = (CustomSkinCheckBox) rootView2.findViewById(R.id.cbox_sysXcjz);
                            if (cboxSysXcjz2 != null) {
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
                                                id = R.id.tv_sysFuelUnit;
                                                TextView tvSysFuelUnit2 = (TextView) rootView2.findViewById(R.id.tv_sysFuelUnit);
                                                if (tvSysFuelUnit2 != null) {
                                                    id = R.id.tv_sysTempUnit;
                                                    TextView tvSysTempUnit2 = (TextView) rootView2.findViewById(R.id.tv_sysTempUnit);
                                                    if (tvSysTempUnit2 != null) {
                                                        id = R.id.tv_video_app;
                                                        TextView tvVideoApp2 = (TextView) rootView2.findViewById(R.id.tv_video_app);
                                                        if (tvVideoApp2 != null) {
                                                            return new AlsId7UiLayoutSetSystemBinding((ScrollView) rootView2, auxBottomIv2, cboxSysDcgj2, cboxSysDcjy2, cboxSysDcld2, cboxSysHjs2, cboxSysXcjz2, tvMusicApp2, tvSysBgld2, tvSysCaux2, tvSysDcsxt2, tvSysFuelUnit2, tvSysTempUnit2, tvVideoApp2);
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

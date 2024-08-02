package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;
import com.wits.ksw.settings.utlis_view.RtlRadioButton;

public final class LayoutNtg6SystemTwoBinding implements ViewBinding {
    public final ImageView imgTwoBack;
    public final ImageView layoutNtg6SystemTwoBg;
    public final RecyclerView listviewMusic;
    public final RecyclerView listviewVideo;
    public final RtlRadioButton rdbShext1;
    public final RtlRadioButton rdbShext2;
    public final RtlRadioButton rdbShext3;
    public final RtlRadioButton rdbShext4;
    public final RadioGroup rdgBenzTempUnitRadioGroup;
    public final RadioGroup rdgShext;
    public final LinearLayout relateAuxweiz;
    public final LinearLayout relateBeigld;
    public final RelativeLayout relateShext;
    private final RelativeLayout rootView;
    public final SeekBar seekbarBrightness;
    public final SeekBar seekbarCaux;
    public final SeekBar seekbarCaux2;
    public final TextView tvBeigSize;
    public final TextView tvCauxSize;
    public final TextView tvCauxSize2;
    public final TextView tvTebgld;
    public final MarqueeTextView tvTwoMsg;

    private LayoutNtg6SystemTwoBinding(RelativeLayout rootView2, ImageView imgTwoBack2, ImageView layoutNtg6SystemTwoBg2, RecyclerView listviewMusic2, RecyclerView listviewVideo2, RtlRadioButton rdbShext12, RtlRadioButton rdbShext22, RtlRadioButton rdbShext32, RtlRadioButton rdbShext42, RadioGroup rdgBenzTempUnitRadioGroup2, RadioGroup rdgShext2, LinearLayout relateAuxweiz2, LinearLayout relateBeigld2, RelativeLayout relateShext2, SeekBar seekbarBrightness2, SeekBar seekbarCaux3, SeekBar seekbarCaux22, TextView tvBeigSize2, TextView tvCauxSize3, TextView tvCauxSize22, TextView tvTebgld2, MarqueeTextView tvTwoMsg2) {
        this.rootView = rootView2;
        this.imgTwoBack = imgTwoBack2;
        this.layoutNtg6SystemTwoBg = layoutNtg6SystemTwoBg2;
        this.listviewMusic = listviewMusic2;
        this.listviewVideo = listviewVideo2;
        this.rdbShext1 = rdbShext12;
        this.rdbShext2 = rdbShext22;
        this.rdbShext3 = rdbShext32;
        this.rdbShext4 = rdbShext42;
        this.rdgBenzTempUnitRadioGroup = rdgBenzTempUnitRadioGroup2;
        this.rdgShext = rdgShext2;
        this.relateAuxweiz = relateAuxweiz2;
        this.relateBeigld = relateBeigld2;
        this.relateShext = relateShext2;
        this.seekbarBrightness = seekbarBrightness2;
        this.seekbarCaux = seekbarCaux3;
        this.seekbarCaux2 = seekbarCaux22;
        this.tvBeigSize = tvBeigSize2;
        this.tvCauxSize = tvCauxSize3;
        this.tvCauxSize2 = tvCauxSize22;
        this.tvTebgld = tvTebgld2;
        this.tvTwoMsg = tvTwoMsg2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutNtg6SystemTwoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutNtg6SystemTwoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_ntg6_system_two, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutNtg6SystemTwoBinding bind(View rootView2) {
        int id = R.id.img_TwoBack;
        ImageView imgTwoBack2 = (ImageView) rootView2.findViewById(R.id.img_TwoBack);
        if (imgTwoBack2 != null) {
            ImageView layoutNtg6SystemTwoBg2 = (ImageView) rootView2.findViewById(R.id.layout_ntg6_system_two_bg);
            id = R.id.listview_music;
            RecyclerView listviewMusic2 = (RecyclerView) rootView2.findViewById(R.id.listview_music);
            if (listviewMusic2 != null) {
                id = R.id.listview_video;
                RecyclerView listviewVideo2 = (RecyclerView) rootView2.findViewById(R.id.listview_video);
                if (listviewVideo2 != null) {
                    id = R.id.rdb_shext1;
                    RtlRadioButton rdbShext12 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_shext1);
                    if (rdbShext12 != null) {
                        id = R.id.rdb_shext2;
                        RtlRadioButton rdbShext22 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_shext2);
                        if (rdbShext22 != null) {
                            id = R.id.rdb_shext3;
                            RtlRadioButton rdbShext32 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_shext3);
                            if (rdbShext32 != null) {
                                id = R.id.rdb_shext4;
                                RtlRadioButton rdbShext42 = (RtlRadioButton) rootView2.findViewById(R.id.rdb_shext4);
                                if (rdbShext42 != null) {
                                    id = R.id.rdg_benz_tempUnit_radioGroup;
                                    RadioGroup rdgBenzTempUnitRadioGroup2 = (RadioGroup) rootView2.findViewById(R.id.rdg_benz_tempUnit_radioGroup);
                                    if (rdgBenzTempUnitRadioGroup2 != null) {
                                        id = R.id.rdg_shext;
                                        RadioGroup rdgShext2 = (RadioGroup) rootView2.findViewById(R.id.rdg_shext);
                                        if (rdgShext2 != null) {
                                            id = R.id.relate_auxweiz;
                                            LinearLayout relateAuxweiz2 = (LinearLayout) rootView2.findViewById(R.id.relate_auxweiz);
                                            if (relateAuxweiz2 != null) {
                                                id = R.id.relate_beigld;
                                                LinearLayout relateBeigld2 = (LinearLayout) rootView2.findViewById(R.id.relate_beigld);
                                                if (relateBeigld2 != null) {
                                                    id = R.id.relate_shext;
                                                    RelativeLayout relateShext2 = (RelativeLayout) rootView2.findViewById(R.id.relate_shext);
                                                    if (relateShext2 != null) {
                                                        id = R.id.seekbar_brightness;
                                                        SeekBar seekbarBrightness2 = (SeekBar) rootView2.findViewById(R.id.seekbar_brightness);
                                                        if (seekbarBrightness2 != null) {
                                                            id = R.id.seekbar_caux;
                                                            SeekBar seekbarCaux3 = (SeekBar) rootView2.findViewById(R.id.seekbar_caux);
                                                            if (seekbarCaux3 != null) {
                                                                id = R.id.seekbar_caux2;
                                                                SeekBar seekbarCaux22 = (SeekBar) rootView2.findViewById(R.id.seekbar_caux2);
                                                                if (seekbarCaux22 != null) {
                                                                    id = R.id.tv_beigSize;
                                                                    TextView tvBeigSize2 = (TextView) rootView2.findViewById(R.id.tv_beigSize);
                                                                    if (tvBeigSize2 != null) {
                                                                        id = R.id.tv_cauxSize;
                                                                        TextView tvCauxSize3 = (TextView) rootView2.findViewById(R.id.tv_cauxSize);
                                                                        if (tvCauxSize3 != null) {
                                                                            id = R.id.tv_cauxSize2;
                                                                            TextView tvCauxSize22 = (TextView) rootView2.findViewById(R.id.tv_cauxSize2);
                                                                            if (tvCauxSize22 != null) {
                                                                                id = R.id.tv_tebgld;
                                                                                TextView tvTebgld2 = (TextView) rootView2.findViewById(R.id.tv_tebgld);
                                                                                if (tvTebgld2 != null) {
                                                                                    id = R.id.tv_TwoMsg;
                                                                                    MarqueeTextView tvTwoMsg2 = (MarqueeTextView) rootView2.findViewById(R.id.tv_TwoMsg);
                                                                                    if (tvTwoMsg2 != null) {
                                                                                        return new LayoutNtg6SystemTwoBinding((RelativeLayout) rootView2, imgTwoBack2, layoutNtg6SystemTwoBg2, listviewMusic2, listviewVideo2, rdbShext12, rdbShext22, rdbShext32, rdbShext42, rdgBenzTempUnitRadioGroup2, rdgShext2, relateAuxweiz2, relateBeigld2, relateShext2, seekbarBrightness2, seekbarCaux3, seekbarCaux22, tvBeigSize2, tvCauxSize3, tvCauxSize22, tvTebgld2, tvTwoMsg2);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

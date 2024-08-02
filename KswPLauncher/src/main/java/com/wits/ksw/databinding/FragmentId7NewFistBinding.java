package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.CustomFontTextView;

public final class FragmentId7NewFistBinding implements ViewBinding {
    public final ImageView imgXczhiz;
    public final RelativeLayout relFirtNav;
    public final RelativeLayout relFirtaps;
    public final RelativeLayout relFirtbt;
    public final RelativeLayout relFirtci;
    public final RelativeLayout relFirtxc;
    private final RelativeLayout rootView;
    public final CustomFontTextView tvBtInfo;
    public final CustomFontTextView tvXcInfo;

    private FragmentId7NewFistBinding(RelativeLayout rootView2, ImageView imgXczhiz2, RelativeLayout relFirtNav2, RelativeLayout relFirtaps2, RelativeLayout relFirtbt2, RelativeLayout relFirtci2, RelativeLayout relFirtxc2, CustomFontTextView tvBtInfo2, CustomFontTextView tvXcInfo2) {
        this.rootView = rootView2;
        this.imgXczhiz = imgXczhiz2;
        this.relFirtNav = relFirtNav2;
        this.relFirtaps = relFirtaps2;
        this.relFirtbt = relFirtbt2;
        this.relFirtci = relFirtci2;
        this.relFirtxc = relFirtxc2;
        this.tvBtInfo = tvBtInfo2;
        this.tvXcInfo = tvXcInfo2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentId7NewFistBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentId7NewFistBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_id7_new_fist, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentId7NewFistBinding bind(View rootView2) {
        int id = R.id.img_xczhiz;
        ImageView imgXczhiz2 = (ImageView) rootView2.findViewById(R.id.img_xczhiz);
        if (imgXczhiz2 != null) {
            id = R.id.rel_firtNav;
            RelativeLayout relFirtNav2 = (RelativeLayout) rootView2.findViewById(R.id.rel_firtNav);
            if (relFirtNav2 != null) {
                id = R.id.rel_firtaps;
                RelativeLayout relFirtaps2 = (RelativeLayout) rootView2.findViewById(R.id.rel_firtaps);
                if (relFirtaps2 != null) {
                    id = R.id.rel_firtbt;
                    RelativeLayout relFirtbt2 = (RelativeLayout) rootView2.findViewById(R.id.rel_firtbt);
                    if (relFirtbt2 != null) {
                        id = R.id.rel_firtci;
                        RelativeLayout relFirtci2 = (RelativeLayout) rootView2.findViewById(R.id.rel_firtci);
                        if (relFirtci2 != null) {
                            id = R.id.rel_firtxc;
                            RelativeLayout relFirtxc2 = (RelativeLayout) rootView2.findViewById(R.id.rel_firtxc);
                            if (relFirtxc2 != null) {
                                id = R.id.tv_btInfo;
                                CustomFontTextView tvBtInfo2 = (CustomFontTextView) rootView2.findViewById(R.id.tv_btInfo);
                                if (tvBtInfo2 != null) {
                                    id = R.id.tv_xcInfo;
                                    CustomFontTextView tvXcInfo2 = (CustomFontTextView) rootView2.findViewById(R.id.tv_xcInfo);
                                    if (tvXcInfo2 != null) {
                                        return new FragmentId7NewFistBinding((RelativeLayout) rootView2, imgXczhiz2, relFirtNav2, relFirtaps2, relFirtbt2, relFirtci2, relFirtxc2, tvBtInfo2, tvXcInfo2);
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

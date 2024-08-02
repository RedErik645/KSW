package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.CustomFontTextView;

public final class FragmentId7NewTwoBinding implements ViewBinding {
    public final RelativeLayout relFirtMs;
    public final RelativeLayout relFirtfm;
    public final RelativeLayout relFirtie;
    public final RelativeLayout relFirtset;
    public final RelativeLayout relFirtvd;
    private final RelativeLayout rootView;
    public final CustomFontTextView tvMsInfo;

    private FragmentId7NewTwoBinding(RelativeLayout rootView2, RelativeLayout relFirtMs2, RelativeLayout relFirtfm2, RelativeLayout relFirtie2, RelativeLayout relFirtset2, RelativeLayout relFirtvd2, CustomFontTextView tvMsInfo2) {
        this.rootView = rootView2;
        this.relFirtMs = relFirtMs2;
        this.relFirtfm = relFirtfm2;
        this.relFirtie = relFirtie2;
        this.relFirtset = relFirtset2;
        this.relFirtvd = relFirtvd2;
        this.tvMsInfo = tvMsInfo2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentId7NewTwoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentId7NewTwoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_id7_new_two, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentId7NewTwoBinding bind(View rootView2) {
        int id = R.id.rel_firtMs;
        RelativeLayout relFirtMs2 = (RelativeLayout) rootView2.findViewById(R.id.rel_firtMs);
        if (relFirtMs2 != null) {
            id = R.id.rel_firtfm;
            RelativeLayout relFirtfm2 = (RelativeLayout) rootView2.findViewById(R.id.rel_firtfm);
            if (relFirtfm2 != null) {
                id = R.id.rel_firtie;
                RelativeLayout relFirtie2 = (RelativeLayout) rootView2.findViewById(R.id.rel_firtie);
                if (relFirtie2 != null) {
                    id = R.id.rel_firtset;
                    RelativeLayout relFirtset2 = (RelativeLayout) rootView2.findViewById(R.id.rel_firtset);
                    if (relFirtset2 != null) {
                        id = R.id.rel_firtvd;
                        RelativeLayout relFirtvd2 = (RelativeLayout) rootView2.findViewById(R.id.rel_firtvd);
                        if (relFirtvd2 != null) {
                            id = R.id.tv_msInfo;
                            CustomFontTextView tvMsInfo2 = (CustomFontTextView) rootView2.findViewById(R.id.tv_msInfo);
                            if (tvMsInfo2 != null) {
                                return new FragmentId7NewTwoBinding((RelativeLayout) rootView2, relFirtMs2, relFirtfm2, relFirtie2, relFirtset2, relFirtvd2, tvMsInfo2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

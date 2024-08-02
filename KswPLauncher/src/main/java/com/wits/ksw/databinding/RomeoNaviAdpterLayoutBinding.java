package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlNaviRadioButton;

public final class RomeoNaviAdpterLayoutBinding implements ViewBinding {
    public final RtlNaviRadioButton rbtNavi;
    private final RelativeLayout rootView;

    private RomeoNaviAdpterLayoutBinding(RelativeLayout rootView2, RtlNaviRadioButton rbtNavi2) {
        this.rootView = rootView2;
        this.rbtNavi = rbtNavi2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RomeoNaviAdpterLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RomeoNaviAdpterLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.romeo_navi_adpter_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static RomeoNaviAdpterLayoutBinding bind(View rootView2) {
        RtlNaviRadioButton rbtNavi2 = (RtlNaviRadioButton) rootView2.findViewById(R.id.rbt_navi);
        if (rbtNavi2 != null) {
            return new RomeoNaviAdpterLayoutBinding((RelativeLayout) rootView2, rbtNavi2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.rbt_navi)));
    }
}
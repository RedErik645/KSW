package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.view.MarqueeTextView;
import com.wits.ksw.settings.utlis_view.RtlNaviRadioButton;

public final class NaviNtg6AdpterLayoutBinding implements ViewBinding {
    public final MarqueeTextView mtvTv;
    public final RtlNaviRadioButton rbtNavi;
    private final RelativeLayout rootView;

    private NaviNtg6AdpterLayoutBinding(RelativeLayout rootView2, MarqueeTextView mtvTv2, RtlNaviRadioButton rbtNavi2) {
        this.rootView = rootView2;
        this.mtvTv = mtvTv2;
        this.rbtNavi = rbtNavi2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NaviNtg6AdpterLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static NaviNtg6AdpterLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.navi_ntg6_adpter_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static NaviNtg6AdpterLayoutBinding bind(View rootView2) {
        int id = R.id.mtv_tv;
        MarqueeTextView mtvTv2 = (MarqueeTextView) rootView2.findViewById(R.id.mtv_tv);
        if (mtvTv2 != null) {
            id = R.id.rbt_navi;
            RtlNaviRadioButton rbtNavi2 = (RtlNaviRadioButton) rootView2.findViewById(R.id.rbt_navi);
            if (rbtNavi2 != null) {
                return new NaviNtg6AdpterLayoutBinding((RelativeLayout) rootView2, mtvTv2, rbtNavi2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

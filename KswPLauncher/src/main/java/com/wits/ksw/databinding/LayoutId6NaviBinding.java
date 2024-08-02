package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class LayoutId6NaviBinding implements ViewBinding {
    public final RecyclerView naviRecycle;
    private final RelativeLayout rootView;

    private LayoutId6NaviBinding(RelativeLayout rootView2, RecyclerView naviRecycle2) {
        this.rootView = rootView2;
        this.naviRecycle = naviRecycle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutId6NaviBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutId6NaviBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_id6_navi, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutId6NaviBinding bind(View rootView2) {
        RecyclerView naviRecycle2 = (RecyclerView) rootView2.findViewById(R.id.navi_recycle);
        if (naviRecycle2 != null) {
            return new LayoutId6NaviBinding((RelativeLayout) rootView2, naviRecycle2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.navi_recycle)));
    }
}

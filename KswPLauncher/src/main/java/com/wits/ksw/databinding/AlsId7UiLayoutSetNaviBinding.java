package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wits.ksw.R;

public final class AlsId7UiLayoutSetNaviBinding implements ViewBinding {
    private final ScrollView rootView;
    public final TextView tvNaviapp;
    public final TextView tvNavihy;

    private AlsId7UiLayoutSetNaviBinding(ScrollView rootView2, TextView tvNaviapp2, TextView tvNavihy2) {
        this.rootView = rootView2;
        this.tvNaviapp = tvNaviapp2;
        this.tvNavihy = tvNavihy2;
    }

    @Override // android.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static AlsId7UiLayoutSetNaviBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AlsId7UiLayoutSetNaviBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.als_id7_ui_layout_set_navi, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AlsId7UiLayoutSetNaviBinding bind(View rootView2) {
        int id = R.id.tv_naviapp;
        TextView tvNaviapp2 = (TextView) rootView2.findViewById(R.id.tv_naviapp);
        if (tvNaviapp2 != null) {
            id = R.id.tv_navihy;
            TextView tvNavihy2 = (TextView) rootView2.findViewById(R.id.tv_navihy);
            if (tvNavihy2 != null) {
                return new AlsId7UiLayoutSetNaviBinding((ScrollView) rootView2, tvNaviapp2, tvNavihy2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

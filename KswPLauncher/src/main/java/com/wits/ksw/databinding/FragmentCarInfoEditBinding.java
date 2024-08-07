package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class FragmentCarInfoEditBinding implements ViewBinding {
    public final LinearLayout layout;
    private final RelativeLayout rootView;
    public final TextView tvDesc;

    private FragmentCarInfoEditBinding(RelativeLayout rootView2, LinearLayout layout2, TextView tvDesc2) {
        this.rootView = rootView2;
        this.layout = layout2;
        this.tvDesc = tvDesc2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCarInfoEditBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCarInfoEditBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_car_info_edit, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentCarInfoEditBinding bind(View rootView2) {
        int id = R.id.layout;
        LinearLayout layout2 = (LinearLayout) rootView2.findViewById(R.id.layout);
        if (layout2 != null) {
            id = R.id.tv_desc;
            TextView tvDesc2 = (TextView) rootView2.findViewById(R.id.tv_desc);
            if (tvDesc2 != null) {
                return new FragmentCarInfoEditBinding((RelativeLayout) rootView2, layout2, tvDesc2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

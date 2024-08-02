package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wits.ksw.R;

public final class LexusLayoutSetTimeBinding implements ViewBinding {
    private final ScrollView rootView;
    public final TextView tvTimeSync;
    public final TextView tvTimeZhis;

    private LexusLayoutSetTimeBinding(ScrollView rootView2, TextView tvTimeSync2, TextView tvTimeZhis2) {
        this.rootView = rootView2;
        this.tvTimeSync = tvTimeSync2;
        this.tvTimeZhis = tvTimeZhis2;
    }

    @Override // android.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static LexusLayoutSetTimeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LexusLayoutSetTimeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.lexus_layout_set_time, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LexusLayoutSetTimeBinding bind(View rootView2) {
        int id = R.id.tv_timeSync;
        TextView tvTimeSync2 = (TextView) rootView2.findViewById(R.id.tv_timeSync);
        if (tvTimeSync2 != null) {
            id = R.id.tv_timeZhis;
            TextView tvTimeZhis2 = (TextView) rootView2.findViewById(R.id.tv_timeZhis);
            if (tvTimeZhis2 != null) {
                return new LexusLayoutSetTimeBinding((ScrollView) rootView2, tvTimeSync2, tvTimeZhis2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

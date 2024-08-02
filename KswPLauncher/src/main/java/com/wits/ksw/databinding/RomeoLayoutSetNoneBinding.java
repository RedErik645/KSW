package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wits.ksw.R;

public final class RomeoLayoutSetNoneBinding implements ViewBinding {
    public final LinearLayout romeoSettosysLl;
    private final ScrollView rootView;
    public final TextView tvOneDefaul;

    private RomeoLayoutSetNoneBinding(ScrollView rootView2, LinearLayout romeoSettosysLl2, TextView tvOneDefaul2) {
        this.rootView = rootView2;
        this.romeoSettosysLl = romeoSettosysLl2;
        this.tvOneDefaul = tvOneDefaul2;
    }

    @Override // android.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static RomeoLayoutSetNoneBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RomeoLayoutSetNoneBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.romeo_layout_set_none, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static RomeoLayoutSetNoneBinding bind(View rootView2) {
        int id = R.id.romeo_settosys_ll;
        LinearLayout romeoSettosysLl2 = (LinearLayout) rootView2.findViewById(R.id.romeo_settosys_ll);
        if (romeoSettosysLl2 != null) {
            id = R.id.tv_oneDefaul;
            TextView tvOneDefaul2 = (TextView) rootView2.findViewById(R.id.tv_oneDefaul);
            if (tvOneDefaul2 != null) {
                return new RomeoLayoutSetNoneBinding((ScrollView) rootView2, romeoSettosysLl2, tvOneDefaul2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

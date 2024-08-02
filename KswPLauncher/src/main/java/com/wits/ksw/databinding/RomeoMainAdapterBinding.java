package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class RomeoMainAdapterBinding implements ViewBinding {
    public final LinearLayout relatFunctionItem;
    public final ImageView romeoMainIv;
    public final TextView romeoMainTv;
    private final LinearLayout rootView;

    private RomeoMainAdapterBinding(LinearLayout rootView2, LinearLayout relatFunctionItem2, ImageView romeoMainIv2, TextView romeoMainTv2) {
        this.rootView = rootView2;
        this.relatFunctionItem = relatFunctionItem2;
        this.romeoMainIv = romeoMainIv2;
        this.romeoMainTv = romeoMainTv2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RomeoMainAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RomeoMainAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.romeo_main_adapter, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static RomeoMainAdapterBinding bind(View rootView2) {
        LinearLayout relatFunctionItem2 = (LinearLayout) rootView2;
        int id = R.id.romeo_main_iv;
        ImageView romeoMainIv2 = (ImageView) rootView2.findViewById(R.id.romeo_main_iv);
        if (romeoMainIv2 != null) {
            id = R.id.romeo_main_tv;
            TextView romeoMainTv2 = (TextView) rootView2.findViewById(R.id.romeo_main_tv);
            if (romeoMainTv2 != null) {
                return new RomeoMainAdapterBinding((LinearLayout) rootView2, relatFunctionItem2, romeoMainIv2, romeoMainTv2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

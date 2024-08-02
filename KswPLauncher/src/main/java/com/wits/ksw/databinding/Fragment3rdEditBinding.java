package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class Fragment3rdEditBinding implements ViewBinding {
    public final ImageView iv;
    public final LinearLayout llContainer;
    public final ImageView remove;
    private final RelativeLayout rootView;
    public final TextView tvName;

    private Fragment3rdEditBinding(RelativeLayout rootView2, ImageView iv2, LinearLayout llContainer2, ImageView remove2, TextView tvName2) {
        this.rootView = rootView2;
        this.iv = iv2;
        this.llContainer = llContainer2;
        this.remove = remove2;
        this.tvName = tvName2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Fragment3rdEditBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static Fragment3rdEditBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_3rd_edit, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static Fragment3rdEditBinding bind(View rootView2) {
        int id = R.id.iv;
        ImageView iv2 = (ImageView) rootView2.findViewById(R.id.iv);
        if (iv2 != null) {
            id = R.id.ll_container;
            LinearLayout llContainer2 = (LinearLayout) rootView2.findViewById(R.id.ll_container);
            if (llContainer2 != null) {
                id = R.id.remove;
                ImageView remove2 = (ImageView) rootView2.findViewById(R.id.remove);
                if (remove2 != null) {
                    id = R.id.tv_name;
                    TextView tvName2 = (TextView) rootView2.findViewById(R.id.tv_name);
                    if (tvName2 != null) {
                        return new Fragment3rdEditBinding((RelativeLayout) rootView2, iv2, llContainer2, remove2, tvName2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

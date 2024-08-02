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

public final class FragmentGs3rdEditBinding implements ViewBinding {
    public final ImageView gsId8IconEditBg;
    public final ImageView iv;
    public final LinearLayout llContainer;
    public final ImageView remove;
    private final RelativeLayout rootView;
    public final TextView tvName;

    private FragmentGs3rdEditBinding(RelativeLayout rootView2, ImageView gsId8IconEditBg2, ImageView iv2, LinearLayout llContainer2, ImageView remove2, TextView tvName2) {
        this.rootView = rootView2;
        this.gsId8IconEditBg = gsId8IconEditBg2;
        this.iv = iv2;
        this.llContainer = llContainer2;
        this.remove = remove2;
        this.tvName = tvName2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentGs3rdEditBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentGs3rdEditBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_gs_3rd_edit, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentGs3rdEditBinding bind(View rootView2) {
        int id = R.id.gs_id8_icon_edit_bg;
        ImageView gsId8IconEditBg2 = (ImageView) rootView2.findViewById(R.id.gs_id8_icon_edit_bg);
        if (gsId8IconEditBg2 != null) {
            id = R.id.iv;
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
                            return new FragmentGs3rdEditBinding((RelativeLayout) rootView2, gsId8IconEditBg2, iv2, llContainer2, remove2, tvName2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

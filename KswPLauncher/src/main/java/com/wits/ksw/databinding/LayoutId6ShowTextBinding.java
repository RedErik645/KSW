package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class LayoutId6ShowTextBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView tvId6ShowMsg;
    public final TextView tvId6ShowTitle;

    private LayoutId6ShowTextBinding(RelativeLayout rootView2, TextView tvId6ShowMsg2, TextView tvId6ShowTitle2) {
        this.rootView = rootView2;
        this.tvId6ShowMsg = tvId6ShowMsg2;
        this.tvId6ShowTitle = tvId6ShowTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutId6ShowTextBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutId6ShowTextBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.layout_id6_show_text, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LayoutId6ShowTextBinding bind(View rootView2) {
        int id = R.id.tv_id6ShowMsg;
        TextView tvId6ShowMsg2 = (TextView) rootView2.findViewById(R.id.tv_id6ShowMsg);
        if (tvId6ShowMsg2 != null) {
            id = R.id.tv_id6ShowTitle;
            TextView tvId6ShowTitle2 = (TextView) rootView2.findViewById(R.id.tv_id6ShowTitle);
            if (tvId6ShowTitle2 != null) {
                return new LayoutId6ShowTextBinding((RelativeLayout) rootView2, tvId6ShowMsg2, tvId6ShowTitle2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class DialogUpdateProBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView upTextMsg;

    private DialogUpdateProBinding(LinearLayout rootView2, TextView upTextMsg2) {
        this.rootView = rootView2;
        this.upTextMsg = upTextMsg2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogUpdateProBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogUpdateProBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_update_pro, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static DialogUpdateProBinding bind(View rootView2) {
        TextView upTextMsg2 = (TextView) rootView2.findViewById(R.id.upText_msg);
        if (upTextMsg2 != null) {
            return new DialogUpdateProBinding((LinearLayout) rootView2, upTextMsg2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(R.id.upText_msg)));
    }
}

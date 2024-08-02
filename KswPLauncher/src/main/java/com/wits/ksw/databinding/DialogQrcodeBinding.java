package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class DialogQrcodeBinding implements ViewBinding {
    public final RelativeLayout qrRoot;
    private final RelativeLayout rootView;

    private DialogQrcodeBinding(RelativeLayout rootView2, RelativeLayout qrRoot2) {
        this.rootView = rootView2;
        this.qrRoot = qrRoot2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogQrcodeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogQrcodeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_qrcode, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static DialogQrcodeBinding bind(View rootView2) {
        if (rootView2 != null) {
            return new DialogQrcodeBinding((RelativeLayout) rootView2, (RelativeLayout) rootView2);
        }
        throw new NullPointerException("rootView");
    }
}

package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.wits.ksw.R;

public final class DialogMcuUpinfoBinding implements ViewBinding {
    public final ProgressBar mcuProgBar;
    public final TextView mcuTvPro;
    private final LinearLayout rootView;
    public final TextView tvProssToast;

    private DialogMcuUpinfoBinding(LinearLayout rootView2, ProgressBar mcuProgBar2, TextView mcuTvPro2, TextView tvProssToast2) {
        this.rootView = rootView2;
        this.mcuProgBar = mcuProgBar2;
        this.mcuTvPro = mcuTvPro2;
        this.tvProssToast = tvProssToast2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogMcuUpinfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogMcuUpinfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_mcu_upinfo, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static DialogMcuUpinfoBinding bind(View rootView2) {
        int id = R.id.mcuProgBar;
        ProgressBar mcuProgBar2 = (ProgressBar) rootView2.findViewById(R.id.mcuProgBar);
        if (mcuProgBar2 != null) {
            id = R.id.mcuTvPro;
            TextView mcuTvPro2 = (TextView) rootView2.findViewById(R.id.mcuTvPro);
            if (mcuTvPro2 != null) {
                id = R.id.tv_prossToast;
                TextView tvProssToast2 = (TextView) rootView2.findViewById(R.id.tv_prossToast);
                if (tvProssToast2 != null) {
                    return new DialogMcuUpinfoBinding((LinearLayout) rootView2, mcuProgBar2, mcuTvPro2, tvProssToast2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

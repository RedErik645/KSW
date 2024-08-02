package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.settings.utlis_view.RtlTextView;

public final class AlsId7UiFactoryInputBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final RtlTextView tvFacVer;
    public final TextView tvFacinput;
    public final Button tvRestart;

    private AlsId7UiFactoryInputBinding(LinearLayout rootView2, RtlTextView tvFacVer2, TextView tvFacinput2, Button tvRestart2) {
        this.rootView = rootView2;
        this.tvFacVer = tvFacVer2;
        this.tvFacinput = tvFacinput2;
        this.tvRestart = tvRestart2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AlsId7UiFactoryInputBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AlsId7UiFactoryInputBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.als_id7_ui_factory_input, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AlsId7UiFactoryInputBinding bind(View rootView2) {
        int id = R.id.tv_facVer;
        RtlTextView tvFacVer2 = (RtlTextView) rootView2.findViewById(R.id.tv_facVer);
        if (tvFacVer2 != null) {
            id = R.id.tv_Facinput;
            TextView tvFacinput2 = (TextView) rootView2.findViewById(R.id.tv_Facinput);
            if (tvFacinput2 != null) {
                id = R.id.tv_restart;
                Button tvRestart2 = (Button) rootView2.findViewById(R.id.tv_restart);
                if (tvRestart2 != null) {
                    return new AlsId7UiFactoryInputBinding((LinearLayout) rootView2, tvFacVer2, tvFacinput2, tvRestart2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

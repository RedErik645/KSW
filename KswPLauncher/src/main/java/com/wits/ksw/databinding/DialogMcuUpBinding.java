package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class DialogMcuUpBinding implements ViewBinding {
    public final TextView dlgCancel;
    public final TextView dlgMsg;
    public final TextView dlgOk;
    private final LinearLayout rootView;

    private DialogMcuUpBinding(LinearLayout rootView2, TextView dlgCancel2, TextView dlgMsg2, TextView dlgOk2) {
        this.rootView = rootView2;
        this.dlgCancel = dlgCancel2;
        this.dlgMsg = dlgMsg2;
        this.dlgOk = dlgOk2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogMcuUpBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogMcuUpBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_mcu_up, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static DialogMcuUpBinding bind(View rootView2) {
        int id = R.id.dlg_cancel;
        TextView dlgCancel2 = (TextView) rootView2.findViewById(R.id.dlg_cancel);
        if (dlgCancel2 != null) {
            id = R.id.dlg_msg;
            TextView dlgMsg2 = (TextView) rootView2.findViewById(R.id.dlg_msg);
            if (dlgMsg2 != null) {
                id = R.id.dlg_ok;
                TextView dlgOk2 = (TextView) rootView2.findViewById(R.id.dlg_ok);
                if (dlgOk2 != null) {
                    return new DialogMcuUpBinding((LinearLayout) rootView2, dlgCancel2, dlgMsg2, dlgOk2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

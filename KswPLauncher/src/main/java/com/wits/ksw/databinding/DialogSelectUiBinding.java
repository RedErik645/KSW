package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class DialogSelectUiBinding implements ViewBinding {
    public final TextView dlgCancel;
    public final TextView dlgOk;
    private final LinearLayout rootView;
    public final TextView upTextMsg;

    private DialogSelectUiBinding(LinearLayout rootView2, TextView dlgCancel2, TextView dlgOk2, TextView upTextMsg2) {
        this.rootView = rootView2;
        this.dlgCancel = dlgCancel2;
        this.dlgOk = dlgOk2;
        this.upTextMsg = upTextMsg2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogSelectUiBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogSelectUiBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_select_ui, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static DialogSelectUiBinding bind(View rootView2) {
        int id = R.id.dlg_cancel;
        TextView dlgCancel2 = (TextView) rootView2.findViewById(R.id.dlg_cancel);
        if (dlgCancel2 != null) {
            id = R.id.dlg_ok;
            TextView dlgOk2 = (TextView) rootView2.findViewById(R.id.dlg_ok);
            if (dlgOk2 != null) {
                id = R.id.upText_msg;
                TextView upTextMsg2 = (TextView) rootView2.findViewById(R.id.upText_msg);
                if (upTextMsg2 != null) {
                    return new DialogSelectUiBinding((LinearLayout) rootView2, dlgCancel2, dlgOk2, upTextMsg2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

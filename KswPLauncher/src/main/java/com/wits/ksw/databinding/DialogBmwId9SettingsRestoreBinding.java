package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class DialogBmwId9SettingsRestoreBinding implements ViewBinding {
    public final TextView dlgCancel;
    public final TextView dlgMsg;
    public final TextView dlgOk;
    public final TextView dlgTitle;
    private final LinearLayout rootView;

    private DialogBmwId9SettingsRestoreBinding(LinearLayout rootView2, TextView dlgCancel2, TextView dlgMsg2, TextView dlgOk2, TextView dlgTitle2) {
        this.rootView = rootView2;
        this.dlgCancel = dlgCancel2;
        this.dlgMsg = dlgMsg2;
        this.dlgOk = dlgOk2;
        this.dlgTitle = dlgTitle2;
    }

    @Override // android.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogBmwId9SettingsRestoreBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogBmwId9SettingsRestoreBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_bmw_id9_settings_restore, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static DialogBmwId9SettingsRestoreBinding bind(View rootView2) {
        int id = R.id.dlg_cancel;
        TextView dlgCancel2 = (TextView) rootView2.findViewById(R.id.dlg_cancel);
        if (dlgCancel2 != null) {
            id = R.id.dlg_msg;
            TextView dlgMsg2 = (TextView) rootView2.findViewById(R.id.dlg_msg);
            if (dlgMsg2 != null) {
                id = R.id.dlg_ok;
                TextView dlgOk2 = (TextView) rootView2.findViewById(R.id.dlg_ok);
                if (dlgOk2 != null) {
                    id = R.id.dlg_title;
                    TextView dlgTitle2 = (TextView) rootView2.findViewById(R.id.dlg_title);
                    if (dlgTitle2 != null) {
                        return new DialogBmwId9SettingsRestoreBinding((LinearLayout) rootView2, dlgCancel2, dlgMsg2, dlgOk2, dlgTitle2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

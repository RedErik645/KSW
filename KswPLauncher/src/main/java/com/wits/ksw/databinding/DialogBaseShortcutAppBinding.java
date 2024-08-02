package com.wits.ksw.databinding;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class DialogBaseShortcutAppBinding implements ViewBinding {
    public final LinearLayout dialogBaseShortcutLl;
    public final RecyclerView dialogRecyclerView;
    private final CardView rootView;
    public final TextView title;

    private DialogBaseShortcutAppBinding(CardView rootView2, LinearLayout dialogBaseShortcutLl2, RecyclerView dialogRecyclerView2, TextView title2) {
        this.rootView = rootView2;
        this.dialogBaseShortcutLl = dialogBaseShortcutLl2;
        this.dialogRecyclerView = dialogRecyclerView2;
        this.title = title2;
    }

    @Override // android.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static DialogBaseShortcutAppBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogBaseShortcutAppBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_base_shortcut_app, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static DialogBaseShortcutAppBinding bind(View rootView2) {
        int id = R.id.dialog_base_shortcut_ll;
        LinearLayout dialogBaseShortcutLl2 = (LinearLayout) rootView2.findViewById(R.id.dialog_base_shortcut_ll);
        if (dialogBaseShortcutLl2 != null) {
            id = R.id.dialog_recyclerView;
            RecyclerView dialogRecyclerView2 = (RecyclerView) rootView2.findViewById(R.id.dialog_recyclerView);
            if (dialogRecyclerView2 != null) {
                id = R.id.title;
                TextView title2 = (TextView) rootView2.findViewById(R.id.title);
                if (title2 != null) {
                    return new DialogBaseShortcutAppBinding((CardView) rootView2, dialogBaseShortcutLl2, dialogRecyclerView2, title2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

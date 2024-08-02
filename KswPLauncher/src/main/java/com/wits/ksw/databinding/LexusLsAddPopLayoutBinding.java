package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class LexusLsAddPopLayoutBinding implements ViewBinding {
    public final RecyclerView lexusLsAddAppRecycleview;
    public final TextView lexusLsAddappIvCancel;
    public final TextView lexusLsAddappIvOk;
    private final RelativeLayout rootView;

    private LexusLsAddPopLayoutBinding(RelativeLayout rootView2, RecyclerView lexusLsAddAppRecycleview2, TextView lexusLsAddappIvCancel2, TextView lexusLsAddappIvOk2) {
        this.rootView = rootView2;
        this.lexusLsAddAppRecycleview = lexusLsAddAppRecycleview2;
        this.lexusLsAddappIvCancel = lexusLsAddappIvCancel2;
        this.lexusLsAddappIvOk = lexusLsAddappIvOk2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LexusLsAddPopLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LexusLsAddPopLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.lexus_ls_add_pop_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static LexusLsAddPopLayoutBinding bind(View rootView2) {
        int id = R.id.lexus_ls_add_app_recycleview;
        RecyclerView lexusLsAddAppRecycleview2 = (RecyclerView) rootView2.findViewById(R.id.lexus_ls_add_app_recycleview);
        if (lexusLsAddAppRecycleview2 != null) {
            id = R.id.lexus_ls_addapp_iv_cancel;
            TextView lexusLsAddappIvCancel2 = (TextView) rootView2.findViewById(R.id.lexus_ls_addapp_iv_cancel);
            if (lexusLsAddappIvCancel2 != null) {
                id = R.id.lexus_ls_addapp_iv_ok;
                TextView lexusLsAddappIvOk2 = (TextView) rootView2.findViewById(R.id.lexus_ls_addapp_iv_ok);
                if (lexusLsAddappIvOk2 != null) {
                    return new LexusLsAddPopLayoutBinding((RelativeLayout) rootView2, lexusLsAddAppRecycleview2, lexusLsAddappIvCancel2, lexusLsAddappIvOk2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

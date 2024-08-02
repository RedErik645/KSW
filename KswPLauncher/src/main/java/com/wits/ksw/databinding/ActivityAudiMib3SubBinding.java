package com.wits.ksw.databinding;

import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class ActivityAudiMib3SubBinding implements ViewBinding {
    public final RelativeLayout audiSubContentLinearLayout;
    public final ConstraintLayout linearLayout4;
    private final ConstraintLayout rootView;
    public final TextView tvTitleSet;

    private ActivityAudiMib3SubBinding(ConstraintLayout rootView2, RelativeLayout audiSubContentLinearLayout2, ConstraintLayout linearLayout42, TextView tvTitleSet2) {
        this.rootView = rootView2;
        this.audiSubContentLinearLayout = audiSubContentLinearLayout2;
        this.linearLayout4 = linearLayout42;
        this.tvTitleSet = tvTitleSet2;
    }

    @Override // android.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAudiMib3SubBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityAudiMib3SubBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_audi_mib3_sub, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityAudiMib3SubBinding bind(View rootView2) {
        int id = R.id.audiSubContentLinearLayout;
        RelativeLayout audiSubContentLinearLayout2 = (RelativeLayout) rootView2.findViewById(R.id.audiSubContentLinearLayout);
        if (audiSubContentLinearLayout2 != null) {
            ConstraintLayout linearLayout42 = (ConstraintLayout) rootView2;
            id = R.id.tv_title_set;
            TextView tvTitleSet2 = (TextView) rootView2.findViewById(R.id.tv_title_set);
            if (tvTitleSet2 != null) {
                return new ActivityAudiMib3SubBinding((ConstraintLayout) rootView2, audiSubContentLinearLayout2, linearLayout42, tvTitleSet2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

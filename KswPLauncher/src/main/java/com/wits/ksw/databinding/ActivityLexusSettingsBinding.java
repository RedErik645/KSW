package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class ActivityLexusSettingsBinding implements ViewBinding {
    public final FrameLayout frameOneLayout;
    public final FrameLayout frameTwoLayout;
    public final TextView lexusSetTitle;
    public final RecyclerView recyclerView;
    private final RelativeLayout rootView;

    private ActivityLexusSettingsBinding(RelativeLayout rootView2, FrameLayout frameOneLayout2, FrameLayout frameTwoLayout2, TextView lexusSetTitle2, RecyclerView recyclerView2) {
        this.rootView = rootView2;
        this.frameOneLayout = frameOneLayout2;
        this.frameTwoLayout = frameTwoLayout2;
        this.lexusSetTitle = lexusSetTitle2;
        this.recyclerView = recyclerView2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLexusSettingsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityLexusSettingsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_lexus_settings, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityLexusSettingsBinding bind(View rootView2) {
        int id = R.id.frame_OneLayout;
        FrameLayout frameOneLayout2 = (FrameLayout) rootView2.findViewById(R.id.frame_OneLayout);
        if (frameOneLayout2 != null) {
            id = R.id.frame_TwoLayout;
            FrameLayout frameTwoLayout2 = (FrameLayout) rootView2.findViewById(R.id.frame_TwoLayout);
            if (frameTwoLayout2 != null) {
                id = R.id.lexus_set_title;
                TextView lexusSetTitle2 = (TextView) rootView2.findViewById(R.id.lexus_set_title);
                if (lexusSetTitle2 != null) {
                    id = R.id.recyclerView;
                    RecyclerView recyclerView2 = (RecyclerView) rootView2.findViewById(R.id.recyclerView);
                    if (recyclerView2 != null) {
                        return new ActivityLexusSettingsBinding((RelativeLayout) rootView2, frameOneLayout2, frameTwoLayout2, lexusSetTitle2, recyclerView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

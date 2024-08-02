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

public final class ActivitySysFactoryBinding implements ViewBinding {
    public final FrameLayout factoryFrame;
    public final RecyclerView factoryRecycle;
    private final RelativeLayout rootView;
    public final TextView title;

    private ActivitySysFactoryBinding(RelativeLayout rootView2, FrameLayout factoryFrame2, RecyclerView factoryRecycle2, TextView title2) {
        this.rootView = rootView2;
        this.factoryFrame = factoryFrame2;
        this.factoryRecycle = factoryRecycle2;
        this.title = title2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySysFactoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySysFactoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_sys_factory, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivitySysFactoryBinding bind(View rootView2) {
        int id = R.id.factory_Frame;
        FrameLayout factoryFrame2 = (FrameLayout) rootView2.findViewById(R.id.factory_Frame);
        if (factoryFrame2 != null) {
            id = R.id.factory_recycle;
            RecyclerView factoryRecycle2 = (RecyclerView) rootView2.findViewById(R.id.factory_recycle);
            if (factoryRecycle2 != null) {
                id = R.id.title;
                TextView title2 = (TextView) rootView2.findViewById(R.id.title);
                if (title2 != null) {
                    return new ActivitySysFactoryBinding((RelativeLayout) rootView2, factoryFrame2, factoryRecycle2, title2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

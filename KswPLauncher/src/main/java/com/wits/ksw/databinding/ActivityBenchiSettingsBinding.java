package com.wits.ksw.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class ActivityBenchiSettingsBinding implements ViewBinding {
    public final ImageView imgFuntionImg;
    public final RecyclerView recyclerView;
    public final RelativeLayout relatFactory;
    public final RelativeLayout relatNtgOneList;
    public final RelativeLayout relatNtgThreeList;
    public final RelativeLayout relatNtgTwoList;
    private final RelativeLayout rootView;
    public final TextView tvSystemInfo;
    public final TextView tvSystemInfo2;
    public final TextView tvSystemTime;

    private ActivityBenchiSettingsBinding(RelativeLayout rootView2, ImageView imgFuntionImg2, RecyclerView recyclerView2, RelativeLayout relatFactory2, RelativeLayout relatNtgOneList2, RelativeLayout relatNtgThreeList2, RelativeLayout relatNtgTwoList2, TextView tvSystemInfo3, TextView tvSystemInfo22, TextView tvSystemTime2) {
        this.rootView = rootView2;
        this.imgFuntionImg = imgFuntionImg2;
        this.recyclerView = recyclerView2;
        this.relatFactory = relatFactory2;
        this.relatNtgOneList = relatNtgOneList2;
        this.relatNtgThreeList = relatNtgThreeList2;
        this.relatNtgTwoList = relatNtgTwoList2;
        this.tvSystemInfo = tvSystemInfo3;
        this.tvSystemInfo2 = tvSystemInfo22;
        this.tvSystemTime = tvSystemTime2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBenchiSettingsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityBenchiSettingsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_benchi_settings, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityBenchiSettingsBinding bind(View rootView2) {
        int id = R.id.img_funtionImg;
        ImageView imgFuntionImg2 = (ImageView) rootView2.findViewById(R.id.img_funtionImg);
        if (imgFuntionImg2 != null) {
            id = R.id.recyclerView;
            RecyclerView recyclerView2 = (RecyclerView) rootView2.findViewById(R.id.recyclerView);
            if (recyclerView2 != null) {
                id = R.id.relat_Factory;
                RelativeLayout relatFactory2 = (RelativeLayout) rootView2.findViewById(R.id.relat_Factory);
                if (relatFactory2 != null) {
                    id = R.id.relat_ntgOneList;
                    RelativeLayout relatNtgOneList2 = (RelativeLayout) rootView2.findViewById(R.id.relat_ntgOneList);
                    if (relatNtgOneList2 != null) {
                        id = R.id.relat_ntgThreeList;
                        RelativeLayout relatNtgThreeList2 = (RelativeLayout) rootView2.findViewById(R.id.relat_ntgThreeList);
                        if (relatNtgThreeList2 != null) {
                            id = R.id.relat_ntgTwoList;
                            RelativeLayout relatNtgTwoList2 = (RelativeLayout) rootView2.findViewById(R.id.relat_ntgTwoList);
                            if (relatNtgTwoList2 != null) {
                                id = R.id.tv_systemInfo;
                                TextView tvSystemInfo3 = (TextView) rootView2.findViewById(R.id.tv_systemInfo);
                                if (tvSystemInfo3 != null) {
                                    id = R.id.tv_systemInfo2;
                                    TextView tvSystemInfo22 = (TextView) rootView2.findViewById(R.id.tv_systemInfo2);
                                    if (tvSystemInfo22 != null) {
                                        id = R.id.tv_systemTime;
                                        TextView tvSystemTime2 = (TextView) rootView2.findViewById(R.id.tv_systemTime);
                                        if (tvSystemTime2 != null) {
                                            return new ActivityBenchiSettingsBinding((RelativeLayout) rootView2, imgFuntionImg2, recyclerView2, relatFactory2, relatNtgOneList2, relatNtgThreeList2, relatNtgTwoList2, tvSystemInfo3, tvSystemInfo22, tvSystemTime2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView2.getResources().getResourceName(id)));
    }
}

package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;

public final class ActivityId8GsLauncherEditBinding implements ViewBinding {
    public final FrameLayout flContent1;
    public final FrameLayout flContent10;
    public final FrameLayout flContent11;
    public final FrameLayout flContent12;
    public final FrameLayout flContent13;
    public final FrameLayout flContent14;
    public final FrameLayout flContent2;
    public final FrameLayout flContent3;
    public final FrameLayout flContent4;
    public final FrameLayout flContent5;
    public final FrameLayout flContent6;
    public final FrameLayout flContent7;
    public final FrameLayout flContent8;
    public final FrameLayout flContent9;
    public final LinearLayout llContaine;
    private final RelativeLayout rootView;
    public final HorizontalScrollView scrollView;

    private ActivityId8GsLauncherEditBinding(RelativeLayout rootView2, FrameLayout flContent15, FrameLayout flContent102, FrameLayout flContent112, FrameLayout flContent122, FrameLayout flContent132, FrameLayout flContent142, FrameLayout flContent22, FrameLayout flContent32, FrameLayout flContent42, FrameLayout flContent52, FrameLayout flContent62, FrameLayout flContent72, FrameLayout flContent82, FrameLayout flContent92, LinearLayout llContaine2, HorizontalScrollView scrollView2) {
        this.rootView = rootView2;
        this.flContent1 = flContent15;
        this.flContent10 = flContent102;
        this.flContent11 = flContent112;
        this.flContent12 = flContent122;
        this.flContent13 = flContent132;
        this.flContent14 = flContent142;
        this.flContent2 = flContent22;
        this.flContent3 = flContent32;
        this.flContent4 = flContent42;
        this.flContent5 = flContent52;
        this.flContent6 = flContent62;
        this.flContent7 = flContent72;
        this.flContent8 = flContent82;
        this.flContent9 = flContent92;
        this.llContaine = llContaine2;
        this.scrollView = scrollView2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityId8GsLauncherEditBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityId8GsLauncherEditBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_id8_gs_launcher_edit, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityId8GsLauncherEditBinding bind(View rootView2) {
        int id = R.id.fl_content1;
        FrameLayout flContent15 = (FrameLayout) rootView2.findViewById(R.id.fl_content1);
        if (flContent15 != null) {
            id = R.id.fl_content10;
            FrameLayout flContent102 = (FrameLayout) rootView2.findViewById(R.id.fl_content10);
            if (flContent102 != null) {
                id = R.id.fl_content11;
                FrameLayout flContent112 = (FrameLayout) rootView2.findViewById(R.id.fl_content11);
                if (flContent112 != null) {
                    id = R.id.fl_content12;
                    FrameLayout flContent122 = (FrameLayout) rootView2.findViewById(R.id.fl_content12);
                    if (flContent122 != null) {
                        id = R.id.fl_content13;
                        FrameLayout flContent132 = (FrameLayout) rootView2.findViewById(R.id.fl_content13);
                        if (flContent132 != null) {
                            id = R.id.fl_content14;
                            FrameLayout flContent142 = (FrameLayout) rootView2.findViewById(R.id.fl_content14);
                            if (flContent142 != null) {
                                id = R.id.fl_content2;
                                FrameLayout flContent22 = (FrameLayout) rootView2.findViewById(R.id.fl_content2);
                                if (flContent22 != null) {
                                    id = R.id.fl_content3;
                                    FrameLayout flContent32 = (FrameLayout) rootView2.findViewById(R.id.fl_content3);
                                    if (flContent32 != null) {
                                        id = R.id.fl_content4;
                                        FrameLayout flContent42 = (FrameLayout) rootView2.findViewById(R.id.fl_content4);
                                        if (flContent42 != null) {
                                            id = R.id.fl_content5;
                                            FrameLayout flContent52 = (FrameLayout) rootView2.findViewById(R.id.fl_content5);
                                            if (flContent52 != null) {
                                                id = R.id.fl_content6;
                                                FrameLayout flContent62 = (FrameLayout) rootView2.findViewById(R.id.fl_content6);
                                                if (flContent62 != null) {
                                                    id = R.id.fl_content7;
                                                    FrameLayout flContent72 = (FrameLayout) rootView2.findViewById(R.id.fl_content7);
                                                    if (flContent72 != null) {
                                                        id = R.id.fl_content8;
                                                        FrameLayout flContent82 = (FrameLayout) rootView2.findViewById(R.id.fl_content8);
                                                        if (flContent82 != null) {
                                                            id = R.id.fl_content9;
                                                            FrameLayout flContent92 = (FrameLayout) rootView2.findViewById(R.id.fl_content9);
                                                            if (flContent92 != null) {
                                                                id = R.id.ll_containe;
                                                                LinearLayout llContaine2 = (LinearLayout) rootView2.findViewById(R.id.ll_containe);
                                                                if (llContaine2 != null) {
                                                                    id = R.id.scrollView;
                                                                    HorizontalScrollView scrollView2 = (HorizontalScrollView) rootView2.findViewById(R.id.scrollView);
                                                                    if (scrollView2 != null) {
                                                                        return new ActivityId8GsLauncherEditBinding((RelativeLayout) rootView2, flContent15, flContent102, flContent112, flContent122, flContent132, flContent142, flContent22, flContent32, flContent42, flContent52, flContent62, flContent72, flContent82, flContent92, llContaine2, scrollView2);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

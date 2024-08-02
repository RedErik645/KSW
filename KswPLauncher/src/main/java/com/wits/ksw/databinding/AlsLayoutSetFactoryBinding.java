package com.wits.ksw.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;

public final class AlsLayoutSetFactoryBinding implements ViewBinding {
    public final ImageView imgBtn0;
    public final ImageView imgBtn1;
    public final ImageView imgBtn2;
    public final ImageView imgBtn3;
    public final ImageView imgBtn4;
    public final ImageView imgBtn5;
    public final ImageView imgBtn6;
    public final ImageView imgBtn7;
    public final ImageView imgBtn8;
    public final ImageView imgBtn9;
    public final ImageView imgDel;
    public final ImageView imgEnter;
    private final RelativeLayout rootView;
    public final TextView tvShowPwd;

    private AlsLayoutSetFactoryBinding(RelativeLayout rootView2, ImageView imgBtn02, ImageView imgBtn12, ImageView imgBtn22, ImageView imgBtn32, ImageView imgBtn42, ImageView imgBtn52, ImageView imgBtn62, ImageView imgBtn72, ImageView imgBtn82, ImageView imgBtn92, ImageView imgDel2, ImageView imgEnter2, TextView tvShowPwd2) {
        this.rootView = rootView2;
        this.imgBtn0 = imgBtn02;
        this.imgBtn1 = imgBtn12;
        this.imgBtn2 = imgBtn22;
        this.imgBtn3 = imgBtn32;
        this.imgBtn4 = imgBtn42;
        this.imgBtn5 = imgBtn52;
        this.imgBtn6 = imgBtn62;
        this.imgBtn7 = imgBtn72;
        this.imgBtn8 = imgBtn82;
        this.imgBtn9 = imgBtn92;
        this.imgDel = imgDel2;
        this.imgEnter = imgEnter2;
        this.tvShowPwd = tvShowPwd2;
    }

    @Override // android.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AlsLayoutSetFactoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AlsLayoutSetFactoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.als_layout_set_factory, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static AlsLayoutSetFactoryBinding bind(View rootView2) {
        int id = R.id.img_btn0;
        ImageView imgBtn02 = (ImageView) rootView2.findViewById(R.id.img_btn0);
        if (imgBtn02 != null) {
            id = R.id.img_btn1;
            ImageView imgBtn12 = (ImageView) rootView2.findViewById(R.id.img_btn1);
            if (imgBtn12 != null) {
                id = R.id.img_btn2;
                ImageView imgBtn22 = (ImageView) rootView2.findViewById(R.id.img_btn2);
                if (imgBtn22 != null) {
                    id = R.id.img_btn3;
                    ImageView imgBtn32 = (ImageView) rootView2.findViewById(R.id.img_btn3);
                    if (imgBtn32 != null) {
                        id = R.id.img_btn4;
                        ImageView imgBtn42 = (ImageView) rootView2.findViewById(R.id.img_btn4);
                        if (imgBtn42 != null) {
                            id = R.id.img_btn5;
                            ImageView imgBtn52 = (ImageView) rootView2.findViewById(R.id.img_btn5);
                            if (imgBtn52 != null) {
                                id = R.id.img_btn6;
                                ImageView imgBtn62 = (ImageView) rootView2.findViewById(R.id.img_btn6);
                                if (imgBtn62 != null) {
                                    id = R.id.img_btn7;
                                    ImageView imgBtn72 = (ImageView) rootView2.findViewById(R.id.img_btn7);
                                    if (imgBtn72 != null) {
                                        id = R.id.img_btn8;
                                        ImageView imgBtn82 = (ImageView) rootView2.findViewById(R.id.img_btn8);
                                        if (imgBtn82 != null) {
                                            id = R.id.img_btn9;
                                            ImageView imgBtn92 = (ImageView) rootView2.findViewById(R.id.img_btn9);
                                            if (imgBtn92 != null) {
                                                id = R.id.img_del;
                                                ImageView imgDel2 = (ImageView) rootView2.findViewById(R.id.img_del);
                                                if (imgDel2 != null) {
                                                    id = R.id.img_enter;
                                                    ImageView imgEnter2 = (ImageView) rootView2.findViewById(R.id.img_enter);
                                                    if (imgEnter2 != null) {
                                                        id = R.id.tv_showPwd;
                                                        TextView tvShowPwd2 = (TextView) rootView2.findViewById(R.id.tv_showPwd);
                                                        if (tvShowPwd2 != null) {
                                                            return new AlsLayoutSetFactoryBinding((RelativeLayout) rootView2, imgBtn02, imgBtn12, imgBtn22, imgBtn32, imgBtn42, imgBtn52, imgBtn62, imgBtn72, imgBtn82, imgBtn92, imgDel2, imgEnter2, tvShowPwd2);
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

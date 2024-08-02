package com.wits.ksw.launcher.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

public class CustomBcItemBgImageView extends ImageView {
    private static final String TAG = CustomBcItemBgImageView.class.getName();

    public CustomBcItemBgImageView(Context context) {
        this(context, null);
    }

    public CustomBcItemBgImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDefaultFocusHighlightEnabled(false);
    }

    public void translationX(int x) {
        try {
            ObjectAnimator.ofFloat(this, "translationX", (float) x).setDuration(200L).start();
            Log.i(TAG, "<<<<<<<<<<<<<<< translationX: x=" + x);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

public class SlideInBottomAnimation implements BaseAnimation {
    @Override // com.chad.library.adapter.base.animation.BaseAnimation
    public Animator[] getAnimators(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "translationY", (float) view.getMeasuredHeight(), 0.0f)};
    }
}

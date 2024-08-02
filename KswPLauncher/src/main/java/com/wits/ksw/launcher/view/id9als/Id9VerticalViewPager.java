package com.wits.ksw.launcher.view.id9als;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Id9VerticalViewPager extends ViewPager {
    public Id9VerticalViewPager(Context context) {
        super(context);
        init();
    }

    public Id9VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setPageTransformer(true, new VerticalPageTransformer());
        setOverScrollMode(2);
    }

    /* access modifiers changed from: private */
    public class VerticalPageTransformer implements ViewPager.PageTransformer {
        private VerticalPageTransformer() {
        }

        @Override // android.support.v4.view.ViewPager.PageTransformer
        public void transformPage(View view, float position) {
            if (position < -1.0f) {
                view.setAlpha(0.0f);
            } else if (position <= 1.0f) {
                view.setAlpha(1.0f);
                view.setTranslationX(((float) view.getWidth()) * (-position));
                view.setTranslationY(((float) view.getHeight()) * position);
            } else {
                view.setAlpha(0.0f);
            }
        }
    }

    private MotionEvent swapXY(MotionEvent ev) {
        float width = (float) getWidth();
        float height = (float) getHeight();
        ev.setLocation((ev.getY() / height) * width, (ev.getX() / width) * height);
        return ev;
    }

    @Override // android.support.v4.view.ViewPager
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = super.onInterceptTouchEvent(swapXY(ev));
        swapXY(ev);
        return intercepted;
    }

    @Override // android.support.v4.view.ViewPager
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapXY(ev));
    }
}

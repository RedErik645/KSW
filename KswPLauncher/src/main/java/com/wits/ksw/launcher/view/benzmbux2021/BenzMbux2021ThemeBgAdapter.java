package com.wits.ksw.launcher.view.benzmbux2021;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.wits.ksw.R;

public class BenzMbux2021ThemeBgAdapter extends PagerAdapter {
    private final int[] DRAWABLES;

    public BenzMbux2021ThemeBgAdapter(int[] res) {
        this.DRAWABLES = res;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.DRAWABLES.length;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        int[] iArr = this.DRAWABLES;
        int drawable = iArr[position % iArr.length];
        View view = View.inflate(container.getContext(), R.layout.benz_mbux_2021_theme_item_bg, null);
        ((ImageView) view.findViewById(R.id.iv_theme_sel_bg)).setImageResource(drawable);
        container.addView(view);
        return view;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (object != null && (object instanceof View)) {
            container.removeView((View) object);
        }
    }
}

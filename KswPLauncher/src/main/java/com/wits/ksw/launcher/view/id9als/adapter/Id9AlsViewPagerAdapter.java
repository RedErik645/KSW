package com.wits.ksw.launcher.view.id9als.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class Id9AlsViewPagerAdapter extends PagerAdapter {
    private List<View> viewLists;

    public Id9AlsViewPagerAdapter(List<View> viewLists2) {
        this.viewLists = viewLists2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(this.viewLists.get(position));
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(this.viewLists.get(position));
        return this.viewLists.get(position);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        List<View> list = this.viewLists;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}

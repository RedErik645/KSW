package com.wits.ksw.launcher.view.benzmbux2021ksw.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.DisplayMetrics;
import com.wits.ksw.launcher.view.benzmbux2021.BenzMbux2021FragmentTwo;
import com.wits.ksw.launcher.view.benzmbux2021ksw.fragment.BenzMbux2021KswFragmentOne;
import com.wits.ksw.launcher.view.benzmbux2021ksw.fragment.BenzMbux2021KswFragmentThree;
import com.wits.ksw.launcher.view.benzmbux2021ksw.fragment.BenzMbux2021KswFragmentTwo;
import java.util.ArrayList;
import java.util.List;

public class BenzMbux2021KswViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList();
    private Fragment fragmentPage1 = new BenzMbux2021KswFragmentOne();
    private Fragment fragmentPage2 = new BenzMbux2021KswFragmentTwo();
    private Fragment fragmentPage3 = new BenzMbux2021KswFragmentThree();
    private Context mContext;

    public BenzMbux2021KswViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        this.fragmentList.add(this.fragmentPage1);
        this.fragmentList.add(this.fragmentPage2);
        if (width == 1280 && height == 720) {
            this.fragmentList.add(this.fragmentPage3);
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        List<Fragment> list = this.fragmentList;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        List<Fragment> list = this.fragmentList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public BenzMbux2021FragmentTwo getFragmentPage2() {
        return (BenzMbux2021FragmentTwo) this.fragmentPage2;
    }
}

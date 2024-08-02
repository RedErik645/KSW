package com.wits.ksw.launcher.view.benzntg6fy;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wits.ksw.R;
import com.wits.ksw.databinding.BenzNtg6v3FyFragmentTwoCls;
import com.wits.ksw.launcher.utils.Constants;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BenzNtg6v3FyFragmentTwo extends Fragment {
    private BenzNtg6v3FyFragmentTwoCls binding;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BenzNtg6v3FyFragmentTwoCls benzNtg6v3FyFragmentTwoCls = (BenzNtg6v3FyFragmentTwoCls) DataBindingUtil.inflate(inflater, R.layout.ntg6v3_change_theme_item2, null, false);
        this.binding = benzNtg6v3FyFragmentTwoCls;
        return benzNtg6v3FyFragmentTwoCls.getRoot();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.binding.setThemeViewModel((Ntg6v3ThemeChangeViewModel) ViewModelProviders.of(getActivity()).get(Ntg6v3ThemeChangeViewModel.class));
        initView();
    }

    public void initView() {
        this.binding.ntg6v3Item21.setOnClickListener($$Lambda$BenzNtg6v3FyFragmentTwo$kILHZVu1BYKz0AA5BGxUZM6wZPM.INSTANCE);
        this.binding.ntg6v3Item22.setOnClickListener($$Lambda$BenzNtg6v3FyFragmentTwo$_nDnvBrAQsS1drcwn3VI7LZnGB8.INSTANCE);
        this.binding.ntg6v3Item23.setOnClickListener($$Lambda$BenzNtg6v3FyFragmentTwo$MZF5wiKUrmFLFSk2TAxaIVBt1Do.INSTANCE);
        this.binding.ntg6v3Item24.setOnClickListener($$Lambda$BenzNtg6v3FyFragmentTwo$sNrMDj_fpppoXuB3tFwUoa4FsA.INSTANCE);
        this.binding.ntg6v3Item21.setOnKeyListener(new View.OnKeyListener() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$BenzNtg6v3FyFragmentTwo$MT4VkZ477nSEMMTo3XDZCaehppI */

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return BenzNtg6v3FyFragmentTwo.this.lambda$initView$4$BenzNtg6v3FyFragmentTwo(view, i, keyEvent);
            }
        });
    }

    static /* synthetic */ void lambda$initView$0(View view) {
        try {
            PowerManagerApp.setSettingsInt(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL, Constants.NTG6V3_THEME_COLOR_YELLOW);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void lambda$initView$1(View view) {
        try {
            PowerManagerApp.setSettingsInt(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL, Constants.NTG6V3_THEME_COLOR_RED);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void lambda$initView$2(View view) {
        try {
            PowerManagerApp.setSettingsInt(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL, Constants.NTG6V3_THEME_COLOR_PURPLE);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void lambda$initView$3(View view) {
        try {
            PowerManagerApp.setSettingsInt(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL, Constants.NTG6V3_THEME_COLOR_PURPLE_LIGHT);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ boolean lambda$initView$4$BenzNtg6v3FyFragmentTwo(View view, int keyCode, KeyEvent event) {
        BenzNtg6v3FyThemeActivity themeActivity;
        if ((keyCode != 19 && keyCode != 21) || event.getAction() != 0 || (themeActivity = (BenzNtg6v3FyThemeActivity) getActivity()) == null) {
            return false;
        }
        themeActivity.themeViewPager.setCurrentItem(0);
        themeActivity.fragmentPage1.setItem4RequestFocus();
        return true;
    }

    public void setItem1RequestFocus() {
        BenzNtg6v3FyFragmentTwoCls benzNtg6v3FyFragmentTwoCls = this.binding;
        if (benzNtg6v3FyFragmentTwoCls != null) {
            benzNtg6v3FyFragmentTwoCls.ntg6v3Item21.requestFocus();
        }
    }
}

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
import com.wits.ksw.databinding.BenzNtg6v3FyFragmentOneCls;
import com.wits.ksw.launcher.utils.Constants;
import com.wits.pms.statuscontrol.PowerManagerApp;

public class BenzNtg6v3FyFragmentOne extends Fragment {
    private BenzNtg6v3FyFragmentOneCls binding;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BenzNtg6v3FyFragmentOneCls benzNtg6v3FyFragmentOneCls = (BenzNtg6v3FyFragmentOneCls) DataBindingUtil.inflate(inflater, R.layout.ntg6v3_change_theme_item1, null, false);
        this.binding = benzNtg6v3FyFragmentOneCls;
        return benzNtg6v3FyFragmentOneCls.getRoot();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.binding.setThemeViewModel((Ntg6v3ThemeChangeViewModel) ViewModelProviders.of(getActivity()).get(Ntg6v3ThemeChangeViewModel.class));
        initView();
    }

    public void initView() {
        this.binding.ntg6v3Item11.setOnClickListener($$Lambda$BenzNtg6v3FyFragmentOne$FL7Aoj7wRxx0hJCPIp7ihOdQfg.INSTANCE);
        this.binding.ntg6v3Item12.setOnClickListener($$Lambda$BenzNtg6v3FyFragmentOne$mG2wW8iqI1PORndz9OjaYfeRBYQ.INSTANCE);
        this.binding.ntg6v3Item13.setOnClickListener($$Lambda$BenzNtg6v3FyFragmentOne$ZZhC7BP9OapWX6i_Ird5GsYl3bI.INSTANCE);
        this.binding.ntg6v3Item14.setOnClickListener($$Lambda$BenzNtg6v3FyFragmentOne$GBEtipvtkokynE5lNhdYLsZ6mE.INSTANCE);
        this.binding.ntg6v3Item14.setOnKeyListener(new View.OnKeyListener() {
            /* class com.wits.ksw.launcher.view.benzntg6fy.$$Lambda$BenzNtg6v3FyFragmentOne$XfygO2KcaH6qdPUpx8n15W0fcE */

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return BenzNtg6v3FyFragmentOne.this.lambda$initView$4$BenzNtg6v3FyFragmentOne(view, i, keyEvent);
            }
        });
    }

    static /* synthetic */ void lambda$initView$0(View view) {
        try {
            PowerManagerApp.setSettingsInt(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL, Constants.NTG6V3_THEME_COLOR_BLUE);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void lambda$initView$1(View view) {
        try {
            PowerManagerApp.setSettingsInt(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL, Constants.NTG6V3_THEME_COLOR_BLUE_LIGHT);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void lambda$initView$2(View view) {
        try {
            PowerManagerApp.setSettingsInt(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL, Constants.NTG6V3_THEME_COLOR_GAY);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void lambda$initView$3(View view) {
        try {
            PowerManagerApp.setSettingsInt(Constants.NTG6V3_SELECT_THEME_VIEW_MODEL, Constants.NTG6V3_THEME_COLOR_ORANGE);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ boolean lambda$initView$4$BenzNtg6v3FyFragmentOne(View view, int keyCode, KeyEvent event) {
        BenzNtg6v3FyThemeActivity themeActivity;
        if ((keyCode != 20 && keyCode != 22) || event.getAction() != 0 || (themeActivity = (BenzNtg6v3FyThemeActivity) getActivity()) == null) {
            return false;
        }
        themeActivity.themeViewPager.setCurrentItem(1);
        themeActivity.fragmentPage2.setItem1RequestFocus();
        return true;
    }

    public void setItem1RequestFocus() {
        BenzNtg6v3FyFragmentOneCls benzNtg6v3FyFragmentOneCls = this.binding;
        if (benzNtg6v3FyFragmentOneCls != null) {
            benzNtg6v3FyFragmentOneCls.ntg6v3Item11.requestFocus();
        }
    }

    public void setItem4RequestFocus() {
        BenzNtg6v3FyFragmentOneCls benzNtg6v3FyFragmentOneCls = this.binding;
        if (benzNtg6v3FyFragmentOneCls != null) {
            benzNtg6v3FyFragmentOneCls.ntg6v3Item14.requestFocus();
        }
    }
}

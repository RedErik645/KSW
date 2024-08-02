package com.wits.ksw.launcher.view.benzmbux2021kswv2.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wits.ksw.R;
import com.wits.ksw.databinding.Benz2021KswV2FragmentThree;
import com.wits.ksw.launcher.view.benzmbux2021ksw.BenzMbux2021KswBaseFragment;

public class BenzMbux2021KswV2FragmentThree extends BenzMbux2021KswBaseFragment implements View.OnKeyListener, View.OnClickListener, View.OnFocusChangeListener {
    public static final String TAG = BenzMbux2021KswV2FragmentThree.class.getSimpleName();
    public Benz2021KswV2FragmentThree binding;

    @Override // android.support.v4.app.Fragment, com.wits.ksw.launcher.view.benzmbux2021ksw.BenzMbux2021KswBaseFragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Benz2021KswV2FragmentThree benz2021KswV2FragmentThree = (Benz2021KswV2FragmentThree) DataBindingUtil.inflate(inflater, R.layout.fragment_benz_mbux2021_ksw_v2_three, null, false);
        this.binding = benz2021KswV2FragmentThree;
        return benz2021KswV2FragmentThree.getRoot();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.binding.setViewModel(this.viewModel);
        this.binding.appItemview.setOnFocusChangeListener(this);
        this.binding.appItemview.setOnClickListener(this);
        this.binding.ivApps1.setOnClickListener(this);
        this.binding.ivApps2.setOnClickListener(this);
        this.binding.ivCar1.setOnClickListener(this);
        this.binding.ivCar2.setOnClickListener(this);
        this.binding.carItemview.setOnClickListener(this);
        this.binding.ivDash1.setOnClickListener(this);
        this.binding.ivDash2.setOnClickListener(this);
        this.binding.dashboardItemview.setOnClickListener(this);
        this.binding.appItemview.setOnKeyListener(this);
        this.binding.carItemview.setOnKeyListener(this);
        this.binding.dashboardItemview.setOnKeyListener(this);
        setDefaultSelected();
    }

    public void setItemSelected(View view) {
        this.binding.appItemview.setSelected(this.binding.appItemview == view);
    }

    public void setDefaultSelected() {
        try {
            setItemSelected(this.binding.appItemview);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == 0) {
            Log.i(TAG, "benz2021 onKey: " + keyCode);
            if (keyCode == 20 || keyCode == 22) {
                if (v == this.binding.appItemview) {
                    setItemSelected(this.binding.carItemview);
                    return false;
                } else if (v != this.binding.carItemview) {
                    return false;
                } else {
                    setItemSelected(this.binding.dashboardItemview);
                    return false;
                }
            } else if (keyCode != 19 && keyCode != 21) {
                return false;
            } else {
                if (v == this.binding.dashboardItemview) {
                    setItemSelected(this.binding.carItemview);
                    return false;
                } else if (v != this.binding.carItemview) {
                    return false;
                } else {
                    setItemSelected(this.binding.appItemview);
                    return false;
                }
            }
        } else if (keyCode == 66) {
            return false;
        } else {
            if (v == this.binding.appItemview) {
                setItemSelected(this.binding.appItemview);
                return true;
            } else if (v == this.binding.carItemview) {
                setItemSelected(this.binding.carItemview);
                return true;
            } else if (v != this.binding.dashboardItemview) {
                return true;
            } else {
                setItemSelected(this.binding.dashboardItemview);
                return true;
            }
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app_itemview /*{ENCODED_INT: 2131230806}*/:
            case R.id.iv_apps1 /*{ENCODED_INT: 2131231755}*/:
            case R.id.iv_apps2 /*{ENCODED_INT: 2131231756}*/:
                this.viewModel.openApps(v);
                setItemSelected(this.binding.appItemview);
                return;
            case R.id.car_itemview /*{ENCODED_INT: 2131231298}*/:
            case R.id.iv_car1 /*{ENCODED_INT: 2131231766}*/:
            case R.id.iv_car2 /*{ENCODED_INT: 2131231767}*/:
                this.viewModel.openCar(v);
                setItemSelected(this.binding.carItemview);
                return;
            case R.id.dashboard_itemview /*{ENCODED_INT: 2131231381}*/:
            case R.id.iv_dash1 /*{ENCODED_INT: 2131231773}*/:
            case R.id.iv_dash2 /*{ENCODED_INT: 2131231774}*/:
                this.viewModel.openDashboard(v);
                setItemSelected(this.binding.dashboardItemview);
                return;
            default:
                return;
        }
    }

    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.app_itemview /*{ENCODED_INT: 2131230806}*/:
                if (hasFocus && this.mainActivity.viewPagerBenzMbux2021Ksw != null && this.mainActivity.viewPagerBenzMbux2021Ksw.getCurrentItem() != 1) {
                    this.mainActivity.viewPagerBenzMbux2021Ksw.setCurrentItem(2);
                    setItemSelected(v);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
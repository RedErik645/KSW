package com.wits.ksw.launcher.view.benzmbux2021ksw.fragment;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wits.ksw.R;
import com.wits.ksw.databinding.Benz2021KswFragmentTwo;
import com.wits.ksw.launcher.view.benzmbux.BenzMbuxItemView;
import com.wits.ksw.launcher.view.benzmbux2021ksw.BenzMbux2021KswBaseFragment;

public class BenzMbux2021KswFragmentTwo extends BenzMbux2021KswBaseFragment implements View.OnKeyListener, View.OnClickListener, View.OnFocusChangeListener {
    public static final String TAG = "BenzMbux2021KswFragmentTwo - Two";
    public Benz2021KswFragmentTwo binding;
    private int height;
    private int width;

    @Override // android.support.v4.app.Fragment, com.wits.ksw.launcher.view.benzmbux2021ksw.BenzMbux2021KswBaseFragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Benz2021KswFragmentTwo benz2021KswFragmentTwo = (Benz2021KswFragmentTwo) DataBindingUtil.inflate(inflater, R.layout.fragment_benz_mbux2021_ksw_two, null, false);
        this.binding = benz2021KswFragmentTwo;
        return benz2021KswFragmentTwo.getRoot();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.binding.setViewModel(this.viewModel);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        this.width = dm.widthPixels;
        this.height = dm.heightPixels;
        this.binding.videoItemview.setOnFocusChangeListener(this);
        this.binding.dvrItemview.setOnFocusChangeListener(this);
        this.binding.appItemview.setOnClickListener(this);
        this.binding.ivApps1.setOnClickListener(this);
        this.binding.ivApps2.setOnClickListener(this);
        this.binding.ivPhone1.setOnClickListener(this);
        this.binding.ivPhone2.setOnClickListener(this);
        this.binding.phonelinkItemview.setOnClickListener(this);
        this.binding.ivDash1.setOnClickListener(this);
        this.binding.ivDash2.setOnClickListener(this);
        this.binding.dashboardItemview.setOnClickListener(this);
        this.binding.dvrItemview.setOnClickListener(this);
        this.binding.ivDvr1.setOnClickListener(this);
        this.binding.ivDvr2.setOnClickListener(this);
        this.binding.videoItemview.setOnClickListener(this);
        this.binding.ivVideo1.setOnClickListener(this);
        this.binding.ivVideo2.setOnClickListener(this);
        this.binding.carItemview.setOnClickListener(this);
        this.binding.ivCar1.setOnClickListener(this);
        this.binding.ivCar2.setOnClickListener(this);
        this.binding.setItemview.setOnClickListener(this);
        this.binding.ivSet1.setOnClickListener(this);
        this.binding.ivSet2.setOnClickListener(this);
        this.binding.carItemview.setOnKeyListener(this);
        this.binding.setItemview.setOnKeyListener(this);
        this.binding.videoItemview.setOnKeyListener(this);
        this.binding.appItemview.setOnKeyListener(this);
        this.binding.phonelinkItemview.setOnKeyListener(this);
        this.binding.dashboardItemview.setOnKeyListener(this);
        this.binding.dvrItemview.setOnKeyListener(this);
        setDefaultSelected();
    }

    public void setItemSelected(View view) {
        boolean z = true;
        if (this.width == 1280 && this.height == 720) {
            BenzMbuxItemView benzMbuxItemView = this.binding.carItemview;
            if (this.binding.carItemview != view) {
                z = false;
            }
            benzMbuxItemView.setSelected(z);
            return;
        }
        BenzMbuxItemView benzMbuxItemView2 = this.binding.videoItemview;
        if (this.binding.videoItemview != view) {
            z = false;
        }
        benzMbuxItemView2.setSelected(z);
    }

    public void setDefaultSelected() {
        try {
            if (this.width == 1280 && this.height == 720) {
                setItemSelected(this.binding.carItemview);
            } else {
                setItemSelected(this.binding.videoItemview);
            }
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
            Log.i("BenzMbux2021KswFragmentTwo - Two", "benz2021 onKey: " + keyCode);
            if (keyCode == 20 || keyCode == 22) {
                if (this.width == 1280 && this.height == 720) {
                    if (v == this.binding.carItemview) {
                        setItemSelected(this.binding.setItemview);
                        return false;
                    } else if (v != this.binding.setItemview) {
                        return false;
                    } else {
                        setItemSelected(this.binding.videoItemview);
                        return false;
                    }
                } else if (v == this.binding.videoItemview) {
                    setItemSelected(this.binding.appItemview);
                    return false;
                } else if (v == this.binding.appItemview) {
                    setItemSelected(this.binding.phonelinkItemview);
                    return false;
                } else if (v == this.binding.phonelinkItemview) {
                    setItemSelected(this.binding.dashboardItemview);
                    return false;
                } else if (v != this.binding.dashboardItemview) {
                    return false;
                } else {
                    setItemSelected(this.binding.dvrItemview);
                    return false;
                }
            } else if (keyCode != 19 && keyCode != 21) {
                return false;
            } else {
                if (this.width == 1280 && this.height == 720) {
                    if (v == this.binding.videoItemview) {
                        setItemSelected(this.binding.setItemview);
                        return false;
                    } else if (v != this.binding.setItemview) {
                        return false;
                    } else {
                        setItemSelected(this.binding.carItemview);
                        return false;
                    }
                } else if (v == this.binding.dvrItemview) {
                    setItemSelected(this.binding.dashboardItemview);
                    return false;
                } else if (v == this.binding.dashboardItemview) {
                    setItemSelected(this.binding.phonelinkItemview);
                    return false;
                } else if (v == this.binding.phonelinkItemview) {
                    setItemSelected(this.binding.appItemview);
                    return false;
                } else if (v != this.binding.appItemview) {
                    return false;
                } else {
                    setItemSelected(this.binding.videoItemview);
                    return false;
                }
            }
        } else if (keyCode == 66) {
            return false;
        } else {
            if (this.width == 1280 && this.height == 720) {
                if (v == this.binding.carItemview) {
                    setItemSelected(this.binding.carItemview);
                    return true;
                } else if (v == this.binding.setItemview) {
                    setItemSelected(this.binding.setItemview);
                    return true;
                } else if (v != this.binding.videoItemview) {
                    return true;
                } else {
                    setItemSelected(this.binding.videoItemview);
                    return true;
                }
            } else if (v == this.binding.videoItemview) {
                setItemSelected(this.binding.videoItemview);
                return true;
            } else if (v == this.binding.appItemview) {
                setItemSelected(this.binding.appItemview);
                return true;
            } else if (v == this.binding.phonelinkItemview) {
                setItemSelected(this.binding.phonelinkItemview);
                return true;
            } else if (v == this.binding.dashboardItemview) {
                setItemSelected(this.binding.dashboardItemview);
                return true;
            } else if (v != this.binding.dvrItemview) {
                return true;
            } else {
                setItemSelected(this.binding.dvrItemview);
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
            case R.id.dvr_itemview /*{ENCODED_INT: 2131231432}*/:
            case R.id.iv_dvr1 /*{ENCODED_INT: 2131231778}*/:
            case R.id.iv_dvr2 /*{ENCODED_INT: 2131231779}*/:
                this.viewModel.openDvr(v);
                setItemSelected(this.binding.dvrItemview);
                return;
            case R.id.iv_phone1 /*{ENCODED_INT: 2131231822}*/:
            case R.id.iv_phone2 /*{ENCODED_INT: 2131231823}*/:
            case R.id.phonelink_itemview /*{ENCODED_INT: 2131232261}*/:
                if (!Build.DISPLAY.contains("8937")) {
                    this.viewModel.openApp(this.mainActivity.getPackageManager().getLaunchIntentForPackage("com.zjinnova.zlink"));
                } else if (Settings.System.getInt(this.mainActivity.getContentResolver(), "speed_play_switch", 1) == 2) {
                    this.viewModel.openApp(this.mainActivity.getPackageManager().getLaunchIntentForPackage("com.zjinnova.zlink"));
                } else {
                    this.viewModel.openApp(this.mainActivity.getPackageManager().getLaunchIntentForPackage("com.zjinnova.zlink"));
                }
                setItemSelected(this.binding.phonelinkItemview);
                return;
            case R.id.iv_set1 /*{ENCODED_INT: 2131231829}*/:
            case R.id.iv_set2 /*{ENCODED_INT: 2131231830}*/:
            case R.id.set_itemview /*{ENCODED_INT: 2131232566}*/:
                this.viewModel.openSettings(v);
                setItemSelected(this.binding.setItemview);
                return;
            case R.id.iv_video1 /*{ENCODED_INT: 2131231839}*/:
            case R.id.iv_video2 /*{ENCODED_INT: 2131231840}*/:
            case R.id.video_itemview /*{ENCODED_INT: 2131232848}*/:
                this.viewModel.openVideoMulti(v);
                setItemSelected(this.binding.videoItemview);
                return;
            default:
                return;
        }
    }

    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.dvr_itemview /*{ENCODED_INT: 2131231432}*/:
            case R.id.set_itemview /*{ENCODED_INT: 2131232566}*/:
            case R.id.video_itemview /*{ENCODED_INT: 2131232848}*/:
                if (hasFocus && this.mainActivity.viewPagerBenzMbux2021Ksw != null && this.mainActivity.viewPagerBenzMbux2021Ksw.getCurrentItem() != 1) {
                    this.mainActivity.viewPagerBenzMbux2021Ksw.setCurrentItem(1);
                    setItemSelected(v);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.BcVieModel;
import com.wits.ksw.launcher.view.benzmbux.BenzMbuxItemView;

public class Benz2021KswV2FragmentThreeHdpi1280x720Impl extends Benz2021KswV2FragmentThree {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.app_rl, 4);
        sparseIntArray.put(R.id.app_tv, 5);
        sparseIntArray.put(R.id.app_tip, 6);
        sparseIntArray.put(R.id.iv_apps1, 7);
        sparseIntArray.put(R.id.iv_apps2, 8);
        sparseIntArray.put(R.id.car_rl, 9);
        sparseIntArray.put(R.id.car_tv, 10);
        sparseIntArray.put(R.id.car_tip, 11);
        sparseIntArray.put(R.id.iv_car1, 12);
        sparseIntArray.put(R.id.iv_car2, 13);
        sparseIntArray.put(R.id.dashboard_rl, 14);
        sparseIntArray.put(R.id.dashboard_tv, 15);
        sparseIntArray.put(R.id.dashboard_tip, 16);
        sparseIntArray.put(R.id.iv_dash1, 17);
        sparseIntArray.put(R.id.iv_dash2, 18);
    }

    public Benz2021KswV2FragmentThreeHdpi1280x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }

    private Benz2021KswV2FragmentThreeHdpi1280x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (BenzMbuxItemView) bindings[1], (RelativeLayout) bindings[4], (TextView) bindings[6], (TextView) bindings[5], (BenzMbuxItemView) bindings[2], (RelativeLayout) bindings[9], (TextView) bindings[11], (TextView) bindings[10], (BenzMbuxItemView) bindings[3], (RelativeLayout) bindings[14], (TextView) bindings[16], (TextView) bindings[15], (LinearLayout) bindings[0], (ImageView) bindings[7], (ImageView) bindings[8], (ImageView) bindings[12], (ImageView) bindings[13], (ImageView) bindings[17], (ImageView) bindings[18]);
        this.mDirtyFlags = -1;
        this.appItemview.setTag(null);
        this.carItemview.setTag(null);
        this.dashboardItemview.setTag(null);
        this.fragmentTwoLl.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        requestRebind();
    }

    @Override // android.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // android.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (36 != variableId) {
            return false;
        }
        setViewModel((BcVieModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.Benz2021KswV2FragmentThree
    public void setViewModel(BcVieModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelItemIconClassical((ObservableBoolean) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelItemIconClassical(ObservableBoolean ViewModelItemIconClassical, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Drawable viewModelItemIconClassicalDashboardItemviewAndroidDrawableBenzMbux2021KswHomeDashboardSelector1DashboardItemviewAndroidDrawableBenzMbux2021KswHomeDashboardSelector2 = null;
        Drawable viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector2 = null;
        boolean viewModelItemIconClassicalGet = false;
        ObservableBoolean viewModelItemIconClassical = null;
        Drawable viewModelItemIconClassicalAppItemviewAndroidDrawableBenzMbux2021KswHomeAppSelector1AppItemviewAndroidDrawableBenzMbux2021KswHomeAppSelector2 = null;
        BcVieModel viewModel = this.mViewModel;
        if ((dirtyFlags & 7) != 0) {
            if (viewModel != null) {
                viewModelItemIconClassical = viewModel.itemIconClassical;
            }
            updateRegistration(0, viewModelItemIconClassical);
            if (viewModelItemIconClassical != null) {
                viewModelItemIconClassicalGet = viewModelItemIconClassical.get();
            }
            if ((dirtyFlags & 7) != 0) {
                if (viewModelItemIconClassicalGet) {
                    dirtyFlags = dirtyFlags | 16 | 64 | 256;
                } else {
                    dirtyFlags = dirtyFlags | 8 | 32 | 128;
                }
            }
            viewModelItemIconClassicalDashboardItemviewAndroidDrawableBenzMbux2021KswHomeDashboardSelector1DashboardItemviewAndroidDrawableBenzMbux2021KswHomeDashboardSelector2 = AppCompatResources.getDrawable(this.dashboardItemview.getContext(), viewModelItemIconClassicalGet ? R.drawable.benz_mbux_2021_ksw_home_dashboard_selector1 : R.drawable.benz_mbux_2021_ksw_home_dashboard_selector2);
            viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector2 = AppCompatResources.getDrawable(this.carItemview.getContext(), viewModelItemIconClassicalGet ? R.drawable.benz_mbux_2021_ksw_home_car_selector1 : R.drawable.benz_mbux_2021_ksw_home_car_selector2);
            viewModelItemIconClassicalAppItemviewAndroidDrawableBenzMbux2021KswHomeAppSelector1AppItemviewAndroidDrawableBenzMbux2021KswHomeAppSelector2 = AppCompatResources.getDrawable(this.appItemview.getContext(), viewModelItemIconClassicalGet ? R.drawable.benz_mbux_2021_ksw_home_app_selector1 : R.drawable.benz_mbux_2021_ksw_home_app_selector2);
        }
        if ((7 & dirtyFlags) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.appItemview, viewModelItemIconClassicalAppItemviewAndroidDrawableBenzMbux2021KswHomeAppSelector1AppItemviewAndroidDrawableBenzMbux2021KswHomeAppSelector2);
            ImageViewBindingAdapter.setImageDrawable(this.carItemview, viewModelItemIconClassicalCarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021KswHomeCarSelector2);
            ImageViewBindingAdapter.setImageDrawable(this.dashboardItemview, viewModelItemIconClassicalDashboardItemviewAndroidDrawableBenzMbux2021KswHomeDashboardSelector1DashboardItemviewAndroidDrawableBenzMbux2021KswHomeDashboardSelector2);
        }
    }
}

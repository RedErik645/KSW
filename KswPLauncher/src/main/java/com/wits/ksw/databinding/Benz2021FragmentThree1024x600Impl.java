package com.wits.ksw.databinding;

import android.content.Context;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
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

public class Benz2021FragmentThree1024x600Impl extends Benz2021FragmentThree {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.phonelink_rl, 7);
        sparseIntArray.put(R.id.phonelink_tv, 8);
        sparseIntArray.put(R.id.phonelink_tip, 9);
        sparseIntArray.put(R.id.iv_phone1, 10);
        sparseIntArray.put(R.id.space1, 11);
        sparseIntArray.put(R.id.iv_phone2, 12);
        sparseIntArray.put(R.id.app_rl, 13);
        sparseIntArray.put(R.id.app_tv, 14);
        sparseIntArray.put(R.id.app_tip, 15);
        sparseIntArray.put(R.id.iv_apps1, 16);
        sparseIntArray.put(R.id.space2, 17);
        sparseIntArray.put(R.id.iv_apps2, 18);
        sparseIntArray.put(R.id.dashboard_rl, 19);
        sparseIntArray.put(R.id.dashboard_tv, 20);
        sparseIntArray.put(R.id.dashboard_tip, 21);
        sparseIntArray.put(R.id.iv_dash1, 22);
        sparseIntArray.put(R.id.space, 23);
        sparseIntArray.put(R.id.iv_dash2, 24);
    }

    public Benz2021FragmentThree1024x600Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }

    private Benz2021FragmentThree1024x600Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (BenzMbuxItemView) bindings[3], (BenzMbuxItemView) bindings[4], (RelativeLayout) bindings[13], (TextView) bindings[15], (TextView) bindings[14], (BenzMbuxItemView) bindings[5], (BenzMbuxItemView) bindings[6], (RelativeLayout) bindings[19], (TextView) bindings[21], (TextView) bindings[20], (LinearLayout) bindings[0], (ImageView) bindings[16], (ImageView) bindings[18], (ImageView) bindings[22], (ImageView) bindings[24], (ImageView) bindings[10], (ImageView) bindings[12], (BenzMbuxItemView) bindings[1], (BenzMbuxItemView) bindings[2], (RelativeLayout) bindings[7], (TextView) bindings[9], (TextView) bindings[8], (View) bindings[23], (View) bindings[11], (View) bindings[17]);
        this.mDirtyFlags = -1;
        this.appItemview.setTag(null);
        this.appItemviewYo.setTag(null);
        this.dashboardItemview.setTag(null);
        this.dashboardItemviewYo.setTag(null);
        this.fragmentTwoLl.setTag(null);
        this.phonelinkItemview.setTag(null);
        this.phonelinkItemviewYo.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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

    @Override // com.wits.ksw.databinding.Benz2021FragmentThree
    public void setViewModel(BcVieModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
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
            case 1:
                return onChangeViewModelIsYO((ObservableBoolean) object, fieldId);
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

    private boolean onChangeViewModelIsYO(ObservableBoolean ViewModelIsYO, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        int viewModelIsYOViewVISIBLEViewGONE;
        ObservableBoolean viewModelItemIconClassical;
        long dirtyFlags2;
        int i;
        Context context;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ObservableBoolean viewModelItemIconClassical2 = null;
        boolean viewModelIsYOGet = false;
        Drawable viewModelItemIconClassicalDashboardItemviewYoAndroidDrawableBenzMbux2021HomeDashboardSelector1DashboardItemviewYoAndroidDrawableBenzMbux2021HomeDashboardSelector2 = null;
        ObservableBoolean viewModelIsYO = null;
        int viewModelIsYOViewGONEViewVISIBLE = 0;
        Drawable viewModelItemIconClassicalDashboardItemviewYoAndroidDrawableBenzMbux2021HomeDashboardSelector1DashboardItemviewYoAndroidDrawableBenzMbux2021HomeDashboardSelector22 = null;
        Drawable viewModelItemIconClassicalPhonelinkItemviewYoAndroidDrawableBenzMbux2021HomeEasySelector1PhonelinkItemviewYoAndroidDrawableBenzMbux2021HomeEasySelector2 = null;
        Drawable viewModelItemIconClassicalDashboardItemviewAndroidDrawableBenzMbux2021HomeDashboardSelector1DashboardItemviewAndroidDrawableBenzMbux2021HomeDashboardSelector2 = null;
        Drawable viewModelItemIconClassicalPhonelinkItemviewYoAndroidDrawableBenzMbux2021HomeEasySelector1PhonelinkItemviewYoAndroidDrawableBenzMbux2021HomeEasySelector22 = null;
        boolean viewModelItemIconClassicalGet = false;
        Drawable viewModelItemIconClassicalAppItemviewYoAndroidDrawableBenzMbux2021HomeAppSelector1AppItemviewYoAndroidDrawableBenzMbux2021HomeAppSelector2 = null;
        BcVieModel viewModel = this.mViewModel;
        if ((dirtyFlags & 15) != 0) {
            if ((dirtyFlags & 13) != 0) {
                if (viewModel != null) {
                    viewModelItemIconClassical = viewModel.itemIconClassical;
                } else {
                    viewModelItemIconClassical = null;
                }
                updateRegistration(0, viewModelItemIconClassical);
                if (viewModelItemIconClassical != null) {
                    viewModelItemIconClassicalGet = viewModelItemIconClassical.get();
                }
                if ((dirtyFlags & 13) != 0) {
                    if (viewModelItemIconClassicalGet) {
                        dirtyFlags = dirtyFlags | 32 | 512 | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH | PlaybackStateCompat.ACTION_PLAY_FROM_URI | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                    } else {
                        dirtyFlags = dirtyFlags | 16 | 256 | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM | PlaybackStateCompat.ACTION_PREPARE | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    }
                }
                if (viewModelItemIconClassicalGet) {
                    context = this.phonelinkItemview.getContext();
                    dirtyFlags2 = dirtyFlags;
                    i = R.drawable.benz_mbux_2021_home_easy_selector1;
                } else {
                    dirtyFlags2 = dirtyFlags;
                    context = this.phonelinkItemview.getContext();
                    i = R.drawable.benz_mbux_2021_home_easy_selector2;
                }
                Drawable viewModelItemIconClassicalPhonelinkItemviewAndroidDrawableBenzMbux2021HomeEasySelector1PhonelinkItemviewAndroidDrawableBenzMbux2021HomeEasySelector2 = AppCompatResources.getDrawable(context, i);
                Context context2 = this.dashboardItemviewYo.getContext();
                Drawable viewModelItemIconClassicalDashboardItemviewYoAndroidDrawableBenzMbux2021HomeDashboardSelector1DashboardItemviewYoAndroidDrawableBenzMbux2021HomeDashboardSelector23 = viewModelItemIconClassicalGet ? AppCompatResources.getDrawable(context2, R.drawable.benz_mbux_2021_home_dashboard_selector1) : AppCompatResources.getDrawable(context2, R.drawable.benz_mbux_2021_home_dashboard_selector2);
                Context context3 = this.appItemview.getContext();
                Drawable viewModelItemIconClassicalAppItemviewAndroidDrawableBenzMbux2021HomeAppSelector1AppItemviewAndroidDrawableBenzMbux2021HomeAppSelector2 = viewModelItemIconClassicalGet ? AppCompatResources.getDrawable(context3, R.drawable.benz_mbux_2021_home_app_selector1) : AppCompatResources.getDrawable(context3, R.drawable.benz_mbux_2021_home_app_selector2);
                Drawable viewModelItemIconClassicalDashboardItemviewAndroidDrawableBenzMbux2021HomeDashboardSelector1DashboardItemviewAndroidDrawableBenzMbux2021HomeDashboardSelector22 = viewModelItemIconClassicalGet ? AppCompatResources.getDrawable(this.dashboardItemview.getContext(), R.drawable.benz_mbux_2021_home_dashboard_selector1) : AppCompatResources.getDrawable(this.dashboardItemview.getContext(), R.drawable.benz_mbux_2021_home_dashboard_selector2);
                Drawable viewModelItemIconClassicalPhonelinkItemviewYoAndroidDrawableBenzMbux2021HomeEasySelector1PhonelinkItemviewYoAndroidDrawableBenzMbux2021HomeEasySelector23 = AppCompatResources.getDrawable(this.phonelinkItemviewYo.getContext(), viewModelItemIconClassicalGet ? R.drawable.benz_mbux_2021_home_easy_selector1 : R.drawable.benz_mbux_2021_home_easy_selector2);
                viewModelItemIconClassicalDashboardItemviewAndroidDrawableBenzMbux2021HomeDashboardSelector1DashboardItemviewAndroidDrawableBenzMbux2021HomeDashboardSelector2 = viewModelItemIconClassicalDashboardItemviewAndroidDrawableBenzMbux2021HomeDashboardSelector1DashboardItemviewAndroidDrawableBenzMbux2021HomeDashboardSelector22;
                viewModelItemIconClassicalAppItemviewYoAndroidDrawableBenzMbux2021HomeAppSelector1AppItemviewYoAndroidDrawableBenzMbux2021HomeAppSelector2 = viewModelItemIconClassicalGet ? AppCompatResources.getDrawable(this.appItemviewYo.getContext(), R.drawable.benz_mbux_2021_home_app_selector1) : AppCompatResources.getDrawable(this.appItemviewYo.getContext(), R.drawable.benz_mbux_2021_home_app_selector2);
                viewModelItemIconClassicalPhonelinkItemviewYoAndroidDrawableBenzMbux2021HomeEasySelector1PhonelinkItemviewYoAndroidDrawableBenzMbux2021HomeEasySelector22 = viewModelItemIconClassicalPhonelinkItemviewYoAndroidDrawableBenzMbux2021HomeEasySelector1PhonelinkItemviewYoAndroidDrawableBenzMbux2021HomeEasySelector23;
                viewModelItemIconClassicalPhonelinkItemviewYoAndroidDrawableBenzMbux2021HomeEasySelector1PhonelinkItemviewYoAndroidDrawableBenzMbux2021HomeEasySelector2 = viewModelItemIconClassicalAppItemviewAndroidDrawableBenzMbux2021HomeAppSelector1AppItemviewAndroidDrawableBenzMbux2021HomeAppSelector2;
                viewModelItemIconClassicalDashboardItemviewYoAndroidDrawableBenzMbux2021HomeDashboardSelector1DashboardItemviewYoAndroidDrawableBenzMbux2021HomeDashboardSelector22 = viewModelItemIconClassicalDashboardItemviewYoAndroidDrawableBenzMbux2021HomeDashboardSelector1DashboardItemviewYoAndroidDrawableBenzMbux2021HomeDashboardSelector23;
                dirtyFlags = dirtyFlags2;
                viewModelItemIconClassicalDashboardItemviewYoAndroidDrawableBenzMbux2021HomeDashboardSelector1DashboardItemviewYoAndroidDrawableBenzMbux2021HomeDashboardSelector2 = viewModelItemIconClassicalPhonelinkItemviewAndroidDrawableBenzMbux2021HomeEasySelector1PhonelinkItemviewAndroidDrawableBenzMbux2021HomeEasySelector2;
                viewModelItemIconClassical2 = viewModelItemIconClassical;
            } else {
                viewModelItemIconClassical2 = null;
            }
            if ((dirtyFlags & 14) != 0) {
                if (viewModel != null) {
                    viewModelIsYO = viewModel.isYO;
                }
                updateRegistration(1, viewModelIsYO);
                if (viewModelIsYO != null) {
                    viewModelIsYOGet = viewModelIsYO.get();
                }
                if ((dirtyFlags & 14) != 0) {
                    if (viewModelIsYOGet) {
                        dirtyFlags = dirtyFlags | 128 | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    } else {
                        dirtyFlags = dirtyFlags | 64 | PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    }
                }
                viewModelIsYOViewVISIBLEViewGONE = 8;
                viewModelIsYOViewGONEViewVISIBLE = viewModelIsYOGet ? 8 : 0;
                if (viewModelIsYOGet) {
                    viewModelIsYOViewVISIBLEViewGONE = 0;
                }
            } else {
                viewModelIsYOViewVISIBLEViewGONE = 0;
            }
        } else {
            viewModelIsYOViewVISIBLEViewGONE = 0;
        }
        if ((dirtyFlags & 13) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.appItemview, viewModelItemIconClassicalPhonelinkItemviewYoAndroidDrawableBenzMbux2021HomeEasySelector1PhonelinkItemviewYoAndroidDrawableBenzMbux2021HomeEasySelector2);
            ImageViewBindingAdapter.setImageDrawable(this.appItemviewYo, viewModelItemIconClassicalAppItemviewYoAndroidDrawableBenzMbux2021HomeAppSelector1AppItemviewYoAndroidDrawableBenzMbux2021HomeAppSelector2);
            ImageViewBindingAdapter.setImageDrawable(this.dashboardItemview, viewModelItemIconClassicalDashboardItemviewAndroidDrawableBenzMbux2021HomeDashboardSelector1DashboardItemviewAndroidDrawableBenzMbux2021HomeDashboardSelector2);
            ImageViewBindingAdapter.setImageDrawable(this.dashboardItemviewYo, viewModelItemIconClassicalDashboardItemviewYoAndroidDrawableBenzMbux2021HomeDashboardSelector1DashboardItemviewYoAndroidDrawableBenzMbux2021HomeDashboardSelector22);
            ImageViewBindingAdapter.setImageDrawable(this.phonelinkItemview, viewModelItemIconClassicalDashboardItemviewYoAndroidDrawableBenzMbux2021HomeDashboardSelector1DashboardItemviewYoAndroidDrawableBenzMbux2021HomeDashboardSelector2);
            ImageViewBindingAdapter.setImageDrawable(this.phonelinkItemviewYo, viewModelItemIconClassicalPhonelinkItemviewYoAndroidDrawableBenzMbux2021HomeEasySelector1PhonelinkItemviewYoAndroidDrawableBenzMbux2021HomeEasySelector22);
        }
        if ((dirtyFlags & 14) != 0) {
            this.appItemview.setVisibility(viewModelIsYOViewGONEViewVISIBLE);
            this.appItemviewYo.setVisibility(viewModelIsYOViewVISIBLEViewGONE);
            this.dashboardItemview.setVisibility(viewModelIsYOViewGONEViewVISIBLE);
            this.dashboardItemviewYo.setVisibility(viewModelIsYOViewVISIBLEViewGONE);
            this.phonelinkItemview.setVisibility(viewModelIsYOViewGONEViewVISIBLE);
            this.phonelinkItemviewYo.setVisibility(viewModelIsYOViewVISIBLEViewGONE);
        }
    }
}

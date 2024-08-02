package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
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

public class Benz2021FragmentOneHdpi1280x720Impl extends Benz2021FragmentOne {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bt_rl, 5);
        sparseIntArray.put(R.id.bt_tv, 6);
        sparseIntArray.put(R.id.iv_bt1, 7);
        sparseIntArray.put(R.id.space1, 8);
        sparseIntArray.put(R.id.iv_bt2, 9);
        sparseIntArray.put(R.id.navi_rl, 10);
        sparseIntArray.put(R.id.navi_tv, 11);
        sparseIntArray.put(R.id.navi_tip, 12);
        sparseIntArray.put(R.id.iv_navi1, 13);
        sparseIntArray.put(R.id.space2, 14);
        sparseIntArray.put(R.id.iv_navi2, 15);
        sparseIntArray.put(R.id.car_rl, 16);
        sparseIntArray.put(R.id.car_tv, 17);
        sparseIntArray.put(R.id.car_tip, 18);
        sparseIntArray.put(R.id.iv_car1, 19);
        sparseIntArray.put(R.id.space, 20);
        sparseIntArray.put(R.id.iv_car2, 21);
    }

    public Benz2021FragmentOneHdpi1280x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }

    private Benz2021FragmentOneHdpi1280x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (BenzMbuxItemView) bindings[1], (RelativeLayout) bindings[5], (TextView) bindings[2], (TextView) bindings[6], (BenzMbuxItemView) bindings[4], (RelativeLayout) bindings[16], (TextView) bindings[18], (TextView) bindings[17], (LinearLayout) bindings[0], (ImageView) bindings[7], (ImageView) bindings[9], (ImageView) bindings[19], (ImageView) bindings[21], (ImageView) bindings[13], (ImageView) bindings[15], (BenzMbuxItemView) bindings[3], (RelativeLayout) bindings[10], (TextView) bindings[12], (TextView) bindings[11], (View) bindings[20], (View) bindings[8], (View) bindings[14]);
        this.mDirtyFlags = -1;
        this.btItemview.setTag(null);
        this.btTip.setTag(null);
        this.carItemview.setTag(null);
        this.fragmentOneLl.setTag(null);
        this.naviItemview.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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

    @Override // com.wits.ksw.databinding.Benz2021FragmentOne
    public void setViewModel(BcVieModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelIsYO((ObservableBoolean) object, fieldId);
            case 1:
                return onChangeViewModelItemIconClassical((ObservableBoolean) object, fieldId);
            case 2:
                return onChangeViewModelBtState((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelIsYO(ObservableBoolean ViewModelIsYO, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelItemIconClassical(ObservableBoolean ViewModelItemIconClassical, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelBtState(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        ObservableBoolean viewModelIsYO;
        ObservableBoolean viewModelIsYO2;
        ObservableBoolean viewModelIsYO3;
        ObservableBoolean viewModelIsYO4;
        Drawable drawable;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Drawable viewModelIsYONaviItemviewAndroidDrawableBenzMbuxYoHomeNaviSelector1NaviItemviewAndroidDrawableBenzMbux2021HomeNaviSelector1 = null;
        boolean viewModelItemIconClassicalGet = false;
        ObservableBoolean viewModelItemIconClassical = null;
        Drawable viewModelIsYOBtItemviewAndroidDrawableBenzMbuxYoHomeBtSelector1BtItemviewAndroidDrawableBenzMbux2021HomeBtSelector1 = null;
        ObservableField<String> viewModelBtState = null;
        Drawable viewModelIsYOCarItemviewAndroidDrawableBenzMbuxYoHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021HomeCarSelector1 = null;
        boolean viewModelIsYOGet = false;
        Drawable viewModelItemIconClassicalViewModelIsYOBtItemviewAndroidDrawableBenzMbuxYoHomeBtSelector1BtItemviewAndroidDrawableBenzMbux2021HomeBtSelector1BtItemviewAndroidDrawableBenzMbux2021HomeBtSelector2 = null;
        Drawable viewModelItemIconClassicalViewModelIsYONaviItemviewAndroidDrawableBenzMbuxYoHomeNaviSelector1NaviItemviewAndroidDrawableBenzMbux2021HomeNaviSelector1NaviItemviewAndroidDrawableBenzMbux2021HomeNaviSelector2 = null;
        Drawable viewModelItemIconClassicalViewModelIsYOCarItemviewAndroidDrawableBenzMbuxYoHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021HomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021HomeCarSelector2 = null;
        BcVieModel viewModel = this.mViewModel;
        String viewModelBtStateGet = null;
        if ((dirtyFlags & 31) != 0) {
            if ((dirtyFlags & 27) != 0) {
                if (viewModel != null) {
                    viewModelItemIconClassical = viewModel.itemIconClassical;
                }
                viewModelIsYO = null;
                updateRegistration(1, viewModelItemIconClassical);
                if (viewModelItemIconClassical != null) {
                    viewModelItemIconClassicalGet = viewModelItemIconClassical.get();
                }
                if ((dirtyFlags & 27) != 0) {
                    dirtyFlags = viewModelItemIconClassicalGet ? dirtyFlags | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM | PlaybackStateCompat.ACTION_PREPARE | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : dirtyFlags | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH | PlaybackStateCompat.ACTION_PLAY_FROM_URI | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
            } else {
                viewModelIsYO = null;
            }
            if ((dirtyFlags & 28) != 0) {
                if (viewModel != null) {
                    viewModelBtState = viewModel.btState;
                }
                updateRegistration(2, viewModelBtState);
                if (viewModelBtState != null) {
                    viewModelBtStateGet = viewModelBtState.get();
                }
            }
        } else {
            viewModelIsYO = null;
        }
        if ((dirtyFlags & 86016) != 0) {
            if (viewModel != null) {
                viewModelIsYO3 = viewModel.isYO;
            } else {
                viewModelIsYO3 = viewModelIsYO;
            }
            updateRegistration(0, viewModelIsYO3);
            if (viewModelIsYO3 != null) {
                viewModelIsYOGet = viewModelIsYO3.get();
            }
            if ((dirtyFlags & PlaybackStateCompat.ACTION_PREPARE) != 0) {
                if (viewModelIsYOGet) {
                    dirtyFlags |= 64;
                } else {
                    dirtyFlags |= 32;
                }
            }
            if ((dirtyFlags & PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) != 0) {
                if (viewModelIsYOGet) {
                    dirtyFlags |= 256;
                } else {
                    dirtyFlags |= 128;
                }
            }
            if ((dirtyFlags & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
                if (viewModelIsYOGet) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                } else {
                    dirtyFlags |= 512;
                }
            }
            if ((dirtyFlags & PlaybackStateCompat.ACTION_PREPARE) != 0) {
                if (viewModelIsYOGet) {
                    viewModelIsYO4 = viewModelIsYO3;
                    drawable = AppCompatResources.getDrawable(this.naviItemview.getContext(), R.drawable.benz_mbux_yo_home_navi_selector1);
                } else {
                    viewModelIsYO4 = viewModelIsYO3;
                    drawable = AppCompatResources.getDrawable(this.naviItemview.getContext(), R.drawable.benz_mbux_2021_home_navi_selector1);
                }
                viewModelIsYONaviItemviewAndroidDrawableBenzMbuxYoHomeNaviSelector1NaviItemviewAndroidDrawableBenzMbux2021HomeNaviSelector1 = drawable;
            } else {
                viewModelIsYO4 = viewModelIsYO3;
            }
            if ((dirtyFlags & PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) != 0) {
                viewModelIsYOBtItemviewAndroidDrawableBenzMbuxYoHomeBtSelector1BtItemviewAndroidDrawableBenzMbux2021HomeBtSelector1 = AppCompatResources.getDrawable(this.btItemview.getContext(), viewModelIsYOGet ? R.drawable.benz_mbux_yo_home_bt_selector1 : R.drawable.benz_mbux_2021_home_bt_selector1);
            }
            if ((dirtyFlags & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
                viewModelIsYOCarItemviewAndroidDrawableBenzMbuxYoHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021HomeCarSelector1 = AppCompatResources.getDrawable(this.carItemview.getContext(), viewModelIsYOGet ? R.drawable.benz_mbux_yo_home_car_selector1 : R.drawable.benz_mbux_2021_home_car_selector1);
                viewModelIsYO2 = viewModelIsYO4;
            } else {
                viewModelIsYO2 = viewModelIsYO4;
            }
        } else {
            viewModelIsYO2 = viewModelIsYO;
        }
        if ((dirtyFlags & 27) != 0) {
            viewModelItemIconClassicalViewModelIsYOBtItemviewAndroidDrawableBenzMbuxYoHomeBtSelector1BtItemviewAndroidDrawableBenzMbux2021HomeBtSelector1BtItemviewAndroidDrawableBenzMbux2021HomeBtSelector2 = viewModelItemIconClassicalGet ? viewModelIsYOBtItemviewAndroidDrawableBenzMbuxYoHomeBtSelector1BtItemviewAndroidDrawableBenzMbux2021HomeBtSelector1 : AppCompatResources.getDrawable(this.btItemview.getContext(), R.drawable.benz_mbux_2021_home_bt_selector2);
            viewModelItemIconClassicalViewModelIsYONaviItemviewAndroidDrawableBenzMbuxYoHomeNaviSelector1NaviItemviewAndroidDrawableBenzMbux2021HomeNaviSelector1NaviItemviewAndroidDrawableBenzMbux2021HomeNaviSelector2 = viewModelItemIconClassicalGet ? viewModelIsYONaviItemviewAndroidDrawableBenzMbuxYoHomeNaviSelector1NaviItemviewAndroidDrawableBenzMbux2021HomeNaviSelector1 : AppCompatResources.getDrawable(this.naviItemview.getContext(), R.drawable.benz_mbux_2021_home_navi_selector2);
            viewModelItemIconClassicalViewModelIsYOCarItemviewAndroidDrawableBenzMbuxYoHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021HomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021HomeCarSelector2 = viewModelItemIconClassicalGet ? viewModelIsYOCarItemviewAndroidDrawableBenzMbuxYoHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021HomeCarSelector1 : AppCompatResources.getDrawable(this.carItemview.getContext(), R.drawable.benz_mbux_2021_home_car_selector2);
        }
        if ((dirtyFlags & 27) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.btItemview, viewModelItemIconClassicalViewModelIsYOBtItemviewAndroidDrawableBenzMbuxYoHomeBtSelector1BtItemviewAndroidDrawableBenzMbux2021HomeBtSelector1BtItemviewAndroidDrawableBenzMbux2021HomeBtSelector2);
            ImageViewBindingAdapter.setImageDrawable(this.carItemview, viewModelItemIconClassicalViewModelIsYOCarItemviewAndroidDrawableBenzMbuxYoHomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021HomeCarSelector1CarItemviewAndroidDrawableBenzMbux2021HomeCarSelector2);
            ImageViewBindingAdapter.setImageDrawable(this.naviItemview, viewModelItemIconClassicalViewModelIsYONaviItemviewAndroidDrawableBenzMbuxYoHomeNaviSelector1NaviItemviewAndroidDrawableBenzMbux2021HomeNaviSelector1NaviItemviewAndroidDrawableBenzMbux2021HomeNaviSelector2);
        }
        if ((dirtyFlags & 28) != 0) {
            TextViewBindingAdapter.setText(this.btTip, viewModelBtStateGet);
        }
    }
}
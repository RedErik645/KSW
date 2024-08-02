package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
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
import com.wits.ksw.R;
import com.wits.ksw.settings.bmw_id9.vm.BmwId9SettingsViewModel;

public class BmwId9SettingsSystemCameraLayoutBindingImpl extends BmwId9SettingsSystemCameraLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mViewModelOnClickAndroidViewViewOnClickListener;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView1;
    private final ImageView mboundView3;
    private final ImageView mboundView5;
    private final ImageView mboundView7;
    private final ImageView mboundView9;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bmw_id9_settings_system_camera_lay, 10);
    }

    public BmwId9SettingsSystemCameraLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private BmwId9SettingsSystemCameraLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (RelativeLayout) bindings[6], (RelativeLayout) bindings[8], (RelativeLayout) bindings[2], (LinearLayout) bindings[10], (RelativeLayout) bindings[4]);
        this.mDirtyFlags = -1;
        this.bmwId9SettingsSystemCamera360.setTag(null);
        this.bmwId9SettingsSystemCamera360Built.setTag(null);
        this.bmwId9SettingsSystemCameraAfter.setTag(null);
        this.bmwId9SettingsSystemCameraOem.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[3];
        this.mboundView3 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[5];
        this.mboundView5 = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) bindings[7];
        this.mboundView7 = imageView4;
        imageView4.setTag(null);
        ImageView imageView5 = (ImageView) bindings[9];
        this.mboundView9 = imageView5;
        imageView5.setTag(null);
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
        setViewModel((BmwId9SettingsViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.BmwId9SettingsSystemCameraLayoutBinding
    public void setViewModel(BmwId9SettingsViewModel ViewModel) {
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
                return onChangeViewModelSystemBgShow((ObservableBoolean) object, fieldId);
            case 1:
                return onChangeViewModelRearCameraType((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelSystemBgShow(ObservableBoolean ViewModelSystemBgShow, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelRearCameraType(ObservableInt ViewModelRearCameraType, int fieldId) {
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
        Drawable viewModelRearCameraTypeInt0MboundView3AndroidDrawableBmwId9SettingsSelectMboundView3AndroidDrawableBmwId9SettingsUnselect;
        boolean viewModelSystemBgShowGet;
        ObservableInt viewModelRearCameraType;
        ObservableInt viewModelRearCameraType2;
        Drawable drawable;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Drawable viewModelRearCameraTypeInt1MboundView5AndroidDrawableBmwId9SettingsSelectMboundView5AndroidDrawableBmwId9SettingsUnselect = null;
        Drawable viewModelRearCameraTypeInt3MboundView9AndroidDrawableBmwId9SettingsSelectMboundView9AndroidDrawableBmwId9SettingsUnselect = null;
        int viewModelSystemBgShowViewGONEViewVISIBLE = 0;
        int viewModelRearCameraTypeGet = 0;
        View.OnClickListener viewModelOnClickAndroidViewViewOnClickListener = null;
        ObservableBoolean viewModelSystemBgShow = null;
        Drawable viewModelRearCameraTypeInt2MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect = null;
        BmwId9SettingsViewModel viewModel = this.mViewModel;
        if ((dirtyFlags & 15) != 0) {
            if (!((dirtyFlags & 12) == 0 || viewModel == null)) {
                OnClickListenerImpl onClickListenerImpl = this.mViewModelOnClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mViewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl;
                }
                viewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl.setValue(viewModel);
            }
            if ((dirtyFlags & 13) != 0) {
                if (viewModel != null) {
                    viewModelSystemBgShow = viewModel.systemBgShow;
                }
                updateRegistration(0, viewModelSystemBgShow);
                if (viewModelSystemBgShow != null) {
                    viewModelSystemBgShowGet = viewModelSystemBgShow.get();
                } else {
                    viewModelSystemBgShowGet = false;
                }
                if ((dirtyFlags & 13) != 0) {
                    if (viewModelSystemBgShowGet) {
                        dirtyFlags |= 512;
                    } else {
                        dirtyFlags |= 256;
                    }
                }
                viewModelSystemBgShowViewGONEViewVISIBLE = viewModelSystemBgShowGet ? 8 : 0;
            } else {
                viewModelSystemBgShowGet = false;
            }
            if ((dirtyFlags & 14) != 0) {
                if (viewModel != null) {
                    viewModelRearCameraType = viewModel.rearCameraType;
                } else {
                    viewModelRearCameraType = null;
                }
                updateRegistration(1, viewModelRearCameraType);
                if (viewModelRearCameraType != null) {
                    viewModelRearCameraTypeGet = viewModelRearCameraType.get();
                }
                boolean viewModelRearCameraTypeInt3 = viewModelRearCameraTypeGet == 3;
                boolean viewModelRearCameraTypeInt1 = viewModelRearCameraTypeGet == 1;
                boolean viewModelRearCameraTypeInt2 = viewModelRearCameraTypeGet == 2;
                boolean viewModelRearCameraTypeInt0 = viewModelRearCameraTypeGet == 0;
                if ((dirtyFlags & 14) != 0) {
                    if (viewModelRearCameraTypeInt3) {
                        dirtyFlags |= 128;
                    } else {
                        dirtyFlags |= 64;
                    }
                }
                if ((dirtyFlags & 14) != 0) {
                    if (viewModelRearCameraTypeInt1) {
                        dirtyFlags |= 32;
                    } else {
                        dirtyFlags |= 16;
                    }
                }
                if ((dirtyFlags & 14) != 0) {
                    if (viewModelRearCameraTypeInt2) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    }
                }
                if ((dirtyFlags & 14) != 0) {
                    if (viewModelRearCameraTypeInt0) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    }
                }
                if (viewModelRearCameraTypeInt3) {
                    viewModelRearCameraType2 = viewModelRearCameraType;
                    drawable = AppCompatResources.getDrawable(this.mboundView9.getContext(), R.drawable.bmw_id9_settings_select);
                } else {
                    viewModelRearCameraType2 = viewModelRearCameraType;
                    drawable = AppCompatResources.getDrawable(this.mboundView9.getContext(), R.drawable.bmw_id9_settings_unselect);
                }
                viewModelRearCameraTypeInt3MboundView9AndroidDrawableBmwId9SettingsSelectMboundView9AndroidDrawableBmwId9SettingsUnselect = drawable;
                viewModelRearCameraTypeInt1MboundView5AndroidDrawableBmwId9SettingsSelectMboundView5AndroidDrawableBmwId9SettingsUnselect = AppCompatResources.getDrawable(this.mboundView5.getContext(), viewModelRearCameraTypeInt1 ? R.drawable.bmw_id9_settings_select : R.drawable.bmw_id9_settings_unselect);
                viewModelRearCameraTypeInt2MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect = AppCompatResources.getDrawable(this.mboundView7.getContext(), viewModelRearCameraTypeInt2 ? R.drawable.bmw_id9_settings_select : R.drawable.bmw_id9_settings_unselect);
                viewModelRearCameraTypeInt0MboundView3AndroidDrawableBmwId9SettingsSelectMboundView3AndroidDrawableBmwId9SettingsUnselect = AppCompatResources.getDrawable(this.mboundView3.getContext(), viewModelRearCameraTypeInt0 ? R.drawable.bmw_id9_settings_select : R.drawable.bmw_id9_settings_unselect);
            } else {
                viewModelRearCameraTypeInt0MboundView3AndroidDrawableBmwId9SettingsSelectMboundView3AndroidDrawableBmwId9SettingsUnselect = null;
            }
        } else {
            viewModelRearCameraTypeInt0MboundView3AndroidDrawableBmwId9SettingsSelectMboundView3AndroidDrawableBmwId9SettingsUnselect = null;
        }
        if ((dirtyFlags & 12) != 0) {
            this.bmwId9SettingsSystemCamera360.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId9SettingsSystemCamera360Built.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId9SettingsSystemCameraAfter.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.bmwId9SettingsSystemCameraOem.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 13) != 0) {
            this.mboundView1.setVisibility(viewModelSystemBgShowViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 14) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView3, viewModelRearCameraTypeInt0MboundView3AndroidDrawableBmwId9SettingsSelectMboundView3AndroidDrawableBmwId9SettingsUnselect);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView5, viewModelRearCameraTypeInt1MboundView5AndroidDrawableBmwId9SettingsSelectMboundView5AndroidDrawableBmwId9SettingsUnselect);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView7, viewModelRearCameraTypeInt2MboundView7AndroidDrawableBmwId9SettingsSelectMboundView7AndroidDrawableBmwId9SettingsUnselect);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView9, viewModelRearCameraTypeInt3MboundView9AndroidDrawableBmwId9SettingsSelectMboundView9AndroidDrawableBmwId9SettingsUnselect);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private BmwId9SettingsViewModel value;

        public OnClickListenerImpl setValue(BmwId9SettingsViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.onClick(arg0);
        }
    }
}

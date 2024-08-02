package com.wits.ksw.databinding;

import android.content.Context;
import android.databinding.DataBindingComponent;
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
import com.wits.ksw.settings.benz_mbux_2021.vm.BenzMbuxSettingsViewModel;

public class BenzMbuxSettingsSystemCameraLayoutBindingImpl extends BenzMbuxSettingsSystemCameraLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mViewModelOnClickAndroidViewViewOnClickListener;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView2;
    private final ImageView mboundView4;
    private final ImageView mboundView6;
    private final ImageView mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.mbux_settings_system_camera_lay, 9);
    }

    public BenzMbuxSettingsSystemCameraLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private BenzMbuxSettingsSystemCameraLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RelativeLayout) bindings[5], (RelativeLayout) bindings[7], (RelativeLayout) bindings[1], (LinearLayout) bindings[9], (RelativeLayout) bindings[3]);
        this.mDirtyFlags = -1;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[4];
        this.mboundView4 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[6];
        this.mboundView6 = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) bindings[8];
        this.mboundView8 = imageView4;
        imageView4.setTag(null);
        this.mbuxSettingsSystemCamera360.setTag(null);
        this.mbuxSettingsSystemCamera360Built.setTag(null);
        this.mbuxSettingsSystemCameraAfter.setTag(null);
        this.mbuxSettingsSystemCameraOem.setTag(null);
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
        setViewModel((BenzMbuxSettingsViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.BenzMbuxSettingsSystemCameraLayoutBinding
    public void setViewModel(BenzMbuxSettingsViewModel ViewModel) {
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
                return onChangeViewModelRearCameraType((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelRearCameraType(ObservableInt ViewModelRearCameraType, int fieldId) {
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
        Drawable viewModelRearCameraTypeInt0MboundView2AndroidDrawableMbuxSettingsSelectMboundView2AndroidDrawableMbuxSettingsUnselect = null;
        Drawable viewModelRearCameraTypeInt2MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect = null;
        Drawable viewModelRearCameraTypeInt3MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect = null;
        Drawable viewModelRearCameraTypeInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect = null;
        int viewModelRearCameraTypeGet = 0;
        View.OnClickListener viewModelOnClickAndroidViewViewOnClickListener = null;
        ObservableInt viewModelRearCameraType = null;
        BenzMbuxSettingsViewModel viewModel = this.mViewModel;
        if ((dirtyFlags & 7) != 0) {
            if (!((dirtyFlags & 6) == 0 || viewModel == null)) {
                OnClickListenerImpl onClickListenerImpl = this.mViewModelOnClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mViewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl;
                }
                viewModelOnClickAndroidViewViewOnClickListener = onClickListenerImpl.setValue(viewModel);
            }
            if (viewModel != null) {
                viewModelRearCameraType = viewModel.rearCameraType;
            }
            updateRegistration(0, viewModelRearCameraType);
            if (viewModelRearCameraType != null) {
                viewModelRearCameraTypeGet = viewModelRearCameraType.get();
            }
            boolean viewModelRearCameraTypeInt3 = viewModelRearCameraTypeGet == 3;
            boolean viewModelRearCameraTypeInt1 = viewModelRearCameraTypeGet == 1;
            boolean viewModelRearCameraTypeInt2 = viewModelRearCameraTypeGet == 2;
            boolean viewModelRearCameraTypeInt0 = viewModelRearCameraTypeGet == 0;
            if ((dirtyFlags & 7) != 0) {
                if (viewModelRearCameraTypeInt3) {
                    dirtyFlags |= 256;
                } else {
                    dirtyFlags |= 128;
                }
            }
            if ((dirtyFlags & 7) != 0) {
                if (viewModelRearCameraTypeInt1) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                } else {
                    dirtyFlags |= 512;
                }
            }
            if ((dirtyFlags & 7) != 0) {
                if (viewModelRearCameraTypeInt2) {
                    dirtyFlags |= 64;
                } else {
                    dirtyFlags |= 32;
                }
            }
            if ((dirtyFlags & 7) != 0) {
                if (viewModelRearCameraTypeInt0) {
                    dirtyFlags |= 16;
                } else {
                    dirtyFlags |= 8;
                }
            }
            int i = R.drawable.mbux_settings_select;
            Context context = this.mboundView8.getContext();
            if (!viewModelRearCameraTypeInt3) {
                i = R.drawable.mbux_settings_unselect;
            }
            viewModelRearCameraTypeInt3MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect = AppCompatResources.getDrawable(context, i);
            viewModelRearCameraTypeInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect = AppCompatResources.getDrawable(this.mboundView4.getContext(), viewModelRearCameraTypeInt1 ? R.drawable.mbux_settings_select : R.drawable.mbux_settings_unselect);
            viewModelRearCameraTypeInt2MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect = AppCompatResources.getDrawable(this.mboundView6.getContext(), viewModelRearCameraTypeInt2 ? R.drawable.mbux_settings_select : R.drawable.mbux_settings_unselect);
            viewModelRearCameraTypeInt0MboundView2AndroidDrawableMbuxSettingsSelectMboundView2AndroidDrawableMbuxSettingsUnselect = AppCompatResources.getDrawable(this.mboundView2.getContext(), viewModelRearCameraTypeInt0 ? R.drawable.mbux_settings_select : R.drawable.mbux_settings_unselect);
        }
        if ((dirtyFlags & 7) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView2, viewModelRearCameraTypeInt0MboundView2AndroidDrawableMbuxSettingsSelectMboundView2AndroidDrawableMbuxSettingsUnselect);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView4, viewModelRearCameraTypeInt1MboundView4AndroidDrawableMbuxSettingsSelectMboundView4AndroidDrawableMbuxSettingsUnselect);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView6, viewModelRearCameraTypeInt2MboundView6AndroidDrawableMbuxSettingsSelectMboundView6AndroidDrawableMbuxSettingsUnselect);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView8, viewModelRearCameraTypeInt3MboundView8AndroidDrawableMbuxSettingsSelectMboundView8AndroidDrawableMbuxSettingsUnselect);
        }
        if ((dirtyFlags & 6) != 0) {
            this.mbuxSettingsSystemCamera360.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.mbuxSettingsSystemCamera360Built.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.mbuxSettingsSystemCameraAfter.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
            this.mbuxSettingsSystemCameraOem.setOnClickListener(viewModelOnClickAndroidViewViewOnClickListener);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private BenzMbuxSettingsViewModel value;

        public OnClickListenerImpl setValue(BenzMbuxSettingsViewModel value2) {
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

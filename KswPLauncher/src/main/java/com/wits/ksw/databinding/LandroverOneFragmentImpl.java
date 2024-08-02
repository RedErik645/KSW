package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.land_rover.model.LandroverViewModel;

public class LandroverOneFragmentImpl extends LandroverOneFragment implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback433;
    private final View.OnClickListener mCallback434;
    private final View.OnClickListener mCallback435;
    private final View.OnClickListener mCallback436;
    private final View.OnClickListener mCallback437;
    private final View.OnClickListener mCallback438;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    public LandroverOneFragmentImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    private LandroverOneFragmentImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[4], (ImageView) bindings[5], (ImageView) bindings[1], (ImageView) bindings[3], (ImageView) bindings[6], (ImageView) bindings[2]);
        this.mDirtyFlags = -1;
        this.landroverMainIconCar.setTag(null);
        this.landroverMainIconDvr.setTag(null);
        this.landroverMainIconGps.setTag(null);
        this.landroverMainIconMusic.setTag(null);
        this.landroverMainIconSettings.setTag(null);
        this.landroverMainIconVideo.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(root);
        this.mCallback435 = new OnClickListener(this, 3);
        this.mCallback434 = new OnClickListener(this, 2);
        this.mCallback437 = new OnClickListener(this, 5);
        this.mCallback436 = new OnClickListener(this, 4);
        this.mCallback433 = new OnClickListener(this, 1);
        this.mCallback438 = new OnClickListener(this, 6);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
        if (25 != variableId) {
            return false;
        }
        setViewModel((LandroverViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.LandroverOneFragment
    public void setViewModel(LandroverViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        LandroverViewModel viewModel = this.mViewModel;
        View.OnFocusChangeListener viewModelSettingsViewFocusChangeListener = null;
        if (!((dirtyFlags & 3) == 0 || viewModel == null)) {
            viewModelSettingsViewFocusChangeListener = viewModel.settingsViewFocusChangeListener;
        }
        if ((2 & dirtyFlags) != 0) {
            this.landroverMainIconCar.setOnClickListener(this.mCallback436);
            this.landroverMainIconDvr.setOnClickListener(this.mCallback437);
            this.landroverMainIconGps.setOnClickListener(this.mCallback433);
            this.landroverMainIconMusic.setOnClickListener(this.mCallback435);
            this.landroverMainIconSettings.setOnClickListener(this.mCallback438);
            this.landroverMainIconVideo.setOnClickListener(this.mCallback434);
        }
        if ((3 & dirtyFlags) != 0) {
            this.landroverMainIconSettings.setOnFocusChangeListener(viewModelSettingsViewFocusChangeListener);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean viewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                LandroverViewModel viewModel = this.mViewModel;
                if (viewModel == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel.openNaviApp(callbackArg_0);
                    return;
                }
                return;
            case 2:
                LandroverViewModel viewModel2 = this.mViewModel;
                if (viewModel2 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel2.openVideoMulti(callbackArg_0);
                    return;
                }
                return;
            case 3:
                LandroverViewModel viewModel3 = this.mViewModel;
                if (viewModel3 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel3.openMusicMulti(callbackArg_0);
                    return;
                }
                return;
            case 4:
                LandroverViewModel viewModel4 = this.mViewModel;
                if (viewModel4 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel4.openCar(callbackArg_0);
                    return;
                }
                return;
            case 5:
                LandroverViewModel viewModel5 = this.mViewModel;
                if (viewModel5 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel5.openDvr(callbackArg_0);
                    return;
                }
                return;
            case 6:
                LandroverViewModel viewModel6 = this.mViewModel;
                if (viewModel6 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel6.openSettings(callbackArg_0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

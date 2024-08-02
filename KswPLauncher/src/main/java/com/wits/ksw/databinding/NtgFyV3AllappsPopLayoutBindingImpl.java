package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel;

public class NtgFyV3AllappsPopLayoutBindingImpl extends NtgFyV3AllappsPopLayoutBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback106;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ntg_fy_v3_popwindow_bg, 2);
        sparseIntArray.put(R.id.viewpager, 3);
        sparseIntArray.put(R.id.point, 4);
    }

    public NtgFyV3AllappsPopLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    private NtgFyV3AllappsPopLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RelativeLayout) bindings[1], (ConstraintLayout) bindings[2], (LinearLayout) bindings[4], (ViewPager) bindings[3]);
        this.mDirtyFlags = -1;
        this.llEdit.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(root);
        this.mCallback106 = new OnClickListener(this, 1);
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
        if (22 != variableId) {
            return false;
        }
        setPopwindowViewModel((Ntg6v3LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.NtgFyV3AllappsPopLayoutBinding
    public void setPopwindowViewModel(Ntg6v3LauncherViewModel PopwindowViewModel) {
        this.mPopwindowViewModel = PopwindowViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(22);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangePopwindowViewModelAllappPopStatle((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangePopwindowViewModelAllappPopStatle(ObservableField<Boolean> observableField, int fieldId) {
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
        int popwindowViewModelAllappPopStatleViewVISIBLEViewGONE = 0;
        ObservableField<Boolean> popwindowViewModelAllappPopStatle = null;
        Ntg6v3LauncherViewModel popwindowViewModel = this.mPopwindowViewModel;
        Boolean popwindowViewModelAllappPopStatleGet = null;
        if ((dirtyFlags & 7) != 0) {
            if (popwindowViewModel != null) {
                popwindowViewModelAllappPopStatle = popwindowViewModel.allappPopStatle;
            }
            int i = 0;
            updateRegistration(0, popwindowViewModelAllappPopStatle);
            if (popwindowViewModelAllappPopStatle != null) {
                popwindowViewModelAllappPopStatleGet = popwindowViewModelAllappPopStatle.get();
            }
            boolean androidDatabindingViewDataBindingSafeUnboxPopwindowViewModelAllappPopStatleGet = ViewDataBinding.safeUnbox(popwindowViewModelAllappPopStatleGet);
            if ((dirtyFlags & 7) != 0) {
                if (androidDatabindingViewDataBindingSafeUnboxPopwindowViewModelAllappPopStatleGet) {
                    dirtyFlags |= 16;
                } else {
                    dirtyFlags |= 8;
                }
            }
            if (!androidDatabindingViewDataBindingSafeUnboxPopwindowViewModelAllappPopStatleGet) {
                i = 8;
            }
            popwindowViewModelAllappPopStatleViewVISIBLEViewGONE = i;
        }
        if ((4 & dirtyFlags) != 0) {
            this.llEdit.setOnClickListener(this.mCallback106);
        }
        if ((7 & dirtyFlags) != 0) {
            this.mboundView0.setVisibility(popwindowViewModelAllappPopStatleViewVISIBLEViewGONE);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        Ntg6v3LauncherViewModel popwindowViewModel = this.mPopwindowViewModel;
        if (popwindowViewModel != null) {
            popwindowViewModel.clickAllAppEdit();
        }
    }
}

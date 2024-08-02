package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.CustomBmwImageView;

public class Id7V2SubVideoViewBindingImpl extends Id7V2SubVideoViewBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback561;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.textView2, 2);
        sparseIntArray.put(R.id.textView3, 3);
    }

    public Id7V2SubVideoViewBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }

    private Id7V2SubVideoViewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[2], (TextView) bindings[3], (ConstraintLayout) bindings[0], (CustomBmwImageView) bindings[1]);
        this.mDirtyFlags = -1;
        this.videoConstraintLayout.setTag(null);
        this.videoImageView.setTag(null);
        setRootTag(root);
        this.mCallback561 = new OnClickListener(this, 1);
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
        if (16 != variableId) {
            return false;
        }
        setMediaViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.Id7V2SubVideoViewBinding
    public void setMediaViewModel(LauncherViewModel MediaViewModel) {
        this.mMediaViewModel = MediaViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(16);
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
        LauncherViewModel mediaViewModel = this.mMediaViewModel;
        View.OnFocusChangeListener mediaViewModelVideoViewFocusChangeListenerv2 = null;
        if (!((dirtyFlags & 3) == 0 || mediaViewModel == null)) {
            mediaViewModelVideoViewFocusChangeListenerv2 = mediaViewModel.videoViewFocusChangeListenerv2;
        }
        if ((2 & dirtyFlags) != 0) {
            this.videoImageView.setOnClickListener(this.mCallback561);
        }
        if ((3 & dirtyFlags) != 0) {
            this.videoImageView.setOnFocusChangeListener(mediaViewModelVideoViewFocusChangeListenerv2);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        LauncherViewModel mediaViewModel = this.mMediaViewModel;
        if (mediaViewModel != null) {
            mediaViewModel.openVideoMulti(callbackArg_0);
        }
    }
}

package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.launcher.bean.AppInfo;

public class Ntg6v3AppDialogItemBindingImpl extends Ntg6v3AppDialogItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public Ntg6v3AppDialogItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }

    private Ntg6v3AppDialogItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[0], (ImageView) bindings[1], (TextView) bindings[2]);
        this.mDirtyFlags = -1;
        this.BcItemConstraintLayout.setTag(null);
        this.nameImageView.setTag(null);
        this.textView.setTag(null);
        setRootTag(root);
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
        if (34 != variableId) {
            return false;
        }
        setNtg6v3listItem((AppInfo) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.Ntg6v3AppDialogItemBinding
    public void setNtg6v3listItem(AppInfo Ntg6v3listItem) {
        this.mNtg6v3listItem = Ntg6v3listItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(34);
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
        Drawable ntg6v3listItemAppIcon = null;
        String ntg6v3listItemAppLable = null;
        AppInfo ntg6v3listItem = this.mNtg6v3listItem;
        if (!((dirtyFlags & 3) == 0 || ntg6v3listItem == null)) {
            ntg6v3listItemAppIcon = ntg6v3listItem.getAppIcon();
            ntg6v3listItemAppLable = ntg6v3listItem.getAppLable();
        }
        if ((3 & dirtyFlags) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.nameImageView, ntg6v3listItemAppIcon);
            TextViewBindingAdapter.setText(this.textView, ntg6v3listItemAppLable);
        }
    }
}

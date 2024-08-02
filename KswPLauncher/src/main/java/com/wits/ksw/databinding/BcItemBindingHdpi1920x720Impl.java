package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.bean.BcItem;
import com.wits.ksw.launcher.model.BcVieModel;
import com.wits.ksw.launcher.view.CustomBcImageView;

public class BcItemBindingHdpi1920x720Impl extends BcItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback94;
    private long mDirtyFlags;
    private final CustomBcImageView mboundView1;
    private final TextView mboundView2;

    public BcItemBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }

    private BcItemBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[0]);
        this.mDirtyFlags = -1;
        CustomBcImageView customBcImageView = (CustomBcImageView) bindings[1];
        this.mboundView1 = customBcImageView;
        customBcImageView.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        this.naviCusLinearLayout.setTag("naviCusLinearLayout");
        setRootTag(root);
        this.mCallback94 = new OnClickListener(this, 1);
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
        if (29 == variableId) {
            setListItem((BcItem) variable);
            return true;
        } else if (30 != variableId) {
            return false;
        } else {
            setMBcVieModel((BcVieModel) variable);
            return true;
        }
    }

    @Override // com.wits.ksw.databinding.BcItemBinding
    public void setListItem(BcItem ListItem) {
        this.mListItem = ListItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(29);
        super.requestRebind();
    }

    @Override // com.wits.ksw.databinding.BcItemBinding
    public void setMBcVieModel(BcVieModel MBcVieModel) {
        this.mMBcVieModel = MBcVieModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(30);
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
        BcItem listItem = this.mListItem;
        Drawable listItemAppIcon = null;
        BcVieModel bcVieModel = this.mMBcVieModel;
        String listItemAppLable = null;
        if (!((dirtyFlags & 5) == 0 || listItem == null)) {
            listItemAppIcon = listItem.getAppIcon();
            listItemAppLable = listItem.getAppLable();
        }
        if ((5 & dirtyFlags) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView1, listItemAppIcon);
            TextViewBindingAdapter.setText(this.mboundView2, listItemAppLable);
        }
        if ((4 & dirtyFlags) != 0) {
            this.mboundView1.setOnClickListener(this.mCallback94);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        BcItem listItem = this.mListItem;
        BcVieModel mBcVieModel = this.mMBcVieModel;
        if (mBcVieModel != null) {
            mBcVieModel.onItemClick(callbackArg_0, listItem);
        }
    }
}
package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.bean.NtgFyV3Item;
import com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel;

public class Ntgfyv3OtherItemBindingImpl extends Ntgfyv3OtherItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback115;
    private long mDirtyFlags;
    private final ImageView mboundView2;
    private final TextView mboundView3;

    public Ntgfyv3OtherItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }

    private Ntgfyv3OtherItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[0], (RelativeLayout) bindings[1]);
        this.mDirtyFlags = -1;
        ImageView imageView = (ImageView) bindings[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        this.naviCusLinearLayout.setTag("naviCusLinearLayout");
        this.ntgfyv3ItemIv.setTag(null);
        setRootTag(root);
        this.mCallback115 = new OnClickListener(this, 1);
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
            setListItem((NtgFyV3Item) variable);
            return true;
        } else if (32 != variableId) {
            return false;
        } else {
            setMappsVieModel((Ntg6v3LauncherViewModel) variable);
            return true;
        }
    }

    @Override // com.wits.ksw.databinding.Ntgfyv3OtherItemBinding
    public void setListItem(NtgFyV3Item ListItem) {
        this.mListItem = ListItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(29);
        super.requestRebind();
    }

    @Override // com.wits.ksw.databinding.Ntgfyv3OtherItemBinding
    public void setMappsVieModel(Ntg6v3LauncherViewModel MappsVieModel) {
        this.mMappsVieModel = MappsVieModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(32);
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
        NtgFyV3Item listItem = this.mListItem;
        Drawable listItemAppIcon = null;
        Ntg6v3LauncherViewModel ntg6v3LauncherViewModel = this.mMappsVieModel;
        String listItemAppLable = null;
        if (!((dirtyFlags & 5) == 0 || listItem == null)) {
            listItemAppIcon = listItem.getAppIcon();
            listItemAppLable = listItem.getAppLable();
        }
        if ((5 & dirtyFlags) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView2, listItemAppIcon);
            TextViewBindingAdapter.setText(this.mboundView3, listItemAppLable);
        }
        if ((4 & dirtyFlags) != 0) {
            this.ntgfyv3ItemIv.setOnClickListener(this.mCallback115);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        NtgFyV3Item listItem = this.mListItem;
        Ntg6v3LauncherViewModel mappsVieModel = this.mMappsVieModel;
        if (mappsVieModel != null) {
            mappsVieModel.onItemClick(callbackArg_0, listItem);
        }
    }
}

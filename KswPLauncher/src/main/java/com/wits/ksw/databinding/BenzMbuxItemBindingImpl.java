package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.BcVieModel;
import com.wits.ksw.launcher.view.benzmbux.BenzMbuxBean;
import com.wits.ksw.launcher.view.benzmbux.BenzMbuxItemView;

public class BenzMbuxItemBindingImpl extends BenzMbuxItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback384;
    private final View.OnClickListener mCallback385;
    private final View.OnClickListener mCallback386;
    private long mDirtyFlags;
    private final ImageView mboundView3;
    private final ImageView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.space, 5);
    }

    public BenzMbuxItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private BenzMbuxItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BenzMbuxItemView) bindings[1], (TextView) bindings[2], (RelativeLayout) bindings[0], (View) bindings[5]);
        this.mDirtyFlags = -1;
        this.benzMbuxImageView.setTag(null);
        this.benzMbuxTextView.setTag(null);
        ImageView imageView = (ImageView) bindings[3];
        this.mboundView3 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[4];
        this.mboundView4 = imageView2;
        imageView2.setTag(null);
        this.naviCusLinearLayout.setTag("naviCusLinearLayout");
        setRootTag(root);
        this.mCallback386 = new OnClickListener(this, 3);
        this.mCallback385 = new OnClickListener(this, 2);
        this.mCallback384 = new OnClickListener(this, 1);
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
            setListItem((BenzMbuxBean) variable);
            return true;
        } else if (35 != variableId) {
            return false;
        } else {
            setVieModel((BcVieModel) variable);
            return true;
        }
    }

    @Override // com.wits.ksw.databinding.BenzMbuxItemBinding
    public void setListItem(BenzMbuxBean ListItem) {
        this.mListItem = ListItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(29);
        super.requestRebind();
    }

    @Override // com.wits.ksw.databinding.BenzMbuxItemBinding
    public void setVieModel(BcVieModel VieModel) {
        this.mVieModel = VieModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(35);
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
        BenzMbuxBean listItem = this.mListItem;
        Drawable listItemAppIcon = null;
        BcVieModel bcVieModel = this.mVieModel;
        String listItemAppLable = null;
        Drawable listItemSubIcon1 = null;
        Drawable listItemSubIcon2 = null;
        if (!((dirtyFlags & 5) == 0 || listItem == null)) {
            listItemAppIcon = listItem.getAppIcon();
            listItemAppLable = listItem.getAppLable();
            listItemSubIcon1 = listItem.getSubIcon1();
            listItemSubIcon2 = listItem.getSubIcon2();
        }
        if ((4 & dirtyFlags) != 0) {
            this.benzMbuxImageView.setOnClickListener(this.mCallback384);
            this.mboundView3.setOnClickListener(this.mCallback385);
            this.mboundView4.setOnClickListener(this.mCallback386);
        }
        if ((5 & dirtyFlags) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.benzMbuxImageView, listItemAppIcon);
            TextViewBindingAdapter.setText(this.benzMbuxTextView, listItemAppLable);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView3, listItemSubIcon1);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView4, listItemSubIcon2);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean vieModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                BenzMbuxBean listItem = this.mListItem;
                BcVieModel vieModel = this.mVieModel;
                if (vieModel == null) {
                    vieModelJavaLangObjectNull = false;
                }
                if (vieModelJavaLangObjectNull) {
                    vieModel.onMbuxHomeItemClick(callbackArg_0, listItem);
                    return;
                }
                return;
            case 2:
                BenzMbuxBean listItem2 = this.mListItem;
                BcVieModel vieModel2 = this.mVieModel;
                if (vieModel2 == null) {
                    vieModelJavaLangObjectNull = false;
                }
                if (vieModelJavaLangObjectNull) {
                    vieModel2.onMbuxHomeItemClick(this.benzMbuxImageView, listItem2);
                    return;
                }
                return;
            case 3:
                BenzMbuxBean listItem3 = this.mListItem;
                BcVieModel vieModel3 = this.mVieModel;
                if (vieModel3 == null) {
                    vieModelJavaLangObjectNull = false;
                }
                if (vieModelJavaLangObjectNull) {
                    vieModel3.onMbuxHomeItemClick(this.benzMbuxImageView, listItem3);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

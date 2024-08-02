package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class Evoid8AppRightBarBindingImpl extends Evoid8AppRightBarBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback76;
    private final View.OnClickListener mCallback77;
    private final View.OnClickListener mCallback78;
    private final View.OnClickListener mCallback79;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ll_right_bar_container, 5);
        sparseIntArray.put(R.id.iv_right_4, 6);
    }

    public Evoid8AppRightBarBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    private Evoid8AppRightBarBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1], (ImageView) bindings[2], (ImageView) bindings[3], (ImageView) bindings[6], (ImageView) bindings[4], (ImageView) bindings[5]);
        this.mDirtyFlags = -1;
        this.ivRight1.setTag("Id8ugRight1");
        this.ivRight2.setTag("Id8ugRight2");
        this.ivRight3.setTag("Id8ugRight3");
        this.ivRight5.setTag("Id8ugRight5");
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(root);
        this.mCallback78 = new OnClickListener(this, 3);
        this.mCallback79 = new OnClickListener(this, 4);
        this.mCallback76 = new OnClickListener(this, 1);
        this.mCallback77 = new OnClickListener(this, 2);
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
        if (14 != variableId) {
            return false;
        }
        setLeftViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.Evoid8AppRightBarBinding
    public void setLeftViewModel(LauncherViewModel LeftViewModel) {
        this.mLeftViewModel = LeftViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(14);
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
        LauncherViewModel launcherViewModel = this.mLeftViewModel;
        if ((2 & dirtyFlags) != 0) {
            this.ivRight1.setOnClickListener(this.mCallback76);
            this.ivRight2.setOnClickListener(this.mCallback77);
            this.ivRight3.setOnClickListener(this.mCallback78);
            this.ivRight5.setOnClickListener(this.mCallback79);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean leftViewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                LauncherViewModel leftViewModel = this.mLeftViewModel;
                if (leftViewModel == null) {
                    leftViewModelJavaLangObjectNull = false;
                }
                if (leftViewModelJavaLangObjectNull) {
                    leftViewModel.openNaviApp(callbackArg_0);
                    return;
                }
                return;
            case 2:
                LauncherViewModel leftViewModel2 = this.mLeftViewModel;
                if (leftViewModel2 == null) {
                    leftViewModelJavaLangObjectNull = false;
                }
                if (leftViewModelJavaLangObjectNull) {
                    leftViewModel2.openShouJiHuLian(callbackArg_0);
                    return;
                }
                return;
            case 3:
                LauncherViewModel leftViewModel3 = this.mLeftViewModel;
                if (leftViewModel3 == null) {
                    leftViewModelJavaLangObjectNull = false;
                }
                if (leftViewModelJavaLangObjectNull) {
                    leftViewModel3.openBtApp(callbackArg_0);
                    return;
                }
                return;
            case 4:
                LauncherViewModel leftViewModel4 = this.mLeftViewModel;
                if (leftViewModel4 == null) {
                    leftViewModelJavaLangObjectNull = false;
                }
                if (leftViewModelJavaLangObjectNull) {
                    leftViewModel4.openSettings(callbackArg_0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

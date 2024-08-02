package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.land_rover.model.LandroverViewModel;

public class LandroverTwoFragmentImpl extends LandroverTwoFragment implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback285;
    private final View.OnClickListener mCallback286;
    private final View.OnClickListener mCallback287;
    private final View.OnClickListener mCallback288;
    private final View.OnClickListener mCallback289;
    private final View.OnClickListener mCallback290;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    public LandroverTwoFragmentImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    private LandroverTwoFragmentImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[5], (ImageView) bindings[6], (ImageView) bindings[1], (ImageView) bindings[3], (ImageView) bindings[2], (ImageView) bindings[4]);
        this.mDirtyFlags = -1;
        this.landroverMainIconApp.setTag(null);
        this.landroverMainIconBrowser.setTag(null);
        this.landroverMainIconBt.setTag(null);
        this.landroverMainIconDashboard.setTag(null);
        this.landroverMainIconFile.setTag(null);
        this.landroverMainIconPhonelink.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(root);
        this.mCallback289 = new OnClickListener(this, 5);
        this.mCallback287 = new OnClickListener(this, 3);
        this.mCallback288 = new OnClickListener(this, 4);
        this.mCallback285 = new OnClickListener(this, 1);
        this.mCallback286 = new OnClickListener(this, 2);
        this.mCallback290 = new OnClickListener(this, 6);
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

    @Override // com.wits.ksw.databinding.LandroverTwoFragment
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
        View.OnFocusChangeListener viewModelBtViewFocusChangeListener = null;
        if (!((dirtyFlags & 3) == 0 || viewModel == null)) {
            viewModelBtViewFocusChangeListener = viewModel.btViewFocusChangeListener;
        }
        if ((2 & dirtyFlags) != 0) {
            this.landroverMainIconApp.setOnClickListener(this.mCallback289);
            this.landroverMainIconBrowser.setOnClickListener(this.mCallback290);
            this.landroverMainIconBt.setOnClickListener(this.mCallback285);
            this.landroverMainIconDashboard.setOnClickListener(this.mCallback287);
            this.landroverMainIconFile.setOnClickListener(this.mCallback286);
            this.landroverMainIconPhonelink.setOnClickListener(this.mCallback288);
        }
        if ((3 & dirtyFlags) != 0) {
            this.landroverMainIconBt.setOnFocusChangeListener(viewModelBtViewFocusChangeListener);
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
                    viewModel.openBtApp(callbackArg_0);
                    return;
                }
                return;
            case 2:
                LandroverViewModel viewModel2 = this.mViewModel;
                if (viewModel2 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel2.openFileManager(callbackArg_0);
                    return;
                }
                return;
            case 3:
                LandroverViewModel viewModel3 = this.mViewModel;
                if (viewModel3 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel3.openDashboard(callbackArg_0);
                    return;
                }
                return;
            case 4:
                LandroverViewModel viewModel4 = this.mViewModel;
                if (viewModel4 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel4.openShouJiHuLian(callbackArg_0);
                    return;
                }
                return;
            case 5:
                LandroverViewModel viewModel5 = this.mViewModel;
                if (viewModel5 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel5.openAllApp(callbackArg_0);
                    return;
                }
                return;
            case 6:
                LandroverViewModel viewModel6 = this.mViewModel;
                if (viewModel6 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel6.openBrowser(callbackArg_0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

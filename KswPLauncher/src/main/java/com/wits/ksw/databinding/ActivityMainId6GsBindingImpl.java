package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.view.bmwevoid6gs.BmwId6gsViewMode;
import com.wits.ksw.launcher.view.bmwevoid6gs.Bmwid6gsViewPager;

public class ActivityMainId6GsBindingImpl extends ActivityMainId6GsBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback582;
    private final View.OnClickListener mCallback583;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public ActivityMainId6GsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }

    private ActivityMainId6GsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (ImageView) bindings[2], (Bmwid6gsViewPager) bindings[1], (ImageView) bindings[3]);
        this.mDirtyFlags = -1;
        this.id6GsLeftBtn.setTag(null);
        this.id6GsMainViewPager.setTag(null);
        this.id6GsRightBtn.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(root);
        this.mCallback582 = new OnClickListener(this, 1);
        this.mCallback583 = new OnClickListener(this, 2);
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
        if (37 != variableId) {
            return false;
        }
        setVm((BmwId6gsViewMode) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityMainId6GsBinding
    public void setVm(BmwId6gsViewMode Vm) {
        this.mVm = Vm;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(37);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeVmPageIndex((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeVmPageIndex(ObservableInt VmPageIndex, int fieldId) {
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
        int vmPageIndexInt2ViewINVISIBLEViewVISIBLE = 0;
        ObservableInt vmPageIndex = null;
        BmwId6gsViewMode vm = this.mVm;
        int vmPageIndexGet = 0;
        int vmPageIndexInt0ViewINVISIBLEViewVISIBLE = 0;
        if ((dirtyFlags & 7) != 0) {
            if (vm != null) {
                vmPageIndex = vm.pageIndex;
            }
            updateRegistration(0, vmPageIndex);
            if (vmPageIndex != null) {
                vmPageIndexGet = vmPageIndex.get();
            }
            boolean vmPageIndexInt2 = true;
            boolean vmPageIndexInt0 = vmPageIndexGet == 0;
            if (vmPageIndexGet != 2) {
                vmPageIndexInt2 = false;
            }
            if ((dirtyFlags & 7) != 0) {
                if (vmPageIndexInt0) {
                    dirtyFlags |= 64;
                } else {
                    dirtyFlags |= 32;
                }
            }
            if ((dirtyFlags & 7) != 0) {
                if (vmPageIndexInt2) {
                    dirtyFlags |= 16;
                } else {
                    dirtyFlags |= 8;
                }
            }
            int i = 4;
            vmPageIndexInt0ViewINVISIBLEViewVISIBLE = vmPageIndexInt0 ? 4 : 0;
            if (!vmPageIndexInt2) {
                i = 0;
            }
            vmPageIndexInt2ViewINVISIBLEViewVISIBLE = i;
        }
        if ((4 & dirtyFlags) != 0) {
            this.id6GsLeftBtn.setOnClickListener(this.mCallback582);
            this.id6GsRightBtn.setOnClickListener(this.mCallback583);
        }
        if ((7 & dirtyFlags) != 0) {
            this.id6GsLeftBtn.setVisibility(vmPageIndexInt0ViewINVISIBLEViewVISIBLE);
            this.id6GsMainViewPager.setCurrentItem(vmPageIndexGet);
            this.id6GsRightBtn.setVisibility(vmPageIndexInt2ViewINVISIBLEViewVISIBLE);
        }
    }

    /* JADX INFO: Multiple debug info for r4v1 int: [D('vmPageIndexGet' int), D('vmPageIndexInt1' int)] */
    /* JADX INFO: Multiple debug info for r4v3 int: [D('vmPageIndexGet' int), D('vmPageIndexInt1' int)] */
    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean vmPageIndexJavaLangObjectNull = false;
        switch (sourceId) {
            case 1:
                BmwId6gsViewMode vm = this.mVm;
                if (vm != null) {
                    ObservableInt vmPageIndex = vm.pageIndex;
                    if (vmPageIndex != null) {
                        vmPageIndexJavaLangObjectNull = true;
                    }
                    if (vmPageIndexJavaLangObjectNull) {
                        vm.setCurrentItem(callbackArg_0, vmPageIndex.get() - 1);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                BmwId6gsViewMode vm2 = this.mVm;
                if (vm2 != null) {
                    ObservableInt vmPageIndex2 = vm2.pageIndex;
                    if (vmPageIndex2 != null) {
                        vmPageIndexJavaLangObjectNull = true;
                    }
                    if (vmPageIndexJavaLangObjectNull) {
                        vm2.setCurrentItem(callbackArg_0, vmPageIndex2.get() + 1);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}

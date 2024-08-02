package com.wits.ksw.databinding;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class ActivityEvoid8LauncherMainBindingImpl extends ActivityEvoid8LauncherMainBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(15);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"evoid8_launcher_left_bar"}, new int[]{3}, new int[]{R.layout.evoid8_launcher_left_bar});
        includedLayouts.setIncludes(2, new String[]{"evoid8_launcher_right_bar"}, new int[]{4}, new int[]{R.layout.evoid8_launcher_right_bar});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.scrollView, 5);
        sparseIntArray.put(R.id.ll_container, 6);
        sparseIntArray.put(R.id.fl_content1, 7);
        sparseIntArray.put(R.id.fl_content2, 8);
        sparseIntArray.put(R.id.fl_content3, 9);
        sparseIntArray.put(R.id.fl_content4, 10);
        sparseIntArray.put(R.id.fl_content5, 11);
        sparseIntArray.put(R.id.fl_content6, 12);
        sparseIntArray.put(R.id.fl_content7, 13);
        sparseIntArray.put(R.id.fl_content8, 14);
    }

    public ActivityEvoid8LauncherMainBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private ActivityEvoid8LauncherMainBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (FrameLayout) bindings[7], (FrameLayout) bindings[8], (FrameLayout) bindings[9], (FrameLayout) bindings[10], (FrameLayout) bindings[11], (FrameLayout) bindings[12], (FrameLayout) bindings[13], (FrameLayout) bindings[14], (ConstraintLayout) bindings[0], (LinearLayout) bindings[1], (LinearLayout) bindings[6], (Evoid8LauncherLeftBarBinding) bindings[3], (Evoid8LauncherRightBarBinding) bindings[4], (LinearLayout) bindings[2], (HorizontalScrollView) bindings[5]);
        this.mDirtyFlags = -1;
        this.id8UgMain.setTag(null);
        this.leftLinearLayout.setTag(null);
        setContainedBinding(this.llLeftContainer);
        setContainedBinding(this.llRightContainer);
        this.rightLinearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
        }
        this.llLeftContainer.invalidateAll();
        this.llRightContainer.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r4.llRightContainer.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.llLeftContainer.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    @Override // android.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.mDirtyFlags     // Catch:{ all -> 0x0021 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0021 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0021 }
            com.wits.ksw.databinding.Evoid8LauncherLeftBarBinding r0 = r4.llLeftContainer
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            com.wits.ksw.databinding.Evoid8LauncherRightBarBinding r0 = r4.llRightContainer
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r1
        L_0x001f:
            r0 = 0
            return r0
        L_0x0021:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.databinding.ActivityEvoid8LauncherMainBindingImpl.hasPendingBindings():boolean");
    }

    @Override // android.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (13 != variableId) {
            return false;
        }
        setLauncherViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityEvoid8LauncherMainBinding
    public void setLauncherViewModel(LauncherViewModel LauncherViewModel) {
        this.mLauncherViewModel = LauncherViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    @Override // android.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.llLeftContainer.setLifecycleOwner(lifecycleOwner);
        this.llRightContainer.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeLlLeftContainer((Evoid8LauncherLeftBarBinding) object, fieldId);
            case 1:
                return onChangeLlRightContainer((Evoid8LauncherRightBarBinding) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeLlLeftContainer(Evoid8LauncherLeftBarBinding LlLeftContainer, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeLlRightContainer(Evoid8LauncherRightBarBinding LlRightContainer, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
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
        LauncherViewModel launcherViewModel = this.mLauncherViewModel;
        if ((12 & dirtyFlags) != 0) {
            this.llLeftContainer.setLeftViewModel(launcherViewModel);
            this.llRightContainer.setLeftViewModel(launcherViewModel);
        }
        executeBindingsOn(this.llLeftContainer);
        executeBindingsOn(this.llRightContainer);
    }
}

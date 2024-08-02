package com.wits.ksw.databinding;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.base.BaseBindingModel;
import com.wits.ksw.launcher.base.BaseListAdpater;
import com.wits.ksw.launcher.bean.AppInfo;
import com.wits.ksw.launcher.model.AppViewModel;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.CustomGridView;
import com.wits.ksw.launcher.view.DragGridView;

public class ActivityEvoid8AppsBindingImpl extends ActivityEvoid8AppsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"evoid8_app_left_bar"}, new int[]{4}, new int[]{R.layout.evoid8_app_left_bar});
        includedLayouts.setIncludes(2, new String[]{"evoid8_app_right_bar"}, new int[]{5}, new int[]{R.layout.evoid8_app_right_bar});
    }

    public ActivityEvoid8AppsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private ActivityEvoid8AppsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (CustomGridView) bindings[3], (ConstraintLayout) bindings[0], (LinearLayout) bindings[1], (Evoid8AppLeftBarBinding) bindings[4], (Evoid8AppRightBarBinding) bindings[5], (LinearLayout) bindings[2]);
        this.mDirtyFlags = -1;
        this.appGridView.setTag(null);
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
            this.mDirtyFlags = 32;
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
            com.wits.ksw.databinding.Evoid8AppLeftBarBinding r0 = r4.llLeftContainer
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            com.wits.ksw.databinding.Evoid8AppRightBarBinding r0 = r4.llRightContainer
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
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.databinding.ActivityEvoid8AppsBindingImpl.hasPendingBindings():boolean");
    }

    @Override // android.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (2 == variableId) {
            setAppViewModel((AppViewModel) variable);
            return true;
        } else if (13 != variableId) {
            return false;
        } else {
            setLauncherViewModel((LauncherViewModel) variable);
            return true;
        }
    }

    @Override // com.wits.ksw.databinding.ActivityEvoid8AppsBinding
    public void setAppViewModel(AppViewModel AppViewModel) {
        this.mAppViewModel = AppViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // com.wits.ksw.databinding.ActivityEvoid8AppsBinding
    public void setLauncherViewModel(LauncherViewModel LauncherViewModel) {
        this.mLauncherViewModel = LauncherViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
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
                return onChangeLlLeftContainer((Evoid8AppLeftBarBinding) object, fieldId);
            case 1:
                return onChangeLlRightContainer((Evoid8AppRightBarBinding) object, fieldId);
            case 2:
                return onChangeAppViewModelListAdpater((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeLlLeftContainer(Evoid8AppLeftBarBinding LlLeftContainer, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeLlRightContainer(Evoid8AppRightBarBinding LlRightContainer, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeAppViewModelListAdpater(ObservableField<BaseListAdpater<AppInfo>> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
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
        BaseListAdpater<AppInfo> appViewModelListAdpaterGet = null;
        AppViewModel appViewModel = this.mAppViewModel;
        AdapterView.OnItemLongClickListener appViewModelOnItemLongClickListener = null;
        LauncherViewModel launcherViewModel = this.mLauncherViewModel;
        DragGridView.onItemChangerListener appViewModelOnItemChangerListener = null;
        AdapterView.OnItemClickListener appViewModelOnItemClickListener = null;
        ObservableField<BaseListAdpater<AppInfo>> appViewModelListAdpater = null;
        if ((dirtyFlags & 44) != 0) {
            if (!((dirtyFlags & 40) == 0 || appViewModel == null)) {
                appViewModelOnItemLongClickListener = appViewModel.onItemLongClickListener;
                appViewModelOnItemChangerListener = appViewModel.onItemChangerListener;
                appViewModelOnItemClickListener = appViewModel.onItemClickListener;
            }
            if (appViewModel != null) {
                appViewModelListAdpater = appViewModel.listAdpater;
            }
            updateRegistration(2, appViewModelListAdpater);
            if (appViewModelListAdpater != null) {
                appViewModelListAdpaterGet = appViewModelListAdpater.get();
            }
        }
        if ((44 & dirtyFlags) != 0) {
            BaseBindingModel.setAdpater(this.appGridView, appViewModelListAdpaterGet);
        }
        if ((dirtyFlags & 40) != 0) {
            BaseBindingModel.setOnItemChangerListener(this.appGridView, appViewModelOnItemChangerListener);
            this.appGridView.setOnItemClickListener(appViewModelOnItemClickListener);
            this.appGridView.setOnItemLongClickListener(appViewModelOnItemLongClickListener);
        }
        if ((48 & dirtyFlags) != 0) {
            this.llLeftContainer.setLeftViewModel(launcherViewModel);
            this.llRightContainer.setLeftViewModel(launcherViewModel);
        }
        executeBindingsOn(this.llLeftContainer);
        executeBindingsOn(this.llRightContainer);
    }
}

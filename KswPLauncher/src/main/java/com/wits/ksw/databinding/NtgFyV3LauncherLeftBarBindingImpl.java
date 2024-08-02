package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel;

public class NtgFyV3LauncherLeftBarBindingImpl extends NtgFyV3LauncherLeftBarBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback101;
    private final View.OnClickListener mCallback102;
    private final View.OnClickListener mCallback103;
    private final View.OnClickListener mCallback104;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_left_1, 5);
        sparseIntArray.put(R.id.iv_left_2, 6);
        sparseIntArray.put(R.id.iv_left_3, 7);
        sparseIntArray.put(R.id.iv_left_4, 8);
    }

    public NtgFyV3LauncherLeftBarBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private NtgFyV3LauncherLeftBarBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (ImageView) bindings[5], (ImageView) bindings[6], (ImageView) bindings[7], (ImageView) bindings[8], (LinearLayout) bindings[1], (LinearLayout) bindings[2], (LinearLayout) bindings[3], (LinearLayout) bindings[4], (LinearLayout) bindings[0]);
        this.mDirtyFlags = -1;
        this.llLeft1.setTag(null);
        this.llLeft2.setTag(null);
        this.llLeft3.setTag(null);
        this.llLeft4.setTag(null);
        this.llLeftBarContainer.setTag(null);
        setRootTag(root);
        this.mCallback104 = new OnClickListener(this, 4);
        this.mCallback102 = new OnClickListener(this, 2);
        this.mCallback103 = new OnClickListener(this, 3);
        this.mCallback101 = new OnClickListener(this, 1);
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
        if (14 != variableId) {
            return false;
        }
        setLeftViewModel((Ntg6v3LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.NtgFyV3LauncherLeftBarBinding
    public void setLeftViewModel(Ntg6v3LauncherViewModel LeftViewModel) {
        this.mLeftViewModel = LeftViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeLeftViewModelNtg6v3MainThemeMode((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeLeftViewModelNtg6v3MainThemeMode(ObservableInt LeftViewModelNtg6v3MainThemeMode, int fieldId) {
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
        int leftViewModelNtg6v3MainThemeModeGet = 0;
        Ntg6v3LauncherViewModel ntg6v3LauncherViewModel = this.mLeftViewModel;
        if ((dirtyFlags & 5) != 0) {
            ObservableInt leftViewModelNtg6v3MainThemeMode = Ntg6v3LauncherViewModel.ntg6v3MainThemeMode;
            updateRegistration(0, leftViewModelNtg6v3MainThemeMode);
            if (leftViewModelNtg6v3MainThemeMode != null) {
                leftViewModelNtg6v3MainThemeModeGet = leftViewModelNtg6v3MainThemeMode.get();
            }
        }
        if ((4 & dirtyFlags) != 0) {
            this.llLeft1.setOnClickListener(this.mCallback101);
            this.llLeft2.setOnClickListener(this.mCallback102);
            this.llLeft3.setOnClickListener(this.mCallback103);
            this.llLeft4.setOnClickListener(this.mCallback104);
        }
        if ((5 & dirtyFlags) != 0) {
            Ntg6v3LauncherViewModel.setNtg6v3MainLeftItemBg(this.llLeft1, leftViewModelNtg6v3MainThemeModeGet);
            Ntg6v3LauncherViewModel.setNtg6v3MainLeftItemBg(this.llLeft2, leftViewModelNtg6v3MainThemeModeGet);
            Ntg6v3LauncherViewModel.setNtg6v3MainLeftItemBg(this.llLeft3, leftViewModelNtg6v3MainThemeModeGet);
            Ntg6v3LauncherViewModel.setNtg6v3MainLeftItemBg(this.llLeft4, leftViewModelNtg6v3MainThemeModeGet);
            Ntg6v3LauncherViewModel.setNtg6v3MainLeftBg(this.llLeftBarContainer, leftViewModelNtg6v3MainThemeModeGet);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean leftViewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                Ntg6v3LauncherViewModel leftViewModel = this.mLeftViewModel;
                if (leftViewModel == null) {
                    leftViewModelJavaLangObjectNull = false;
                }
                if (leftViewModelJavaLangObjectNull) {
                    leftViewModel.openNaviApp(callbackArg_0);
                    return;
                }
                return;
            case 2:
                Ntg6v3LauncherViewModel leftViewModel2 = this.mLeftViewModel;
                if (leftViewModel2 == null) {
                    leftViewModelJavaLangObjectNull = false;
                }
                if (leftViewModelJavaLangObjectNull) {
                    leftViewModel2.setAllAppShow(callbackArg_0);
                    return;
                }
                return;
            case 3:
                Ntg6v3LauncherViewModel leftViewModel3 = this.mLeftViewModel;
                if (leftViewModel3 == null) {
                    leftViewModelJavaLangObjectNull = false;
                }
                if (leftViewModelJavaLangObjectNull) {
                    leftViewModel3.openMusicMulti(callbackArg_0);
                    return;
                }
                return;
            case 4:
                Ntg6v3LauncherViewModel leftViewModel4 = this.mLeftViewModel;
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

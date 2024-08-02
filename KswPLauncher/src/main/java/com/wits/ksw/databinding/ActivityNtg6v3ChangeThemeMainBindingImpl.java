package com.wits.ksw.databinding;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ViewDataBinding;
import android.support.v4.view.ViewPager;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3ThemeChangeViewModel;

public class ActivityNtg6v3ChangeThemeMainBindingImpl extends ActivityNtg6v3ChangeThemeMainBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback221;
    private final View.OnClickListener mCallback222;
    private long mDirtyFlags;
    private final RelativeLayout mboundView1;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(10);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"ntg6v3_change_wallpaper_item"}, new int[]{6}, new int[]{R.layout.ntg6v3_change_wallpaper_item});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_ll, 7);
        sparseIntArray.put(R.id.pageTv1, 8);
        sparseIntArray.put(R.id.pageTv2, 9);
    }

    public ActivityNtg6v3ChangeThemeMainBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private ActivityNtg6v3ChangeThemeMainBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (LinearLayout) bindings[4], (RelativeLayout) bindings[0], (TextView) bindings[8], (TextView) bindings[9], (TextView) bindings[2], (ViewPager) bindings[5], (LinearLayout) bindings[7], (TextView) bindings[3], (Ntg6v3ChangeWallpaperItemBinding) bindings[6]);
        this.mDirtyFlags = -1;
        this.indicatorLl.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[1];
        this.mboundView1 = relativeLayout;
        relativeLayout.setTag(null);
        this.ntg6v3ChangeThemeMainBg.setTag(null);
        this.themeChangeTv.setTag(null);
        this.themeViewPager.setTag(null);
        this.wallpaperChangeTv.setTag(null);
        setContainedBinding(this.wallpaperIncludeView);
        setRootTag(root);
        this.mCallback221 = new OnClickListener(this, 1);
        this.mCallback222 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
        }
        this.wallpaperIncludeView.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.wallpaperIncludeView.hasPendingBindings() == false) goto L_0x0016;
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
            long r0 = r4.mDirtyFlags     // Catch:{ all -> 0x0018 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            com.wits.ksw.databinding.Ntg6v3ChangeWallpaperItemBinding r0 = r4.wallpaperIncludeView
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.databinding.ActivityNtg6v3ChangeThemeMainBindingImpl.hasPendingBindings():boolean");
    }

    @Override // android.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (23 != variableId) {
            return false;
        }
        setThemeViewModel((Ntg6v3ThemeChangeViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityNtg6v3ChangeThemeMainBinding
    public void setThemeViewModel(Ntg6v3ThemeChangeViewModel ThemeViewModel) {
        this.mThemeViewModel = ThemeViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(23);
        super.requestRebind();
    }

    @Override // android.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.wallpaperIncludeView.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeWallpaperIncludeView((Ntg6v3ChangeWallpaperItemBinding) object, fieldId);
            case 1:
                return onChangeThemeViewModelIsThemeModeSelect((ObservableBoolean) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeWallpaperIncludeView(Ntg6v3ChangeWallpaperItemBinding WallpaperIncludeView, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeThemeViewModelIsThemeModeSelect(ObservableBoolean ThemeViewModelIsThemeModeSelect, int fieldId) {
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
        Ntg6v3ThemeChangeViewModel themeViewModel = this.mThemeViewModel;
        int themeViewModelIsThemeModeSelectViewVISIBLEViewGONE = 0;
        boolean themeViewModelIsThemeModeSelectGet = false;
        int themeViewModelIsThemeModeSelectViewGONEViewVISIBLE = 0;
        boolean ThemeViewModelIsThemeModeSelect1 = false;
        if ((dirtyFlags & 10) != 0) {
            ObservableBoolean themeViewModelIsThemeModeSelect = Ntg6v3ThemeChangeViewModel.isThemeModeSelect;
            updateRegistration(1, themeViewModelIsThemeModeSelect);
            if (themeViewModelIsThemeModeSelect != null) {
                themeViewModelIsThemeModeSelectGet = themeViewModelIsThemeModeSelect.get();
            }
            if ((dirtyFlags & 10) != 0) {
                if (themeViewModelIsThemeModeSelectGet) {
                    dirtyFlags = dirtyFlags | 32 | 128;
                } else {
                    dirtyFlags = dirtyFlags | 16 | 64;
                }
            }
            int i = 0;
            themeViewModelIsThemeModeSelectViewVISIBLEViewGONE = themeViewModelIsThemeModeSelectGet ? 0 : 8;
            if (themeViewModelIsThemeModeSelectGet) {
                i = 8;
            }
            themeViewModelIsThemeModeSelectViewGONEViewVISIBLE = i;
            ThemeViewModelIsThemeModeSelect1 = !themeViewModelIsThemeModeSelectGet;
        }
        if ((10 & dirtyFlags) != 0) {
            this.indicatorLl.setVisibility(themeViewModelIsThemeModeSelectViewVISIBLEViewGONE);
            Ntg6v3ThemeChangeViewModel.setThemeTitleViewSelect(this.themeChangeTv, themeViewModelIsThemeModeSelectGet);
            this.themeViewPager.setVisibility(themeViewModelIsThemeModeSelectViewVISIBLEViewGONE);
            Ntg6v3ThemeChangeViewModel.setThemeTitleViewSelect(this.wallpaperChangeTv, ThemeViewModelIsThemeModeSelect1);
            this.wallpaperIncludeView.getRoot().setVisibility(themeViewModelIsThemeModeSelectViewGONEViewVISIBLE);
        }
        if ((8 & dirtyFlags) != 0) {
            this.themeChangeTv.setOnClickListener(this.mCallback221);
            this.wallpaperChangeTv.setOnClickListener(this.mCallback222);
        }
        if ((12 & dirtyFlags) != 0) {
            this.wallpaperIncludeView.setThemeWallpaperViewModel(themeViewModel);
        }
        executeBindingsOn(this.wallpaperIncludeView);
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean themeViewModelJavaLangObjectNull = true;
        boolean themeViewModelJavaLangObjectNull2 = false;
        switch (sourceId) {
            case 1:
                Ntg6v3ThemeChangeViewModel themeViewModel = this.mThemeViewModel;
                if (themeViewModel != null) {
                    themeViewModelJavaLangObjectNull2 = true;
                }
                if (themeViewModelJavaLangObjectNull2) {
                    themeViewModel.onNtg6v3ThemeSelectClick(callbackArg_0, true);
                    return;
                }
                return;
            case 2:
                Ntg6v3ThemeChangeViewModel themeViewModel2 = this.mThemeViewModel;
                if (themeViewModel2 == null) {
                    themeViewModelJavaLangObjectNull = false;
                }
                if (themeViewModelJavaLangObjectNull) {
                    themeViewModel2.onNtg6v3ThemeSelectClick(callbackArg_0, false);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

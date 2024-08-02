package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.utils.Constants;
import com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3ThemeChangeViewModel;

public class Ntg6v3ChangeWallpaperItemBindingImpl extends Ntg6v3ChangeWallpaperItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback100;
    private final View.OnClickListener mCallback98;
    private final View.OnClickListener mCallback99;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ImageView mboundView2;
    private final ImageView mboundView4;
    private final ImageView mboundView6;

    public Ntg6v3ChangeWallpaperItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    private Ntg6v3ChangeWallpaperItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (ImageView) bindings[5], (ImageView) bindings[3], (ImageView) bindings[1]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[4];
        this.mboundView4 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[6];
        this.mboundView6 = imageView3;
        imageView3.setTag(null);
        this.wallpaperCustomIv.setTag(null);
        this.wallpaperMapIv.setTag(null);
        this.wallpaperNormalIv.setTag(null);
        setRootTag(root);
        this.mCallback98 = new OnClickListener(this, 1);
        this.mCallback100 = new OnClickListener(this, 3);
        this.mCallback99 = new OnClickListener(this, 2);
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
        if (24 != variableId) {
            return false;
        }
        setThemeWallpaperViewModel((Ntg6v3ThemeChangeViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.Ntg6v3ChangeWallpaperItemBinding
    public void setThemeWallpaperViewModel(Ntg6v3ThemeChangeViewModel ThemeWallpaperViewModel) {
        this.mThemeWallpaperViewModel = ThemeWallpaperViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(24);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeThemeWallpaperViewModelNtg6v3ChangeWallpaperMode((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeThemeWallpaperViewModelNtg6v3ChangeWallpaperMode(ObservableInt ThemeWallpaperViewModelNtg6v3ChangeWallpaperMode, int fieldId) {
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
        int themeWallpaperViewModelNtg6v3ChangeWallpaperModeGet;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        int themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELNORMALViewVISIBLEViewGONE = 0;
        int themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELMAPViewVISIBLEViewGONE = 0;
        int themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELCUSTOMViewVISIBLEViewGONE = 0;
        Ntg6v3ThemeChangeViewModel ntg6v3ThemeChangeViewModel = this.mThemeWallpaperViewModel;
        if ((dirtyFlags & 5) != 0) {
            int constantsNTG6V3THEMEWALLPAPERMODELCUSTOM = Constants.NTG6V3_THEME_WALLPAPER_MODEL_CUSTOM;
            int constantsNTG6V3THEMEWALLPAPERMODELMAP = Constants.NTG6V3_THEME_WALLPAPER_MODEL_MAP;
            ObservableInt themeWallpaperViewModelNtg6v3ChangeWallpaperMode = Ntg6v3ThemeChangeViewModel.ntg6v3ChangeWallpaperMode;
            int constantsNTG6V3THEMEWALLPAPERMODELNORMAL = Constants.NTG6V3_THEME_WALLPAPER_MODEL_NORMAL;
            int i = 0;
            updateRegistration(0, themeWallpaperViewModelNtg6v3ChangeWallpaperMode);
            if (themeWallpaperViewModelNtg6v3ChangeWallpaperMode != null) {
                themeWallpaperViewModelNtg6v3ChangeWallpaperModeGet = themeWallpaperViewModelNtg6v3ChangeWallpaperMode.get();
            } else {
                themeWallpaperViewModelNtg6v3ChangeWallpaperModeGet = 0;
            }
            boolean themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELNORMAL = true;
            boolean themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELCUSTOM = themeWallpaperViewModelNtg6v3ChangeWallpaperModeGet == constantsNTG6V3THEMEWALLPAPERMODELCUSTOM;
            boolean themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELMAP = themeWallpaperViewModelNtg6v3ChangeWallpaperModeGet == constantsNTG6V3THEMEWALLPAPERMODELMAP;
            if (themeWallpaperViewModelNtg6v3ChangeWallpaperModeGet != constantsNTG6V3THEMEWALLPAPERMODELNORMAL) {
                themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELNORMAL = false;
            }
            if ((dirtyFlags & 5) != 0) {
                if (themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELCUSTOM) {
                    dirtyFlags |= 256;
                } else {
                    dirtyFlags |= 128;
                }
            }
            if ((dirtyFlags & 5) != 0) {
                if (themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELMAP) {
                    dirtyFlags |= 64;
                } else {
                    dirtyFlags |= 32;
                }
            }
            if ((dirtyFlags & 5) != 0) {
                if (themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELNORMAL) {
                    dirtyFlags |= 16;
                } else {
                    dirtyFlags |= 8;
                }
            }
            themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELCUSTOMViewVISIBLEViewGONE = themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELCUSTOM ? 0 : 8;
            themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELMAPViewVISIBLEViewGONE = themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELMAP ? 0 : 8;
            if (!themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELNORMAL) {
                i = 8;
            }
            themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELNORMALViewVISIBLEViewGONE = i;
        }
        if ((dirtyFlags & 5) != 0) {
            this.mboundView2.setVisibility(themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELNORMALViewVISIBLEViewGONE);
            this.mboundView4.setVisibility(themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELMAPViewVISIBLEViewGONE);
            this.mboundView6.setVisibility(themeWallpaperViewModelNtg6v3ChangeWallpaperModeConstantsNTG6V3THEMEWALLPAPERMODELCUSTOMViewVISIBLEViewGONE);
        }
        if ((4 & dirtyFlags) != 0) {
            this.wallpaperCustomIv.setOnClickListener(this.mCallback100);
            this.wallpaperMapIv.setOnClickListener(this.mCallback99);
            this.wallpaperNormalIv.setOnClickListener(this.mCallback98);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean themeWallpaperViewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                Ntg6v3ThemeChangeViewModel themeWallpaperViewModel = this.mThemeWallpaperViewModel;
                if (themeWallpaperViewModel == null) {
                    themeWallpaperViewModelJavaLangObjectNull = false;
                }
                if (themeWallpaperViewModelJavaLangObjectNull) {
                    themeWallpaperViewModel.onWallpaperNormalIvClick(callbackArg_0);
                    return;
                }
                return;
            case 2:
                Ntg6v3ThemeChangeViewModel themeWallpaperViewModel2 = this.mThemeWallpaperViewModel;
                if (themeWallpaperViewModel2 == null) {
                    themeWallpaperViewModelJavaLangObjectNull = false;
                }
                if (themeWallpaperViewModelJavaLangObjectNull) {
                    themeWallpaperViewModel2.onWallpaperMapIvClick(callbackArg_0);
                    return;
                }
                return;
            case 3:
                Ntg6v3ThemeChangeViewModel themeWallpaperViewModel3 = this.mThemeWallpaperViewModel;
                if (themeWallpaperViewModel3 == null) {
                    themeWallpaperViewModelJavaLangObjectNull = false;
                }
                if (themeWallpaperViewModelJavaLangObjectNull) {
                    themeWallpaperViewModel3.onWallpaperCustomIvClick(callbackArg_0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

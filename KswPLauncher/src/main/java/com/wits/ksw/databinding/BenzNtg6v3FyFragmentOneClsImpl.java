package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.utils.Constants;
import com.wits.ksw.launcher.view.benzntg6fy.Ntg6v3ThemeChangeViewModel;

public class BenzNtg6v3FyFragmentOneClsImpl extends BenzNtg6v3FyFragmentOneCls {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ImageView mboundView1;
    private final ImageView mboundView2;
    private final ImageView mboundView3;
    private final ImageView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ntg6v3Item1_1, 5);
        sparseIntArray.put(R.id.ntg6v3Item1_2, 6);
        sparseIntArray.put(R.id.ntg6v3Item1_3, 7);
        sparseIntArray.put(R.id.ntg6v3Item1_4, 8);
    }

    public BenzNtg6v3FyFragmentOneClsImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private BenzNtg6v3FyFragmentOneClsImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (ImageView) bindings[5], (ImageView) bindings[6], (ImageView) bindings[7], (ImageView) bindings[8]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[2];
        this.mboundView2 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[3];
        this.mboundView3 = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) bindings[4];
        this.mboundView4 = imageView4;
        imageView4.setTag(null);
        setRootTag(root);
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
        if (23 != variableId) {
            return false;
        }
        setThemeViewModel((Ntg6v3ThemeChangeViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.BenzNtg6v3FyFragmentOneCls
    public void setThemeViewModel(Ntg6v3ThemeChangeViewModel ThemeViewModel) {
        this.mThemeViewModel = ThemeViewModel;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeThemeViewModelNtg6v3ChangeThemeMode((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeThemeViewModelNtg6v3ChangeThemeMode(ObservableInt ThemeViewModelNtg6v3ChangeThemeMode, int fieldId) {
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
        int constantsNTG6V3THEMECOLORGAY;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        int themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORBLUELIGHTViewVISIBLEViewGONE = 0;
        int themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORBLUEViewVISIBLEViewGONE = 0;
        int themeViewModelNtg6v3ChangeThemeModeGet = 0;
        int themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORORANGEViewVISIBLEViewGONE = 0;
        if ((dirtyFlags & 5) != 0) {
            ObservableInt themeViewModelNtg6v3ChangeThemeMode = Ntg6v3ThemeChangeViewModel.ntg6v3ChangeThemeMode;
            int constantsNTG6V3THEMECOLORBLUE = Constants.NTG6V3_THEME_COLOR_BLUE;
            int constantsNTG6V3THEMECOLORORANGE = Constants.NTG6V3_THEME_COLOR_ORANGE;
            int constantsNTG6V3THEMECOLORGAY2 = Constants.NTG6V3_THEME_COLOR_GAY;
            int constantsNTG6V3THEMECOLORBLUELIGHT = Constants.NTG6V3_THEME_COLOR_BLUE_LIGHT;
            int themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORGAYViewVISIBLEViewGONE = 0;
            updateRegistration(0, themeViewModelNtg6v3ChangeThemeMode);
            if (themeViewModelNtg6v3ChangeThemeMode != null) {
                themeViewModelNtg6v3ChangeThemeModeGet = themeViewModelNtg6v3ChangeThemeMode.get();
            }
            boolean themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORGAY = true;
            boolean themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORORANGE = themeViewModelNtg6v3ChangeThemeModeGet == constantsNTG6V3THEMECOLORORANGE;
            boolean themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORBLUELIGHT = themeViewModelNtg6v3ChangeThemeModeGet == constantsNTG6V3THEMECOLORBLUELIGHT;
            boolean themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORBLUE = themeViewModelNtg6v3ChangeThemeModeGet == constantsNTG6V3THEMECOLORBLUE;
            if (themeViewModelNtg6v3ChangeThemeModeGet != constantsNTG6V3THEMECOLORGAY2) {
                themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORGAY = false;
            }
            if ((dirtyFlags & 5) != 0) {
                if (themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORORANGE) {
                    dirtyFlags |= 256;
                } else {
                    dirtyFlags |= 128;
                }
            }
            if ((dirtyFlags & 5) != 0) {
                if (themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORBLUELIGHT) {
                    dirtyFlags |= 16;
                } else {
                    dirtyFlags |= 8;
                }
            }
            if ((dirtyFlags & 5) != 0) {
                if (themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORBLUE) {
                    dirtyFlags |= 64;
                } else {
                    dirtyFlags |= 32;
                }
            }
            if ((dirtyFlags & 5) != 0) {
                if (themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORGAY) {
                    dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                } else {
                    dirtyFlags |= 512;
                }
            }
            themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORORANGEViewVISIBLEViewGONE = themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORORANGE ? 0 : 8;
            themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORBLUELIGHTViewVISIBLEViewGONE = themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORBLUELIGHT ? 0 : 8;
            themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORBLUEViewVISIBLEViewGONE = themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORBLUE ? 0 : 8;
            if (!themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORGAY) {
                themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORGAYViewVISIBLEViewGONE = 8;
            }
            constantsNTG6V3THEMECOLORGAY = themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORGAYViewVISIBLEViewGONE;
        } else {
            constantsNTG6V3THEMECOLORGAY = 0;
        }
        if ((dirtyFlags & 5) != 0) {
            this.mboundView1.setVisibility(themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORBLUEViewVISIBLEViewGONE);
            this.mboundView2.setVisibility(themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORBLUELIGHTViewVISIBLEViewGONE);
            this.mboundView3.setVisibility(constantsNTG6V3THEMECOLORGAY);
            this.mboundView4.setVisibility(themeViewModelNtg6v3ChangeThemeModeConstantsNTG6V3THEMECOLORORANGEViewVISIBLEViewGONE);
        }
    }
}

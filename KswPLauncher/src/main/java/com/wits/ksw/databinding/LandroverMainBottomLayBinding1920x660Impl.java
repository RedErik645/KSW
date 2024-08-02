package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.land_rover.model.LandroverViewModel;

public class LandroverMainBottomLayBinding1920x660Impl extends LandroverMainBottomLayBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback140;
    private final View.OnClickListener mCallback141;
    private final View.OnClickListener mCallback142;
    private final View.OnClickListener mCallback143;
    private final View.OnClickListener mCallback144;
    private final View.OnClickListener mCallback145;
    private final View.OnClickListener mCallback146;
    private final View.OnClickListener mCallback147;
    private final View.OnClickListener mCallback148;
    private final View.OnClickListener mCallback149;
    private final View.OnClickListener mCallback150;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    public LandroverMainBottomLayBinding1920x660Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private LandroverMainBottomLayBinding1920x660Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[8], (ImageView) bindings[6], (ImageView) bindings[4], (ImageView) bindings[5], (ImageView) bindings[2], (ImageView) bindings[11], (ImageView) bindings[10], (ImageView) bindings[9], (ImageView) bindings[1], (ImageView) bindings[3], (ImageView) bindings[7]);
        this.mDirtyFlags = -1;
        this.landroverMainBottomAirBtn.setTag(null);
        this.landroverMainBottomBtBtn.setTag(null);
        this.landroverMainBottomDvrBtn.setTag(null);
        this.landroverMainBottomGpsBtn.setTag(null);
        this.landroverMainBottomMenuBtn.setTag(null);
        this.landroverMainBottomOffBtn.setTag(null);
        this.landroverMainBottomParkassistBtn.setTag(null);
        this.landroverMainBottomRadarBtn.setTag(null);
        this.landroverMainBottomReturnBtn.setTag(null);
        this.landroverMainBottomSetupBtn.setTag(null);
        this.landroverMainBottomVideoBtn.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(root);
        this.mCallback148 = new OnClickListener(this, 9);
        this.mCallback146 = new OnClickListener(this, 7);
        this.mCallback144 = new OnClickListener(this, 5);
        this.mCallback142 = new OnClickListener(this, 3);
        this.mCallback140 = new OnClickListener(this, 1);
        this.mCallback150 = new OnClickListener(this, 11);
        this.mCallback149 = new OnClickListener(this, 10);
        this.mCallback147 = new OnClickListener(this, 8);
        this.mCallback145 = new OnClickListener(this, 6);
        this.mCallback143 = new OnClickListener(this, 4);
        this.mCallback141 = new OnClickListener(this, 2);
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
        if (13 != variableId) {
            return false;
        }
        setLauncherViewModel((LandroverViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.LandroverMainBottomLayBinding
    public void setLauncherViewModel(LandroverViewModel LauncherViewModel) {
        this.mLauncherViewModel = LauncherViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(13);
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
        LandroverViewModel landroverViewModel = this.mLauncherViewModel;
        if ((2 & dirtyFlags) != 0) {
            this.landroverMainBottomAirBtn.setOnClickListener(this.mCallback147);
            this.landroverMainBottomBtBtn.setOnClickListener(this.mCallback145);
            this.landroverMainBottomDvrBtn.setOnClickListener(this.mCallback143);
            this.landroverMainBottomGpsBtn.setOnClickListener(this.mCallback144);
            this.landroverMainBottomMenuBtn.setOnClickListener(this.mCallback141);
            this.landroverMainBottomOffBtn.setOnClickListener(this.mCallback150);
            this.landroverMainBottomParkassistBtn.setOnClickListener(this.mCallback149);
            this.landroverMainBottomRadarBtn.setOnClickListener(this.mCallback148);
            this.landroverMainBottomReturnBtn.setOnClickListener(this.mCallback140);
            this.landroverMainBottomSetupBtn.setOnClickListener(this.mCallback142);
            this.landroverMainBottomVideoBtn.setOnClickListener(this.mCallback146);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean launcherViewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                LandroverViewModel launcherViewModel = this.mLauncherViewModel;
                if (launcherViewModel == null) {
                    launcherViewModelJavaLangObjectNull = false;
                }
                if (launcherViewModelJavaLangObjectNull) {
                    launcherViewModel.backKeyClick();
                    return;
                }
                return;
            case 2:
                LandroverViewModel launcherViewModel2 = this.mLauncherViewModel;
                if (launcherViewModel2 == null) {
                    launcherViewModelJavaLangObjectNull = false;
                }
                if (launcherViewModelJavaLangObjectNull) {
                    launcherViewModel2.homeKeyClick();
                    return;
                }
                return;
            case 3:
                LandroverViewModel launcherViewModel3 = this.mLauncherViewModel;
                if (launcherViewModel3 == null) {
                    launcherViewModelJavaLangObjectNull = false;
                }
                if (launcherViewModelJavaLangObjectNull) {
                    launcherViewModel3.openSettings(callbackArg_0);
                    return;
                }
                return;
            case 4:
                LandroverViewModel launcherViewModel4 = this.mLauncherViewModel;
                if (launcherViewModel4 == null) {
                    launcherViewModelJavaLangObjectNull = false;
                }
                if (launcherViewModelJavaLangObjectNull) {
                    launcherViewModel4.openDvr();
                    return;
                }
                return;
            case 5:
                LandroverViewModel launcherViewModel5 = this.mLauncherViewModel;
                if (launcherViewModel5 == null) {
                    launcherViewModelJavaLangObjectNull = false;
                }
                if (launcherViewModelJavaLangObjectNull) {
                    launcherViewModel5.openNaviApp();
                    return;
                }
                return;
            case 6:
                LandroverViewModel launcherViewModel6 = this.mLauncherViewModel;
                if (launcherViewModel6 == null) {
                    launcherViewModelJavaLangObjectNull = false;
                }
                if (launcherViewModelJavaLangObjectNull) {
                    launcherViewModel6.openBtApp();
                    return;
                }
                return;
            case 7:
                LandroverViewModel launcherViewModel7 = this.mLauncherViewModel;
                if (launcherViewModel7 == null) {
                    launcherViewModelJavaLangObjectNull = false;
                }
                if (launcherViewModelJavaLangObjectNull) {
                    launcherViewModel7.openVideo();
                    return;
                }
                return;
            case 8:
                LandroverViewModel launcherViewModel8 = this.mLauncherViewModel;
                if (launcherViewModel8 == null) {
                    launcherViewModelJavaLangObjectNull = false;
                }
                if (launcherViewModelJavaLangObjectNull) {
                    launcherViewModel8.airClick();
                    return;
                }
                return;
            case 9:
                LandroverViewModel launcherViewModel9 = this.mLauncherViewModel;
                if (launcherViewModel9 == null) {
                    launcherViewModelJavaLangObjectNull = false;
                }
                if (launcherViewModelJavaLangObjectNull) {
                    launcherViewModel9.radarClick();
                    return;
                }
                return;
            case 10:
                LandroverViewModel launcherViewModel10 = this.mLauncherViewModel;
                if (launcherViewModel10 == null) {
                    launcherViewModelJavaLangObjectNull = false;
                }
                if (launcherViewModelJavaLangObjectNull) {
                    launcherViewModel10.parkClick();
                    return;
                }
                return;
            case 11:
                LandroverViewModel launcherViewModel11 = this.mLauncherViewModel;
                if (launcherViewModel11 == null) {
                    launcherViewModelJavaLangObjectNull = false;
                }
                if (launcherViewModelJavaLangObjectNull) {
                    launcherViewModel11.screenOff();
                    return;
                }
                return;
            default:
                return;
        }
    }
}

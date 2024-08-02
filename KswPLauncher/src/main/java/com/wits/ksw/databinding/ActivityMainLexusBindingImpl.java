package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class ActivityMainLexusBindingImpl extends ActivityMainLexusBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback171;
    private final View.OnClickListener mCallback172;
    private final View.OnClickListener mCallback173;
    private final View.OnClickListener mCallback174;
    private final View.OnClickListener mCallback175;
    private final View.OnClickListener mCallback176;
    private final View.OnClickListener mCallback177;
    private final View.OnClickListener mCallback178;
    private final View.OnClickListener mCallback179;
    private final View.OnClickListener mCallback180;
    private final View.OnClickListener mCallback181;
    private final View.OnClickListener mCallback182;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.lexus_main_sv, 13);
        sparseIntArray.put(R.id.id_gallery, 14);
        sparseIntArray.put(R.id.main_menu, 15);
    }

    public ActivityMainLexusBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private ActivityMainLexusBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (LinearLayout) bindings[14], (Button) bindings[12], (Button) bindings[11], (Button) bindings[10], (Button) bindings[4], (Button) bindings[5], (Button) bindings[9], (Button) bindings[6], (Button) bindings[3], (Button) bindings[1], (Button) bindings[2], (Button) bindings[7], (Button) bindings[8], (HorizontalScrollView) bindings[13], (LinearLayout) bindings[15]);
        this.mDirtyFlags = -1;
        this.lexusAir.setTag(null);
        this.lexusBtApp.setTag(null);
        this.lexusBtCar.setTag(null);
        this.lexusBtDash.setTag(null);
        this.lexusBtDvr.setTag(null);
        this.lexusBtFile.setTag(null);
        this.lexusBtLink.setTag(null);
        this.lexusBtMusic.setTag(null);
        this.lexusBtNavi.setTag(null);
        this.lexusBtPhone.setTag(null);
        this.lexusBtSet.setTag(null);
        this.lexusBtVedio.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(root);
        this.mCallback178 = new OnClickListener(this, 8);
        this.mCallback176 = new OnClickListener(this, 6);
        this.mCallback174 = new OnClickListener(this, 4);
        this.mCallback182 = new OnClickListener(this, 12);
        this.mCallback172 = new OnClickListener(this, 2);
        this.mCallback180 = new OnClickListener(this, 10);
        this.mCallback179 = new OnClickListener(this, 9);
        this.mCallback177 = new OnClickListener(this, 7);
        this.mCallback175 = new OnClickListener(this, 5);
        this.mCallback173 = new OnClickListener(this, 3);
        this.mCallback171 = new OnClickListener(this, 1);
        this.mCallback181 = new OnClickListener(this, 11);
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
        if (36 != variableId) {
            return false;
        }
        setViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityMainLexusBinding
    public void setViewModel(LauncherViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelAcControl((ObservableBoolean) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelAcControl(ObservableBoolean ViewModelAcControl, int fieldId) {
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
        boolean viewModelAcControlGet = false;
        int viewModelAcControlViewVISIBLEViewGONE = 0;
        ObservableBoolean viewModelAcControl = null;
        LauncherViewModel viewModel = this.mViewModel;
        if ((dirtyFlags & 7) != 0) {
            if (viewModel != null) {
                viewModelAcControl = viewModel.acControl;
            }
            int i = 0;
            updateRegistration(0, viewModelAcControl);
            if (viewModelAcControl != null) {
                viewModelAcControlGet = viewModelAcControl.get();
            }
            if ((dirtyFlags & 7) != 0) {
                if (viewModelAcControlGet) {
                    dirtyFlags |= 16;
                } else {
                    dirtyFlags |= 8;
                }
            }
            if (!viewModelAcControlGet) {
                i = 8;
            }
            viewModelAcControlViewVISIBLEViewGONE = i;
        }
        if ((7 & dirtyFlags) != 0) {
            this.lexusAir.setVisibility(viewModelAcControlViewVISIBLEViewGONE);
        }
        if ((4 & dirtyFlags) != 0) {
            this.lexusAir.setOnClickListener(this.mCallback182);
            this.lexusBtApp.setOnClickListener(this.mCallback181);
            this.lexusBtCar.setOnClickListener(this.mCallback180);
            this.lexusBtDash.setOnClickListener(this.mCallback174);
            this.lexusBtDvr.setOnClickListener(this.mCallback175);
            this.lexusBtFile.setOnClickListener(this.mCallback179);
            this.lexusBtLink.setOnClickListener(this.mCallback176);
            this.lexusBtMusic.setOnClickListener(this.mCallback173);
            this.lexusBtNavi.setOnClickListener(this.mCallback171);
            this.lexusBtPhone.setOnClickListener(this.mCallback172);
            this.lexusBtSet.setOnClickListener(this.mCallback177);
            this.lexusBtVedio.setOnClickListener(this.mCallback178);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean viewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                LauncherViewModel viewModel = this.mViewModel;
                if (viewModel == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel.openNaviApp(callbackArg_0);
                    return;
                }
                return;
            case 2:
                LauncherViewModel viewModel2 = this.mViewModel;
                if (viewModel2 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel2.openBtApp(callbackArg_0);
                    return;
                }
                return;
            case 3:
                LauncherViewModel viewModel3 = this.mViewModel;
                if (viewModel3 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel3.openMusicMulti(callbackArg_0);
                    return;
                }
                return;
            case 4:
                LauncherViewModel viewModel4 = this.mViewModel;
                if (viewModel4 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel4.openDashboard(callbackArg_0);
                    return;
                }
                return;
            case 5:
                LauncherViewModel viewModel5 = this.mViewModel;
                if (viewModel5 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel5.openDvr(callbackArg_0);
                    return;
                }
                return;
            case 6:
                LauncherViewModel viewModel6 = this.mViewModel;
                if (viewModel6 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel6.openShouJiHuLian(callbackArg_0);
                    return;
                }
                return;
            case 7:
                LauncherViewModel viewModel7 = this.mViewModel;
                if (viewModel7 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel7.openSettings(callbackArg_0);
                    return;
                }
                return;
            case 8:
                LauncherViewModel viewModel8 = this.mViewModel;
                if (viewModel8 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel8.openVideoMulti(callbackArg_0);
                    return;
                }
                return;
            case 9:
                LauncherViewModel viewModel9 = this.mViewModel;
                if (viewModel9 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel9.openFileManager(callbackArg_0);
                    return;
                }
                return;
            case 10:
                LauncherViewModel viewModel10 = this.mViewModel;
                if (viewModel10 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel10.openLexusCar(callbackArg_0);
                    return;
                }
                return;
            case 11:
                LauncherViewModel viewModel11 = this.mViewModel;
                if (viewModel11 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel11.openApps(callbackArg_0);
                    return;
                }
                return;
            case 12:
                LauncherViewModel viewModel12 = this.mViewModel;
                if (viewModel12 == null) {
                    viewModelJavaLangObjectNull = false;
                }
                if (viewModelJavaLangObjectNull) {
                    viewModel12.openAirControl(callbackArg_0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

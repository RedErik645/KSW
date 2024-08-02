package com.wits.ksw.databinding;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class BmwId8gsModusLayoutBindingImpl extends BmwId8gsModusLayoutBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback570;
    private final View.OnClickListener mCallback571;
    private final View.OnClickListener mCallback572;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView2;
    private final TextView mboundView3;
    private final ImageView mboundView5;
    private final TextView mboundView6;
    private final ImageView mboundView8;
    private final TextView mboundView9;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(16);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"id8_gs_launcher_left_bar"}, new int[]{10}, new int[]{R.layout.id8_gs_launcher_left_bar});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rl_modus_container, 11);
        sparseIntArray.put(R.id.tv_change_modus_title, 12);
        sparseIntArray.put(R.id.ll_modus_personal, 13);
        sparseIntArray.put(R.id.ll_modus_sport, 14);
        sparseIntArray.put(R.id.ll_modus_efficient, 15);
    }

    public BmwId8gsModusLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private BmwId8gsModusLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (Id8GsLauncherLeftBarBinding) bindings[10], (RelativeLayout) bindings[15], (ImageView) bindings[7], (RelativeLayout) bindings[13], (ImageView) bindings[1], (RelativeLayout) bindings[14], (ImageView) bindings[4], (RelativeLayout) bindings[11], (TextView) bindings[12]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.bmwId8GsModusMainLeftBar);
        this.llModusEfficientImg.setTag(null);
        this.llModusPersonalImg.setTag(null);
        this.llModusSportImg.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[5];
        this.mboundView5 = imageView2;
        imageView2.setTag(null);
        TextView textView2 = (TextView) bindings[6];
        this.mboundView6 = textView2;
        textView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[8];
        this.mboundView8 = imageView3;
        imageView3.setTag(null);
        TextView textView3 = (TextView) bindings[9];
        this.mboundView9 = textView3;
        textView3.setTag(null);
        setRootTag(root);
        this.mCallback570 = new OnClickListener(this, 1);
        this.mCallback572 = new OnClickListener(this, 3);
        this.mCallback571 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
        }
        this.bmwId8GsModusMainLeftBar.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.bmwId8GsModusMainLeftBar.hasPendingBindings() == false) goto L_0x0016;
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
            com.wits.ksw.databinding.Id8GsLauncherLeftBarBinding r0 = r4.bmwId8GsModusMainLeftBar
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
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.databinding.BmwId8gsModusLayoutBindingImpl.hasPendingBindings():boolean");
    }

    @Override // android.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (13 != variableId) {
            return false;
        }
        setLauncherViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.BmwId8gsModusLayoutBinding
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
        this.bmwId8GsModusMainLeftBar.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeLauncherViewModelIsEfficientModus((ObservableField) object, fieldId);
            case 1:
                return onChangeLauncherViewModelIsPersonalModus((ObservableField) object, fieldId);
            case 2:
                return onChangeBmwId8GsModusMainLeftBar((Id8GsLauncherLeftBarBinding) object, fieldId);
            case 3:
                return onChangeLauncherViewModelIsSportModus((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeLauncherViewModelIsEfficientModus(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeLauncherViewModelIsPersonalModus(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeBmwId8GsModusMainLeftBar(Id8GsLauncherLeftBarBinding BmwId8GsModusMainLeftBar, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeLauncherViewModelIsSportModus(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        int launcherViewModelIsSportModusViewVISIBLEViewGONE;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Boolean launcherViewModelIsEfficientModusGet = null;
        LauncherViewModel launcherViewModel = this.mLauncherViewModel;
        Boolean launcherViewModelIsPersonalModusGet = null;
        int launcherViewModelIsEfficientModusViewVISIBLEViewGONE = 0;
        int launcherViewModelIsPersonalModusViewVISIBLEViewGONE = 0;
        ObservableField<Boolean> launcherViewModelIsEfficientModus = null;
        ObservableField<Boolean> launcherViewModelIsPersonalModus = null;
        ObservableField<Boolean> launcherViewModelIsSportModus = null;
        Boolean launcherViewModelIsSportModusGet = null;
        if ((dirtyFlags & 59) != 0) {
            int launcherViewModelIsSportModusViewVISIBLEViewGONE2 = 8;
            if ((dirtyFlags & 49) != 0) {
                if (launcherViewModel != null) {
                    launcherViewModelIsEfficientModus = launcherViewModel.isEfficientModus;
                }
                updateRegistration(0, launcherViewModelIsEfficientModus);
                if (launcherViewModelIsEfficientModus != null) {
                    launcherViewModelIsEfficientModusGet = launcherViewModelIsEfficientModus.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxLauncherViewModelIsEfficientModusGet = ViewDataBinding.safeUnbox(launcherViewModelIsEfficientModusGet);
                if ((dirtyFlags & 49) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxLauncherViewModelIsEfficientModusGet) {
                        dirtyFlags |= 128;
                    } else {
                        dirtyFlags |= 64;
                    }
                }
                launcherViewModelIsEfficientModusViewVISIBLEViewGONE = androidDatabindingViewDataBindingSafeUnboxLauncherViewModelIsEfficientModusGet ? 0 : 8;
            }
            if ((dirtyFlags & 50) != 0) {
                if (launcherViewModel != null) {
                    launcherViewModelIsPersonalModus = launcherViewModel.isPersonalModus;
                }
                updateRegistration(1, launcherViewModelIsPersonalModus);
                if (launcherViewModelIsPersonalModus != null) {
                    launcherViewModelIsPersonalModusGet = launcherViewModelIsPersonalModus.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxLauncherViewModelIsPersonalModusGet = ViewDataBinding.safeUnbox(launcherViewModelIsPersonalModusGet);
                if ((dirtyFlags & 50) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxLauncherViewModelIsPersonalModusGet) {
                        dirtyFlags |= 512;
                    } else {
                        dirtyFlags |= 256;
                    }
                }
                launcherViewModelIsPersonalModusViewVISIBLEViewGONE = androidDatabindingViewDataBindingSafeUnboxLauncherViewModelIsPersonalModusGet ? 0 : 8;
            }
            if ((dirtyFlags & 56) != 0) {
                if (launcherViewModel != null) {
                    launcherViewModelIsSportModus = launcherViewModel.isSportModus;
                }
                updateRegistration(3, launcherViewModelIsSportModus);
                if (launcherViewModelIsSportModus != null) {
                    launcherViewModelIsSportModusGet = launcherViewModelIsSportModus.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxLauncherViewModelIsSportModusGet = ViewDataBinding.safeUnbox(launcherViewModelIsSportModusGet);
                if ((dirtyFlags & 56) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxLauncherViewModelIsSportModusGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    }
                }
                if (androidDatabindingViewDataBindingSafeUnboxLauncherViewModelIsSportModusGet) {
                    launcherViewModelIsSportModusViewVISIBLEViewGONE2 = 0;
                }
                launcherViewModelIsSportModusViewVISIBLEViewGONE = launcherViewModelIsSportModusViewVISIBLEViewGONE2;
            } else {
                launcherViewModelIsSportModusViewVISIBLEViewGONE = 0;
            }
        } else {
            launcherViewModelIsSportModusViewVISIBLEViewGONE = 0;
        }
        if ((dirtyFlags & 48) != 0) {
            this.bmwId8GsModusMainLeftBar.setLeftViewModel(launcherViewModel);
        }
        if ((dirtyFlags & 32) != 0) {
            this.llModusEfficientImg.setOnClickListener(this.mCallback572);
            this.llModusPersonalImg.setOnClickListener(this.mCallback570);
            this.llModusSportImg.setOnClickListener(this.mCallback571);
        }
        if ((dirtyFlags & 50) != 0) {
            this.mboundView2.setVisibility(launcherViewModelIsPersonalModusViewVISIBLEViewGONE);
            this.mboundView3.setVisibility(launcherViewModelIsPersonalModusViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 56) != 0) {
            this.mboundView5.setVisibility(launcherViewModelIsSportModusViewVISIBLEViewGONE);
            this.mboundView6.setVisibility(launcherViewModelIsSportModusViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 49) != 0) {
            this.mboundView8.setVisibility(launcherViewModelIsEfficientModusViewVISIBLEViewGONE);
            this.mboundView9.setVisibility(launcherViewModelIsEfficientModusViewVISIBLEViewGONE);
        }
        executeBindingsOn(this.bmwId8GsModusMainLeftBar);
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean launcherViewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                LauncherViewModel launcherViewModel = this.mLauncherViewModel;
                if (launcherViewModel == null) {
                    launcherViewModelJavaLangObjectNull = false;
                }
                if (launcherViewModelJavaLangObjectNull) {
                    launcherViewModel.changeModusToPersonal(callbackArg_0);
                    return;
                }
                return;
            case 2:
                LauncherViewModel launcherViewModel2 = this.mLauncherViewModel;
                if (launcherViewModel2 == null) {
                    launcherViewModelJavaLangObjectNull = false;
                }
                if (launcherViewModelJavaLangObjectNull) {
                    launcherViewModel2.changeModusToSport(callbackArg_0);
                    return;
                }
                return;
            case 3:
                LauncherViewModel launcherViewModel3 = this.mLauncherViewModel;
                if (launcherViewModel3 == null) {
                    launcherViewModelJavaLangObjectNull = false;
                }
                if (launcherViewModelJavaLangObjectNull) {
                    launcherViewModel3.changeModusToEfficient(callbackArg_0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

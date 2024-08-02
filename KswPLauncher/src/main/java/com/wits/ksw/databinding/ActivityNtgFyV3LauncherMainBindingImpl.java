package com.wits.ksw.databinding;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.ControlBean;
import com.wits.ksw.launcher.model.Ntg6v3LauncherViewModel;

public class ActivityNtgFyV3LauncherMainBindingImpl extends ActivityNtgFyV3LauncherMainBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private OnClickListenerImpl mLauncherViewModelOnControlClickAndroidViewViewOnClickListener;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"ntg_fy_v3_launcher_left_bar", "ntg_fy_v3_launcher_bottom_bar", "ntg_fy_v3_allapps_pop_layout"}, new int[]{2, 3, 4}, new int[]{R.layout.ntg_fy_v3_launcher_left_bar, R.layout.ntg_fy_v3_launcher_bottom_bar, R.layout.ntg_fy_v3_allapps_pop_layout});
    }

    public ActivityNtgFyV3LauncherMainBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    private ActivityNtgFyV3LauncherMainBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (ImageView) bindings[1], (NtgFyV3LauncherBottomBarBinding) bindings[3], (NtgFyV3LauncherLeftBarBinding) bindings[2], (NtgFyV3AllappsPopLayoutBinding) bindings[4], (RelativeLayout) bindings[0]);
        this.mDirtyFlags = -1;
        this.controlBtn.setTag(null);
        setContainedBinding(this.llBottomContainer);
        setContainedBinding(this.llLeftContainer);
        setContainedBinding(this.llPopwindowContainer);
        this.ntg6v3LauncherMainBg.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
        }
        this.llLeftContainer.invalidateAll();
        this.llBottomContainer.invalidateAll();
        this.llPopwindowContainer.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r4.llBottomContainer.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r4.llPopwindowContainer.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
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
            long r0 = r4.mDirtyFlags     // Catch:{ all -> 0x002a }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x002a }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x002a }
            com.wits.ksw.databinding.NtgFyV3LauncherLeftBarBinding r0 = r4.llLeftContainer
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            com.wits.ksw.databinding.NtgFyV3LauncherBottomBarBinding r0 = r4.llBottomContainer
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r1
        L_0x001f:
            com.wits.ksw.databinding.NtgFyV3AllappsPopLayoutBinding r0 = r4.llPopwindowContainer
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0028
            return r1
        L_0x0028:
            r0 = 0
            return r0
        L_0x002a:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.databinding.ActivityNtgFyV3LauncherMainBindingImpl.hasPendingBindings():boolean");
    }

    @Override // android.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (13 != variableId) {
            return false;
        }
        setLauncherViewModel((Ntg6v3LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityNtgFyV3LauncherMainBinding
    public void setLauncherViewModel(Ntg6v3LauncherViewModel LauncherViewModel) {
        this.mLauncherViewModel = LauncherViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    @Override // android.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.llLeftContainer.setLifecycleOwner(lifecycleOwner);
        this.llBottomContainer.setLifecycleOwner(lifecycleOwner);
        this.llPopwindowContainer.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeLauncherViewModelControlBeanControlPanelClose((ObservableBoolean) object, fieldId);
            case 1:
                return onChangeLlBottomContainer((NtgFyV3LauncherBottomBarBinding) object, fieldId);
            case 2:
                return onChangeLlPopwindowContainer((NtgFyV3AllappsPopLayoutBinding) object, fieldId);
            case 3:
                return onChangeLauncherViewModelControlBeanBenzControlPanelState((ObservableBoolean) object, fieldId);
            case 4:
                return onChangeLlLeftContainer((NtgFyV3LauncherLeftBarBinding) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeLauncherViewModelControlBeanControlPanelClose(ObservableBoolean LauncherViewModelControlBeanControlPanelClose, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeLlBottomContainer(NtgFyV3LauncherBottomBarBinding LlBottomContainer, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeLlPopwindowContainer(NtgFyV3AllappsPopLayoutBinding LlPopwindowContainer, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeLauncherViewModelControlBeanBenzControlPanelState(ObservableBoolean LauncherViewModelControlBeanBenzControlPanelState, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeLlLeftContainer(NtgFyV3LauncherLeftBarBinding LlLeftContainer, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
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
        ObservableBoolean launcherViewModelControlBeanControlPanelClose = null;
        View.OnClickListener launcherViewModelOnControlClickAndroidViewViewOnClickListener = null;
        ObservableBoolean launcherViewModelControlBeanBenzControlPanelState = null;
        Ntg6v3LauncherViewModel launcherViewModel = this.mLauncherViewModel;
        int launcherViewModelControlBeanControlPanelCloseViewGONEViewVISIBLE = 0;
        ControlBean launcherViewModelControlBean = null;
        boolean launcherViewModelControlBeanControlPanelCloseGet = false;
        boolean launcherViewModelControlBeanBenzControlPanelStateGet = false;
        Drawable launcherViewModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector = null;
        if ((105 & dirtyFlags) != 0) {
            if (!((dirtyFlags & 96) == 0 || launcherViewModel == null)) {
                OnClickListenerImpl onClickListenerImpl = this.mLauncherViewModelOnControlClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mLauncherViewModelOnControlClickAndroidViewViewOnClickListener = onClickListenerImpl;
                }
                launcherViewModelOnControlClickAndroidViewViewOnClickListener = onClickListenerImpl.setValue(launcherViewModel);
            }
            if (launcherViewModel != null) {
                launcherViewModelControlBean = launcherViewModel.controlBean;
            }
            if ((dirtyFlags & 97) != 0) {
                if (launcherViewModelControlBean != null) {
                    launcherViewModelControlBeanControlPanelClose = launcherViewModelControlBean.controlPanelClose;
                }
                int i = 0;
                updateRegistration(0, launcherViewModelControlBeanControlPanelClose);
                if (launcherViewModelControlBeanControlPanelClose != null) {
                    launcherViewModelControlBeanControlPanelCloseGet = launcherViewModelControlBeanControlPanelClose.get();
                }
                if ((dirtyFlags & 97) != 0) {
                    if (launcherViewModelControlBeanControlPanelCloseGet) {
                        dirtyFlags |= 256;
                    } else {
                        dirtyFlags |= 128;
                    }
                }
                if (launcherViewModelControlBeanControlPanelCloseGet) {
                    i = 8;
                }
                launcherViewModelControlBeanControlPanelCloseViewGONEViewVISIBLE = i;
            }
            if ((dirtyFlags & 104) != 0) {
                if (launcherViewModelControlBean != null) {
                    launcherViewModelControlBeanBenzControlPanelState = launcherViewModelControlBean.benzControlPanelState;
                }
                updateRegistration(3, launcherViewModelControlBeanBenzControlPanelState);
                if (launcherViewModelControlBeanBenzControlPanelState != null) {
                    launcherViewModelControlBeanBenzControlPanelStateGet = launcherViewModelControlBeanBenzControlPanelState.get();
                }
                if ((dirtyFlags & 104) != 0) {
                    if (launcherViewModelControlBeanBenzControlPanelStateGet) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    } else {
                        dirtyFlags |= 512;
                    }
                }
                launcherViewModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector = AppCompatResources.getDrawable(this.controlBtn.getContext(), launcherViewModelControlBeanBenzControlPanelStateGet ? R.drawable.ntg55_ctrlpanel_down_selector : R.drawable.ntg55_ctrlpanel_up_selector);
            }
        }
        if ((dirtyFlags & 97) != 0) {
            this.controlBtn.setVisibility(launcherViewModelControlBeanControlPanelCloseViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 104) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.controlBtn, launcherViewModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector);
        }
        if ((96 & dirtyFlags) != 0) {
            this.controlBtn.setOnClickListener(launcherViewModelOnControlClickAndroidViewViewOnClickListener);
            this.llBottomContainer.setBottomViewModel(launcherViewModel);
            this.llLeftContainer.setLeftViewModel(launcherViewModel);
            this.llPopwindowContainer.setPopwindowViewModel(launcherViewModel);
        }
        executeBindingsOn(this.llLeftContainer);
        executeBindingsOn(this.llBottomContainer);
        executeBindingsOn(this.llPopwindowContainer);
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private Ntg6v3LauncherViewModel value;

        public OnClickListenerImpl setValue(Ntg6v3LauncherViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.onControlClick(arg0);
        }
    }
}

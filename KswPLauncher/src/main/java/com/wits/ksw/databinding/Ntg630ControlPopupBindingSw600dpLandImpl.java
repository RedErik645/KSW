package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class Ntg630ControlPopupBindingSw600dpLandImpl extends Ntg630ControlPopupBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private OnClickListenerImpl3 mLauncherViewModelOnAuxiliaryRadarClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl mLauncherViewModelOnEspClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl5 mLauncherViewModelOnFoldLeftClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mLauncherViewModelOnFoldRigtClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl4 mLauncherViewModelOnHighChasssisClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mLauncherViewModelShowBrightnessDialogAndroidViewViewOnClickListener;

    public Ntg630ControlPopupBindingSw600dpLandImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private Ntg630ControlPopupBindingSw600dpLandImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (ImageView) bindings[7], (ImageView) bindings[8], (ImageView) bindings[2], (ImageView) bindings[3], (ImageView) bindings[4], (ImageView) bindings[5], (ImageView) bindings[6], (ImageView) bindings[1], (RelativeLayout) bindings[0]);
        this.mDirtyFlags = -1;
        this.brightnessBtnLeft.setTag(null);
        this.brightnessBtnRight.setTag(null);
        this.controlBtn1.setTag(null);
        this.controlBtn2.setTag(null);
        this.controlBtn3.setTag(null);
        this.foldLeftBtn.setTag(null);
        this.foldRightBtn.setTag(null);
        this.imageView.setTag(null);
        this.linearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        if (28 != variableId) {
            return false;
        }
        setLauncherViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.Ntg630ControlPopupBinding
    public void setLauncherViewModel(LauncherViewModel LauncherViewModel) {
        this.mLauncherViewModel = LauncherViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(28);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeLauncherViewModelControlBeanRdarAssistance((ObservableBoolean) object, fieldId);
            case 1:
                return onChangeLauncherViewModelControlBeanPassairbar((ObservableBoolean) object, fieldId);
            case 2:
                return onChangeLauncherViewModelControlBeanChassis((ObservableBoolean) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeLauncherViewModelControlBeanRdarAssistance(ObservableBoolean LauncherViewModelControlBeanRdarAssistance, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeLauncherViewModelControlBeanPassairbar(ObservableBoolean LauncherViewModelControlBeanPassairbar, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeLauncherViewModelControlBeanChassis(ObservableBoolean LauncherViewModelControlBeanChassis, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01aa  */
    @Override // android.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 519
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.databinding.Ntg630ControlPopupBindingSw600dpLandImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private LauncherViewModel value;

        public OnClickListenerImpl setValue(LauncherViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.onEspClick(arg0);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private LauncherViewModel value;

        public OnClickListenerImpl1 setValue(LauncherViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.showBrightnessDialog(arg0);
        }
    }

    public static class OnClickListenerImpl2 implements View.OnClickListener {
        private LauncherViewModel value;

        public OnClickListenerImpl2 setValue(LauncherViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.onFoldRigtClick(arg0);
        }
    }

    public static class OnClickListenerImpl3 implements View.OnClickListener {
        private LauncherViewModel value;

        public OnClickListenerImpl3 setValue(LauncherViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.onAuxiliaryRadarClick(arg0);
        }
    }

    public static class OnClickListenerImpl4 implements View.OnClickListener {
        private LauncherViewModel value;

        public OnClickListenerImpl4 setValue(LauncherViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.onHighChasssisClick(arg0);
        }
    }

    public static class OnClickListenerImpl5 implements View.OnClickListener {
        private LauncherViewModel value;

        public OnClickListenerImpl5 setValue(LauncherViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.onFoldLeftClick(arg0);
        }
    }
}

package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.model.BcVieModel;
import com.wits.ksw.launcher.model.ControlBean;

public class ActivityMainBenzMbuxBindingImpl extends ActivityMainBenzMbuxBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private OnClickListenerImpl mVieModelOnControlClickAndroidViewViewOnClickListener;

    public ActivityMainBenzMbuxBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }

    private ActivityMainBenzMbuxBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (RecyclerView) bindings[1], (ImageView) bindings[2], (ConstraintLayout) bindings[0]);
        this.mDirtyFlags = -1;
        this.benzMbuxRecyclerView.setTag(null);
        this.controlBtn.setTag(null);
        this.linearLayout3.setTag(null);
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
        if (35 != variableId) {
            return false;
        }
        setVieModel((BcVieModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityMainBenzMbuxBinding
    public void setVieModel(BcVieModel VieModel) {
        this.mVieModel = VieModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(35);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeVieModelControlBeanControlPanelClose((ObservableBoolean) object, fieldId);
            case 1:
                return onChangeVieModelBcPagePosition((ObservableInt) object, fieldId);
            case 2:
                return onChangeVieModelControlBeanBenzControlPanelState((ObservableBoolean) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeVieModelControlBeanControlPanelClose(ObservableBoolean VieModelControlBeanControlPanelClose, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVieModelBcPagePosition(ObservableInt VieModelBcPagePosition, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVieModelControlBeanBenzControlPanelState(ObservableBoolean VieModelControlBeanBenzControlPanelState, int fieldId) {
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
        ObservableBoolean vieModelControlBeanControlPanelClose = null;
        View.OnClickListener vieModelOnControlClickAndroidViewViewOnClickListener = null;
        BcVieModel vieModel = this.mVieModel;
        ObservableInt vieModelBcPagePosition = null;
        int vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE = 0;
        Drawable vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector = null;
        boolean vieModelControlBeanControlPanelCloseGet = false;
        ObservableBoolean vieModelControlBeanBenzControlPanelState = null;
        int vieModelBcPagePositionGet = 0;
        boolean vieModelControlBeanBenzControlPanelStateGet = false;
        ControlBean vieModelControlBean = null;
        if ((dirtyFlags & 31) != 0) {
            if (!((dirtyFlags & 24) == 0 || vieModel == null)) {
                OnClickListenerImpl onClickListenerImpl = this.mVieModelOnControlClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mVieModelOnControlClickAndroidViewViewOnClickListener = onClickListenerImpl;
                }
                vieModelOnControlClickAndroidViewViewOnClickListener = onClickListenerImpl.setValue(vieModel);
            }
            if ((dirtyFlags & 26) != 0) {
                if (vieModel != null) {
                    vieModelBcPagePosition = vieModel.bcPagePosition;
                }
                updateRegistration(1, vieModelBcPagePosition);
                if (vieModelBcPagePosition != null) {
                    vieModelBcPagePositionGet = vieModelBcPagePosition.get();
                }
            }
            if ((29 & dirtyFlags) != 0) {
                if (vieModel != null) {
                    vieModelControlBean = vieModel.controlBean;
                }
                if ((dirtyFlags & 25) != 0) {
                    if (vieModelControlBean != null) {
                        vieModelControlBeanControlPanelClose = vieModelControlBean.controlPanelClose;
                    }
                    int i = 0;
                    updateRegistration(0, vieModelControlBeanControlPanelClose);
                    if (vieModelControlBeanControlPanelClose != null) {
                        vieModelControlBeanControlPanelCloseGet = vieModelControlBeanControlPanelClose.get();
                    }
                    if ((dirtyFlags & 25) != 0) {
                        if (vieModelControlBeanControlPanelCloseGet) {
                            dirtyFlags |= 64;
                        } else {
                            dirtyFlags |= 32;
                        }
                    }
                    if (vieModelControlBeanControlPanelCloseGet) {
                        i = 8;
                    }
                    vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE = i;
                }
                if ((dirtyFlags & 28) != 0) {
                    if (vieModelControlBean != null) {
                        vieModelControlBeanBenzControlPanelState = vieModelControlBean.benzControlPanelState;
                    }
                    updateRegistration(2, vieModelControlBeanBenzControlPanelState);
                    if (vieModelControlBeanBenzControlPanelState != null) {
                        vieModelControlBeanBenzControlPanelStateGet = vieModelControlBeanBenzControlPanelState.get();
                    }
                    if ((dirtyFlags & 28) != 0) {
                        if (vieModelControlBeanBenzControlPanelStateGet) {
                            dirtyFlags |= 256;
                        } else {
                            dirtyFlags |= 128;
                        }
                    }
                    vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector = AppCompatResources.getDrawable(this.controlBtn.getContext(), vieModelControlBeanBenzControlPanelStateGet ? R.drawable.ntg55_ctrlpanel_down_selector : R.drawable.ntg55_ctrlpanel_up_selector);
                }
            }
        }
        if ((dirtyFlags & 26) != 0) {
            this.benzMbuxRecyclerView.smoothScrollToPosition(vieModelBcPagePositionGet);
        }
        if ((dirtyFlags & 25) != 0) {
            this.controlBtn.setVisibility(vieModelControlBeanControlPanelCloseViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 28) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.controlBtn, vieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector);
        }
        if ((dirtyFlags & 24) != 0) {
            this.controlBtn.setOnClickListener(vieModelOnControlClickAndroidViewViewOnClickListener);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private BcVieModel value;

        public OnClickListenerImpl setValue(BcVieModel value2) {
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

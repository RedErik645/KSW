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
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.BcVieModel;
import com.wits.ksw.launcher.model.ControlBean;
import com.wits.ksw.launcher.view.CustomBcItemBgImageView;

public class ActivityMainBcBindingHdpi1920x720Impl extends ActivityMainBcBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback317;
    private final View.OnClickListener mCallback318;
    private long mDirtyFlags;
    private OnClickListenerImpl1 mMBcVieModelOnControlClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl mMBcVieModelOpenAppsAndroidViewViewOnClickListener;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.constraintLayout2, 6);
        sparseIntArray.put(R.id.CustomBcItemBgImageView, 7);
    }

    public ActivityMainBcBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private ActivityMainBcBindingHdpi1920x720Impl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (CustomBcItemBgImageView) bindings[7], (TextView) bindings[2], (TextView) bindings[3], (TextView) bindings[4], (ConstraintLayout) bindings[6], (ImageView) bindings[5], (ConstraintLayout) bindings[0], (RecyclerView) bindings[1]);
        this.mDirtyFlags = -1;
        this.appsBtn.setTag(null);
        this.bcArrowLeftButton.setTag(null);
        this.bcArrowRightButton.setTag(null);
        this.controlBtn.setTag(null);
        this.linearLayout3.setTag(null);
        this.recyclerView2.setTag(null);
        setRootTag(root);
        this.mCallback318 = new OnClickListener(this, 2);
        this.mCallback317 = new OnClickListener(this, 1);
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
        if (30 != variableId) {
            return false;
        }
        setMBcVieModel((BcVieModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityMainBcBinding
    public void setMBcVieModel(BcVieModel MBcVieModel) {
        this.mMBcVieModel = MBcVieModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(30);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeMBcVieModelControlBeanBenzControlPanelState((ObservableBoolean) object, fieldId);
            case 1:
                return onChangeMBcVieModelControlBeanControlPanelClose((ObservableBoolean) object, fieldId);
            case 2:
                return onChangeMBcVieModelBcPagePosition((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeMBcVieModelControlBeanBenzControlPanelState(ObservableBoolean MBcVieModelControlBeanBenzControlPanelState, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeMBcVieModelControlBeanControlPanelClose(ObservableBoolean MBcVieModelControlBeanControlPanelClose, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeMBcVieModelBcPagePosition(ObservableInt MBcVieModelBcPagePosition, int fieldId) {
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
        boolean mBcVieModelControlBeanBenzControlPanelStateGet = false;
        View.OnClickListener mBcVieModelOpenAppsAndroidViewViewOnClickListener = null;
        ObservableBoolean mBcVieModelControlBeanBenzControlPanelState = null;
        int mBcVieModelBcPagePositionGet = 0;
        ObservableBoolean mBcVieModelControlBeanControlPanelClose = null;
        Drawable mBcVieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector = null;
        ControlBean mBcVieModelControlBean = null;
        ObservableInt mBcVieModelBcPagePosition = null;
        int mBcVieModelControlBeanControlPanelCloseViewGONEViewVISIBLE = 0;
        View.OnClickListener mBcVieModelOnControlClickAndroidViewViewOnClickListener = null;
        BcVieModel mBcVieModel = this.mMBcVieModel;
        boolean mBcVieModelControlBeanControlPanelCloseGet = false;
        if ((dirtyFlags & 31) != 0) {
            if (!((dirtyFlags & 24) == 0 || mBcVieModel == null)) {
                OnClickListenerImpl onClickListenerImpl = this.mMBcVieModelOpenAppsAndroidViewViewOnClickListener;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mMBcVieModelOpenAppsAndroidViewViewOnClickListener = onClickListenerImpl;
                }
                View.OnClickListener mBcVieModelOpenAppsAndroidViewViewOnClickListener2 = onClickListenerImpl.setValue(mBcVieModel);
                OnClickListenerImpl1 onClickListenerImpl1 = this.mMBcVieModelOnControlClickAndroidViewViewOnClickListener;
                if (onClickListenerImpl1 == null) {
                    onClickListenerImpl1 = new OnClickListenerImpl1();
                    this.mMBcVieModelOnControlClickAndroidViewViewOnClickListener = onClickListenerImpl1;
                }
                mBcVieModelOpenAppsAndroidViewViewOnClickListener = mBcVieModelOpenAppsAndroidViewViewOnClickListener2;
                mBcVieModelOnControlClickAndroidViewViewOnClickListener = onClickListenerImpl1.setValue(mBcVieModel);
            }
            if ((27 & dirtyFlags) != 0) {
                if (mBcVieModel != null) {
                    mBcVieModelControlBean = mBcVieModel.controlBean;
                }
                if ((dirtyFlags & 25) != 0) {
                    if (mBcVieModelControlBean != null) {
                        mBcVieModelControlBeanBenzControlPanelState = mBcVieModelControlBean.benzControlPanelState;
                    }
                    updateRegistration(0, mBcVieModelControlBeanBenzControlPanelState);
                    if (mBcVieModelControlBeanBenzControlPanelState != null) {
                        mBcVieModelControlBeanBenzControlPanelStateGet = mBcVieModelControlBeanBenzControlPanelState.get();
                    }
                    if ((dirtyFlags & 25) != 0) {
                        if (mBcVieModelControlBeanBenzControlPanelStateGet) {
                            dirtyFlags |= 64;
                        } else {
                            dirtyFlags |= 32;
                        }
                    }
                    mBcVieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector = AppCompatResources.getDrawable(this.controlBtn.getContext(), mBcVieModelControlBeanBenzControlPanelStateGet ? R.drawable.ntg55_ctrlpanel_down_selector : R.drawable.ntg55_ctrlpanel_up_selector);
                }
                if ((dirtyFlags & 26) != 0) {
                    if (mBcVieModelControlBean != null) {
                        mBcVieModelControlBeanControlPanelClose = mBcVieModelControlBean.controlPanelClose;
                    }
                    updateRegistration(1, mBcVieModelControlBeanControlPanelClose);
                    if (mBcVieModelControlBeanControlPanelClose != null) {
                        mBcVieModelControlBeanControlPanelCloseGet = mBcVieModelControlBeanControlPanelClose.get();
                    }
                    if ((dirtyFlags & 26) != 0) {
                        if (mBcVieModelControlBeanControlPanelCloseGet) {
                            dirtyFlags |= 256;
                        } else {
                            dirtyFlags |= 128;
                        }
                    }
                    mBcVieModelControlBeanControlPanelCloseViewGONEViewVISIBLE = mBcVieModelControlBeanControlPanelCloseGet ? 8 : 0;
                }
            }
            if ((dirtyFlags & 28) != 0) {
                if (mBcVieModel != null) {
                    mBcVieModelBcPagePosition = mBcVieModel.bcPagePosition;
                }
                updateRegistration(2, mBcVieModelBcPagePosition);
                if (mBcVieModelBcPagePosition != null) {
                    mBcVieModelBcPagePositionGet = mBcVieModelBcPagePosition.get();
                }
            }
        }
        if ((dirtyFlags & 24) != 0) {
            this.appsBtn.setOnClickListener(mBcVieModelOpenAppsAndroidViewViewOnClickListener);
            this.controlBtn.setOnClickListener(mBcVieModelOnControlClickAndroidViewViewOnClickListener);
        }
        if ((16 & dirtyFlags) != 0) {
            this.bcArrowLeftButton.setOnClickListener(this.mCallback317);
            this.bcArrowRightButton.setOnClickListener(this.mCallback318);
        }
        if ((dirtyFlags & 26) != 0) {
            this.controlBtn.setVisibility(mBcVieModelControlBeanControlPanelCloseViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 25) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.controlBtn, mBcVieModelControlBeanBenzControlPanelStateControlBtnAndroidDrawableNtg55CtrlpanelDownSelectorControlBtnAndroidDrawableNtg55CtrlpanelUpSelector);
        }
        if ((dirtyFlags & 28) != 0) {
            this.recyclerView2.smoothScrollToPosition(mBcVieModelBcPagePositionGet);
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
            this.value.openApps(arg0);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private BcVieModel value;

        public OnClickListenerImpl1 setValue(BcVieModel value2) {
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

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean mBcVieModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                BcVieModel mBcVieModel = this.mMBcVieModel;
                if (mBcVieModel == null) {
                    mBcVieModelJavaLangObjectNull = false;
                }
                if (mBcVieModelJavaLangObjectNull) {
                    mBcVieModel.switchToFirstView();
                    return;
                }
                return;
            case 2:
                BcVieModel mBcVieModel2 = this.mMBcVieModel;
                if (mBcVieModel2 == null) {
                    mBcVieModelJavaLangObjectNull = false;
                }
                if (mBcVieModelJavaLangObjectNull) {
                    mBcVieModel2.switchToSecondView();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
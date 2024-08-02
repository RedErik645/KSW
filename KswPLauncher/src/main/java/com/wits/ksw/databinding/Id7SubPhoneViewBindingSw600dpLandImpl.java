package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.model.LauncherViewModel;
import com.wits.ksw.launcher.view.CustomBmwImageView;

public class Id7SubPhoneViewBindingSw600dpLandImpl extends Id7SubPhoneViewBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback47;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.textView2, 5);
    }

    public Id7SubPhoneViewBindingSw600dpLandImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private Id7SubPhoneViewBindingSw600dpLandImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (TextView) bindings[4], (TextView) bindings[3], (TextView) bindings[2], (ConstraintLayout) bindings[0], (CustomBmwImageView) bindings[1], (TextView) bindings[5]);
        this.mDirtyFlags = -1;
        this.dayTextView.setTag(null);
        this.monthTextView.setTag(null);
        this.phoneConnectionTextView.setTag(null);
        this.phoneConstraintLayout.setTag(null);
        this.phoneImageView.setTag(null);
        setRootTag(root);
        this.mCallback47 = new OnClickListener(this, 1);
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
        if (20 != variableId) {
            return false;
        }
        setNaviViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.Id7SubPhoneViewBinding
    public void setNaviViewModel(LauncherViewModel NaviViewModel) {
        this.mNaviViewModel = NaviViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeNaviViewModelBtState((ObservableField) object, fieldId);
            case 1:
                return onChangeNaviViewModelMonth((ObservableField) object, fieldId);
            case 2:
                return onChangeNaviViewModelDay((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeNaviViewModelBtState(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeNaviViewModelMonth(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeNaviViewModelDay(ObservableField<String> observableField, int fieldId) {
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
        ObservableField<String> naviViewModelBtState = null;
        LauncherViewModel naviViewModel = this.mNaviViewModel;
        String naviViewModelDayGet = null;
        String naviViewModelMonthGet = null;
        ObservableField<String> naviViewModelMonth = null;
        ObservableField<String> naviViewModelDay = null;
        String naviViewModelBtStateGet = null;
        View.OnFocusChangeListener naviViewModelPhoneViewFocusChangeListener = null;
        if ((31 & dirtyFlags) != 0) {
            if ((dirtyFlags & 25) != 0) {
                if (naviViewModel != null) {
                    naviViewModelBtState = naviViewModel.btState;
                }
                updateRegistration(0, naviViewModelBtState);
                if (naviViewModelBtState != null) {
                    naviViewModelBtStateGet = naviViewModelBtState.get();
                }
            }
            if ((dirtyFlags & 26) != 0) {
                if (naviViewModel != null) {
                    naviViewModelMonth = naviViewModel.month;
                }
                updateRegistration(1, naviViewModelMonth);
                if (naviViewModelMonth != null) {
                    naviViewModelMonthGet = naviViewModelMonth.get();
                }
            }
            if ((dirtyFlags & 28) != 0) {
                if (naviViewModel != null) {
                    naviViewModelDay = naviViewModel.day;
                }
                updateRegistration(2, naviViewModelDay);
                if (naviViewModelDay != null) {
                    naviViewModelDayGet = naviViewModelDay.get();
                }
            }
            if (!((dirtyFlags & 24) == 0 || naviViewModel == null)) {
                naviViewModelPhoneViewFocusChangeListener = naviViewModel.phoneViewFocusChangeListener;
            }
        }
        if ((dirtyFlags & 28) != 0) {
            TextViewBindingAdapter.setText(this.dayTextView, naviViewModelDayGet);
        }
        if ((dirtyFlags & 26) != 0) {
            TextViewBindingAdapter.setText(this.monthTextView, naviViewModelMonthGet);
        }
        if ((dirtyFlags & 25) != 0) {
            TextViewBindingAdapter.setText(this.phoneConnectionTextView, naviViewModelBtStateGet);
        }
        if ((dirtyFlags & 16) != 0) {
            this.phoneImageView.setOnClickListener(this.mCallback47);
        }
        if ((dirtyFlags & 24) != 0) {
            this.phoneImageView.setOnFocusChangeListener(naviViewModelPhoneViewFocusChangeListener);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        LauncherViewModel naviViewModel = this.mNaviViewModel;
        if (naviViewModel != null) {
            naviViewModel.openBtApp(callbackArg_0);
        }
    }
}

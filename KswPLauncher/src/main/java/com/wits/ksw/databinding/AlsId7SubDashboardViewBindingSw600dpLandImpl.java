package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ObservableFloat;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.als_id7.model.AlsID7ViewModel;
import com.wits.ksw.launcher.view.CustomBmwImageView;

public class AlsId7SubDashboardViewBindingSw600dpLandImpl extends AlsId7SubDashboardViewBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback541;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title, 7);
    }

    public AlsId7SubDashboardViewBindingSw600dpLandImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private AlsId7SubDashboardViewBindingSw600dpLandImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (TextView) bindings[4], (ConstraintLayout) bindings[0], (CustomBmwImageView) bindings[1], (TextView) bindings[2], (ImageView) bindings[3], (TextView) bindings[5], (TextView) bindings[6], (TextView) bindings[7]);
        this.mDirtyFlags = -1;
        this.brakeTextView.setTag(null);
        this.dashboardConstraintLayout.setTag(null);
        this.dashboardImageView.setTag(null);
        this.oilTextView.setTag(null);
        this.pointerImageView.setTag(null);
        this.seatBeltTextView.setTag(null);
        this.speedTextView.setTag(null);
        setRootTag(root);
        this.mCallback541 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
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
        if (6 != variableId) {
            return false;
        }
        setDashVideoViewModel((AlsID7ViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.AlsId7SubDashboardViewBinding
    public void setDashVideoViewModel(AlsID7ViewModel DashVideoViewModel) {
        this.mDashVideoViewModel = DashVideoViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeDashVideoViewModelCarInfoTurnSpeed((ObservableInt) object, fieldId);
            case 1:
                return onChangeDashVideoViewModelCarInfoBrakeValue((ObservableField) object, fieldId);
            case 2:
                return onChangeDashVideoViewModelCarInfoOilValue((ObservableField) object, fieldId);
            case 3:
                return onChangeDashVideoViewModelCarInfoSeatBeltpValue((ObservableField) object, fieldId);
            case 4:
                return onChangeDashVideoViewModelCarInfoTurnSpeedAnge((ObservableFloat) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeDashVideoViewModelCarInfoTurnSpeed(ObservableInt DashVideoViewModelCarInfoTurnSpeed, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeDashVideoViewModelCarInfoBrakeValue(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeDashVideoViewModelCarInfoOilValue(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeDashVideoViewModelCarInfoSeatBeltpValue(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeDashVideoViewModelCarInfoTurnSpeedAnge(ObservableFloat DashVideoViewModelCarInfoTurnSpeedAnge, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01de  */
    @Override // android.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 487
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.databinding.AlsId7SubDashboardViewBindingSw600dpLandImpl.executeBindings():void");
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        AlsID7ViewModel dashVideoViewModel = this.mDashVideoViewModel;
        if (dashVideoViewModel != null) {
            dashVideoViewModel.openDashboard(callbackArg_0);
        }
    }
}

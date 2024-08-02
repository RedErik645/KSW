package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.bean.CarInfo;
import com.wits.ksw.launcher.model.LauncherViewModel;

public class KswId7MainPage2FragmentImpl extends KswId7MainPage2Fragment implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback184;
    private final View.OnClickListener mCallback185;
    private final View.OnClickListener mCallback186;
    private final View.OnClickListener mCallback187;
    private final View.OnClickListener mCallback188;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_arrow, 7);
        sparseIntArray.put(R.id.tv_video, 8);
    }

    public KswId7MainPage2FragmentImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private KswId7MainPage2FragmentImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (ImageView) bindings[7], (LinearLayout) bindings[4], (LinearLayout) bindings[2], (LinearLayout) bindings[5], (LinearLayout) bindings[6], (LinearLayout) bindings[1], (TextView) bindings[8]);
        this.mDirtyFlags = -1;
        this.llCarCard.setTag(null);
        this.llComputerCard.setTag(null);
        this.llFileCard.setTag(null);
        this.llLinkCard.setTag(null);
        this.llVideoCard.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        setRootTag(root);
        this.mCallback188 = new OnClickListener(this, 5);
        this.mCallback186 = new OnClickListener(this, 3);
        this.mCallback187 = new OnClickListener(this, 4);
        this.mCallback184 = new OnClickListener(this, 1);
        this.mCallback185 = new OnClickListener(this, 2);
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
        if (5 != variableId) {
            return false;
        }
        setCarViewModel((LauncherViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.KswId7MainPage2Fragment
    public void setCarViewModel(LauncherViewModel CarViewModel) {
        this.mCarViewModel = CarViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeCarViewModelCarInfoOilValue((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeCarViewModelCarInfoOilValue(ObservableField<String> observableField, int fieldId) {
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
        String carViewModelCarInfoOilValueGet = null;
        String mboundView3AndroidStringOilSizeCarViewModelCarInfoOilValue = null;
        ObservableField<String> carViewModelCarInfoOilValue = null;
        LauncherViewModel carViewModel = this.mCarViewModel;
        View.OnFocusChangeListener carViewModelKswId7VideoCardFocusChangeListener = null;
        if ((dirtyFlags & 5) != 0) {
            CarInfo carViewModelCarInfo = LauncherViewModel.carInfo;
            if (carViewModelCarInfo != null) {
                carViewModelCarInfoOilValue = carViewModelCarInfo.oilValue;
            }
            updateRegistration(0, carViewModelCarInfoOilValue);
            if (carViewModelCarInfoOilValue != null) {
                carViewModelCarInfoOilValueGet = carViewModelCarInfoOilValue.get();
            }
            mboundView3AndroidStringOilSizeCarViewModelCarInfoOilValue = this.mboundView3.getResources().getString(R.string.oil_size, carViewModelCarInfoOilValueGet);
        }
        if (!((dirtyFlags & 6) == 0 || carViewModel == null)) {
            carViewModelKswId7VideoCardFocusChangeListener = carViewModel.kswId7VideoCardFocusChangeListener;
        }
        if ((4 & dirtyFlags) != 0) {
            this.llCarCard.setOnClickListener(this.mCallback186);
            this.llComputerCard.setOnClickListener(this.mCallback185);
            this.llFileCard.setOnClickListener(this.mCallback187);
            this.llLinkCard.setOnClickListener(this.mCallback188);
            this.llVideoCard.setOnClickListener(this.mCallback184);
        }
        if ((6 & dirtyFlags) != 0) {
            this.llVideoCard.setOnFocusChangeListener(carViewModelKswId7VideoCardFocusChangeListener);
        }
        if ((5 & dirtyFlags) != 0) {
            TextViewBindingAdapter.setText(this.mboundView3, mboundView3AndroidStringOilSizeCarViewModelCarInfoOilValue);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean carViewModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                LauncherViewModel carViewModel = this.mCarViewModel;
                if (carViewModel == null) {
                    carViewModelJavaLangObjectNull = false;
                }
                if (carViewModelJavaLangObjectNull) {
                    carViewModel.openVideoMulti(callbackArg_0);
                    return;
                }
                return;
            case 2:
                LauncherViewModel carViewModel2 = this.mCarViewModel;
                if (carViewModel2 == null) {
                    carViewModelJavaLangObjectNull = false;
                }
                if (carViewModelJavaLangObjectNull) {
                    carViewModel2.openDashboard(callbackArg_0);
                    return;
                }
                return;
            case 3:
                LauncherViewModel carViewModel3 = this.mCarViewModel;
                if (carViewModel3 == null) {
                    carViewModelJavaLangObjectNull = false;
                }
                if (carViewModelJavaLangObjectNull) {
                    carViewModel3.openCar(callbackArg_0);
                    return;
                }
                return;
            case 4:
                LauncherViewModel carViewModel4 = this.mCarViewModel;
                if (carViewModel4 == null) {
                    carViewModelJavaLangObjectNull = false;
                }
                if (carViewModelJavaLangObjectNull) {
                    carViewModel4.openFileManager(callbackArg_0);
                    return;
                }
                return;
            case 5:
                LauncherViewModel carViewModel5 = this.mCarViewModel;
                if (carViewModel5 == null) {
                    carViewModelJavaLangObjectNull = false;
                }
                if (carViewModelJavaLangObjectNull) {
                    carViewModel5.openShouJiHuLian(callbackArg_0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

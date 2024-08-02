package com.wits.ksw.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wits.ksw.generated.callback.OnClickListener;
import com.wits.ksw.launcher.base.BaseBindingModel;
import com.wits.ksw.launcher.model.BwmNbtModel;

public class ActivityBmwNbtBindingImpl extends ActivityBmwNbtBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback193;
    private final View.OnClickListener mCallback194;
    private final View.OnClickListener mCallback195;
    private final View.OnClickListener mCallback196;
    private final View.OnClickListener mCallback197;
    private final View.OnClickListener mCallback198;
    private final View.OnClickListener mCallback199;
    private final View.OnClickListener mCallback200;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final ImageView mboundView1;
    private final ImageView mboundView2;
    private final ImageView mboundView3;
    private final ImageView mboundView4;

    public ActivityBmwNbtBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }

    private ActivityBmwNbtBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (Button) bindings[5], (Button) bindings[11], (Button) bindings[7], (Button) bindings[6], (Button) bindings[9], (Button) bindings[10], (Button) bindings[12], (Button) bindings[8]);
        this.mDirtyFlags = -1;
        this.appLl.setTag(null);
        this.dashbroadLl.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[2];
        this.mboundView2 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[3];
        this.mboundView3 = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) bindings[4];
        this.mboundView4 = imageView4;
        imageView4.setTag(null);
        this.musicLl.setTag(null);
        this.naviLl.setTag(null);
        this.phoneLl.setTag(null);
        this.rlCar.setTag(null);
        this.rlSettings.setTag(null);
        this.videoLl.setTag(null);
        setRootTag(root);
        this.mCallback198 = new OnClickListener(this, 6);
        this.mCallback196 = new OnClickListener(this, 4);
        this.mCallback194 = new OnClickListener(this, 2);
        this.mCallback199 = new OnClickListener(this, 7);
        this.mCallback200 = new OnClickListener(this, 8);
        this.mCallback197 = new OnClickListener(this, 5);
        this.mCallback195 = new OnClickListener(this, 3);
        this.mCallback193 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
        if (33 != variableId) {
            return false;
        }
        setNbtModel((BwmNbtModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.ActivityBmwNbtBinding
    public void setNbtModel(BwmNbtModel NbtModel) {
        this.mNbtModel = NbtModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(33);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeNbtModelCircleBgId((ObservableInt) object, fieldId);
            case 1:
                return onChangeNbtModelLeftBGId((ObservableInt) object, fieldId);
            case 2:
                return onChangeNbtModelItemLogoId((ObservableInt) object, fieldId);
            case 3:
                return onChangeNbtModelIndicatorBgId((ObservableInt) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeNbtModelCircleBgId(ObservableInt NbtModelCircleBgId, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeNbtModelLeftBGId(ObservableInt NbtModelLeftBGId, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeNbtModelItemLogoId(ObservableInt NbtModelItemLogoId, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeNbtModelIndicatorBgId(ObservableInt NbtModelIndicatorBgId, int fieldId) {
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
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        BwmNbtModel nbtModel = this.mNbtModel;
        int nbtModelLeftBGIdGet = 0;
        ObservableInt nbtModelCircleBgId = null;
        ObservableInt nbtModelLeftBGId = null;
        ObservableInt nbtModelItemLogoId = null;
        int nbtModelIndicatorBgIdGet = 0;
        ObservableInt nbtModelIndicatorBgId = null;
        int nbtModelCircleBgIdGet = 0;
        int nbtModelItemLogoIdGet = 0;
        if ((63 & dirtyFlags) != 0) {
            if ((dirtyFlags & 49) != 0) {
                if (nbtModel != null) {
                    nbtModelCircleBgId = nbtModel.circleBgId;
                }
                updateRegistration(0, nbtModelCircleBgId);
                if (nbtModelCircleBgId != null) {
                    nbtModelCircleBgIdGet = nbtModelCircleBgId.get();
                }
            }
            if ((dirtyFlags & 50) != 0) {
                if (nbtModel != null) {
                    nbtModelLeftBGId = nbtModel.leftBGId;
                }
                updateRegistration(1, nbtModelLeftBGId);
                if (nbtModelLeftBGId != null) {
                    nbtModelLeftBGIdGet = nbtModelLeftBGId.get();
                }
            }
            if ((dirtyFlags & 52) != 0) {
                if (nbtModel != null) {
                    nbtModelItemLogoId = nbtModel.itemLogoId;
                }
                updateRegistration(2, nbtModelItemLogoId);
                if (nbtModelItemLogoId != null) {
                    nbtModelItemLogoIdGet = nbtModelItemLogoId.get();
                }
            }
            if ((dirtyFlags & 56) != 0) {
                if (nbtModel != null) {
                    nbtModelIndicatorBgId = nbtModel.indicatorBgId;
                }
                updateRegistration(3, nbtModelIndicatorBgId);
                if (nbtModelIndicatorBgId != null) {
                    nbtModelIndicatorBgIdGet = nbtModelIndicatorBgId.get();
                }
            }
        }
        if ((dirtyFlags & 32) != 0) {
            this.appLl.setOnClickListener(this.mCallback193);
            this.dashbroadLl.setOnClickListener(this.mCallback199);
            this.musicLl.setOnClickListener(this.mCallback195);
            this.naviLl.setOnClickListener(this.mCallback194);
            this.phoneLl.setOnClickListener(this.mCallback197);
            this.rlCar.setOnClickListener(this.mCallback198);
            this.rlSettings.setOnClickListener(this.mCallback200);
            this.videoLl.setOnClickListener(this.mCallback196);
        }
        if ((dirtyFlags & 50) != 0) {
            BaseBindingModel.srcImage(this.mboundView1, nbtModelLeftBGIdGet);
        }
        if ((dirtyFlags & 56) != 0) {
            BaseBindingModel.srcImage(this.mboundView2, nbtModelIndicatorBgIdGet);
        }
        if ((dirtyFlags & 49) != 0) {
            BaseBindingModel.srcImage(this.mboundView3, nbtModelCircleBgIdGet);
        }
        if ((52 & dirtyFlags) != 0) {
            BaseBindingModel.srcImage(this.mboundView4, nbtModelItemLogoIdGet);
        }
    }

    @Override // com.wits.ksw.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        boolean nbtModelJavaLangObjectNull = true;
        switch (sourceId) {
            case 1:
                BwmNbtModel nbtModel = this.mNbtModel;
                if (nbtModel == null) {
                    nbtModelJavaLangObjectNull = false;
                }
                if (nbtModelJavaLangObjectNull) {
                    nbtModel.onNbtClick(callbackArg_0);
                    return;
                }
                return;
            case 2:
                BwmNbtModel nbtModel2 = this.mNbtModel;
                if (nbtModel2 == null) {
                    nbtModelJavaLangObjectNull = false;
                }
                if (nbtModelJavaLangObjectNull) {
                    nbtModel2.onNbtClick(callbackArg_0);
                    return;
                }
                return;
            case 3:
                BwmNbtModel nbtModel3 = this.mNbtModel;
                if (nbtModel3 == null) {
                    nbtModelJavaLangObjectNull = false;
                }
                if (nbtModelJavaLangObjectNull) {
                    nbtModel3.onNbtClick(callbackArg_0);
                    return;
                }
                return;
            case 4:
                BwmNbtModel nbtModel4 = this.mNbtModel;
                if (nbtModel4 == null) {
                    nbtModelJavaLangObjectNull = false;
                }
                if (nbtModelJavaLangObjectNull) {
                    nbtModel4.onNbtClick(callbackArg_0);
                    return;
                }
                return;
            case 5:
                BwmNbtModel nbtModel5 = this.mNbtModel;
                if (nbtModel5 == null) {
                    nbtModelJavaLangObjectNull = false;
                }
                if (nbtModelJavaLangObjectNull) {
                    nbtModel5.onNbtClick(callbackArg_0);
                    return;
                }
                return;
            case 6:
                BwmNbtModel nbtModel6 = this.mNbtModel;
                if (nbtModel6 == null) {
                    nbtModelJavaLangObjectNull = false;
                }
                if (nbtModelJavaLangObjectNull) {
                    nbtModel6.onNbtClick(callbackArg_0);
                    return;
                }
                return;
            case 7:
                BwmNbtModel nbtModel7 = this.mNbtModel;
                if (nbtModel7 == null) {
                    nbtModelJavaLangObjectNull = false;
                }
                if (nbtModelJavaLangObjectNull) {
                    nbtModel7.onNbtClick(callbackArg_0);
                    return;
                }
                return;
            case 8:
                BwmNbtModel nbtModel8 = this.mNbtModel;
                if (nbtModel8 == null) {
                    nbtModelJavaLangObjectNull = false;
                }
                if (nbtModelJavaLangObjectNull) {
                    nbtModel8.onNbtClick(callbackArg_0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
package com.wits.ksw.databinding;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.databinding.DataBindingComponent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wits.ksw.R;
import com.wits.ksw.launcher.base.BaseBindingModel;
import com.wits.ksw.launcher.bean.CarInfo;
import com.wits.ksw.launcher.model.DashboardViewModel;
import com.wits.ksw.launcher.view.LinearGradientProgressNew;

public class BmwId8DashboardLayoutNewBindingImpl extends BmwId8DashboardLayoutNewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl1 mViewModelDashboardMusicLayAndroidViewViewOnClickListener;
    private OnClickListenerImpl mViewModelDashboardWeatherLayAndroidViewViewOnClickListener;
    private final LinearGradientProgressNew mboundView1;
    private final ImageView mboundView10;
    private final ImageView mboundView11;
    private final ImageView mboundView12;
    private final ImageView mboundView13;
    private final ImageView mboundView14;
    private final LinearGradientProgressNew mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView6;
    private final ImageView mboundView7;
    private final ImageView mboundView8;
    private final RelativeLayout mboundView9;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(20);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(15, new String[]{"bmw_id8_dashboard_music_layout", "bmw_id8_dashboard_weather_layout"}, new int[]{16, 17}, new int[]{R.layout.bmw_id8_dashboard_music_layout, R.layout.bmw_id8_dashboard_weather_layout});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bmw_id8_dashboard_left_bg, 18);
        sparseIntArray.put(R.id.bmw_id8_dashboard_right_bg, 19);
    }

    public BmwId8DashboardLayoutNewBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }

    private BmwId8DashboardLayoutNewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 15, (RelativeLayout) bindings[0], (ImageView) bindings[18], (RelativeLayout) bindings[15], (BmwId8DashboardMusicLayoutBinding) bindings[16], (ImageView) bindings[19], (BmwId8DashboardWeatherLayoutBinding) bindings[17]);
        this.mDirtyFlags = -1;
        this.bmwId8DashboardLay.setTag(null);
        this.bmwId8DashboardMidLay.setTag(null);
        setContainedBinding(this.bmwId8DashboardMusicLay);
        setContainedBinding(this.bmwId8DashboardWeatherLay);
        LinearGradientProgressNew linearGradientProgressNew = (LinearGradientProgressNew) bindings[1];
        this.mboundView1 = linearGradientProgressNew;
        linearGradientProgressNew.setTag(null);
        ImageView imageView = (ImageView) bindings[10];
        this.mboundView10 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[11];
        this.mboundView11 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[12];
        this.mboundView12 = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) bindings[13];
        this.mboundView13 = imageView4;
        imageView4.setTag(null);
        ImageView imageView5 = (ImageView) bindings[14];
        this.mboundView14 = imageView5;
        imageView5.setTag(null);
        LinearGradientProgressNew linearGradientProgressNew2 = (LinearGradientProgressNew) bindings[2];
        this.mboundView2 = linearGradientProgressNew2;
        linearGradientProgressNew2.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[4];
        this.mboundView4 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[5];
        this.mboundView5 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) bindings[6];
        this.mboundView6 = textView4;
        textView4.setTag(null);
        ImageView imageView6 = (ImageView) bindings[7];
        this.mboundView7 = imageView6;
        imageView6.setTag(null);
        ImageView imageView7 = (ImageView) bindings[8];
        this.mboundView8 = imageView7;
        imageView7.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[9];
        this.mboundView9 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // android.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        this.bmwId8DashboardMusicLay.invalidateAll();
        this.bmwId8DashboardWeatherLay.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r4.bmwId8DashboardWeatherLay.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.bmwId8DashboardMusicLay.hasPendingBindings() == false) goto L_0x0016;
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
            long r0 = r4.mDirtyFlags     // Catch:{ all -> 0x0021 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0021 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0021 }
            com.wits.ksw.databinding.BmwId8DashboardMusicLayoutBinding r0 = r4.bmwId8DashboardMusicLay
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            com.wits.ksw.databinding.BmwId8DashboardWeatherLayoutBinding r0 = r4.bmwId8DashboardWeatherLay
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r1
        L_0x001f:
            r0 = 0
            return r0
        L_0x0021:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wits.ksw.databinding.BmwId8DashboardLayoutNewBindingImpl.hasPendingBindings():boolean");
    }

    @Override // android.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (36 != variableId) {
            return false;
        }
        setViewModel((DashboardViewModel) variable);
        return true;
    }

    @Override // com.wits.ksw.databinding.BmwId8DashboardLayoutNewBinding
    public void setViewModel(DashboardViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    @Override // android.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bmwId8DashboardMusicLay.setLifecycleOwner(lifecycleOwner);
        this.bmwId8DashboardWeatherLay.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelCarInfoTurnSpeed((ObservableInt) object, fieldId);
            case 1:
                return onChangeBmwId8DashboardMusicLay((BmwId8DashboardMusicLayoutBinding) object, fieldId);
            case 2:
                return onChangeViewModelCarInfoCarImage((ObservableBoolean) object, fieldId);
            case 3:
                return onChangeViewModelCarInfoFrDoorState((ObservableField) object, fieldId);
            case 4:
                return onChangeViewModelCarInfoOilValue((ObservableField) object, fieldId);
            case 5:
                return onChangeViewModelDashBoardMusicShow((ObservableField) object, fieldId);
            case 6:
                return onChangeViewModelCarInfoRlDoorState((ObservableField) object, fieldId);
            case 7:
                return onChangeViewModelCarInfoRrDoorState((ObservableField) object, fieldId);
            case 8:
                return onChangeViewModelCarInfoSeatBeltpValue((ObservableField) object, fieldId);
            case 9:
                return onChangeViewModelCarInfoSpeedUnit((ObservableField) object, fieldId);
            case 10:
                return onChangeViewModelCarInfoFlDoorState((ObservableField) object, fieldId);
            case 11:
                return onChangeBmwId8DashboardWeatherLay((BmwId8DashboardWeatherLayoutBinding) object, fieldId);
            case 12:
                return onChangeViewModelCarInfoSpeed((ObservableInt) object, fieldId);
            case 13:
                return onChangeViewModelCarInfoBDoorState((ObservableField) object, fieldId);
            case 14:
                return onChangeViewModelCarInfoBrakeValue((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelCarInfoTurnSpeed(ObservableInt ViewModelCarInfoTurnSpeed, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeBmwId8DashboardMusicLay(BmwId8DashboardMusicLayoutBinding BmwId8DashboardMusicLay, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoCarImage(ObservableBoolean ViewModelCarInfoCarImage, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoFrDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoOilValue(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelDashBoardMusicShow(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoRlDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoRrDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoSeatBeltpValue(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoSpeedUnit(ObservableField<String> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoFlDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean onChangeBmwId8DashboardWeatherLay(BmwId8DashboardWeatherLayoutBinding BmwId8DashboardWeatherLay, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoSpeed(ObservableInt ViewModelCarInfoSpeed, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoBDoorState(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }

    private boolean onChangeViewModelCarInfoBrakeValue(ObservableField<Boolean> observableField, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        return true;
    }

    /* JADX INFO: Multiple debug info for r0v12 'viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew'  android.graphics.drawable.Drawable: [D('viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew' android.graphics.drawable.Drawable), D('viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew' android.graphics.drawable.Drawable)] */
    /* JADX INFO: Multiple debug info for r0v14 android.graphics.drawable.Drawable: [D('viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew' android.graphics.drawable.Drawable), D('viewModelCarInfoOilValueGet' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r0v16 'viewModelCarInfoSpeedUnitGet'  java.lang.String: [D('viewModelCarInfoSpeedUnitGet' java.lang.String), D('viewModelCarInfoOilValueGet' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r0v18 java.lang.String: [D('viewModelCarInfoTurnSpeedGet' int), D('viewModelCarInfoSpeedUnitGet' java.lang.String)] */
    /* JADX INFO: Multiple debug info for r0v20 'viewModelDashBoardMusicShowViewGONEViewVISIBLE'  int: [D('viewModelCarInfoTurnSpeedGet' int), D('viewModelDashBoardMusicShowViewGONEViewVISIBLE' int)] */
    /* access modifiers changed from: protected */
    @Override // android.databinding.ViewDataBinding
    public void executeBindings() {
        long dirtyFlags;
        int viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE;
        int viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE;
        View.OnClickListener viewModelDashboardWeatherLayAndroidViewViewOnClickListener;
        Drawable viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew;
        int viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE;
        int viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE;
        int viewModelDashBoardMusicShowViewVISIBLEViewGONE;
        int viewModelCarInfoTurnSpeedGet;
        Drawable viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew;
        String stringValueOfViewModelCarInfoSpeed;
        String viewModelCarInfoSpeedUnitGet;
        int viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE;
        String viewModelCarInfoOilValueGet;
        Drawable viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew2;
        Drawable viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew2;
        String viewModelCarInfoSpeedUnitGet2;
        String viewModelCarInfoOilValueGet2;
        int viewModelDashBoardMusicShowViewVISIBLEViewGONE2;
        View.OnClickListener viewModelDashboardWeatherLayAndroidViewViewOnClickListener2;
        View.OnClickListener viewModelDashboardMusicLayAndroidViewViewOnClickListener;
        int viewModelDashBoardMusicShowViewGONEViewVISIBLE;
        int viewModelCarInfoTurnSpeedGet2;
        int viewModelDashBoardMusicShowViewGONEViewVISIBLE2;
        String viewModelCarInfoSpeedUnitGet3;
        String viewModelCarInfoOilValueGet3;
        Drawable viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew3;
        Drawable viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew4;
        ObservableField<Boolean> viewModelDashBoardMusicShow;
        boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet;
        ObservableField<Boolean> viewModelCarInfoBDoorState;
        ObservableInt viewModelCarInfoTurnSpeed;
        ObservableInt viewModelCarInfoTurnSpeed2;
        boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet2;
        ObservableField<Boolean> viewModelCarInfoBDoorState2;
        ObservableField<Boolean> viewModelCarInfoBDoorState3;
        ObservableField<Boolean> viewModelCarInfoBDoorState4;
        long dirtyFlags2;
        int i;
        Context context;
        ObservableInt viewModelCarInfoSpeed;
        ObservableField<Boolean> viewModelCarInfoFlDoorState;
        ObservableField<String> viewModelCarInfoSpeedUnit;
        ObservableField<Boolean> viewModelCarInfoSeatBeltpValue;
        long dirtyFlags3;
        Drawable drawable;
        ObservableField<Boolean> viewModelCarInfoRrDoorState;
        ObservableField<Boolean> viewModelCarInfoRlDoorState;
        ObservableField<String> viewModelCarInfoOilValue;
        ObservableField<Boolean> viewModelCarInfoFrDoorState;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Boolean viewModelCarInfoBDoorStateGet = null;
        int viewModelCarInfoSpeedGet = 0;
        int viewModelCarInfoBDoorStateViewVISIBLEViewINVISIBLE = 0;
        ObservableBoolean viewModelCarInfoCarImage = null;
        boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRlDoorStateGet = false;
        boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRrDoorStateGet = false;
        String viewModelCarInfoOilValueGet4 = null;
        Boolean viewModelCarInfoSeatBeltpValueGet = null;
        Boolean viewModelCarInfoRlDoorStateGet = null;
        int viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE2 = 0;
        String viewModelCarInfoSpeedUnitGet4 = null;
        String stringValueOfViewModelCarInfoSpeed2 = null;
        Boolean viewModelCarInfoRrDoorStateGet = null;
        int viewModelCarInfoTurnSpeedGet3 = 0;
        View.OnClickListener viewModelDashboardMusicLayAndroidViewViewOnClickListener2 = null;
        Boolean viewModelCarInfoFlDoorStateGet = null;
        Boolean viewModelCarInfoBrakeValueGet = null;
        int viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE2 = 0;
        int viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE2 = 0;
        int viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2 = 0;
        boolean viewModelCarInfoCarImageGet = false;
        Boolean viewModelCarInfoFrDoorStateGet = null;
        Drawable viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew5 = null;
        Boolean viewModelDashBoardMusicShowGet = null;
        int viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2 = 0;
        DashboardViewModel viewModel = this.mViewModel;
        if ((dirtyFlags & 96221) != 0) {
            CarInfo viewModelCarInfo = DashboardViewModel.carInfo;
            if ((dirtyFlags & 65537) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoBDoorState = null;
                    viewModelCarInfoTurnSpeed = viewModelCarInfo.turnSpeed;
                } else {
                    viewModelCarInfoBDoorState = null;
                    viewModelCarInfoTurnSpeed = null;
                }
                androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet = false;
                updateRegistration(0, viewModelCarInfoTurnSpeed);
                if (viewModelCarInfoTurnSpeed != null) {
                    viewModelCarInfoTurnSpeedGet3 = viewModelCarInfoTurnSpeed.get();
                }
            } else {
                viewModelCarInfoBDoorState = null;
                androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet = false;
                viewModelCarInfoTurnSpeed = null;
            }
            if ((dirtyFlags & 65540) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoCarImage = viewModelCarInfo.carImage;
                }
                updateRegistration(2, viewModelCarInfoCarImage);
                if (viewModelCarInfoCarImage != null) {
                    viewModelCarInfoCarImageGet = viewModelCarInfoCarImage.get();
                }
                if ((dirtyFlags & 65540) != 0) {
                    if (viewModelCarInfoCarImageGet) {
                        dirtyFlags |= 68719476736L;
                    } else {
                        dirtyFlags |= 34359738368L;
                    }
                }
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2 = viewModelCarInfoCarImageGet ? 0 : 4;
            }
            if ((dirtyFlags & 65544) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoFrDoorState = viewModelCarInfo.frDoorState;
                } else {
                    viewModelCarInfoFrDoorState = null;
                }
                viewModelCarInfoTurnSpeed2 = viewModelCarInfoTurnSpeed;
                updateRegistration(3, viewModelCarInfoFrDoorState);
                if (viewModelCarInfoFrDoorState != null) {
                    viewModelCarInfoFrDoorStateGet = viewModelCarInfoFrDoorState.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFrDoorStateGet = ViewDataBinding.safeUnbox(viewModelCarInfoFrDoorStateGet);
                if ((dirtyFlags & 65544) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFrDoorStateGet) {
                        dirtyFlags |= 4294967296L;
                    } else {
                        dirtyFlags |= 2147483648L;
                    }
                }
                viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFrDoorStateGet ? 0 : 4;
            } else {
                viewModelCarInfoTurnSpeed2 = viewModelCarInfoTurnSpeed;
            }
            if ((dirtyFlags & 65552) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoOilValue = viewModelCarInfo.oilValue;
                } else {
                    viewModelCarInfoOilValue = null;
                }
                updateRegistration(4, viewModelCarInfoOilValue);
                if (viewModelCarInfoOilValue != null) {
                    viewModelCarInfoOilValueGet4 = viewModelCarInfoOilValue.get();
                }
            }
            if ((dirtyFlags & 65600) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoRlDoorState = viewModelCarInfo.rlDoorState;
                } else {
                    viewModelCarInfoRlDoorState = null;
                }
                updateRegistration(6, viewModelCarInfoRlDoorState);
                if (viewModelCarInfoRlDoorState != null) {
                    viewModelCarInfoRlDoorStateGet = viewModelCarInfoRlDoorState.get();
                }
                androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRlDoorStateGet = ViewDataBinding.safeUnbox(viewModelCarInfoRlDoorStateGet);
                if ((dirtyFlags & 65600) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRlDoorStateGet) {
                        dirtyFlags |= 268435456;
                    } else {
                        dirtyFlags |= 134217728;
                    }
                }
                viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE2 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRlDoorStateGet ? 0 : 4;
            }
            if ((dirtyFlags & 65664) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoRrDoorState = viewModelCarInfo.rrDoorState;
                } else {
                    viewModelCarInfoRrDoorState = null;
                }
                updateRegistration(7, viewModelCarInfoRrDoorState);
                if (viewModelCarInfoRrDoorState != null) {
                    viewModelCarInfoRrDoorStateGet = viewModelCarInfoRrDoorState.get();
                }
                androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRrDoorStateGet = ViewDataBinding.safeUnbox(viewModelCarInfoRrDoorStateGet);
                if ((dirtyFlags & 65664) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRrDoorStateGet) {
                        dirtyFlags |= 4194304;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    }
                }
                viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE2 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoRrDoorStateGet ? 0 : 4;
            }
            if ((dirtyFlags & 65792) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoSeatBeltpValue = viewModelCarInfo.seatBeltpValue;
                } else {
                    viewModelCarInfoSeatBeltpValue = null;
                }
                updateRegistration(8, viewModelCarInfoSeatBeltpValue);
                if (viewModelCarInfoSeatBeltpValue != null) {
                    viewModelCarInfoSeatBeltpValueGet = viewModelCarInfoSeatBeltpValue.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoSeatBeltpValueGet = ViewDataBinding.safeUnbox(viewModelCarInfoSeatBeltpValueGet);
                if ((dirtyFlags & 65792) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoSeatBeltpValueGet) {
                        dirtyFlags |= 17179869184L;
                    } else {
                        dirtyFlags |= 8589934592L;
                    }
                }
                if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoSeatBeltpValueGet) {
                    dirtyFlags3 = dirtyFlags;
                    drawable = AppCompatResources.getDrawable(this.mboundView7.getContext(), R.drawable.id8_dashboard_icon_seatbelt_new);
                } else {
                    dirtyFlags3 = dirtyFlags;
                    drawable = AppCompatResources.getDrawable(this.mboundView7.getContext(), R.drawable.id8_dashboard_icon_seatbelt_f_new);
                }
                viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew5 = drawable;
                dirtyFlags = dirtyFlags3;
            }
            if ((dirtyFlags & 66048) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoSpeedUnit = viewModelCarInfo.speedUnit;
                } else {
                    viewModelCarInfoSpeedUnit = null;
                }
                updateRegistration(9, viewModelCarInfoSpeedUnit);
                if (viewModelCarInfoSpeedUnit != null) {
                    viewModelCarInfoSpeedUnitGet4 = viewModelCarInfoSpeedUnit.get();
                }
            }
            if ((dirtyFlags & 66560) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoFlDoorState = viewModelCarInfo.flDoorState;
                } else {
                    viewModelCarInfoFlDoorState = null;
                }
                updateRegistration(10, viewModelCarInfoFlDoorState);
                if (viewModelCarInfoFlDoorState != null) {
                    viewModelCarInfoFlDoorStateGet = viewModelCarInfoFlDoorState.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFlDoorStateGet = ViewDataBinding.safeUnbox(viewModelCarInfoFlDoorStateGet);
                if ((dirtyFlags & 66560) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFlDoorStateGet) {
                        dirtyFlags |= 1073741824;
                    } else {
                        dirtyFlags |= 536870912;
                    }
                }
                viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE2 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoFlDoorStateGet ? 0 : 4;
            }
            if ((dirtyFlags & 69632) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoSpeed = viewModelCarInfo.speed;
                } else {
                    viewModelCarInfoSpeed = null;
                }
                updateRegistration(12, viewModelCarInfoSpeed);
                if (viewModelCarInfoSpeed != null) {
                    viewModelCarInfoSpeedGet = viewModelCarInfoSpeed.get();
                }
                stringValueOfViewModelCarInfoSpeed2 = String.valueOf(viewModelCarInfoSpeedGet);
            }
            if ((dirtyFlags & 73728) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoBDoorState2 = viewModelCarInfo.bDoorState;
                } else {
                    viewModelCarInfoBDoorState2 = viewModelCarInfoBDoorState;
                }
                updateRegistration(13, viewModelCarInfoBDoorState2);
                if (viewModelCarInfoBDoorState2 != null) {
                    viewModelCarInfoBDoorStateGet = viewModelCarInfoBDoorState2.get();
                }
                androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet2 = ViewDataBinding.safeUnbox(viewModelCarInfoBDoorStateGet);
                if ((dirtyFlags & 73728) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet2) {
                        dirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    } else {
                        dirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                    }
                }
                viewModelCarInfoBDoorStateViewVISIBLEViewINVISIBLE = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet2 ? 0 : 4;
            } else {
                viewModelCarInfoBDoorState2 = viewModelCarInfoBDoorState;
                androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet2 = androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBDoorStateGet;
            }
            if ((dirtyFlags & 81920) != 0) {
                if (viewModelCarInfo != null) {
                    viewModelCarInfoBDoorState3 = viewModelCarInfoBDoorState2;
                    viewModelCarInfoBDoorState4 = viewModelCarInfo.brakeValue;
                } else {
                    viewModelCarInfoBDoorState3 = viewModelCarInfoBDoorState2;
                    viewModelCarInfoBDoorState4 = null;
                }
                updateRegistration(14, viewModelCarInfoBDoorState4);
                if (viewModelCarInfoBDoorState4 != null) {
                    viewModelCarInfoBrakeValueGet = viewModelCarInfoBDoorState4.get();
                }
                boolean androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBrakeValueGet = ViewDataBinding.safeUnbox(viewModelCarInfoBrakeValueGet);
                if ((dirtyFlags & 81920) != 0) {
                    if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBrakeValueGet) {
                        dirtyFlags |= 16777216;
                    } else {
                        dirtyFlags |= 8388608;
                    }
                }
                if (androidDatabindingViewDataBindingSafeUnboxViewModelCarInfoBrakeValueGet) {
                    context = this.mboundView8.getContext();
                    dirtyFlags2 = dirtyFlags;
                    i = R.drawable.id8_dashboard_icon_brake_f_new;
                } else {
                    dirtyFlags2 = dirtyFlags;
                    context = this.mboundView8.getContext();
                    i = R.drawable.id8_dashboard_icon_brake_new;
                }
                Drawable viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew3 = AppCompatResources.getDrawable(context, i);
                viewModelCarInfoOilValueGet = viewModelCarInfoOilValueGet4;
                viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE = viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2;
                dirtyFlags = dirtyFlags2;
                viewModelCarInfoSpeedUnitGet = viewModelCarInfoSpeedUnitGet4;
                stringValueOfViewModelCarInfoSpeed = stringValueOfViewModelCarInfoSpeed2;
                viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew = viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew3;
                viewModelDashboardWeatherLayAndroidViewViewOnClickListener = null;
                viewModelCarInfoTurnSpeedGet = viewModelCarInfoTurnSpeedGet3;
                viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE = 0;
                viewModelDashBoardMusicShowViewVISIBLEViewGONE = viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew = viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew5;
            } else {
                viewModelCarInfoOilValueGet = viewModelCarInfoOilValueGet4;
                viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE = viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE2;
                viewModelCarInfoSpeedUnitGet = viewModelCarInfoSpeedUnitGet4;
                stringValueOfViewModelCarInfoSpeed = stringValueOfViewModelCarInfoSpeed2;
                viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew = null;
                viewModelDashboardWeatherLayAndroidViewViewOnClickListener = null;
                viewModelCarInfoTurnSpeedGet = viewModelCarInfoTurnSpeedGet3;
                viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE = 0;
                viewModelDashBoardMusicShowViewVISIBLEViewGONE = viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE = viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE2;
                viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew = viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew5;
            }
        } else {
            viewModelCarInfoOilValueGet = null;
            viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE = 0;
            viewModelCarInfoSpeedUnitGet = null;
            viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE = 0;
            stringValueOfViewModelCarInfoSpeed = null;
            viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew = null;
            viewModelDashboardWeatherLayAndroidViewViewOnClickListener = null;
            viewModelCarInfoTurnSpeedGet = 0;
            viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE = 0;
            viewModelDashBoardMusicShowViewVISIBLEViewGONE = 0;
            viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE = 0;
            viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE = 0;
            viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew = null;
        }
        if ((dirtyFlags & 98336) != 0) {
            if ((dirtyFlags & 98304) == 0) {
                viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew2 = viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew;
            } else if (viewModel != null) {
                viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew2 = viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew;
                OnClickListenerImpl onClickListenerImpl = this.mViewModelDashboardWeatherLayAndroidViewViewOnClickListener;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.mViewModelDashboardWeatherLayAndroidViewViewOnClickListener = onClickListenerImpl;
                }
                viewModelDashboardWeatherLayAndroidViewViewOnClickListener = onClickListenerImpl.setValue(viewModel);
                OnClickListenerImpl1 onClickListenerImpl1 = this.mViewModelDashboardMusicLayAndroidViewViewOnClickListener;
                if (onClickListenerImpl1 == null) {
                    onClickListenerImpl1 = new OnClickListenerImpl1();
                    this.mViewModelDashboardMusicLayAndroidViewViewOnClickListener = onClickListenerImpl1;
                }
                viewModelDashboardMusicLayAndroidViewViewOnClickListener2 = onClickListenerImpl1.setValue(viewModel);
            } else {
                viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew2 = viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew;
            }
            if (viewModel != null) {
                viewModelDashBoardMusicShow = viewModel.dashBoardMusicShow;
            } else {
                viewModelDashBoardMusicShow = null;
            }
            viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew2 = viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew;
            updateRegistration(5, viewModelDashBoardMusicShow);
            if (viewModelDashBoardMusicShow != null) {
                viewModelDashBoardMusicShowGet = viewModelDashBoardMusicShow.get();
            }
            boolean androidDatabindingViewDataBindingSafeUnboxViewModelDashBoardMusicShowGet = ViewDataBinding.safeUnbox(viewModelDashBoardMusicShowGet);
            if ((dirtyFlags & 98336) != 0) {
                if (androidDatabindingViewDataBindingSafeUnboxViewModelDashBoardMusicShowGet) {
                    dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED | 67108864;
                } else {
                    dirtyFlags = dirtyFlags | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED | 33554432;
                }
            }
            viewModelDashBoardMusicShowViewVISIBLEViewGONE2 = androidDatabindingViewDataBindingSafeUnboxViewModelDashBoardMusicShowGet ? 0 : 8;
            viewModelDashboardWeatherLayAndroidViewViewOnClickListener2 = viewModelDashboardWeatherLayAndroidViewViewOnClickListener;
            viewModelCarInfoOilValueGet2 = viewModelCarInfoOilValueGet;
            viewModelDashBoardMusicShowViewGONEViewVISIBLE = androidDatabindingViewDataBindingSafeUnboxViewModelDashBoardMusicShowGet ? 8 : 0;
            viewModelCarInfoSpeedUnitGet2 = viewModelCarInfoSpeedUnitGet;
            viewModelDashboardMusicLayAndroidViewViewOnClickListener = viewModelDashboardMusicLayAndroidViewViewOnClickListener2;
        } else {
            viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew2 = viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew;
            viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew2 = viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew;
            viewModelDashboardWeatherLayAndroidViewViewOnClickListener2 = viewModelDashboardWeatherLayAndroidViewViewOnClickListener;
            viewModelDashBoardMusicShowViewVISIBLEViewGONE2 = viewModelCarInfoRlDoorStateViewVISIBLEViewINVISIBLE;
            viewModelCarInfoOilValueGet2 = viewModelCarInfoOilValueGet;
            viewModelDashBoardMusicShowViewGONEViewVISIBLE = 0;
            viewModelCarInfoSpeedUnitGet2 = viewModelCarInfoSpeedUnitGet;
            viewModelDashboardMusicLayAndroidViewViewOnClickListener = null;
        }
        if ((dirtyFlags & 98304) != 0) {
            viewModelCarInfoTurnSpeedGet2 = viewModelCarInfoTurnSpeedGet;
            this.bmwId8DashboardMusicLay.getRoot().setOnClickListener(viewModelDashboardMusicLayAndroidViewViewOnClickListener);
            this.bmwId8DashboardMusicLay.setViewModel(viewModel);
            this.bmwId8DashboardWeatherLay.getRoot().setOnClickListener(viewModelDashboardWeatherLayAndroidViewViewOnClickListener2);
            this.bmwId8DashboardWeatherLay.setViewModel(viewModel);
        } else {
            viewModelCarInfoTurnSpeedGet2 = viewModelCarInfoTurnSpeedGet;
        }
        if ((dirtyFlags & 98336) != 0) {
            this.bmwId8DashboardMusicLay.getRoot().setVisibility(viewModelDashBoardMusicShowViewVISIBLEViewGONE2);
            this.bmwId8DashboardWeatherLay.getRoot().setVisibility(viewModelDashBoardMusicShowViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 69632) != 0) {
            this.mboundView1.setScae(viewModelCarInfoSpeedGet);
            TextViewBindingAdapter.setText(this.mboundView3, stringValueOfViewModelCarInfoSpeed);
        }
        if ((dirtyFlags & 65544) != 0) {
            this.mboundView10.setVisibility(viewModelCarInfoFrDoorStateViewVISIBLEViewINVISIBLE);
        }
        if ((dirtyFlags & 65664) != 0) {
            this.mboundView11.setVisibility(viewModelCarInfoRrDoorStateViewVISIBLEViewINVISIBLE);
        }
        if ((dirtyFlags & 66560) != 0) {
            this.mboundView12.setVisibility(viewModelCarInfoFlDoorStateViewVISIBLEViewINVISIBLE);
        }
        if ((dirtyFlags & 65600) != 0) {
            this.mboundView13.setVisibility(viewModelDashBoardMusicShowViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 73728) != 0) {
            this.mboundView14.setVisibility(viewModelCarInfoBDoorStateViewVISIBLEViewINVISIBLE);
        }
        if ((dirtyFlags & 65537) != 0) {
            viewModelDashBoardMusicShowViewGONEViewVISIBLE2 = viewModelCarInfoTurnSpeedGet2;
            this.mboundView2.setScae(viewModelDashBoardMusicShowViewGONEViewVISIBLE2);
            BaseBindingModel.setTurnSpeedStr(this.mboundView5, viewModelDashBoardMusicShowViewGONEViewVISIBLE2);
        } else {
            viewModelDashBoardMusicShowViewGONEViewVISIBLE2 = viewModelCarInfoTurnSpeedGet2;
        }
        if ((dirtyFlags & 66048) != 0) {
            viewModelCarInfoSpeedUnitGet3 = viewModelCarInfoSpeedUnitGet2;
            TextViewBindingAdapter.setText(this.mboundView4, viewModelCarInfoSpeedUnitGet3);
        } else {
            viewModelCarInfoSpeedUnitGet3 = viewModelCarInfoSpeedUnitGet2;
        }
        if ((dirtyFlags & 65552) != 0) {
            viewModelCarInfoOilValueGet3 = viewModelCarInfoOilValueGet2;
            TextViewBindingAdapter.setText(this.mboundView6, viewModelCarInfoOilValueGet3);
        } else {
            viewModelCarInfoOilValueGet3 = viewModelCarInfoOilValueGet2;
        }
        if ((dirtyFlags & 65792) != 0) {
            viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew3 = viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew2;
            ImageViewBindingAdapter.setImageDrawable(this.mboundView7, viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew3);
        } else {
            viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew3 = viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew2;
        }
        if ((dirtyFlags & 81920) != 0) {
            viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew4 = viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew2;
            ImageViewBindingAdapter.setImageDrawable(this.mboundView8, viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew4);
        } else {
            viewModelCarInfoSeatBeltpValueMboundView7AndroidDrawableId8DashboardIconSeatbeltNewMboundView7AndroidDrawableId8DashboardIconSeatbeltFNew4 = viewModelCarInfoBrakeValueMboundView8AndroidDrawableId8DashboardIconBrakeFNewMboundView8AndroidDrawableId8DashboardIconBrakeNew2;
        }
        if ((dirtyFlags & 65540) != 0) {
            this.mboundView9.setVisibility(viewModelCarInfoCarImageViewVISIBLEViewINVISIBLE);
        }
        executeBindingsOn(this.bmwId8DashboardMusicLay);
        executeBindingsOn(this.bmwId8DashboardWeatherLay);
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private DashboardViewModel value;

        public OnClickListenerImpl setValue(DashboardViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.dashboardWeatherLay(arg0);
        }
    }

    public static class OnClickListenerImpl1 implements View.OnClickListener {
        private DashboardViewModel value;

        public OnClickListenerImpl1 setValue(DashboardViewModel value2) {
            this.value = value2;
            if (value2 == null) {
                return null;
            }
            return this;
        }

        public void onClick(View arg0) {
            this.value.dashboardMusicLay(arg0);
        }
    }
}
